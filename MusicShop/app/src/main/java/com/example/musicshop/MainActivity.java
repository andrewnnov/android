package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    //позволяет связать спинер а ArrayList
    ArrayAdapter spinnerAdapter;
    String goodsName;
    double price;

    HashMap goodsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner();
        createMap();




    }

    void createMap() {
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard", 1000.0);
    }

    public void increaseQuantity(View view) {
        quantity = quantity + 1;
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);

        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    public void decreaseButton(View view) {
        quantity = quantity - 1;
        if(quantity < 0) {
            quantity = 0;
        }
        TextView quantityTextView = findViewById(R.id.quantityTextView);
        quantityTextView.setText("" + quantity);

        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //присваиваем переменной выбор из спинера
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceTextView);
        priceTextView.setText("" + quantity * price);

        ImageView goodsImageView = findViewById(R.id.goodsImageView);


        switch (goodsName) {
            case "guitar":
                goodsImageView.setImageResource(R.drawable.guitar);
                break;

            case "drums":
                goodsImageView.setImageResource(R.drawable.drums);
                break;

            case "keyboard":
                goodsImageView.setImageResource(R.drawable.keyboard);
                break;

            default:
                goodsImageView.setImageResource(R.drawable.guitar);
                break;

        }
    }

    void createSpinner() {

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
