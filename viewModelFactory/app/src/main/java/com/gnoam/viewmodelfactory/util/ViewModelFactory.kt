package com.gnoam.viewmodelfactory.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gnoam.viewmodelfactory.api.ApiHelper
import com.gnoam.viewmodelfactory.local.DatabaseHelper
import com.gnoam.viewmodelfactory.network.SingleNetworkViewModel

class ViewModelFactory (
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleNetworkViewModel::class.java)) {
            return SingleNetworkViewModel(apiHelper, dbHelper) as T
        }
//        if (modelClass.isAssignableFrom())
        throw IllegalArgumentException("Unknown class name")
    }
}