package com.example.sessionmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment{
	OnButtonClickedListener mListener;
	
    // Email, password edittext
    EditText txtUsername, txtPassword;
    // Session Manager Class
    SessionManager session;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
		View view = inflater.inflate(R.layout.login, container, false);
		
		Button start_signup_button = (Button) view.findViewById(R.id.start_sign_up_button);
		Button signin_button = (Button) view.findViewById(R.id.sign_in_button);
		
		// Session Manager
        session = new SessionManager(getActivity());                
         
        // Email, Password input text
        txtUsername = (EditText) view.findViewById(R.id.email);
        txtPassword = (EditText) view.findViewById(R.id.password); 
        
        // A simple OnClickListener for our button. You can see here how a Fragment can encapsulate
        // logic and views to build out re-usable Activity components.
		signin_button.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	// Get username, password from EditText
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                 
                // Check if username, password is filled                
                if(username.trim().length() > 0 && password.trim().length() > 0){
                    // For testing puspose username, password is checked with sample data
                    // username = test
                    // password = test
                    if(username.equals("test") && password.equals("test")){
                         
                        // Creating user login session
                        // For testing i am stroing name, email as follow
                        // Use user real data
                        session.createLoginSession("Android Hive", "anroidhive@gmail.com", "000");
                         
                        // Staring MainActivity
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        getActivity().startActivity(i);
                        getActivity().finish();
                         
                    }else{
                        // username / password doesn't match
                        
                    }               
                }else{
                    // user didn't entered username or password
                    // Show alert asking him to enter the details
                   
                }
            }
        });
		
        
		start_signup_button.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
            	mListener.onButtonClicked();
            }
            
        });
		
        return view;
	}
	
	public interface OnButtonClickedListener{
		public void onButtonClicked();
	}
	
	
	@Override
	public void onAttach(Activity activity){
		super.onAttach(activity);
		try{
			mListener = (OnButtonClickedListener)activity;
		}catch(ClassCastException e){
			throw new ClassCastException(activity.toString()+"must implement OnButtonClickListener");
		}
	}
}
