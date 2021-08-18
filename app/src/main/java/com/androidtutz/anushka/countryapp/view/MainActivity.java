package com.androidtutz.anushka.countryapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidtutz.anushka.countryapp.R;
import com.androidtutz.anushka.countryapp.model.Info;
import com.androidtutz.anushka.countryapp.model.Result;
import com.androidtutz.anushka.countryapp.service.GetCountryDataService;
import com.androidtutz.anushka.countryapp.service.RetrofitInstance;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText countryCodeEditText;
    TextView countryNameTextView;
    Button submitButton;
    Button clearButton;

    String countryCode;
    private Result result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryCodeEditText = (EditText) findViewById(R.id.etCode);
        countryNameTextView = (TextView) findViewById(R.id.tvCountryName);
        submitButton = (Button) findViewById(R.id.btnSubmit);
        clearButton = (Button) findViewById(R.id.btnClear);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                countryCode = countryCodeEditText.getText().toString();

                GetCountryDataService getCountryDataService = RetrofitInstance.getService();


                Call<Info> call = getCountryDataService.getResultByAlpha2Code(countryCode);


                call.enqueue(new Callback<Info>() {
                    @Override
                    public void onResponse(Call<Info> call, Response<Info> response) {

                        Info info = response.body();

                        if(info !=null && info.getRestResponse() != null) {

                            result = info.getRestResponse().getResult();

                            countryNameTextView.setText(result.getName());

                        }

                    }

                    @Override
                    public void onFailure(Call<Info> call, Throwable t) {

                    }
                });
            }
        });


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                countryNameTextView.setText(" ");
                countryCodeEditText.setText(" ");
            }
        });
    }
}
