package Fragments;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicusApp.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Adapter.ListFragment_Adapter;
import Model.Doc;
import Services.DocService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    String mUrlString = "http://85.214.40.101:8080/MedicusManagementWeb/api/v1/docs/101";
    Context mContext;


    public RecyclerView recyclerView;
    public ListFragment_Adapter adapter;
    public List<Doc> listeArzte = fill_with_doc_data();
    public static ListFragment newInstance(){
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    public ListFragment(){

    }

    private static final Comparator<Doc> ALPHABETICAL_COMPARATOR = new Comparator<Doc>() {
        @Override
        public int compare(Doc a, Doc b) {
            return a.getFirstName().compareTo(b.getFirstName());
        }
    };

    public class WrapContentLinearLayoutManager extends LinearLayoutManager {
        public WrapContentLinearLayoutManager(Context context, int horizontal, boolean b) {
            super(context);
        }

        //... constructor
        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                Log.e("probe", "Absturz im Recyclerview verhindert");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_list, container, false);

        mContext = this.getActivity().getApplicationContext();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
       // recyclerView.hasFixedSize();
        adapter=new ListFragment_Adapter(getActivity(), ALPHABETICAL_COMPARATOR);
       // new ArrayAdapter<String>(rootView.getContext(),R.layout.support_simple_spinner_dropdown_item,arrayCountry);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false));


//

        //Das wird ausgeführt wenn der rote Button gedrückt wird:
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Etwas hinzugefügt", Snackbar.LENGTH_LONG)
              //          .setAction("Action", null).show();
               // adapter.insert(new Doc(15,"AAA", "Seine Beschreibung", R.drawable.pic1_small));
                recyclerView.scrollToPosition(0);


            }
        });

        return rootView;


    }







    private List<Doc> fill_with_doc_data(){
        List<Doc> docs = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://85.214.40.101:8080/MedicusManagementWeb/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DocService service = retrofit.create(DocService.class);

        Call<List<Doc>> call = service.loadAllDocs();

        call.enqueue(new Callback<List<Doc>>() {
            @Override
            public void onResponse(Call<List<Doc>> call, retrofit2.Response<List<Doc>> response) {
                if (response.isSuccessful()) {
                    List<Doc> docList = response.body();
                    docList.forEach(doc -> System.out.println(doc.getFirstName()));
                    docList.forEach(doc -> docs.add(new Doc(doc.getLanr(), doc.getFirstName(), doc.getLastName(), "Augenarzt", R.drawable.pic1_small)));
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<List<Doc>> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });

        return docs;
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