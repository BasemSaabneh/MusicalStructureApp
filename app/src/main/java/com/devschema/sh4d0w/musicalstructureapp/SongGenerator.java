package com.devschema.sh4d0w.musicalstructureapp;

import android.content.Context;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class SongGenerator {
    private Context context;
    private final ArrayList<Song> songs;

    public SongGenerator(Context context, ArrayList<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    public void generateSongs() {
        DecimalFormat twoDForm = new DecimalFormat("#.00");
        for (int i = 1; i <= 10; i++) {
            double duration = 0.2 + (i + (0.212) - (0.15 * i) / 2);
            duration = Double.valueOf(twoDForm.format(duration));
            songs.add(new Song(i, context.getResources().getString(R.string.song) + " " + i, context.getResources().getString(R.string.artist) + i, duration));
        }
    }
}
