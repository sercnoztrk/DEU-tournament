package com.example.sercan.deutournament;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentB extends Fragment {
    private OnFragmentInteractionListener mListener;
    private TextView text_view_for_tab_selection;
    private ListView list_view_for_rounds;

    public FragmentB() {
        // Required empty public constructor
    }


    public static FragmentB newInstance(/*String tabSelected*/ArrayList<String> listPerRound) {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        args.putStringArrayList(Constants.FRAG_B, /*tabSelected*/ listPerRound);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        //text_view_for_tab_selection=(TextView)view.findViewById(R.id.text_view_for_tab_selection);
        //text_view_for_tab_selection.setText(getArguments().getString(Constants.FRAG_B));
        list_view_for_rounds = view.findViewById(R.id.match_list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getArguments().getStringArrayList(Constants.FRAG_B));
        list_view_for_rounds.setAdapter(arrayAdapter);

        return view;
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

    @Override
    public void onResume() {
        super.onResume();
    }
}
