package com.example.otoge_;

import java.util.TimerTask;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;

public class BGMTask extends TimerTask {
	
	private Handler handler;
	private MediaPlayer mediaPlayer;
	private Context context;
	private long BGMTimeMillis;
	
	public BGMTask(Context context,Long BGMTimeMillis) {
		this.context=context;
		handler = new Handler();
		this.BGMTimeMillis =BGMTimeMillis;
		mediaPlayer =MediaPlayer.create(context, R.raw.bgm1);
	}
	
	@Override
	public void run() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				mediaPlayer.start();
				Log.d("bgm", "run");
				
				//åªç›éûçèÇéÊìæ
				BGMTimeMillis = System.currentTimeMillis();
				Log.d("aaaaaaaaa", String.valueOf(BGMTimeMillis));
				
			}
		});
	}
	
	
}
