package com.example.k_moocclassinfoapp.acitivities.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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