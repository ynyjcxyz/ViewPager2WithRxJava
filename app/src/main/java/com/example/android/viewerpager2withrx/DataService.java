package com.example.android.viewerpager2withrx;

import com.example.android.viewerpager2withrx.DataModel.CategoryDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

//https://run.mocky.io/v3/f60dd98c-466f-44e7-a5dc-f5258dc4f513
public interface DataService {
    @GET("v3/{uuid}")
    Single<CategoryDto> retrofitService(@Path("uuid") String parameterUuid);
}
