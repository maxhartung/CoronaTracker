package com.sss.coronatracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private static List<PersonsClass> data;
    Call<List<PersonsClass>> call;
    TextView nr_infectati;
    Button refresh;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        nr_infectati = findViewById(R.id.nr_infectati);
        refresh = findViewById(R.id.bt_refresh);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://covid19.hackout.ro/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        RetrofitClient client = retrofit.create(RetrofitClient.class);
        call = client.cases();

        refresh.setOnClickListener((View v) -> {
                    call = null;
                    Call<List<PersonsClass>> call = client.cases();
                }
        );


        call.enqueue(new Callback<List<PersonsClass>>() {
            @Override
            public void onResponse(Call<List<PersonsClass>> call, Response<List<PersonsClass>> response) {
                List<PersonsClass> persons = response.body();
                Collections.reverse(persons);
                recyclerView.setAdapter(new PersonsListAdapter(persons));
                nr_infectati.setText(getResources().getString(R.string.tw_nr_infectati, String.valueOf(persons.size())));
            }

            @Override
            public void onFailure(Call<List<PersonsClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
