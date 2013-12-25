package com.example.otoge_;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity implements OnTouchListener {
        
        Button BD_button, snare_button, hihat_button, open_button,                  //ˆê’i–Ú
               clap_button, bassline_button, tom1_button, tom2_button,              //“ñ’i–Ú
               BD2_button, snare2_button, ride_button, crash_button,                //ŽO’i–Ú
               perc_button, splash_button, SFX_button, triangle_button;             //Žl’i–Ú
               
        Button start_button, stay_button, return_button;                


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE); 
            setContentView(R.layout.activity_main);
                
        //ˆê’i–Ú
        BD_button = (Button) findViewById(R.id.num_button1);
        snare_button = (Button) findViewById(R.id.ride01_button);
        hihat_button = (Button) findViewById(R.id.num_button3);
        open_button = (Button) findViewById(R.id.num_button4);
        //“ñ’i–Ú
        clap_button = (Button) findViewById(R.id.num_button5);
        bassline_button = (Button) findViewById(R.id.bd01_button);
        tom1_button = (Button) findViewById(R.id.kick_button);
        tom2_button = (Button) findViewById(R.id.tom123_button);
        //ŽO’i–Ú
        BD2_button = (Button) findViewById(R.id.num_button9);
        snare2_button = (Button) findViewById(R.id.sn01_button);
        ride_button = (Button) findViewById(R.id.sn02_button);
        crash_button = (Button) findViewById(R.id.clach_button);
        //Žl’i–Ú
        perc_button = (Button) findViewById(R.id.num_button13);
        splash_button = (Button) findViewById(R.id.num_button14);
        SFX_button = (Button) findViewById(R.id.num_button15);
        triangle_button = (Button) findViewById(R.id.clap_button);
        
        start_button = (Button) findViewById(R.id.StartButton1);
        stay_button = (Button) findViewById(R.id.StayButton1);
        return_button = (Button) findViewById(R.id.ReturnButton1);
        
        //ˆê’i–Ú
        BD_button.setOnTouchListener(this);
        snare_button.setOnTouchListener(this);
        hihat_button.setOnTouchListener(this);
        open_button.setOnTouchListener(this);
        //“ñ’i–Ú
        clap_button.setOnTouchListener(this);
        bassline_button.setOnTouchListener(this);
        tom1_button.setOnTouchListener(this);
        tom2_button.setOnTouchListener(this);
        //ŽO’i–Ú
        BD2_button.setOnTouchListener(this);
        snare2_button.setOnTouchListener(this);
        ride_button.setOnTouchListener(this);
        crash_button.setOnTouchListener(this);
        //Žl’i–Ú
        perc_button.setOnTouchListener(this);
        splash_button.setOnTouchListener(this);
        SFX_button.setOnTouchListener(this);
        triangle_button.setOnTouchListener(this);
        
        start_button.setOnTouchListener(this);
        stay_button.setOnTouchListener(this);
        return_button.setOnTouchListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        return false;
    }
}