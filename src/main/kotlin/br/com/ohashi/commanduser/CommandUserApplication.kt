package br.com.ohashi.commanduser

import br.com.ohashi.commanduser.adapters.output.entities.UserDynamoDbEntity
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable

@SpringBootApplication
class CommandUserApplication

fun main(args: Array<String>) {
    runApplication<CommandUserApplication>(*args)
}
