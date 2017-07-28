package com.gabrielaangebrandt.funworld.memory_activity.presenter;

import android.graphics.drawable.Drawable;

import com.gabrielaangebrandt.funworld.memory_activity.MemoryContract;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by Gabriela on 27.7.2017..
 */

public class MemoryPresenterImpl implements MemoryContract.MemoryPresenter{
    private MemoryContract.MemoryView view;


    public MemoryPresenterImpl(MemoryContract.MemoryView view) {
        this.view = view;
    }

    @Override
    public void onStart() {
        Field[] arrayDrawable = com.gabrielaangebrandt.funworld.R.drawable.class.getFields();
        ArrayList<Drawable> drawables = new ArrayList<>();

        for(Field field : arrayDrawable)
        {
            //drawables.add(getResources().getDrawable(field.getInt(null)));
        }
    }

    @Override
    public void onStop() {

    }
}
