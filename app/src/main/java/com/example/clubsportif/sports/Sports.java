package com.example.clubsportif.sports;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.clubsportif.R;
import com.example.clubsportif.offers.OfferAdapter;
import com.example.clubsportif.offers.Offre;

import java.util.ArrayList;
import java.util.List;

public class Sports  extends AppCompatActivity {
    /*ListView listSport;
    ArrayList<Offre> offers=new ArrayList<>();*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports);
        /*listSport=findViewById(R.id.listviewSports);

        ArrayList<Sport> listSports=new ArrayList<>();
        Sport basket_ball=new Sport(R.drawable.ic_baseline_sports_basketball_24,"BASKET BALL");
        Sport foot_ball=new Sport(R.drawable.ic_baseline_sports_soccer_24,"FOOT BALL");
        Sport volley_ball=new Sport(R.drawable.ic_baseline_sports_volleyball_24,"VOLLEY BALL");
        Sport rugby=new Sport(R.drawable.ic_baseline_sports_rugby_24,"RUGBY");
        Sport hand_ball=new Sport(R.drawable.ic_baseline_sports_handball_24,"HAND BALL");
        Sport golf=new Sport(R.drawable.ic_baseline_sports_golf_24,"GOLF");
        Sport tennis=new Sport(R.drawable.ic_baseline_sports_tennis_24,"TENNIS");

        offers.add(new Offre(R.drawable.foot, "FOOT BALL","50 $ per mont with two months for free.","Promotion of 3 months free for you"));
        offers.add(new Offre(R.drawable.basketball, "BASKET BALL","50 $ per mont with two months for free.","Promotion of 3 months free for you"));
        offers.add(new Offre(R.drawable.foot, "FOOT BALL","50 $ per mont with two months for free.","Promotion of 3 months free for you"));
        listSports.add(basket_ball);
        listSports.add(foot_ball);
        listSports.add(volley_ball);
        listSports.add(rugby);
        listSports.add(hand_ball);
        listSports.add(golf);
        listSports.add(tennis);
        SportsAdapter theAdapter= new SportsAdapter(this,listSports);

        this.listSport.setAdapter(theAdapter);*/





    }
}
