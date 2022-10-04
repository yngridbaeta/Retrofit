package com.example.apiretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private List<Dog> listaDog;
    Context context;

    public GridViewAdapter(Context context, List<Dog> parametroListaDog){
        this.context = context;
        this.listaDog = parametroListaDog;
    }



    //retorna o tamanho da lista
    @Override
    public int getCount() {
        return listaDog.size();
    }

    //retorna a posicao somente de um dog
    @Override
    public Object getItem(int posicao) {
        return listaDog.get(posicao);
    }

    //retorna id do objeto
    @Override
    public long getItemId(int posicao) {
        return posicao;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_gridview, viewGroup, false);
        }

        TextView tvNome = view.findViewById(R.id.tvNome);
        TextView tvRaca = view.findViewById(R.id.tvRaca);
        ImageView dogImageView = view.findViewById(R.id.dogImageView);


        final Dog dog = listaDog.get(posicao);

        tvNome.setText(dog.getNome());
        tvRaca.setText(dog.getRaca());

        if(dog.getImage() != null && dog.getImage().length() > 0){
            Picasso.get().load(dog.getImage()).into(dogImageView);
        } else {
            Toast.makeText(context, "URL da imagem está vazia", Toast.LENGTH_LONG).show();
        }

        return view;
    }
}
