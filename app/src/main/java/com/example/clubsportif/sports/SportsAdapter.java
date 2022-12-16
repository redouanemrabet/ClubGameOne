package com.example.clubsportif.sports;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.clubsportif.R;
import com.example.clubsportif.offers.Offre;
import com.example.clubsportif.offers.Register;

import java.util.ArrayList;

public class SportsAdapter extends ArrayAdapter<Sport> {
public View currentItemView1;
public SportsAdapter(@NonNull Context context, ArrayList<Sport> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
        }
@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    // convertView which is recyclable view
    View currentItemView = convertView;


    // of the recyclable view is null then inflate the custom layout for the same
    if (currentItemView == null) {
        currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.template_sports, parent, false);
        currentItemView1 = currentItemView;
    }


    // get the position of the view from the ArrayAdapter
    Sport currentCountryPosition = getItem(position);

    // then according to the position of the view assign the desired image for the same
    ImageView numbersImage = currentItemView.findViewById(R.id.template_image);
    assert currentCountryPosition != null;
    numbersImage.setImageResource(currentCountryPosition.getImage());

    // then according to the position of the view assign the desired TextView 1 for the same
    TextView textView1 = currentItemView.findViewById(R.id.template_title);
    textView1.setText(currentCountryPosition.getTitle());


    return currentItemView;
}

}
