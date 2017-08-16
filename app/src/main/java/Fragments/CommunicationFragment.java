package Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.medicusApp.R;

import SupportClasses.JSONResponse;
import SupportClasses.JSONTask;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CommunicationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommunicationFragment extends Fragment implements JSONResponse{

    String mUrlString = "http://85.214.40.101:8080/MedicusManagementWeb/api/v1/docs/101";
    Context mContext;

    private TextView textView;
    JSONTask jsonTask = new JSONTask();
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView=inflater.inflate(R.layout.fragment_communication, container, false);
        textView=(TextView) rootView.findViewById(R.id.textView3);
        Button button = (Button) rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Snackbar.make(view, "Etwas hinzugefügt", Snackbar.LENGTH_LONG)
                 //        .setAction("Action", null).show();
            }
        });

        // Inflate the layout for this fragment
        return rootView;



    }

    public void doSomething() {
        textView=(TextView) rootView.findViewById(R.id.textView3);

    }


    @Override
    public void processFinish(String output) {

    }
}
