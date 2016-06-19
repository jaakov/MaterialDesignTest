package com.jkgeekjack.mymd;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecommandFragment extends Fragment {
    private RecyclerView recyclerView;
    private static RecommandFragment recommandFragment=new RecommandFragment();
    public static RecommandFragment getRecommandFragment(){
        return recommandFragment;
    }

    public RecommandFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommand, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerView);
        List<String>strings=new ArrayList<>();
        for(int i=0;i<20;i++){
            strings.add(i+"");
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        ListAdapter mAdapter=new ListAdapter(strings);
        recyclerView.setAdapter(mAdapter);
    }
}
