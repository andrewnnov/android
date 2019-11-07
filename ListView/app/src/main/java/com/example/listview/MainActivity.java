package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.colorListView);

        final ArrayList<String> colorArrayList = new ArrayList<>();
        colorArrayList.add("Красный");
        colorArrayList.add("Оранжевый");
        colorArrayList.add("Желтый");
        colorArrayList.add("Зеленый");
        colorArrayList.add("Голубой");
        colorArrayList.add("Синий");
        colorArrayList.add("Фиолетовый");

        ArrayAdapter<String> colorsArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, colorArrayList);

        listView.setAdapter(colorsArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Номер" + position +
                        " - " + colorArrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
