package com.app.rutaciudadana;



import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.app.utils_rutaciudadana.LocationPosicion_GPS;

public class Ubicacion_Activity extends Activity {
	private CheckBox checkBox;
	private Boolean estado,nuevo_estado;
	private String msg,direccion;
	private double msg_latitud,msg_longitud;
	Toast toast; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ubicacion);
		checkBox=(CheckBox)findViewById(R.id.CheckUbicacion);
		//recibe de nuevo la variable con su nuevo estado
		nuevo_estado=getIntent().getBooleanExtra("nuevo_estado",false);
		if(nuevo_estado!=false){checkBox.setVisibility(View.INVISIBLE);}
		else{checkBox.setVisibility(View.VISIBLE);}
		
	}
	
	public void Obtener_inicio(View v){
		
		if(checkBox.isChecked()){
			Location_GPS();
            toast=Toast.makeText(getApplicationContext(), "Hola has cheakeado!!!",Toast.LENGTH_SHORT);	
            estado=true; 
            
              
		}
	   else
	   {
		toast= Toast.makeText(getApplicationContext(), "Has check",Toast.LENGTH_SHORT);	
		estado=false;
        }
		
		
		 toast.show();
		 Intent i=new Intent(this,Punto_Activity.class);
         i.putExtra("estado",estado);
         i.putExtra("direccion",direccion);
         startActivity(i);
         finish();
	}
	
	public void Location_GPS()
	{
		LocationManager objLocation_Manager=null;
		LocationListener objLocation_Listener;
		
		objLocation_Manager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
		objLocation_Listener=new LocationPosicion_GPS();
		objLocation_Manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, objLocation_Listener);
		    if(objLocation_Manager.isProviderEnabled(LocationManager.GPS_PROVIDER))
		    {
		    	if(LocationPosicion_GPS.latitud>0)
		    	{
		    		//msg_latitud=LocationPosicion_GPS.latitud;
		    		//msg_longitud=LocationPosicion_GPS.longitud;
		    		obtenerDireccion(LocationPosicion_GPS.coordenadas);
		    	}
		    	else
		    	{
		    		AlertDialog.Builder alert=new AlertDialog.Builder(Ubicacion_Activity.this);
		    		alert.setTitle("En espera");
					alert.setMessage("conectado con GPS");
					alert.setPositiveButton("ok", null);
					alert.create().show();
		    	}
		    }
		    else
		    {
		    	AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTitle("GPS no Activado!!!");
			builder.setMessage("Porfavor Active el servicio de localizacion y GPS");
	        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int whichg) {
					// TODO Auto-generated method stub
					
				}
			});
			builder.setPositiveButton("Activar", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
			   		startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
				}
			});
				}


		    }
	
	
	public void obtenerDireccion(Location loc)
	{
		if(loc.getLatitude()!=0.0&&loc.getLongitude()!=0.0)
		{
			try
			{
				Geocoder geocoder=new Geocoder(this,Locale.getDefault());
				List<Address>list=geocoder.getFromLocation(loc.getLatitude(),
						loc.getLongitude(), 1);
				if(!list.isEmpty())
				{
					Address address=list.get(0);
					direccion=address.getAddressLine(0);
			
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
    
	
}
