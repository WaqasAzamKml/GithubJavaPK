package com.dozydroid.githubjavapk.controller;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.dozydroid.githubjavapk.ItemAdapter;
import com.dozydroid.githubjavapk.R;
import com.dozydroid.githubjavapk.api.GitHubClient;
import com.dozydroid.githubjavapk.api.Service;
import com.dozydroid.githubjavapk.model.Item;
import com.dozydroid.githubjavapk.model.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMain;
    private ProgressDialog dialog;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews(){
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading data...");
        dialog.setCancelable(false);
        dialog.show();
        recyclerViewMain = (RecyclerView) findViewById(R.id.recyclerMain);
        recyclerViewMain.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewMain.smoothScrollToPosition(0);
        loadJSON();
    }

    private void loadJSON(){
        try{
            GitHubClient apiClient = new GitHubClient();
            Service apiService = apiClient.getClient().create(Service.class);
            Call<ItemResponse> call = apiService.getItems();
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    List<Item> items = response.body().getItems();
                    recyclerViewMain.setAdapter(new ItemAdapter(items, getApplicationContext()));
                    recyclerViewMain.smoothScrollToPosition(0);
                    dialog.hide();
                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                    Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
                    dialog.hide();
                }
            });
        } catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            dialog.hide();
        }
    }
}
