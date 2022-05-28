package com.example.sit305_7_1p;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerListFragment extends Fragment implements ItemRecycler.ItemClickListener {

    ArrayList<DataModel> list = new ArrayList<>();

    public RecyclerListFragment() {
        // Required empty public constructor
    }

    public static RecyclerListFragment newInstance() {
        RecyclerListFragment fragment = new RecyclerListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_list, container, false);

        DbModel db = new DbModel(getContext());
        list = db.fetchAllAlerts();

        RecyclerView RecyclerViewAlerts = view.findViewById(R.id.recycler);
        LinearLayoutManager VerticalManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerViewAlerts.setLayoutManager(VerticalManager);
        ItemRecycler AlertAdapter = new ItemRecycler(getContext(), list, this);
        RecyclerViewAlerts.setAdapter(AlertAdapter);

        return view;
    }

    @Override
    public void onItemClick(DataModel alert) {
        Fragment fragment = ItemInfoFragment.newInstance(alert);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("RecyclerListFragment"));
        transaction.add(R.id.FragmentContainer, fragment, "ItemInfoFragment");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}