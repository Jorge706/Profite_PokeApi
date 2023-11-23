package com.example.profite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.profite.R;
import com.example.profite.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class pokemonAdapter extends RecyclerView.Adapter<pokemonAdapter.PokemonHolder> {

    private List<Pokemon> pokemons;// que es List<Pokemon>: https://www.geeksforgeeks.org/list-interface-java-examples/ , osea es una lista de objetos de tipo Pokemon

    public pokemonAdapter(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }//esto lo que hace es que cuando se crea una instancia de pokemonAdapter, se le pasa una lista de pokemones

    @NonNull
    @Override
    public PokemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder, parent, false);//esto es para inflar el layout de cada item de la lista, de divide en 3 partes: 1) el layout que se va a inflar, 2) el ViewGroup al que pertenece, 3) si se va a inflar en el ViewGroup o no
        return new PokemonHolder(view);
    }
//el parent.getContext() es para obtener el contexto del ViewGroup, el inflate es para inflar el layout, el false es para que no se infle en el ViewGroup
    //el viewgroup es el recyclerview, el view es el layout que se va a inflar, el false es para que no se infle en el viewgroup, sino que se infle en el recyclerview
    @Override
    public void onBindViewHolder(@NonNull PokemonHolder holder, int position) {//esto es para asignar los valores de cada item de la lista
        Pokemon pokemon = pokemons.get(position);//esto es para obtener el pokemon de la lista de pokemones, en la posicion position
        holder.name.setText(pokemon.getName());//esto es para asignar el nombre del pokemon al textview del layout
        Picasso.get().load(pokemon.getImagenUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder {//esto es para obtener los elementos del layout
        TextView name;

        ImageView img;
        public PokemonHolder(@NonNull View itemView) {//esto es para obtener los elementos del layout
            super(itemView);
            name = itemView.findViewById(R.id.textView1);
            img = itemView.findViewById(R.id.textView2);
        }
    }
}