package com.example.materialdrawertest1304;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import SupportClasses.Data;
import SupportClasses.Row_List_View_Adapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {


    RecyclerView recyclerView;
    private Row_List_View_Adapter adapter;

    public static ListFragment newInstance(){
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    public ListFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.list_content, container, false);

        List<Data> data = fill_with_data();

        //recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        //recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
       // recyclerView.hasFixedSize();


        adapter=new Row_List_View_Adapter(data, getActivity() );


        recyclerView.setAdapter(adapter);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return rootView;


    }



    private List<Data> fill_with_data() {
        List<Data> data = new ArrayList<>();

        data.add(new Data("Batman vs Superman", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", R.drawable.ic_action_movie));
        data.add(new Data("X-Men: Apocalypse", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", R.drawable.ic_action_movie));
        data.add(new Data("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", R.drawable.ic_action_movie));
        data.add(new Data("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", R.drawable.ic_action_movie));
        data.add(new Data("Warcraft", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ", R.drawable.ic_action_movie));
        data.add(new Data("Alice in Wonderland", "Alice in Wonderland: Through the Looking Glass ", R.drawable.ic_action_movie));

        data.add(new Data("Batman vs Superman", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", R.drawable.ic_action_movie));
        data.add(new Data("X-Men: Apocalypse", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", R.drawable.ic_action_movie));
        data.add(new Data("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", R.drawable.ic_action_movie));
        data.add(new Data("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", R.drawable.ic_action_movie));
        data.add(new Data("Warcraft", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ", R.drawable.ic_action_movie));
        data.add(new Data("Alice in Wonderland", "Alice in Wonderland: Through the Looking Glass ", R.drawable.ic_action_movie));

        return data;
    }

    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 50, 50, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }

    public  void displayView() {
        Fragment fragment = null;
        fragment =   new DoktorFragment();

        if (fragment !=null){
            FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.constraintlayout_for_fragment, fragment)
                    .addToBackStack(null).commit();

        }

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