package com.example.sessionmanager;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {
	SharedPreferences pref;
	Editor editor;
	Context _context;
	
	int PRIVATE_MODE = 0;
	private static final String PREF_NAME 	= "TestPref";
	private static final String IS_LOGIN 	= "IsLoggedIn";
	public static final String KEY_NAME 	= "name";
	public static final String KEY_EMAIL 	= "email";
	public static final String USER_TOKEN 	= "token";
	
	public SessionManager(Context context){
		this._context = context;
		pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
		editor = pref.edit();
	}
	
	/**
	 * Create login session
	 */
	public void createLoginSession(String name, String email, String token){
		editor.putBoolean(IS_LOGIN, true);
		editor.putString(KEY_NAME, name);
		editor.putString(KEY_EMAIL, email);
		editor.putString(USER_TOKEN, token);
		
		editor.commit();
	}
	
	/**
	 * Get Stored session data
	 */
	public HashMap<String, String> getUserDetails(){
		HashMap<String, String> user = new HashMap<String, String>();
		user.put(KEY_NAME, pref.getString(KEY_NAME, null));
		user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
		user.put(USER_TOKEN, pref.getString(USER_TOKEN, null));
	
		return user;
	}
	
	/**
	 * Check login method - direct user to login activity if fail to sign in
	 */
	public void checkLogin(){
		if(!this.isLoggedIn()){
			Intent i = new Intent(_context, LoginActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			_context.startActivity(i);
		}
	}
	
	/**
	 * clear session
	 */
	public void logoutUser(){
		editor.clear();
		editor.commit();
		
		Intent i = new Intent(_context, LoginActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		_context.startActivity(i);
	}
	
	public boolean isLoggedIn(){
		return pref.getBoolean(IS_LOGIN, false);
	}
}
