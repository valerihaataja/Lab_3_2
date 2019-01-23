package com.example.valer.lab_3_2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText text_editor;
    String osoite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go_button).setOnClickListener(this);
        findViewById(R.id.open_map_button).setOnClickListener(this);
        findViewById(R.id.crete_call_button).setOnClickListener(this);
        text_editor = findViewById(R.id.text_editor);

    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();

        if(viewID == R.id.open_map_button){
            Uri location = Uri.parse("geo:0,0?q=1600+Kotkantie+1,+90250+Oulu");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

            startActivity(mapIntent);

        }

        if(viewID == R.id.crete_call_button){
            Uri number = Uri.parse("tel: +358443050696");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

            startActivity(callIntent);
        }

        if(viewID == R.id.go_button){
            osoite = text_editor.getText().toString();
            Uri webpage = Uri.parse(osoite);
            Intent urlIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(urlIntent);

        }
    }
}
