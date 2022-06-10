package App.download.quizizz_maker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;




public class Ayuda1 extends AppCompatActivity {
    Button Video;
    Button Crearquizz;
    Button resquizz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda1);

        Button Video = (Button)this.findViewById(R.id.btnVideo);
        Button Crearquizz = (Button)this.findViewById(R.id.btnCrearquizz);
        Button resquizz = (Button)this.findViewById(R.id.btnresquizz);



        Video.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent ayuda2 = new Intent(Ayuda1.this, Ayuda2.class);
                startActivity(ayuda2);
            }
        });


        Crearquizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ayuda3 = new Intent(Ayuda1.this, Ayuda3.class);
                startActivity(ayuda3);
            }
        });

        resquizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  ayuda4 = new Intent(Ayuda1.this, Ayuda4.class);
                startActivity(ayuda4);
            }
        });
    }
}