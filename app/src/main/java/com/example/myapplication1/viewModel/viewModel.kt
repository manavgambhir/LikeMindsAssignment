package com.example.myapplication1.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapplication1.model.HarryResponse
import com.example.myapplication1.model.ResponseItem
import com.example.myapplication1.repos.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class harryViewModel:ViewModel() {
    val harryList = MutableLiveData<List<ResponseItem>?>()

//    private val list = arrayListOf<CryptoCurrencyListItem>()


    fun getResponse(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = withContext(Dispatchers.Main){ repository.getData() }
            if(response.isSuccessful){
                val harryData = response.body()!!.response?.filterNotNull()
//                Log.d("LIST",marketData.toString())
                response.body().let {
                    if (it != null) {
                        harryList.postValue(harryData)
                    }
                }
            }
        }

    }
}