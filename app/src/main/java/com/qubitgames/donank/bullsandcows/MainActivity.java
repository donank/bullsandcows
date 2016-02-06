package com.qubitgames.donank.bullsandcows;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.qubitgames.donank.bullsandcows.NumberGenerator.number_generate;

public class MainActivity extends AppCompatActivity {

    int tries = 0;
    String target = String.valueOf(number_generate());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_guess = (Button) findViewById(R.id.button_guess);

        btn_guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkmate(v);
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void checkmate(View view) {

        EditText guess = (EditText) findViewById(R.id.guess_number);
        TextView log = (TextView) findViewById(R.id.status);

        int guess_num = Integer.parseInt(guess.getText().toString());

            int bulls = 0;
            int cows = 0;

            tries++;
            String guessStr = guess_num + "";
            for (int i = 0; i < 4; i++) {
                if (guessStr.charAt(i) == target.charAt(i)) {
                    bulls++;
                } else if (target.contains(guessStr.charAt(i) + "")) {
                    cows++;
                }
            }
            if (bulls == 4) {
                log.append("\n"+getString(R.string.youwon) + tries + getString(R.string.guesses));

            }
            else if(tries == 8){
                log.append("\n"+getString(R.string.youlost) + target);

            }
            else {
                log.setText(cows + getString(R.string.cowsand) + bulls + getString(R.string.bulls) + "\nCount: " + tries);

            }

    }
    }


