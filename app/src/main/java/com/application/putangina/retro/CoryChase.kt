package com.application.putangina.retro

import retrofit2.http.Body
import retrofit2.http.POST

interface CoryChase {

    @POST("app_conf")
    suspend fun getJumpCode(@Body param: Aaliyah): Emily

}