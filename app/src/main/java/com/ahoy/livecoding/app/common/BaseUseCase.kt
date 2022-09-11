package com.ahoy.livecoding.app.common

interface BaseUseCase<Input, Output> {
    suspend fun execute(input: Input): Output
}