package com.example.profite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.profite.adapter.pokemonAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPokemon();
    }




    private void getPokemon() {



        Retrofit retrofit = new Retrofit.Builder()//esto es para crear una instancia de retrofit
                .baseUrl("https://pokeapi.co/api/v2/")//esto es para indicar la url base de la api
                .addConverterFactory(GsonConverterFactory.create())//esto es para indicar que se va a usar el convertidor de gson
                .build();//esto es para construir la instancia de retrofit

        PokemonApiInterface pokemonRequetInterface = retrofit.create(PokemonApiInterface.class);//esto es para crear una instancia de la interfaz de la api

        Call<ServicioPokemon> call = pokemonRequetInterface.getPokemon(150, 0);
// El CAll es para hacer la llamada a la api, y el ServicioPokemon es para indicar que se va a devolver un objeto de tipo ServicioPokemon
        call.enqueue(new Callback<ServicioPokemon>() {// metodo enqueue es para hacer la llamada asincrona a la api, o en segundo plano, el callback es una accion que se ejecuta cuando se obtiene una respuesta de la api
            //execute es para hacer la llamada sincrona a la api, osea que se hace en primer plano, y no se puede hacer en el hilo principal, osea que se tiene que hacer en un hilo secundario
            @Override
            public void onResponse(Call<ServicioPokemon> call, Response<ServicioPokemon> response) {
                if (response.isSuccessful()) {
                    ServicioPokemon servicioPokemon = response.body();
                    // Crear una instancia del adaptador con los datos de Pokemon
                    pokemonAdapter adapter = new pokemonAdapter(servicioPokemon.getResults());

                    // Obtener una referencia a tu RecyclerView
                    RecyclerView recyclerView = findViewById(R.id.RecyclerView);

                    // Establecer el adaptador en tu RecyclerView
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<ServicioPokemon> call, Throwable t) {

            }
        });
    }
}