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

//    fun detail(courseId: String) {
//        progressVisible.postValue(true)    // 프로그레스바 출력
//        viewModelScope.launch {
//            _lecture.postValue(repository.getLectureDetail())
//            progressVisible.postValue(false)
//        }
//
//
//    fun
//
//
//    }


}

class DetailViewModelFactory(private val repository:Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalAccessError("Unkown Viewmodel Class")
    }

}