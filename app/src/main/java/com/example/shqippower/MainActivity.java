package com.example.shqippower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);

        ListActivity l1 = new ListActivity("Matematica", "Rimetto apposto gli appunti", "1");
        ListActivity l2 = new ListActivity("Matematica","Sottolineo cose importanti","15");
        ListActivity l3 = new ListActivity("Matematica","Cerco termini dubbi","10");
        ListActivity l4 = new ListActivity("Matematica","Esercizi","60");
        ListActivity l5 = new ListActivity("Matematica","Studio della teoria","80");

        final ArrayList<ListActivity> arrayList=new ArrayList<>(5);
        arrayList.add(0, l1);
        arrayList.add(1, l2);
        arrayList.add(2, l3);
        arrayList.add(3, l4);
        arrayList.add(4, l5);

        ListAdapter adapter = new ListAdapter(this, R.layout.layout_list, arrayList);
        listView.setAdapter(adapter);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DialogPotente.class);
                intent.putExtra("list", arrayList);
                startActivity(intent);
            }
        });

    }
}