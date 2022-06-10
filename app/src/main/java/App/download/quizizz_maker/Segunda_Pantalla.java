package App.download.quizizz_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
                Intent Cuestionariodocentes = new Intent(Segunda_Pantalla.this,Docentes.class);
                startActivity(Cuestionariodocentes);
            }
        });

    estudiantes.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        Intent Cuestionariosestudiantes = new Intent(Segunda_Pantalla.this,Cuestionario_disponible.class);
        startActivity(Cuestionariosestudiantes);
        }
    });


    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuayuda, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){


        Intent imostrar= new Intent(Segunda_Pantalla.this, Ayuda1.class);
        startActivity(imostrar);
        return super.onOptionsItemSelected(item);

        }

    }

