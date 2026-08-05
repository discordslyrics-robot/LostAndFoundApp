package com.example.lostfoundmypart.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lostfoundmypart.R;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    MaterialCardView cardProfile, cardReportLost, cardReportFound, cardViewLost, cardViewFound, cardViewSearch, cardReports;
    Button logoutBtn;

    FirebaseAuth auth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();

        // 🔥 If user not logged in → send to login
        if (currentUser == null) {
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_home);

        // Leader's Views
        cardProfile = findViewById(R.id.cardProfile);
        cardReportLost = findViewById(R.id.cardReportLost);
        cardReportFound = findViewById(R.id.cardReportFound);
        cardReports = findViewById(R.id.cardReports);
        logoutBtn = findViewById(R.id.logoutBtn);

        // User's Views
        cardViewLost = findViewById(R.id.cardViewLost);
        cardViewFound = findViewById(R.id.cardViewFound);
        cardViewSearch = findViewById(R.id.cardViewSearch);

        // Logout
        logoutBtn.setOnClickListener(v -> {
            auth.signOut();
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        // Leader's actions
        cardProfile.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
        });

        cardReportLost.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ReportLostItemActivity.class));
        });

        cardReportFound.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, ReportFoundItemActivity.class));
        });

        cardReports.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, MyReportsActivity.class));
        });

        // User's actions
        cardViewLost.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, LostItemsActivity.class));
        });

        cardViewFound.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, FoundItemsActivity.class));
        });

        cardViewSearch.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, SearchActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }
}