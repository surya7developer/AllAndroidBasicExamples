package com.example.api_with_mvvm.viewmodel

import android.content.Context
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.api_with_mvvm.getCall
import com.example.api_with_mvvm.model.DataList
import com.example.api_with_mvvm.model.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(val context: Context) : ViewModel() {

    private var liveDataList : MutableLiveData<DataList?> = MutableLiveData()
    private var liveDataUserList : MutableLiveData<UserData?> = MutableLiveData()
    private var liveDataUserListQuery : MutableLiveData<UserData?> = MutableLiveData()
    private var liveDataUserListMultipleQuery : MutableLiveData<UserData?> = MutableLiveData()
    private var liveDataUserListqueryMap : MutableLiveData<UserData?> = MutableLiveData()
    var showLoader = ObservableBoolean(true)


    fun getLiveDataObserver() : MutableLiveData<DataList?> {
        return liveDataList
    }

    fun getLiveDataUserListObserver() : MutableLiveData<UserData?> {
        return liveDataUserList
    }
    fun getLiveDataUserListQueryObserver() : MutableLiveData<UserData?> {
        return liveDataUserListQuery
    }
    fun getLiveDataUserListMultipleQueryObserver() : MutableLiveData<UserData?> {
        return liveDataUserListMultipleQuery
    }
    fun getLiveDataUserListQueryMapObserver() : MutableLiveData<UserData?> {
        return liveDataUserListqueryMap
    }


    fun getApiData() {

        val call = getCall().getList()

       viewModelScope.launch(Dispatchers.IO){
           call.enqueue(object : Callback<DataList> {

               override fun onFailure(call: Call<DataList>, t: Throwable) {
                   showLoader.set(false)
                   liveDataList.postValue(null)
               }

               override fun onResponse(call: Call<DataList>, response: Response<DataList>) {
                   showLoader.set(false)
                   liveDataList.postValue(response.body())
                   response.body()
               }
           })

       }

    }

    fun getUserData() {

        val call = getCall().getCommentList(3)

        viewModelScope.launch(Dispatchers.IO){
            call.enqueue(object : Callback<UserData> {

                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    Log.d("getUserData","onFailure = ${t.localizedMessage}")
                    showLoader.set(false)
                    liveDataUserList.postValue(null)
                }

                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    Log.d("getUserData","onResponse = ${response.code()}")
                    showLoader.set(false)
                    liveDataUserList.postValue(response.body())
                    response.body()
                }
            })

        }
    }

    fun getUserDataQuery() {

        val call = getCall().getCommentListQuery(3)

        viewModelScope.launch(Dispatchers.IO){
            call.enqueue(object : Callback<UserData> {

                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    Log.d("getUserData","onFailure = ${t.localizedMessage}")
                    showLoader.set(false)
                    liveDataUserListQuery.postValue(null)
                }

                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    Log.d("getUserData","onResponse = ${response.code()}")
                    showLoader.set(false)
                    liveDataUserListQuery.postValue(response.body())
                    response.body()
                }
            })

        }
    }

    fun getUserDataMultipleQuery() {

        val call = getCall().getCommentListMultipleQuery(3,"id","desc")

        viewModelScope.launch(Dispatchers.IO){
            call.enqueue(object : Callback<UserData> {

                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    Log.d("getUserData","onFailure = ${t.localizedMessage}")
                    showLoader.set(false)
                    liveDataUserListMultipleQuery.postValue(null)
                }

                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    Log.d("getUserData","onResponse = ${response.code()}")
                    showLoader.set(false)
                    liveDataUserListMultipleQuery.postValue(response.body())
                    response.body()
                }
            })

        }
    }

    fun getUserDataQueryHashMap() {

        var map = HashMap<String,String>()
        map["postId"] = "4"
        map["_sort"] = "id"
        map["_order"] = "desc"

        val call = getCall().getCommentListQueryHashMap(map)

        viewModelScope.launch(Dispatchers.IO){
            call.enqueue(object : Callback<UserData> {

                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    Log.d("getUserData","onFailure = ${t.localizedMessage}")
                    showLoader.set(false)
                    liveDataUserListqueryMap.postValue(null)
                }

                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    Log.d("getUserData","onResponse = ${response.code()}")
                    showLoader.set(false)
                    liveDataUserListqueryMap.postValue(response.body())
                    response.body()
                }
            })

        }
    }


    class MainViewModelFactory(val context: Context) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(context) as T
        }
    }

}