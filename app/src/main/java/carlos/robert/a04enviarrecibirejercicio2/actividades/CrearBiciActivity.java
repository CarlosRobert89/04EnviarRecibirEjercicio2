package carlos.robert.a04enviarrecibirejercicio2.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import carlos.robert.a04enviarrecibirejercicio2.R;
import carlos.robert.a04enviarrecibirejercicio2.modelos.Bici;

public class CrearBiciActivity extends AppCompatActivity {
    //VARIABLES DE VISTA
    private EditText txtMarca;
    private EditText txtPulgadas;
    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bici);

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
                //Sacar la info de la vista para crear una bici
                String marca = txtMarca.getText().toString();
                String pulgadas = txtPulgadas.getText().toString();

                if(marca.isEmpty() || pulgadas.isEmpty()){
                    Toast.makeText(CrearBiciActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else{
                    Bici bici = new Bici(marca, pulgadas);
                    //Enviar la bici a la actividad anterior
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICI", bici);
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
        txtMarca = findViewById(R.id.txtMarcaCrearBici);
        txtPulgadas = findViewById(R.id.txtPulgadasCrearBici);

        btnCancelar = findViewById(R.id.btnCancelarCrearBici);
        btnCrear = findViewById(R.id.btnCrearCrearBici);
    }
}