package com.jui.feedback.photo;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;

/**
 * 获取相册图片帮助类
 * @author berrytao
 *
 */
public class ImageHelper
{

    private static ImageHelper instance;
    public static List< ImageItem > list = null;

    Context mContext;
    ContentResolver resolver;

    private ImageHelper()
    {

    }

    public static ImageHelper newInstance()
    {
	if( instance == null )
	{
	    instance = new ImageHelper( );

	}
	return instance;
    }

    /**
     * 初始化
     */
    public void init( Context context )
    {
	if( mContext == null )
	{
	    this.mContext = context;
	    this.resolver = mContext.getContentResolver( );

	}
	if( list == null || list.size( ) < 1 )
	{
	    //费时操作
	    list = getAllImage( );
	}

    }

   /**
	 * 从数据库中得到原图地址,按拍照时间先后
	 * 
	 * @return
	 */
	public List<ImageItem> getAllImage() {
		String[] projection = { Media._ID, Media.DATA };
		Cursor cursor = resolver.query(Media.EXTERNAL_CONTENT_URI, projection,
				null, null, Media.DATE_TAKEN);
		List<ImageItem> mList = null;
		if (cursor != null) {
			cursor.moveToLast();
			mList = new ArrayList<ImageItem>();
			int idIndex = cursor.getColumnIndexOrThrow(Media._ID);
			int pathIdex = cursor.getColumnIndexOrThrow(Media.DATA);
			while (!cursor.isBeforeFirst()) {
				String id = cursor.getString(idIndex);
				String path = cursor.getString(pathIdex);
				mList.add(new ImageItem(id, path));
				cursor.moveToPrevious();
			}
			cursor.close();
		}

		return mList;
	}

}
