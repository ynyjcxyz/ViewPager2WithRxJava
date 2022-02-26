package com.example.android.viewerpager2withrx.DataModel;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.List;

@GenerateTypeAdapter
@AutoValue

public abstract class CategoryDto implements Parcelable {
    @SerializedName("region")
    public abstract String region();

    @SerializedName("landmarks")
    public abstract List<BaseModel> landmarks();

    @SerializedName("national_parks")
    public abstract List<BaseModel> national_parks();

    @SerializedName("museums")
    public abstract List<BaseModel> museums();

    @SerializedName("roadtrip")
    public abstract List<BaseModel> roadtrip();

    @SerializedName("data_source")
    public abstract String data_source();
}
