package dev.knight.olympius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreWorks();
        winnerWorks();
    }

    int[] score = {0, 0, 0};

    private void scoreWorks() {
        Button p1_win = findViewById(R.id.p1_win);
        Button p1_lose = findViewById(R.id.p1_lose);
        Button p2_win = findViewById(R.id.p2_win);
        Button p2_lose = findViewById(R.id.p2_lose);
        Button p3_win = findViewById(R.id.p3_win);
        Button p3_lose = findViewById(R.id.p3_lose);

        p1_win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score[0]++;
            }
        });

        p1_lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score[0]--;
            }
        });

        p2_win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score[1]++;
            }
        });

        p2_lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score[1]--;
            }
        });

        p3_win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score[2]++;
            }
        });

        p3_lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score[2]--;
            }
        });
    }

    private void winnerWorks() {
        Button who_button = findViewById(R.id.who_button);
        final TextView who_text = findViewById(R.id.who_text);
        who_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (score[0] > score[1] && score[0] > score[2]){
                    who_text.setText("Du is the winner!");
                } else if (score[1] > score[0] && score[1] > score[2]){
                    who_text.setText("Dudu is the winner!");
                } else if (score[2] > score[0] && score[2] > score[1]){
                    who_text.setText("Edu is the winner!");
                } else {
                    who_text.setText("There's no winner yet!");
                }
                who_text.setVisibility(View.VISIBLE);
            }
        });
    }
}