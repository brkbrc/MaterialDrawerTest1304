package Fragments;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicusApp.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import SupportClasses.Data;
import SupportClasses.ListFragment_Adapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    public RecyclerView recyclerView;
    public ListFragment_Adapter adapter;
    public List<Data> data = fill_with_data();
    public static ListFragment newInstance(){
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    public ListFragment(){

    }

    private static final Comparator<Data> ALPHABETICAL_COMPARATOR = new Comparator<Data>() {
        @Override
        public int compare(Data a, Data b) {
            return a.getText().compareTo(b.getText());
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
       // recyclerView.hasFixedSize();
        adapter=new ListFragment_Adapter(data, getActivity(), ALPHABETICAL_COMPARATOR);
       // new ArrayAdapter<String>(rootView.getContext(),R.layout.support_simple_spinner_dropdown_item,arrayCountry);
        recyclerView.setAdapter(adapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);


        //Das wird ausgeführt wenn der rote Button gedrückt wird:
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Etwas hinzugefügt", Snackbar.LENGTH_LONG)
              //          .setAction("Action", null).show();
                adapter.insert(adapter.getItemCount(), new Data(15,"Neuer Arzt", "Seine Beschreibung", R.drawable.pic1_small));

            }
        });

        return rootView;


    }



    private List<Data> fill_with_data() {
        List<Data> data = new ArrayList<>();





        data.add(new Data(1,"Dr. Achim", "Dr. Achim ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(2,"Dr. Müller", "Dr. Müller ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(3,"Dr. Dietrich", "Dr. Dietrich ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(4,"Dr. Burkhardt", "Dr. Burkhardt ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(5,"Dr. Schmidt", "Dr. Schmidt ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(6,"Dr. Achmed", "Dr. Achmed ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(7,"Dr. Ratte", "Dr. Ratte ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(8,"Dr. Schmerz", "Dr. Schmerz ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(9,"Dr. Anabolika", "Dr. Anabolika ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(10,"Dr. Fake", "Dr. Fake ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(11,"Dr. Nein", "Dr. Nein ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data(12,"Dr. Bitte", "Dr. Bitte ist ein hervorragender Hausarzt", R.drawable.pic1_small));

        return data;
    }

    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 50, 50, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }





}








/*    AutoCompleteTextView textView;
final String[] countries = new String[] {
        "Albania", "Algeria", "American Samoa", "Andorra",
        "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium"
        };

public ListFragment() {
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
        */