package com.hermesis.christian.practica11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler)
    RecyclerView rv;

    public static final List<artista> datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        artista ar = new artista();
        ar.setName("Maria");
        ar.setPhone("1234567890");
        ar.setRating(3.5);
        datos.add(ar);
        ar = new artista();
        ar.setName("Mayra");
        ar.setPhone("1234567834");
        ar.setRating(5);
        datos.add(ar);

        LlamarRecycler();
        }

    public void LlamarRecycler(){
        if(datos != null)
        {
            adaptador_recicler ar = new adaptador_recicler(this,datos);
            LinearLayoutManager Llm = new LinearLayoutManager(this) ;
            rv.setLayoutManager(Llm);
            rv.setAdapter(ar);
        }
    }
}
