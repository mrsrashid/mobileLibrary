package com.example.libraryprogram;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RetrofitAPI {
    // as we are making a post request to post a data
    // and along with that we are passing a parameter as users
    @POST("users/userAdd/")

    //on below line we are creating a method to post our data.
    Call<ApiResponse> createPost(@Body DataModel dataModal);
}
