package com.example.cvbuildersmdassigment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Experience extends AppCompatActivity {

    EditText etCompanyName, etJobTitle, etYearsExperience;
    Button btnsave, btncancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_experience);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btncancel.setOnClickListener((v)->{
            setResult(RESULT_CANCELED);
            finish();
        });

        btnsave.setOnClickListener((v)->{
            String companyname=etCompanyName.getText().toString();
            String jobtitle=etJobTitle.getText().toString();
            String yearsexperience=etYearsExperience.getText().toString();
            Intent i=new Intent();
            i.putExtra("companyname",companyname);
            i.putExtra("jobtitle",jobtitle);
            i.putExtra("yearsexperience",yearsexperience);

            setResult(RESULT_OK,i);
            finish();

        });
    }

    private void init(){
        etCompanyName=findViewById(R.id.etCompanyName);
        etJobTitle=findViewById(R.id.etJobTitle);
        etYearsExperience=findViewById(R.id.etYearsExperience);
        btnsave=findViewById(R.id.btnSaveExperience);
        btncancel=findViewById(R.id.btnCancelExperience);
    }
}