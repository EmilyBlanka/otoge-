package com.example.otoge_;

import java.util.Timer;
import java.util.TimerTask;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnTouchListener {
	
		SoundPool bd, snare, hihat, open, clap, bassline, tom1, tom2,
		bd2, snare2, ride, crash, perc, splash, sfx, triangle;
	
		Button bd_button, snare_button, hihat_button, open_button,	//一段目
		clap_button, bassline_button, tom1_button, tom2_button,		//二段目
		bd2_button, snare2_button, ride_button, crash_button,		//三段目
		perc_button, splash_button, sfx_button, triangle_button;	//四段目
		
		int sound_id1, sound_id2, sound_id3, sound_id4, sound_id5, sound_id6,
		sound_id7, sound_id8, sound_id9, sound_id10, sound_id11, sound_id12,
		sound_id13, sound_id14, sound_id15, sound_id16;
	       
		ImageButton	start_button, stay_button, return_button;		
		
		ImageView tap_button1,tap_button2,tap_button3,tap_button4,tap_button5,
		tap_button6,tap_button7,tap_button8,tap_button9,tap_button10,tap_button11,
		tap_button12,tap_button13,tap_button14,tap_button15,tap_button16;
		
		
		private long justnow =0;  // 繰り返しの間隔（単位：msec）
		int AniDly = 400; //ボタンのアニメーションが開始から終了までの間隔（単位：msec）
		private long[] delay1={2327,5964,9600,};
		private long[] delay2={10509,11191,11873,12595,13236,13691,};
		private long[] delay3={2555,6191,9827,10509,11191,11873,12595,13236,13691};
		private long TouchTimeMillis;
		private long StartTimeMillis;
		private long Time;
		int score=0;
		
		Timer timer =new Timer();
		Handler handler;
		
		Data data1 =new Data(-1);
		Data data2 =new Data(-1);
		

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_main);
		
		bd = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        snare = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        hihat = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        open = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 ); 
        clap = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        bassline = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        tom1 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        tom2 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        bd2 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        snare2 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        ride = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        crash = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        perc = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        splash = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sfx = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        triangle = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		
        sound_id1 = bd.load(this, R.raw.bd_01, 1 );
        sound_id2 = snare.load(this, R.raw.sn_01, 1 );
        sound_id3 = hihat.load(this, R.raw.hh_01, 1 );
        sound_id4 = open.load(this, R.raw.open_hh_01, 1 );  
        sound_id5 = clap.load(this, R.raw.hanb_clap_01, 1 );
        sound_id6 = bassline.load(this, R.raw.bass_riff_01, 1 );
        sound_id7 = tom1.load(this, R.raw.tom_01, 1 );
        sound_id8 = tom2.load(this, R.raw.tom_02, 1 );
        sound_id9 = bd2.load(this, R.raw.kick_02, 1 );
        sound_id10 = snare2.load(this, R.raw.snare_02, 1 );
        sound_id11 = ride.load(this, R.raw.ride_01, 1 );
        sound_id12 = crash.load(this, R.raw.crash_01, 1 );
        sound_id13 = perc.load(this, R.raw.perc_01, 1 );
        sound_id14 = splash.load(this, R.raw.splash_01, 1 );
        sound_id15 = sfx.load(this, R.raw.sfx_01, 1 );
        sound_id16 = triangle.load(this, R.raw.triangle_01, 1 );
        
        bd_button = (Button) findViewById(R.id.TapButton1);
        snare_button = (Button) findViewById(R.id.TapButton2);
        hihat_button = (Button) findViewById(R.id.TapButton3);
        open_button = (Button) findViewById(R.id.TapButton4);
        clap_button = (Button) findViewById(R.id.TapButton5);
        bassline_button = (Button) findViewById(R.id.TapButton6);
        tom1_button = (Button) findViewById(R.id.TapButton7);
        tom2_button = (Button) findViewById(R.id.TapButton8);
        bd2_button = (Button) findViewById(R.id.TapButton9);
        snare2_button = (Button) findViewById(R.id.TapButton10);
        ride_button = (Button) findViewById(R.id.TapButton11);
        crash_button = (Button) findViewById(R.id.TapButton12);
        perc_button = (Button) findViewById(R.id.TapButton13);
        splash_button = (Button) findViewById(R.id.TapButton14);
        sfx_button = (Button) findViewById(R.id.TapButton15);
        triangle_button = (Button) findViewById(R.id.TapButton16);
        stay_button = (ImageButton) findViewById(R.id.StayButton1);
        return_button = (ImageButton) findViewById(R.id.ReturnButton1);
      
        tap_button1 = (ImageView) findViewById(R.id.TapImage1);
        tap_button2 = (ImageView) findViewById(R.id.TapImage2);
        tap_button3 = (ImageView) findViewById(R.id.TapImage3);
        tap_button4 = (ImageView) findViewById(R.id.TapImage4);
        tap_button5 = (ImageView) findViewById(R.id.TapImage5);
        tap_button6 = (ImageView) findViewById(R.id.TapImage6);
        tap_button7 = (ImageView) findViewById(R.id.TapImage7);
        tap_button8 = (ImageView) findViewById(R.id.TapImage8);
        tap_button9 = (ImageView) findViewById(R.id.TapImage9);
        tap_button10 = (ImageView) findViewById(R.id.TapImage10);
        tap_button10 = (ImageView) findViewById(R.id.TapImage11);
        tap_button12 = (ImageView) findViewById(R.id.TapImage12);
        tap_button13 = (ImageView) findViewById(R.id.TapImage13);
        tap_button14 = (ImageView) findViewById(R.id.TapImage14);
        tap_button15 = (ImageView) findViewById(R.id.TapImage15);
        tap_button16 = (ImageView) findViewById(R.id.TapImage16);
               
        bd_button.setOnTouchListener(this);
        snare_button.setOnTouchListener(this);
        hihat_button.setOnTouchListener(this);
        open_button.setOnTouchListener(this);
        clap_button.setOnTouchListener(this);
        bassline_button.setOnTouchListener(this);
        tom1_button.setOnTouchListener(this);
        tom2_button.setOnTouchListener(this);
        bd2_button.setOnTouchListener(this);
        snare2_button.setOnTouchListener(this);
        ride_button.setOnTouchListener(this);
        crash_button.setOnTouchListener(this);
        perc_button.setOnTouchListener(this);
        splash_button.setOnTouchListener(this);
        sfx_button.setOnTouchListener(this);
        triangle_button.setOnTouchListener(this);
             
        stay_button.setOnTouchListener(this);
        return_button.setOnTouchListener(this);

        handler = new Handler();
        
        // タイマー開始ボタンの処理
        		ImageButton start_button = (ImageButton)findViewById(R.id.StartButton1);
        		start_button.setOnClickListener(new View.OnClickListener() {
        			@Override
        			public void onClick(View v) {
        				
        				//現在時刻を取得
        				StartTimeMillis = System.currentTimeMillis();
        				
        				// タイマー1をセット
        				TimerTask timerTask0 = new BGMTask(MainActivity.this);
        				timer.schedule(timerTask0, justnow);

        				//ボタン1のアニメーションタイマー・タスクのセット
        				for(int i=0; i < delay1.length; i++) {	
        					TimerTask timerTask1 = new AnimationTask(MainActivity.this,handler,tap_button1);
        					timer.schedule(timerTask1, delay1[i]); 
        					
        					TimerTask timerTask2 = new DataNoTask(MainActivity.this,handler,data1);
        					timer.schedule(timerTask2, delay1[i]+AniDly-(AniDly/2));

        					TimerTask timerTask3 = new DataFlagTask(MainActivity.this,handler,data1);
        					timer.schedule(timerTask3, delay1[i]+AniDly+(AniDly/2));		
        				}	
        				
        				//ボタン2のアニメーションタイマー・タスクのセット
        				for(int i=0; i < delay2.length; i++) {	
        					TimerTask timertask4 = new AnimationTask(MainActivity.this,handler,tap_button2);
        					timer.schedule(timertask4, delay2[i]); 
        					
        					TimerTask timerTask5 = new DataNoTask(MainActivity.this,handler,data2);
        					timer.schedule(timerTask5, delay2[i]+AniDly-(AniDly/2));

        					TimerTask timerTask6 = new DataFlagTask(MainActivity.this,handler,data2);
        					timer.schedule(timerTask6, delay2[i]+AniDly+(AniDly/2));			
        				}			
        			}
        		});
    }

    @Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		int GreLan =30;
		int GodLan =50;
		int BadLan =50;
		
		String stringscore = String.valueOf(score);
		TextView textView0 = (TextView) findViewById(R.id.textView1);
		textView0.setText(stringscore);
		
		TouchTimeMillis = System.currentTimeMillis();
		Time =TouchTimeMillis-StartTimeMillis;
		 
		if((event.getAction() == MotionEvent.ACTION_DOWN) || (event.getAction() == MotionEvent.ACTION_POINTER_DOWN)) {
			switch (v.getId()) {
			case R.id.TapButton1:
				
				bd.play(sound_id1, 1.0F, 1.0F, 0, 0, 1.0F);
				if(data1.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data1.getFlag() ==1) {	
					if( delay1[data1.getNo()]+AniDly-GreLan <= Time && Time <= delay1[data1.getNo()]+AniDly+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						score +=70;
						break;
					} else if ((delay1[data1.getNo()]+AniDly-GreLan-GodLan) <= Time && Time < (delay1[data1.getNo()]+AniDly-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						score +=30;
						break;
					} else if ((delay1[data1.getNo()]+AniDly+GreLan) < Time && Time <= (delay1[data1.getNo()]+AniDly+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						score +=20;
						break;
					} else if ((delay1[data1.getNo()]+AniDly-GreLan-GodLan-BadLan) <= Time && Time < (delay1[data1.getNo()]+AniDly-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						break;
					} else if ((delay1[data1.getNo()]+AniDly+GreLan+GodLan) <= Time && Time < (delay1[data1.getNo()]+AniDly+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						break;		
					}	
						data1.init();	
						Log.d("aaaaaa", "0000001");
				}
				break;
				
			case R.id.TapButton2:
				snare.play(sound_id2, 1.0F, 1.0F, 0, 0, 1.0F);
				
				if(data2.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data2.getFlag() ==1) {	
					if( delay2[data2.getNo()]+AniDly-GreLan <= Time && Time <= delay2[data2.getNo()]+AniDly+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						score +=70;
						break;
					} else if ((delay2[data2.getNo()]+AniDly-GreLan-GodLan) <= Time && Time < (delay2[data2.getNo()]+AniDly-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						score +=30;
						break;
					} else if ((delay2[data2.getNo()]+AniDly+GreLan) < Time && Time <= (delay2[data2.getNo()]+AniDly+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						score +=20;
						break;
					} else if ((delay2[data2.getNo()]+AniDly-GreLan-GodLan-BadLan) <= Time && Time < (delay2[data2.getNo()]+AniDly-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						break;
					} else if ((delay2[data2.getNo()]+AniDly+GreLan+GodLan) <= Time && Time < (delay2[data2.getNo()]+AniDly+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						break;		
					}	
						data2.init();	
						Log.d("aaaaaa", "0000002");
				}
			
				break;
			case R.id.TapButton3:
				hihat.play(sound_id3, 0.5F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton4:
				open.play(sound_id4, 0.5F, 1.0F, 0, 0, 1.0F);
				break;
				
			case R.id.TapButton5:
				clap.play(sound_id5, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton6:
				bassline.play(sound_id6, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton7:
				tom1.play(sound_id7, 0.5F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton8:
				tom2.play(sound_id8, 0.5F, 1.0F, 0, 0, 1.0F);
				break;
				
			case R.id.TapButton9:
				bd2.play(sound_id9, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton10:
				snare2.play(sound_id10, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton11:
				ride.play(sound_id11, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton12:
				crash.play(sound_id12, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
				
			case R.id.TapButton13:
				perc.play(sound_id13, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton14:
				splash.play(sound_id14, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton15:
				sfx.play(sound_id15, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
			case R.id.TapButton16:
				triangle.play(sound_id16, 1.0F, 1.0F, 0, 0, 1.0F);
				break;
			}
			return true;
		}else if((event.getAction() == MotionEvent.ACTION_UP) || (event.getAction() == MotionEvent.ACTION_POINTER_UP)) {
			switch (v.getId()) {
			case R.id.TapButton1:
				bd.stop(sound_id1);
				break;
			case R.id.TapButton2:
				snare.stop(sound_id2);
				break;
			case R.id.TapButton3:
				hihat.stop(sound_id3);
				break;
			case R.id.TapButton4:
				open.stop(sound_id4);
				break;
				
			case R.id.TapButton5:
				clap.stop(sound_id5);
				break;
			case R.id.TapButton6:
				bassline.stop(sound_id6);
				break;
			case R.id.TapButton7:
				tom1.stop(sound_id7);
				break;
			case R.id.TapButton8:
				tom2.stop(sound_id8);
				break;
				
			case R.id.TapButton9:
				bd2.stop(sound_id9);
				break;
			case R.id.TapButton10:
				snare2.stop(sound_id10);
				break;
			case R.id.TapButton11:
				ride.stop(sound_id11);
				break;
			case R.id.TapButton12:
				crash.stop(sound_id12);
				break;
				
			case R.id.TapButton13:
				perc.stop(sound_id13);
				break;
			case R.id.TapButton14:
				splash.stop(sound_id14);
				break;
			case R.id.TapButton15:
				sfx.stop(sound_id15);
				break;
			case R.id.TapButton16:
				triangle.stop(sound_id16);
				break;
			}
            return true;
        }
		return false;
	}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    
}
