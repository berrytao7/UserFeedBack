package com.jui.feedback;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kobjects.base64.Base64;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.jui.feedback.bean.RspBean;
import com.jui.feedback.net.ServerUrl;
import com.jui.feedback.photo.Bimp;
import com.jui.feedback.protocol.FeedbackController;

import pada.widget.dialog.PadaLoadingDialog;
import android.os.AsyncTask;
import android.util.Log;

/**
 * 提交信息线程
 * @author berrytao
 *
 */
public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
	private ItemActivity activity;
	
	private PadaLoadingDialog dialog;
	//数据处理是否完成
	private boolean isCompleted= false;
	//数据处理完毕，1表示信息提交成功，2表示信息提交失败，3表示图片上传失败
	private int call = 0;
	private int failPics = 0;
	// 图片url
	private ArrayList< String > imgUrls;
	
	int mType; 
	String mDesc;
	String mNumber;
	String mInfo;
	
	
	public MyAsyncTask(ItemActivity iActivity){
		this.activity = iActivity;
	}
	
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		isCompleted = false;
		dialog = new PadaLoadingDialog(activity,activity.getResources().getString(R.string.dialog_msg3));
		dialog.setCancelable( false );
		dialog.show();
		failPics = 0;
		call = 0;
		imgUrls = new ArrayList<String>();
		ItemActivity.showDialog = true;
	}

	@Override
	protected Void doInBackground(Void... params) {
		List< String > paths = Bimp.paths;
		   synchronized (Bimp.paths) {
			   if( paths == null || paths.size( ) < 1 )
			    {//无照片上传,直接提交其他信息
				  failPics = 0;
			    }			    
			    else
			    {//有照片
				for( String path : paths )
				{

				    String name = path.substring( path.lastIndexOf( "/" ) + 1 );
				    try
				    {
					FileInputStream fis = new FileInputStream( path );
					ByteArrayOutputStream baos = new ByteArrayOutputStream( );
					byte [] buffer = new byte [1024];
					int count = 0;
					while ( ( count = fis.read( buffer ) ) >= 0 )
					{
					    baos.write( buffer , 0 , count );
					}
					String uploadBuffer = new String( Base64.encode( baos.toByteArray( ) ) ); // 进行Base64编码
					String imgUrl = connectWebService( name , uploadBuffer ); // 调用webservice
					if( imgUrl != null )
					{
					    imgUrls.add( imgUrl );
					}
					else
					{//图片上传失败
					    failPics++;
					}

					fis.close( );
				    }
				    catch ( FileNotFoundException e )
				    {
					Log.i( "berrytao--uploadImage" , "FileNotFoundException:" + e.getMessage( ) );
					failPics++;
				    }
				    catch ( IOException e )
				    {
					Log.i( "berrytao--uploadImage" , "IOException:" + e.getMessage( ) );
					failPics++;
				    }
				}				
				
			    }
			   
			   if (failPics!=0) {
				   call = 3;
				}
		   }
		return null;
	}
	
	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);		
		if (call==3) {
			isCompleted = true;
			ItemActivity.showDialog = false;
			System.out.println("=======task,call:"+call+",fail:"+failPics);
			if (dialog!=null) {
				dialog.dismiss();
			}
			notifyActivityTaskCompleted(call,failPics);
		}else {
			//提交其他信息	
			if (activity!=null) {
				System.out.println("=====before update,type:"+mType+",desc:"+mDesc+",num:"+mNumber);
				 FeedbackController fController = new FeedbackController( mType , mDesc , mNumber , imgUrls , mInfo , resultHandler );
				 fController.doRequest( );
			}else {
				System.out.println("===============activity == null");
			}
			 
		}
		
	}
	
	/**
	 * 保存点提交按钮时activity的数据
	 */
	
	public void setData(int type, String desc, String number, String info){
		this.mType = type;
		this.mDesc = desc;
		this.mNumber = number;
		this.mInfo = info;
	}
	
	/**
	 * 设置Activity，因为Activity会一直变化
	 * 
	 */
	
	public void setActivity(ItemActivity iActivity){
		 // 如果上一个Activity销毁，将与上一个Activity绑定的DialogFragment销毁
		if (iActivity==null) {
			if (dialog!=null) {
				dialog.dismiss();
			}
			
			return;
		}
		// 设置为当前的Activity
		this.activity = iActivity;
		// 开启一个与当前Activity绑定的等待框 
		System.out.println("=====setActivity,call:"+call);
		
		if (this.activity!=null && call==0 && ItemActivity.showDialog) {
			dialog = new PadaLoadingDialog(this.activity,this.activity.getResources().getString(R.string.dialog_msg3));
			dialog.setCancelable( false );
			dialog.show();
		}

	}
	
	private void notifyActivityTaskCompleted(int call,int fail)  
    {  
        if (null != activity)  
        {  
            activity.onTaskCompleted(call,fail);  
        }  
    }
	


    // 检测提交返回值
    FeedbackController.HandlResponse resultHandler = new FeedbackController.HandlResponse( )
    {

	@Override
	public void handleResponseBean( boolean hasError , RspBean bean )
	{
		ItemActivity.showDialog = false;
	    boolean isSuccess = hasError;
	    if( isSuccess )
	    {
	    	call = 1;
	    	System.out.println("======提交成功,call:"+call);
	    	isCompleted = true;
	    	if (dialog!=null) {
				dialog.dismiss();
			}
			notifyActivityTaskCompleted(call,0);
	    }
	    else
	    {
		RspBean rsp = bean;
		Log.i( "berrytao" , "提交失败," + "errorCode:" + rsp.getRetCode( ) + ",errorMsg:" + rsp.getRetMsg( ) );
		call = 2;
		System.out.println("======提交失败,call:"+call);
		isCompleted = true;
		if (dialog!=null) {
			dialog.dismiss();
		}
		notifyActivityTaskCompleted(call,0);
	    }

	}
    };
    
    
    /**
     * webService xml http://192.168.1.11/upload2/UploadFile.asmx?wsdl
     * Namespace="http://tempuri.org/" 调用方法：WriteFile * 参数： String
     * FileName,第一次上传为null String rawFileName，原文件名 base64Binary filestrem 文件流
     * int blockLes 剩余块数，分块值int maxLength = 100000，文件长度小于maxLength，则blockLes为1
     * 
     * 返回结果 String WriteFileResult 参数： 第一个固定为 0 第二个图片 url 第三个原始文件名的md5的hash值 例如：
     * 0,M00/01/2C/wKgBDVPYdLOEes5CAAAAAEQRG80524.jpg,1
     * A5F2CBAA14550BD76700F47873ACEB1
     * 
     */
    public String connectWebService( String filename , String filestrem )
    {
	String imgUrl = null;
	String namespace = "http://tempuri.org/";// 命名空间
	String methodName = "WriteFile";// 方法名
	String url = ServerUrl.getImageServerUrlCommit( );
	SoapObject requst = new SoapObject( namespace , methodName );
	requst.addProperty( "FileName" , null );
	requst.addProperty( "rawFileName" , filename );
	requst.addProperty( "filestrem" , filestrem );
	requst.addProperty( "blockLes" , 1 );

	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope( SoapEnvelope.VER12 );
	envelope.dotNet = true;// 设置是否调用的是dotNet开发的webService
	envelope.setOutputSoapObject( requst );

	HttpTransportSE hTransportSE = new HttpTransportSE( url , 30000 );
	try
	{
	    hTransportSE.call( null , envelope );
	}
	catch ( HttpResponseException e )
	{
	    Log.i( "berrytao--connectWebService" , "HttpResponseException:" + e.getMessage( ) );
	    return null;
	}
	catch ( IOException e )
	{
	    e.printStackTrace( );
	    Log.i( "berrytao--connectWebService" , "IOException:" + e.getMessage( ) );
	    return null;
	}
	catch ( XmlPullParserException e )
	{
	    Log.i( "berrytao--connectWebService" , "XmlPullParserException:" + e.getMessage( ) );
	    return null;
	}

	try
	{
	    // 返回数据
	    SoapObject response = (SoapObject)envelope.bodyIn;
	    String result = response.getProperty( "WriteFileResult" ).toString( );
	    if( result != null && result.length( ) > 1 )
	    {
		String [] strs = result.split( "," );
		imgUrl = strs[1];
		String md5 = strs[2];
		// 每张图片上传结束执行下面方法
		fininshUpload( imgUrl , md5 , filestrem.length( ) );
	    }

	}
	catch ( ClassCastException e )
	{
	    Log.i( "berrytao--connectWebService" , "ClassCastException:" + e.getMessage( ) + "|||response:" + envelope.bodyIn.toString( ) );
	}
	return imgUrl;

    }

    public void fininshUpload( String filename , String md5 , int len )
    {
	String namespace = "http://tempuri.org/";
	String methodName = "Finish";
	String url = ServerUrl.getImageServerUrlCommit( );
	SoapObject requst = new SoapObject( namespace , methodName );
	requst.addProperty( "fileName" , filename );
	requst.addProperty( "md5" , md5 );
	requst.addProperty( "appid" , 12 );
	requst.addProperty( "cid" , 12 );
	requst.addProperty( "len" , len );

	SoapSerializationEnvelope envelope = new SoapSerializationEnvelope( SoapEnvelope.VER12 );
	envelope.dotNet = true;
	envelope.setOutputSoapObject( requst );

	HttpTransportSE hTransportSE = new HttpTransportSE( url );
	try
	{
	    hTransportSE.call( null , envelope );
	}
	catch ( HttpResponseException e )
	{
	    e.printStackTrace( );
	}
	catch ( IOException e )
	{
	    e.printStackTrace( );
	}
	catch ( XmlPullParserException e )
	{
	    e.printStackTrace( );
	}
    }

}
