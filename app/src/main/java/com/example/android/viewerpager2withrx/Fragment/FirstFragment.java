package com.example.android.viewerpager2withrx.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.viewerpager2withrx.DataModel.BaseModel;
import com.example.android.viewerpager2withrx.R;
import com.example.android.viewerpager2withrx.RecyclerViewAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FirstFragment extends Fragment {
    List<BaseModel> landmarks = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle bundle ){
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        assert bundle != null;
        landmarks = (List<BaseModel>) bundle.getSerializable("landmarks");

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(rootView.getContext(),landmarks));

        return rootView;
    }


}
