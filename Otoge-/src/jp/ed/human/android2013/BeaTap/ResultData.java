package jp.ed.human.android2013.BeaTap;

public class ResultData {
	//フィールド変数
	int score=0;
	int MaxCombo=0;
	int MaxComboNo=0;
	
	int greatNo =0;
	int goodNo =0;
	int badNo =0;
	int comboNo =0;
	
	//コンストラクタ
	ResultData(int MaxComboNo) {this.MaxComboNo=MaxComboNo;}
	/*void setNo(int no){this.no=no;}*/
	
	//メソッド
	void greatPointUp(){this.score=score+70;}
	void goodPointUp(){this.score=score+30;}
		
	void greatNoUp() {this.greatNo++;}
	void goodNoUp() {this.goodNo++;}
	void badNoUp() {this.badNo++;}
	void comboNoUp() {this.comboNo++;}
	void comboNoRes() {this.comboNo=0;}
	void setMaxComboNo(int MaxComboNo) {this.MaxComboNo=MaxComboNo;}
	
	int score() {return score;}
	int comboNo() {return comboNo;}
	int maxComboNo() {return MaxComboNo;}
	int scoreMax() {return MaxComboNo*70;}
	
	double scoreAve() {return Math.round((double)score()/(double)scoreMax()*100.0);}
	int maxCombo() {return MaxCombo;}//更新情報

}
