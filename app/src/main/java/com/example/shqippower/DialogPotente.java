package com.example.shqippower;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DialogPotente extends Activity {
    private int i = 0;
    private CountDownTimer timer;
    private long timeleft;
    private String title, type, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFinishOnTouchOutside(false);

        final ArrayList<ListActivity> arrayList;
        arrayList=(ArrayList<ListActivity>) getIntent().getSerializableExtra("list");

        final int n = arrayList.size();

        final Button btnstart = findViewById(R.id.btnstart);
        final Button btnstop = findViewById(R.id.btnstop);
        btnstop.setEnabled(false);
        final Button btnnext = findViewById(R.id.btnnext);
        btnnext.setEnabled(false);
        final Button btnriprendi = findViewById(R.id.btnriprendi);
        btnriprendi.setEnabled(false);
        final Button btnchiudi = findViewById(R.id.btnchiudi);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = arrayList.get(i).getTitle();
                type = arrayList.get(i).getType();
                time = arrayList.get(i).getTime();
                int t =  Integer.parseInt(time);
                long millis = t * 60 * 1000;
                functiondisplayed(title, type, millis);
                btnstart.setEnabled(false);
                btnnext.setEnabled(true);
                btnstop.setEnabled(true);
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                btnriprendi.setEnabled(true);
                btnstop.setEnabled(false);
            }
        });

        btnriprendi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functiondisplayed(title, type, timeleft);
                btnstop.setEnabled(true);
                btnriprendi.setEnabled(false);
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == n - 1){
                    timer.cancel();
                    timer.onFinish();
                    btnnext.setEnabled(false);
                    btnstop.setEnabled(false);
                    btnriprendi.setEnabled(false);
                    Toast.makeText(getApplication(), "HAI TERMINATO LA TUA ATTIVITA'", Toast.LENGTH_SHORT).show();

                }else {
                    i++;
                    String title = arrayList.get(i).getTitle();
                    String type = arrayList.get(i).getType();
                    String time = arrayList.get(i).getTime();
                    int t = Integer.parseInt(time);
                    long millis = t * 60 * 1000;
                    timer.cancel();
                    timer.onFinish();
                    functiondisplayed(title, type, millis);
                    timer.start();
                }
            }
        });

        btnchiudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void functiondisplayed(String title, String type, long millis){
        final TextView textTitle = findViewById(R.id.title);
        final TextView textType = findViewById(R.id.type);
        final TextView textTime = findViewById(R.id.time);
        textTitle.setText((CharSequence) title);
        textType.setText((CharSequence) type);
        timer = new CountDownTimer(millis, 1000) {
            public void onTick(long millis) {
                timeleft = millis;
                textTime.setText("TEMPO RIMANENTE: " + millis / 1000 + " secondi");
            }

            public void onFinish() {
                textType.setText("TASK TERMINATO");
                textTime.setText("TERMINANTO IL TEMPO");
            }
        }.start();


    }
}
