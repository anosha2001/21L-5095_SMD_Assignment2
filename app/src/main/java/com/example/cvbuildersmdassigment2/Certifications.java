package com.example.cvbuildersmdassigment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Certifications extends AppCompatActivity {

    EditText etcert,etissuer;
    Button btnsave, btncancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_certifications);
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
            String cert= etcert.getText().toString();
            String issuer=etissuer.getText().toString();
            Intent i=new Intent();
            i.putExtra("cert",cert);
            i.putExtra("issuer",issuer);

            setResult(RESULT_OK,i);
            finish();
        });
    }

    private void init(){
        etcert=findViewById(R.id.etCertification);
        etissuer=findViewById(R.id.etIssuer);
        btnsave=findViewById(R.id.btnSaveCertifications);
        btncancel=findViewById(R.id.btnCancelCertifications);

    }
}
