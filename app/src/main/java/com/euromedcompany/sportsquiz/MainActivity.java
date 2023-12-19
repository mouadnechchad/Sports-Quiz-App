package com.euromedcompany.sportsquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.start_btn);
        Button aboutUsButton = findViewById(R.id.aboutUsbtn);
        Button quitButton = findViewById(R.id.quit_btn);


        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the method to show the exit confirmation dialog
                onBackPressed();
            }
        });
        // Connect start button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ChooseSportActivity when the button is clicked
                Intent intent = new Intent(MainActivity.this, ChooseSportActivity.class);
                startActivity(intent);
            }
        });
        //Connect about Us button
        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the About Us page
                Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed(){
        ConfirmExit();
    }
    private void ConfirmExit() {
        // Create an AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        // Set the title and message for the dialog
        builder.setTitle("Exit App");
        builder.setMessage("Are you sure you want to exit?");

        // Add buttons to the dialog
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // If the user clicks "Yes", finish the activity
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // If the user clicks "No", dismiss the dialog (do nothing)
                dialog.dismiss();
            }
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
};