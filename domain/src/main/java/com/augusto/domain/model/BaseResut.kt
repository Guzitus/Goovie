package com.augusto.domain.model

data class BaseResult<T>(
    val status: String,
    val copyright: String,
    val has_more: String,
    val num_results: String,
    val results: List<T>
)