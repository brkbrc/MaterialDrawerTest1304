package com.example.materialdrawertest1304;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {
    AutoCompleteTextView textView;
    final String[] countries = new String[] {
            "Albania", "Algeria", "American Samoa", "Andorra",
            "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium"
    };

    public CameraFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_camera, container, false);
        textView = (AutoCompleteTextView) view.findViewById(R.id.country_autocomplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_multiple_choice, countries);
        textView.setAdapter(adapter);
        textView.setThreshold(1);
        return view;
    }

}
