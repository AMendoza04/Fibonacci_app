package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class fib_seq extends AppCompatActivity {

    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fib_seq);

        Bundle bund = getIntent().getBundleExtra("bundle");
        ll = findViewById( R.id.vll_fibSeq );



        int it = bund.getInt("iterations");
        if( it == 1 )
        {
            addToView( 0 );
        }
        else
        {
            addToView( 0 );
            fib_exe( 0 , 1, 1, it );
        }
    }

    private void addToView(int i)
    {
        TextView tv_number = new TextView(this);
        String s_number = "" + i;
        tv_number.setText(s_number);
        ll.addView( tv_number );
    }


    public void fib_exe( int num_a , int num_b , int it_p , int it_t)
    {
        //addToView( num_b );

        if(it_p == it_t)
        {
            return;
        }

        addToView( num_b );
        fib_exe(num_b, num_a + num_b, it_p + 1 , it_t );
    }
}
