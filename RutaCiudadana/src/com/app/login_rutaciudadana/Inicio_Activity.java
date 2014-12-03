package com.app.login_rutaciudadana;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.Toast;

import com.app.rutaciudadana.R;

public class Inicio_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_inicio);
		
	        Handler handler=new Handler();
	        //accion a ejetarse durante un periodo de tiempo.
	        handler.postDelayed(new Runnable(){
	        	public void run(){
	        		mensaje("Bienvenido!!");
	        		startActivity(new Intent (Inicio_Activity.this,Login_Activity.class));
	        		finish();
	        	}
	        }, 3000);
	        	
	    }

    private void mensaje(String arg){
    	Toast.makeText(this, arg, Toast.LENGTH_SHORT).show();
    }

}
