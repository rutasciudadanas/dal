package com.app.rutaciudadana;



import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends FragmentActivity   {
	
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
	    getActionBar().setCustomView(R.layout.icon_actionbar);
	    
		
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		int id = item.getItemId();
		if (id == R.id.action_settings){
			return true;
		}
		if(id==R.id.puntoab){
			 startActivity(new Intent(this,Punto_Activity.class));
			

		}
		if(id==R.id.rutasbuses){
			startActivity(new Intent(this,Ruta_Activity.class));
			 

		}
		if(id==R.id.denuncia){
			startActivity(new Intent(this,Denuncia_Activity.class));
			

		}
		
		return super.onOptionsItemSelected(item);

	}
	
	
	
	
	
}
