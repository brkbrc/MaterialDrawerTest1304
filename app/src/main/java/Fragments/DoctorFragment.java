package Fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.medicusApp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorFragment extends Fragment {

   // @Bind(R.id.user_profile_name) TextView doctor_name_textview;

    String doctor_title;
    String first_name;
    String doctor_name;
    Button checkinbutton;


    public DoctorFragment(String title, String firstName, String Name) {
        // Required empty public constructor
        this.doctor_title = title;
        this.first_name = firstName;
        this.doctor_name=Name;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_doctor_cardview,container,false);
        TextView t = (TextView) view.findViewById(R.id.profile_doctor_name);
        t.setText(doctor_title + " " + first_name + " " + doctor_name);

        checkinbutton = (Button) view.findViewById(R.id.profile_doctor_checkin_button);
        checkinbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                ViertesFragment viertesFragment = new ViertesFragment(doctor_name,first_name);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();


                activity.getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.enter,R.anim.exit,R.anim.pop_enter,R.anim.pop_exit)
                        .replace(R.id.constraintlayout_for_fragment, viertesFragment)
                        .addToBackStack(null) //addtobackstack sichert die korrekte Reihenfolge beim Drücken des Back Buttons
                        .commit();



            }
        });
        return view;



        //Toast.makeText(view.getContext(), t.getText() +" "+ view.getId(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(view.getContext(), "You have clicked " + view.getId(), Toast.LENGTH_SHORT).show();
       // doctor_name_textview.setText(doctor_name);


    }



}
