package carlos.robert.a04enviarrecibirejercicio2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import carlos.robert.a04enviarrecibirejercicio2.actividades.CrearBiciActivity;
import carlos.robert.a04enviarrecibirejercicio2.actividades.CrearCocheActivity;
import carlos.robert.a04enviarrecibirejercicio2.actividades.CrearMotoActivity;
import carlos.robert.a04enviarrecibirejercicio2.modelos.Bici;
import carlos.robert.a04enviarrecibirejercicio2.modelos.Coche;
import carlos.robert.a04enviarrecibirejercicio2.modelos.Moto;

public class MainActivity extends AppCompatActivity {
    //ATRIBUTOS PARA LA VISTA
    private Button btnCrearCoche;
    private Button btnCrearMoto;
    private Button btnCrearBici;
    private TextView lbCantidadCoches;
    private TextView lbCantidadMotos;
    private TextView lbCantidadBicis;

    //ATRIBUTOS PARA LOS LAUNCHERS (RECOGER INFORMACIÓN)
    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;

    //ATRIBUTOS PARA
    private ArrayList<Coche> listaCoches;
    private ArrayList<Moto> listaMotos;
    private ArrayList<Bici> listaBicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariables();

        btnCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCoches.launch(new Intent(MainActivity.this, CrearCocheActivity.class));
            }
        });
        btnCrearMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherMotos.launch(new Intent(MainActivity.this, CrearMotoActivity.class));
            }
    });
        btnCrearBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherBicis.launch(new Intent(MainActivity.this, CrearBiciActivity.class));
            }
        });
        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            //comprobar si el intent no está vacío  //comprobar si el bundle no está vacío
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                Coche coche = (Coche) result.getData().getExtras().getSerializable("COCHE");
                                if (coche != null) {
                                    listaCoches.add(coche);
                                    lbCantidadCoches.setText("Coches: " + listaCoches.size());
                                } else {
                                    Toast.makeText(MainActivity.this, "NO HAY COCHE", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ACTIVIDAD CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        launcherBicis = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            //comprobar si el intent no está vacío  //comprobar si el bundle no está vacío
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                Bici bici = (Bici) result.getData().getExtras().getSerializable("BICI");
                                if (bici != null) {
                                    listaBicis.add(bici);
                                    lbCantidadBicis.setText("Bicis: " + listaBicis.size());
                                } else {
                                    Toast.makeText(MainActivity.this, "NO HAY BICI", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ACTIVIDAD CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        launcherMotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            //comprobar si el intent no está vacío  //comprobar si el bundle no está vacío
                            if (result.getData() != null && result.getData().getExtras() != null) {
                                Moto moto = (Moto) result.getData().getExtras().getSerializable("MOTO");
                                if (moto != null) {
                                    listaMotos.add(moto);
                                    lbCantidadMotos.setText("Motos: " + listaMotos.size());
                                } else {
                                    Toast.makeText(MainActivity.this, "NO HAY MOTO", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "NO HAY DATOS", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "ACTIVIDAD CANCELADA", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void inicializarVariables() {
        //inicializar Vista
        lbCantidadCoches = findViewById(R.id.lbCantidadCochesMain);
        lbCantidadMotos = findViewById(R.id.lbCantidadMotosMain);
        lbCantidadBicis = findViewById(R.id.lbCantidadBicisMain);

        btnCrearCoche = findViewById(R.id.btnCrearCocheMain);
        btnCrearMoto = findViewById(R.id.btnCrearMotoMain);
        btnCrearBici = findViewById(R.id.btnCrearBiciMain);

        //inicializar Lógica
        listaCoches = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaBicis = new ArrayList<>();

    }
}