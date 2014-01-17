package com.example.otoge_;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends Activity {
	//既存情報(maxcomboの数とmaxscore)
	private int maxComboNo;
	private int maxScore;
	
	//停止ボタン
	private int tempoScore;
	private int tempoMaxcombo;
	private int tempogreatNo;
	private int tempogoodNo;
	private int tempobadNo;
	private int tempoScoreAve;
	
	Button	continue_button, end_button;
	
	ImageView rank;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_result);
		
		continue_button = (Button)findViewById(R.id.continue_button);
		
		rank = (ImageView) findViewById(R.id.imageView1);
		
		//既存情報(maxcomboの数とmaxscore)情報の受け取り
		Bundle extras00 = getIntent().getExtras();
		maxComboNo = extras00.getInt("maxcomboNo");
		Bundle extras01 = getIntent().getExtras();
		maxScore = extras01.getInt("maxScore");
		
		//既存情報(maxcomboの数とmaxscore)情報の文字化
		String stringscore00 = String.valueOf(maxScore);
		String stringscore01 = String.valueOf(maxComboNo);
		
		//停止ボタンを押した場合
		//途中情報(Intent)の受け取り
		Bundle extras6 = getIntent().getExtras();
		tempoScore = extras6.getInt("returnscore");//score情報
		Bundle extras7 = getIntent().getExtras();
		tempoMaxcombo = extras7.getInt("returnmaxcombo");//更新Maｘcombo情報
		Bundle extras8 = getIntent().getExtras();
		tempogreatNo = extras8.getInt("returngreatNo");//Maｘgreat情報
		Bundle extras9 = getIntent().getExtras();
		tempogoodNo = extras9.getInt("returngoodNo");//Maｘgood情報
		Bundle extras10 = getIntent().getExtras();
		tempobadNo = extras10.getInt("returnbadNo");//Maｘbad情報
		Bundle extras11 = getIntent().getExtras();
		tempoScoreAve = extras11.getInt("returnscoreAve");///平均score情報
	
		//途中情報(Intent)の文字化
		String stringscore6 = String.valueOf(tempoScore);
		String stringscore7 = String.valueOf(tempoMaxcombo);
		String stringscore8 = String.valueOf(tempogreatNo);
		String stringscore9 = String.valueOf(tempogoodNo);
		String stringscore10 = String.valueOf(tempobadNo);
		String stringscore11 = String.valueOf(tempoScoreAve);
		
		//途中情報(Intent)の表示
		TextView textView6 = (TextView) findViewById(R.id.textSCORE);
		textView6.setText(stringscore6+"/"+stringscore00+" ("+stringscore11+"%)");//score情報
		TextView textView7 = (TextView) findViewById(R.id.textMAX_COMBO);
		textView7.setText(stringscore7 +"/"+stringscore01);//更新Maｘcombo情報
		TextView textView8 = (TextView) findViewById(R.id.textMAX_GREAT);
		textView8.setText(stringscore8 +"/"+stringscore01);//Maｘgreat情報
		TextView textView9 = (TextView) findViewById(R.id.textMAX_GOOD);
		textView9.setText(stringscore9 +"/"+stringscore01);//Maｘgood情報
		TextView textView10 = (TextView) findViewById(R.id.textMAX_BAD);
		textView10.setText(stringscore10 +"/"+stringscore01);//Maｘbad情報
		
		String title_name = getIntent().getStringExtra("title");
		TextView textView11 = (TextView) findViewById(R.id.title_text);
		textView11.setText(title_name);		
		
		//ランクの表示
		if(0<=tempoScoreAve && tempoScoreAve<50){
			rank.setImageResource(R.drawable.beginner_image1);
		} else if (50<=tempoScoreAve && tempoScoreAve<90) {
			rank.setImageResource(R.drawable.amateur_image1);
		} else if (90<=tempoScoreAve &&tempoScoreAve<=100) {
			rank.setImageResource(R.drawable.professional_image1);
		}
		
		continue_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
			finish();
			
			}
		});
		
		/*end_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			
		
			
	
			}
		});*/
	}

		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 @Override
	    public boolean onKeyDown(int keyCode, KeyEvent event) {
	        // BackBtnアクション
	        if(keyCode==KeyEvent.KEYCODE_BACK){
	             finish();
	             /*Intent intent=new Intent(getApplicationContext(),MainActivity.class);	
	 			startActivity(intent);*/
	        }
			return false;
	    }

}
