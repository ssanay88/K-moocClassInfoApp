package com.example.k_moocclassinfoapp.acitivities.viewmodels

import android.text.BoringLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.k_moocclassinfoapp.acitivities.model.LectureList
import com.example.k_moocclassinfoapp.acitivities.repositories.Repository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: Repository) : ViewModel() {

    var progressVisible = MutableLiveData<Boolean>()
    private val _lectureList = MutableLiveData<LectureList>()

    val lectureList : LiveData<LectureList>
        get() = _lectureList

    fun list() {
        progressVisible.postValue(true)    // 새로 고침 progressBar 등장
        viewModelScope.launch {
            _lectureList.postValue()
        }


    }




}