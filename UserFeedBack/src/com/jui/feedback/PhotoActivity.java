package com.jui.feedback;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import pada.widget.actionbar.PadaHeaderBar;
import pada.widget.actionbar.PadaHeaderBar.OnHeaderBarClickListener;
import pada.widget.dialog.PadaLoadingDialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jui.feedback.adapter.PhotoGridAdapter;
import com.jui.feedback.photo.Bimp;
import com.jui.feedback.photo.FileUtil;
import com.jui.feedback.photo.ImageHelper;

/**
 * 本地图片列表
 * @author berrytao
 *
 */
public class PhotoActivity extends Activity
{
    GridView photoGrid;
    PadaHeaderBar padaHeaderBar;
    public static Bitmap bimap;
    public static int numColumns;
    public static int width;
    PhotoGridAdapter adapter;
    ImageHelper helper;
    boolean flag = false;
    
    final OnHeaderBarClickListener headerBarClickListener = new OnHeaderBarClickListener() {
		
		@Override
		public void onHeaderBarClicked(int position) {
			switch (position) {
			case OnHeaderBarClickListener.LEFT_HANDLE_BNT:
				finishActivity( );
				break;
			}
			
		}
	};
	
	
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
	super.onCreate( savedInstanceState );
	setContentView( R.layout.activity_photo );
	changeStatusBarColor();
	
	flag = true;
	DisplayMetrics dm = new DisplayMetrics( );
	getWindowManager( ).getDefaultDisplay( ).getMetrics( dm );
	int screenWidth = dm.widthPixels;// screen width px 
	//		int screenHeight = dm.heightPixels;// screen height px
	width = screenWidth;
	int orientation = getResources( ).getConfiguration( ).orientation;
	if( orientation == 2 )
	{//横屏
	    numColumns = 5;

	}
	else if( orientation == 1 )
	{//竖屏
	    numColumns = 4;
	}

	new MyTask( ).execute( "0" );
    }

    @Override
    public void onConfigurationChanged( Configuration newConfig )
    {
	super.onConfigurationChanged( newConfig );
	DisplayMetrics dm = new DisplayMetrics( );
	getWindowManager( ).getDefaultDisplay( ).getMetrics( dm );
	int screenWidth = dm.widthPixels;
	width = screenWidth;
	if( newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE )
	{// 横屏
	    numColumns = 5;
	    if( photoGrid == null )
	    {
		photoGrid = (GridView)findViewById( R.id.photogrid );
	    }
	    photoGrid.setNumColumns( numColumns );
	}
	else if( newConfig.orientation == Configuration.ORIENTATION_PORTRAIT )
	{//竖屏
	    numColumns = 4;
	    if( photoGrid == null )
	    {
		photoGrid = (GridView)findViewById( R.id.photogrid );
	    }
	    photoGrid.setNumColumns( numColumns );
	}
    }

    @Override
    public void onBackPressed()
    {
	super.onBackPressed( );
	finishActivity( );

    }

    private void finishActivity()
    {
    	finish();
	System.gc( );
    }

    @Override
    protected void onDestroy()
    {
	super.onDestroy( );
    }

    /**
     * 初始化view视图
     */
	private void initView() {
		padaHeaderBar = (PadaHeaderBar) findViewById(R.id.padaheaderbar);
		photoGrid = (GridView) findViewById(R.id.photogrid);
		photoGrid.setNumColumns(numColumns);
		adapter = new PhotoGridAdapter(PhotoActivity.this, ImageHelper.list);
		photoGrid.setAdapter(adapter);

		padaHeaderBar.setmRightHandleBtnVisibility(View.GONE);
		padaHeaderBar.setOnHeaderBarClickListener(headerBarClickListener);

	/*	photoGrid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				System.out.println("onItemClick,flag:" + flag);
				if (!flag) {// 解决点多次的问题
					finishActivity();
					return;

				}
				flag = false;

				// Bimp.max<4时可点击，否则不可点击，monkey测试时出现max大于4
				if (Bimp.tmpPaths.size() >= 3 || Bimp.max >= 3) {
					finishActivity();
					return;
				}

//				ImageView selected = (ImageView) view
//						.findViewById(R.id.isselected);

				String path = ImageHelper.list.get(position).imagePath;

//				selected.setImageResource(R.drawable.img_select_style);
				Bitmap bm = null;
				try {
					bm = Bimp.revitionImageSize(path);
				} catch (IOException e) {
					Log.i("berrytao", "图片压缩失败");
					bm = null;
					e.printStackTrace();
				}

				if (bm != null) {
					Bimp.tmpPaths.add(path);
					Bimp.max++;
					String newStr = path.substring(path.lastIndexOf("/") + 1,
							path.lastIndexOf("."));
					FileUtil.saveBitmap(bm, "" + newStr);

				}
				finishActivity();

			}

		});*/
	}

    class MyTask extends AsyncTask< String , String , String >
    {
    	PadaLoadingDialog dialog;

	@Override
	protected void onPreExecute()
	{
	    super.onPreExecute( );
	    dialog = new PadaLoadingDialog( PhotoActivity.this,getResources( ).getString( R.string.photo_loading ) );
	    dialog.show( );

	    helper = ImageHelper.newInstance( );

	}

	@Override
	protected String doInBackground( String ...params )
	{

	    helper.init( PhotoActivity.this );
	    if( bimap == null )
	    {
		bimap = BitmapFactory.decodeResource( getResources( ) , R.drawable.default_image );
	    }
	    return null;
	}

	@Override
	protected void onPostExecute( String result )
	{
	    super.onPostExecute( result );
	    initView( );
	    dialog.dismiss( );
	}
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
