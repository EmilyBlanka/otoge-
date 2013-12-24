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
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnTouchListener {
	
		SoundPool kick, bd, clap, tom123, bd2, snare2, ride, crash, snare1;
	
		Button ride_button, bd_button, snare1_button, snare2_button, clap_button, tom123_button,
		kick_button, crash_button;
		
		int sound_id1, sound_id2, sound_id3, sound_id4, sound_id5, sound_id6,
		sound_id7, sound_id8, sound_id9, sound_id10, sound_id11, sound_id12,
		sound_id13, sound_id14, sound_id15, sound_id16;
	       
		ImageButton	start_button, stay_button, return_button;		
		
		ImageView tap_button1,tap_button2,tap_button3,tap_button4,tap_button5,
		tap_button6,tap_button7,tap_button8,tap_button9,tap_button10,tap_button11,
		tap_button12,tap_button13,tap_button14,tap_button15,tap_button16;
		
		
		private long justnow =0;  // 繰り返しの間隔（単位：msec）
		int AniDly = 400; //ボタンのアニメーションが開始から終了までの間隔（単位：msec）
		
		private long[] delay1={};
		//ride(10509)
		private long[] delay2={10509,11191,11873,12595,13236,13691,57782,58464,59600,60282,61418,62100,63236,63918,65054,
		65736,66873,67554,68691,69373,70509,71191,72327,73009,74145,74827,75964,76645,77782,78464,79145};
		/*private long[] delay2={500,1000,1500,2000,2500,3000};*/
		private long[] delay3={};
		private long[] delay4={};
		private long[] delay5={};
		//bd(2727)
		/*private long[] delay6={700,1200,1700,2200,2700,3200};*/
		private long[] delay6={2327,5964,9600,10509,11191,11873,12595,13236,13691,14145,15964,16418,17782,18009,18464,19145,19373,19827,21418,
		23236,23691,25055,25282,25736,26418,26645,27100,35055,35282,42327,42782,43236,45055,45736,46873,48691,50509,52327,53009,
		54145,55964,56645,65054,65736,66873,67554,68691,69373,70509,71191};
		//kick
		private long[] delay7={44373,46191,48009,49827,51645,53464,55282,57100,57441};
		//toms(2955)
		private long[] delay8={2555,6191,9827,64600};
		private long[] delay9={};
		//SN
		private long[] delay10={15055,16873,18691,20055,22327,24145,25964,27327,27782,28236,35509,35736,42555,
		43009,44600,46418,48236,50054,51873,53691,55509,57327,57554};
		//SN2
		private long[] delay11={15055,16873,18691,20055,22327,24145,25964,27327,27782,28236,35509,35736,42555,
				43009,44600,46418,48236,50054,51873,53691,55509,57327,57554};
		//clash
		private long[] delay12={20509,28691,35964,43236,50509};
		private long[] delay13={};
		private long[] delay14={};
		private long[] delay15={};
		//clap
		private long[] delay16={28691,29145,29600,30055,30509,30964,31418,31873,32327,32782,33236,33691,34145,34600,35964,
		36418,36873,37327,37782,38236,38691,39145,39600,40055,40509,40964,41418,41873};
		
		private long BGMTimeMillis;
		private long ButtonTimeMillis;
		private long AniTimeLag;
		private long AniTimeLagSum;
		private long TouchTimeMillis;
		private long StartTimeMillis;
		private long Time;
		int score=0;
		
		Timer timer =new Timer();
		Handler handler;
		
		Data data1 =new Data(-1);
		Data data2 =new Data(-1);
		Data data3 =new Data(-1);
		Data data4 =new Data(-1);
		Data data5 =new Data(-1);
		Data data6 =new Data(-1);
		Data data7 =new Data(-1);
		Data data8 =new Data(-1);
		Data data9 =new Data(-1);
		Data data10 =new Data(-1);
		Data data11 =new Data(-1);
		Data data12 =new Data(-1);
		Data data13 =new Data(-1);
		Data data14 =new Data(-1);
		Data data15 =new Data(-1);
		Data data16 =new Data(-1);
		
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_main);
		
		ride = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		bd = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		kick = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		tom123 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        snare1 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        snare2 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        crash = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        clap = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        
        sound_id2 = ride.load(this, R.raw.ride_01, 1 );
        sound_id6 = bd.load(this, R.raw.bd01, 1 );
        sound_id7 = kick.load(this, R.raw.kick_02, 1 );
        sound_id8 = tom123.load(this, R.raw.toms132, 1 );
        sound_id10 = snare1.load(this, R.raw.sn_01, 1 );
        sound_id11 = snare2.load(this, R.raw.snare_02, 1 );
        sound_id12 = crash.load(this, R.raw.crash_01, 1 );
        sound_id16 = clap.load(this, R.raw.hanb_clap_01, 1 );
        
        ride_button = (Button) findViewById(R.id.TapButton2);
        bd_button = (Button) findViewById(R.id.TapButton6);
        kick_button = (Button) findViewById(R.id.TapButton7);
        tom123_button = (Button) findViewById(R.id.TapButton8);
        snare1_button = (Button) findViewById(R.id.TapButton10);
        snare2_button = (Button) findViewById(R.id.TapButton11);
        crash_button = (Button) findViewById(R.id.TapButton12);
        clap_button = (Button) findViewById(R.id.TapButton16);
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
        tap_button11 = (ImageView) findViewById(R.id.TapImage11);
        tap_button12 = (ImageView) findViewById(R.id.TapImage12);
        tap_button13 = (ImageView) findViewById(R.id.TapImage13);
        tap_button14 = (ImageView) findViewById(R.id.TapImage14);
        tap_button15 = (ImageView) findViewById(R.id.TapImage15);
        tap_button16 = (ImageView) findViewById(R.id.TapImage16);
               
        bd_button.setOnTouchListener(this);
        clap_button.setOnTouchListener(this);
        tom123_button.setOnTouchListener(this);
        snare2_button.setOnTouchListener(this);
        snare1_button.setOnTouchListener(this);
        ride_button.setOnTouchListener(this);
        crash_button.setOnTouchListener(this);   
        kick_button.setOnTouchListener(this);
        stay_button.setOnTouchListener(this);
        return_button.setOnTouchListener(this);

        handler = new Handler();
        
        // タイマー開始ボタンの処理
        		ImageButton start_button = (ImageButton)findViewById(R.id.StartButton1);
        		start_button.setOnClickListener(new View.OnClickListener() {
        			@Override
        			public void onClick(View v) {
        				
        				
        				// タイマー1をセット
        				TimerTask timerTask0 = new BGMTask(MainActivity.this,BGMTimeMillis);
        				timer.schedule(timerTask0, 0);
        				Log.d("bgm", "timerset");
        				
        				
        				//ボタン2のアニメーションタイマー・タスクのセット
        				for(int i=0; i < delay2.length; i++) {	
        					ButtonTimeMillis = System.currentTimeMillis();
            				
            				AniTimeLag = ButtonTimeMillis- BGMTimeMillis;
            				Log.d("aaaaaaaaa", String.valueOf(BGMTimeMillis));
        					
            				AniTimeLagSum +=AniTimeLag;
            				/*Log.d("aaaaaaaaa", String.valueOf(AniTimeLagSum));*/
        					
        					TimerTask timerTask1 = new AnimationTask(MainActivity.this,handler,tap_button2);
        					timer.schedule(timerTask1, delay2[i]/*-AniTimeLagSum*/); 
        					Log.d("animation", "task");
        					  					
        					TimerTask timerTask2 = new DataNoTask(MainActivity.this,handler,data2);
        					timer.schedule(timerTask2, delay2[i]+AniDly-(AniDly/2));

        					TimerTask timerTask3 = new DataFlagTask(MainActivity.this,handler,data2);
        					timer.schedule(timerTask3, delay2[i]+AniDly+(AniDly/2));
        					
        					
        				}	
        				
        				//ボタン6のアニメーションタイマー・タスクのセット
        				for(int i=0; i < delay6.length; i++) {	
        					ButtonTimeMillis = System.currentTimeMillis();
        					
        					AniTimeLag = ButtonTimeMillis- BGMTimeMillis;
            				AniTimeLagSum +=AniTimeLag;
            				/*Log.d("aaaaaaaaa", String.valueOf(delay6[i]-AniTimeLagSum));*/
            				
        					TimerTask timertask4 = new AnimationTask(MainActivity.this,handler,tap_button6);
        					timer.schedule(timertask4, delay6[i]/*-AniTimeLagSum*/); 
        					
        					TimerTask timerTask5 = new DataNoTask(MainActivity.this,handler,data6);
        					timer.schedule(timerTask5, delay6[i]+AniDly-(AniDly/2));

        					TimerTask timerTask6 = new DataFlagTask(MainActivity.this,handler,data6);
        					timer.schedule(timerTask6, delay6[i]+AniDly+(AniDly/2));			
        				}		
        				
        				//ボタン7のアニメーションタイマー・タスクのセット
        				for(int i=0; i < delay7.length; i++) {	
        					/*ButtonTimeMillis = System.currentTimeMillis();
            				
            				AniTimeLag = ButtonTimeMillis- BGMTimeMillis;
            				AniTimeLagSum +=AniTimeLag*/;
            				
        					TimerTask timertask7 = new AnimationTask(MainActivity.this,handler,tap_button7);
        					timer.schedule(timertask7, delay7[i]/*-AniTimeLagSum*/); 
        					
        					TimerTask timerTask8 = new DataNoTask(MainActivity.this,handler,data7);
        					timer.schedule(timerTask8, delay7[i]+AniDly-(AniDly/2));

        					TimerTask timerTask9 = new DataFlagTask(MainActivity.this,handler,data7);
        					timer.schedule(timerTask9, delay7[i]+AniDly+(AniDly/2));			
        				}	
        				
        				//ボタン8のアニメーションタイマー・タスクのセット
        				for(int i=0; i < delay8.length; i++) {	
        					/*ButtonTimeMillis = System.currentTimeMillis();
            				
            				AniTimeLag = ButtonTimeMillis- BGMTimeMillis;
            				AniTimeLagSum +=AniTimeLag;*/
        					
        					TimerTask timertask10 = new AnimationTask(MainActivity.this,handler,tap_button8);
        					timer.schedule(timertask10, delay8[i]/*-AniTimeLagSum*/);

        					TimerTask timerTask11 = new DataNoTask(MainActivity.this,handler,data8);
        					timer.schedule(timerTask11, delay8[i]+AniDly-(AniDly/2));

        					TimerTask timerTask12 = new DataFlagTask(MainActivity.this,handler,data8);
        					timer.schedule(timerTask12, delay8[i]+AniDly+(AniDly/2));			
        				}
        				
        				//ボタン10のアニメーションタイマー・タスクのセット
        				for(int i=0; i < delay10.length; i++) {	
        					/*ButtonTimeMillis = System.currentTimeMillis();
            				
            				AniTimeLag = ButtonTimeMillis- BGMTimeMillis;
            				AniTimeLagSum +=AniTimeLag;
            				*/
        					TimerTask timertask13= new AnimationTask(MainActivity.this,handler,tap_button10);
        					timer.schedule(timertask13, delay10[i]/*-AniTimeLagSum*/); 
        					
        					TimerTask timerTask14 = new DataNoTask(MainActivity.this,handler,data10);
        					timer.schedule(timerTask14, delay10[i]+AniDly-(AniDly/2));

        					TimerTask timerTask15 = new DataFlagTask(MainActivity.this,handler,data10);
        					timer.schedule(timerTask15, delay10[i]+AniDly+(AniDly/2));			
        				}
        				
        				//ボタン11のアニメーションタイマー・タスクのセット
        				/*ButtonTimeMillis = System.currentTimeMillis();
        				
        				AniTimeLag = ButtonTimeMillis- BGMTimeMillis;
        				AniTimeLagSum +=AniTimeLag;*/
        				
        				for(int i=0; i < delay11.length; i++) {	
        					TimerTask timertask16= new AnimationTask(MainActivity.this,handler,tap_button11);
        					timer.schedule(timertask16, delay11[i]/*-AniTimeLagSum*/); 
        					
        					TimerTask timerTask17 = new DataNoTask(MainActivity.this,handler,data11);
        					timer.schedule(timerTask17, delay11[i]+AniDly-(AniDly/2));

        					TimerTask timerTask18 = new DataFlagTask(MainActivity.this,handler,data11);
        					timer.schedule(timerTask18, delay11[i]+AniDly+(AniDly/2));			
        				}
        				
        				//ボタン12のアニメーションタイマー・タスクのセット
        				/*ButtonTimeMillis = System.currentTimeMillis();
        				
        				AniTimeLag = ButtonTimeMillis- BGMTimeMillis;
        				AniTimeLagSum +=AniTimeLag;*/
        				
        				for(int i=0; i < delay12.length; i++) {	
        					TimerTask timertask19= new AnimationTask(MainActivity.this,handler,tap_button12);
        					timer.schedule(timertask19, delay12[i]/*-AniTimeLagSum*/); 
        					
        					TimerTask timerTask20 = new DataNoTask(MainActivity.this,handler,data12);
        					timer.schedule(timerTask20, delay12[i]+AniDly-(AniDly/2));

        					TimerTask timerTask21 = new DataFlagTask(MainActivity.this,handler,data12);
        					timer.schedule(timerTask21, delay12[i]+AniDly+(AniDly/2));			
        				}
        				
        				//ボタン16のアニメーションタイマー・タスクのセット
        				/*ButtonTimeMillis = System.currentTimeMillis();
        				
        				AniTimeLag = ButtonTimeMillis- BGMTimeMillis;
        				AniTimeLagSum +=AniTimeLag;*/
        				
        				for(int i=0; i < delay16.length; i++) {	
        					TimerTask timertask22= new AnimationTask(MainActivity.this,handler,tap_button16);
        					timer.schedule(timertask22, delay16[i]/*-AniTimeLagSum*/); 
        					
        					TimerTask timerTask23 = new DataNoTask(MainActivity.this,handler,data16);
        					timer.schedule(timerTask23, delay16[i]+AniDly-(AniDly/2));

        					TimerTask timerTask24 = new DataFlagTask(MainActivity.this,handler,data16);
        					timer.schedule(timerTask24, delay16[i]+AniDly+(AniDly/2));			
        				}
        				
        				//現在時刻を取得
        				StartTimeMillis = System.currentTimeMillis();
        				Log.d("system time","StartTimeMillis" );
        				
        				
        			}
        		});
    }

    @Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		int GreLan =50;
		int GodLan =100;
		int BadLan =50;
		
		String stringscore = String.valueOf(score);
		TextView textView0 = (TextView) findViewById(R.id.textView1);
		textView0.setText(stringscore);
		
		TouchTimeMillis = System.currentTimeMillis();
		Time =TouchTimeMillis-StartTimeMillis;
		 
		if((event.getAction() == MotionEvent.ACTION_DOWN) || (event.getAction() == MotionEvent.ACTION_POINTER_DOWN)) {
			switch (v.getId()) {
			case R.id.TapButton2:
				ride.play(sound_id2, 1.0F, 1.0F, 0, 0, 1.0F);
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
				}
				break;
				
			case R.id.TapButton6:
				bd.play(sound_id6, 1.0F, 1.0F, 0, 0, 1.0F);
				
				if(data6.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data6.getFlag() ==1) {	
					if( delay6[data6.getNo()]+AniDly-GreLan <= Time && Time <= delay6[data6.getNo()]+AniDly+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						score +=70;
						break;
					} else if ((delay6[data6.getNo()]+AniDly-GreLan-GodLan) <= Time && Time < (delay6[data6.getNo()]+AniDly-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						score +=30;
						break;
					} else if ((delay6[data6.getNo()]+AniDly+GreLan) < Time && Time <= (delay6[data6.getNo()]+AniDly+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						score +=20;
						break;
					} else if ((delay6[data6.getNo()]+AniDly-GreLan-GodLan-BadLan) <= Time && Time < (delay6[data6.getNo()]+AniDly-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						break;
					} else if ((delay6[data6.getNo()]+AniDly+GreLan+GodLan) <= Time && Time < (delay6[data6.getNo()]+AniDly+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						break;		
					}	
						data6.init();	
				}
			
				break;
		
			case R.id.TapButton7:
				kick.play(sound_id7, 0.5F, 1.0F, 0, 0, 1.0F);

				if(data7.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data7.getFlag() ==1) {	
					if( delay7[data7.getNo()]+AniDly-GreLan <= Time && Time <= delay7[data7.getNo()]+AniDly+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						score +=70;
						break;
					} else if ((delay7[data7.getNo()]+AniDly-GreLan-GodLan) <= Time && Time < (delay7[data7.getNo()]+AniDly-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						score +=30;
						break;
					} else if ((delay7[data7.getNo()]+AniDly+GreLan) < Time && Time <= (delay7[data7.getNo()]+AniDly+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						score +=20;
						break;
					} else if ((delay7[data7.getNo()]+AniDly-GreLan-GodLan-BadLan) <= Time && Time < (delay7[data7.getNo()]+AniDly-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						break;
					} else if ((delay7[data7.getNo()]+AniDly+GreLan+GodLan) <= Time && Time < (delay7[data7.getNo()]+AniDly+GreLan+GodLan+BadLan))  {
						TextView textView7 = (TextView) findViewById(R.id.valueView);
						textView7.setText("Bad.");
						break;		
					}	
						data7.init();	
				}
			
				break;
			case R.id.TapButton8:
				tom123.play(sound_id8, 0.5F, 1.0F, 0, 0, 1.0F);
				if(data8.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data8.getFlag() ==1) {	
					if( delay8[data8.getNo()]+AniDly-GreLan <= Time && Time <= delay8[data8.getNo()]+AniDly+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						score +=70;
						break;
					} else if ((delay8[data8.getNo()]+AniDly-GreLan-GodLan) <= Time && Time < (delay8[data8.getNo()]+AniDly-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						score +=30;
						break;
					} else if ((delay8[data8.getNo()]+AniDly+GreLan) < Time && Time <= (delay8[data8.getNo()]+AniDly+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						score +=20;
						break;
					} else if ((delay8[data8.getNo()]+AniDly-GreLan-GodLan-BadLan) <= Time && Time < (delay8[data8.getNo()]+AniDly-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						break;
					} else if ((delay8[data8.getNo()]+AniDly+GreLan+GodLan) <= Time && Time < (delay8[data8.getNo()]+AniDly+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						break;		
					}	
						data8.init();	
				}
				break;
			case R.id.TapButton10:
				snare1.play(sound_id10, 1.0F, 1.0F, 0, 0, 1.0F);
				if(data10.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data10.getFlag() ==1) {	
					if( delay10[data10.getNo()]+AniDly-GreLan <= Time && Time <= delay10[data10.getNo()]+AniDly+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						score +=70;
						break;
					} else if ((delay10[data10.getNo()]+AniDly-GreLan-GodLan) <= Time && Time < (delay10[data10.getNo()]+AniDly-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						score +=30;
						break;
					} else if ((delay10[data10.getNo()]+AniDly+GreLan) < Time && Time <= (delay10[data10.getNo()]+AniDly+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						score +=20;
						break;
					} else if ((delay10[data10.getNo()]+AniDly-GreLan-GodLan-BadLan) <= Time && Time < (delay10[data10.getNo()]+AniDly-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						break;
					} else if ((delay10[data10.getNo()]+AniDly+GreLan+GodLan) <= Time && Time < (delay10[data10.getNo()]+AniDly+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						break;		
					}	
						data10.init();	
				}
				break;
			case R.id.TapButton11:
				snare2.play(sound_id11, 1.0F, 1.0F, 0, 0, 1.0F);
				if(data11.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data11.getFlag() ==1) {	
					if( delay11[data11.getNo()]+AniDly-GreLan <= Time && Time <= delay11[data11.getNo()]+AniDly+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						score +=70;
						break;
					} else if ((delay11[data11.getNo()]+AniDly-GreLan-GodLan) <= Time && Time < (delay11[data11.getNo()]+AniDly-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						score +=30;
						break;
					} else if ((delay11[data11.getNo()]+AniDly+GreLan) < Time && Time <= (delay11[data11.getNo()]+AniDly+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						score +=20;
						break;
					} else if ((delay11[data11.getNo()]+AniDly-GreLan-GodLan-BadLan) <= Time && Time < (delay11[data11.getNo()]+AniDly-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						break;
					} else if ((delay11[data11.getNo()]+AniDly+GreLan+GodLan) <= Time && Time < (delay11[data11.getNo()]+AniDly+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						break;		
					}	
						data11.init();	
				}
				break;
			case R.id.TapButton12:
				crash.play(sound_id12, 1.0F, 1.0F, 0, 0, 1.0F);
				if(data12.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data12.getFlag() ==1) {	
					if( delay12[data12.getNo()]+AniDly-GreLan <= Time && Time <= delay12[data12.getNo()]+AniDly+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						score +=70;
						break;
					} else if ((delay12[data12.getNo()]+AniDly-GreLan-GodLan) <= Time && Time < (delay12[data12.getNo()]+AniDly-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						score +=30;
						break;
					} else if ((delay12[data12.getNo()]+AniDly+GreLan) < Time && Time <= (delay12[data12.getNo()]+AniDly+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						score +=20;
						break;
					} else if ((delay12[data12.getNo()]+AniDly-GreLan-GodLan-BadLan) <= Time && Time < (delay12[data12.getNo()]+AniDly-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						break;
					} else if ((delay12[data12.getNo()]+AniDly+GreLan+GodLan) <= Time && Time < (delay12[data12.getNo()]+AniDly+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						break;		
					}	
						data12.init();	
				}
				break;			
			case R.id.TapButton16:
				clap.play(sound_id16, 1.0F, 1.0F, 0, 0, 1.0F);
				if(data16.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data16.getFlag() ==1) {	
					if( delay16[data16.getNo()]+AniDly-GreLan <= Time && Time <= delay16[data16.getNo()]+AniDly+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						score +=70;
						break;
					} else if ((delay16[data16.getNo()]+AniDly-GreLan-GodLan) <= Time && Time < (delay16[data16.getNo()]+AniDly-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						score +=30;
						break;
					} else if ((delay16[data16.getNo()]+AniDly+GreLan) < Time && Time <= (delay16[data16.getNo()]+AniDly+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						score +=20;
						break;
					} else if ((delay16[data16.getNo()]+AniDly-GreLan-GodLan-BadLan) <= Time && Time < (delay16[data16.getNo()]+AniDly-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						break;
					} else if ((delay16[data16.getNo()]+AniDly+GreLan+GodLan) <= Time && Time < (delay16[data16.getNo()]+AniDly+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						break;		
					}	
						data16.init();	
				}
				break;
			}
			return true;
		}else if((event.getAction() == MotionEvent.ACTION_UP) || (event.getAction() == MotionEvent.ACTION_POINTER_UP)) {
			switch (v.getId()) {
			case R.id.TapButton2:
				ride.stop(sound_id2);
				break;
			case R.id.TapButton6:
				bd.stop(sound_id6);
				break;
			case R.id.TapButton7:
				kick.stop(sound_id7);
				break;
			case R.id.TapButton8:
				tom123.stop(sound_id8);
				break;
			case R.id.TapButton10:
				snare1.stop(sound_id10);
				break;
			case R.id.TapButton11:
				snare2.stop(sound_id11);
				break;
			case R.id.TapButton12:
				crash.stop(sound_id12);
				break;
			case R.id.TapButton16:
				clap.stop(sound_id16);
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
