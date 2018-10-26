package com.devschema.sh4d0w.musicalstructureapp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {
    private ImageView imgDetails;
    private TextView tvTitleDetails, tvArtistDetails, tvDurationDetails, tvNowPlaying;
    private Song song;
    private Button btnPrevious, btnPause, btnNext;
    private boolean flag = true;
    private int songId = 0;
    private String SongStatus = "";
    private Animations anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        findViewById();

        song = new Song();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            song.setTitle(getIntent().getStringExtra("Title"));
            song.setArtist(getIntent().getStringExtra("Artist"));
            Double Duration = Double.parseDouble(getIntent().getStringExtra("Duration"));
            song.setDuration(Duration);
            Integer id = Integer.parseInt(getIntent().getStringExtra("Id"));
            song.setId(id);

            songId = song.getId();

            tvTitleDetails.setText(song.getTitle());
            tvArtistDetails.setText(song.getArtist());
            tvDurationDetails.setText(String.valueOf(song.getDuration()));
            tvNowPlaying.setText(getResources().getString(R.string.now_playing) + "  " + song.getTitle());
        }

        if (savedInstanceState != null) {
            songId = savedInstanceState.getInt("songId");
            song.setId(savedInstanceState.getInt("getId"));
            song.setTitle(savedInstanceState.getString("getTitle"));
            song.setArtist(savedInstanceState.getString("getArtist"));

            flag = savedInstanceState.getBoolean("flag");
            flag = !flag;
            SongStatus = savedInstanceState.getString("SongStatus");

            PlayPause();
        }
        anim = new Animations(getApplicationContext(), tvNowPlaying);
        anim.getAnimationsSlide();

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayPause();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songId = songId - 1;
                if (songId >= 1) {
                    SongStatus = "";
                    fillData(songId, "");
                } else
                    songId = songId + 1;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                songId = songId + 1;
                SongStatus = "";
                fillData(songId, SongStatus);
            }
        });

    }

    private void PlayPause() {
        if (flag) {
            btnPause.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_media_play, 0, 0, 0);
            flag = false;
            SongStatus = getResources().getString(R.string.pause);
            fillData(songId, SongStatus);
        } else {
            btnPause.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_media_pause, 0, 0, 0);
            flag = true;
            SongStatus = getResources().getString(R.string.play);
            fillData(songId, SongStatus);

        }
        anim.getAnimationsSlide();
    }

    private void findViewById() {
        tvTitleDetails = (TextView) findViewById(R.id.tvTitleDetails);
        tvArtistDetails = (TextView) findViewById(R.id.tvArtistDetails);
        tvDurationDetails = (TextView) findViewById(R.id.tvDurationDetails);
        tvNowPlaying = (TextView) findViewById(R.id.tvNowPlaying);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnNext = (Button) findViewById(R.id.btnNext);
    }

    private void fillData(int newId, String status) {

        ArrayList<Song> songsList = new ArrayList<Song>();
        SongGenerator songGenerator = new SongGenerator(getApplicationContext(), songsList);
        songGenerator.generateSongs();
        int SongsCount = songsList.size();

        if (newId > SongsCount) {
            songId = SongsCount;
            return;
        }
        for (Song song : songsList) {
            if (song.getId() == newId) {
                tvTitleDetails.setText(song.getTitle());
                tvArtistDetails.setText(song.getArtist());
                tvDurationDetails.setText(String.valueOf(song.getDuration()));
                tvNowPlaying.setText(getResources().getString(R.string.now_playing) + "  " + song.getTitle() + " " + status);

                anim = new Animations(getApplicationContext(), tvNowPlaying);
                anim.getAnimationsSlide();
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("songId", songId);
        outState.putInt("getId", song.getId());
        outState.putString("getTitle", song.getTitle());
        outState.putString("getArtist", song.getArtist());
        outState.putBoolean("flag", flag);
        outState.putString("SongStatus", SongStatus);

    }

}
