package com.example.edalexapp;

import android.os.Parcel;
import android.os.Parcelable;

public class HomeWork extends Item implements Parcelable{
	
	public HomeWork(){}
	
	public HomeWork (Parcel in){
		super (in);
	}
	
	public static final Parcelable.Creator<HomeWork> CREATOR = new Parcelable.Creator<HomeWork> (){
		public HomeWork createFromParcel (Parcel in){
			return new HomeWork (in);
		}
		
		public HomeWork[] newArray (int n){
			return new HomeWork[n];
		}
	};
	
}
