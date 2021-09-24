package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int SeekBarR, SeekBarG, SeekBarB;
    SeekBar red_Bar, green_Bar, blue_Bar;
    TextView mScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScreen = findViewById(R.id.myScreen);
        red_Bar = findViewById(R.id.bar_red);
        green_Bar = findViewById(R.id.bar_green);
        blue_Bar = findViewById(R.id.bar_blue);

        BackgroundColorUpdate();

        red_Bar.setOnSeekBarChangeListener(seekBarChangeListener);
        green_Bar.setOnSeekBarChangeListener(seekBarChangeListener);
        blue_Bar.setOnSeekBarChangeListener(seekBarChangeListener);



    }
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            BackgroundColorUpdate();

        }


        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    };

    private void BackgroundColorUpdate(){
        SeekBarR = red_Bar.getProgress();
        SeekBarG = green_Bar.getProgress();
        SeekBarB = blue_Bar.getProgress();

        mScreen.setBackgroundColor(
                0xff000000
                        + SeekBarR * 0x10000
                        + SeekBarG * 0x100
                        + SeekBarB
        );

    }

}