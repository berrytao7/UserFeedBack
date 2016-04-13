package com.jui.feedback.net;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.content.Context;
import android.util.Log;

public abstract class AsyncHttpSession implements Runnable
{
    public final String mUrl;
    protected int mHasRetry = 0;

    private HttpClient mHttpClient = null;
    protected HttpResponse mResponse = null;
    private final String Tag = "AsyncHttpSession";
    protected Context mContext;
    protected HttpSessionCallBack mCallBack = null;

    protected AsyncHttpSession( String url )
    {
	mUrl = url;

    }

    protected AsyncHttpSession( String url , Context context )
    {
	mUrl = url;
	mContext = context;

    }

    protected abstract void doRun();

    public void registerCallBack( HttpSessionCallBack httpSessionCallBack )
    {
	mCallBack = httpSessionCallBack;
    }

    public void unregisterCallBack()
    {
	mCallBack = null;
    }

    protected void shutDown()
    {
	if( mHttpClient != null )
	{
	    mHttpClient.getConnectionManager( ).shutdown( );
	    mHttpClient = null;
	}
	mResponse = null;
    }

    public HttpClient getHttpClient()
    {
	if( mHttpClient == null )
	{
	    HttpParams params = new BasicHttpParams( );
	    HttpConnectionParams.setConnectionTimeout( params , HttpSessionConstant.CONNECTION_TIMEOUT );
	    HttpConnectionParams.setSoTimeout( params , HttpSessionConstant.SO_TIMEOUT );
	    HttpConnectionParams.setSocketBufferSize( params , HttpSessionConstant.SOCKET_BUFFER_SIZE );

	    HttpClientParams.setRedirecting( params , true );

	    mHttpClient = new DefaultHttpClient( params );
	    mHttpClient.getParams( ).setParameter( "http.useragent" , HttpSessionConstant.getUserAgent( ) );

	    boolean useProxy = APNUtil.hasProxy( );
	    if( useProxy )
	    {

		Log.d( Tag , "need getApnProxy = " + APNUtil.getApnProxy( ) );
		Log.d( Tag , "need getApnPortInt = " + APNUtil.getApnPortInt( ) );

		HttpHost proxy = new HttpHost( APNUtil.getApnProxy( ) , APNUtil.getApnPortInt( ) );
		mHttpClient.getParams( ).setParameter( ConnRoutePNames.DEFAULT_PROXY , proxy );
	    }
	}

	return mHttpClient;
    }

    @Override
    public void run()
    {

	if( APNUtil.isNetworkAvailable( ) == false )
	{
	    if( mCallBack != null )
		mCallBack.onError( HttpSessionConstant.ERROR_CODE.ERR_NETWORK_DISABLE , "ahs net work error" );
	}
	else
	{
	    doRun( );
	}
    }

    public void exec()
    {

	doRun( );
    }
}
