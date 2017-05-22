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
import java.util.List;

import SupportClasses.Data;
import SupportClasses.ListFragment_Adapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    RecyclerView recyclerView;
    private ListFragment_Adapter adapter;

    public static ListFragment newInstance(){
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    public ListFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_list, container, false);

        List<Data> data = fill_with_data();

        //recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        //recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
       // recyclerView.hasFixedSize();


        adapter=new ListFragment_Adapter(data, getActivity() );


        recyclerView.setAdapter(adapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);



        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Etwas hinzugefügt", Snackbar.LENGTH_LONG)
              //          .setAction("Action", null).show();
                adapter.insert(adapter.getItemCount(), new Data("Neuer Arzt", "Seine Beschreibung", R.drawable.pic1_small));

            }
        });

        return rootView;


    }



    private List<Data> fill_with_data() {
        List<Data> data = new ArrayList<>();





        data.add(new Data("Dr. Achim", "Dr. Achim ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Müller", "Dr. Müller ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Dietrich", "Dr. Dietrich ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Burkhardt", "Dr. Burkhardt ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Schmidt", "Dr. Schmidt ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Achmed", "Dr. Achmed ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Ratte", "Dr. Ratte ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Schmerz", "Dr. Schmerz ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Anabolika", "Dr. Anabolika ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Fake", "Dr. Fake ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Nein", "Dr. Nein ist ein hervorragender Hausarzt", R.drawable.pic1_small));
        data.add(new Data("Dr. Bitte", "Dr. Bitte ist ein hervorragender Hausarzt", R.drawable.pic1_small));

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