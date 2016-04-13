package com.jui.feedback.bean;

import java.util.Locale;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;

public class DeviceInfo
{
    private static String udi;

    public static void setDeviceInfo( Context context )
    {
	getudi( context );
    }

    public static String getDeviceInfo()
    {
	return udi;
    }

    private static void getudi( Context context )
    {

	TelephonyManager tm = (TelephonyManager)context.getSystemService( Context.TELEPHONY_SERVICE );
	WifiManager wifi = (WifiManager)context.getSystemService( Context.WIFI_SERVICE );
	DisplayMetrics dm = context.getResources( ).getDisplayMetrics( );
	ConnectivityManager cm = (ConnectivityManager)context.getSystemService( Context.CONNECTIVITY_SERVICE );
	Locale locale = context.getResources( ).getConfiguration( ).locale;

	StringBuilder sbuilder = new StringBuilder( );
	String imei = tm.getDeviceId( );
	String imsi = tm.getSubscriberId( );
	sbuilder.append( "ei=" + ( imei == null ? "" : imei ) );

	if( !TextUtils.isEmpty( imsi ) )
	{
	    sbuilder.append( "&si=" + imsi );
	}
	String ai = Settings.Secure.getString( context.getContentResolver( ) , Settings.Secure.ANDROID_ID );
	if( !TextUtils.isEmpty( ai ) )
	{
	    sbuilder.append( "&ai=" + ai );
	}

	String wm = wifi.getConnectionInfo( ).getMacAddress( );
	if( !TextUtils.isEmpty( wm ) )
	{
	    sbuilder.append( "&wm=" + wm );
	}

	String mf = android.os.Build.MANUFACTURER;
	String bd = android.os.Build.BRAND;
	String md = android.os.Build.MODEL;
	int pl = android.os.Build.VERSION.SDK_INT;

	sbuilder.append( "&mf=" + mf );
	sbuilder.append( "&bd=" + bd );
	sbuilder.append( "&md=" + md );
	sbuilder.append( "&pl=" + pl );

	sbuilder.append( "&sw=" + dm.widthPixels );
	sbuilder.append( "&sh=" + dm.heightPixels );

	NetworkInfo ni = cm.getActiveNetworkInfo( );
	if( ni != null )
	{
	    sbuilder.append( "&nt=" + cm.getActiveNetworkInfo( ).getType( ) );
	}

	String la = locale.getLanguage( ) + "-" + locale.getCountry( );
	sbuilder.append( "&la=" + la );

	udi = sbuilder.toString( );

    }
}
