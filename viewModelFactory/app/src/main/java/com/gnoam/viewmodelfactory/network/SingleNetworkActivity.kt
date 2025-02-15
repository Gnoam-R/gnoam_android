package com.gnoam.viewmodelfactory.network

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.gnoam.viewmodelfactory.R
import com.gnoam.viewmodelfactory.api.ApiHelperImpl
import com.gnoam.viewmodelfactory.api.RetrofitBuilder
import com.gnoam.viewmodelfactory.base.ApiUserAdapter
import com.gnoam.viewmodelfactory.local.DatabaseBuilder
import com.gnoam.viewmodelfactory.local.DatabaseHelperImpl
import com.gnoam.viewmodelfactory.util.Status
import com.gnoam.viewmodelfactory.util.ViewModelFactory

class SingleNetworkActivity: AppCompatActivity() {
    private lateinit var viewModel: SingleNetworkViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_network)
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter =
            ApiUserAdapter(
                arrayListOf()
            )
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    private fun setupObserver() {
        viewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {

                }
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
            }
        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        ).get(SingleNetworkViewModel::class.java)

    }
}