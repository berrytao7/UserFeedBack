package com.jui.feedback.protocol;

import java.util.ArrayList;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.jui.feedback.bean.RspBean;
import com.jui.feedback.net.ServerUrl;
import com.jui.feedback.protocol.Packet.MaskCode;

public class FeedbackController extends AbstractNetController
{

    private int feedbackType;//反馈类型
    private String description;//问题描述
    private String machineType; //设备型号
    private ArrayList< String > imageUrls; //反馈的图片在云存储上的url
    private String contactInfo; //邮箱
    HandlResponse mHandlResponse;//响应返回

    public static interface HandlResponse
    {
	public void handleResponseBean( boolean hasError , RspBean bean );
    }

    public FeedbackController( int mType , String desc , String mNumber , ArrayList< String > imgUrls , String info , HandlResponse responseHandle )
    {
	this.feedbackType = mType;
	this.description = desc;
	this.machineType = mNumber;
	this.imageUrls = imgUrls;
	this.contactInfo = info;
	this.mHandlResponse = responseHandle;
    }

    @Override
    protected ByteString getRequestBody()
    {
	Feedback.ReqFeedback.Builder builder = Feedback.ReqFeedback.newBuilder( );
	builder.setFeedbackType( feedbackType );
	builder.setDescription( description );
	builder.setMachineType( machineType );
	builder.setContactInfo( contactInfo );
	if( imageUrls != null && imageUrls.size( ) > 0 )
	{
	    for( int i = 0 ; i < imageUrls.size( ) ; i++ )
	    {
		builder.addImageUrls( imageUrls.get( i ) );
	    }
	}
	return builder.build( ).toByteString( );
    }

    @Override
    protected int getRequestMask()
    {
	return MaskCode.DEFAULT_VALUE;
    }

    @Override
    protected String getRequestAction()
    {
	return ACTION.ACTION_FEEDBACK_REQUEST;
    }

    @Override
    protected String getResponseAction()
    {
	return ACTION.ACTION_FEEDBACK_RESPONSE;
    }

    @Override
    protected void handleResponseBody( ByteString byteString )
    {
	try
	{
	    Feedback.RspFeedback rspBody = Feedback.RspFeedback.parseFrom( byteString );
	    int retCode = rspBody.getRescode( );//返回码
	    String retMsg = rspBody.getResmsg( );//返回消息
	    RspBean rsp = new RspBean( retCode , retMsg );
	    mHandlResponse.handleResponseBean( true , rsp );
	}
	catch ( InvalidProtocolBufferException e )
	{
	    handleResponseError( ERROR.ERROR_BAD_PACKET , e.getMessage( ) );
	}
    }

    @Override
    protected void handleResponseError( int errCode , String strErr )
    {
	RspBean rsp = new RspBean( errCode , strErr );
	mHandlResponse.handleResponseBean( false , rsp );
    }

    @Override
    protected String getServerUrl()
    {
	return ServerUrl.getServerUrlCommit( );
    }

}
