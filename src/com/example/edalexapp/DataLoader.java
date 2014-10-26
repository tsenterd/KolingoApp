package com.example.edalexapp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.JsonReader;
import android.util.Log;

public class DataLoader {
	public static String afterDate;
	
	public static ArrayList<Item> loadData(Activity activity, int classID){
		ConnectivityManager con = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo;
		
		 networkInfo = con.getActiveNetworkInfo();
		
		
	    if (networkInfo != null && networkInfo.isConnected()) {
	    	try {
	    	String currentDateandTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	    	URL hwURL = new URL ("http://edapphack.herokuapp.com/api/homework/get.php?class_id=" + classID + "&after=" + "2014-10-23 12:00:00");
	    	Log.d("url",hwURL.toString());
	    	HttpURLConnection conn = (HttpURLConnection) hwURL.openConnection();
	        conn.setReadTimeout(10000 /* milliseconds */);
	        conn.setConnectTimeout(15000 /* milliseconds */);
	        conn.setRequestMethod("GET");
	        conn.setDoInput(true);
	        // Starts the query
	        conn.connect();
	        int response = conn.getResponseCode();

	      
	        JsonReader reader = new JsonReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

	        return (readMessagesArray(reader));
	    	}
	    	catch (MalformedURLException e){
	    		
	    	}
	    	catch (IOException e){
	    	
	    	}
	        finally{
	        	
	        }
	    	
	    }
	    return null;
	}
	
	public static ArrayList<Item> readMessagesArray(JsonReader reader) throws IOException {
	     ArrayList<Item> messages = new ArrayList<Item>();

	     reader.beginArray();
	     while (reader.hasNext()) {
	       messages.add(readMessage(reader));
	     }
	     reader.endArray();
	     return messages;
	   }
	
	public static Item readMessage(JsonReader reader) throws IOException {
	     Item item = new Item();

	     reader.beginObject();
	     while (reader.hasNext()) {
	       String name = reader.nextName();
	       if (name.equals("homework_id") || name.equals("announcement_id")) {
	         item.setitemID(reader.nextString());
	       } else if (name.equals("class_id")) {
	         item.setClassID(reader.nextInt());
	       } else if (name.equals("homework_data") ||name.equals("announcement_data")){
	         item.setDescription(reader.nextString());
	       } else if (name.equals("homework_title")||name.equals("announcement_title")) {
	         item.setTitle(reader.nextString());
	       }else if (name.equals("created"))
	       {
	    	   item.setDatecreated(reader.nextString());
	       }
	       else {
	         reader.skipValue();
	       }
	     }
	     reader.endObject();
	     return item;
	   }

	
}
