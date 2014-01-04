package com.example.otoge_;

import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

public class DataNoTask extends TimerTask {
	
	private Handler handler;
	private Context context;
	private ScoreJudgeData data;
		
	public DataNoTask(MainActivity activity,Handler handler,ScoreJudgeData data) {
		this.context=context;
		this.handler = handler;
		this.data = data;
	}
	
	@Override
	public void run() {
		handler.post(new Runnable() {
			 @Override
			 public void run() {
				 //Dataクラスの　変数：Noに１を加えていく
				 data.countupNo();
				 //Dataクラスの　変数：Flagを1に変更(初期値=0)
				 data.comp();		 
			 }
		});
	}
}

