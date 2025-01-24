package com.gnoam.viewmodelfactory.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gnoam.viewmodelfactory.api.ApiHelper
import com.gnoam.viewmodelfactory.local.DatabaseHelper
import com.gnoam.viewmodelfactory.util.ApiUser
import com.gnoam.viewmodelfactory.util.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class SingleNetworkViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val users = MutableLiveData<Resource<List<ApiUser>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            apiHelper.getUsers()
                .catch { e ->
                    users.postValue(Resource.error(e.toString(), null))
                }
                .collect {
                    users.postValue(Resource.success(it))
                }
        }
    }

    fun getUsers(): LiveData<Resource<List<ApiUser>>> {
        return users
    }
}