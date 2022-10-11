package tesoem.edu.mx.t2p27s2120222rrja;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import Parcerables.DatosParcerables;

public class captura extends AppCompatActivity {

    EditText txtnombre, txtedad, txtcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);
        txtnombre = findViewById(R.id.txt_nombre);
        txtedad = findViewById(R.id.txt_edad);
        txtcorreo = findViewById(R.id.txt_correo);
    }
    public void regresar(View view){
        Intent pan = new Intent();
        DatosParcerables datosParcerables = new DatosParcerables(txtnombre.getText().toString(),Integer.parseInt(txtedad.getText().toString()),txtcorreo.getText().toString());
        pan.putExtra("Datos", datosParcerables);
        setResult(Activity.RESULT_OK, pan);
        finish();
    }
}