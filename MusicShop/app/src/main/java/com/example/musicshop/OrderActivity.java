package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //setTitle("Your order!");

        //получаем интент запустивший активити
        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userName");
        String goodsName = receivedOrderIntent.getStringExtra("goodsName");
        int quantity = receivedOrderIntent.getIntExtra("quantity", 0);
        double orderPrice = receivedOrderIntent.getDoubleExtra("orderPrice", 0.0);
        double price = receivedOrderIntent.getDoubleExtra("price", 0.0);
        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText("Customer Name: " + userName + "\n"  +
                "Goods name: " + goodsName + "\n" +
                "Quantity: " + quantity + "\n" +
                "Price : " + price + "\n" +
                "Oder price: " + orderPrice);
    }
}
