package com.example.mprog1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static int[] ids = {R.id.arms, R.id.hat, R.id.mustache, R.id.shoes, R.id.mouth, R.id.nose, R.id.glasses, R.id.eyes, R.id.eyebrows};
    public static String[] ids_strings = {"arms", "hat", "mustache", "shoes", "mouth", "nose", "glasses", "eyes", "eyebrows"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            for (int i = 0; i < 9; i++){
                ImageView image = (ImageView) findViewById(ids[i]);
                if (savedInstanceState.getInt(ids_strings[i]) ==View.VISIBLE){
                    image.setVisibility(View.VISIBLE);
                } else image.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        for (int i = 0; i < 9; i++){
            ImageView image = (ImageView) findViewById(ids[i]);
            int vis = image.getVisibility();
            outState.putInt(ids_strings[i], vis);
        }
    }

    public void checkClicked(View v) {
        Log.d("potato", "checkClicked");

        CheckBox checkbox = (CheckBox) v;
        boolean c = checkbox.isChecked();
        String checkbox_text = checkbox.getText().toString();
        int id = getResources().getIdentifier(checkbox_text, "id", getPackageName());
        ImageView image = (ImageView) findViewById(id);

        if (c) {
            image.setVisibility(View.VISIBLE);
        } else image.setVisibility(View.INVISIBLE);
    }
}
