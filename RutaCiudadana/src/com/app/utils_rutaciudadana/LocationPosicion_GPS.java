/*clase contenedora de latitud y longitud utilizada en la clase implemetadora de esta.*/

package com.app.utils_rutaciudadana;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;


public class LocationPosicion_GPS implements LocationListener{
	public static double latitud;
	public static double longitud;
	public static boolean statusGPS;
	public static Location coordenadas;
	
	
	@Override
	public void onLocationChanged(Location location) {
		location.getLatitude();
		location.getLongitude();
		latitud=location.getLatitude();
		longitud=location.getLongitude();
		coordenadas=location;
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		statusGPS=false;
	}

	@Override
	public void onProviderEnabled(String provider) {
		statusGPS=true;
	}

	@Override
	public void onProviderDisabled(String provider) {}

}
