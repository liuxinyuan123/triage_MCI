package com.example.triage_mci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Triage_START extends AppCompatActivity {

    public static boolean isFragment_breath_Displayed = false;
    public static boolean isFragment_respiratory_displayed = false;

    private Button able_to_walk_no;
    private Button able_to_walk_yes;
    //自主呼吸
//    fragment_respiratory_rate已经显示
//    @Override
//    public void onBackPressed() {
//        // 处理后退按钮事件,删掉所有的fragment
//        FragmentManager fm = getSupportFragmentManager();
//        if (fm.getBackStackEntryCount() > 0) {
//            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triage_start);
        TextView start_title = findViewById(R.id.start_title);
        able_to_walk_no = findViewById(R.id.START_able_to_walk_no);
        able_to_walk_yes = findViewById(R.id.START_able_to_walk_yes);

        able_to_walk_no.setEnabled(true);
        able_to_walk_yes.setEnabled(true);


        //隐藏默认出现的有无呼吸
        {
            Fragment fragment_spontaneousBreath = getSupportFragmentManager().findFragmentById(R.id.fragment_spontaneousBreath);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            assert fragment_spontaneousBreath != null;
            fragmentTransaction.remove(fragment_spontaneousBreath);
            fragmentTransaction.commit();
        }

        //隐藏默认的呼吸频率
        {
            Fragment fragment_respiratory_rate = getSupportFragmentManager().findFragmentById(R.id.fragment_respiratory_rate);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            assert fragment_respiratory_rate != null;
            fragmentTransaction.remove(fragment_respiratory_rate);
            fragmentTransaction.commit();
        }

        {
            Fragment fragment_perfusion_rate = getSupportFragmentManager().findFragmentById(R.id.fragment_perfusion_rate);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            assert fragment_perfusion_rate != null;
            fragmentTransaction.remove(fragment_perfusion_rate);
            fragmentTransaction.commit();
        }

        {
            Fragment fragment_spontaneousBreath_reassess = getSupportFragmentManager().findFragmentById(R.id.fragment_spontaneousBreath_reassess);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            assert fragment_spontaneousBreath_reassess != null;
            fragmentTransaction.remove(fragment_spontaneousBreath_reassess);
            fragmentTransaction.commit();
        }

        {
            Fragment fragment_mental_status = getSupportFragmentManager().findFragmentById(R.id.fragment_mental_status);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            assert fragment_mental_status != null;
            fragmentTransaction.remove(fragment_mental_status);
            fragmentTransaction.commit();
        }


        able_to_walk_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                if (!isFragment_breath_Displayed) {
                    Fragment myFragment = new spontaneous_breathing();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.fragment_spontaneousBreath , myFragment);
//                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    isFragment_breath_Displayed = true;
                    Toast.makeText(Triage_START.this , "If you need, you should call the emergency! " , Toast.LENGTH_SHORT).show();
                    able_to_walk_no.setEnabled(false);

                    able_to_walk_yes.setEnabled(true);
                }

            }
        });


        able_to_walk_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                able_to_walk_no.setEnabled(true);
                able_to_walk_yes.setEnabled(false);
                hideAllFragments();
                isFragment_breath_Displayed = false;
                start_title.setBackgroundColor(getResources().getColor(R.color.green_text,getTheme()));
//                Intent intent = new Intent(Triage_START.this, START_able_to_walk.class);
//                startActivity(intent);
                Toast.makeText(Triage_START.this , R.string.Green_Toast , Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void hideAllFragments () {
        // 隐藏自主呼吸Fragment
        Fragment fragment_spontaneousBreath = getSupportFragmentManager().findFragmentById(R.id.fragment_spontaneousBreath);
        if (fragment_spontaneousBreath != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment_spontaneousBreath).commit();
            isFragment_breath_Displayed = false;
        }
        // 隐藏呼吸频率Fragment
        Fragment fragment_respiratory_rate = getSupportFragmentManager().findFragmentById(R.id.fragment_respiratory_rate);
        if (fragment_respiratory_rate != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment_respiratory_rate).commit();
            isFragment_respiratory_displayed = false;
        }
        // 隐藏灌注率Fragment
        Fragment fragment_perfusion_rate = getSupportFragmentManager().findFragmentById(R.id.fragment_perfusion_rate);
        if (fragment_perfusion_rate != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment_perfusion_rate).commit();
        }
        // 隐藏自主呼吸复查Fragment
        Fragment fragment_spontaneousBreath_reassess = getSupportFragmentManager().findFragmentById(R.id.fragment_spontaneousBreath_reassess);
        if (fragment_spontaneousBreath_reassess != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment_spontaneousBreath_reassess).commit();
        }

        Fragment mental_status = getSupportFragmentManager().findFragmentByTag("能否听从指令");
        if (mental_status != null) {
            getSupportFragmentManager().beginTransaction().remove(mental_status).commit();
        }

        Fragment fragment_mental_status = getSupportFragmentManager().findFragmentById(R.id.fragment_mental_status);
        if (fragment_mental_status != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment_mental_status).commit();
        }

    }

    @Override
    protected void onResume () {
        super.onResume();

        able_to_walk_no = findViewById(R.id.START_able_to_walk_no);
        able_to_walk_yes = findViewById(R.id.START_able_to_walk_yes);

        // 重新启用 Button
        able_to_walk_no.setEnabled(true);
        able_to_walk_yes.setEnabled(true);

    }


}




