package com.example.tp3dessin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int RQ_CODE = 1;
    public static final int ERROR = 404;
    Button btn;
    int edtC = Color.BLACK;
    float edtE = 10;
    Dessin d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ref();

        launch(btn);


    }

    void Ref () {
        btn = (Button) findViewById(R.id.btnChange);
        d = (Dessin) findViewById(R.id.dessin);
    }

    void launch(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Palette.class);
                startActivityForResult(intent, RQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RQ_CODE) {
            if (resultCode == RESULT_OK) {
                edtC = data.getIntExtra(Palette.SEND_COULEUR, ERROR);
                edtE = data.getFloatExtra(Palette.SEND_EPAISSEUR, ERROR);
                d.setC(edtC);
                d.setE(edtE);
            }
        }
    }
}