package com.example.otoge_;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {
	
		SoundPool soundpool;	
	
		MediaPlayer mediaplayer, mediaplayer1, mediaplayer2, mediaplayer3 ;
		
		private int[] soundResouces1 = {
                R.raw.nosound1, R.raw.ride_01,R.raw.nosound2, R.raw.nosound3, 
                R.raw.bd03, R.raw.bd01,R.raw.kick_02,R.raw.toms132,
                R.raw.nosound5, R.raw.sn ,R.raw.snare_02,R.raw.crash_01,
                R.raw.nosound6, R.raw.nosound7, R.raw.nosound8, R.raw.hanb_clap_01,
        };
		
		private int[] soundResouces2 = {
                R.raw.fuck,   R.raw.perc01, R.raw.perc02, R.raw.perc03,
                R.raw.perc04, R.raw.bd02,  R.raw.sn01,   R.raw.sn02	,
                R.raw.chip01, R.raw.clap, R.raw.bongo, R.raw.chip02,
                R.raw.perc05, R.raw.hh_01, R.raw.sn03, R.raw.fuck_02,
        };
		
		private int[] MusicResouces = {
                R.raw.bgm1,R.raw.all_beats1,
                R.raw.fuck_up_backbgm,R.raw.fuck_up_soundrolll
        };

        int[] soundIds;
		
		Button button_1,button_2,button_3,button_4,button_5,button_6,button_7, button_8,button_9,
		button_10, button_11,button_12, button_13,button_14,button_15,button_16;
		
		Button start_button, return_button;		
		
		Button music1_button, music2_button,music3_button;
	
		static String title;
		String titleA="First kitchen",titleB="F�~�~k Up";
		
		BGMTask timerTask0;
		Handler handler;
		Timer timer;
		
		TimingData timing =new TimingData(1);
		
		int MaxComboNo = (timing.delay2.length)+(timing.delay6.length)+(timing.delay7.length)+(timing.delay8.length)+
				(timing.delay10.length)+(timing.delay11.length)+(timing.delay12.length)+(timing.delay16.length);
			
		private long AniTimeLag2,AniTimeLag3,AniTimeLag4,AniTimeLag5,AniTimeLag6,AniTimeLag7,
		AniTimeLag8,AniTimeLag9,AniTimeLag10,AniTimeLag11,AniTimeLag12,AniTimeLag13,AniTimeLag14,AniTimeLag15,AniTimeLag16;
		private long ButtonTimeMillis;
		private long TouchTimeMillis;
		private long StartTimeMillis;
		private long Time;
		private long InterBGM=1000;
		long scheduleSetLag =1;
		long scheduleSetLagSum=0;
	
		TimerTask[] timertaskAni = new TimerTask[16];
		TimerTask[] timertaskFla = new TimerTask[16];
		TimerTask[] timertaskNo = new TimerTask[16];
		
		ImageView[] tap_button=new ImageView[16];
		
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
		
		ResultData result =new ResultData(MaxComboNo);
		
		//
		@Override
		protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_main);
		
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
           
        return_button = (Button) findViewById(R.id.ReturnButton1);
        start_button = (Button)findViewById(R.id.StartButton1);
        
        music1_button = (Button) findViewById(R.id.musicbutton1);
        music2_button = (Button) findViewById(R.id.musicbutton2);
        music3_button = (Button)findViewById(R.id.musicbutton3);
      
        tap_button[0] = (ImageView) findViewById(R.id.TapImage1);
        tap_button[1] = (ImageView) findViewById(R.id.TapImage2);
        tap_button[2] = (ImageView) findViewById(R.id.TapImage3);
        tap_button[3] = (ImageView) findViewById(R.id.TapImage4);
        tap_button[4] = (ImageView) findViewById(R.id.TapImage5);
        tap_button[5] = (ImageView) findViewById(R.id.TapImage6);
        tap_button[6] = (ImageView) findViewById(R.id.TapImage7);
        tap_button[7] = (ImageView) findViewById(R.id.TapImage8);
        tap_button[8] = (ImageView) findViewById(R.id.TapImage9);
        tap_button[9] = (ImageView) findViewById(R.id.TapImage10);
        tap_button[10] = (ImageView) findViewById(R.id.TapImage11);
        tap_button[11] = (ImageView) findViewById(R.id.TapImage12);
        tap_button[12] = (ImageView) findViewById(R.id.TapImage13);
        tap_button[13] = (ImageView) findViewById(R.id.TapImage14);
        tap_button[14] = (ImageView) findViewById(R.id.TapImage15);
        tap_button[15] = (ImageView) findViewById(R.id.TapImage16);
               
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
        
        music1_button.setEnabled(true);
        
        //"First kitchen"�̃{�^�����������ꍇ�̏���
        music1_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//��������������O�ɁA�X�^�[�g�{�^�����������ƃG���[���N����̂ŏ�������������܂ł͔�\���ɂ�����B
				start_button.setVisibility(View.INVISIBLE);
				
				//ResultActivity�̋ȃ^�C�g����\������ׂɁAstring��ύX�B"First kitchen"�̃J���[����A�{�^�����@�\��~�ɂ�����B
				title =titleA;
				music2_button.setTextColor(Color.parseColor("black"));
				music1_button.setTextColor(Color.parseColor("blue")); music1_button.setEnabled(false);
				
				//soundpool�������[�X���Anull����(music2���Z�b�g������ɁAmusic1�ɃZ�b�g�������ꍇ�����邽��)
				soundpool.release();
				soundpool = null;
				
				//soundpool���ēxnew�Ő������Aid��16�쐬�B"First kitchen"�̌��ʉ���load
				soundpool = new SoundPool( 16, AudioManager.STREAM_MUSIC, 0 ); soundIds = new int[16];
				
				soundIds[0] = soundpool.load(getBaseContext(), soundResouces1[0], 1 );
				soundIds[1] = soundpool.load(getBaseContext(), soundResouces1[1], 1 );
				soundIds[2] = soundpool.load(getBaseContext(), soundResouces1[2], 1 );
				soundIds[3] = soundpool.load(getBaseContext(), soundResouces1[3], 1 );
				soundIds[4] = soundpool.load(getBaseContext(), soundResouces1[4], 1 );
				soundIds[5] = soundpool.load(getBaseContext(), soundResouces1[5], 1 );
				soundIds[6] = soundpool.load(getBaseContext(), soundResouces1[6], 1 );
				soundIds[7] = soundpool.load(getBaseContext(), soundResouces1[7], 1 );
				soundIds[8] = soundpool.load(getBaseContext(), soundResouces1[8], 1 );
				soundIds[9] = soundpool.load(getBaseContext(), soundResouces1[9], 1 );
				soundIds[10] = soundpool.load(getBaseContext(), soundResouces1[10], 1 );
				soundIds[11] = soundpool.load(getBaseContext(), soundResouces1[11], 1 );
				soundIds[12] = soundpool.load(getBaseContext(), soundResouces1[12], 1 );
				soundIds[13] = soundpool.load(getBaseContext(), soundResouces1[13], 1 );
				soundIds[14] = soundpool.load(getBaseContext(), soundResouces1[14], 1 );
				soundIds[15] = soundpool.load(getBaseContext(), soundResouces1[15], 1 );
			
				//mediaplayer��"First kitchen"�̃h�������[���ɕύX
				mediaplayer =MediaPlayer.create(getBaseContext(),MusicResouces[1]);
		        
		        //BGM�J�n��1�b��ɃZ�b�g
		        timerTask0 = new BGMTask(MainActivity.this,MainActivity.this,result,mediaplayer);
				timer =new Timer();
				timer.schedule(timerTask0,1000);
				
				timing.setmusic1();
				
				//BGM�I����̏���
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {	
					
					@Override
					public void onCompletion(MediaPlayer mp) {
						
						//mediaplayer("First kitchen"�̃h�������[��BGM)�������[�X���Anull��������,new�ō쐬
						mediaplayer.release();
						mediaplayer = null;
						mediaplayer = new MediaPlayer();
						
						//mediaplayer��"First kitchen"BGM����
						try {
							String test = "android.resource://"+getBaseContext().getPackageName()+"/"+R.raw.bgm1;
							mediaplayer.setDataSource(getBaseContext(), Uri.parse(test));
							mediaplayer.prepare();
						} catch (IllegalArgumentException e) {
							// TODO �����������ꂽ catch �u���b�N
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO �����������ꂽ catch �u���b�N
							e.printStackTrace();
						} catch (IllegalStateException e) {
							// TODO �����������ꂽ catch �u���b�N
							e.printStackTrace();
						} catch (IOException e) {
							// TODO �����������ꂽ catch �u���b�N
							e.printStackTrace();
						}
						//start button��\�������A"F�~�~k Up"�̃e�L�X�g�������ɂ��A�{�^���̋@�\�𐳏�ɖ߂�
						start_button.setVisibility(View.VISIBLE);
						music2_button.setEnabled(true);
					}
				});	
			}
		});
        
        //"F�~�~k Up"�̃{�^�����������ꍇ�̏���
        music2_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//��������������O�ɁA�X�^�[�g�{�^�����������ƃG���[���N����̂ŏ�������������܂ł͔�\���ɂ�����B
				start_button.setVisibility(View.INVISIBLE);
				
				//ResultActivity�̋ȃ^�C�g����\������ׂɁAstring��ύX�B"F�~�~k Up"�̃J���[����A�{�^�����@�\��~�ɂ�����B
				title =titleB;
				music1_button.setTextColor(Color.parseColor("black"));
				music2_button.setTextColor(Color.parseColor("blue")); music2_button.setEnabled(false);
				
				//soundpool�������[�X���Anull����(music1���Z�b�g������ɁAmusic2�ɃZ�b�g�������ꍇ�����邽��)
				soundpool.release();
				soundpool = null;
				
				//soundpool���ēxnew�Ő������Aid��16�쐬�B"First kitchen"�̌��ʉ���load
				soundpool = new SoundPool( 16, AudioManager.STREAM_MUSIC, 0 ); soundIds = new int[16];
				
				soundIds[0] = soundpool.load(getBaseContext(), soundResouces2[0], 1 );
				soundIds[1] = soundpool.load(getBaseContext(), soundResouces2[1], 1 );
				soundIds[2] = soundpool.load(getBaseContext(), soundResouces2[2], 1 );
				soundIds[3] = soundpool.load(getBaseContext(), soundResouces2[3], 1 );
				soundIds[4] = soundpool.load(getBaseContext(), soundResouces2[4], 1 );
				soundIds[5] = soundpool.load(getBaseContext(), soundResouces2[5], 1 );
				soundIds[6] = soundpool.load(getBaseContext(), soundResouces2[6], 1 );
				soundIds[7] = soundpool.load(getBaseContext(), soundResouces2[7], 1 );
				soundIds[8] = soundpool.load(getBaseContext(), soundResouces2[8], 1 );
				soundIds[9] = soundpool.load(getBaseContext(), soundResouces2[9], 1 );
				soundIds[10] = soundpool.load(getBaseContext(), soundResouces2[10], 1 );
				soundIds[11] = soundpool.load(getBaseContext(), soundResouces2[11], 1 );
				soundIds[12] = soundpool.load(getBaseContext(), soundResouces2[12], 1 );
				soundIds[13] = soundpool.load(getBaseContext(), soundResouces2[13], 1 );
				soundIds[14] = soundpool.load(getBaseContext(), soundResouces2[14], 1 );
				soundIds[15] = soundpool.load(getBaseContext(), soundResouces2[15], 1 );
				
				//mediaplayer��"First kitchen"�̃h�������[���ɕύX
				mediaplayer =MediaPlayer.create(getBaseContext(),MusicResouces[3]);
				
				//BGM�J�n��1�b��ɃZ�b�g
		        timerTask0 = new BGMTask(MainActivity.this,MainActivity.this,result,mediaplayer);
				timer =new Timer();
				timer.schedule(timerTask0,1000);
				
				timing.setmusic2();
				
				//�h�������[�����̃^�C�~���O�ƃ{�^���̃A�j���[�V����
				/*timertaskAni[0] = new AnimationTask(MainActivity.this,handler,tap_button[0]);
				timertaskAni[1] = new AnimationTask(MainActivity.this,handler,tap_button[1]);
				
				timer.schedule(timertaskAni[0], 1000); timer.schedule(timertaskAni[1], 1100); timer.schedule(timertaskAni[2], 1200); 
				timer.schedule(timertaskAni[3], 1300); timer.schedule(timertaskAni[4], 1400); timer.schedule(timertaskAni[5], 1500); 
				timer.schedule(timertaskAni[6], 1600); timer.schedule(timertaskAni[7], 1700); timer.schedule(timertaskAni[8], 1800); 
				timer.schedule(timertaskAni[9], 1900); timer.schedule(timertaskAni[10], 2000); timer.schedule(timertaskAni[11], 2100); 
				timer.schedule(timertaskAni[12], 2200); timer.schedule(timertaskAni[13], 2300); timer.schedule(timertaskAni[14], 2400); 
				timer.schedule(timertaskAni[15], 2500); */
				
				//BGM�I����̏���
				mediaplayer.setOnCompletionListener(new OnCompletionListener() {	
					@Override
					public void onCompletion(MediaPlayer mp) {
						mediaplayer.release();
						mediaplayer = null;
						mediaplayer = new MediaPlayer();
						
						try {
							String test = "android.resource://"+getBaseContext().getPackageName()+"/"+R.raw.fuck_up_backbgm;
							mediaplayer.setDataSource(getBaseContext(), Uri.parse(test));
							mediaplayer.prepare();
						} catch (IllegalArgumentException e) {
							// TODO �����������ꂽ catch �u���b�N
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO �����������ꂽ catch �u���b�N
							e.printStackTrace();
						} catch (IllegalStateException e) {
							// TODO �����������ꂽ catch �u���b�N
							e.printStackTrace();
						} catch (IOException e) {
							// TODO �����������ꂽ catch �u���b�N
							e.printStackTrace();
						}	
						//start button��\�������A"F�~�~k Up"�̃e�L�X�g�������ɂ��A�{�^���̋@�\�𐳏�ɖ߂�
						music1_button.setEnabled(true);
						start_button.setVisibility(View.VISIBLE);
					}
				});	
			}
		});
    
        music3_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				timing.setmusic2();
				
			}
		});
        
	}
	
		
	//ResultActivity��ʂ�finish�����ۂɌĂ΂�郁�\�b�h
	//onCreate�̎��ɌĂ΂�郁�\�b�h
	@Override
	protected void onStart() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onStart();
		
		mediaplayer =MediaPlayer.create(getBaseContext(),MusicResouces[0]);
		
		timerStart();
		timing.setmusic1();
		
		/*mediaplayer =MediaPlayer.create(getBaseContext(),MusicResouces[0]);*/
		//���l���̏�����
		result.score=0;
		result.comboNo=0;
		result.MaxCombo=0;
		result.greatNo =0;
		result.goodNo =0;
		result.badNo =0;
		result.comboNo =0;
		
		TextView textView1 = (TextView) findViewById(R.id.valueView);
		textView1.setText("");
		
		//dataNo�N���X�̕ϐ��̏�����
		data1.no=-1;data2.no=-1;data3.no=-1;data4.no=-1;data5.no=-1;data6.no=-1;data7.no=-1;data8.no=-1;
		data1.no=-1;data9.no=-1;data10.no=-1;data11.no=-1;data12.no=-1;data13.no=-1;data14.no=-1;data15.no=-1;data16.no=-1;
		
		//�Ȗ��{�^���̋@�\�𕜊�
		music1_button.setEnabled(false); music2_button.setEnabled(true);
		/*start_button.setVisibility(View.VISIBLE);*/
		
		//��ʃ��C�A�E�g�̏�����Ԃł́A"First kitchen"���Z�b�g�����ׁA�^�C�g����"First kitchen"���Z�b�g�B�^�C�g���e�L�X�g�͐��B"First kitchen"�̃{�^�����@�\��~������
        title =titleA;
        music1_button.setTextColor(Color.parseColor("blue"));music1_button.setEnabled(false);
        music2_button.setTextColor(Color.parseColor("black"));
        
        //��ʃ��C�A�E�g�̏�����Ԃł́A���^�[���{�^�����\��
        return_button.setVisibility(View.INVISIBLE);
		
		//score���e�L�X�g�r���[�ɕ\��
		String stringscore = String.valueOf(result.score());
		TextView textView0 = (TextView) findViewById(R.id.textView1);
		textView0.setText(stringscore);
		
		//�v���C����combo�����e�L�X�g�ɕ\��
		String stringcombo = String.valueOf(result.comboNo());
		TextView textView00 = (TextView) findViewById(R.id.textView2);
		textView00.setText(stringcombo);
		
	}

	//TimerTask��new�쐬�Asoundpool��new�쐬�Aid�쐬
	@Override
	protected void onResume() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onResume();
		
		timerTask0 = new BGMTask(MainActivity.this,MainActivity.this,result,mediaplayer);
		timer =new Timer();

		//soundpool�N���X16��new�ō쐬
		soundpool = new SoundPool( 16, AudioManager.STREAM_MUSIC, 0 );
		
		/*soundpool.setOnLoadCompleteListener(new OnLoadCompleteListener(){
			@Override
			public void onLoadComplete(SoundPool arg0, int arg1,
					int arg2) {
				// TODO �����������ꂽ���\�b�h�E�X�^�u
				Log.d("aaaaa", String.format("dddddd_%d:%d ", arg1,arg2));
			}
		});*/
		        
		soundIds = new int[16];
		soundIds[0] = soundpool.load(this, soundResouces1[0], 1 );
		soundIds[1] = soundpool.load(this, soundResouces1[1], 1 );
		soundIds[2] = soundpool.load(this, soundResouces1[2], 1 );
		soundIds[3] = soundpool.load(this, soundResouces1[3], 1 );
		soundIds[4] = soundpool.load(this, soundResouces1[4], 1 );
		soundIds[5] = soundpool.load(this, soundResouces1[5], 1 );
		soundIds[6] = soundpool.load(this, soundResouces1[6], 1 );
		soundIds[7] = soundpool.load(this, soundResouces1[7], 1 );
		soundIds[8] = soundpool.load(this, soundResouces1[8], 1 );
		soundIds[9] = soundpool.load(this, soundResouces1[9], 1 );
		soundIds[10] = soundpool.load(this, soundResouces1[10], 1 );
		soundIds[11] = soundpool.load(this, soundResouces1[11], 1 );
		soundIds[12] = soundpool.load(this, soundResouces1[12], 1 );
		soundIds[13] = soundpool.load(this, soundResouces1[13], 1 );
		soundIds[14] = soundpool.load(this, soundResouces1[14], 1 );
		soundIds[15] = soundpool.load(this, soundResouces1[15], 1 );
	}

	//���C����ʂ���resukt��ʂɑJ�ڂ���u�ԂɎ��s���郁�\�b�h
	@Override
	protected void onPause() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onPause();
	    
		//soundpool�̃����[�X
	    soundpool.release(); soundpool = null;
	    //mediaplayer�̃����[�X
	    mediaplayer.release(); mediaplayer = null;
	    
        timer.cancel();     
	}

	
	@Override
    protected void onDestroy() {
        super.onDestroy();
    }

	
	private void timerStart() {
		
		// �^�C�}�[�J�n�{�^���̏���
		start_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//�ꎟ��~�ƃ��^�[���{�^����\���A�X�^�[�g�{�^�����\��
				return_button.setVisibility(View.VISIBLE);                                                     
		        start_button.setVisibility(View.INVISIBLE);
		        
		        music1_button.setEnabled(false); music2_button.setEnabled(false);
		        
		        // �^�C�}�[1���Z�b�g
		        timerTask0 = new BGMTask(MainActivity.this,MainActivity.this,result,mediaplayer);
				timer =new Timer();
				timer.schedule(timerTask0,InterBGM);
				
				timerTask0.moveResult();
				
				/*���ݎ������擾*/
				StartTimeMillis = System.currentTimeMillis();
				
				//�{�^��1�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				for(int i=0; i < timing.delay1.length; i++) {
					timertaskAni[0] = new AnimationTask(MainActivity.this,handler,tap_button[0]);
					timer.schedule(timertaskAni[0], timing.delay1[i]+InterBGM-scheduleSetLagSum); 

					timertaskNo[0] = new DataNoTask(MainActivity.this,handler,data1);
					timer.schedule(timertaskNo[0], timing.delay1[i] + InterBGM-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					timertaskFla[0] = new DataFlagTask(MainActivity.this,handler,data1);
					timer.schedule(timertaskFla[0], timing.delay1[i] + InterBGM-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//�{�^��2�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag2 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay2.length; i++) {
					timertaskAni[1] = new AnimationTask(MainActivity.this,handler,tap_button[1]);
					timer.schedule(timertaskAni[1], timing.delay2[i]+InterBGM-AniTimeLag2-scheduleSetLagSum);

					timertaskNo[1] = new DataNoTask(MainActivity.this,handler,data2);
					timer.schedule(timertaskNo[1], timing.delay2[i] + InterBGM-AniTimeLag2-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					timertaskFla[1] = new DataFlagTask(MainActivity.this,handler,data2);
					timer.schedule(timertaskFla[1], timing.delay2[i] + InterBGM-AniTimeLag2-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//�{�^��3�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag3 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay3.length; i++) {
					timertaskAni[2] = new AnimationTask(MainActivity.this,handler,tap_button[2]);
					timer.schedule(timertaskAni[2], timing.delay3[i]+InterBGM-AniTimeLag3-scheduleSetLagSum); 

					timertaskNo[2] = new DataNoTask(MainActivity.this,handler,data3);
					timer.schedule(timertaskNo[2], timing.delay3[i] + InterBGM-AniTimeLag3-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					timertaskFla[2] = new DataFlagTask(MainActivity.this,handler,data3);
					timer.schedule(timertaskFla[2], timing.delay3[i] + InterBGM-AniTimeLag3-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//�{�^��4�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag4 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay4.length; i++) {
					timertaskAni[3] = new AnimationTask(MainActivity.this,handler,tap_button[3]);
					timer.schedule(timertaskAni[3], timing.delay4[i]+InterBGM-AniTimeLag4-scheduleSetLagSum); 

					timertaskNo[3] = new DataNoTask(MainActivity.this,handler,data4);
					timer.schedule(timertaskNo[3], timing.delay4[i] + InterBGM-AniTimeLag3-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					timertaskFla[3] = new DataFlagTask(MainActivity.this,handler,data4);
					timer.schedule(timertaskFla[3], timing.delay4[i] + InterBGM-AniTimeLag4-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//�{�^��5�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag5 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay5.length; i++) {
					timertaskAni[4] = new AnimationTask(MainActivity.this,handler,tap_button[4]);
					timer.schedule(timertaskAni[4], timing.delay5[i]+InterBGM-AniTimeLag5-scheduleSetLagSum); 

					timertaskNo[4] = new DataNoTask(MainActivity.this,handler,data5);
					timer.schedule(timertaskNo[4] , timing.delay5[i] + InterBGM-AniTimeLag3-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));
					
					timertaskFla[4] = new DataFlagTask(MainActivity.this,handler,data5);
					timer.schedule(timertaskFla[4], timing.delay5[i] + InterBGM-AniTimeLag5-scheduleSetLagSum +timing.AniDly+(timing.AniDly/2));
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//�{�^��6�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag6 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay6.length; i++) {	
					timertaskAni[5] = new AnimationTask(MainActivity.this,handler,tap_button[5]);
					timer.schedule(timertaskAni[5], timing.delay6[i]+InterBGM-AniTimeLag6-scheduleSetLagSum); 
					
					timertaskNo[5] = new DataNoTask(MainActivity.this,handler,data6);
					timer.schedule(timertaskNo[5], timing.delay6[i] +InterBGM-AniTimeLag6-scheduleSetLagSum + timing.AniDly-(timing.AniDly/2));

					timertaskFla[5] = new DataFlagTask(MainActivity.this,handler,data6);
					timer.schedule(timertaskFla[5], timing.delay6[i]+InterBGM-AniTimeLag6-scheduleSetLagSum + timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
				
				//�{�^��7�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag7 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay7.length; i++) {	
					timertaskAni[6] = new AnimationTask(MainActivity.this,handler,tap_button[6]);
					timer.schedule(timertaskAni[6], timing.delay7[i]+InterBGM-AniTimeLag7-scheduleSetLagSum); 
					
					timertaskNo[6] = new DataNoTask(MainActivity.this,handler,data7);
					timer.schedule(timertaskNo[6], timing.delay7[i]+InterBGM-AniTimeLag7-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[6] = new DataFlagTask(MainActivity.this,handler,data7);
					timer.schedule(timertaskFla[6], timing.delay7[i]+InterBGM-AniTimeLag7-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}	
				scheduleSetLagSum =0;
				
				//�{�^��8�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag8 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay8.length; i++) {	
					timertaskAni[7] = new AnimationTask(MainActivity.this,handler,tap_button[7]);
					timer.schedule(timertaskAni[7], timing.delay8[i]+InterBGM-AniTimeLag8-scheduleSetLagSum);
					
					timertaskNo[7] = new DataNoTask(MainActivity.this,handler,data8);
					timer.schedule(timertaskNo[7], timing.delay8[i]+InterBGM-AniTimeLag8-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[7] = new DataFlagTask(MainActivity.this,handler,data8);
					timer.schedule(timertaskFla[7], timing.delay8[i]+InterBGM-AniTimeLag8-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;
				
				//�{�^��9�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag9 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay9.length; i++) {	
					timertaskAni[8] = new AnimationTask(MainActivity.this,handler,tap_button[8]);
					timer.schedule(timertaskAni[8], timing.delay9[i]+InterBGM-AniTimeLag9-scheduleSetLagSum);
					
					timertaskNo[8] = new DataNoTask(MainActivity.this,handler,data9);
					timer.schedule(timertaskNo[8], timing.delay9[i]+InterBGM-AniTimeLag9-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[8] = new DataFlagTask(MainActivity.this,handler,data9);
					timer.schedule(timertaskFla[8], timing.delay9[i]+InterBGM-AniTimeLag9-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;
				
				//�{�^��10�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag10 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay10.length; i++) {	
					timertaskAni[9]= new AnimationTask(MainActivity.this,handler,tap_button[9]);
					timer.schedule(timertaskAni[9], timing.delay10[i]+InterBGM-AniTimeLag10-scheduleSetLagSum); 
					
					timertaskNo[9] = new DataNoTask(MainActivity.this,handler,data10);
					timer.schedule(timertaskNo[9], timing.delay10[i]+InterBGM-AniTimeLag10-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[9] = new DataFlagTask(MainActivity.this,handler,data10);
					timer.schedule(timertaskFla[9], timing.delay10[i]+InterBGM-AniTimeLag10-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;
				
				//�{�^��11�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag11 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay11.length; i++) {	
					timertaskAni[10]= new AnimationTask(MainActivity.this,handler,tap_button[10]);
					timer.schedule(timertaskAni[10], timing.delay11[i]+InterBGM-AniTimeLag11-scheduleSetLagSum); 
					
					timertaskNo[10] = new DataNoTask(MainActivity.this,handler,data11);
					timer.schedule(timertaskNo[10], timing.delay11[i]+InterBGM-AniTimeLag11-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[10] = new DataFlagTask(MainActivity.this,handler,data11);
					timer.schedule(timertaskFla[10], timing.delay11[i]+InterBGM-AniTimeLag11-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));		
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;

				//�{�^��12�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag12 = ButtonTimeMillis- StartTimeMillis;
				for(int i=0; i < timing.delay12.length; i++) {	
					timertaskAni[11]= new AnimationTask(MainActivity.this,handler,tap_button[11]);
					timer.schedule(timertaskAni[11], timing.delay12[i]+InterBGM-AniTimeLag12-scheduleSetLagSum); 
					
					timertaskNo[11] = new DataNoTask(MainActivity.this,handler,data12);
					timer.schedule(timertaskNo[11], timing.delay12[i]+InterBGM-AniTimeLag12-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[11]= new DataFlagTask(MainActivity.this,handler,data12);
					timer.schedule(timertaskFla[11], timing.delay12[i]+InterBGM-AniTimeLag12-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));		
					
					scheduleSetLagSum +=scheduleSetLag;
				}
				scheduleSetLagSum =0;
				
				//�{�^��13�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag13 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay13.length; i++) {	
					timertaskAni[12]= new AnimationTask(MainActivity.this,handler,tap_button[12]);
					timer.schedule(timertaskAni[12], timing.delay13[i]+InterBGM-AniTimeLag13-scheduleSetLagSum); 
					
					timertaskNo[12] = new DataNoTask(MainActivity.this,handler,data13);
					timer.schedule(timertaskNo[12] , timing.delay13[i]+InterBGM-AniTimeLag13-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[12] = new DataFlagTask(MainActivity.this,handler,data13);
					timer.schedule(timertaskFla[12], timing.delay13[i]+InterBGM-AniTimeLag13-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
				
				//�{�^��14�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag14 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay14.length; i++) {	
					timertaskAni[13]= new AnimationTask(MainActivity.this,handler,tap_button[13]);
					timer.schedule(timertaskAni[13], timing.delay14[i]+InterBGM-AniTimeLag14-scheduleSetLagSum); 
					
					timertaskNo[13] = new DataNoTask(MainActivity.this,handler,data14);
					timer.schedule(timertaskNo[13], timing.delay14[i]+InterBGM-AniTimeLag14-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[13] = new DataFlagTask(MainActivity.this,handler,data14);
					timer.schedule(timertaskFla[13], timing.delay14[i]+InterBGM-AniTimeLag14-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
				
				//�{�^��15�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag15 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay15.length; i++) {	
					timertaskAni[14]= new AnimationTask(MainActivity.this,handler,tap_button[14]);
					timer.schedule(timertaskAni[14], timing.delay15[i]+InterBGM-AniTimeLag15-scheduleSetLagSum); 
					
					timertaskNo[14] = new DataNoTask(MainActivity.this,handler,data15);
					timer.schedule(timertaskNo[14], timing.delay15[i]+InterBGM-AniTimeLag15-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[14] = new DataFlagTask(MainActivity.this,handler,data15);
					timer.schedule(timertaskFla[14], timing.delay15[i]+InterBGM-AniTimeLag15-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
				
				//�{�^��16�̃A�j���[�V�����^�C�}�[�E�^�X�N�̃Z�b�g
				ButtonTimeMillis = System.currentTimeMillis();
				AniTimeLag16 = ButtonTimeMillis- StartTimeMillis;
				
				for(int i=0; i < timing.delay16.length; i++) {	
					timertaskAni[15]= new AnimationTask(MainActivity.this,handler,tap_button[15]);
					timer.schedule(timertaskAni[15], timing.delay16[i]+InterBGM-AniTimeLag16-scheduleSetLagSum); 
					
					timertaskNo[15] = new DataNoTask(MainActivity.this,handler,data16);
					timer.schedule(timertaskNo[15], timing.delay16[i]+InterBGM-AniTimeLag16-scheduleSetLagSum+timing.AniDly-(timing.AniDly/2));

					timertaskFla[15] = new DataFlagTask(MainActivity.this,handler,data16);
					timer.schedule(timertaskFla[15], timing.delay16[i]+InterBGM-AniTimeLag16-scheduleSetLagSum+timing.AniDly+(timing.AniDly/2));	
					
					scheduleSetLagSum +=scheduleSetLag;
				}		
				scheduleSetLagSum =0;
			}
		});
		
		//return�{�^�����������ꍇ�̏���
		return_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//�ꎟ��~�ƃ��^�[���{�^����\���A�X�^�[�g�{�^�����\��
		        return_button.setVisibility(View.INVISIBLE);
		        start_button.setVisibility(View.VISIBLE);
		        //intent���쐬���A���݂̐��l����ResultActivity�ɓn��
		        Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
		        intent.putExtra("title",title);
		        intent.putExtra("returnscore",result.score);
		        intent.putExtra("returnmaxcombo",result.MaxCombo);
		        intent.putExtra("returngreatNo",result.greatNo);
		        intent.putExtra("returngoodNo",result.goodNo);
		        intent.putExtra("returnbadNo",result.badNo);
		        intent.putExtra("maxcomboNo",result.maxComboNo());
		        intent.putExtra("maxScore",result.scoreMax());
		        intent.putExtra("returnscoreAve",(int)result.scoreAve());
				startActivity(intent);
				//intent���쐬���A���݂̐��l����ResultActivity�ɓn��
		       /* timerTask0.stopBGM();
		        timer.cancel();     */ 
		    }
		});
}
	
	//16�̃{�^�����������ꍇ�̏������L�q
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			
			int GreLan =80;
			int GodLan =70;
			int BadLan =45;
			
			TouchTimeMillis = System.currentTimeMillis();
			Time =TouchTimeMillis-StartTimeMillis;
			
			//score���e�L�X�g�r���[�ɕ\��
			String stringscore = String.valueOf(result.score());
			TextView textView0 = (TextView) findViewById(R.id.textView1);
			textView0.setText(stringscore);
			
			//�v���C����combo�����e�L�X�g�ɕ\��
			String stringcombo = String.valueOf(result.comboNo());
			TextView textView00 = (TextView) findViewById(R.id.textView2);
			textView00.setText(stringcombo);
			 
			if((event.getAction() == MotionEvent.ACTION_DOWN) || (event.getAction() == MotionEvent.ACTION_POINTER_DOWN)) {
				switch (v.getId()) {
					//button1���������ꍇ
					case R.id.TapButton1:
						soundpool.play(soundIds[0], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data1.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");	
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
					//button2���������ꍇ
					case R.id.TapButton2:
						soundpool.play(soundIds[1], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data2.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");	
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
					//button3���������ꍇ
					case R.id.TapButton3:
						soundpool.play(soundIds[2], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data3.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");	
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
					//button4���������ꍇ
					case R.id.TapButton4:
						soundpool.play(soundIds[3], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data4.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");	
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
					//button5���������ꍇ
					case R.id.TapButton5:
						soundpool.play(soundIds[4], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data5.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");	
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
					//button6���������ꍇ
					case R.id.TapButton6:
						soundpool.play(soundIds[5], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data6.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
						soundpool.play(soundIds[6], 0.5F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data7.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
						soundpool.play(soundIds[7], 0.5F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data8.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
					//button9���������ꍇ
					case R.id.TapButton9:
						soundpool.play(soundIds[8], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data9.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
					//button10���������ꍇ
					case R.id.TapButton10:
						soundpool.play(soundIds[9], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data10.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
					//button11���������ꍇ
					case R.id.TapButton11:
						soundpool.play(soundIds[10], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data11.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
					//button12���������ꍇ
					case R.id.TapButton12:
						soundpool.play(soundIds[11], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data12.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
					//button13���������ꍇ
					case R.id.TapButton13:
						soundpool.play(soundIds[12], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data13.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
					//button14���������ꍇ
					case R.id.TapButton14:
						soundpool.play(soundIds[13], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data14.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
					//button15���������ꍇ
					case R.id.TapButton15:
						soundpool.play(soundIds[14], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						if(data15.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
						soundpool.play(soundIds[15], 1.0F, 1.0F, 0, 0, 1.0F);
						scheduleSetLagSum =0;
						Log.d("ddddd", "aaaaa");
						if(data16.getFlag() ==0) {
							TextView textView1 = (TextView) findViewById(R.id.valueView);
							textView1.setText("");
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
				//max��combo�����X�V���Ă���
				if(result.MaxCombo <= result.comboNo){
					if(result.comboNo != 0){
						result.MaxCombo =result.comboNo;
					}	
				}
				return true;
			}else if((event.getAction() == MotionEvent.ACTION_UP) || (event.getAction() == MotionEvent.ACTION_POINTER_UP)) {
				switch (v.getId()) {
				case R.id.TapButton1:
					button_1.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[0]);
					break;
				case R.id.TapButton2:
					button_2.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[1]);
					break;
				case R.id.TapButton3:
					button_3.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[2]);
					break;
				case R.id.TapButton4:
					button_4.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[3]);
					break;
				case R.id.TapButton5:
					button_5.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[4]);
					break;
				case R.id.TapButton6:
					button_6.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[5]);
					break;
				case R.id.TapButton7:
					button_7.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[6]);
					break;
				case R.id.TapButton8:
					button_8.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[7]);
					break;
				case R.id.TapButton9:
					button_9.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[8]);
					break;
				case R.id.TapButton10:
					button_10.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[9]);
					break;
				case R.id.TapButton11:
					button_11.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[10]);
					break;
				case R.id.TapButton12:
					button_12.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[11]);
					break;
				case R.id.TapButton13:
					button_13.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[12]);
					break;
				case R.id.TapButton14:
					button_14.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[13]);
					break;
				case R.id.TapButton15:
					button_15.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[14]);
					break;
				case R.id.TapButton16:
					button_16.setBackgroundResource(android.R.drawable.btn_default);
					soundpool.stop(soundIds[15]);
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
