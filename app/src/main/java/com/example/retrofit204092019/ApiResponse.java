package com.example.retrofit204092019;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiResponse {
//    https://news.zing.vn/

//    https://news.zing.vn/thoi-su.html

    @GET("thoi-su.html")
    Call<String> getHtmlThoisu();


}
