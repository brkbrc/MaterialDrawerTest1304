package com.example.materialdrawertest1304;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {

    public CameraFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AutoCompleteTextView textView;
         final String[] countries = new String[] {
                "Albania", "Algeria", "American Samoa", "Andorra",
                "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium"
        };
        View view =  inflater.inflate(R.layout.fragment_camera, container, false);
        textView = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, countries);
        textView.setThreshold(2);
        textView.setAdapter(adapter);
        
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }

}
