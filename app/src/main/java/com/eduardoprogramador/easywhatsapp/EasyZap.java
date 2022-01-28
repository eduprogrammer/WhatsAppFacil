/*
*   Copyright 2021. Eduardo Programador
*   www.eduardoprogramador.com
*   consultoria@eduardoprogramador.com
*
*   All rights reserved
* */

package com.eduardoprogramador.easywhatsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EasyZap extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.easy_zap);
    }

    public void processZapRequest(View view) {

        EditText editCountry = findViewById(R.id.edit_country_code);
        EditText editDdd = findViewById(R.id.edit_ddd);
        EditText editNumber = findViewById(R.id.edit_number);

        String country = null;
        String ddd = null;
        String number = null;

        country = (editCountry.getText().toString().equalsIgnoreCase("55") ||
                editCountry.getText().toString().equalsIgnoreCase("Cód. País: 55")) ?
                "55" : editCountry.getText().toString();

        ddd = editDdd.getText().toString();

        number = editNumber.getText().toString();


        if(ddd.length() < 2) {
            Toast.makeText(this, "Informe um DDD válido", Toast.LENGTH_SHORT).show();
        } else {
            if(number.length() < 8) {
                Toast.makeText(this, "Informe um número válido", Toast.LENGTH_SHORT).show();
            } else {

                String link = "https://wa.me/" + country + ddd +
                        number;

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                Toast.makeText(this, "Tentando Conexão", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        }
    }
}
