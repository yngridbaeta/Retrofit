package com.example.apiretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        String strNome = edtNome.getText().toString();

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class); //chamamos a classe service
        Call<Dog> call = service.selecionarNome(strNome);
        call.enqueue(new Callback<Dog>() {
            @Override
            public void onResponse(Call<Dog> call, Response<Dog> response) {
                if(response.isSuccessful()){
                    Dog dogRespostaNode = response.body(); //recebe o body inteiro do dog

                    edtId.setText(dogRespostaNode.getId().toString());
                    edtNome.setText(dogRespostaNode.getNome().toString());
                    edtRaca.setText(dogRespostaNode.getRaca().toString());
                    edtImagem.setText(dogRespostaNode.getImage().toString());



                }
                else {
                    Toast.makeText(ActivityCadastro.this, "Erro na consulta!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Dog> call, Throwable t) {
                Toast.makeText(ActivityCadastro.this, "Ocorreu erro de requisição no Node:" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void incluirDog(){
        String strId = edtId.getText().toString();
        String strNome = edtNome.getText().toString();
        String strRaca = edtRaca.getText().toString();
        String strImagem = edtImagem.getText().toString();

        Dog dog = new Dog(strId, strNome, strRaca, strImagem);
        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class); //chamamos a classe service
        Call<Dog> call = service.incluirDog(dog);
        call.enqueue(new Callback<Dog>() {
            @Override
            public void onResponse(Call<Dog> call, Response<Dog> response) {
                if(response.isSuccessful()){
                    Dog dogRespostaNode = response.body(); //recebe o body inteiro do dog

                    dogRespostaNode.getId().toString();
                    dogRespostaNode.getNome().toString();
                    dogRespostaNode.getRaca().toString();
                    dogRespostaNode.getImage().toString();

                    Gson gson = new GsonBuilder().create(); //criar o Gson
                    String jsonRespostaNode = gson.toJson(dogRespostaNode);

                    TextView tvJson = findViewById(R.id.tvJson);
                    tvJson.setText(jsonRespostaNode);

                    TextView tvObjeto = findViewById(R.id.tvObjeto);
                    tvObjeto.setText("");
                    tvObjeto.append(dogRespostaNode.getId().toString() + "\n");
                    tvObjeto.append(dogRespostaNode.getNome().toString() + "\n");
                    tvObjeto.append(dogRespostaNode.getRaca().toString()+ "\n");
                    tvObjeto.append(dogRespostaNode.getImage().toString()+ "\n");
                }
                else {
                    Toast.makeText(ActivityCadastro.this, "Erro na inclusão!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Dog> call, Throwable t) {
                Toast.makeText(ActivityCadastro.this, "Ocorreu erro de requisição no Node:" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void alterarDog(){
        String strId = edtId.getText().toString();
        String strNome = edtNome.getText().toString();
        String strRaca = edtRaca.getText().toString();
        String strImagem = edtImagem.getText().toString();

        Dog dog = new Dog(strId, strNome, strRaca, strImagem);
        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class); //chamamos a classe service
        Call<Dog> call = service.alterarDog(strId, dog);
        call.enqueue(new Callback<Dog>() {
            @Override
            public void onResponse(Call<Dog> call, Response<Dog> response) {
                if(response.isSuccessful()){
                    Dog dogRespostaNode = response.body(); //recebe o body inteiro do dog

                    dogRespostaNode.getId().toString();
                    dogRespostaNode.getNome().toString();
                    dogRespostaNode.getRaca().toString();
                    dogRespostaNode.getImage().toString();

                    Gson gson = new GsonBuilder().create(); //criar o Gson
                    String jsonRespostaNode = gson.toJson(dogRespostaNode);

                    TextView tvJson = findViewById(R.id.tvJson);
                    tvJson.setText(jsonRespostaNode);

                    TextView tvObjeto = findViewById(R.id.tvObjeto);
                    tvObjeto.setText("");
                    tvObjeto.append(dogRespostaNode.getId().toString() + "\n");
                    tvObjeto.append(dogRespostaNode.getNome().toString() + "\n");
                    tvObjeto.append(dogRespostaNode.getRaca().toString()+ "\n");
                    tvObjeto.append(dogRespostaNode.getImage().toString()+ "\n");
                }
                else {
                    Toast.makeText(ActivityCadastro.this, "Erro na inclusão!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Dog> call, Throwable t) {
                Toast.makeText(ActivityCadastro.this, "Ocorreu erro de requisição no Node:" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }


    private void excluirDog(){

        String strId = edtId.getText().toString(); // pega o id que o usuário digitou

        Service service = RetrofitConfig.getRetrofitInstance().create(Service.class); //rota

        Call<Dog> call = service.excluirDog(strId);

        call.enqueue(new Callback<Dog>() {
            @Override
            public void onResponse(Call<Dog> call, Response<Dog> response) {
                if(response.isSuccessful()){
                    Dog dogRespostaNode = response.body();

                    dogRespostaNode.getId().toString();
                    dogRespostaNode.getNome().toString();
                    dogRespostaNode.getRaca().toString();
                    dogRespostaNode.getImage().toString();

                    Gson gson = new GsonBuilder().create();

                    String json = gson.toJson(dogRespostaNode);
                    TextView tvJson = findViewById(R.id.tvJson);
                    tvJson.setText(json);

                    TextView tvObjeto = findViewById(R.id.tvObjeto);
                    tvObjeto.setText("");
                    tvObjeto.append(dogRespostaNode.getId().toString() + "\n");
                    tvObjeto.append(dogRespostaNode.getNome().toString() + "\n");
                    tvObjeto.append(dogRespostaNode.getRaca().toString()+ "\n");
                    tvObjeto.append(dogRespostaNode.getImage().toString()+ "\n");
                }
                else {
                    Toast.makeText(ActivityCadastro.this, "Erro na exclusão!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Dog> call, Throwable t) {
                Toast.makeText(ActivityCadastro.this, "Ocorreu erro de requisição no Node:" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}