package com.example.clubsportif.accueil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clubsportif.Offers;
import com.example.clubsportif.R;
import com.example.clubsportif.aboutus.AboutUs;
import com.example.clubsportif.auth.MainActivity;
import com.example.clubsportif.contact.ContactUs;
import com.example.clubsportif.offers.OfferAdapter;
import com.example.clubsportif.offers.OffersWithListView;
import com.example.clubsportif.sports.Sports;

public class Accueil extends AppCompatActivity {
    androidx.cardview.widget.CardView card_offers;
    androidx.cardview.widget.CardView card_contact;
    androidx.cardview.widget.CardView card_sports;
    androidx.cardview.widget.CardView card_about;
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        card_offers=findViewById(R.id.card_offers);
        card_contact=findViewById(R.id.card_contactus);
        card_sports=findViewById(R.id.card_sports);
        card_about=findViewById(R.id.card_about);
        btn_logout=findViewById(R.id.btn_logout);
        card_offers.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(), OffersWithListView.class);
        startActivity(i);
    }
});
        card_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ContactUs.class);
                startActivity(i);
            }
        });
        card_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Sports.class);
                startActivity(i);
            }
        });
        card_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(i);

            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
