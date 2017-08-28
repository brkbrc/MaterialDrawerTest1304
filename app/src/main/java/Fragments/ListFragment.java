package Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.medicusApp.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Adapter.ListFragment_Adapter;
import Model.Doc;
import Services.DocService;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    @BindView(R.id.list_search)
    EditText mSearchBar;
    final String mBaseUrl = "http://85.214.40.101:8080/MedicusManagementWeb/api/v1/";
    Context mContext;
    String mLastName;
    String mSpeciality;
    String mCity;
    @BindView(R.id.button3)
    Button searchButton;
    Unbinder unbinder;

    public RecyclerView recyclerView;
    public ListFragment_Adapter adapter;
    public List<Doc> listeArzte;
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

        unbinder = ButterKnife.bind(this, rootView);

        Bundle bundle = getArguments();
        mLastName = bundle.getString("lastName");
        mSpeciality = bundle.getString("speciality");
        mCity = bundle.getString("city");

        initViews(rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initViews(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);

        // recyclerView.hasFixedSize();
        // new ArrayAdapter<String>(rootView.getContext(),R.layout.support_simple_spinner_dropdown_item,arrayCountry);
        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false));

        fillWithDocs();
    }

    private void fillWithDocs() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DocService service = retrofit.create(DocService.class);

        Call<List<Doc>> call = service.searchDocs(mLastName, mSpeciality, mCity);

        call.enqueue(new Callback<List<Doc>>() {
            @Override
            public void onResponse(Call<List<Doc>> call, retrofit2.Response<List<Doc>> response) {
                if (response.isSuccessful()) {
                    List<Doc> docList = response.body();
                    List<Doc> docs = new ArrayList<Doc>();
                    docList.forEach(doc -> System.out.println(doc.getFirstName()));
                    docList.forEach(doc -> docs.add(new Doc(doc.getId(), doc.getGender(), doc.getTitle(), doc.getFirstName(), doc.getLastName(), doc.getAddress(), doc.getSpeciality(), doc.getLanguageList())));

                    adapter = new ListFragment_Adapter(getActivity().getApplicationContext(), docList);
                    recyclerView.setAdapter(adapter);
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<List<Doc>> call, Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("RetroFit Error", t.getMessage());
            }
        });
    }

    @OnTextChanged(R.id.list_search)
    public void instantSearch() {
        mLastName = mSearchBar.getText().toString();
        mSpeciality = "";
        mCity = "";
        fillWithDocs();
    }

    @OnClick(R.id.button3)
    public void onViewClicked() {
        mLastName = mSearchBar.getText().toString();
        mSpeciality = "";
        mCity = "";
        fillWithDocs();
    }

}


