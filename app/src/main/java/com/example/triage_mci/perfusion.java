package com.example.triage_mci;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link perfusion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class perfusion extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public perfusion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment perfusion.
     */
    // TODO: Rename and change types and number of parameters
    public static perfusion newInstance(String param1, String param2) {
        perfusion fragment = new perfusion();
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

        View view =  inflater.inflate(R.layout.fragment_perfusion, container, false);
        view.setTag("血管灌注");

        Button perfusion_yes = view.findViewById(R.id.START_perfusion_yes);
        Button perfusion_no = view.findViewById(R.id.START_perfusion_no);

        //灌注不足
        perfusion_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                perfusion_no.setEnabled(false);
                perfusion_yes.setEnabled(true);
                Toast.makeText(getActivity(), "Please call the emergency! in perfusion ", Toast.LENGTH_SHORT).show();
                Fragment fragment_mental_status = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_mental_status);
                if (fragment_mental_status != null) {
                    getActivity().getSupportFragmentManager().beginTransaction().remove(fragment_mental_status).commit();
                }

            }
        });

        //灌注可
        perfusion_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perfusion_no.setEnabled(true);
                perfusion_yes.setEnabled(false);
                {
                    Fragment mental_status = new mental_status();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.fragment_mental_status, mental_status);
                    fragmentTransaction.commit();
                }

            }
        });

        return view;
    }
}

