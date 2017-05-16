package com.gabrielaangebrandt.funworld;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Gabriela on 16.5.2017..
 */

public class MyFirstTabFragment extends Fragment{
    Button memory1, millionire1, picado1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Declare your second fragment here
    View view = inflater.inflate(R.layout.fragment_countries, container, false);

        this.memory1 = (Button) view.findViewById(R.id.memory);
        this.millionire1 = (Button) view.findViewById(R.id.millionaire);
        this.picado1 = (Button) view.findViewById(R.id.picado);

       /* memory1.setOnClickListener(this);
        millionire1.setOnClickListener(this);
        picado1.setOnClickListener(this);*/
        return view;
    }

   /* @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.memory:
                break;

            case R.id.millionaire:
                break;

            case R.id.picado:
                break;
        }
    }*/
}
