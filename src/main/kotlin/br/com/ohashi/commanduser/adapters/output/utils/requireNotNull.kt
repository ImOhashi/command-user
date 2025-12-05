package br.com.ohashi.commanduser.adapters.output.utils

fun requireNotNull(value: String?, lazyMessage: () -> String): String {
    if (value.isNullOrBlank()) {
        throw IllegalArgumentException(lazyMessage())
    }

    return value
}