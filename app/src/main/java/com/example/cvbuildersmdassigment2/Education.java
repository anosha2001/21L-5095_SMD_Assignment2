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

public class Education extends AppCompatActivity {

    EditText etDegree, etInstitution;
    Button btnsave,btncancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_education);
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
            String degree= etDegree.getText().toString();
            String institution=etInstitution.getText().toString();
            Intent i=new Intent();
            i.putExtra("degree",degree);
            i.putExtra("institution",institution);

            setResult(RESULT_OK,i);
            finish();
        });
    }

    private void init(){
        etDegree=findViewById(R.id.etDegree);
        etInstitution=findViewById(R.id.etInstitution);
        btnsave=findViewById(R.id.btnSaveEducation);
        btncancel=findViewById(R.id.btnCancelEducation);

    }
}