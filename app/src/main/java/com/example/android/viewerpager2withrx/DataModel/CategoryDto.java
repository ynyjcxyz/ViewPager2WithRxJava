package com.example.android.viewerpager2withrx.DataModel;

import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.serializable.SerializableAutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.List;

@GenerateTypeAdapter
@AutoValue
@SerializableAutoValue

public abstract class CategoryDto {
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
