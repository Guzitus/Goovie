package com.augusto.network.errors

import java.lang.Exception

data class ServerException(val code: Int, val msg: String) : Exception(msg)