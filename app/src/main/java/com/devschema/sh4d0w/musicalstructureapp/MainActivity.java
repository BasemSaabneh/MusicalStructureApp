package com.devschema.sh4d0w.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Song> songs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs = new ArrayList<Song>();
        SongGenerator songGenerator = new SongGenerator(getApplicationContext(), songs);
        songGenerator.generateSongs();

        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        Animations anim = new Animations(getApplicationContext(), listView);
        anim.getAnimationsSlow();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Song song = songs.get(position);
                Intent intent = new Intent(getApplicationContext(), NowPlayingActivity.class);
                intent.putExtra("Id", String.valueOf(song.getId()));
                intent.putExtra("Title", song.getTitle().toString());
                intent.putExtra("Artist", song.getArtist().toString());
                intent.putExtra("Duration", String.valueOf(song.getDuration()));
                startActivity(intent);
            }
        });
    }

}
