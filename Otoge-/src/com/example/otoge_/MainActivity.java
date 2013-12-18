package com.example.otoge_;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
//import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnTouchListener {
	
	ImageButton BD_button, snare_button, hihat_button, open_button,			//一段目
			    clap_button, bassline_button, tom1_button, tom2_button,		//二段目
			    BD2_button, snare2_button, ride_button, crash_button,		//三段目
			    perc_button, splash_button, SFX_button, triangle_button,	//四段目
			    start_button, stay_button, return_button;		

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_main);
		
		//一段目
        BD_button = (ImageButton) findViewById(R.id.num_button1);
        snare_button = (ImageButton) findViewById(R.id.ride01_button);
        hihat_button = (ImageButton) findViewById(R.id.num_button3);
        open_button = (ImageButton) findViewById(R.id.num_button4);
        //二段目
        clap_button = (ImageButton) findViewById(R.id.num_button5);
        bassline_button = (ImageButton) findViewById(R.id.bd01_button);
        tom1_button = (ImageButton) findViewById(R.id.kick_button);
        tom2_button = (ImageButton) findViewById(R.id.tom123_button);
        //三段目
        BD2_button = (ImageButton) findViewById(R.id.num_button9);
        snare2_button = (ImageButton) findViewById(R.id.sn01_button);
        ride_button = (ImageButton) findViewById(R.id.sn02_button);
        crash_button = (ImageButton) findViewById(R.id.clach_button);
        //四段目
        perc_button = (ImageButton) findViewById(R.id.num_button13);
        splash_button = (ImageButton) findViewById(R.id.num_button14);
        SFX_button = (ImageButton) findViewById(R.id.num_button15);
        triangle_button = (ImageButton) findViewById(R.id.clap_button);
        
        start_button = (ImageButton) findViewById(R.id.StartButton1);
        stay_button = (ImageButton) findViewById(R.id.StayButton1);
        return_button = (ImageButton) findViewById(R.id.ReturnButton1);
        
        //一段目
        BD_button.setOnTouchListener(this);
        snare_button.setOnTouchListener(this);
        hihat_button.setOnTouchListener(this);
        open_button.setOnTouchListener(this);
        //二段目
        clap_button.setOnTouchListener(this);
        bassline_button.setOnTouchListener(this);
        tom1_button.setOnTouchListener(this);
        tom2_button.setOnTouchListener(this);
        //三段目
        BD2_button.setOnTouchListener(this);
        snare2_button.setOnTouchListener(this);
        ride_button.setOnTouchListener(this);
        crash_button.setOnTouchListener(this);
        //四段目
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
