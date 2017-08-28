package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.medicusApp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by janhu on 24.08.2017.
 */

/**
 * Created by janhu on 21.07.2017.
 */

public class SearchFragment extends Fragment {

    @BindView(R.id.etLastName)
    EditText mEtLastName;
    @BindView(R.id.etSpeciality)
    EditText mEtSpeciality;
    @BindView(R.id.etCity)
    EditText mEtCity;
    @BindView(R.id.btSearch)
    Button mBtSearch;
    Unbinder unbinder;
    String mSearchQuery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_doc_search, container, false);

        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btSearch)
    public void onViewClicked() {

        Bundle bundle = new Bundle();
        bundle.putString("lastName", mEtLastName.getText().toString());
        bundle.putString("speciality", mEtSpeciality.getText().toString());
        bundle.putString("city", mEtCity.getText().toString());

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ListFragment listFragment = new ListFragment();
        listFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.constraintlayout_for_fragment, listFragment);
        fragmentTransaction.commit();
    }


}
