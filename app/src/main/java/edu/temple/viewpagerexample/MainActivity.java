package edu.temple.viewpagerexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    // An Arraylist full of fragments
    ArrayList<TestFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragments = new ArrayList<>();

        // a ViewPager is essentially just an AdapterView, that displays things given to it by an Adapter, which itself uses some data source
        viewPager = findViewById(R.id.viewPager);

        // FragmentStatePagerAdapter lets ViewPager display its fragments
        // Needs a reference to getSupportFragmentManager in an activity, getChildFragmentManager() within a Fragment
        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            // Just needs these two methods, actually
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });


        // Also need a way to add fragments to the list
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Adds new TestFragment, then alerts ViewPager's adapter that the dataset has changed 
                fragments.add(new TestFragment());
                viewPager.getAdapter().notifyDataSetChanged();
            }
        });
    }
}