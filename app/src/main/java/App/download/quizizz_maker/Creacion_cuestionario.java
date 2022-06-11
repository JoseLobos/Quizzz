package App.download.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Creacion_cuestionario extends AppCompatActivity {
    BaseDeDatos db;
    public Cursor c;
    RadioButton Opcion1,opcion2,opcion3,opcion4,opcion1Dos,opcion2Dos,opcion3dos,opcion4dos;
    TextView NombreQuizz,textView10,Pregunta2;
    Button  Entregar,Finalizar;
    int nota=0; int Npregunta =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion_cuestionario);

        Opcion1= (RadioButton)findViewById(R.id.Opcion1);
        opcion2= (RadioButton)findViewById(R.id.opcion2);
        opcion3= (RadioButton)findViewById(R.id.opcion3);
        opcion4= (RadioButton)findViewById(R.id.opcion4);
        opcion1Dos= (RadioButton)findViewById(R.id.opcion1Dos);
        opcion2Dos= (RadioButton)findViewById(R.id.opcion2Dos);
        opcion3dos= (RadioButton)findViewById(R.id.opcion3dos);
        opcion4dos= (RadioButton)findViewById(R.id.opcion4dos);

        NombreQuizz= (TextView)findViewById(R.id.NombreQuizz);
        textView10= (TextView)findViewById(R.id.textView10);
        Pregunta2= (TextView)findViewById(R.id.Pregunta2);

        Entregar= (Button) findViewById(R.id.Finalizar);
        Finalizar= (Button) findViewById(R.id.Salir);


        obtenerDatos();


    }

    public void obtenerDatos(){
        Bundle idCuestionario = this.getIntent().getExtras();

        String Id = idCuestionario.getString("Idc");
        db = new BaseDeDatos(Creacion_cuestionario.this, "", null, 1);
        c = db.consultarCuestionario(Id);
        if(c.moveToFirst()){

            TextView NombreQuizz = (TextView) findViewById(R.id.NombreQuizz);
            TextView Pregunta1 = (TextView) findViewById(R.id.textView10);
            TextView Pregunta2 = (TextView) findViewById(R.id.Pregunta2);


            Button opcion1 = (Button) findViewById(R.id.Opcion1);
            Button opcion2 = (Button) findViewById(R.id.opcion2);
            Button opcion3 = (Button) findViewById(R.id.opcion3);
            Button opcion4 = (Button) findViewById(R.id.opcion4);
            Button opcion1dos = (Button) findViewById(R.id.opcion1Dos);
            Button opcion2dos = (Button) findViewById(R.id.opcion2Dos);
            Button opcion3dos = (Button) findViewById(R.id.opcion3dos);
            Button opcion4dos = (Button) findViewById(R.id.opcion4dos);


            String Nombre = c.getString(1);
            String Preg1 = c.getString(2);
            String opc1 = c.getString(4);
            String opc2 = c.getString(5);
            String opc3 = c.getString(6);
            String opc4 = c.getString(7);
            String Preg2 = c.getString(8);
            String opc1dos = c.getString(9);
            String opc2dos = c.getString(10);
            String opc3dos = c.getString(11);
            String opc4dos = c.getString(12);

             NombreQuizz.setText(Nombre);
             Pregunta1.setText(Preg1);
             Pregunta2.setText(Preg2);


             opcion1.setText(opc1);
             opcion2.setText(opc2);
             opcion3.setText(opc3);
             opcion4.setText(opc4);
             opcion1dos.setText(opc1dos);
             opcion2dos.setText(opc2dos);
             opcion3dos.setText(opc3dos);
             opcion4dos.setText(opc4dos);


    }}

    public void Finalizarb (View view){
        if (Opcion1.isChecked()== false && Opcion1.isChecked()== false && opcion2.isChecked()== false && opcion3.isChecked()== false && opcion4.isChecked()== false && opcion1Dos.isChecked()== false && opcion2Dos.isChecked()== false && opcion3dos.isChecked()== false ){
            Toast.makeText(this, "ELIJA UNA OPCION ",Toast.LENGTH_SHORT).show();
        }else if (Npregunta==1){
            if (Opcion1.isChecked()){
                nota=nota +5;
            }
            Npregunta=Npregunta+1;
        }
        else if (Npregunta==2){
            if (opcion1Dos.isChecked()){
                nota=nota +5;
            }
            NombreQuizz.setText("NOTA OBTENIDA: "+nota);
            if (nota>=6){
                textView10.setText("ESTADO APROBADO");
            }
            else {
                textView10.setText("ESTADO REPROBADO");
            }
            Opcion1.setVisibility(View.GONE);
            opcion2.setVisibility(View.GONE);
            opcion3.setVisibility(View.GONE);
            opcion4.setVisibility(View.GONE);
            opcion1Dos.setVisibility(View.GONE);
            opcion2Dos.setVisibility(View.GONE);
            opcion3dos.setVisibility(View.GONE);
            opcion4dos.setVisibility(View.GONE);
            Pregunta2.setVisibility(View.GONE);
            Entregar.setVisibility(View.GONE);

        }
    }

public void Salir(View view){
    Intent imostrar= new Intent(Creacion_cuestionario.this, Especialidad_Academica.class);
    startActivity(imostrar);
}
}