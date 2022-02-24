package com.example.android.viewerpager2withrx.Util;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpClientUtil {
    public static OkHttpClient buildOkHttpClient(){
        return new OkHttpClient.Builder()
                .addInterceptor
                        (new HttpLoggingInterceptor()
                                .setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();
    }
}
