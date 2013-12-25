package com.example.otoge_;

import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

public class DataFlagTask extends TimerTask {
	
	private Handler handler;
	private Context context;
	private Data data;
		
	public DataFlagTask(MainActivity activity,Handler handler,Data data) {
		this.context=context;
		this.handler = handler;
		this.data = data;
	}
	
	@Override
	public void run() {
		handler.post(new Runnable() {
			 @Override
			 public void run() {
				 //Dataクラスの　変数：Flagを0に初期化
				 data.init();
			      }
			    });
	}
}

