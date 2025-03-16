package com.example.cvbuildersmdassigment2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Animation top_to_bottom;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ivLogo = findViewById(R.id.ivLogo);
        top_to_bottom = AnimationUtils.loadAnimation(this, R.anim.topdown);
        ivLogo.setAnimation(top_to_bottom);

        new Handler()
                .postDelayed(()->{
                    startActivity(new Intent(MainActivity.this, Home.class));
                    finish();
                }, 3000);
    }
}