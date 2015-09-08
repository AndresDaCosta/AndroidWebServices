package com.example.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

public class GestorDeCon2 extends AsyncTask<Void,Void, String>{
	private String Url = new String ("http://172.16.0.62:8191/webAndroid/MyServlet");
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		String respuesta = null;
		try {
			
			URL url = new URL(Url);
			
			HttpURLConnection bo = (HttpURLConnection) url.openConnection();
			bo.setDoOutput(true);
			bo.setRequestMethod("POST");
			bo.setRequestProperty("Content-type", "text/plain;charset=UTF-8");
			if(bo.getResponseCode() == 200){
			
				BufferedReader in = new BufferedReader
						(new InputStreamReader(bo.getInputStream()));
				
				 respuesta = in.readLine();
				in.close();
			bo.disconnect();
				
				
			}else{
				
			}
			
			
			
		} catch (MalformedURLException e) {
			
			Log.e("GestorDeCon",e.getMessage());
			e.printStackTrace();
			
		} catch (IOException e) {
			Log.e("GestorDeCon",e.getMessage());
			e.printStackTrace();
		}
		return respuesta;
	}
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}

}
