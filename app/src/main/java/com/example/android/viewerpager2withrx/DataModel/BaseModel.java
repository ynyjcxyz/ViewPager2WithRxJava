package com.example.android.viewerpager2withrx.DataModel;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;

@GenerateTypeAdapter
@AutoValue

public abstract class BaseModel implements Parcelable {

    @Nullable
    @SerializedName("name")
    public abstract String name();

    @Nullable
    @SerializedName("image_url")
    public abstract String image_url();

    @Nullable
    @SerializedName("tripadvisor_url")
    public abstract String tripadvisor_url();

}
