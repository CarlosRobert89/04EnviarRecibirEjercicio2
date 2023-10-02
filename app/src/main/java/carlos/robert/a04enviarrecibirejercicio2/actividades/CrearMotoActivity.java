package carlos.robert.a04enviarrecibirejercicio2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import carlos.robert.a04enviarrecibirejercicio2.R;
import carlos.robert.a04enviarrecibirejercicio2.modelos.Moto;

public class CrearMotoActivity extends AppCompatActivity {
    //VARIABLES DE VISTA
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCilindrada;
    private Button btnCancelar;
    private Button btnCrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_moto);

        inicializarVista();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Sacar la info de la vista para crear una moto
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String cilindrada = txtCilindrada.getText().toString();

                if(marca.isEmpty() || modelo.isEmpty() || cilindrada.isEmpty()){
                    Toast.makeText(CrearMotoActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else{
                    Moto moto = new Moto(marca, modelo, cilindrada);
                    //Enviar la moto a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MOTO", moto);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    //Devolver resultado de OK
                    setResult(RESULT_OK, intent);
                    //Terminar
                    finish();
                }

            }
        });

    }

    private void inicializarVista() {

        txtMarca = findViewById(R.id.txtMarcaCrearMoto);
        txtModelo = findViewById(R.id.txtModeloCrearMoto);
        txtCilindrada = findViewById(R.id.txtCilindradaCrearMoto);

        btnCancelar = findViewById(R.id.btnCancelarCrearMoto);
        btnCrear = findViewById(R.id.btnCrearCrearMoto);
    }
}