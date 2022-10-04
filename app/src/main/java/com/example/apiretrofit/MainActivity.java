package com.example.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private GridView dogGridView;
    private FloatingActionButton fab;
    private GridViewAdapter adapter;

    public void populateGridView(List<Dog> listaDog){
        dogGridView = findViewById(R.id.dogGridView);
        adapter = new GridViewAdapter(this, listaDog);
        dogGridView.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar myProgressBar = findViewById(R.id.myProgressBar); //representa o progressBar.xml

        myProgressBar.setIndeterminate(true); //vai rodar
        myProgressBar.setVisibility(View.VISIBLE); //vai estar visível e funcionando

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chama a activity Cadastro

                Intent intent = new Intent(MainActivity.this, ActivityCadastro.class);
                startActivity(intent);
            }
        });

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class);

        //pegar a rota no Node de forma asyncrona
        Call<List<Dog>> call = service.getDog();
        call.enqueue(new Callback<List<Dog>>() {
            @Override
            public void onResponse(Call<List<Dog>> call, Response<List<Dog>> response) {

                if(response.isSuccessful()){
                    myProgressBar.setVisibility(View.GONE);
                    populateGridView(response.body());
                }
                else{
                    String errorMessage = response.errorBody().toString();
                    Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Dog>> call, Throwable t) {
                myProgressBar.setVisibility(View.GONE);
                String messageProblem = t.getMessage().toString();
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}