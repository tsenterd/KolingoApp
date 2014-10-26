package com.example.edalexapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.widget.ImageView;


public class SubjectIcon extends ImageView {
	private Activity activity;
	private int subjectID;

	public SubjectIcon(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		activity = (Activity)context;
	}
	/*
	public boolean onTouchEvent (MotionEvent m){
		if (m.getActionMasked() == MotionEvent.ACTION_DOWN){
			activity.startActivity (new Intent(activity, SubjectActivity.class).putExtra(Subject.INTENTID, subjectID));
			return true;
		}
		return false;
	}
	*/

}
