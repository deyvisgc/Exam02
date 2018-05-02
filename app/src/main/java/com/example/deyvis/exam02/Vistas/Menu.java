package com.example.deyvis.exam02.Vistas;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.deyvis.exam02.R;

public class Menu extends Activity {
    GridLayout layout;
    CardView cardView,car1,car2,car3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        layout=(GridLayout)findViewById(R.id.mainGrid);
        cardView=(CardView)findViewById(R.id.uno);
        car1=(CardView)findViewById(R.id.dos);
        car2=(CardView)findViewById(R.id.tres);
        car3=(CardView)findViewById(R.id.cuatro);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Menu.this,Ventass.class);
                startActivity(intent);
            }
        });

        car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Menu.this,Producto.class);
                startActivity(intent);
            }
        });

        car3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Menu.this,Vendedor.class);
                startActivity(intent);

            }
        });

    }


}
