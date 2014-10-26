package com.example.edalexapp;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Subject implements Parcelable{
	public static final String INTENTID = "subject";
	protected ArrayList<HomeWork> homework;
	protected ArrayList<Anouncement> anouncements;
	
	public Subject (Parcel in){
		in.readTypedList(homework, HomeWork.CREATOR);
	}
	
	public int describeContents (){
		return 0;
	}
	
	public static final Parcelable.Creator<Subject> CREATOR = new Parcelable.Creator<Subject>() {
		public Subject createFromParcel (Parcel in){
			return new Subject (in);
		}
		
		public Subject[] newArray(int size){
			return new Subject[size];
		}
	};
	
	public void writeToParcel (Parcel out, int flags){
		out.writeTypedList(homework);
		out.writeTypedList(anouncements);
	}
}
