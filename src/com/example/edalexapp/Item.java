package com.example.edalexapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable{
	protected String title;
	protected String description;
	protected SubjectIcon icon;
	protected String createdDate;
	protected int classID;
	protected String itemID;
	
	public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item> (){
		public Item createFromParcel (Parcel in){
			return new Item (in);
		}
		
		public Item[] newArray (int n){
			return new Item[n];
		}
	};
	
	public Item (Parcel in){
		title = in.readString ();
		description = in.readString();
		createdDate = in.readString();
		classID = in.readInt();
		itemID = in.readString();
	}
	
	public int describeContents (){
		return 0;
	}
	
	public void writeToParcel(Parcel out, int flags){
		out.writeString (title);
		out.writeString (description);
		out.writeString(createdDate);
		out.writeInt(classID);
		out.writeString(itemID);
	}
	
	public Item (){
	}
	
	public void setTitle (String title){
		this.title = title;
	}
	
	public void setDescription (String description){
		this.description = description;
	}
	
	public void setIcon (SubjectIcon icon){
		this.icon = icon;
	}
	
	public void setDatecreated (String date){
		this.createdDate = date;
	}
	
	public void setitemID (String id){
		this.itemID = id;
	}
	
	public void setClassID(int id){
	    classID = id;
	}
	public String toString()
	{
		return (title + " " + description);
	}
}
