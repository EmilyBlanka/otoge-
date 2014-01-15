package com.example.otoge_;

import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.util.Log;

public class BGMTask extends TimerTask {
	
	private Handler handler;
	private Context context;
	private Activity activity;
	private MediaPlayer mediaplayer;
	private ResultData result;
	
	public BGMTask(Context context,Activity activity,ResultData result,MediaPlayer mediaplayer) {
		this.context=context;
		this.activity=activity;
		this.result =result;
		handler = new Handler();
		this.mediaplayer=mediaplayer;
		/*mediaPlayer =MediaPlayer.create(context, R.raw.bgm1);*/
	}
	
	@Override
	public void run() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				mediaplayer.start();
				Log.d("bgm", "run");
				
			}
		});
	}
	
	public void stopBGM() {
		if (mediaplayer.isPlaying()) {
        	mediaplayer.stop();
        	mediaplayer.release();
        	mediaplayer = null;

        } else {
        }
	}
	
	public void moveResult() {
		mediaplayer.setOnCompletionListener(new OnCompletionListener() {	
			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO 自動生成されたメソッド・スタブ
				Intent intent=new Intent(activity.getApplicationContext(),ResultActivity.class);
				intent.putExtra("title",MainActivity.title);
				intent.putExtra("returnscore",result.score);
		        intent.putExtra("returnmaxcombo",result.MaxCombo);
		        intent.putExtra("returngreatNo",result.greatNo);
		        intent.putExtra("returngoodNo",result.goodNo);
		        intent.putExtra("returnbadNo",result.badNo);
		        intent.putExtra("maxcomboNo",result.maxComboNo());
		        intent.putExtra("maxScore",result.scoreMax());
		        intent.putExtra("returnscoreAve",(int)result.scoreAve());
		        activity.startActivity(intent);
			}
		});	
	}
	
	/*public void changeBGM1() {
		mediaPlayer.release();
        mediaPlayer =MediaPlayer.create(context, R.raw.all_beats1);
	}*/
}
	
