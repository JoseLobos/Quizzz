package App.download.quizizz_maker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Docentes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docentes);
        Button crear = (Button)this.findViewById(R.id.BtnCreaciondecuestionarios);
        Button estudiantes = (Button)this.findViewById(R.id.btnmodificar);

        crear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Cuestionariodocentes = new Intent(Docentes.this,Creacion_Cuestionarios.class);
                startActivity(Cuestionariodocentes);
            }
        });

    estudiantes.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Intent Cuestionariosestudiantes = new Intent(Docentes.this,Cuestionario_disponible_Docente.class);
        startActivity(Cuestionariosestudiantes);
        }
    });


    }
}