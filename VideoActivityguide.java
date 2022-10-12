package z1913793.cs.niu.edu.math_tutor_kids_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivityguide extends AppCompatActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_activityguide);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(v -> {

            Intent intentnew = new Intent(this, MainActivity.class);
            startActivity(intentnew);
        });

        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+ R.raw.vide);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
    }
}
