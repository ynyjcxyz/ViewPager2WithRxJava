package com.example.android.viewerpager2withrx.DataModel;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.util.List;

@GenerateTypeAdapter
@AutoValue

public abstract class CategoryDto implements Parcelable {
    @Nullable
    @SerializedName("region")
    public abstract String region();

    @Nullable
    @SerializedName("landmarks")
    public abstract List<BaseModel> landmarks();

    @Nullable
    @SerializedName("national_parks")
    public abstract List<BaseModel> national_parks();

    @Nullable
    @SerializedName("museums")
    public abstract List<BaseModel> museums();

    @Nullable
    @SerializedName("roadtrip")
    public abstract List<BaseModel> roadtrip();

    @Nullable
    @SerializedName("data_source")
    public abstract String data_source();
}
