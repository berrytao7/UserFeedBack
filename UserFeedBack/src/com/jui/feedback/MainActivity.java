package com.jui.feedback;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pada.widget.actionbar.PadaHeaderBar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.jui.feedback.adapter.MainGridAdapter;

public class MainActivity extends Activity
{

    GridView gridView;
    PadaHeaderBar padaHeaderBar;
    MainGridAdapter adapter;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
	super.onCreate( savedInstanceState );
	setContentView( R.layout.activity_main );
	changeStatusBarColor();
	initViews( );

    }

    @Override
    public void onBackPressed()
    {
	super.onBackPressed( );
	finishActivity( );
    }

    @Override
    protected void onDestroy()
    {
	super.onDestroy( );
	//这里调用finishActivity切屏会闪退
	//		finishActivity();
    }

    //activity结束之前
    private void finishActivity()
    {
	adapter = null;
	gridView = null;
	MainActivity.this.finish( );
    }

    private void initViews()
    {
    padaHeaderBar = (PadaHeaderBar) findViewById(R.id.padaheaderbar);
	gridView = (GridView)findViewById( R.id.gridview );
	adapter = new MainGridAdapter( MainActivity.this );
	gridView.setAdapter( adapter );
	
	padaHeaderBar.setmRightHandleBtnVisibility(View.GONE);
	padaHeaderBar.setmLeftHandleBtnVisibility(View.GONE);

	gridView.setOnItemClickListener( new OnItemClickListener( )
	{

	    @Override
	    public void onItemClick( AdapterView< ? > parent , View view , int position , long id )
	    {
		Intent intent = new Intent( );
		intent.setClass( MainActivity.this , ItemActivity.class );
		Bundle bundle = new Bundle( );
		bundle.putInt( "type" , position );
		intent.putExtras( bundle );
		intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
		startActivity( intent );
		finishActivity( );

	    }
	} );

    }
    
    @SuppressLint("InlinedApi")
	private void changeStatusBarColor()
    {
	boolean statusBarColorChange = false;
	// TODO: change statusBarColor to modify the statusbar theme
	// example 0x00100001 -> statusbar white theme
	// example 0x00e0e0e0 -> statusbar black theme
	int statusBarColor = 0x00ffffff;

	if( android.os.Build.VERSION.SDK_INT >= 19 )
	{
	    Object [] args = { statusBarColor };
	    statusBarColorChange = invokeMethod( (Object)getWindow( ) , "setStatusBarColor" , args );
	    if( statusBarColorChange )
	    {
		getWindow( ).setFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS , WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
	    }
	}

	//Log.v("dbg", "statusBarColorChange:" + statusBarColorChange);
	if( statusBarColorChange )
	{
	    //TODO: if statusBarColor transparent, expand margin_top 
	    LinearLayout.LayoutParams lay = new LinearLayout.LayoutParams( LayoutParams.MATCH_PARENT , getStatusBarHeight( ) );
	    LinearLayout statusBarHeader = (LinearLayout)this.findViewById( R.id.status_bar_header );
	    statusBarHeader.setLayoutParams( lay );
	    statusBarHeader.setVisibility( View.VISIBLE );
	}
	else
	{
	    //TODO:
	}
	//................
    }

    public int getStatusBarHeight()
    {
	Class< ? > c = null;
	Object obj = null;
	java.lang.reflect.Field field = null;
	int x = 0;
	int statusBarHeight = 0;
	try
	{
	    c = Class.forName( "com.android.internal.R$dimen" );
	    obj = c.newInstance( );
	    field = c.getField( "status_bar_height" );
	    x = Integer.parseInt( field.get( obj ).toString( ) );
	    statusBarHeight = getResources( ).getDimensionPixelSize( x );
	    return statusBarHeight;
	}
	catch ( Exception e )
	{
	    e.printStackTrace( );
	}
	return statusBarHeight;
    }

    private static boolean invokeMethod( Object owner , String methodName , Object [] args )
    {
	Class< ? > ownerClass = owner.getClass( );
	@SuppressWarnings( "rawtypes" )
	Class [] methodArgs = new Class [args.length];
	int i = 0;
	for( Object obj : args )
	{
	    if( obj instanceof Integer )
	    {
		methodArgs[i] = int.class;
	    }
	    else
	    {
		methodArgs[i] = args[i].getClass( );
	    }
	    i++;
	}

	Method method;
	try
	{
	    method = ownerClass.getMethod( methodName , methodArgs );
	}
	catch ( NoSuchMethodException e )
	{
	    return false;
	}

	try
	{
	    method.invoke( owner , args );
	    return true;
	}
	catch ( IllegalArgumentException e )
	{
	    //e.printStackTrace();
	}
	catch ( IllegalAccessException e )
	{
	    //e.printStackTrace();
	}
	catch ( InvocationTargetException e )
	{
	    //e.printStackTrace();
	}

	return false;
    }

}
