package com.example.retrofit204092019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buoc 1 : Khoi tao retrofit
        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://news.zing.vn/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        // Buoc 2 : Tao 1 interface call api va hung du lieu
        ApiResponse apiResponse = retrofit.create(ApiResponse.class);

        // Buoc 3 : Goi api va nhan du lieu tu trong call back
        Call<String> callbackThoiTietHtml = apiResponse.getHtmlThoisu();

        callbackThoiTietHtml.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String value = response.body();
                Log.d("BBB",value);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}
