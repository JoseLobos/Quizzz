package App.download.quizizz_maker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
;

import androidx.appcompat.app.AppCompatActivity;


public class selecciondequizz extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionquizz);

        final EditText idc = (EditText) this.findViewById(R.id.idCuestionario);
        Button siguiente = (Button) this.findViewById(R.id.button11);

        siguiente.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             String id = idc.getText().toString();

                                             Bundle idCuestionario = new Bundle();
                                             idCuestionario.putString("Idc",id);
                                             Intent siguiente = new Intent( selecciondequizz.this, Creacion_cuestionario.class);
                                             siguiente.putExtras(idCuestionario);
                                             startActivity(siguiente);

                                         }
                                     }
        );
    }

}