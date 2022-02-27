package com.example.android.viewerpager2withrx;

import com.example.android.viewerpager2withrx.DataModel.CategoryDto;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

//https://run.mocky.io/v3/e06909ca-66c3-4b35-adb6-4620bd889f6a
public interface DataService {
    @GET("v3/{uuid}")
    Single<CategoryDto> retrofitService(@Path("uuid") String parameterUuid);
}
