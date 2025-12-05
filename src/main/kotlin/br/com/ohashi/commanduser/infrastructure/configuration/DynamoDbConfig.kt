package br.com.ohashi.commanduser.infrastructure.configuration

import br.com.ohashi.commanduser.adapters.output.entities.UserDynamoDbEntity
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI

@Configuration
class DynamoDbConfig(
    @Value("\${aws.dynamodb.url}") private val dynamoDbUrl: String,
    @Value("\${aws.dynamodb.schemas.user.table-name}") private val userTableName: String,
) {

    @Bean
    fun dynamoDbClient(): DynamoDbClient = DynamoDbClient
        .builder()
        .endpointOverride(URI.create(dynamoDbUrl))
        .httpClient(UrlConnectionHttpClient.builder().build())
        .build()

    @Bean
    fun dynamoDbEnhancedClient(dynamoDbClient: DynamoDbClient): DynamoDbEnhancedClient = DynamoDbEnhancedClient
        .builder()
        .dynamoDbClient(dynamoDbClient)
        .build()

    @Bean
    fun dynamoDbUserTableNameConfiguration(
        dynamoDbEnhancedClient: DynamoDbEnhancedClient
    ): DynamoDbTable<UserDynamoDbEntity> = dynamoDbEnhancedClient.table(
        userTableName,
        TableSchema.fromImmutableClass(
            UserDynamoDbEntity::class.java
        )
    )
}