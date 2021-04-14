package com.example.mycompose.case5

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycompose.case2.Contact

class MvvmViewModel : ViewModel() {

    private val _contact =
        MutableLiveData(
            Contact(
                "zhongliuwang",
                "1662086666",
                "123456@qq.com",
                Color(0xFF063142)
            )
        )
    val contact = _contact.value

    fun onChangeName(userName: String) {

    }

}