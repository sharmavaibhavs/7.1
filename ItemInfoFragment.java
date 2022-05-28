package com.example.sit305_7_1p;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ItemInfoFragment extends Fragment {

    private static DataModel dataModel;

    public ItemInfoFragment() {
    }

    //this method creates and returns a new instance of the fragment
    public static ItemInfoFragment newInstance(DataModel alertItem) {
        ItemInfoFragment fragment = new ItemInfoFragment();
        dataModel = alertItem;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_info, container, false);
        TextView name, phone , desc, date , location;

        Button removeButton = view.findViewById(R.id.remove);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.Phone);
        desc = view.findViewById(R.id.Desc);
        date = view.findViewById(R.id.Date);
        location = view.findViewById(R.id.Location);
        name.setText(dataModel.getLostOrFound()+" "+dataModel.getName());
        phone.setText(String.valueOf(dataModel.getPhone()));
        desc.setText(dataModel.getDescription());
        date.setText(dataModel.getDate());
        location.setText(dataModel.getLocation());
        DbModel db = new DbModel(getContext());



        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteAlert(dataModel);
                Fragment fragment = RecyclerListFragment.newInstance();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.hide(getActivity().getSupportFragmentManager().findFragmentByTag("ItemInfoFragment"));
                transaction.add(R.id.FragmentContainer, fragment,"ShowAlertFragment");
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}