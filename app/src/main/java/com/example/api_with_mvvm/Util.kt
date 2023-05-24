package com.example.api_with_mvvm

import com.example.api_with_mvvm.retrofit.RetrofitHelper
import com.example.api_with_mvvm.service.APiService

fun getCall(): APiService {
    return RetrofitHelper.getRetrofit().create(APiService::class.java)
}