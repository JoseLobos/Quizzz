package App.download.quizizz_maker;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Modificar_Cuestionarios extends AppCompatActivity {
    BaseDeDatos cuestionarios;
    BaseDeDatos db;
    public Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cuestionarios);
        obtenerDatos();

        Bundle idc = this.getIntent().getExtras();
        final EditText tNombre = (EditText) this.findViewById(R.id.NombreQuizz);
        final EditText Tcategoria = (EditText) this.findViewById(R.id.Categotia);
        Button btnSave = (Button) this.findViewById(R.id.btnSave);
        final EditText tPregunta = (EditText) this.findViewById(R.id.pregunta);
        final EditText tCorrecto = (EditText) this.findViewById(R.id.respCorrecta_1_);
        final EditText tIncorrecto1 = (EditText) this.findViewById(R.id.respIncorrecta_1_);
        final EditText tIncorrecto2 = (EditText) this.findViewById(R.id.respIncorrecta_1_2);
        final EditText tIncorrecto3 = (EditText) this.findViewById(R.id.respIncorrecta_1_3);
        final EditText tPregunta2 = (EditText) this.findViewById(R.id.pregunta2);
        final EditText tCorrecto2 = (EditText) this.findViewById(R.id.respCorrecta_1_2);
        final EditText tIncorrecto2_1 = (EditText) this.findViewById(R.id.respIncorrecta_2_1);
        final EditText tIncorrecto2_2 = (EditText) this.findViewById(R.id.respIncorrecta_2_2);
        final EditText tIncorrecto2_3 = (EditText) this.findViewById(R.id.respIncorrecta_2_3);
         String Id = idc.getString("id");
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


                    cuestionarios = new BaseDeDatos(Modificar_Cuestionarios.this, "",null,1);
                    cuestionarios.modificarQuizz(Nombre, categoria,  Pregunta,Correcto,Incorrecto1,Incorrecto2,Incorrecto3,Pregunta2,Correcto2,Incorrecto2_1,Incorrecto2_2,Incorrecto2_3,Id);
                    Toast.makeText(Modificar_Cuestionarios.this, "Listo, Cuestionario registrado con exito", Toast.LENGTH_LONG).show();
                    Intent imostrar= new Intent(Modificar_Cuestionarios.this, Especialidad_Academica.class);
                    startActivity(imostrar);
                }
                catch(Exception ex){
                    Toast.makeText(Modificar_Cuestionarios.this, "Error: "+ ex.getMessage().toString(), Toast.LENGTH_LONG).show();
                }


            }
        });


    }
    public void obtenerDatos(){

        Bundle idc = this.getIntent().getExtras();
        final EditText tNombre = (EditText) this.findViewById(R.id.NombreQuizz);
        final EditText Tcategoria = (EditText) this.findViewById(R.id.Categotia);
        Button btnSave = (Button) this.findViewById(R.id.btnSave);
        final EditText tPregunta = (EditText) this.findViewById(R.id.pregunta);
        final EditText tCorrecto = (EditText) this.findViewById(R.id.respCorrecta_1_);
        final EditText tIncorrecto1 = (EditText) this.findViewById(R.id.respIncorrecta_1_);
        final EditText tIncorrecto2 = (EditText) this.findViewById(R.id.respIncorrecta_1_2);
        final EditText tIncorrecto3 = (EditText) this.findViewById(R.id.respIncorrecta_1_3);
        final EditText tPregunta2 = (EditText) this.findViewById(R.id.pregunta2);
        final EditText tCorrecto2 = (EditText) this.findViewById(R.id.respCorrecta_1_2);
        final EditText tIncorrecto2_1 = (EditText) this.findViewById(R.id.respIncorrecta_2_1);
        final EditText tIncorrecto2_2 = (EditText) this.findViewById(R.id.respIncorrecta_2_2);
        final EditText tIncorrecto2_3 = (EditText) this.findViewById(R.id.respIncorrecta_2_3);
         String Id = idc.getString("id");
        db = new BaseDeDatos(Modificar_Cuestionarios.this, "", null, 1);
        c = db.consultarCuestionario(Id);
        if(c.moveToFirst()){


            String Nombre = c.getString(1);
            String Preg1 = c.getString(2);
            String cat =c.getString(3);
            String opc1 = c.getString(4);
            String opc2 = c.getString(5);
            String opc3 = c.getString(6);
            String opc4 = c.getString(7);
            String Preg2 = c.getString(8);
            String opc1dos = c.getString(9);
            String opc2dos = c.getString(10);
            String opc3dos = c.getString(11);
            String opc4dos = c.getString(12);

            tNombre.setText(Nombre);
            Tcategoria.setText(cat);
            tPregunta.setText(Preg1);
            tCorrecto.setText(opc1);
            tIncorrecto1.setText(opc2);
            tIncorrecto2.setText(opc3);
            tIncorrecto3.setText(opc4);
            tPregunta2.setText(Preg2);
            tCorrecto2.setText(opc1dos);
            tIncorrecto2_1.setText(opc2dos);
            tIncorrecto2_2.setText(opc3dos);
            tIncorrecto2_3.setText(opc4dos);


        }}
}