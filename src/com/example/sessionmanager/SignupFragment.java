package com.example.sessionmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SignupFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
		View view = inflater.inflate(R.layout.signup, container, false);
		
		Button signup_button = (Button) view.findViewById(R.id.sign_up_button);
        
        // A simple OnClickListener for our button. You can see here how a Fragment can encapsulate
        // logic and views to build out re-usable Activity components.
		signup_button.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {

            	}
        });
		
		return view;
	}
}
