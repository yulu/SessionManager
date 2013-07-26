package com.example.sessionmanager;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity{
	SessionManager session;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		session = new SessionManager(getApplicationContext());
		
		TextView txName = (TextView)findViewById(R.id.userName);
		TextView txEmail= (TextView)findViewById(R.id.userEmail);
		
		session.checkLogin();
		
		HashMap<String, String> user = session.getUserDetails();
		String name = user.get(SessionManager.KEY_NAME);
		String email = user.get(SessionManager.KEY_EMAIL);
		
		txName.setText(name);
		txEmail.setText(email);
	}
}
