package jp.ed.human.android2013.BeaTap;

public class ScoreJudgeData {
	
	//フィールド変数
	int no =0;
	int flag=0;
	
	//コンストラクタ
	ScoreJudgeData(int no) {this.no=no; flag=0;}
	void setNo(int no){this.no=no;}
	
	//メソッド
	void comp(){this.flag=1;}
	void init(){this.flag=0;}
	int getNo(){return this.no;}
	void countupNo() {this.no++;}
	int getFlag(){return this.flag;}

}
