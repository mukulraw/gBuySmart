package com.technuoma.gbuysmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.technuoma.gbuysmart.checkoutPOJO.checkoutBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Membership extends AppCompatActivity {

    Toolbar toolbar;
    Button green, gold, platinum;
    ProgressBar progress;

    String membership = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        toolbar = findViewById(R.id.toolbar2);
        green = findViewById(R.id.button3);
        gold = findViewById(R.id.button4);
        platinum = findViewById(R.id.button5);
        progress = findViewById(R.id.progressBar6);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("Become a Member");
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                membership = "green";
                buyMembership();

            }
        });

        gold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                membership = "gold";
                buyMembership();

            }
        });


        platinum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                membership = "platinum";
                buyMembership();

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        progress.setVisibility(View.VISIBLE);

        Bean b = (Bean) getApplicationContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(b.baseurl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

        Call<getMembershipBean> call = cr.getMembership(SharePreferenceUtils.getInstance().getString("userId"));

        call.enqueue(new Callback<getMembershipBean>() {
            @Override
            public void onResponse(Call<getMembershipBean> call, Response<getMembershipBean> response) {

                if (response.body().getStatus().equals("1")) {
                    String type = response.body().getCurrentMembership();
                    String expiry = response.body().getExpiresOn();

                    green.setEnabled(false);
                    gold.setEnabled(false);
                    platinum.setEnabled(false);

                    if (type.equals("green")) {
                        green.setText("Expires on " + expiry);
                        gold.setText("₹ 3000 for 6 months");
                        platinum.setText("₹ 5000 for 9 months");
                    } else if (type.equals("gold")) {
                        gold.setText("Expires on " + expiry);
                        green.setText("₹ 500 for 3 months");
                        platinum.setText("₹ 5000 for 9 months");
                    } else {
                        platinum.setText("Expires on " + expiry);
                        green.setText("₹ 500 for 3 months");
                        gold.setText("₹ 3000 for 6 months");
                    }

                } else {
                    green.setEnabled(true);
                    gold.setEnabled(true);
                    platinum.setEnabled(true);
                    green.setText("₹ 500 for 3 months");
                    gold.setText("₹ 3000 for 6 months");
                    platinum.setText("₹ 5000 for 9 months");
                }

                progress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<getMembershipBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });


    }

    void buyMembership() {
        progress.setVisibility(View.VISIBLE);

        Bean b = (Bean) getApplicationContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(b.baseurl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

        Call<checkoutBean> call = cr.buyMembership(
                SharePreferenceUtils.getInstance().getString("userId"),
                membership,
                "etsaasdasd"
        );

        call.enqueue(new Callback<checkoutBean>() {
            @Override
            public void onResponse(Call<checkoutBean> call, Response<checkoutBean> response) {
                Toast.makeText(Membership.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                onResume();
                progress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<checkoutBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });
    }

}