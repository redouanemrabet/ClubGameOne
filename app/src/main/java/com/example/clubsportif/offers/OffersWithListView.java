package com.example.clubsportif.offers;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.clubsportif.Offers;
import com.example.clubsportif.R;
import com.example.clubsportif.contact.ContactUs;

import java.util.ArrayList;

public class OffersWithListView extends AppCompatActivity {
    ListView listOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_offers);
        listOffers=findViewById(R.id.list_offers);

        ArrayList<Offre> offers=new ArrayList<>();
        offers.add(new Offre(R.drawable.foot, "FOOT BALL","40 $ per month ","Promotion of 3 months free if you register with us for 6 months"));
        offers.add(new Offre(R.drawable.basketball, "BASKET BALL","60 $ per month ","Promotion of 3 months free if you register with us for 6 months"));

        offers.add(new Offre(R.drawable.tennis, "TENNIS","50 $ per month","Promotion of 3 months free if you register with us for 6 months"));
        offers.add(new Offre(R.drawable.rugby, "RUGBY","40 $ per mont with two months for free.","Promotion of 3 months free if you register with us for 6 months"));
        offers.add(new Offre(R.drawable.volley, "VOLLEY BALL","50 $ per month","Promotion of 3 months free if you register with us for 6 months"));
        offers.add(new Offre(R.drawable.golf, "GOLF","50 $ per month","Promotion of 3 months free if you register with us for 6 months"));
        offers.add(new Offre(R.drawable.hand, "HAND BALL","50 $ per month","Promotion of 3 months free if you register with us for 6 months"));
        OfferAdapter theAdapter= new OfferAdapter(this,offers);

        this.listOffers.setAdapter(theAdapter);

       // Button buttonEdit = (Button) theAdapter.currentItemView1.findViewById(R.id.register_btn);
        /*buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });*/


    }



}
