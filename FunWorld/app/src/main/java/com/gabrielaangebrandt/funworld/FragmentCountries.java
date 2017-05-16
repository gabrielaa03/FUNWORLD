package com.gabrielaangebrandt.funworld;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;



/**
 * Created by Gabriela on 11.5.2017..
 */

public class FragmentCountries extends Fragment {
    private static final String TAG = "TAG";
    ListView listView;
    String[] listOfCountries;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_countries, container, false);
        listView = (ListView) v.findViewById(R.id.listCountries);
        listOfCountries = getResources().getStringArray(R.array.countries1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listOfCountries);

        listView.setAdapter(adapter);
        return v;
    }
}
