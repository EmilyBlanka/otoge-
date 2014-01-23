package jp.ed.human.android2013.BeaTap;

import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationTask extends TimerTask {
	
	private Handler handler;
	private Context context;
	private ImageView img;		
	Animation anim1;
		
	public AnimationTask(MainActivity activity,Handler handler,ImageView img) {
		this.context=context;
		this.handler = handler;
		this.img =img;
		anim1 = AnimationUtils.loadAnimation(activity,R.anim.button_anim01);
		
	}
	
	@Override
	public void run() {
		handler.post(new Runnable() {
			 @Override
			 public void run() {
				 img.startAnimation(anim1);
				 
			      }
			    });
	}
}

