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
                int bigger = score[0];
                for (int i = 1; i < score.length; i++) {
                    if (score[i] > bigger) {
                        bigger = score[i];
                    }
                }
                int count = 0;
                for (int i = 0; i < score.length; i++) {
                    if (score[i] == bigger) {
                        count++;
                    }
                }
                if (count == 3) {
                    who_text.setText("The three tied.");
                }
                if (count == 2) {
                    for (int i = 0; i < score.length; i++) {
                        if (score[i] != bigger) {
                            switch (i) {
                                case 0:
                                    who_text.setText("Dudu and Edu tied.");
                                    break;
                                case 1:
                                    who_text.setText("Du and Edu tied.");
                                    break;
                                case 2:
                                    who_text.setText("Du and Dudu tied.");
                                    break;
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < score.length; i++) {
                        if (score[i] == bigger) {
                            switch (i) {
                                case 0:
                                    who_text.setText("Du is the winner!");
                                    break;
                                case 1:
                                    who_text.setText("Dudu is the winner.");
                                    break;
                                case 2:
                                    who_text.setText("Edu is the winner.");
                                    break;
                            }
                        }
                    }
                }
                who_text.setVisibility(View.VISIBLE);
            }
        });
    }
}