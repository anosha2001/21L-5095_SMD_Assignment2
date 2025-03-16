package com.example.cvbuildersmdassigment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CVPreview extends AppCompatActivity {

    TextView tvName, tvEmail, tvPhone, tvGender, tvDegree, tvInstitution, tvCompanyName,
            tvJobTitle, tvYearsExperience, tvCert, tvIssuer, tvRefName, tvRefContact, tvSummary;
    Button btnBack, btnSavePDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cvpreview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvGender = findViewById(R.id.tvGender);
        tvDegree = findViewById(R.id.tvDegree);
        tvInstitution = findViewById(R.id.tvInstitution);
        tvCompanyName = findViewById(R.id.tvCompanyName);
        tvJobTitle = findViewById(R.id.tvJobTitle);
        tvYearsExperience = findViewById(R.id.tvYearsExperience);
        tvCert = findViewById(R.id.tvCert);
        tvIssuer = findViewById(R.id.tvIssuer);
        tvRefName = findViewById(R.id.tvRefName);
        tvRefContact = findViewById(R.id.tvRefContact);
        tvSummary = findViewById(R.id.tvSummary);

        // Initialize Buttons
        btnBack = findViewById(R.id.btnBack);
        btnSavePDF = findViewById(R.id.btnSavePDF);

        // Get data from Intent
        Intent intent = getIntent();
        tvName.setText("Name: " + intent.getStringExtra("name"));
        tvEmail.setText("Email: " + intent.getStringExtra("email"));
        tvPhone.setText("Phone: " + intent.getStringExtra("phone"));
        tvGender.setText("Gender: " + intent.getStringExtra("gender"));
        tvDegree.setText("Degree: " + intent.getStringExtra("degree"));
        tvInstitution.setText("Institution: " + intent.getStringExtra("institution"));
        tvCompanyName.setText("Company: " + intent.getStringExtra("companyname"));
        tvJobTitle.setText("Job Title: " + intent.getStringExtra("jobtitle"));
        tvYearsExperience.setText("Years of Experience: " + intent.getStringExtra("yearsexperience"));
        tvCert.setText("Certificate: " + intent.getStringExtra("cert"));
        tvIssuer.setText("Issued by: " + intent.getStringExtra("issuer"));
        tvRefName.setText("Referee Name: " + intent.getStringExtra("refname"));
        tvRefContact.setText("Referee Contact: " + intent.getStringExtra("refcontact"));
        tvSummary.setText("Summary: " + intent.getStringExtra("summary"));

        // Back button functionality
        btnBack.setOnClickListener(v -> finish());

        // Save CV as PDF (sharing functionality)
        btnSavePDF.setOnClickListener(view -> {
            // Get text from TextViews
            String cvDetails = tvName.getText().toString() + "\n" +
                    tvEmail.getText().toString() + "\n" +
                    tvPhone.getText().toString() + "\n" +
                    tvGender.getText().toString() + "\n\n" +
                    "Education: \n" +
                    tvDegree.getText().toString() + "\n" +
                    tvInstitution.getText().toString() + "\n\n" +
                    "Experience: \n" +
                    tvCompanyName.getText().toString() + "\n" +
                    tvJobTitle.getText().toString() + "\n" +
                    tvYearsExperience.getText().toString() + "\n\n" +
                    "Certification: \n" +
                    tvCert.getText().toString() + "\n" +
                    tvIssuer.getText().toString() + "\n\n" +
                    "Reference: \n" +
                    tvRefName.getText().toString() + "\n" +
                    tvRefContact.getText().toString() + "\n\n" +
                    "Summary: \n" + tvSummary.getText().toString();

            // Create an implicit intent for sharing
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My CV Details");
            shareIntent.putExtra(Intent.EXTRA_TEXT, cvDetails);

            // Start activity chooser to select an app to share with
            startActivity(Intent.createChooser(shareIntent, "Share CV via"));
        });

    }
}