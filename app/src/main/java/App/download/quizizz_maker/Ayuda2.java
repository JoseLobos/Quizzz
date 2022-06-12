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
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda2);

        videoView = (VideoView)findViewById(R.id.videoView);

       // String path = "android.resource://"+ getPackageName() + "/" +
              //  R.raw.;
       // videoView.setVideoURI(Uri.parse(path));
      //  videoView.start();

    }
}

