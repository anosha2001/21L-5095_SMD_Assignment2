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

public class References extends AppCompatActivity {

    EditText etRefname,etRefcontact;
    Button btnsave, btncancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_references);
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
            String refname= etRefname.getText().toString();
            String refcontact=etRefcontact.getText().toString();
            Intent i=new Intent();
            i.putExtra("refname",refname);
            i.putExtra("refcontact",refcontact);

            setResult(RESULT_OK,i);
            finish();
        });
    }

    private void init(){
        etRefcontact=findViewById(R.id.etRefContact);
        etRefname=findViewById(R.id.etRefName);
        btncancel=findViewById(R.id.btnCancelReferences);
        btnsave=findViewById(R.id.btnSaveReferences);
    }
}