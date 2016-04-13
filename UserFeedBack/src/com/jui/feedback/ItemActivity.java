package com.jui.feedback;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pada.widget.actionbar.PadaHeaderBar;
import pada.widget.actionbar.PadaHeaderBar.OnHeaderBarClickListener;
import pada.widget.dialog.PadaAlertDialog;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jui.feedback.adapter.ItemGridAdapter;
import com.jui.feedback.bean.DeviceInfo;
import com.jui.feedback.net.APNUtil;
import com.jui.feedback.photo.Bimp;
import com.jui.feedback.photo.FileUtil;
import com.jui.feedback.photo.ImageHelper;

public class ItemActivity extends Activity
{
    ArrayList< String > types;
    MyHandler handler = new MyHandler( this );
    TextView typeView;
    EditText despView , emailView;
    GridView feedbackGrid;
    ItemGridAdapter adapter;
    Toast mToast;
    TextView mToastView;
    PadaHeaderBar padaHeaderBar;

    int type = 0;// 类型
    String desc = null;// 问题描述
    String mNumber = Build.MODEL;// 设备型号
    String info = null;// 联系人邮箱

    boolean isUpdate = false;
    
    private RetainedFragment dataFragment;  
    private MyAsyncTask mMyTask; 
    public static boolean showDialog = false;

     static class MyHandler extends Handler
    {
	WeakReference< ItemActivity > mActivity;

	MyHandler( ItemActivity activity )
	{
	    mActivity = new WeakReference< ItemActivity >( activity );
	}

	@SuppressLint( "NewApi" )
	@Override
	public void handleMessage( Message msg )
	{
	    ItemActivity theActivity = mActivity.get( );
	    switch ( msg.what )
	    {
		case 0 :
		    theActivity.showToast( theActivity.getResources( ).getString( R.string.network_not_available_label ) , false );
		    break;
		case 1 :
		    theActivity.showToast( theActivity.getResources( ).getString( R.string.desp_null_label ) , false );
		    break;
		case 2 :// 部分图片上传失败		
		    int count = msg.arg2;
		    String str = theActivity.getString( R.string.upload_img_fail );
		    theActivity.showToast( String.format( str , count ) , false );

		    break;
		case 3 :// 提交失败			
		    theActivity.showToast( theActivity.getResources( ).getString( R.string.commit_fail_label ) , false );

		    break;
		case 4 :// 提交成功	
		    
		    theActivity.showToast( theActivity.getResources( ).getString( R.string.commit_success_label ) , true );
		    theActivity.finishActivity( );
		    if (!theActivity.isDestroyed()) {
				theActivity.finish();
			}
		    break;
		case 5 :
		    theActivity.showToast( theActivity.getResources( ).getString( R.string.email_format_error ) , false );
		    break;
		

	    }
	}
    };
    
    
    final OnHeaderBarClickListener headerBarClickListener = new OnHeaderBarClickListener() {
		
		@Override
		public void onHeaderBarClicked(int position) {
			switch (position) {
			case OnHeaderBarClickListener.LEFT_HANDLE_BNT:
				showExitDialog( );
				break;

			case OnHeaderBarClickListener.RIGHT_HANDLE_BNT:
				commit( );
				break;
			}
			
		}
	};
    
          

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
	super.onCreate( savedInstanceState );
	setContentView( R.layout.activity_item );
	
	changeStatusBarColor();

	DeviceInfo.setDeviceInfo( ItemActivity.this );
	APNUtil.setContext( ItemActivity.this );
	
	
	initData( );

	initViews( );
	
	
	// find the retained fragment on activity restarts  
    FragmentManager fm = getFragmentManager();  
    dataFragment = (RetainedFragment) fm.findFragmentByTag("data");  

