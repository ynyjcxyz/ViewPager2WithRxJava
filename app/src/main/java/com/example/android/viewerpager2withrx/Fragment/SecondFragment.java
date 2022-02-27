package com.example.android.viewerpager2withrx.Fragment;

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

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {
    private List<BaseModel> national_parks = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        national_parks = getArguments() != null ? getArguments().getParcelableArrayList("national_parks") : null;
        System.out.println(national_parks);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAdapter = new RecyclerViewAdapter(rootView.getContext(),national_parks);
        recyclerView.setAdapter(recyclerAdapter);

        return rootView;
    }
}
