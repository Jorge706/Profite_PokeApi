package com.example.profite;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonApiInterface {

    //las interfaces son solo lo que queremos cumplir
    @GET("pokemon")//esto es para indicar que se va a hacer una peticion get a la api, y que se va a hacer a la ruta pokemon, osea a https://pokeapi.co/api/v2/pokemon
    Call<ServicioPokemon> getPokemon(@Query("limit") int limit, @Query("offset") int offset);//esto es para indicar que se va a hacer una peticion get a la api, y que se va a hacer a la ruta pokemon, osea a https://pokeapi.co/api/v2/pokemon
//el @GET es para indicar que se va a hacer una peticion get a la api, y que se va a hacer a la ruta pokemon, osea a https://pokeapi.co/api/v2/pokemon
    //el Call<ServicioPokemon> es para indicar que se va a devolver un objeto de tipo ServicioPokemon
    //el @Query("limit") int limit, @Query("offset") int offset es para indicar que se va a pasar como parametro a la api, el limit y el offset
    //el limit es para indicar la cantidad de pokemones que se van a obtener, y el offset es para indicar desde que pokemon se va a empezar a obtener
    //el limit y el offset son parametros que se pasan a la api, y se pasan como parametros de la ruta, osea que se pasan asi: https://pokeapi.co/api/v2/pokemon?limit=100&offset=0

/*
    @GET("ramiro174/feeds/oficina.luz/data")
    Call<List<DataSensor>> getDatasensor(@Header("X-Auth-Token") String aioKey);//esto es un metodo que devuelve un objeto de tipo servicio pokemon, que es la clase que creamos
    //esto es una clase de tipo interfaz, osea que no tiene implementacion, solo declara los metodos que se van a usar
    //osea si para crear a un pato tiene que tener el metodo volar pero

    //en las clases de tipo interfaz los metodos no tienen cuerpo, solo se declaran
    int suma();//int es el tipo de dato que devuelve el metodo, y suma es el nombre del metodo
    List<String > getAlumnos();//List<String > es una lista de string que devuelve el metodo getAlumnos


    Call<List<DataSensor>> getDatasensor(@Header("X-Auth-Token") String aioKey);//Call<List<DataSensor>> el call es para que se pueda hacer la llamada a la api, y el list es para que devuelva una lista de datasensor
*/
}
