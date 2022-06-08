package App.download.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Segunda_Pantalla extends AppCompatActivity {
Button docentes;
Button estudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidad_academica);
        Button docentes = (Button)this.findViewById(R.id.btn_docentes);
        Button estudiantes = (Button)this.findViewById(R.id.btn_estudiante);

        docentes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent Cuestionariodocentes = new Intent(Segunda_Pantalla.this,Creacion_Cuestionarios.class);
                startActivity(Cuestionariodocentes);
            }
        });

    estudiantes.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Intent Cuestionariosestudiantes = new Intent(Segunda_Pantalla.this,Creacion_cuestionario.class);
        startActivity(Cuestionariosestudiantes);
        }
    });


    }
}