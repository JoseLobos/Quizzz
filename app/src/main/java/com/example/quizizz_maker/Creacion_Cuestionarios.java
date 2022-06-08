package com.example.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Creacion_Cuestionarios extends AppCompatActivity {
    BaseDeDatos cuestionarios;
    String accion = "nuevo";
    String Id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creacion_cuestionarios);
        final EditText tNombre = (EditText) this.findViewById(R.id.NombreQuizz);
        final EditText Tcategoria = (EditText) this.findViewById(R.id.Categotia);
        Button btnSave = (Button) this.findViewById(R.id.btnSave);
        final EditText tPregunta = (EditText) this.findViewById(R.id.pregunta);
        final EditText tCorrecto = (EditText) this.findViewById(R.id.respCorrecta_1_);
        final EditText tIncorrecto1 = (EditText) this.findViewById(R.id.respIncorrecta_1_);
        final EditText tIncorrecto2 = (EditText) this.findViewById(R.id.respIncorrecta_1_2);
        final EditText tIncorrecto3 = (EditText) this.findViewById(R.id.respIncorrecta_1_3);
        final EditText tPregunta2 = (EditText) this.findViewById(R.id.pregunta2_);
        final EditText tCorrecto2 = (EditText) this.findViewById(R.id.respCorrecta_1_2);
        final EditText tIncorrecto2_1 = (EditText) this.findViewById(R.id.respIncorrecta_2_);
        final EditText tIncorrecto2_2 = (EditText) this.findViewById(R.id.respIncorrecta_2_2);
        final EditText tIncorrecto2_3 = (EditText) this.findViewById(R.id.respIncorrecta_2_3);
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String Nombre = tNombre.getText().toString();
                String categoria = Tcategoria.getText().toString();
                String Pregunta = tPregunta.getText().toString();
                String Correcto = tCorrecto.getText().toString();
                String Incorrecto1 = tIncorrecto1.getText().toString();
                String Incorrecto2 = tIncorrecto2.getText().toString();
                String Incorrecto3 = tIncorrecto3.getText().toString();
                String Pregunta2 = tPregunta2.getText().toString();
                String Correcto2 = tCorrecto2.getText().toString();
                String Incorrecto2_1 = tIncorrecto2_1.getText().toString();
                String Incorrecto2_2 = tIncorrecto2_2.getText().toString();
                String Incorrecto2_3 = tIncorrecto2_3.getText().toString();
                try{


                    cuestionarios = new BaseDeDatos(Creacion_Cuestionarios.this, "",null,1);
                    cuestionarios.guardarCuestionario( Nombre, categoria,  Pregunta,Correcto,Incorrecto1,Incorrecto2,Incorrecto3,Pregunta2,Correcto2,Incorrecto2_1,Incorrecto2_2,Incorrecto2_3,accion,Id);
                    Toast.makeText(Creacion_Cuestionarios.this, "Listo, Cuestionario registrado con exito", Toast.LENGTH_LONG).show();
                    Intent imostrar= new Intent(Creacion_Cuestionarios.this, Especialidad_Academica.class);
                    startActivity(imostrar);
                }
                catch(Exception ex){
                    Toast.makeText(Creacion_Cuestionarios.this, "Error: "+ ex.getMessage().toString(), Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}