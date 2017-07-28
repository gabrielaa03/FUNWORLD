package com.gabrielaangebrandt.funworld.MainActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gabrielaangebrandt.funworld.R;

import java.lang.reflect.Field;

/**
 * Created by Gabriela on 25.7.2017..
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private Field[] list;

    public MyRecyclerAdapter(Field[] list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_element_image, parent, false);
        ViewHolder memoryViewHolder = new ViewHolder(view);
        return memoryViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     /*       list = android.R.drawable.class.getFields();
        for (Field f : list) {
            try {
              //  holder.flag.setImageDrawable(list(position));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }*/
    }

    @Override
    public int getItemCount() {

        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView flag;
        public ViewHolder(View view) {
            super(view);
            flag = (ImageView) view.findViewById(R.id.iv_memory_element);
        }
    }
}
