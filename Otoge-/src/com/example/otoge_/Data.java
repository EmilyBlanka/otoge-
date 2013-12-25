package com.example.otoge_;

public class Data {
	
	//フィールド変数
	int no =0;
	int flag=0;
	
	//コンストラクタ
	Data(int no) {this.no=no; flag=0;}
	void setNo(int no){this.no=no;}
	
	//メソッド
	void comp(){this.flag=1;}
	void init(){this.flag=0;}
	int getNo(){return this.no;}
	void countupNo() {this.no++;}
	int getFlag(){return this.flag;}

}
