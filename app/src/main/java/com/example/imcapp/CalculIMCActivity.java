package com.example.imcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class CalculIMCActivity extends AppCompatActivity {

    /////////////////////////  Definition des classes propres au composants ////////////////////////

    ////////// Composant Layout ///////////
    private LinearLayout layout;
    private RelativeLayout relativeLayout;

    ////////// Composant EditText ///////////
    private EditText edtNom;
    private EditText edtPre;

    ////////// Composant NumberPicker ///////////
    private NumberPicker numberPickerTaille;
    private NumberPicker numberPickerPoids;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_imcactivity);

        layout = findViewById(R.id.linearform);
        relativeLayout = (RelativeLayout) layout.findViewById(R.id.relativeLayout);

        edtNom =(EditText) layout.findViewById(R.id.edtnom);
        edtPre =(EditText) layout.findViewById(R.id.edtPrenom);

        //////////////////////////       GESTION DES NUMBER PICKER ET DE LEUR LOGIQUE //////////////////////////////
        // Gestion du number picker

        numberPickerTaille = (NumberPicker) relativeLayout.findViewById(R.id.numberPickerTaille);
        numberPickerPoids = (NumberPicker) relativeLayout.findViewById(R.id.numberPickerPoids);

        // Definition des valeurs minimale des NumberPicker
        numberPickerTaille.setMinValue(1);
        numberPickerPoids.setMinValue(1);

            // Definition des valeurs maximale des NumberPicker
        numberPickerTaille.setMaxValue(203);
        numberPickerPoids.setMaxValue(190);


        // Définition du composant avec les troits points(...)
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    // Remplissage des options du menu trois points(...) et affichage
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Calculer");
        menu.add("Quitter");
        return super.onCreateOptionsMenu(menu);
    }



    // Redirection vers l'activite d'affichage de l'imc

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getTitle().equals("Calculer")){
            String nom = edtNom.getText().toString();
            String prenom = edtPre.getText().toString();

            int poids = numberPickerPoids.getValue();
            double taille = (( numberPickerTaille.getValue()  * numberPickerTaille.getValue() ) / 100) * 10;
            double imc = (poids / taille) ;
            imc *= 1000;


            Intent intent = new Intent(CalculIMCActivity.this, IMCActivity.class);

            // Crer un bundle
            Bundle bundle = new Bundle();

            // Ajout des variables de calcul de l'imc au bundle
            bundle.putString("prenom", prenom);
            bundle.putString("nom",nom);
            bundle.putDouble("imc", imc);

            // Ajouter le bundle a l'intention
            intent.putExtras(bundle);

            // Démarrer l'activite accueil
            startActivity(intent);
        }
        else if (item.getTitle().equals("Quitter")){
            // Fermeture de l'application
            this.finishAffinity();
        }
        return super.onOptionsItemSelected(item);
    }
}