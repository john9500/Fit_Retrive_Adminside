package com.example.fit_retrive_adminside;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Artistret extends ArrayAdapter<John> {

    private Activity context;
    private List<John> artistList;

    public Artistret(Activity context, List<John> artistList) {
        super(context, R.layout.ret_firebaseadmin, artistList);
        this.context = context;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.ret_firebaseadmin, null, true);
        TextView id = (TextView) listview.findViewById(R.id.one);
        TextView respiration = (TextView) listview.findViewById(R.id.two);
        TextView blood = (TextView) listview.findViewById(R.id.three);
        TextView heart = (TextView) listview.findViewById(R.id.four);
        TextView oxygen = (TextView) listview.findViewById(R.id.five);
        TextView ast = (TextView) listview.findViewById(R.id.six);
        TextView name = (TextView) listview.findViewById(R.id.namee);
        John artist = artistList.get(position);

        id.setText("ID : "+artist.getArtistID());
        respiration.setText("Respiration : "+artist.getArtistRespiration());
        blood.setText("Blood Pressure : " + artist.getArtistbloodlevel());
        heart.setText("hear Rate : " +artist.getArtistheartrate());
        oxygen.setText("Oxygen Level : " +artist.getArtistoxylevel());
        ast.setText("Asthma Prediction: " +artist.getAstma());
        name.setText("Name: " +artist.getName());

        return listview;
    }
}
