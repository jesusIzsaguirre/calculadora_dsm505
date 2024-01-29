package org.utl.calculadora_volumen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText txtAncho;
    EditText txtAlto;
    EditText txtRadio;
    EditText txtLargo;
    TextView txtResultado;
    RadioButton rbCuadrada;
    RadioButton rbCilindrica;
    RadioButton rbEsferica;
    RadioButton rbRectangular;
    RadioButton rbTriangular;
    Button btnCalcularVol;
    Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtAlto = findViewById(R.id.txtAlto);
        txtAncho = findViewById(R.id.txtAncho);
        txtLargo = findViewById(R.id.txtLargo);
        txtResultado = findViewById(R.id.txtResultado);
        txtRadio = findViewById(R.id.txtRadio);
        rbCuadrada = findViewById(R.id.rbCuadrada);
        rbCilindrica = findViewById(R.id.rbCIlindrica);
        rbEsferica = findViewById(R.id.rbEsferica);
        rbRectangular = findViewById(R.id.rbRectangular);
        rbTriangular = findViewById(R.id.rbTriangular);
        btnCalcularVol = findViewById(R.id.btnCalcularVol);
        btnRegresar = findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener(View -> {
            Intent regresar = new Intent(this, MainActivity.class);
            startActivity(regresar);
        });

        btnCalcularVol.setOnClickListener(view -> {
            MostrarResultado();
        });
        rbCuadrada.setOnClickListener(view -> {
            habilitarCampos(true, true, true, false);
        });

        rbCilindrica.setOnClickListener(view -> {
            habilitarCampos(false, true, false, true);
        });

        rbEsferica.setOnClickListener(view -> {
            habilitarCampos(false, false, false, true);
        });

        rbRectangular.setOnClickListener(view -> {
            habilitarCampos(true, true, true, true);
        });

        rbTriangular.setOnClickListener(view -> {
            habilitarCampos(false, true, false, true);
        });
    }


    private void habilitarCampos(boolean ancho, boolean alto, boolean largo, boolean radio) {
        txtAncho.setEnabled(ancho);
        txtAlto.setEnabled(alto);
        txtLargo.setEnabled(largo);
        txtRadio.setEnabled(radio);
    }


    public void MostrarResultado (){
        String ancho = txtAncho.getText().toString();
        String alto = txtAlto.getText().toString();
        String largo = txtLargo.getText().toString();
        String radio = txtRadio.getText().toString();

        Double valAncho = Double.parseDouble(ancho);
        Double valAlto = Double.parseDouble(alto);
        Double valLargo = Double.parseDouble(largo);
        Double valRadio = Double.parseDouble(radio);

        if(rbCuadrada.isChecked() == true){
            Double volumenCu = (valAncho * valAlto * valLargo) *0.001;
            String resultadoCu =  String.valueOf(volumenCu);
            txtResultado.setText(resultadoCu);
        }
        else if(rbCilindrica.isChecked() == true){
            Double volumenCi = (valAlto * 3.14 * (valRadio*valRadio)) *0.001;
            String resultadoCi =  String.valueOf(volumenCi);
            txtResultado.setText(resultadoCi);
        }
        else if(rbEsferica.isChecked() == true){
            Double volumenE = (67/16 * valRadio) * 0.001;
            String resultadoE =  String.valueOf(volumenE);
            txtResultado.setText(resultadoE);
        }
        else if(rbRectangular.isChecked() == true){
            Double volumenR = (valLargo * valAncho * valAlto + (valAlto * 3.14 *(valRadio*valRadio))/2)*0.001;
            String resultadoR =  String.valueOf(volumenR);
            txtResultado.setText(resultadoR);
        }
        else if(rbTriangular.isChecked() == true){
            Double volumenT = (valAlto * 3.14 * (valRadio*valRadio)/4) * 0.001;
            String resultadoT =  String.valueOf(volumenT);
            txtResultado.setText(resultadoT);
        }

    }
}