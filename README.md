Backbeam-pushnotifications-android-phonegap-plugin
==================================================

Phonegap 3.0 Plugin for Android 4.x for projects with Backbeam SDK to achieve subscribing to a push notifications channel of backbeam

==================================================

Usage
=====

The first thing is to set your phonegap project to allow internet access to the SDK Backbeam add and configure your Android project using the same settings you're using in the javascript development.

Backbeam:

You can find the setup instructions of backbeam in: 

javascript: http://backbeam.io/documentation-javascript

Android: http://backbeam.io/documentation-android

You must include the backbeam setup and push notifications methods in method: public void onStart()
	
Phonegap:

In your Phonegap project:
	/platforms/android/AndroidManifest.xml must be a similar configuration:
		
	<?xml version='1.0' encoding='utf-8'?>
	<manifest android:versionCode="1" android:versionName="1.0.0"  package="com.example.hello" xmlns:android="http://schemas.android.com/apk/res/android"><!--Your package name-->
	    <uses-sdk android:minSdkVersion="10" android:targetSdkVersion="18" />
	    <supports-screens android:anyDensity="true" android:largeScreens="true" android:normalScreens="true" android:resizeable="true" android:smallScreens="true" android:xlargeScreens="true" />
	    <uses-permission android:name="android.permission.INTERNET" />
	    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
		<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	    <uses-permission android:name="android.permission.GET_ACCOUNTS" />
	    <uses-permission android:name="android.permission.WAKE_LOCK" />
	    <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
	    <permission android:name="com.example.hello.permission.C2D_MESSAGE"
	        android:protectionLevel="signature" /><!--Your package name-->
	    <uses-permission android:name="com.example.hello.permission.C2D_MESSAGE" /><!--Your package name-->
	    
	    <application android:allowBackup="true" android:icon="@drawable/icon" android:label="@string/app_name">
	        <activity android:configChanges="orientation|keyboardHidden|keyboard|screenSize|locale" android:label="@string/app_name" android:name="Hello" android:theme="@android:style/Theme.Black.NoTitleBar"> <!--android:name="<Your project>"-->
	            <intent-filter>
	                <action android:name="android.intent.action.MAIN" />
	                <category android:name="android.intent.category.LAUNCHER" />
	            </intent-filter>
	        </activity>
	        <receiver
	            android:name="io.backbeam.GCMBroadcastReceiver" android:exported="true"
	            android:permission="com.google.android.c2dm.permission.SEND" >
	            <intent-filter>
	                <action android:name="com.google.android.c2dm.intent.RECEIVE" />
	                <action android:name="com.google.android.c2dm.intent.REGISTRATION" />
	                <category android:name="com.example.hello" /> //<!--Your package name-->
	            </intent-filter>
	        </receiver>
	        <service android:name="io.backbeam.GCMIntentService" />
	    </application>
	</manifest>
