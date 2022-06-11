package App.download.quizizz_maker;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;



public class Ayuda2 extends AppCompatActivity {
    VideoView vv1;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda2);
        vv1=findViewById(R.id.vv1);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);

    }
    public void inicar (View view)
    {
        tv1.setText("ESTADO: DESCARGANDO DE INTERNET");
        vv1.setVideoURI(Uri.parse("https://youtu.be/ltNCaZcPRgA"));
        vv1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                tv1.setText("ESTADO: REPRODUCIENDO");
                tv2.setText("DURACION:"+(vv1.getDuration()/1000)+"seg.");
                vv1.start();
            }
        });
    }


}

