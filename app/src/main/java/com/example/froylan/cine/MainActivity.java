package com.example.froylan.cine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
    private RecyclerView ciudadesRecyclerview;
    private CiudadAdapter adapter;
    List<Ciudad>ciudadaes=new ArrayList<>();
    private CineService cineService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ciudadesRecyclerview=(RecyclerView)findViewById(R.id.recycler);
        adapter=new CiudadAdapter(ciudadaes,this);
        ciudadesRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ciudadesRecyclerview.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Retrofit retrofit=getclient();
        cineService= retrofit.create(CineService.class);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getCiudades();

            }
        });
    }
    private void getCiudades(){
        Call<List<Ciudad>> call= cineService.getCiudades();
        call.enqueue(new Callback<List<Ciudad>>() {
            @Override
            public void onResponse(Call<List<Ciudad>> call, Response<List<Ciudad>> response) {
                if(response.isSuccessful()){
                    ciudadaes.clear();
                    ciudadaes.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<List<Ciudad>> call, Throwable t) {

            }
        });
    }

    private Retrofit getclient(){


        String urlBase="http://api.cinepolis.com.mx/Consumo.svc/json/";
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create(getGson()))

                .build();
        return retrofit;
    }

    @NonNull
    protected Gson getGson(){
        return new Gson();
    }
    public interface CineService{
        @GET("ObtenerCiudades")
        Call<List<Ciudad>>  getCiudades();

    }
}
