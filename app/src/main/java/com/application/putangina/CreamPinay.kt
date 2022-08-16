package com.application.putangina

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.application.putangina.retro.Emily
import com.application.putangina.retro.Dakota
import com.application.putangina.retro.Aaliyah
import com.application.putangina.utilss.Jordi

class CreamPinay: ViewModel() {

    private val repo = Dakota()

    private val _urlResponse = MutableLiveData<Jordi<Emily>>()
    val urlResponse : LiveData<Jordi<Emily>>
        get() = _urlResponse

    fun getJumpUrl(packageName: String){
        val param = Aaliyah(
            packageName
        )
        viewModelScope.launch {
            repo.getJumpCodeUrl(param)
                .catch { err -> _urlResponse.value = Jordi.Error(err) }
                .collectLatest {
                    _urlResponse.value = Jordi.Success(it)
                }
        }
    }
}