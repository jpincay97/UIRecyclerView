package com.example.uirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.uirecyclerview.Adapter.AdaptadorOfertaLaboral;
import com.example.uirecyclerview.Modelo.OfertaLaboral;
import com.example.uirecyclerview.WebService.Asynchtask;
import com.example.uirecyclerview.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    ArrayList<OfertaLaboral> listaOfertasLaborales;
    RecyclerView recyclerOfertasLaborales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerOfertasLaborales = (RecyclerView) findViewById(R.id.rvOfertasLaborales);
        recyclerOfertasLaborales.setLayoutManager(new LinearLayoutManager(this));

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://api.jsonbin.io/b/5efe857d0bab551d2b6af8b1",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }
    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<OfertaLaboral> lstOfertas = new ArrayList<OfertaLaboral> ();

        try {
            JSONArray JSONlista =  new JSONArray(result);
            lstOfertas = OfertaLaboral.JsonObjectsBuild(JSONlista);
            AdaptadorOfertaLaboral adapatorOferta = new AdaptadorOfertaLaboral(lstOfertas,MainActivity.this);
            recyclerOfertasLaborales.setAdapter(adapatorOferta);
        }catch (JSONException e)
        {
            Toast.makeText(this.getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}
