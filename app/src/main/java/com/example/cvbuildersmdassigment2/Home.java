package com.example.cvbuildersmdassigment2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {
    Button btnpfp,btnpd,btns,btnedu,btnexp,btnc,btnr,btncvprev;
    String name, email, phone, gender,cert,issuer,degree,institution,companyname,jobtitle,yearsexperience,refname,refcontact,summary;
    ImageView ivProfilePic;
    ActivityResultLauncher<Intent> getImageLauncher;
    ActivityResultLauncher<Intent> getPDDataLauncher,getCDataLauncher,getRDataLauncher,getEduDataLauncher,getExpDataLauncher,getSDataLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnpfp.setOnClickListener((v)->{
            Intent i = new Intent(Intent.ACTION_PICK);
            i.setType("image/*");
            getImageLauncher.launch(i);
        });

        btnc.setOnClickListener((v)->{
            Intent i=new Intent(Home.this,Certifications.class);
            getCDataLauncher.launch(i);

        });

        btnedu.setOnClickListener((v)->{
            Intent i=new Intent(Home.this,Education.class);
            getEduDataLauncher.launch(i);

        });

        btnexp.setOnClickListener((v)->{
            Intent i=new Intent(Home.this,Experience.class);
            getExpDataLauncher.launch(i);

        });

        btnr.setOnClickListener((v)->{
            Intent i=new Intent(Home.this,References.class);
            getRDataLauncher.launch(i);

        });

        btns.setOnClickListener((v)->{
            Intent i=new Intent(Home.this,Summary.class);
            getSDataLauncher.launch(i);

        });

        btnpd.setOnClickListener((v)->{
            Intent i=new Intent(Home.this,PersonalDetails.class);
            getPDDataLauncher.launch(i);

        });

        btncvprev.setOnClickListener((v) -> {
            if (name != null && email != null && phone != null && gender != null &&
                    cert != null && issuer != null && degree != null && institution != null &&
                    companyname != null && jobtitle != null && yearsexperience != null &&
                    refname != null && refcontact != null && summary != null) {

                Intent i = new Intent(Home.this, CVPreview.class);
                i.putExtra("name", name);
                i.putExtra("email", email);
                i.putExtra("phone", phone);
                i.putExtra("gender", gender);
                i.putExtra("cert", cert);
                i.putExtra("issuer", issuer);
                i.putExtra("degree", degree);
                i.putExtra("institution", institution);
                i.putExtra("companyname", companyname);
                i.putExtra("jobtitle", jobtitle);
                i.putExtra("yearsexperience", yearsexperience);
                i.putExtra("refname", refname);
                i.putExtra("refcontact", refcontact);
                i.putExtra("summary", summary);
                startActivity(i);
            } else {
                Toast.makeText(this, "Please complete all sections before previewing your CV.", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void init() {
        ivProfilePic = findViewById(R.id.ivProfilePic);
        btnpfp = findViewById(R.id.btnProfilePicture);
        btnpd = findViewById(R.id.btnPersonalDetails);
        btns = findViewById(R.id.btnSummary);
        btnedu = findViewById(R.id.btnEducation);
        btnexp = findViewById(R.id.btnExperience);
        btnc = findViewById(R.id.btnCertifications);
        btnr=findViewById(R.id.btnReferences);
        btncvprev=findViewById(R.id.btnCVPreview);

        getImageLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result) -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri image = result.getData().getData();
                        ivProfilePic.setImageURI(image);
                    } else {
                        Toast.makeText(this, "Select the image", Toast.LENGTH_SHORT).show();
                    }
                });

        getPDDataLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Data not entered by user", Toast.LENGTH_SHORT).show();
                    }
                    else if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                    {
                        Intent PDdataIntent = result.getData();
                        name = PDdataIntent.getStringExtra("name");
                        email = PDdataIntent.getStringExtra("email");
                        gender = PDdataIntent.getStringExtra("gender");
                        phone = PDdataIntent.getStringExtra("phone");
                        Toast.makeText(this, name+"\n"+phone+"\n"+gender+"\n"+email, Toast.LENGTH_LONG).show();

                    }
                });

        getCDataLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Data not entered by user", Toast.LENGTH_SHORT).show();
                    }
                    else if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                    {
                        Intent CdataIntent = result.getData();
                        cert=CdataIntent.getStringExtra("cert");
                        issuer=CdataIntent.getStringExtra("issuer");

                        Toast.makeText(this, "Certification:\nCertificate: " + cert + "\nIssuer: " + issuer, Toast.LENGTH_LONG).show();

                    }
                });

        getEduDataLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Data not entered by user", Toast.LENGTH_SHORT).show();
                    }
                    else if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                    {
                        Intent EdudataIntent = result.getData();
                        degree=EdudataIntent.getStringExtra("degree");
                        institution=EdudataIntent.getStringExtra("institution");

                        Toast.makeText(this, "Education:\nDegree: " + degree + "\nInstitution: " + institution, Toast.LENGTH_LONG).show();

                    }
                });

        getExpDataLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Data not entered by user", Toast.LENGTH_SHORT).show();
                    }
                    else if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                    {
                        Intent ExpdataIntent = result.getData();
                        companyname=ExpdataIntent.getStringExtra("companyname");
                        jobtitle=ExpdataIntent.getStringExtra("jobtitle");
                        yearsexperience=ExpdataIntent.getStringExtra("yearsexperience");

                        Toast.makeText(this, "Experience:\nCompany: " + companyname + "\nJob Title: " + jobtitle + "\nYears Experience: " + yearsexperience, Toast.LENGTH_LONG).show();

                    }
                });

        getRDataLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Data not entered by user", Toast.LENGTH_SHORT).show();
                    }
                    else if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                    {
                        Intent RdataIntent = result.getData();
                        refname=RdataIntent.getStringExtra("refname");
                        refcontact=RdataIntent.getStringExtra("refcontact");

                        Toast.makeText(this, "References:\nReferee Name: " + refname + "\nReferee Contact: " + refcontact, Toast.LENGTH_LONG).show();
                    }
                });

        getSDataLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                (result)->{
                    if(result.getResultCode() == RESULT_CANCELED)
                    {
                        Toast.makeText(this, "Data not entered by user", Toast.LENGTH_SHORT).show();
                    }
                    else if(result.getResultCode() == RESULT_OK && result.getData()!=null)
                    {
                        Intent SdataIntent = result.getData();
                        summary=SdataIntent.getStringExtra("summary");

                        Toast.makeText(this, "Summary: " + summary, Toast.LENGTH_LONG).show();

                    }
                });


    }
}