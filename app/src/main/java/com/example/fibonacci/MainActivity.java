package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_fib;
    Button btn_fac;
    Button btn_paises;
    EditText et_fibIter;
    Spinner sp_facNum;
    TextView txt_numFib;
    TextView txt_numFac;
    TextView txt_hFib;
    TextView txt_hFac;
    ImageButton ibtn_bibl;
    static int contFib = 0;
    static int contFac = 0;
    static Date currentDnTFib;
    static Date currentDnTFac;
    String hFib;
    String hFac;
    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        if( contFac >= 1 ) txt_hFac.setText( hFac );
        if( contFib >= 1 ) txt_hFib.setText( hFib );
        String aux = "";
        aux = aux + contFib;
        txt_numFib.setText(aux);
        aux = "";
        aux = aux + contFac;
        txt_numFac.setText(aux);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);
        btn_fac = findViewById( R.id.btn_fac );
        btn_fib = findViewById( R.id.btn_go );
        btn_paises = findViewById( R.id.btn_paises );
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

                try {
                    int iterationsF = Integer.parseInt( et_fibIter.getText().toString().trim() );
                    bundle.putInt("iterations",iterationsF);
                    Intent fib_intent = new Intent( v.getContext(), fib_seq.class );
                    fib_intent.putExtra("bundle", bundle);

                    contFib++;

                    String pat = "dd/MM/yyyy HH:mm";
                    DateFormat df = new SimpleDateFormat(pat);


                    currentDnTFib = Calendar.getInstance().getTime();
                    hFib = df.format( currentDnTFib );

                    startActivity(fib_intent);
                }
                catch(Exception e)
                {
                    Toast.makeText( v.getContext() , "Not valid iterations", Toast.LENGTH_LONG ).show();
                }


            }
        });
        btn_fac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numFac = Integer.parseInt(sp_facNum.getSelectedItem().toString());
                Bundle bundle = new Bundle();
                bundle.putInt("numFac",numFac);
                Intent fac_intent = new Intent( v.getContext(), facto.class );
                fac_intent.putExtra("bundle",bundle);

                contFac++;

                String pat = "dd/MM/yyyy HH:mm";
                DateFormat df = new SimpleDateFormat(pat);


                currentDnTFac = Calendar.getInstance().getTime();
                hFac = df.format( currentDnTFac );
                startActivity(fac_intent);
            }
        });

        btn_paises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent paises_intent = new Intent( v.getContext(), paisesAll.class );
                startActivity( paises_intent );
            }
        });
    }
}
