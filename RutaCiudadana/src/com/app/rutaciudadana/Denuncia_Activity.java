package com.app.rutaciudadana;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Denuncia_Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_denuncia);
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		getActionBar().setCustomView(R.layout.icon_actionbar);
		    
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.denuncia_, menu);
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
