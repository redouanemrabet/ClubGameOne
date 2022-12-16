package com.example.clubsportif.offers;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.clubsportif.R;
import com.example.clubsportif.aboutus.AboutUs;
import com.example.clubsportif.sports.Sports;

import java.util.ArrayList;

public class OfferAdapter extends ArrayAdapter<Offre> {
    public View currentItemView1;
    public OfferAdapter(@NonNull Context context, ArrayList<Offre> arrayList) {

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
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.template, parent, false);
            currentItemView1=currentItemView;
        }
        Button buttonEdit = (Button) currentItemView.findViewById(R.id.register_btn);
        ImageView imageView=(ImageView) currentItemView.findViewById(R.id.imagee_foot);

        // get the position of the view from the ArrayAdapter
        Offre currentCountryPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        ImageView numbersImage = currentItemView.findViewById(R.id.imagee_foot);
        assert currentCountryPosition != null;
        numbersImage.setImageResource(currentCountryPosition.getImage());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.title_card);
        textView1.setText(currentCountryPosition.getTitle());

        // then according to the position of the view assign the desired TextView 2 for the same
        TextView textView2 = currentItemView.findViewById(R.id.subtitle);
        textView2.setText(currentCountryPosition.getSubtitle());
        TextView textView3 = currentItemView.findViewById(R.id.subtitle2);
        textView3.setText(currentCountryPosition.getSubtitle2());
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext() , Register.class);


                getContext().startActivity(i);

            }
        });
        // then return the recyclable view
        return currentItemView;
    }
}
