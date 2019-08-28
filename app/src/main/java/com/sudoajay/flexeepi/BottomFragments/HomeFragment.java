package com.sudoajay.flexeepi.BottomFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sudoajay.flexeepi.MainActivity;
import com.sudoajay.flexeepi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private MainActivity main_Activity;

    public HomeFragment() {
        // Required empty public constructor
    }

    public HomeFragment createInstance(MainActivity main_Activity) {
        this.main_Activity = main_Activity;
        return this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
