package com.jui.feedback.protocol;

import java.util.concurrent.atomic.AtomicInteger;

import android.content.Context;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.jui.feedback.bean.DeviceInfo;
import com.jui.feedback.net.AsyncHttpPostSession;
import com.jui.feedback.net.AsyncHttpSession;
import com.jui.feedback.net.HttpSessionCallBack;
import com.jui.feedback.protocol.Packet.MaskCode;
import com.jui.feedback.protocol.Packet.ReqPacket;
import com.jui.feedback.protocol.Packet.RspPacket;

public abstract class AbstractNetController
{

    protected Context mContext;

    private AsyncHttpPostSession mSession;
    private static AtomicInteger mRequestSeq = new AtomicInteger( 0 );

    public static final class ACTION
    {
	public static String ACTION_FEEDBACK_REQUEST = "ReqFeedback";
	public static String ACTION_FEEDBACK_RESPONSE = "RspFeedback";
    }

    /**
     * 子类实现，返回请求的业务包体
     * 
     * @return ByteString
     */
    protected abstract ByteString getRequestBody();

    /**
     * 子类实现，返回请求的Mask设置
     * 
     * @return
     */
    protected abstract int getRequestMask();

    /**
     * 子类实现，返回请求的action设置
     * 
     * @return
     */
    protected abstract String getRequestAction();

    /**
     * 子类实现，返回回复包的action设置
     * 
     * @return
     */
    protected abstract String getResponseAction();

    /**
     * 子类实现，处理返回的业务数据与业务本身的逻辑错误
     * 
     * @param byteString
     */
    protected abstract void handleResponseBody( ByteString byteString );

    /**
     * 子类实现，处理返回的网络与包数据相关的错误
     * 
     * @param errCode
     * @param strErr
     */
    protected abstract void handleResponseError( int errCode , String strErr );

    /**
     * 
     * @return 对应请求的服务器地址
     */
    protected abstract String getServerUrl();

    protected AbstractNetController()
    {}

    public AsyncHttpSession getSession()
    {
	return mSession;
    }

    public void doRequest()
    {
	mSession = new AsyncHttpPostSession( getServerUrl( ) );
	mSession.registerCallBack( mHttpSessionCallBack );
	mSession.doPost( makePacket( ) );
    }

    private String getDeviceInfo()
    {
	return DeviceInfo.getDeviceInfo( );
    }

    private byte [] makePacket()
    {
	// 包头

	ReqPacket.Builder builder = ReqPacket.newBuilder( );
	builder.setMask( getRequestMask( ) );
	builder.setUdi( getDeviceInfo( ) );
	builder.addAction( getRequestAction( ) );
	builder.addParams( preHandleRequestBody( getRequestBody( ) ) );
	builder.setReqNo( getRequestSequence( ) );
	builder.setClientId( 12 ); // client id 12

	return builder.build( ).toByteArray( );
    }

    /*
     * 预处理请求包
     */
    private ByteString preHandleRequestBody( ByteString body )
    {
	ByteString handleBody = body;

	if( ( getRequestMask( ) | 0xFF ) == MaskCode.PARAMS_RSA_VALUE )
	{
	    // TODO encrypt body
	    handleBody = body;
	}

	if( ( getRequestMask( ) | 0xFF ) == MaskCode.PARAMS_GZIP_VALUE )
	{
	    // TODO zip compress
	    handleBody = body;
	}
	return handleBody;
    }

    /*
     * 预处理返回包
     */
    private ByteString preHandleResponseBody( ByteString body , int mask )
    {
	ByteString handleBody = body;

	if( ( mask | 0xFF ) == MaskCode.PARAMS_RSA_VALUE )
	{

	}

	if( ( mask | 0xFF ) == MaskCode.PARAMS_GZIP_VALUE )
	{

	}

	return handleBody;
    }

    /*
     * private String getServerUrl() { return ServerUrl.SERVER_URL; }
     */
    private int getRequestSequence()
    {
	return mRequestSeq.getAndIncrement( );

    }

    private final HttpSessionCallBack mHttpSessionCallBack = new HttpSessionCallBack( )
    {

	@Override
	public void onSucceed( byte [] rspData )
	{
	    try
	    {
		RspPacket resPacket = RspPacket.parseFrom( rspData );
		int resCode = resPacket.getRescode( );

		if( resCode == 0 )
		{
		    String action = resPacket.getAction( 0 );
		    if( action.equals( getResponseAction( ) ) )
		    {

			handleResponseBody( preHandleResponseBody( resPacket.getParams( 0 ) , resPacket.getMask( ) ) );

		    }
		    else
		    {

			// 包的action不匹配，在调试过程中可能会出现
			handleResponseError( ERROR.ERROR_ACTION_MISMATCH , "Action from server is misMatch, reqAction:" + getRequestAction( ) + ",resAction:" + action );
		    }
		}
		else
		{
		    String msg = resPacket.getResmsg( );
		    handleResponseError( ERROR.ERROR_ACTION_FAIL , msg );
		}

	    }
	    catch ( InvalidProtocolBufferException e )
	    {

		e.printStackTrace( );
		handleResponseError( ERROR.ERROR_BAD_PACKET , e.getMessage( ) );
	    }
	}

	@Override
	public void onError( int errCode , String strErr )
	{
	    handleResponseError( errCode , strErr );
	}
    };

    public static final class ERROR
    {
	public static int ERROR_ACTION_MISMATCH = 0x1000;
	public static int ERROR_BAD_PACKET = 0x1001;
	public static int ERROR_ACTION_FAIL = 0x1002;
    }

}
