package com.example.k_moocclassinfoapp.acitivities.activities.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.k_moocclassinfoapp.acitivities.model.Lecture
import java.util.*

class LectureAdapter : ListAdapter<Lecture, LectureAdapter.LectureViewHolder>(diffUtill) {

    private val lectures = mutableListOf<Lecture>()

    // 목록 업데이트
    fun updataLectures(lectures: List<Lecture>) {
        this.lectures.clear()
        this.lectures.addAll(lectures)
        notifyDataSetChanged()

    }

    inner class LectureViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind() {

        }

    }

    companion object {
        val diffUtill = object : DiffUtil.ItemCallback<Lecture>() {
            override fun areItemsTheSame(oldItem: Lecture, newItem: Lecture): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Lecture, newItem: Lecture): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureAdapter.LectureViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: LectureAdapter.LectureViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}