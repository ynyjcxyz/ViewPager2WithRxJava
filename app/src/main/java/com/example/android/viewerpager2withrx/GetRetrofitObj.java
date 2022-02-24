package com.example.android.viewerpager2withrx;

import static com.example.android.viewerpager2withrx.Util.GsonUtil.createGson;
import static com.example.android.viewerpager2withrx.Util.OkhttpClientUtil.buildOkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetRetrofitObj {
    static DataService retrofitService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //necessary
                .client(buildOkHttpClient())
                .build();
        return retrofit.create(DataService.class);
    }
}
