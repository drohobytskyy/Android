package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<Post> posts;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Post>> call = apiInterface.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()) {

                    Toast.makeText(getApplicationContext(),"An error occurred: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;

                }

                posts = response.body();
                adapter = new RecyclerAdapter(posts);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"An error occurred: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
