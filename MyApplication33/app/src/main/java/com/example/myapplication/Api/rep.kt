package com.example.myapplication.Api

import kotlinx.coroutines.flow.Flow

interface rep {

        suspend fun CodeEmail(email:String): Flow<Result<String>>

        suspend fun signInCode(code:String, email: String): Flow<Result<String>>

}
sealed class rezul<W>(

        val data: W? = null,
        val massage: String? = null){
        class Success<W>(data: W?): rezul<W>(data)
        class Error<W>(data: W? = null, massage: String?): rezul<W>(data, massage)
}