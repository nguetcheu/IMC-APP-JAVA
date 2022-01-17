package com.example.imcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.MessageFormat;

public class IMCActivity extends AppCompatActivity {
    private TextView txtNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcactivity);

        // Recuperer les widgets xml
        txtNom =(TextView) findViewById(R.id.txtWelcome);

        String Newligne=System.getProperty("line.separator");
        String etatSante;
        /*
        // Recuperer l'intention
        Intent intent = getIntent();
         */

        // Recuperer le bundle
        Bundle bundle = getIntent().getExtras();

        // Recuperer imc
        String nom = bundle.getString("nom");
        String prenom = bundle.getString("prenom");
        Double imc = bundle.getDouble("imc");

        ///////////////////////////////// etat de sante particulier //////////////////////////////
        if (imc < 16.5) {
            etatSante = "denutrition ou famine";
        }
        else if (imc>16.5 && imc <18.5) {
            etatSante = "migreur";
        }
        else if (imc>18.5 && imc <25) {
            etatSante = "corpulence normale";
        }
        else if (imc>25 && imc <30) {
            etatSante = "surpoids";
        }
        else if (imc>30 && imc <35) {
            etatSante = "obesite moderée";
        }
        else if (imc>35 && imc <40) {
            etatSante = "obesite sévère";
        }
        else {
            etatSante = "obesite morbide ou massive";
        }

        ///////////////////////////////// etat de sante particulier //////////////////////////////

        // Afficher le nom dans la textView
        txtNom.setText(MessageFormat.format("LE CALCUL DE VOTRE IMC \r \r Monsieur {0} {1} \r Votre imc est egale a : {2}                                   Vous etes en {3} ", nom, prenom, imc, etatSante));
    }

}