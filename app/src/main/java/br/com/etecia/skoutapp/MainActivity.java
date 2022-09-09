package br.com.etecia.skoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Declarando as variaveis globais que irao representar os objetos xml

    EditText edtUsuario, edtSenha;
    Button btnEntrar, btnSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //apresentar ao java os componentes do xml

        edtSenha = findViewById(R.id.ediSenha);
        edtUsuario = findViewById(R.id.editUsuario);
        btnEntrar = findViewById(R.id.btnEntar);
        btnSair = findViewById(R.id.btnSair);

        //criando ação de botão

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //atribuindo valores as variaveis

                String usuario, senha;

                usuario = edtUsuario.getText().toString();
                senha = edtSenha.getText().toString();

                if (usuario.equals("etecia") && senha.equals("123456")) {

                    //abrimos a janela menu principal

                    startActivity(new Intent(getApplicationContext(), MenuPrincipalActivity.class));

                    finish();

                } else {


                    Toast.makeText(getApplicationContext(), "Usuario ou Senha incorreta !  ", Toast.LENGTH_SHORT).show();


                    edtUsuario.setText("");
                    edtSenha.setText("");

                    edtUsuario.requestFocus();

                }
            }
        });

    }
}