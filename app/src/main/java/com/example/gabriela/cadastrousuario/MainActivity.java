package com.example.gabriela.cadastrousuario;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText tel;
    private EditText email;
    private EditText senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.campoNome);
        tel = findViewById(R.id.campoTel);
        email = findViewById(R.id.campoEmail);
        senha = findViewById(R.id.campoSenha);


        Button btnTela = (Button) findViewById(R.id.btnCad);
        btnTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Informações", "Nome:"+nome.getText().toString());
                Log.i("Informações", "Telefone:"+tel.getText().toString());
                Log.i("Informações", "E-mail:"+email.getText().toString());
                Log.i("Informações", "Senha:"+senha.getText().toString());

                       Intent intent = new Intent(MainActivity.this, Main2Activity.class);
               startActivity(intent);
            }

        });

    }
    }

