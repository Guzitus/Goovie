package com.augusto.network.errors

import java.lang.Exception

data class BadRequestException(val code: Int, val msg: String) : Exception(msg)