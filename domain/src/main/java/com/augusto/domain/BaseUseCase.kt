package com.augusto.domain

interface BaseUseCase<Params, R> {
    suspend fun execute(params: Params): R
}
