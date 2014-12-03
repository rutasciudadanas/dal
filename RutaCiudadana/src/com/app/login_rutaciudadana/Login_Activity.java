package com.app.login_rutaciudadana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.app.rutaciudadana.MainActivity;
import com.app.rutaciudadana.R;
import com.facebook.Session;
import com.facebook.SessionLoginBehavior;
import com.facebook.SessionState;
import com.facebook.widget.LoginButton;
import com.parse.Parse;

public class Login_Activity extends FragmentActivity {
	LoginButton loginButton;
	private Session.StatusCallback sessionStatusCallback;
	private Session estadosession;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		 Parse.initialize(this, "1VvAzyTMLt7CQ3i7vut3M2Swt4COjGy5qPwV1ypt", "aQ4VaKIoNTJa8SDtfGTJwR8CymLfGEf4jgeHCtQU");

        loginButton = (LoginButton) findViewById(R.id.login_button);
       loginButton.setOnClickListener(new OnClickListener()
       {
    	   public void onClick(View v){
    		   Coneccion_F ();
    		   Log.d("muestra", "on click");
    	   }
       });
        sessionStatusCallback=new Session.StatusCallback() {
		
		
        public void call(Session session,SessionState state,Exception exception)
        {
        	onSessionStateChange(session,state,exception);
        }
       };
	}

    public void principal(View v){startActivity(new Intent(this,MainActivity.class)); }
    
    // conexion
    public void Coneccion_F(){
       estadosession=new Session.Builder(this).build();
       estadosession.addCallback(sessionStatusCallback);
       Session.OpenRequest openRequest=new Session.OpenRequest(this);
       openRequest.setLoginBehavior(SessionLoginBehavior.SUPPRESS_SSO);
       openRequest.setRequestCode(Session.DEFAULT_AUTHORIZE_ACTIVITY_CODE);
       estadosession.openForPublish(openRequest);

    }
    public void onActivityResult(int requestCode, int resultCode,Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	if(estadosession!=null){
    		estadosession.onActivityResult(this, requestCode, resultCode, data);
    	}
    }
    
    
	private void onSessionStateChange(Session session,SessionState state,Exception exception)
    {
    	if(session!=estadosession){return;}
    	if(state.isOpened()){mensaje("session de facebook  abierta");}
    	else if(state.isClosed()){mensaje("session cerrada");}
    	
    }


	
	
	   private void mensaje(String arg){
	    	Toast.makeText(this, arg, Toast.LENGTH_SHORT).show();
	    }
}
