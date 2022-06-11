package com.example.k_moocclassinfoapp.acitivities.activities.list

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.k_moocclassinfoapp.acitivities.LectureApplication
import com.example.k_moocclassinfoapp.acitivities.repositories.Repository
import com.example.k_moocclassinfoapp.acitivities.viewmodels.ListViewModel
import com.example.k_moocclassinfoapp.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = (application as LectureApplication).repository
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        val lectureAdapter = LectureAdapter()

        binding.lectureRv.adapter = lectureAdapter

        viewModel.lectureList.observe(this) {
            lectureAdapter.updataLectures(it.Lectures)
            binding.pullToRefreshLayout.isRefreshing = false
        }

        binding.pullToRefreshLayout.setOnRefreshListener {
            viewModel.list()
        }

        binding.lectureRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = binding.lectureRv.layoutManager

                if (viewModel.progressVisible.value != true) {
                    val lastVisibleItem = (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()

                    // 마지막 아이템의 위치가 전체 아아템 개수보다 5개 적은 위치에 있는 경우 데이터를 받아온다.
                    if (layoutManager.itemCount <= lastVisibleItem + 5) {
                        viewModel.next()
                    }
                }
            }
        })

        viewModel.list()
    }

}