package com.example.tp3dessin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Palette extends AppCompatActivity {

    public static final String SEND_COULEUR = "Send couleur";
    public static final String SEND_EPAISSEUR = "Send epaisseur";
    Button btn;
    EditText edtC;
    EditText edtE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        Ref();

        sendMessage(btn);
    }

    void Ref () {
        btn = (Button) findViewById(R.id.btnOK);
        edtC = (EditText) findViewById(R.id.edtCouleur);
        edtE = (EditText) findViewById(R.id.edtEpaisseur);
    }

    void sendMessage (Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtC.getText().toString().isEmpty() || edtE.getText().toString().isEmpty()) {
                    Toast.makeText(Palette.this,"Please complete the Form", Toast.LENGTH_SHORT).show();
                } else {
                    int coul = Integer.parseInt(edtC.getText().toString());
                        int newC = convertttoC(coul);
                        Intent intent = new Intent(Palette.this, MainActivity.class);
                        intent.putExtra(SEND_COULEUR, newC);
                        intent.putExtra(SEND_EPAISSEUR, Float.parseFloat(edtE.getText().toString()));

                        setResult(Activity.RESULT_OK, intent);
                        finish();


                }

            }
        });
    }

    int convertttoC (int c) {
            switch (c) {
                case 1: return Color.BLUE;
                case 2: return Color.RED;
                case 3: return Color.GREEN;
                case 4: return Color.YELLOW;
                case 5: return Color.CYAN;
                case 6: return Color.BLACK;
                case 7: return Color.GRAY;
                default: return Color.WHITE;
            }
    }

}