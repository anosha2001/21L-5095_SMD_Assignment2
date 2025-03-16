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

public class Summary extends AppCompatActivity {

    EditText etsummary;
    Button btnsave, btncancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_summary);
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
            String summary= etsummary.getText().toString();
            Intent i=new Intent();
            i.putExtra("summary",summary);

            setResult(RESULT_OK,i);
            finish();
        });
    }

    private void init(){
        etsummary=findViewById(R.id.etSummary);
        btnsave=findViewById(R.id.btnSaveSummary);
        btncancel=findViewById(R.id.btnCancelSummary);

    }
}