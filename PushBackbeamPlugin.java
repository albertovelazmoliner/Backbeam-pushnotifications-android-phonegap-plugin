package com.bearaventure.weplai;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.backbeam.*;

public class PushBackbeamPlugin extends CordovaPlugin {
	public static final String ACTION_SUSCRIBE_TO_CHANEL = "subscribeDeviceToChannelsBackbeam";
	public static final String ACTION_UNSUSCRIBE_FROM_CHANEL = "unsubscribeDeviceFromChannelsBackbeam";
	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		try {
			if (ACTION_SUSCRIBE_TO_CHANEL.equals(action)) {
				JSONObject message = args.getJSONObject(0);
				String chanelUser = message.optString("chanel");
				final String chanel_user = "user_"+chanelUser;
				System.out.println("Este es el chanel_user: "+chanel_user);
				cordova.getThreadPool().execute(new Runnable() {
					public void run(){
						
						Backbeam.subscribeToChannels(new OperationCallback() {
							public void success() {
								System.out.println("successfully subscribed");
							}
							public void failure(BackbeamException exception) {
								System.out.println("subscription failure "+exception);
							}
						}, chanel_user);
					 
						callbackContext.success();
					}
				});
				return true;
			} else if(ACTION_UNSUSCRIBE_FROM_CHANEL.equals(action)){
				JSONObject message = args.getJSONObject(0);
				String chanelUser = message.optString("chanel");
				final String chanel_user = "user_"+chanelUser;
				cordova.getThreadPool().execute(new Runnable() {
					public void run(){
						
						Backbeam.unsubscribeFromChannels(new OperationCallback() {
							public void success() {
								System.out.println("successfully unsubscribed");
							}
							public void failure(BackbeamException exception) {
								System.out.println("unsubscription failure "+exception);
							}
						}, chanel_user);
					 
						callbackContext.success();
					}
				});
				return true;
			}
			callbackContext.error("Invalid action");
			return false;
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		} 
	}
}
