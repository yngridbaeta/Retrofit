package com.example.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCadastro extends AppCompatActivity {

    EditText edtId, edtNome, edtRaca, edtImagem;
    Button btnConsultarNome, btnInserir, btnAlterar, btnExcluir, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtId = findViewById(R.id.edtId);
        edtNome = findViewById(R.id.edtNome);
        edtRaca = findViewById(R.id.edtRaca);
        edtImagem = findViewById(R.id.edtImagem);

        btnConsultarNome = findViewById(R.id.btnConsultarNome);
        btnConsultarNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consultarDogNome();
            }
        });


        btnInserir = findViewById(R.id.btnInserir);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incluirDog();
            }
        });

        btnAlterar = findViewById(R.id.btnAlterar);
        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alterarDog();
            }
        });

        btnExcluir = findViewById(R.id.btnExcluir);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excluirDog();
            }
        });

        btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
    }

    private void limpar(){
        edtId.setText("");
        edtNome.setText("");
        edtRaca.setText("");
        edtImagem.setText("");
    }

    private void consultarDogNome(){

    }

    private void incluirDog(){

    }

    private void alterarDog(){

    }

    private void excluirDog(){

    }
}