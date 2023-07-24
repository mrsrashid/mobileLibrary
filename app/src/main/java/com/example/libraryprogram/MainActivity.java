package com.example.libraryprogram;


import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext,
    // button, textview and progressbar.
    private EditText userIdEdt, firstNameEdt, lastNameEdt,phoneNumberEdt, emailEdt, addressEdt, genderEdt;
    private Button postDataBtn;
    private TextView responseTV;
    private ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing our views
        userIdEdt = findViewById(R.id.edit_text_id);
        firstNameEdt = findViewById(R.id.firstname_edit_text);
        lastNameEdt = findViewById(R.id.lastname_edit_text);
        phoneNumberEdt = findViewById(R.id.phonenumber_edit_text);
        emailEdt = findViewById(R.id.email_edit_text);
        addressEdt = findViewById(R.id.address_edit_text);
        genderEdt = findViewById(R.id.gender_edit_text);
        postDataBtn = findViewById(R.id.idBtnPost);
        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);

        // adding on click listener to our button.
        postDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validating if the text field is empty or not.
                if (userIdEdt.getText().toString().isEmpty() && firstNameEdt.getText().toString().isEmpty()
                        && lastNameEdt.getText().toString().isEmpty() && phoneNumberEdt.getText().toString().isEmpty()
                        && emailEdt.getText().toString().isEmpty() && addressEdt.getText().toString().isEmpty()
                        && genderEdt.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all  values", Toast.LENGTH_SHORT).show();
                    return;
                }
//                System.out.println(Integer.valueOf(userIdEdt.getText().toString()));
                // calling a method to post the data and passing our name and job.
                postData(Integer.valueOf(userIdEdt.getText().toString()), firstNameEdt.getText().toString(), lastNameEdt.getText().toString(),
                        phoneNumberEdt.getText().toString(), emailEdt.getText().toString(), addressEdt.getText().toString(),
                        genderEdt.getText().toString());
            }
        });
    }

    private void postData(int userId, String firstName, String lastName, String phoneNumber,
                          String email, String address, String gender) {

        // below line is for displaying our progress bar.
        loadingPB.setVisibility(View.VISIBLE);

        // on below line we are creating a retrofit
        // builder and passing our base url
        // Get the Retrofit API service instance
        RetrofitAPI apiService = ApiClient.getApiService();
        // below line is to create an instance for our retrofit api class.


        // passing data from our text fields to our modal class.
        DataModel modal = new DataModel(userId, firstName, lastName, phoneNumber, email, address, gender);

        // calling a method to create a post and passing our modal class.
        // Make the POST request
        Call<ApiResponse> call = apiService.createPost(modal);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    // Process the successful response
                    ApiResponse apiResponse = response.body();
                    if (apiResponse != null) {
                        String message = apiResponse.getMessage();
                        // Handle the success message
                        // e.g., show a toast, update UI, etc.
                    }
                } else {
                    // Handle the error response
                    // e.g., show an error message, update UI, etc.
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Handle the failure
                // e.g., show an error message, update UI, etc.
            }
        });
    }
    }

