package edu.temple.viewpagerexample;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestFragment extends Fragment {

    int color;

    public TestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View l = inflater.inflate(R.layout.fragment_test, container, false);

        if (savedInstanceState != null) {
            // It's retrieving the color value by key
            color = savedInstanceState.getInt("color");
        } else {
            int[] colors = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};
            color = colors[new Random().nextInt(colors.length)];
        }
        l.setBackgroundColor(color);

        return l;
    }

    // This is where int color is being saved
    @Override
    public void onSaveInstanceState (@NonNull Bundle outState) {
        // Call the superclass to do all it's normal stuff, followed by your override specific actions
        super.onSaveInstanceState(outState);
        // Storing the color value
        outState.putInt("color", color);
    }
}