package com.example.materialdrawertest1304;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorFragment extends Fragment {

    @Bind(R.id.user_profile_name) TextView doctor_name_textview;

    String doctor_name;

    public DoctorFragment(String Name) {
        // Required empty public constructor
        this.doctor_name=Name;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_doktor,container,false);
        TextView t = (TextView) view.findViewById(R.id.user_profile_name);
        t.setText(doctor_name);
        return view;

        //Toast.makeText(view.getContext(), t.getText() +" "+ view.getId(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(view.getContext(), "You have clicked " + view.getId(), Toast.LENGTH_SHORT).show();
       // doctor_name_textview.setText(doctor_name);


    }



}
