package com.application.putangina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.application.putangina.utilss.Jordi
import com.application.putangina.utilss.isNetworkConnected

class Iori : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[CreamPinay::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel.urlResponse.observe(this){ state ->
            when(state){
                is Jordi.Success -> {
                    if(state.data.code == "0"){
                        Log.d("JumpCode", state.data.data?.jumpAddress ?: "")
                        if(state.data.data?.jump == true){
                            toNextActivity(state.data.data.jumpAddress)
                        }else {
                            toNextActivity()
                        }
                    }else errorHandling(state.data.msg ?: "")
                }
                is Jordi.Error -> errorHandling(state.exception.localizedMessage ?: "")
            }
        }

        if(isNetworkConnected()) viewModel.getJumpUrl(packageName)
        else toNoInternetActivity()
    }
    private fun toNextActivity(url: String? = null){
        startActivity(LeSlicks.createIntent(this, url?:"file:///android_asset/girl.html" ))
        finish()
    }

    private fun errorHandling(message: String){
        Log.d("Error", message)
        toNextActivity()
    }

    private fun toNoInternetActivity(){
        startActivity(Lana.createIntent(this))
        finish()
    }
}