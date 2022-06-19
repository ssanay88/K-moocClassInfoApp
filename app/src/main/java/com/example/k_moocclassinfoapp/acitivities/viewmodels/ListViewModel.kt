package com.example.k_moocclassinfoapp.acitivities.viewmodels

import androidx.lifecycle.*
import com.example.k_moocclassinfoapp.acitivities.DTO.LectureList
import com.example.k_moocclassinfoapp.acitivities.repositories.Repository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: Repository) : ViewModel() {

    var progressVisible = MutableLiveData<Boolean>()
    private val _lectureList = MutableLiveData<LectureList>()

    val lectureList : LiveData<LectureList>
        get() = _lectureList

    // 리사이클러뷰에 강의 목록을 추가해준다.
    fun list() {
        progressVisible.postValue(true)    // 새로 고침 progressBar 등장
        viewModelScope.launch {
            repository.list() {
                _lectureList.postValue(it)
                progressVisible.postValue(false)
            }
        }

    }

    fun next() {
        progressVisible.postValue(true)
        val currentLectureList = this.lectureList.value ?: return
        // 다음 강의들을 불러오는 메서드
        repository.next(currentLectureList) { lectureList ->
            val currentLectures = currentLectureList.Lectures
            val mergedLectures = currentLectures.toMutableList().apply {
                addAll(lectureList.Lectures)
            }
            lectureList.Lectures = mergedLectures
            _lectureList.postValue(lectureList)
            progressVisible.postValue(false)

        }
    }


}

// ViewModelProvider.Factory를 확장
// 오버라이드하여 create 함수를 받는다.
class ListViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // modelClass에 ViewModel이 상속이 되었나?
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            // 맞다면 ViewModel의 인자값을 넘겨준다.
            return ListViewModel(repository) as T
        }
        // 상속이 되어 있지 않다면 IllegalAccessError를 통해 상속이 되지 않았다는 에러 표시
        throw IllegalAccessError("Unkown ViewModel Class")
    }

}