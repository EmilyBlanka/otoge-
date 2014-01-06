	package com.example.otoge_;

import java.util.Timer;
import java.util.TimerTask;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {
	
		SoundPool kick, bd, clap, tom123, bd2, snare2, ride, crash, snare1;
		
		Button ride_button,bd_button,snare1_button, snare2_button, clap_button, tom123_button,
		kick_button, crash_button,button_1,button_3,button_4,button_5,button_9,button_13,button_14,button_15;
		
		Button start_button, stay_button, return_button;		
		
		Button music1_button, music2_button,music3_button;
		
		int sound_id1, sound_id2, sound_id3, sound_id4, sound_id5, sound_id6,
		sound_id7, sound_id8, sound_id9, sound_id10, sound_id11, sound_id12,
		sound_id13, sound_id14, sound_id15, sound_id16;
	       
		
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
		private long[] delay6={2327,5964,9600,(10509/*+60*/),(11191/*+60*/),(11873/*+60*/),(12595/*+70*/),(13236/*+70*/),13691,14145,15964,16418,17782,18009,18464,19145,19373,19827,21418,
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
		
		private long ButtonTimeMillis;
		private long AniTimeLag6;
		private long AniTimeLag7;
		private long AniTimeLag8;
		private long AniTimeLag10;
		private long AniTimeLag11;
		private long AniTimeLag12;
		private long AniTimeLag16;
		private long TouchTimeMillis;
		private long StartTimeMillis;
		private long Time;
		private long InterBGM=1000;
		long scheduleSetLag =1;
		long scheduleSetLagSum=0;
	
		Timer timer;
		BGMTask timerTask0;
		Handler handler;
			
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
		
		int MaxComboNo = (delay2.length)+(delay6.length)+(delay7.length)+(delay8.length)+(delay10.length)+(delay11.length)
				+(delay12.length)+(delay16.length);
		/*int maxScore = MaxComboNo*70;*/
		
		ResultData result =new ResultData(MaxComboNo);
		
		
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
        
        
        ride_button = (Button) findViewById(R.id.TapButton2); ride_button.setBackgroundResource(android.R.drawable.btn_default);
        bd_button = (Button) findViewById(R.id.TapButton6); bd_button.setBackgroundResource(android.R.drawable.btn_default);
        kick_button = (Button) findViewById(R.id.TapButton7); kick_button.setBackgroundResource(android.R.drawable.btn_default);
        tom123_button = (Button) findViewById(R.id.TapButton8); tom123_button.setBackgroundResource(android.R.drawable.btn_default);
        snare1_button = (Button) findViewById(R.id.TapButton10); snare1_button.setBackgroundResource(android.R.drawable.btn_default);
        snare2_button = (Button) findViewById(R.id.TapButton11); snare2_button.setBackgroundResource(android.R.drawable.btn_default);
        crash_button = (Button) findViewById(R.id.TapButton12); crash_button.setBackgroundResource(android.R.drawable.btn_default);
        clap_button = (Button) findViewById(R.id.TapButton16); clap_button.setBackgroundResource(android.R.drawable.btn_default);
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
               
        bd_button.setOnTouchListener(this);
        clap_button.setOnTouchListener(this);
        tom123_button.setOnTouchListener(this);
        snare2_button.setOnTouchListener(this);
        snare1_button.setOnTouchListener(this);
        ride_button.setOnTouchListener(this);
        crash_button.setOnTouchListener(this);   
        kick_button.setOnTouchListener(this);
        button_1.setOnTouchListener(this);
        
        handler = new Handler();
        
        //一次停止とリターンボタンを最初非表示
        stay_button.setVisibility(View.INVISIBLE);
        return_button.setVisibility(View.INVISIBLE);
        
        music2_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, Music2Activity.class);
				// 次画面のアクティビティ起動
				startActivity(intent);
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
				Log.d("bgm", "timerset");
				
				/*現在時刻を取得*/
				StartTimeMillis = System.currentTimeMillis();
				Log.d("test1", "aaa");
				
				//ボタン2のアニメーションタイマー・タスクのセット
				for(int i=0; i < delay2.length; i++) {
					TimerTask timertask1 = new AnimationTask(MainActivity.this,handler,tap_button2);
					timer.schedule(timertask1, delay2[i]+InterBGM-scheduleSetLagSum); 
					Log.d("ani", "2");
					  					
					TimerTask timerTask2 = new DataNoTask(MainActivity.this,handler,data2);
					timer.schedule(timerTask2, delay2[i] + InterBGM-scheduleSetLagSum + AniDly-(AniDly/2));
					Log.d("no", "2");
					
					TimerTask timerTask3 = new DataFlagTask(MainActivity.this,handler,data2);
					timer.schedule(timerTask3, delay2[i] + InterBGM-scheduleSetLagSum +AniDly+(AniDly/2));
					Log.d("flag", "2");
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				
				scheduleSetLagSum =0;
				
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag6 = ButtonTimeMillis- StartTimeMillis;
				
				
				//ボタン6のアニメーションタイマー・タスクのセット
				for(int i=0; i < delay6.length; i++) {	
					TimerTask timertask4 = new AnimationTask(MainActivity.this,handler,tap_button6);
					timer.schedule(timertask4, delay6[i]+InterBGM-AniTimeLag6-scheduleSetLagSum); 
					Log.d("ani", "6");
					
					TimerTask timerTask5 = new DataNoTask(MainActivity.this,handler,data6);
					timer.schedule(timerTask5, delay6[i] +InterBGM-AniTimeLag6-scheduleSetLagSum + AniDly-(AniDly/2));

					TimerTask timerTask6 = new DataFlagTask(MainActivity.this,handler,data6);
					timer.schedule(timerTask6, delay6[i]+InterBGM-AniTimeLag6-scheduleSetLagSum + AniDly+(AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				
				scheduleSetLagSum =0;
				
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag7 = ButtonTimeMillis- StartTimeMillis;
				
				
				//ボタン7のアニメーションタイマー・タスクのセット
				for(int i=0; i < delay7.length; i++) {	
					TimerTask timertask7 = new AnimationTask(MainActivity.this,handler,tap_button7);
					timer.schedule(timertask7, delay7[i]+InterBGM-AniTimeLag7-scheduleSetLagSum); 
					
					TimerTask timerTask8 = new DataNoTask(MainActivity.this,handler,data7);
					timer.schedule(timerTask8, delay7[i]+InterBGM-AniTimeLag7-scheduleSetLagSum+AniDly-(AniDly/2));

					TimerTask timerTask9 = new DataFlagTask(MainActivity.this,handler,data7);
					timer.schedule(timerTask9, delay7[i]+InterBGM-AniTimeLag7-scheduleSetLagSum+AniDly+(AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				
				scheduleSetLagSum =0;
				
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag8 = ButtonTimeMillis- StartTimeMillis;
				
				//ボタン8のアニメーションタイマー・タスクのセット
				for(int i=0; i < delay8.length; i++) {	
					TimerTask timertask10 = new AnimationTask(MainActivity.this,handler,tap_button8);
					timer.schedule(timertask10, delay8[i]+InterBGM-AniTimeLag8-scheduleSetLagSum);
					
					TimerTask timerTask11 = new DataNoTask(MainActivity.this,handler,data8);
					timer.schedule(timerTask11, delay8[i]+InterBGM-AniTimeLag8-scheduleSetLagSum+AniDly-(AniDly/2));

					TimerTask timerTask12 = new DataFlagTask(MainActivity.this,handler,data8);
					timer.schedule(timerTask12, delay8[i]+InterBGM-AniTimeLag8-scheduleSetLagSum+AniDly+(AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				
				scheduleSetLagSum =0;
				
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag10 = ButtonTimeMillis- StartTimeMillis;
				
				//ボタン10のアニメーションタイマー・タスクのセット
				for(int i=0; i < delay10.length; i++) {	
					TimerTask timertask13= new AnimationTask(MainActivity.this,handler,tap_button10);
					timer.schedule(timertask13, delay10[i]+InterBGM-AniTimeLag10-scheduleSetLagSum); 
					
					TimerTask timerTask14 = new DataNoTask(MainActivity.this,handler,data10);
					timer.schedule(timerTask14, delay10[i]+InterBGM-AniTimeLag10-scheduleSetLagSum+AniDly-(AniDly/2));

					TimerTask timerTask15 = new DataFlagTask(MainActivity.this,handler,data10);
					timer.schedule(timerTask15, delay10[i]+InterBGM-AniTimeLag10-scheduleSetLagSum+AniDly+(AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				
				scheduleSetLagSum =0;
				
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag11 = ButtonTimeMillis- StartTimeMillis;
				
				//ボタン11のアニメーションタイマー・タスクのセット
				for(int i=0; i < delay11.length; i++) {	
					TimerTask timertask16= new AnimationTask(MainActivity.this,handler,tap_button11);
					timer.schedule(timertask16, delay11[i]+InterBGM-AniTimeLag11-scheduleSetLagSum); 
					
					TimerTask timerTask17 = new DataNoTask(MainActivity.this,handler,data11);
					timer.schedule(timerTask17, delay11[i]+InterBGM-AniTimeLag11-scheduleSetLagSum+AniDly-(AniDly/2));

					TimerTask timerTask18 = new DataFlagTask(MainActivity.this,handler,data11);
					timer.schedule(timerTask18, delay11[i]+InterBGM-AniTimeLag11-scheduleSetLagSum+AniDly+(AniDly/2));		
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				
				scheduleSetLagSum =0;
				
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag12 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < delay12.length; i++) {	
					TimerTask timertask19= new AnimationTask(MainActivity.this,handler,tap_button12);
					timer.schedule(timertask19, delay12[i]+InterBGM-AniTimeLag12-scheduleSetLagSum); 
					
					TimerTask timerTask20 = new DataNoTask(MainActivity.this,handler,data12);
					timer.schedule(timerTask20, delay12[i]+InterBGM-AniTimeLag12-scheduleSetLagSum+AniDly-(AniDly/2));

					TimerTask timerTask21 = new DataFlagTask(MainActivity.this,handler,data12);
					timer.schedule(timerTask21, delay12[i]+InterBGM-AniTimeLag12-scheduleSetLagSum+AniDly+(AniDly/2));		
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				
				scheduleSetLagSum =0;
				
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag16 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < delay16.length; i++) {	
					TimerTask timertask22= new AnimationTask(MainActivity.this,handler,tap_button16);
					timer.schedule(timertask22, delay16[i]+InterBGM-AniTimeLag16-scheduleSetLagSum); 
					
					TimerTask timerTask23 = new DataNoTask(MainActivity.this,handler,data16);
					timer.schedule(timerTask23, delay16[i]+InterBGM-AniTimeLag16-scheduleSetLagSum+AniDly-(AniDly/2));

					TimerTask timerTask24 = new DataFlagTask(MainActivity.this,handler,data16);
					timer.schedule(timerTask24, delay16[i]+InterBGM-AniTimeLag16-scheduleSetLagSum+AniDly+(AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
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
			case R.id.TapButton2:
				ride.play(sound_id2, 1.0F, 1.0F, 0, 0, 1.0F);
				scheduleSetLagSum =0;
				if(data2.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} else if(data2.getFlag() ==1) {	
					if( delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum-GreLan <= Time && Time <= delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						ride_button.setBackgroundColor(Color.argb(128, 0, 255, 0));
						result.greatPointUp();
						result.greatNoUp();
						result.comboNoUp();
						break;
					} else if ((delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum-GreLan-GodLan) <= Time && Time < (delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum+GreLan) < Time && Time <= (delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum-GreLan-GodLan-BadLan) <= Time && Time < (delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						result.badNoUp();
						result.comboNoRes();
						break;
					} else if ((delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum+GreLan+GodLan) <= Time && Time < (delay2[data2.getNo()]+InterBGM+AniDly+scheduleSetLagSum+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						result.badNoUp();
						result.comboNoRes();
						break;		
					}	
						data2.init();	
						scheduleSetLagSum +=scheduleSetLag;
				}
				break;
				
			case R.id.TapButton6:
				bd.play(sound_id6, 1.0F, 1.0F, 0, 0, 1.0F);
				scheduleSetLagSum =0;
				if(data6.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data6.getFlag() ==1) {	
					if( delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6-GreLan <= Time && Time <= delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						bd_button.setBackgroundColor(Color.argb(128, 0, 255, 0));
						result.greatPointUp();
						result.greatNoUp();
						result.comboNoUp();
						break;
					} else if ((delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6-GreLan-GodLan) <= Time && Time < (delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						bd_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					}  else if ((delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6+GreLan) < Time && Time <= (delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						bd_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6-GreLan-GodLan-BadLan) <= Time && Time < (delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						bd_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;
					} else if ((delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6+GreLan+GodLan) <= Time && Time < (delay6[data6.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag6+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						bd_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;		
					}	
						data6.init();	
						scheduleSetLagSum +=scheduleSetLag;
				}
			
				break;
		
			case R.id.TapButton7:
				kick.play(sound_id7, 0.5F, 1.0F, 0, 0, 1.0F);
				scheduleSetLagSum =0;
				if(data7.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data7.getFlag() ==1) {	
					if( delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7-GreLan <= Time && Time <= delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						kick_button.setBackgroundColor(Color.argb(128, 0, 255, 0));
						result.greatPointUp();
						result.greatNoUp();
						result.comboNoUp();
						break;
					} else if ((delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7-GreLan-GodLan) <= Time && Time < (delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						kick_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7+GreLan) < Time && Time <= (delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						kick_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7-GreLan-GodLan-BadLan) <= Time && Time < (delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						kick_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;
					} else if ((delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7+GreLan+GodLan) <= Time && Time < (delay7[data7.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag7+GreLan+GodLan+BadLan))  {
						TextView textView7 = (TextView) findViewById(R.id.valueView);
						textView7.setText("Bad.");
						kick_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;		
					}	
						data7.init();	
						scheduleSetLagSum +=scheduleSetLag;
				}
			
				break;
			case R.id.TapButton8:
				tom123.play(sound_id8, 0.5F, 1.0F, 0, 0, 1.0F);
				scheduleSetLagSum =0;
				if(data8.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data8.getFlag() ==1) {	
					if( delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8-GreLan <= Time && Time <= delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						tom123_button.setBackgroundColor(Color.argb(128, 0, 255, 0));
						result.greatPointUp();
						result.greatNoUp();
						result.comboNoUp();
						break;
					} else if ((delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8-GreLan-GodLan) <= Time && Time < (delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						tom123_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8+GreLan) < Time && Time <= (delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						tom123_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8-GreLan-GodLan-BadLan) <= Time && Time < (delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						tom123_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;
					} else if ((delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8+GreLan+GodLan) <= Time && Time < (delay8[data8.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag8+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						tom123_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;		
					}	
						data8.init();	
						scheduleSetLagSum +=scheduleSetLag;
				}
				break;
			case R.id.TapButton10:
				snare1.play(sound_id10, 1.0F, 1.0F, 0, 0, 1.0F);
				scheduleSetLagSum =0;
				if(data10.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data10.getFlag() ==1) {	
					if( delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10-GreLan <= Time && Time <= delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						snare1_button.setBackgroundColor(Color.argb(128, 0, 255, 0));
						result.greatPointUp();
						result.greatNoUp();
						result.comboNoUp();
						break;
					} else if ((delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10-GreLan-GodLan) <= Time && Time < (delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						snare1_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10+GreLan) < Time && Time <= (delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						snare1_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10-GreLan-GodLan-BadLan) <= Time && Time < (delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						snare1_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;
					} else if ((delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10+GreLan+GodLan) <= Time && Time < (delay10[data10.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag10+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						snare1_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;		
					}	
						data10.init();	
						scheduleSetLagSum +=scheduleSetLag;
				}
				break;
			case R.id.TapButton11:
				snare2.play(sound_id11, 1.0F, 1.0F, 0, 0, 1.0F);
				scheduleSetLagSum =0;
				if(data11.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data11.getFlag() ==1) {	
					if( delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11-GreLan <= Time && Time <= delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						snare2_button.setBackgroundColor(Color.argb(128, 0, 255, 0));
						result.greatPointUp();
						result.greatNoUp();
						result.comboNoUp();
						break;
					} else if ((delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11-GreLan-GodLan) <= Time && Time < (delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						snare2_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11+GreLan) < Time && Time <= (delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						snare2_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11-GreLan-GodLan-BadLan) <= Time && Time < (delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						snare2_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;
					} else if ((delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11+GreLan+GodLan) <= Time && Time < (delay11[data11.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag11+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						snare2_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;		
					}	
						data11.init();	
						scheduleSetLagSum +=scheduleSetLag;
				}
				break;
			case R.id.TapButton12:
				crash.play(sound_id12, 1.0F, 1.0F, 0, 0, 1.0F);
				scheduleSetLagSum =0;
				if(data12.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data12.getFlag() ==1) {	
					if( delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12-GreLan <= Time && Time <= delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						crash_button.setBackgroundColor(Color.argb(128, 0, 255, 0));
						result.greatPointUp();
						result.greatNoUp();
						result.comboNoUp();
						break;
					} else if ((delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12-GreLan-GodLan) <= Time && Time < (delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						crash_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12+GreLan) < Time && Time <= (delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						crash_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12-GreLan-GodLan-BadLan) <= Time && Time < (delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						crash_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;
					} else if ((delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12+GreLan+GodLan) <= Time && Time < (delay12[data12.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag12+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						crash_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;		
					}	
						data12.init();	
						scheduleSetLagSum +=scheduleSetLag;
				}
				break;			
			case R.id.TapButton16:
				clap.play(sound_id16, 1.0F, 1.0F, 0, 0, 1.0F);
				scheduleSetLagSum =0;
				if(data16.getFlag() ==0) {
					TextView textView1 = (TextView) findViewById(R.id.valueView);
					textView1.setText("ボタン押しても無視");
					break;	
				} if(data16.getFlag() ==1) {	
					if( delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16-GreLan <= Time && Time <= delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16+GreLan ) {
						TextView textView2 = (TextView) findViewById(R.id.valueView);
						textView2.setText("Great!");
						clap_button.setBackgroundColor(Color.argb(128, 0, 255, 0));
						result.greatPointUp();
						result.greatNoUp();
						result.comboNoUp();
						break;
					} else if ((delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16-GreLan-GodLan) <= Time && Time < (delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16-GreLan)) {
						TextView textView3 = (TextView) findViewById(R.id.valueView);
						textView3.setText("Good!");
						clap_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16+GreLan) < Time && Time <= (delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16+GreLan+GodLan)) {
						TextView textView4 = (TextView) findViewById(R.id.valueView);
						textView4.setText("Good!");
						clap_button.setBackgroundColor(Color.argb(128, 255, 255, 0));
						result.goodPointUp();
						result.goodNoUp();
						result.comboNoUp();
						break;
					} else if ((delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16-GreLan-GodLan-BadLan) <= Time && Time < (delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16-GreLan-GodLan))  {
						TextView textView5 = (TextView) findViewById(R.id.valueView);
						textView5.setText("Bad.");
						clap_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;
					} else if ((delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16+GreLan+GodLan) <= Time && Time < (delay16[data16.getNo()]+InterBGM+AniDly+scheduleSetLagSum+AniTimeLag16+GreLan+GodLan+BadLan))  {
						TextView textView6 = (TextView) findViewById(R.id.valueView);
						textView6.setText("Bad.");
						clap_button.setBackgroundColor(Color.argb(128, 255, 0, 0));
						result.badNoUp();
						result.comboNoRes();
						break;		
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
				ride_button.setBackgroundResource(android.R.drawable.btn_default);
				ride.stop(sound_id2);
				break;
			case R.id.TapButton6:
				bd_button.setBackgroundResource(android.R.drawable.btn_default);
				bd.stop(sound_id6);
				break;
			case R.id.TapButton7:
				kick_button.setBackgroundResource(android.R.drawable.btn_default);
				kick.stop(sound_id7);
				break;
			case R.id.TapButton8:
				tom123_button.setBackgroundResource(android.R.drawable.btn_default);
				tom123.stop(sound_id8);
				break;
			case R.id.TapButton10:
				snare1_button.setBackgroundResource(android.R.drawable.btn_default);
				snare1.stop(sound_id10);
				break;
			case R.id.TapButton11:
				snare2_button.setBackgroundResource(android.R.drawable.btn_default);
				snare2.stop(sound_id11);
				break;
			case R.id.TapButton12:
				crash_button.setBackgroundResource(android.R.drawable.btn_default);
				crash.stop(sound_id12);
				break;
			case R.id.TapButton16:
				clap_button.setBackgroundResource(android.R.drawable.btn_default);
				clap.stop(sound_id16);
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
