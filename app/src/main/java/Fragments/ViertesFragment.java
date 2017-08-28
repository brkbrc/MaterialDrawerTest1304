package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.medicusApp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.Expandable_list_adapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViertesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViertesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViertesFragment extends Fragment {
    ExpandableListView expandableListView;
    CheckBox checkBoxKopfschmerz;
    SeekBar seekBar2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private String firstname;
    private String doktorname;

    private OnFragmentInteractionListener mListener;

    public ViertesFragment(String name, String name2) {
        firstname = name2;
        doktorname=name;
        // Required empty public constructor
    }


    public static ViertesFragment newInstance(int param1) {
        ViertesFragment fragment = new ViertesFragment("name", "name2");
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);

        }






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Integer total = mParam1*5;
        onButtonPressed(total.toString());
        View view;
        view = inflater.inflate(R.layout.fragment_vier, container, false);

/*
        expandableListView= (ExpandableListView) view.findViewById(R.id.exp_listview);
        List<String> Headings = new ArrayList<String>();
        List<String> L1 = new ArrayList<String>();
        List<String> L2 = new ArrayList<String>();
        List<String> L3 = new ArrayList<String>();
        HashMap<String,List<String>> ChildList = new HashMap<String, List<String>>();
        String heading_items[] = getResources().getStringArray(R.array.expandable_list_header_title);
        String l1[] = getResources().getStringArray(R.array.expandable_list_header_vorerkrankungen);
        String l2[] = getResources().getStringArray(R.array.expandable_list_header_medikamente);
        String l3[] = getResources().getStringArray(R.array.expandable_list_header_beandlungen);

        for (String title : heading_items)
        {
            Headings.add(title);
        }
        for (String title :  l1)
        {
            L1.add(title);
        }
        for (String title :  l2)
        {
            L2.add(title);
        }

        for (String title :  l3)
        {
            L3.add(title);
        }
        ChildList.put(Headings.get(0),L1);
        ChildList.put(Headings.get(1),L2);
        ChildList.put(Headings.get(2),L3);

        Expandable_list_adapter expandableListAdapter = new Expandable_list_adapter(this.getContext(), Headings,ChildList);
        expandableListView.setAdapter(expandableListAdapter);
        //textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        expandableListView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                int height =0;
                int count = expandableListView.getChildCount();
                for (int z=0; z< count; z++){
                    height += expandableListView.getChildAt(z).getMeasuredHeight();
                    height += expandableListView.getDividerHeight();
                }
                expandableListView.getLayoutParams().height = (height+6)*10;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                expandableListView.getLayoutParams().height = 200;
            }
        });
*/
        String[] Medikamente =new String[] {
                "Aspirin", "Ibuprophen", "Dicolofenac", "Novalgin", "Codein"
        };
        MultiAutoCompleteTextView anamText = (MultiAutoCompleteTextView) view.findViewById(R.id.anamneseTextView);
        ArrayAdapter<String> anamTextAd= new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1,Medikamente);
        anamText.setAdapter(anamTextAd);
        anamText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        seekBar2 = (SeekBar) view.findViewById(R.id.seekBar2);
        TextView docname;

        docname = (TextView) view.findViewById(R.id.profile_doctor_name_anamnese);
        docname.setText("Dr. med " + firstname+" " +doktorname);

         checkBoxKopfschmerz = (CheckBox) view.findViewById(R.id.expandable_list_child_item_checkbox_kopfschmerzen);
        checkBoxKopfschmerz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClicked(view);


                //checkBoxKopfschmerz.setVisibility(View.INVISIBLE);
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction(data);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void itemClicked(View v){
        if (checkBoxKopfschmerz.isChecked()){
            Snackbar.make(v, "Wie stark sind die Schmerzen auf einer Skala 1-5?", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            seekBar2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,150));
        } else {
            seekBar2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0));
        }

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {


        // TODO: Update argument type and name
        void onFragmentInteraction(String data);
    }
}
