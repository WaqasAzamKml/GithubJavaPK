package com.dozydroid.githubjavapk.api;

import com.dozydroid.githubjavapk.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MIRSAAB on 3/29/2017.
 */

public interface Service {
    @GET("/search/users?q=lang:java+location:pakistan")
    Call<ItemResponse> getItems();
}
