package com.example.android.viewerpager2withrx.DataModel;


import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.serializable.SerializableAutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue
@SerializableAutoValue

public abstract class BaseModel {

    @SerializedName("name")
    public abstract String name();

    @SerializedName("image_url")
    public abstract String image_url();

    @SerializedName("tripadvisor_url")
    public abstract String tripadvisor_url();

}
