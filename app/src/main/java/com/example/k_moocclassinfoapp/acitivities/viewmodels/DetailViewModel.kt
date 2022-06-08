package com.example.k_moocclassinfoapp.acitivities.viewmodels

import androidx.lifecycle.*
import com.example.k_moocclassinfoapp.acitivities.model.Lecture
import com.example.k_moocclassinfoapp.acitivities.repositories.Repository
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel()  {

    // LiveData로 선언
    var progressVisible = MutableLiveData<Boolean>()
    private val _lecture = MutableLiveData<Lecture>()

    val lecture : LiveData<Lecture>
        get() = _lecture

    fun detail(courseId: String) {
        progressVisible.postValue(true)    // 프로그레스바 출력
        viewModelScope.launch {
            _lecture.postValue(repository.getLectureList())
            progressVisible.postValue(false)
        }


    }


}

class DetailViewModelFactory(private val repository:) : ViewModelProvider.Factory {

    override fun <T : ViewModel>

}