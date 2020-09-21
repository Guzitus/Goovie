package com.augusto.network

import com.augusto.network.errors.BadRequestException
import com.augusto.network.errors.GenericErrorException
import com.augusto.network.errors.ServerException
import retrofit2.Response

object NetworkRequester {

    suspend fun <S> request(api: suspend () -> Response<S>): S? {
        return try {
            val response: Response<S> = api()
            if (response.isSuccessful)
                response.body()
            else
                throw when (response.code()) {
                    400 -> {
                        BadRequestException(response.code(), response.message())
                    }
                    500 -> {
                        ServerException(response.code(), response.message())
                    }
                    else -> {
                        GenericErrorException(response.code(), response.message())
                    }
                }
        } catch (error: Exception) {
            throw GenericErrorException(-1, error.message ?: "Não foi possível realizar a chamada! ")
        }
    }

}