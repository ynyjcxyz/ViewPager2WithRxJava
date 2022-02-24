package com.example.android.viewerpager2withrx.DataModel;


import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

import java.io.Serializable;

@GenerateTypeAdapter
@AutoValue
public abstract class BaseModel implements Serializable {

    @SerializedName("name")
    public abstract String iconUrl();

    @SerializedName("image_url")
    public abstract String image_url();

    @SerializedName("tripadvisor_url")
    public abstract String tripadvisor_url();

}
