package br.com.ohashi.commanduser

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CommandUserApplication

fun main(args: Array<String>) {
    runApplication<CommandUserApplication>(*args)
}
