package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_fib;
    Button btn_fac;
    EditText et_fibIter;
    Spinner sp_facNum;
    TextView txt_numFib;
    TextView txt_numFac;
    TextView txt_hFib;
    TextView txt_hFac;
    ImageButton ibtn_bibl;
    static int contFib;
    static int contFac;


    @Override
    public void onResume(){
        super.onResume();


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        contFac++;
        contFib++;
        setContentView(R.layout.activity_main);
        btn_fac = findViewById( R.id.btn_fac );
        btn_fib = findViewById( R.id.btn_go );
        et_fibIter = findViewById( R.id.et_iterations );
        sp_facNum = findViewById( R.id.sp_fac );
        txt_hFac = findViewById( R.id.txt_hfac );
        txt_hFib = findViewById( R.id.txt_hfib );
        txt_numFac = findViewById( R.id.txt_contFac );
        txt_numFib = findViewById( R.id.txt_contFib );
        ibtn_bibl = findViewById( R.id.ibtn_bibl );

        ibtn_bibl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent bibl_intent = new Intent( v.getContext(), Bibliografia.class );
                startActivity( bibl_intent );

            }
        });

        btn_fib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                int iterationsF = Integer.parseInt( et_fibIter.getText().toString().trim() );
                bundle.putInt("iterations",iterationsF);
                Intent fib_intent = new Intent( v.getContext(), fib_seq.class );
                fib_intent.putExtras(bundle);
                startActivity(fib_intent);

            }
        });
        btn_fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numFac = (Integer)sp_facNum.getSelectedItem();
                Bundle bundle = new Bundle();
                bundle.putInt("numFac",numFac);
                Intent fac_intent = new Intent( v.getContext(), facto.class );
                fac_intent.putExtras(bundle);
                startActivity(fac_intent);
            }
        });
    }
}
