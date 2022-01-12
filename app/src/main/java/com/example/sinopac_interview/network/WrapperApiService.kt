package com.example.sinopac_interview.network


class WrapperApiService(private val apiService: ApiService) : ApiService by apiService {


}