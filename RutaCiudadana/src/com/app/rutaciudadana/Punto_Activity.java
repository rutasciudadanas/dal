package com.app.rutaciudadana;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Punto_Activity extends Activity {
	Toast toast;
	Boolean nuevo_estado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_punto);
		getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); 
		//area de action bar
	    getActionBar().setCustomView(R.layout.icon_actionbar);
	   //recuperacion de la variable de estado enviada desde ubicacion Activity
		Boolean estado=getIntent().getBooleanExtra("estado",false);
		String direc=getIntent().getStringExtra("direccion");
		
		if(estado!=false){
            toast=Toast.makeText(getApplicationContext(), "bien",Toast.LENGTH_SHORT);
            nuevo_estado=true;
            Button btn_partida=(Button)findViewById(R.id.puntoa);
            btn_partida.setText(direc);
            
		}
		else {
            toast=Toast.makeText(getApplicationContext(), "NO!!",Toast.LENGTH_SHORT);	
            nuevo_estado=false;
		}
		
		toast.show();
	}
	public void ruta(View v){
		Intent i=new Intent(this,Ubicacion_Activity.class);
		i.putExtra("nuevo_estado", nuevo_estado);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.punto_, menu);
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
			 finish();

		}
		if(id==R.id.rutasbuses){
			startActivity(new Intent(this,Ruta_Activity.class));
			 finish();

		}
		if(id==R.id.denuncia){
			startActivity(new Intent(this,Denuncia_Activity.class));
			 finish();

		}
		
		return super.onOptionsItemSelected(item);

	}
}
