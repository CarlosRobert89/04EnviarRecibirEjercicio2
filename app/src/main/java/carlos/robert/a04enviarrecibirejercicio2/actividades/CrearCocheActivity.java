package carlos.robert.a04enviarrecibirejercicio2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import carlos.robert.a04enviarrecibirejercicio2.R;
import carlos.robert.a04enviarrecibirejercicio2.modelos.Coche;

public class CrearCocheActivity extends AppCompatActivity {
    //VARIABLES DE VISTA
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;
    private Button btnCancelar;
    private Button btnCrear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_coche);

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
                //Sacar la info de la vista para crear un coche
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                if(marca.isEmpty() || modelo.isEmpty() || color.isEmpty()){
                    Toast.makeText(CrearCocheActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else{
                    Coche coche = new Coche(marca, modelo, color);
                    //Enviar el coche a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", coche);
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
        txtMarca = findViewById(R.id.txtMarcaCrearCoche);
        txtModelo = findViewById(R.id.txtModeloCrearCoche);
        txtColor = findViewById(R.id.txtColorCrearCoche);

        btnCancelar = findViewById(R.id.btnCancelarCrearCoche);
        btnCrear = findViewById(R.id.btnCrearCrearCoche);
    }
}