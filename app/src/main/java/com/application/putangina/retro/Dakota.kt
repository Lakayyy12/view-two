package com.application.putangina.retro

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class Dakota {

    private val service: CoryChase = Lexi.service()

    suspend fun getJumpCodeUrl(param: Aaliyah): Flow<Emily> = callbackFlow {
        trySend(service.getJumpCode(param))
        awaitClose()
    }

}