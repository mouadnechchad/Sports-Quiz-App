package com.euromedcompany.sportsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChooseSportActivity extends AppCompatActivity {

    //private GridView gridView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sport);

        recyclerView = findViewById(R.id.recyclerView);
        // Configurez le RecyclerView avec un LinearLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        // Create a list of sports (you can replace this with your data)
        List<Sport> sports = getSports();

        // Create an adapter for the GridView
        SportAdapter adapter = new SportAdapter(this, sports);

        // Set the adapter to the GridView
        recyclerView.setAdapter(adapter);

        // Set click listener for RecyclerView items
        adapter.setOnItemClickListener(new SportAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Sport sport) {
                // Start QuizActivity and pass the selected sport
                Intent intent = new Intent(ChooseSportActivity.this, QuestionActivity.class);
                intent.putExtra("selectedSport", sport);
                startActivity(intent);
            }
        });
    }

    private List<Sport> getSports() {
        // Replace this with your data retrieval logic
        // This is a sample list, you should replace it with your actual data
        List<Sport> sports = new ArrayList<>();
        sports.add(new Sport("Football", R.drawable.football_img));
        sports.add(new Sport("Basketball", R.drawable.basketball_img));
        sports.add(new Sport("Tennis", R.drawable.tennis_image));
        sports.add(new Sport("Volleyball", R.drawable.volleyball_img));
        sports.add(new Sport("Formula 1", R.drawable.formula1_img));
        sports.add(new Sport("Athletics", R.drawable.athletics_img));
        // Add more sports...

        return sports;
    }
}
