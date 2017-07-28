package com.gabrielaangebrandt.funworld.MainActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gabrielaangebrandt.funworld.R;
import com.gabrielaangebrandt.funworld.memory_activity.view.MemoryActivity;

/**
 * Created by Gabriela on 16.5.2017..
 */

public class FragmentGames extends Fragment implements View.OnClickListener{
    Button memory1, millionire1, picado1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Declare your second fragment here
    View view = inflater.inflate(R.layout.fragment_games_layout, container, false);

        this.memory1 = (Button) view.findViewById(R.id.btn_memory);
        this.millionire1 = (Button) view.findViewById(R.id.btn_millionaire);
        this.picado1 = (Button) view.findViewById(R.id.btn_picado);

       memory1.setOnClickListener(this);
        millionire1.setOnClickListener(this);
        picado1.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.btn_memory:
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setMessage("")
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                               Intent intent = new Intent (getContext(), MemoryActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                               dialog.dismiss();
                            }
                        });
                alertDialog.create();

                break;

            case R.id.btn_millionaire:
                final AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(getContext());
                alertDialog1.setMessage("")
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent (getContext(), TiltActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                               dialog.dismiss();
                            }
                        });
                alertDialog1.create();


                break;

            case R.id.btn_picado:
                final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(getContext());
                alertDialog2.setMessage("")
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(getContext(), PicadoActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        });
                alertDialog2.create();
                break;
        }

    }
}
