package com.dozydroid.githubjavapk.api;

import com.dozydroid.githubjavapk.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MIRSAAB on 3/29/2017.
 */

public interface Service {
    // Search all users with language Java from location Pakistan.
    // Per page 500. It means query run one time will return max 500.
    // Sort by number of followers, descending order (default).
    @GET("/search/users?q=language:java+location:pakistan&per_page=500&sort=followers")
    Call<ItemResponse> getItems();
}
