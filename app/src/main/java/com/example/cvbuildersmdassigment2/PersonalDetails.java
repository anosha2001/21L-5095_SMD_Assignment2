package com.example.cvbuildersmdassigment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PersonalDetails extends AppCompatActivity {

    EditText etName, etEmail, etPhone;
    RadioGroup rgGender;
    Button btnsave,btncancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_personal_details);
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
            String name=etName.getText().toString();
            String email=etEmail.getText().toString();
            String phone=etPhone.getText().toString();
            String gender;
            int idGender = rgGender.getCheckedRadioButtonId();
            RadioButton rbOption = findViewById(idGender);
            gender= rbOption.getText().toString();
            Intent i=new Intent();
            i.putExtra("name", name);
            i.putExtra("email", email);
            i.putExtra("gender", gender);
            i.putExtra("phone", phone);

            setResult(RESULT_OK, i);
            finish();
        });
    }

    private void init(){
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPhone=findViewById(R.id.etPhone);
        rgGender=findViewById(R.id.rgGender);
        btnsave=findViewById(R.id.btnSavePersonalDetails);
        btncancel=findViewById(R.id.btnCancelPersonalDetails);

    }
}