    // create the fragment and data the first time  
    if (dataFragment == null)  
    {  
        // add the fragment  
        dataFragment = new RetainedFragment();  
        fm.beginTransaction().add(dataFragment, "data").commit();  
    }  
    mMyTask = dataFragment.getData();  
    if (mMyTask != null)  
    {  
        mMyTask.setActivity(this);  
    } else  
    {  
        mMyTask = new MyAsyncTask(this);  
        dataFragment.setData(mMyTask);  
    }  
	

    }
    
   
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	mMyTask.setActivity(null);
    }

    @Override
    protected void onResume() {
    	super.onResume();    	
    	    		
    	if (!isUpdate) {
    		adapter.notifyDataSetChanged( );
		}    	
    }
    @Override
    protected void onPause() {
    	super.onPause();
    	isUpdate = false;
    	
    }
    
        
    @Override
    protected void onRestart()
    {
	super.onRestart( );
	
	adapter.notifyDataSetChanged( );
	isUpdate = true;
	
    }
    
  
    @Override
    public void onBackPressed()
    {
	showExitDialog( );
	//		super.onBackPressed();
    }
    
       

    // 退出activity时清空数组
    private void finishActivity()
    {
    	    
	new Handler( ).post( new Runnable( )
	{

	    @Override
	    public void run()
	    {
		types.clear( );
		Bimp.tmpPaths.clear( );
		Bimp.max = 0;
		FileUtil.deleteDir( );
		if( ImageHelper.list != null )
		{
		    ImageHelper.list.clear( );
		    ImageHelper.list = null;
		}
	    }
	} );
	
	ItemActivity.this.finish( );
    }

    private void commit()
    {
	desc = despView.getText( ).toString( );
	info = emailView.getText( ).toString( );
	if( APNUtil.isNetworkEnable( ) )
	{
	    if( desc != null && desc.trim( ).length( ) > 0 )
	    {
		if( isEmail( info ) )
		{					mMyTask = new MyAsyncTask(this);  
		        dataFragment.setData(mMyTask);  
		        mMyTask.setData(type, desc, mNumber, info);
		        mMyTask.execute();
			
		}
		else
		{//邮箱格式不正确
		    handler.sendEmptyMessage( 5 );
		}

	    }
	    else
	    {// 问题描述不能为空
		handler.sendEmptyMessage( 1 );
	    }
	}
	else
	{// 网络不可用
	    handler.sendEmptyMessage( 0 );
	}
    }

    private void showToast( String msg , boolean isCommit )
    {
	if( mToast == null )
	{
	    mToast = new Toast( this );
	    View view = LayoutInflater.from( this ).inflate( R.layout.layout_toast , null );
	    mToastView = (TextView)view.findViewById( R.id.toast_msg );
	    mToastView.setText( msg );
	    mToast.setView( view );
	}
	else
	{
	    mToastView.setText( msg );
	}

	if( isCommit )
	{
	    int marginButtom = (int)getResources( ).getDimension( R.dimen.toast_buttom_margin );
	    //1024*600  横屏时toast距底部距离为30dip
	    DisplayMetrics dm = new DisplayMetrics( );
	    getWindowManager( ).getDefaultDisplay( ).getMetrics( dm );
	    int screenHeight = dm.heightPixels;// screen height == 600
	    if( screenHeight == 552 )
	    {
		marginButtom = 30;
	    }
	    mToast.setGravity( Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM , 0 , marginButtom );
	}
	else
	{
	    mToast.setGravity( Gravity.CENTER , 0 , 0 );
	}
	mToast.setDuration( Toast.LENGTH_LONG );
	mToast.show( );
    }

    private void initData()
    {
	Bundle bundle = getIntent( ).getExtras( );
	int postion = bundle.getInt( "type" );
	type = postion + 1;

	types = new ArrayList< String >( );
	types.add( getResources( ).getString( R.string.txt1 ) );
	types.add( getResources( ).getString( R.string.txt2 ) );
	types.add( getResources( ).getString( R.string.txt3 ) );
	types.add( getResources( ).getString( R.string.txt4 ) );
	types.add( getResources( ).getString( R.string.txt5 ) );
	types.add( getResources( ).getString( R.string.txt6 ) );
	types.add( getResources( ).getString( R.string.txt7 ) );
	types.add( getResources( ).getString( R.string.txt8 ) );
	types.add( getResources( ).getString( R.string.txt9 ) );


    }

    private void initViews()
    {

    padaHeaderBar = (PadaHeaderBar) findViewById(R.id.padaheaderbar);
	typeView = (TextView)findViewById( R.id.item_type );
	despView = (EditText)findViewById( R.id.item_desp );
	emailView = (EditText)findViewById( R.id.item_eamil );
	feedbackGrid = (GridView)findViewById( R.id.feedbackgrid );

	typeView.setText( types.get( type - 1 ) );
	adapter = new ItemGridAdapter( this );
	feedbackGrid.setAdapter( adapter );
	
	padaHeaderBar.setOnHeaderBarClickListener(headerBarClickListener);

    }

    //判断退出时是否显示提示对话框,全部为null
    private boolean isShowExit()
    {

	desc = despView.getText( ).toString( );
	info = emailView.getText( ).toString( );

	boolean imageIsEmpty = ( Bimp.paths == null || Bimp.paths.size( ) < 1 );
	if( !desc.isEmpty( ) || !info.isEmpty( ) || !imageIsEmpty )
	{
	    return true;
	}
	return false;
    }

    //显示退出对话框
    private void showExitDialog()
    {
	if( !isShowExit( ) )
	{
	    Intent intent = new Intent( );
	    intent.setClass( ItemActivity.this , MainActivity.class );
	    startActivity( intent );
	    finishActivity( );
	}
	else
	{
	    final PadaAlertDialog alertDialog = new PadaAlertDialog( ItemActivity.this , getResources( ).getString( R.string.dialog_msg ) , false );
	    alertDialog.setmLeftBtnTitle(getResources().getString(R.string.no_label));
	    alertDialog.setmRightBtnTitle(getResources().getString(R.string.yes_label));
	    alertDialog.addLeftBtnListener( new OnClickListener( )
	    {

		@Override
		public void onClick( View v )
		{
		    alertDialog.dismiss( );
		    Intent intent = new Intent( );
		    intent.setClass( ItemActivity.this , MainActivity.class );
		    startActivity( intent );
		    finishActivity( );

		}
	    } );
	    alertDialog.addRightBtnListener( new OnClickListener( )
	    {

		@Override
		public void onClick( View v )
		{
		    alertDialog.dismiss( );
		    commit( );
		}
	    } );
	    alertDialog.show( );
	}
    }

    //判断email格式是否正确 ，邮箱可以为空
    public boolean isEmail( String email )
    {
	if( email == null || "".endsWith( email.trim( ).toString( ) ) )
	{
	    return true;
	}
	String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	Pattern p = Pattern.compile( str );
	Matcher m = p.matcher( email );
	return m.matches( );
    }

       
    //回调 线程处理完成
    public void onTaskCompleted(int call,int fail){
    	switch (call) {
		case 1://信息提交成功
			handler.sendEmptyMessage(4);
			break;
		case 2://信息提交失败
			handler.sendEmptyMessage(3);
			break;
		case 3://图片上传失败
			 Message msg = handler.obtainMessage( );
			    msg.arg2 = fail;
			    msg.what = 2;
			    msg.sendToTarget( );
			break;
		}
    }

    
    @SuppressLint("InlinedApi")
	private void changeStatusBarColor()
    {
	boolean statusBarColorChange = false;
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
