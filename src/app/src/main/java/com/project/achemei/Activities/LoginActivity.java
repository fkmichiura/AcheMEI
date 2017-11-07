package com.project.achemei.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.achemei.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView tvTerms = (TextView) findViewById(R.id.tvTerms);
        TextView tvPrivacy = (TextView) findViewById(R.id.tvPrivacy);

        final Intent it = new Intent(Intent.ACTION_VIEW);

        //Eventos de cliques dos Termos
        tvTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it.setData(Uri.parse("http://www.google.com"));
                startActivity(it);
                Toast.makeText(LoginActivity.this, "Clicou em Termos", Toast.LENGTH_SHORT).show();
            }
        });

        tvPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it.setData(Uri.parse("http://www.yahoo.com"));
                startActivity(it);
                Toast.makeText(LoginActivity.this, "Clicou em Privacidade", Toast.LENGTH_SHORT).show();
            }
        });

        //Botão responsável por chamar a RegisterActivity
        Button registerBtn = (Button) findViewById(R.id.reg_btn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //Botão responsável por realizar o Login
        Button loginBtn = (Button) findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
