package com.example.otoge_;

import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;


public class BGMTask extends TimerTask {
	
	private Handler handler;
	private Context context;
	private long BGMTimeMillis;
	private Activity activity;
	private MediaPlayer mediaPlayer;
	
	public BGMTask(Context context,Activity activity) {
		this.context=context;
		this.activity=activity;
		handler = new Handler();
		this.mediaPlayer=mediaPlayer;
		mediaPlayer =MediaPlayer.create(context, R.raw.bgm1);
	}
	
	@Override
	public void run() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				mediaPlayer.start();
				Log.d("bgm", "run");
				
				mediaPlayer.setOnCompletionListener(new OnCompletionListener() {	
					@Override
					public void onCompletion(MediaPlayer mp) {
						// TODO 自動生成されたメソッド・スタブ
						Intent intent=new Intent(context,ResultActivity.class);
						activity.startActivity(intent);
						
						
					}
				});
				
			}
		});
	}
	
	public void stopBGM() {
		if (mediaPlayer.isPlaying()) {
        	mediaPlayer.stop();
        	mediaPlayer.release();
        } 
	}
	
	
}
