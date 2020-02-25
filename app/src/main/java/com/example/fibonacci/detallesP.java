package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class detallesP extends AppCompatActivity {

    TextView tv_detallesP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_p);

        tv_detallesP = findViewById( R.id.tv_detallesP );

        Bundle bnd_detallesP = getIntent().getBundleExtra("bund");
        String detalles = bnd_detallesP.getString("pais");

        tv_detallesP.setText( detalles );
    }
}
