package com.example.k_moocclassinfoapp.acitivities.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.k_moocclassinfoapp.acitivities.model.Lecture

class DetailViewModel() : ViewModel()  {

    // LiveData로 선언
    var progressVisible = MutableLiveData<Boolean>()
    val lecture = MutableLiveData<Lecture>()

    fun detail(courseId: String) {
        progressVisible.postValue(true)    // 프로그레스바 출력
    }


}

class DetailViewModelFactory(private val repository:) : ViewModelProvider.Factory {

    override fun <T : ViewModel>

}