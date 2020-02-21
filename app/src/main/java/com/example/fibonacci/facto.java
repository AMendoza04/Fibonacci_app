package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class facto extends AppCompatActivity {

    TextView tv_result;
    String fib_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facto);
        tv_result = findViewById( R.id.tv_fibResult );
        fib_text = "";

        Bundle bund = getIntent().getBundleExtra("bundle");
        int numFac = bund.getInt("numFac");

        int result = make_fac( 1 , numFac );

        fib_text = fib_text + "\n" + result;

        tv_result.setText( fib_text );

    }

    private int make_fac(int numFac_actual, int numFac) {
        fib_text = fib_text + numFac_actual;
        if( numFac == 1)
            return 1;

        fib_text = fib_text + "*";
        return numFac * make_fac( numFac_actual + 1, numFac - 1);
    }
}
