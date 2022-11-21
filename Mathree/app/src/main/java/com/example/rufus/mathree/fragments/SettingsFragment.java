package com.example.rufus.mathree.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rufus.mathree.R;

import static com.example.rufus.mathree.R.id.bn_logout;

public class SettingsFragment extends Fragment {
    Button BnLogout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Button BnLogout = (Button) getView().findViewById(R.id.bn_logout);


        return inflater.inflate(R.layout.fragment_settings, container, false);

    }
}
