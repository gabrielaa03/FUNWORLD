package com.gabrielaangebrandt.funworld.memory_activity.view;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.gabrielaangebrandt.funworld.MainActivity.MyRecyclerAdapter;
import com.gabrielaangebrandt.funworld.R;
import com.gabrielaangebrandt.funworld.memory_activity.MemoryContract;
import com.gabrielaangebrandt.funworld.memory_activity.presenter.MemoryPresenterImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Gabriela on 23.7.2017..
 */

public class MemoryActivity extends AppCompatActivity implements MemoryContract.MemoryView {
    private TextView player1, player2;
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    MyRecyclerAdapter adapter;
    MemoryContract.MemoryPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MemoryPresenterImpl(this);
        player1 = (TextView) findViewById(R.id.player1);
        player2 = (TextView) findViewById(R.id.player2);

        layoutManager = new GridLayoutManager(this, 10);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMemory);
        recyclerView.setAdapter(adapter);

        Field[] arrayDrawable = com.gabrielaangebrandt.funworld.R.drawable.class.getFields();
        ArrayList<Drawable> drawables = new ArrayList<>();

        for(Field field : arrayDrawable)
        {
         //   drawables.add(getResources().getIdentifier("com.gabrielaangebrandt.funworld:drawable/"), null,null);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }
}
