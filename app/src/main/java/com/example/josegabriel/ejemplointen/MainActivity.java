package com.example.josegabriel.ejemplointen;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText textoed,textoface;
    Button img,comface,maps,pagweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoed=findViewById(R.id.texto);
        img=findViewById(R.id.button);


        textoface=findViewById(R.id.texto2);
        comface=findViewById(R.id.button2);
        maps=findViewById(R.id.mapa);
        pagweb=findViewById(R.id.web);




        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(Intent.ACTION_SEND);
                inten.setType("text/plain");
                inten.putExtra(Intent.EXTRA_TEXT,textoed.getText().toString());
                inten.setPackage("com.whatsapp");
                Intent aux = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                if(aux!=null)
                startActivity(inten);
                else{
                    Toast.makeText(MainActivity.this, "no hay wathsapp", Toast.LENGTH_SHORT).show();
                }
            }
        });


        comface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(Intent.ACTION_SEND);
                inten.setType("text/plain");
                inten.putExtra(Intent.EXTRA_TEXT,textoed.getText().toString());
                inten.setPackage("com.facebook.katana");
                Intent aux = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
                if(aux!=null)
                    startActivity(inten);
                else{
                    Toast.makeText(MainActivity.this, "no hay wathsapp", Toast.LENGTH_SHORT).show();
                }
            }
        });


        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cordenadas = "geo:38.2983421,-5.2736782";

                Intent inten = new Intent(Intent.ACTION_VIEW);

                inten.setData(Uri.parse(cordenadas));
                startActivity(inten);
            }
        });


        pagweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pag = textoed.getText().toString();

                Intent inten = new Intent(Intent.ACTION_VIEW);
                inten.setData(Uri.parse(pag));
                Intent seleccionar = inten.createChooser(inten,"elige una pagina web");
                startActivity(seleccionar);
            }
        });


    }
}
