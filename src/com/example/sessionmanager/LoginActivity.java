package com.example.sessionmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public class LoginActivity extends FragmentActivity implements
		LoginFragment.OnButtonClickedListener{
	
	FragmentManager fm = getSupportFragmentManager();
	Fragment fragment;
	FragmentTransaction ft;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_fragment);
		
		fm = getSupportFragmentManager();
		fragment = fm.findFragmentById(R.id.fragment_content);
		
		if(fragment == null){
			ft = fm.beginTransaction();
			ft.add(R.id.fragment_content, new LoginFragment());
			ft.commit();
		}
		
	}
	
	@Override
	public void onButtonClicked(){
		if(fragment == null){
			ft = fm.beginTransaction();
			ft.replace(R.id.fragment_content, new SignupFragment());
			ft.addToBackStack(null);
			ft.commit();
		}
	}
}
