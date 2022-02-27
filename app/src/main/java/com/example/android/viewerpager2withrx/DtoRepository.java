package com.example.android.viewerpager2withrx;

import static com.example.android.viewerpager2withrx.GetRetrofitObj.retrofitService;
import com.example.android.viewerpager2withrx.DataModel.CategoryDto;
import io.reactivex.Single;

public class DtoRepository {
    public static Single<CategoryDto> getDto(String uuid) {
        return retrofitService().retrofitService(uuid);
    }
}
