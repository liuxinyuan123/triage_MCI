package com.example.triage_mci;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link spontaneous_breathing#newInstance} factory method to
 * create an instance of this fragment.
 */
public class spontaneous_breathing extends Fragment {




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public spontaneous_breathing() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment spontaneous_breathing.
     */
    // TODO: Rename and change types and number of parameters
    public static spontaneous_breathing newInstance(String param1, String param2) {
        spontaneous_breathing fragment = new spontaneous_breathing();
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
        View view = inflater.inflate(R.layout.fragment_spontaneous_breathing, container, false);

        Button breath_yes = view.findViewById(R.id.START_breath_yes);
        Button breath_no = view.findViewById(R.id.START_breath_no);


        breath_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "no breathing!", Toast.LENGTH_SHORT).show();

                breath_no.setEnabled(false);
                breath_yes.setEnabled(true);

                Fragment rate_breath_reassess = new breathing_reassess();
                FragmentManager rateBreath = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = rateBreath.beginTransaction();
                fragmentTransaction.add(R.id.fragment_spontaneousBreath_reassess, rate_breath_reassess);

                fragmentTransaction.commit();
                {
                    Fragment fragment_respiratory_rate = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_respiratory_rate);
                    FragmentTransaction fragmentTransaction_ = getActivity().getSupportFragmentManager().beginTransaction();
                    if (fragment_respiratory_rate != null)
                    {
                        fragmentTransaction_.remove(fragment_respiratory_rate);
                        fragmentTransaction_.commit();
                    }
                }

            }
        });

        breath_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "can breathing!", Toast.LENGTH_SHORT).show();
                Fragment rate_breath = new respiratory_rate();
                FragmentManager rateBreath = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = rateBreath.beginTransaction();
                fragmentTransaction.add(R.id.fragment_respiratory_rate, rate_breath);
                fragmentTransaction.commit();
                breath_yes.setEnabled(false);
                breath_no.setEnabled(true);

                {
                    Fragment fragment_spontaneousBreath_reassess = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_spontaneousBreath_reassess);
                    FragmentTransaction fragmentTransaction_ = getActivity().getSupportFragmentManager().beginTransaction();
                    if (fragment_spontaneousBreath_reassess != null)
                    {
                        fragmentTransaction_.remove(fragment_spontaneousBreath_reassess);
                        fragmentTransaction_.commit();
                    }
                }
            }
        });



        return view;


    }
}