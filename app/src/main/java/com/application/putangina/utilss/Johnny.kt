package com.application.putangina.utilss

import android.Manifest

class Johnny {
    companion object{
        val PERMISSIONS = arrayListOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }
}