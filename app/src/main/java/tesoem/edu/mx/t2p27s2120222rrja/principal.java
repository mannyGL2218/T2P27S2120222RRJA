package tesoem.edu.mx.t2p27s2120222rrja;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import Parcerables.DatosParcerables;

public class principal extends AppCompatActivity {

    TextView tvnombre, tvedad, tvcorreo;

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK){
                Intent datos = result.getData();
                DatosParcerables datosParcerables = datos.getParcelableExtra("Datos");

                tvnombre.setText(datosParcerables.getNombre());
                tvedad.setText(String.valueOf(datosParcerables.getEdad()));
                tvcorreo.setText(datosParcerables.getCorreo());
            }
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        tvnombre = findViewById(R.id.tv_nombre);
        tvedad = findViewById(R.id.tv_edad);
        tvcorreo = findViewById(R.id.tv_correo);
    }
    public void captura(View view){
        Intent intent = new Intent(this, captura.class);
        activityResultLauncher.launch(intent);
    }
}