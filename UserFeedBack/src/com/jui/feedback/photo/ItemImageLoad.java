package com.jui.feedback.photo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;

import com.jui.feedback.PhotoActivity;

public class ItemImageLoad {

	public Handler h = new Handler( );
    private static final int MAX_CAPACITY = 4;
    private static final long DELAY_BEFORE_PURGE = 10 * 1000;

    private HashMap< String , Bitmap > mFirstLevelCache = new LinkedHashMap< String , Bitmap >( MAX_CAPACITY / 2 , 0.75f , true )
    {
	private static final long serialVersionUID = 1L;

	protected boolean removeEldestEntry( Entry< String , Bitmap > eldest )
	{
	    if( size( ) > MAX_CAPACITY )
	    {
		mSecondLevelCache.put( eldest.getKey( ) , new SoftReference< Bitmap >( eldest.getValue( ) ) );
		return true;
	    }
	    return false;
	};
    };
    private ConcurrentHashMap< String , SoftReference< Bitmap >> mSecondLevelCache = new ConcurrentHashMap< String , SoftReference< Bitmap >>( MAX_CAPACITY / 2 );

    private Runnable mClearCache = new Runnable( )
    {
	@Override
	public void run()
	{
	    clear( );
	}
    };
    private Handler mPurgeHandler = new Handler( );

    private void resetPurgeTimer()
    {
	mPurgeHandler.removeCallbacks( mClearCache );
	mPurgeHandler.postDelayed( mClearCache , DELAY_BEFORE_PURGE );
    }

    public void clear()
    {
	mFirstLevelCache.clear( );
	mSecondLevelCache.clear( );
    }

    public Bitmap getBitmapFromCache( String url )
    {
	Bitmap bitmap = null;
	bitmap = getFromFirstLevelCache( url );
	if( bitmap != null )
	{
	    return bitmap;
	}
	bitmap = getFromSecondLevelCache( url );
	return bitmap;
    }

    private Bitmap getFromSecondLevelCache( String url )
    {
	Bitmap bitmap = null;
	SoftReference< Bitmap > softReference = mSecondLevelCache.get( url );
	if( softReference != null )
	{
	    bitmap = softReference.get( );
	    if( bitmap == null )
	    {
		mSecondLevelCache.remove( url );
	    }
	}
	return bitmap;
    }

    private Bitmap getFromFirstLevelCache( String url )
    {
	Bitmap bitmap = null;
	synchronized ( mFirstLevelCache )
	{
	    bitmap = mFirstLevelCache.get( url );
	    if( bitmap != null )
	    {
		mFirstLevelCache.remove( url );
		mFirstLevelCache.put( url , bitmap );
	    }
	}
	return bitmap;
    }

    public void addImage2Cache( String url , Bitmap value )
    {
	if( value == null || url == null )
	{
	    return;
	}
	synchronized ( mFirstLevelCache )
	{
	    mFirstLevelCache.put( url , value );
	}
    }

    public Bitmap getImage(String path )
    {
	if( TextUtils.isEmpty( path ) )
	{
	    return null;
	}

	resetPurgeTimer( );
	Bitmap bitmap = getBitmapFromCache( path );
	if( bitmap == null )
	{//缓存中没有

		Bitmap newBitmap = null;
		try {
			newBitmap = revitionImageSize(path);
		} catch (IOException e) {
			e.printStackTrace();
			newBitmap = null;
		}
		
		if (newBitmap==null) {
			newBitmap = PhotoActivity.bimap;			
		}
		addImage2Cache(path, newBitmap);   
		return newBitmap;

	}
	else
	{
	   return bitmap;
	}

    }

    public Bitmap revitionImageSize( String path ) throws IOException
    {
	BufferedInputStream in = new BufferedInputStream( new FileInputStream( new File( path ) ) );
	BitmapFactory.Options options = new BitmapFactory.Options( );
	options.inJustDecodeBounds = true;
	BitmapFactory.decodeStream( in , null , options );
	in.close( );
	int i = 0;
	Bitmap bitmap = null;
	while ( true )
	{
	    if( ( options.outWidth >> i <= 256 ) && ( options.outHeight >> i <= 256 ) )
	    {
		in = new BufferedInputStream( new FileInputStream( new File( path ) ) );
		options.inSampleSize = (int)Math.pow( 2.0D , i );
		options.inJustDecodeBounds = false;
		bitmap = BitmapFactory.decodeStream( in , null , options );
		break;
	    }
	    i += 1;
	}
	return bitmap;
    }
   
}
