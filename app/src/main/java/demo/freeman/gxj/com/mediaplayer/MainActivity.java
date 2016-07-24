package demo.freeman.gxj.com.mediaplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    String extension[] = {"girl.mp4","baby.avi"};
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView) findViewById(R.id.videoView);

        button = (Button) findViewById(R.id.music);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MusicActivity.class);
                startActivity(intent);
            }
        });

        /**
         * VideoView控制视频播放的功能相对较少，具体而言，它只有start和pause方法。为了提供更多的控制，
         * 可以实例化一个MediaController，并通过setMediaController方法把它设置为VideoView的控制器。
         */
        videoView.setMediaController(new MediaController(this));
        Uri videoUri = Uri.parse(Environment.getExternalStorageDirectory()
                .getPath() + "/" + extension[1]);
        videoView.setVideoURI(videoUri);
        videoView.start();
    }
}
