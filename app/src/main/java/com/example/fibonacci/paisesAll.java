package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class paisesAll extends AppCompatActivity {


    ArrayList<Pais> paises;
    ArrayList<String> paisesN;
    ListView lv_paises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises_all);

        paises = new ArrayList<>();
        paisesN = new ArrayList<>();

        JSONObject json = null;
        try {
            json = new JSONObject(loadJSONFromAsset());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            createPaises( json );
        } catch (JSONException e) {
            e.printStackTrace();
        }


        ArrayAdapter< String > adpt_paises = new ArrayAdapter<>( this, android.R.layout.simple_list_item_1, paisesN );
        lv_paises = findViewById( R.id.lv_paises );
        lv_paises.setAdapter( adpt_paises );
        lv_paises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bnd_paisD = new Bundle();
                bnd_paisD.putString("pais", paises.get(position).toString() );
                Intent int_paisD = new Intent( view.getContext()/* getBaseContext()*/, detallesP.class );
                int_paisD.putExtra("bund",bnd_paisD);
                startActivity( int_paisD );
            }
        });




    }

    private String loadJSONFromAsset() {

        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    private void createPaises(JSONObject json) throws JSONException {

        JSONArray paisesJsonArray = json.getJSONArray("paises");
        for (int i = 0; i < paisesJsonArray.length(); i++) {
            JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
            String capital = jsonObject.getString("capital");
            String nombre = jsonObject.getString("nombre_pais");
            String nombre_i = jsonObject.getString("nombre_pais_int");
            String sigla = jsonObject.getString("sigla");
            System.out.println( nombre );
            paisesN.add( nombre );
            Pais p = new Pais( nombre, nombre_i, capital, sigla );
            paises.add( p );
        }


    }
}
