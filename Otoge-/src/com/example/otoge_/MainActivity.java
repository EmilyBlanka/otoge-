package com.example.otoge_;

import java.util.Timer;
import java.util.TimerTask;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {
	
		SoundPool sound1, sound2, sound3, sound4, sound5, sound7, sound6, sound8, 
		sound9, sound10, sound11,sound12, sound13,sound14, sound15, sound16;
		
		private int[] soundResouces = {
                R.raw.nosound,
                R.raw.ride_01,
                R.raw.bd01,
                R.raw.kick_02,
                R.raw.toms132,
                R.raw.sn_01,
                R.raw.snare_02,
                R.raw.crash_01	,
                R.raw.hanb_clap_01,
        };

        private int[] soundIds;
		
		Button button_1,button_2,button_3,button_4,button_5,button_6,button_7, button_8,button_9,
		button_10, button_11,button_12, button_13,button_14,button_15,button_16;
		
		Button start_button, stay_button, return_button;		
		
		Button music1_button, music2_button,music3_button;
		
		ImageView tap_button1,tap_button2,tap_button3,tap_button4,tap_button5,
		tap_button6,tap_button7,tap_button8,tap_button9,tap_button10,tap_button11,
		tap_button12,tap_button13,tap_button14,tap_button15,tap_button16;
		
		Timer timer;
		BGMTask timerTask0;
		Handler handler;
		
		private long AniTimeLag2,AniTimeLag3,AniTimeLag4,AniTimeLag5,AniTimeLag6,AniTimeLag7,
		AniTimeLag8,AniTimeLag9,AniTimeLag10,AniTimeLag11,AniTimeLag12,AniTimeLag13,AniTimeLag14,AniTimeLag15,AniTimeLag16;
		private long ButtonTimeMillis;
		private long TouchTimeMillis;
		private long StartTimeMillis;
		private long Time;
		private long InterBGM=1000;
		long scheduleSetLag =1;
		long scheduleSetLagSum=0;
	
		TimingData timing =new TimingData(1);
		ScoreJudgeData data1 =new ScoreJudgeData(-1);
		ScoreJudgeData data2 =new ScoreJudgeData(-1);
		ScoreJudgeData data3 =new ScoreJudgeData(-1);
		ScoreJudgeData data4 =new ScoreJudgeData(-1);
		ScoreJudgeData data5 =new ScoreJudgeData(-1);
		ScoreJudgeData data6 =new ScoreJudgeData(-1);
		ScoreJudgeData data7 =new ScoreJudgeData(-1);
		ScoreJudgeData data8 =new ScoreJudgeData(-1);
		ScoreJudgeData data9 =new ScoreJudgeData(-1);
		ScoreJudgeData data10 =new ScoreJudgeData(-1);
		ScoreJudgeData data11 =new ScoreJudgeData(-1);
		ScoreJudgeData data12 =new ScoreJudgeData(-1);
		ScoreJudgeData data13 =new ScoreJudgeData(-1);
		ScoreJudgeData data14 =new ScoreJudgeData(-1);
		ScoreJudgeData data15 =new ScoreJudgeData(-1);
		ScoreJudgeData data16 =new ScoreJudgeData(-1);
		
		int MaxComboNo = (timing.delay2.length)+(timing.delay6.length)+(timing.delay7.length)+(timing.delay8.length)+
			(timing.delay10.length)+(timing.delay11.length)+(timing.delay12.length)+(timing.delay16.length);
		
		ResultData result =new ResultData(MaxComboNo);
		

		@Override
		protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_main);
		
		/*soundPool = new SoundPool(16, AudioManager.STREAM_MUSIC, 0);*/
		sound1 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		sound2 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		sound3 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		sound4 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		sound5 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		sound6 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		sound7 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		sound8 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
		sound9 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sound10 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sound11 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sound12 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sound13 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sound14 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sound15 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        sound16 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );
        
		soundIds = new int[16];
		soundIds[0] = sound1.load(this, soundResouces[0], 1 );
		soundIds[1] = sound2.load(this, soundResouces[1], 1 );
		soundIds[2] = sound3.load(this, soundResouces[0], 1 );
		soundIds[3] = sound4.load(this, soundResouces[0], 1 );
		soundIds[4] = sound5.load(this, soundResouces[0], 1 );
		soundIds[5] = sound6.load(this, soundResouces[2], 1 );
		soundIds[6] = sound7.load(this, soundResouces[3], 1 );
		soundIds[7] = sound8.load(this, soundResouces[4], 1 );
		soundIds[8] = sound9.load(this, soundResouces[0], 1 );
		soundIds[9] = sound10.load(this, soundResouces[5], 1 );
		soundIds[10] = sound11.load(this, soundResouces[6], 1 );
		soundIds[11] = sound12.load(this, soundResouces[7], 1 );
		soundIds[12] = sound13.load(this, soundResouces[0], 1 );
		soundIds[13] = sound14.load(this, soundResouces[0], 1 );
		soundIds[14] = sound15.load(this, soundResouces[0], 1 );
		soundIds[15] = sound16.load(this, soundResouces[8], 1 );	
        
        button_2 = (Button) findViewById(R.id.TapButton2); button_2.setBackgroundResource(android.R.drawable.btn_default);
        button_6 = (Button) findViewById(R.id.TapButton6); button_6.setBackgroundResource(android.R.drawable.btn_default);
        button_7 = (Button) findViewById(R.id.TapButton7); button_7.setBackgroundResource(android.R.drawable.btn_default);
        button_8 = (Button) findViewById(R.id.TapButton8); button_8.setBackgroundResource(android.R.drawable.btn_default);
        button_10 = (Button) findViewById(R.id.TapButton10); button_10.setBackgroundResource(android.R.drawable.btn_default);
        button_11 = (Button) findViewById(R.id.TapButton11); button_11.setBackgroundResource(android.R.drawable.btn_default);
        button_12 = (Button) findViewById(R.id.TapButton12); button_12.setBackgroundResource(android.R.drawable.btn_default);
        button_16 = (Button) findViewById(R.id.TapButton16); button_16.setBackgroundResource(android.R.drawable.btn_default);
        button_1 = (Button) findViewById(R.id.TapButton1); button_1.setBackgroundResource(android.R.drawable.btn_default);
        button_3 = (Button) findViewById(R.id.TapButton3); button_3.setBackgroundResource(android.R.drawable.btn_default);
        button_4 = (Button) findViewById(R.id.TapButton4); button_4.setBackgroundResource(android.R.drawable.btn_default);
        button_5 = (Button) findViewById(R.id.TapButton5); button_5.setBackgroundResource(android.R.drawable.btn_default);
        button_9 = (Button) findViewById(R.id.TapButton9); button_9.setBackgroundResource(android.R.drawable.btn_default);
        button_13 = (Button) findViewById(R.id.TapButton13); button_13.setBackgroundResource(android.R.drawable.btn_default);
        button_14 = (Button) findViewById(R.id.TapButton14); button_14.setBackgroundResource(android.R.drawable.btn_default); 
        button_15 = (Button) findViewById(R.id.TapButton15); button_15.setBackgroundResource(android.R.drawable.btn_default);
           
        stay_button = (Button) findViewById(R.id.StayButton1);
        return_button = (Button) findViewById(R.id.ReturnButton1);
        start_button = (Button)findViewById(R.id.StartButton1);
        
        music1_button = (Button) findViewById(R.id.musicbutton1);
        music2_button = (Button) findViewById(R.id.musicbutton2);
        music3_button = (Button)findViewById(R.id.musicbutton3);
      
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
               
        button_1.setOnTouchListener(this);
        button_2.setOnTouchListener(this);
        button_3.setOnTouchListener(this);
        button_4.setOnTouchListener(this);
        button_5.setOnTouchListener(this);
        button_6.setOnTouchListener(this);
        button_7.setOnTouchListener(this);
        button_8.setOnTouchListener(this);
        button_9.setOnTouchListener(this);
        button_10.setOnTouchListener(this);
        button_11.setOnTouchListener(this);
        button_12.setOnTouchListener(this); 
        button_13.setOnTouchListener(this);
        button_14.setOnTouchListener(this);
        button_15.setOnTouchListener(this);
        button_16.setOnTouchListener(this);
                
        handler = new Handler();
        
       //一次停止とリターンボタンを最初非表示
        stay_button.setVisibility(View.INVISIBLE);
        return_button.setVisibility(View.INVISIBLE);
        
        music1_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				timing.setmusic2();
				
			}
		});
        
        
        
        music3_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				timing.setmusic2();
				
			}
		});
        
		// タイマー開始ボタンの処理
		start_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//一次停止とリターンボタンを表示、スタートボタンを非表示
		        stay_button.setVisibility(View.INVISIBLE);
		        return_button.setVisibility(View.VISIBLE);                                                     
		        start_button.setVisibility(View.INVISIBLE);
				
				// タイマー1をセット
				timerTask0 = new BGMTask(MainActivity.this,MainActivity.this,result);
				timer =new Timer();
				timer.schedule(timerTask0,InterBGM);
				
				/*現在時刻を取得*/
				StartTimeMillis = System.currentTimeMillis();
				
				//ボタン1のアニメーションタイマー・タスクのセット
				for(int i=0; i < timing.delay1.length; i++) {
					TimerTask timertask1 = new AnimationTask(MainActivity.this,handler,tap_button1);
					timer.schedule(timertask1, timing.delay1[i]+InterBGM-scheduleSetLagSum); 

					TimerTask timerTask2 = new DataNoTask(MainActivity.this,handler,data1);
					timer.schedule(timerTask2, timing.delay1[i] + InterBGM-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					TimerTask timerTask3 = new DataFlagTask(MainActivity.this,handler,data1);
					timer.schedule(timerTask3, timing.delay1[i] + InterBGM-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//ボタン2のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag2 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay2.length; i++) {
					TimerTask timertask1 = new AnimationTask(MainActivity.this,handler,tap_button2);
					timer.schedule(timertask1, timing.delay2[i]+InterBGM-AniTimeLag2-scheduleSetLagSum); 

					TimerTask timerTask2 = new DataNoTask(MainActivity.this,handler,data2);
					timer.schedule(timerTask2, timing.delay2[i] + InterBGM-AniTimeLag2-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					TimerTask timerTask3 = new DataFlagTask(MainActivity.this,handler,data2);
					timer.schedule(timerTask3, timing.delay2[i] + InterBGM-AniTimeLag2-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//ボタン3のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag3 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay3.length; i++) {
					TimerTask timertask1 = new AnimationTask(MainActivity.this,handler,tap_button3);
					timer.schedule(timertask1, timing.delay3[i]+InterBGM-AniTimeLag3-scheduleSetLagSum); 

					TimerTask timerTask2 = new DataNoTask(MainActivity.this,handler,data3);
					timer.schedule(timerTask2, timing.delay3[i] + InterBGM-AniTimeLag3-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					TimerTask timerTask3 = new DataFlagTask(MainActivity.this,handler,data3);
					timer.schedule(timerTask3, timing.delay3[i] + InterBGM-AniTimeLag3-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//ボタン4のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag4 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay4.length; i++) {
					TimerTask timertask1 = new AnimationTask(MainActivity.this,handler,tap_button4);
					timer.schedule(timertask1, timing.delay4[i]+InterBGM-AniTimeLag4-scheduleSetLagSum); 

					TimerTask timerTask2 = new DataNoTask(MainActivity.this,handler,data4);
					timer.schedule(timerTask2, timing.delay4[i] + InterBGM-AniTimeLag3-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					TimerTask timerTask3 = new DataFlagTask(MainActivity.this,handler,data4);
					timer.schedule(timerTask3, timing.delay4[i] + InterBGM-AniTimeLag4-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//ボタン5のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag5 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay5.length; i++) {
					TimerTask timertask1 = new AnimationTask(MainActivity.this,handler,tap_button5);
					timer.schedule(timertask1, timing.delay5[i]+InterBGM-AniTimeLag5-scheduleSetLagSum); 

					TimerTask timerTask2 = new DataNoTask(MainActivity.this,handler,data5);
					timer.schedule(timerTask2, timing.delay5[i] + InterBGM-AniTimeLag3-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					TimerTask timerTask3 = new DataFlagTask(MainActivity.this,handler,data5);
					timer.schedule(timerTask3, timing.delay5[i] + InterBGM-AniTimeLag5-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//ボタン6のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag6 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay6.length; i++) {	
					TimerTask timertask1 = new AnimationTask(MainActivity.this,handler,tap_button6);
					timer.schedule(timertask1, timing.delay6[i]+InterBGM-AniTimeLag6-scheduleSetLagSum); 
					
					TimerTask timerTask2 = new DataNoTask(MainActivity.this,handler,data6);
					timer.schedule(timerTask2, timing.delay6[i] +InterBGM-AniTimeLag6-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask3 = new DataFlagTask(MainActivity.this,handler,data6);
					timer.schedule(timerTask3, timing.delay6[i]+InterBGM-AniTimeLag6-scheduleSetLagSum + timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
				
				//ボタン7のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag7 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay7.length; i++) {	
					TimerTask timertask7 = new AnimationTask(MainActivity.this,handler,tap_button7);
					timer.schedule(timertask7, timing.delay7[i]+InterBGM-AniTimeLag7-scheduleSetLagSum); 
					
					TimerTask timerTask8 = new DataNoTask(MainActivity.this,handler,data7);
					timer.schedule(timerTask8, timing.delay7[i]+InterBGM-AniTimeLag7-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask9 = new DataFlagTask(MainActivity.this,handler,data7);
					timer.schedule(timerTask9, timing.delay7[i]+InterBGM-AniTimeLag7-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//ボタン8のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag8 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay8.length; i++) {	
					TimerTask timertask10 = new AnimationTask(MainActivity.this,handler,tap_button8);
					timer.schedule(timertask10, timing.delay8[i]+InterBGM-AniTimeLag8-scheduleSetLagSum);
					
					TimerTask timerTask11 = new DataNoTask(MainActivity.this,handler,data8);
					timer.schedule(timerTask11, timing.delay8[i]+InterBGM-AniTimeLag8-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask12 = new DataFlagTask(MainActivity.this,handler,data8);
					timer.schedule(timerTask12, timing.delay8[i]+InterBGM-AniTimeLag8-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;
				
				//ボタン9のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag9 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay9.length; i++) {	
					TimerTask timertask10 = new AnimationTask(MainActivity.this,handler,tap_button9);
					timer.schedule(timertask10, timing.delay9[i]+InterBGM-AniTimeLag9-scheduleSetLagSum);
					
					TimerTask timerTask11 = new DataNoTask(MainActivity.this,handler,data9);
					timer.schedule(timerTask11, timing.delay9[i]+InterBGM-AniTimeLag9-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask12 = new DataFlagTask(MainActivity.this,handler,data9);
					timer.schedule(timerTask12, timing.delay9[i]+InterBGM-AniTimeLag9-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;
				
				//ボタン10のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag10 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay10.length; i++) {	
					TimerTask timertask13= new AnimationTask(MainActivity.this,handler,tap_button10);
					timer.schedule(timertask13, timing.delay10[i]+InterBGM-AniTimeLag10-scheduleSetLagSum); 
					
					TimerTask timerTask14 = new DataNoTask(MainActivity.this,handler,data10);
					timer.schedule(timerTask14, timing.delay10[i]+InterBGM-AniTimeLag10-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask15 = new DataFlagTask(MainActivity.this,handler,data10);
					timer.schedule(timerTask15, timing.delay10[i]+InterBGM-AniTimeLag10-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;
				
				//ボタン11のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag11 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay11.length; i++) {	
					TimerTask timertask16= new AnimationTask(MainActivity.this,handler,tap_button11);
					timer.schedule(timertask16, timing.delay11[i]+InterBGM-AniTimeLag11-scheduleSetLagSum); 
					
					TimerTask timerTask17 = new DataNoTask(MainActivity.this,handler,data11);
					timer.schedule(timerTask17, timing.delay11[i]+InterBGM-AniTimeLag11-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask18 = new DataFlagTask(MainActivity.this,handler,data11);
					timer.schedule(timerTask18, timing.delay11[i]+InterBGM-AniTimeLag11-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));		
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;

				//ボタン12のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag12 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay12.length; i++) {	
					TimerTask timertask19= new AnimationTask(MainActivity.this,handler,tap_button12);
					timer.schedule(timertask19, timing.delay12[i]+InterBGM-AniTimeLag12-scheduleSetLagSum); 
					
					TimerTask timerTask20 = new DataNoTask(MainActivity.this,handler,data12);
					timer.schedule(timerTask20, timing.delay12[i]+InterBGM-AniTimeLag12-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask21 = new DataFlagTask(MainActivity.this,handler,data12);
					timer.schedule(timerTask21, timing.delay12[i]+InterBGM-AniTimeLag12-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));		
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;
				
				//ボタン13のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag13 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay13.length; i++) {	
					TimerTask timertask22= new AnimationTask(MainActivity.this,handler,tap_button13);
					timer.schedule(timertask22, timing.delay13[i]+InterBGM-AniTimeLag13-scheduleSetLagSum); 
					
					TimerTask timerTask23 = new DataNoTask(MainActivity.this,handler,data13);
					timer.schedule(timerTask23, timing.delay13[i]+InterBGM-AniTimeLag13-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask24 = new DataFlagTask(MainActivity.this,handler,data13);
					timer.schedule(timerTask24, timing.delay13[i]+InterBGM-AniTimeLag13-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
				
				//ボタン14のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag14 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay14.length; i++) {	
					TimerTask timertask22= new AnimationTask(MainActivity.this,handler,tap_button14);
					timer.schedule(timertask22, timing.delay14[i]+InterBGM-AniTimeLag14-scheduleSetLagSum); 
					
					TimerTask timerTask23 = new DataNoTask(MainActivity.this,handler,data14);
					timer.schedule(timerTask23, timing.delay14[i]+InterBGM-AniTimeLag14-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask24 = new DataFlagTask(MainActivity.this,handler,data14);
					timer.schedule(timerTask24, timing.delay14[i]+InterBGM-AniTimeLag14-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
				
				//ボタン15のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag15 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay15.length; i++) {	
					TimerTask timertask22= new AnimationTask(MainActivity.this,handler,tap_button15);
					timer.schedule(timertask22, timing.delay15[i]+InterBGM-AniTimeLag15-scheduleSetLagSum); 
					
					TimerTask timerTask23 = new DataNoTask(MainActivity.this,handler,data15);
					timer.schedule(timerTask23, timing.delay15[i]+InterBGM-AniTimeLag15-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask24 = new DataFlagTask(MainActivity.this,handler,data15);
					timer.schedule(timerTask24, timing.delay15[i]+InterBGM-AniTimeLag15-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
				
				//ボタン16のアニメーションタイマー・タスクのセット
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag16 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay16.length; i++) {	
					TimerTask timertask22= new AnimationTask(MainActivity.this,handler,tap_button16);
					timer.schedule(timertask22, timing.delay16[i]+InterBGM-AniTimeLag16-scheduleSetLagSum); 
					
					TimerTask timerTask23 = new DataNoTask(MainActivity.this,handler,data16);
					timer.schedule(timerTask23, timing.delay16[i]+InterBGM-AniTimeLag16-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					TimerTask timerTask24 = new DataFlagTask(MainActivity.this,handler,data16);
					timer.schedule(timerTask24, timing.delay16[i]+InterBGM-AniTimeLag16-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
			}
		});
		
		music2_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				/*
				//idをクリア
				sound1.release();sound2.release();sound3.release();sound4.release();sound5.release();sound6.release();
				sound7.release();sound8.release();sound9.release();sound10.release();sound11.release();sound12.release();
				sound13.release();sound14.release();sound15.release();sound16.release();
				//newで生成
				sound2 = new SoundPool( 1, AudioManager.STREAM_MUSIC, 0 );*/
				
				soundIds[1] = sound2.load(getBaseContext(),soundResouces[8],1);
				
				timerTask0 = new BGMTask(MainActivity.this,MainActivity.this,result);
				timerTask0.changeBGM1();
				
				timing.setmusic2();
				
				
			}
		});
    
    
	    stay_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//一次停止とリターンボタンを表示、スタートボタンを非表示
		        stay_button.setVisibility(View.INVISIBLE);
		        return_button.setVisibility(View.INVISIBLE);
		        start_button.setVisibility(View.VISIBLE);
			
			}
		});
	    
	    return_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//一次停止とリターンボタンを表示、スタートボタンを非表示
		        stay_button.setVisibility(View.INVISIBLE);
		        return_button.setVisibility(View.INVISIBLE);
		        start_button.setVisibility(View.VISIBLE);
		       
		        Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
		        intent.putExtra("returnscore",result.score);
		        intent.putExtra("returnmaxcombo",result.MaxCombo);
		        intent.putExtra("returngreatNo",result.greatNo);
		        intent.putExtra("returngoodNo",result.goodNo);
		        intent.putExtra("returnbadNo",result.badNo);
		        intent.putExtra("maxcomboNo",result.maxComboNo());
		        intent.putExtra("maxScore",result.scoreMax());
		        intent.putExtra("returnscoreAve",(int)result.scoreAve());
				startActivity(intent);
				
		        timerTask0.stopBGM();
		        timer.cancel();      
		    }
		});
    }
    
    @Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
		int GreLan =80;
		int GodLan =70;
		int BadLan =45;
		
		TouchTimeMillis = System.currentTimeMillis();
		Time =TouchTimeMillis-StartTimeMillis;
		
		if((event.getAction() == MotionEvent.ACTION_DOWN) || (event.getAction() == MotionEvent.ACTION_POINTER_DOWN)) {
			switch (v.getId()) {
				//button1を押した場合
				case R.id.TapButton1:
					sound1.play(soundIds[0], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data1.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");	
					} else if(data1.getFlag() ==1) {	
						if( timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan <= Time && Time <= timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_1.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan) <= Time && Time < (timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_1.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan) < Time && Time <= (timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_1.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_1.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan) <= Time && Time < (timing.delay1[data1.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_1.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data1.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button2を押した場合
				case R.id.TapButton2:
					sound2.play(soundIds[1], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data2.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");	
					} else if(data2.getFlag() ==1) {	
						if( timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan <= Time && Time <= timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_2.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan) <= Time && Time < (timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_2.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan) < Time && Time <= (timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_2.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_2.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan) <= Time && Time < (timing.delay2[data2.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_2.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data2.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button3を押した場合
				case R.id.TapButton3:
					sound3.play(soundIds[2], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data3.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");	
					} else if(data3.getFlag() ==1) {	
						if( timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan <= Time && Time <= timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_3.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan) <= Time && Time < (timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_3.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan) < Time && Time <= (timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_3.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_3.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan) <= Time && Time < (timing.delay3[data3.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_3.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data3.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button4を押した場合
				case R.id.TapButton4:
					sound4.play(soundIds[3], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data4.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");	
					} else if(data4.getFlag() ==1) {	
						if( timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan <= Time && Time <= timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_4.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan) <= Time && Time < (timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_4.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan) < Time && Time <= (timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_4.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_4.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan) <= Time && Time < (timing.delay4[data4.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_4.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data4.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button5を押した場合
				case R.id.TapButton5:
					sound5.play(soundIds[4], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data5.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");	
					} else if(data5.getFlag() ==1) {	
						if( timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan <= Time && Time <= timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_5.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan) <= Time && Time < (timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_5.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan) < Time && Time <= (timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_5.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_5.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan) <= Time && Time < (timing.delay5[data5.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_5.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data5.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button6を押した場合
				case R.id.TapButton6:
					sound6.play(soundIds[5], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data6.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
					} if(data6.getFlag() ==1) {	
						if( timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6-GreLan <= Time && Time <= timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_6.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6-GreLan-GodLan) <= Time && Time < (timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_6.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						}  else if ((timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6+GreLan) < Time && Time <= (timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_6.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_6.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6+GreLan+GodLan) <= Time && Time < (timing.delay6[data6.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag6+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_6.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data6.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				case R.id.TapButton7:
					sound7.play(soundIds[6], 0.5F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data7.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
					} if(data7.getFlag() ==1) {	
						if( timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7-GreLan <= Time && Time <= timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_7.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7-GreLan-GodLan) <= Time && Time < (timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_7.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7+GreLan) < Time && Time <= (timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_7.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_7.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7+GreLan+GodLan) <= Time && Time < (timing.delay7[data7.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag7+GreLan+GodLan+BadLan))  {
							TextView textView7 = (TextView) findViewById(R.id.valueView);
							textView7.setText("Bad.");
							button_7.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data7.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				case R.id.TapButton8:
					sound8.play(soundIds[7], 0.5F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data8.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
					} if(data8.getFlag() ==1) {	
						if( timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8-GreLan <= Time && Time <= timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_8.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8-GreLan-GodLan) <= Time && Time < (timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_8.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8+GreLan) < Time && Time <= (timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_8.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_8.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8+GreLan+GodLan) <= Time && Time < (timing.delay8[data8.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag8+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_8.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data8.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button9を押した場合
				case R.id.TapButton9:
					sound9.play(soundIds[8], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data9.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
					} if(data9.getFlag() ==1) {	
						if( timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9-GreLan <= Time && Time <= timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_9.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9-GreLan-GodLan) <= Time && Time < (timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_9.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						}  else if ((timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9+GreLan) < Time && Time <= (timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_9.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_9.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9+GreLan+GodLan) <= Time && Time < (timing.delay9[data9.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag9+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_9.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data9.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button10を押した場合
				case R.id.TapButton10:
					sound10.play(soundIds[9], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data10.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
					} if(data10.getFlag() ==1) {	
						if( timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10-GreLan <= Time && Time <= timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_10.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10-GreLan-GodLan) <= Time && Time < (timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_10.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10+GreLan) < Time && Time <= (timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_10.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_10.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10+GreLan+GodLan) <= Time && Time < (timing.delay10[data10.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag10+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_10.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data10.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button11を押した場合
				case R.id.TapButton11:
					sound11.play(soundIds[10], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data11.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
					} if(data11.getFlag() ==1) {	
						if( timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11-GreLan <= Time && Time <= timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_11.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11-GreLan-GodLan) <= Time && Time < (timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_11.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11+GreLan) < Time && Time <= (timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_11.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_11.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11+GreLan+GodLan) <= Time && Time < (timing.delay11[data11.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag11+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_11.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data11.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button12を押した場合
				case R.id.TapButton12:
					sound12.play(soundIds[11], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data12.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
				} if(data12.getFlag() ==1) {	
						if( timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12-GreLan <= Time && Time <= timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_12.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12-GreLan-GodLan) <= Time && Time < (timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_12.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12+GreLan) < Time && Time <= (timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_12.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_12.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12+GreLan+GodLan) <= Time && Time < (timing.delay12[data12.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag12+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_12.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data12.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;		
				//button13を押した場合
				case R.id.TapButton13:
					sound13.play(soundIds[12], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data13.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
				} if(data13.getFlag() ==1) {	
						if( timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13-GreLan <= Time && Time <= timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_13.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13-GreLan-GodLan) <= Time && Time < (timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_13.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13+GreLan) < Time && Time <= (timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_13.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_13.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13+GreLan+GodLan) <= Time && Time < (timing.delay13[data13.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag13+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_13.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data13.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button14を押した場合
				case R.id.TapButton14:
					sound14.play(soundIds[13], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data14.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
				} if(data14.getFlag() ==1) {	
						if( timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14-GreLan <= Time && Time <= timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_14.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14-GreLan-GodLan) <= Time && Time < (timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_14.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14+GreLan) < Time && Time <= (timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_14.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_14.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14+GreLan+GodLan) <= Time && Time < (timing.delay14[data14.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag14+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_14.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data14.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				//button15を押した場合
				case R.id.TapButton15:
					sound15.play(soundIds[14], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data15.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
				} if(data15.getFlag() ==1) {	
						if( timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15-GreLan <= Time && Time <= timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_15.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15-GreLan-GodLan) <= Time && Time < (timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_15.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15+GreLan) < Time && Time <= (timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_15.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_15.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15+GreLan+GodLan) <= Time && Time < (timing.delay15[data15.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag15+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_15.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data15.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
				case R.id.TapButton16:
					sound16.play(soundIds[15], 1.0F, 1.0F, 0, 0, 1.0F);
					scheduleSetLagSum =0;
					if(data16.getFlag() ==0) {
						TextView textView1 = (TextView) findViewById(R.id.valueView);
						textView1.setText("ボタン押しても無視");
					} if(data16.getFlag() ==1) {	
						if( timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16-GreLan <= Time && Time <= timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16+GreLan ) {
							TextView textView2 = (TextView) findViewById(R.id.valueView);
							textView2.setText("Great!");
							button_16.setBackgroundColor(Color.argb(128, 0, 255, 0));
							result.greatPointUp();
							result.greatNoUp();
							result.comboNoUp();
						} else if ((timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16-GreLan-GodLan) <= Time && Time < (timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16-GreLan)) {
							TextView textView3 = (TextView) findViewById(R.id.valueView);
							textView3.setText("Good!");
							button_16.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16+GreLan) < Time && Time <= (timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16+GreLan+GodLan)) {
							TextView textView4 = (TextView) findViewById(R.id.valueView);
							textView4.setText("Good!");
							button_16.setBackgroundColor(Color.argb(128, 255, 255, 0));
							result.goodPointUp();
							result.goodNoUp();
							result.comboNoUp();
						} else if ((timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16-GreLan-GodLan-BadLan) <= Time && Time < (timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16-GreLan-GodLan))  {
							TextView textView5 = (TextView) findViewById(R.id.valueView);
							textView5.setText("Bad.");
							button_16.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						} else if ((timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16+GreLan+GodLan) <= Time && Time < (timing.delay16[data16.getNo()]+InterBGM+timing.AniDly+scheduleSetLagSum+AniTimeLag16+GreLan+GodLan+BadLan))  {
							TextView textView6 = (TextView) findViewById(R.id.valueView);
							textView6.setText("Bad.");
							button_16.setBackgroundColor(Color.argb(128, 255, 0, 0));
							result.badNoUp();
							result.comboNoRes();
						}	
							data16.init();	
							scheduleSetLagSum +=scheduleSetLag;
					}
				break;
			}
				
			//maxのcombo数を更新していく
			if(result.MaxCombo <= result.comboNo){
				if(result.comboNo != 0){
					result.MaxCombo =result.comboNo;
				}	
			}
			
			//scoreをテキストビューに表示
			String stringscore = String.valueOf(result.score());
			TextView textView0 = (TextView) findViewById(R.id.textView1);
			textView0.setText(stringscore);
			
			//プレイ中のcombo数をテキストに表示
			String stringcombo = String.valueOf(result.comboNo());
			TextView textView00 = (TextView) findViewById(R.id.textView2);
			textView00.setText(stringcombo);
			 
			
			
			return true;
		}else if((event.getAction() == MotionEvent.ACTION_UP) || (event.getAction() == MotionEvent.ACTION_POINTER_UP)) {
			switch (v.getId()) {
			case R.id.TapButton2:
				button_2.setBackgroundResource(android.R.drawable.btn_default);
				sound2.stop(soundIds[1]);
				break;
			case R.id.TapButton6:
				button_6.setBackgroundResource(android.R.drawable.btn_default);
				sound5.stop(soundIds[5]);
				break;
			case R.id.TapButton7:
				button_7.setBackgroundResource(android.R.drawable.btn_default);
				sound7.stop(soundIds[6]);
				break;
			case R.id.TapButton8:
				button_8.setBackgroundResource(android.R.drawable.btn_default);
				sound8.stop(soundIds[7]);
				break;
			case R.id.TapButton10:
				button_10.setBackgroundResource(android.R.drawable.btn_default);
				sound10.stop(soundIds[9]);
				break;
			case R.id.TapButton11:
				button_11.setBackgroundResource(android.R.drawable.btn_default);
				sound11.stop(soundIds[10]);
				break;
			case R.id.TapButton12:
				button_12.setBackgroundResource(android.R.drawable.btn_default);
				sound12.stop(soundIds[11]);
				break;
			case R.id.TapButton16:
				button_16.setBackgroundResource(android.R.drawable.btn_default);
				sound16.stop(soundIds[15]);
				break;
			}
            return true;
        }
		return false;
	}
    
    

    @Override
    protected void onDestroy() {
        Log.d("FinishTest", "onDestroy");
    	super.onDestroy();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    
}
