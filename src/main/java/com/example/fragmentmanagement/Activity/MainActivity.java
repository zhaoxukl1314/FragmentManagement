package com.example.fragmentmanagement.Activity;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.fragmentmanagement.FragmentController.BaseFragment;
import com.example.fragmentmanagement.FragmentController.Fragment.HomeFragment;
import com.example.fragmentmanagement.FragmentController.FragmentManagement;
import com.example.fragmentmanagement.FragmentController.FragmentRegister;
import com.example.fragmentmanagement.R;

public class MainActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout contentContainer = (FrameLayout) findViewById(R.id.container);
        FragmentManagement manager = getFragmentManagement();
        manager.initialize();
        manager.startFragment(new FragmentRegister(HomeFragment.class));
    }
}
