package com.devschema.sh4d0w.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(@NonNull Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_row, parent, false
            );
        }

        Song song = getItem(position);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvArtist = (TextView) convertView.findViewById(R.id.tvArtist);
        TextView tvDuration = (TextView) convertView.findViewById(R.id.tvDuration);

        tvTitle.setText(song.getTitle().toString());
        tvArtist.setText(song.getArtist().toString());
        tvDuration.setText(String.valueOf(song.getDuration()));

        return convertView;

    }
}
