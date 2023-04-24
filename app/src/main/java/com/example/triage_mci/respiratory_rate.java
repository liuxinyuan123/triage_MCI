package com.example.triage_mci;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link respiratory_rate#newInstance} factory method to
 * create an instance of this fragment.
 */
public class respiratory_rate extends Fragment {
    public boolean isdisplayed = false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public respiratory_rate() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment respiratory_rate.
     */
    // TODO: Rename and change types and number of parameters
    public static respiratory_rate newInstance(String param1, String param2) {
        respiratory_rate fragment = new respiratory_rate();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_respiratory_rate, container, false);


        Button under = view.findViewById(R.id.respiratory_rate_under_30);
        Button above = view.findViewById(R.id.respiratory_rate_above_30);



        under.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment perfusion = new perfusion();
                FragmentManager rateBreath = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = rateBreath.beginTransaction();
                fragmentTransaction.add(R.id.fragment_perfusion_rate, perfusion);
                isdisplayed = true;
                fragmentTransaction.commit();
                above.setEnabled(true);
                under.setEnabled(false);
            }
        });

        above.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                above.setEnabled(false);
                under.setEnabled(true);
                if (isdisplayed)
                {
                    Fragment fragment_perfusion_rate = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_perfusion_rate);
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.remove(fragment_perfusion_rate);
                    fragmentTransaction.commit();
                }

            }
        });


        return  view;
    }
}