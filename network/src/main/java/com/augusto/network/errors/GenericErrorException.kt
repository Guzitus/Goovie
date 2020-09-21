package com.augusto.network.errors

import java.lang.Exception

data class GenericErrorException(val code: Int, val msg: String) : Exception(msg)