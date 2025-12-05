package br.com.ohashi.commanduser.adapters.output.entities

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey

@DynamoDbBean
data class UserDynamoDbEntity(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("cpf")
    val cpf: String
) {
    companion object {
        private var cpf: String? = null

        fun cpf(cpf: String) = apply { this.cpf = cpf }

        fun build(): UserDynamoDbEntity = UserDynamoDbEntity(
            cpf = requireNotNull(cpf) { "Cpf value is required." }
        )
    }
}
