package com.jui.feedback.protocol;

public final class Packet
{
    private Packet()
    {}

    public static void registerAllExtensions( com.google.protobuf.ExtensionRegistry registry )
    {}

    /**
     * Protobuf enum {@code MaskCode}
     */
    public enum MaskCode implements com.google.protobuf.ProtocolMessageEnum
    {
	/**
	 * <code>DEFAULT = 0;</code>
	 */
	DEFAULT( 0 , 0 ) ,
	/**
	 * <code>PARAMS_GZIP = 1;</code>
	 */
	PARAMS_GZIP( 1 , 1 ) ,
	/**
	 * <code>PARAMS_RSA = 2;</code>
	 */
	PARAMS_RSA( 2 , 2 ) , ;

	/**
	 * <code>DEFAULT = 0;</code>
	 */
	public static final int DEFAULT_VALUE = 0;
	/**
	 * <code>PARAMS_GZIP = 1;</code>
	 */
	public static final int PARAMS_GZIP_VALUE = 1;
	/**
	 * <code>PARAMS_RSA = 2;</code>
	 */
	public static final int PARAMS_RSA_VALUE = 2;

	public final int getNumber()
	{
	    return value;
	}

	public static MaskCode valueOf( int value )
	{
	    switch ( value )
	    {
		case 0 :
		    return DEFAULT;
		case 1 :
		    return PARAMS_GZIP;
		case 2 :
		    return PARAMS_RSA;
		default :
		    return null;
	    }
	}

	public static com.google.protobuf.Internal.EnumLiteMap< MaskCode > internalGetValueMap()
	{
	    return internalValueMap;
	}

	private static com.google.protobuf.Internal.EnumLiteMap< MaskCode > internalValueMap = new com.google.protobuf.Internal.EnumLiteMap< MaskCode >( )
	{
	    public MaskCode findValueByNumber( int number )
	    {
		return MaskCode.valueOf( number );
	    }
	};

	public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor()
	{
	    return getDescriptor( ).getValues( ).get( index );
	}

	public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType()
	{
	    return getDescriptor( );
	}

	public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor()
	{
	    return Packet.getDescriptor( ).getEnumTypes( ).get( 0 );
	}

	private static final MaskCode [] VALUES = values( );

	public static MaskCode valueOf( com.google.protobuf.Descriptors.EnumValueDescriptor desc )
	{
	    if( desc.getType( ) != getDescriptor( ) )
	    {
		throw new java.lang.IllegalArgumentException( "EnumValueDescriptor is not for this type." );
	    }
	    return VALUES[desc.getIndex( )];
	}

	private final int index;
	private final int value;

	private MaskCode( int index , int value )
	{
	    this.index = index;
	    this.value = value;
	}

	// @@protoc_insertion_point(enum_scope:MaskCode)
    }

    public interface ReqPacketOrBuilder extends com.google.protobuf.MessageOrBuilder
    {

	// required int32 mask = 1;
	/**
	 * <code>required int32 mask = 1;</code>
	 * 
	 * <pre>
	 * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	 * </pre>
	 */
	boolean hasMask();

	/**
	 * <code>required int32 mask = 1;</code>
	 * 
	 * <pre>
	 * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	 * </pre>
	 */
	int getMask();

	// required string udi = 2;
	/**
	 * <code>required string udi = 2;</code>
	 * 
	 * <pre>
	 * 设备信息
	 * </pre>
	 */
	boolean hasUdi();

	/**
	 * <code>required string udi = 2;</code>
	 * 
	 * <pre>
	 * 设备信息
	 * </pre>
	 */
	java.lang.String getUdi();

	/**
	 * <code>required string udi = 2;</code>
	 * 
	 * <pre>
	 * 设备信息
	 * </pre>
	 */
	com.google.protobuf.ByteString getUdiBytes();

	// repeated string action = 3;
	/**
	 * <code>repeated string action = 3;</code>
	 * 
	 * <pre>
	 * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	 * </pre>
	 */
	java.util.List< java.lang.String > getActionList();

	/**
	 * <code>repeated string action = 3;</code>
	 * 
	 * <pre>
	 * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	 * </pre>
	 */
	int getActionCount();

	/**
	 * <code>repeated string action = 3;</code>
	 * 
	 * <pre>
	 * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	 * </pre>
	 */
	java.lang.String getAction( int index );

	/**
	 * <code>repeated string action = 3;</code>
	 * 
	 * <pre>
	 * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	 * </pre>
	 */
	com.google.protobuf.ByteString getActionBytes( int index );

	// repeated bytes params = 4;
	/**
	 * <code>repeated bytes params = 4;</code>
	 * 
	 * <pre>
	 * 参数（根据action中定义的操作，上传对应的请求参数）
	 * </pre>
	 */
	java.util.List< com.google.protobuf.ByteString > getParamsList();

	/**
	 * <code>repeated bytes params = 4;</code>
	 * 
	 * <pre>
	 * 参数（根据action中定义的操作，上传对应的请求参数）
	 * </pre>
	 */
	int getParamsCount();

	/**
	 * <code>repeated bytes params = 4;</code>
	 * 
	 * <pre>
	 * 参数（根据action中定义的操作，上传对应的请求参数）
	 * </pre>
	 */
	com.google.protobuf.ByteString getParams( int index );

	// required int32 reqNo = 5;
	/**
	 * <code>required int32 reqNo = 5;</code>
	 * 
	 * <pre>
	 * 请求顺序号
	 * </pre>
	 */
	boolean hasReqNo();

	/**
	 * <code>required int32 reqNo = 5;</code>
	 * 
	 * <pre>
	 * 请求顺序号
	 * </pre>
	 */
	int getReqNo();

	// optional int32 chnNo = 6;
	/**
	 * <code>optional int32 chnNo = 6;</code>
	 * 
	 * <pre>
	 * 渠道号（由后台分配给渠道并传入，默认为0）
	 * </pre>
	 */
	boolean hasChnNo();

	/**
	 * <code>optional int32 chnNo = 6;</code>
	 * 
	 * <pre>
	 * 渠道号（由后台分配给渠道并传入，默认为0）
	 * </pre>
	 */
	int getChnNo();

	// optional int32 chnPos = 7;
	/**
	 * <code>optional int32 chnPos = 7;</code>
	 * 
	 * <pre>
	 * 渠道位置（由后台分配给渠道或SDK传入，确定如：广告位第二个广告等位置信息，默认为0。又如帐号中心，可能会有多个位置可以跳游戏中心，渠道位置会不一样）
	 * </pre>
	 */
	boolean hasChnPos();

	/**
	 * <code>optional int32 chnPos = 7;</code>
	 * 
	 * <pre>
	 * 渠道位置（由后台分配给渠道或SDK传入，确定如：广告位第二个广告等位置信息，默认为0。又如帐号中心，可能会有多个位置可以跳游戏中心，渠道位置会不一样）
	 * </pre>
	 */
	int getChnPos();

	// required int32 clientId = 8;
	/**
	 * <code>required int32 clientId = 8;</code>
	 * 
	 * <pre>
	 * 应用的ID（直接与服务端沟通的应用的ID）(定义: 1=帐号账户 , 2= 应用商店 , 3= PcSuite, 4= 桌面)
	 * </pre>
	 */
	boolean hasClientId();

	/**
	 * <code>required int32 clientId = 8;</code>
	 * 
	 * <pre>
	 * 应用的ID（直接与服务端沟通的应用的ID）(定义: 1=帐号账户 , 2= 应用商店 , 3= PcSuite, 4= 桌面)
	 * </pre>
	 */
	int getClientId();

	// optional int32 clientPos = 9;
	/**
	 * <code>optional int32 clientPos = 9;</code>
	 * 
	 * <pre>
	 * 应用的位置（直接与服务端沟通的应用的位置ID，与渠道位置类似）
	 * </pre>
	 */
	boolean hasClientPos();

	/**
	 * <code>optional int32 clientPos = 9;</code>
	 * 
	 * <pre>
	 * 应用的位置（直接与服务端沟通的应用的位置ID，与渠道位置类似）
	 * </pre>
	 */
	int getClientPos();

	// optional string clientVer = 10;
	/**
	 * <code>optional string clientVer = 10;</code>
	 * 
	 * <pre>
	 * 应用的版本（应用的版本由通用的版本号规则定义）
	 * </pre>
	 */
	boolean hasClientVer();

	/**
	 * <code>optional string clientVer = 10;</code>
	 * 
	 * <pre>
	 * 应用的版本（应用的版本由通用的版本号规则定义）
	 * </pre>
	 */
	java.lang.String getClientVer();

	/**
	 * <code>optional string clientVer = 10;</code>
	 * 
	 * <pre>
	 * 应用的版本（应用的版本由通用的版本号规则定义）
	 * </pre>
	 */
	com.google.protobuf.ByteString getClientVerBytes();

	// optional string rsaKeyVer = 11;
	/**
	 * <code>optional string rsaKeyVer = 11;</code>
	 * 
	 * <pre>
	 * 当前程序的RSA - KEY的版本标识
	 * </pre>
	 */
	boolean hasRsaKeyVer();

	/**
	 * <code>optional string rsaKeyVer = 11;</code>
	 * 
	 * <pre>
	 * 当前程序的RSA - KEY的版本标识
	 * </pre>
	 */
	java.lang.String getRsaKeyVer();

	/**
	 * <code>optional string rsaKeyVer = 11;</code>
	 * 
	 * <pre>
	 * 当前程序的RSA - KEY的版本标识
	 * </pre>
	 */
	com.google.protobuf.ByteString getRsaKeyVerBytes();
    }

    /**
     * Protobuf type {@code ReqPacket}
     * 
     * <pre>
     * ============================================ 请求包与响应包
     * </pre>
     */
    public static final class ReqPacket extends com.google.protobuf.GeneratedMessage implements ReqPacketOrBuilder
    {
	// Use ReqPacket.newBuilder() to construct.
	private ReqPacket( com.google.protobuf.GeneratedMessage.Builder< ? > builder )
	{
	    super( builder );
	    this.unknownFields = builder.getUnknownFields( );
	}

	private ReqPacket( boolean noInit )
	{
	    this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance( );
	}

	private static final ReqPacket defaultInstance;

	public static ReqPacket getDefaultInstance()
	{
	    return defaultInstance;
	}

	public ReqPacket getDefaultInstanceForType()
	{
	    return defaultInstance;
	}

	private final com.google.protobuf.UnknownFieldSet unknownFields;

	@java.lang.Override
	public final com.google.protobuf.UnknownFieldSet getUnknownFields()
	{
	    return this.unknownFields;
	}

	private ReqPacket( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    initFields( );
	    int mutable_bitField0_ = 0;
	    com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet.newBuilder( );
	    try
	    {
		boolean done = false;
		while ( !done )
		{
		    int tag = input.readTag( );
		    switch ( tag )
		    {
			case 0 :
			    done = true;
			    break;
			default :
			{
			    if( !parseUnknownField( input , unknownFields , extensionRegistry , tag ) )
			    {
				done = true;
			    }
			    break;
			}
			case 8 :
			{
			    bitField0_ |= 0x00000001;
			    mask_ = input.readInt32( );
			    break;
			}
			case 18 :
			{
			    bitField0_ |= 0x00000002;
			    udi_ = input.readBytes( );
			    break;
			}
			case 26 :
			{
			    if( ! ( ( mutable_bitField0_ & 0x00000004 ) == 0x00000004 ) )
			    {
				action_ = new com.google.protobuf.LazyStringArrayList( );
				mutable_bitField0_ |= 0x00000004;
			    }
			    action_.add( input.readBytes( ) );
			    break;
			}
			case 34 :
			{
			    if( ! ( ( mutable_bitField0_ & 0x00000008 ) == 0x00000008 ) )
			    {
				params_ = new java.util.ArrayList< com.google.protobuf.ByteString >( );
				mutable_bitField0_ |= 0x00000008;
			    }
			    params_.add( input.readBytes( ) );
			    break;
			}
			case 40 :
			{
			    bitField0_ |= 0x00000004;
			    reqNo_ = input.readInt32( );
			    break;
			}
			case 48 :
			{
			    bitField0_ |= 0x00000008;
			    chnNo_ = input.readInt32( );
			    break;
			}
			case 56 :
			{
			    bitField0_ |= 0x00000010;
			    chnPos_ = input.readInt32( );
			    break;
			}
			case 64 :
			{
			    bitField0_ |= 0x00000020;
			    clientId_ = input.readInt32( );
			    break;
			}
			case 72 :
			{
			    bitField0_ |= 0x00000040;
			    clientPos_ = input.readInt32( );
			    break;
			}
			case 82 :
			{
			    bitField0_ |= 0x00000080;
			    clientVer_ = input.readBytes( );
			    break;
			}
			case 90 :
			{
			    bitField0_ |= 0x00000100;
			    rsaKeyVer_ = input.readBytes( );
			    break;
			}
		    }
		}
	    }
	    catch ( com.google.protobuf.InvalidProtocolBufferException e )
	    {
		throw e.setUnfinishedMessage( this );
	    }
	    catch ( java.io.IOException e )
	    {
		throw new com.google.protobuf.InvalidProtocolBufferException( e.getMessage( ) ).setUnfinishedMessage( this );
	    }
	    finally
	    {
		if( ( ( mutable_bitField0_ & 0x00000004 ) == 0x00000004 ) )
		{
		    action_ = new com.google.protobuf.UnmodifiableLazyStringList( action_ );
		}
		if( ( ( mutable_bitField0_ & 0x00000008 ) == 0x00000008 ) )
		{
		    params_ = java.util.Collections.unmodifiableList( params_ );
		}
		this.unknownFields = unknownFields.build( );
		makeExtensionsImmutable( );
	    }
	}

	public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
	{
	    return Packet.internal_static_ReqPacket_descriptor;
	}

	protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	{
	    return Packet.internal_static_ReqPacket_fieldAccessorTable.ensureFieldAccessorsInitialized( Packet.ReqPacket.class , Packet.ReqPacket.Builder.class );
	}

	public static com.google.protobuf.Parser< ReqPacket > PARSER = new com.google.protobuf.AbstractParser< ReqPacket >( )
	{
	    public ReqPacket parsePartialFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	    {
		return new ReqPacket( input , extensionRegistry );
	    }
	};

	@java.lang.Override
	public com.google.protobuf.Parser< ReqPacket > getParserForType()
	{
	    return PARSER;
	}

	private int bitField0_;
	// required int32 mask = 1;
	public static final int MASK_FIELD_NUMBER = 1;
	private int mask_;

	/**
	 * <code>required int32 mask = 1;</code>
	 * 
	 * <pre>
	 * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	 * </pre>
	 */
	public boolean hasMask()
	{
	    return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	}

	/**
	 * <code>required int32 mask = 1;</code>
	 * 
	 * <pre>
	 * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	 * </pre>
	 */
	public int getMask()
	{
	    return mask_;
	}

	// required string udi = 2;
	public static final int UDI_FIELD_NUMBER = 2;
	private java.lang.Object udi_;

	/**
	 * <code>required string udi = 2;</code>
	 * 
	 * <pre>
	 * 设备信息
	 * </pre>
	 */
	public boolean hasUdi()
	{
	    return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	}

	/**
	 * <code>required string udi = 2;</code>
	 * 
	 * <pre>
	 * 设备信息
	 * </pre>
	 */
	public java.lang.String getUdi()
	{
	    java.lang.Object ref = udi_;
	    if( ref instanceof java.lang.String )
	    {
		return (java.lang.String)ref;
	    }
	    else
	    {
		com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString)ref;
		java.lang.String s = bs.toStringUtf8( );
		if( bs.isValidUtf8( ) )
		{
		    udi_ = s;
		}
		return s;
	    }
	}

	/**
	 * <code>required string udi = 2;</code>
	 * 
	 * <pre>
	 * 设备信息
	 * </pre>
	 */
	public com.google.protobuf.ByteString getUdiBytes()
	{
	    java.lang.Object ref = udi_;
	    if( ref instanceof java.lang.String )
	    {
		com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		udi_ = b;
		return b;
	    }
	    else
	    {
		return (com.google.protobuf.ByteString)ref;
	    }
	}

	// repeated string action = 3;
	public static final int ACTION_FIELD_NUMBER = 3;
	private com.google.protobuf.LazyStringList action_;

	/**
	 * <code>repeated string action = 3;</code>
	 * 
	 * <pre>
	 * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	 * </pre>
	 */
	public java.util.List< java.lang.String > getActionList()
	{
	    return action_;
	}

	/**
	 * <code>repeated string action = 3;</code>
	 * 
	 * <pre>
	 * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	 * </pre>
	 */
	public int getActionCount()
	{
	    return action_.size( );
	}

	/**
	 * <code>repeated string action = 3;</code>
	 * 
	 * <pre>
	 * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	 * </pre>
	 */
	public java.lang.String getAction( int index )
	{
	    return action_.get( index );
	}

	/**
	 * <code>repeated string action = 3;</code>
	 * 
	 * <pre>
	 * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	 * </pre>
	 */
	public com.google.protobuf.ByteString getActionBytes( int index )
	{
	    return action_.getByteString( index );
	}

	// repeated bytes params = 4;
	public static final int PARAMS_FIELD_NUMBER = 4;
	private java.util.List< com.google.protobuf.ByteString > params_;

	/**
	 * <code>repeated bytes params = 4;</code>
	 * 
	 * <pre>
	 * 参数（根据action中定义的操作，上传对应的请求参数）
	 * </pre>
	 */
	public java.util.List< com.google.protobuf.ByteString > getParamsList()
	{
	    return params_;
	}

	/**
	 * <code>repeated bytes params = 4;</code>
	 * 
	 * <pre>
	 * 参数（根据action中定义的操作，上传对应的请求参数）
	 * </pre>
	 */
	public int getParamsCount()
	{
	    return params_.size( );
	}

	/**
	 * <code>repeated bytes params = 4;</code>
	 * 
	 * <pre>
	 * 参数（根据action中定义的操作，上传对应的请求参数）
	 * </pre>
	 */
	public com.google.protobuf.ByteString getParams( int index )
	{
	    return params_.get( index );
	}

	// required int32 reqNo = 5;
	public static final int REQNO_FIELD_NUMBER = 5;
	private int reqNo_;

	/**
	 * <code>required int32 reqNo = 5;</code>
	 * 
	 * <pre>
	 * 请求顺序号
	 * </pre>
	 */
	public boolean hasReqNo()
	{
	    return ( ( bitField0_ & 0x00000004 ) == 0x00000004 );
	}

	/**
	 * <code>required int32 reqNo = 5;</code>
	 * 
	 * <pre>
	 * 请求顺序号
	 * </pre>
	 */
	public int getReqNo()
	{
	    return reqNo_;
	}

	// optional int32 chnNo = 6;
	public static final int CHNNO_FIELD_NUMBER = 6;
	private int chnNo_;

	/**
	 * <code>optional int32 chnNo = 6;</code>
	 * 
	 * <pre>
	 * 渠道号（由后台分配给渠道并传入，默认为0）
	 * </pre>
	 */
	public boolean hasChnNo()
	{
	    return ( ( bitField0_ & 0x00000008 ) == 0x00000008 );
	}

	/**
	 * <code>optional int32 chnNo = 6;</code>
	 * 
	 * <pre>
	 * 渠道号（由后台分配给渠道并传入，默认为0）
	 * </pre>
	 */
	public int getChnNo()
	{
	    return chnNo_;
	}

	// optional int32 chnPos = 7;
	public static final int CHNPOS_FIELD_NUMBER = 7;
	private int chnPos_;

	/**
	 * <code>optional int32 chnPos = 7;</code>
	 * 
	 * <pre>
	 * 渠道位置（由后台分配给渠道或SDK传入，确定如：广告位第二个广告等位置信息，默认为0。又如帐号中心，可能会有多个位置可以跳游戏中心，渠道位置会不一样）
	 * </pre>
	 */
	public boolean hasChnPos()
	{
	    return ( ( bitField0_ & 0x00000010 ) == 0x00000010 );
	}

	/**
	 * <code>optional int32 chnPos = 7;</code>
	 * 
	 * <pre>
	 * 渠道位置（由后台分配给渠道或SDK传入，确定如：广告位第二个广告等位置信息，默认为0。又如帐号中心，可能会有多个位置可以跳游戏中心，渠道位置会不一样）
	 * </pre>
	 */
	public int getChnPos()
	{
	    return chnPos_;
	}

	// required int32 clientId = 8;
	public static final int CLIENTID_FIELD_NUMBER = 8;
	private int clientId_;

	/**
	 * <code>required int32 clientId = 8;</code>
	 * 
	 * <pre>
	 * 应用的ID（直接与服务端沟通的应用的ID）(定义: 1=帐号账户 , 2= 应用商店 , 3= PcSuite, 4= 桌面)
	 * </pre>
	 */
	public boolean hasClientId()
	{
	    return ( ( bitField0_ & 0x00000020 ) == 0x00000020 );
	}

	/**
	 * <code>required int32 clientId = 8;</code>
	 * 
	 * <pre>
	 * 应用的ID（直接与服务端沟通的应用的ID）(定义: 1=帐号账户 , 2= 应用商店 , 3= PcSuite, 4= 桌面)
	 * </pre>
	 */
	public int getClientId()
	{
	    return clientId_;
	}

	// optional int32 clientPos = 9;
	public static final int CLIENTPOS_FIELD_NUMBER = 9;
	private int clientPos_;

	/**
	 * <code>optional int32 clientPos = 9;</code>
	 * 
	 * <pre>
	 * 应用的位置（直接与服务端沟通的应用的位置ID，与渠道位置类似）
	 * </pre>
	 */
	public boolean hasClientPos()
	{
	    return ( ( bitField0_ & 0x00000040 ) == 0x00000040 );
	}

	/**
	 * <code>optional int32 clientPos = 9;</code>
	 * 
	 * <pre>
	 * 应用的位置（直接与服务端沟通的应用的位置ID，与渠道位置类似）
	 * </pre>
	 */
	public int getClientPos()
	{
	    return clientPos_;
	}

	// optional string clientVer = 10;
	public static final int CLIENTVER_FIELD_NUMBER = 10;
	private java.lang.Object clientVer_;

	/**
	 * <code>optional string clientVer = 10;</code>
	 * 
	 * <pre>
	 * 应用的版本（应用的版本由通用的版本号规则定义）
	 * </pre>
	 */
	public boolean hasClientVer()
	{
	    return ( ( bitField0_ & 0x00000080 ) == 0x00000080 );
	}

	/**
	 * <code>optional string clientVer = 10;</code>
	 * 
	 * <pre>
	 * 应用的版本（应用的版本由通用的版本号规则定义）
	 * </pre>
	 */
	public java.lang.String getClientVer()
	{
	    java.lang.Object ref = clientVer_;
	    if( ref instanceof java.lang.String )
	    {
		return (java.lang.String)ref;
	    }
	    else
	    {
		com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString)ref;
		java.lang.String s = bs.toStringUtf8( );
		if( bs.isValidUtf8( ) )
		{
		    clientVer_ = s;
		}
		return s;
	    }
	}

	/**
	 * <code>optional string clientVer = 10;</code>
	 * 
	 * <pre>
	 * 应用的版本（应用的版本由通用的版本号规则定义）
	 * </pre>
	 */
	public com.google.protobuf.ByteString getClientVerBytes()
	{
	    java.lang.Object ref = clientVer_;
	    if( ref instanceof java.lang.String )
	    {
		com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		clientVer_ = b;
		return b;
	    }
	    else
	    {
		return (com.google.protobuf.ByteString)ref;
	    }
	}

	// optional string rsaKeyVer = 11;
	public static final int RSAKEYVER_FIELD_NUMBER = 11;
	private java.lang.Object rsaKeyVer_;

	/**
	 * <code>optional string rsaKeyVer = 11;</code>
	 * 
	 * <pre>
	 * 当前程序的RSA - KEY的版本标识
	 * </pre>
	 */
	public boolean hasRsaKeyVer()
	{
	    return ( ( bitField0_ & 0x00000100 ) == 0x00000100 );
	}

	/**
	 * <code>optional string rsaKeyVer = 11;</code>
	 * 
	 * <pre>
	 * 当前程序的RSA - KEY的版本标识
	 * </pre>
	 */
	public java.lang.String getRsaKeyVer()
	{
	    java.lang.Object ref = rsaKeyVer_;
	    if( ref instanceof java.lang.String )
	    {
		return (java.lang.String)ref;
	    }
	    else
	    {
		com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString)ref;
		java.lang.String s = bs.toStringUtf8( );
		if( bs.isValidUtf8( ) )
		{
		    rsaKeyVer_ = s;
		}
		return s;
	    }
	}

	/**
	 * <code>optional string rsaKeyVer = 11;</code>
	 * 
	 * <pre>
	 * 当前程序的RSA - KEY的版本标识
	 * </pre>
	 */
	public com.google.protobuf.ByteString getRsaKeyVerBytes()
	{
	    java.lang.Object ref = rsaKeyVer_;
	    if( ref instanceof java.lang.String )
	    {
		com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		rsaKeyVer_ = b;
		return b;
	    }
	    else
	    {
		return (com.google.protobuf.ByteString)ref;
	    }
	}

	private void initFields()
	{
	    mask_ = 0;
	    udi_ = "";
	    action_ = com.google.protobuf.LazyStringArrayList.EMPTY;
	    params_ = java.util.Collections.emptyList( );
	    reqNo_ = 0;
	    chnNo_ = 0;
	    chnPos_ = 0;
	    clientId_ = 0;
	    clientPos_ = 0;
	    clientVer_ = "";
	    rsaKeyVer_ = "";
	}

	private byte memoizedIsInitialized = -1;

	public final boolean isInitialized()
	{
	    byte isInitialized = memoizedIsInitialized;
	    if( isInitialized != -1 )
		return isInitialized == 1;

	    if( !hasMask( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    if( !hasUdi( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    if( !hasReqNo( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    if( !hasClientId( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    memoizedIsInitialized = 1;
	    return true;
	}

	public void writeTo( com.google.protobuf.CodedOutputStream output ) throws java.io.IOException
	{
	    getSerializedSize( );
	    if( ( ( bitField0_ & 0x00000001 ) == 0x00000001 ) )
	    {
		output.writeInt32( 1 , mask_ );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		output.writeBytes( 2 , getUdiBytes( ) );
	    }
	    for( int i = 0 ; i < action_.size( ) ; i++ )
	    {
		output.writeBytes( 3 , action_.getByteString( i ) );
	    }
	    for( int i = 0 ; i < params_.size( ) ; i++ )
	    {
		output.writeBytes( 4 , params_.get( i ) );
	    }
	    if( ( ( bitField0_ & 0x00000004 ) == 0x00000004 ) )
	    {
		output.writeInt32( 5 , reqNo_ );
	    }
	    if( ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
	    {
		output.writeInt32( 6 , chnNo_ );
	    }
	    if( ( ( bitField0_ & 0x00000010 ) == 0x00000010 ) )
	    {
		output.writeInt32( 7 , chnPos_ );
	    }
	    if( ( ( bitField0_ & 0x00000020 ) == 0x00000020 ) )
	    {
		output.writeInt32( 8 , clientId_ );
	    }
	    if( ( ( bitField0_ & 0x00000040 ) == 0x00000040 ) )
	    {
		output.writeInt32( 9 , clientPos_ );
	    }
	    if( ( ( bitField0_ & 0x00000080 ) == 0x00000080 ) )
	    {
		output.writeBytes( 10 , getClientVerBytes( ) );
	    }
	    if( ( ( bitField0_ & 0x00000100 ) == 0x00000100 ) )
	    {
		output.writeBytes( 11 , getRsaKeyVerBytes( ) );
	    }
	    getUnknownFields( ).writeTo( output );
	}

	private int memoizedSerializedSize = -1;

	public int getSerializedSize()
	{
	    int size = memoizedSerializedSize;
	    if( size != -1 )
		return size;

	    size = 0;
	    if( ( ( bitField0_ & 0x00000001 ) == 0x00000001 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 1 , mask_ );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 2 , getUdiBytes( ) );
	    }
	    {
		int dataSize = 0;
		for( int i = 0 ; i < action_.size( ) ; i++ )
		{
		    dataSize += com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag( action_.getByteString( i ) );
		}
		size += dataSize;
		size += 1 * getActionList( ).size( );
	    }
	    {
		int dataSize = 0;
		for( int i = 0 ; i < params_.size( ) ; i++ )
		{
		    dataSize += com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag( params_.get( i ) );
		}
		size += dataSize;
		size += 1 * getParamsList( ).size( );
	    }
	    if( ( ( bitField0_ & 0x00000004 ) == 0x00000004 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 5 , reqNo_ );
	    }
	    if( ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 6 , chnNo_ );
	    }
	    if( ( ( bitField0_ & 0x00000010 ) == 0x00000010 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 7 , chnPos_ );
	    }
	    if( ( ( bitField0_ & 0x00000020 ) == 0x00000020 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 8 , clientId_ );
	    }
	    if( ( ( bitField0_ & 0x00000040 ) == 0x00000040 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 9 , clientPos_ );
	    }
	    if( ( ( bitField0_ & 0x00000080 ) == 0x00000080 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 10 , getClientVerBytes( ) );
	    }
	    if( ( ( bitField0_ & 0x00000100 ) == 0x00000100 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 11 , getRsaKeyVerBytes( ) );
	    }
	    size += getUnknownFields( ).getSerializedSize( );
	    memoizedSerializedSize = size;
	    return size;
	}

	private static final long serialVersionUID = 0L;

	@java.lang.Override
	protected java.lang.Object writeReplace() throws java.io.ObjectStreamException
	{
	    return super.writeReplace( );
	}

	public static Packet.ReqPacket parseFrom( com.google.protobuf.ByteString data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Packet.ReqPacket parseFrom( com.google.protobuf.ByteString data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Packet.ReqPacket parseFrom( byte [] data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Packet.ReqPacket parseFrom( byte [] data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Packet.ReqPacket parseFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Packet.ReqPacket parseFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input , extensionRegistry );
	}

	public static Packet.ReqPacket parseDelimitedFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input );
	}

	public static Packet.ReqPacket parseDelimitedFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input , extensionRegistry );
	}

	public static Packet.ReqPacket parseFrom( com.google.protobuf.CodedInputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Packet.ReqPacket parseFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input , extensionRegistry );
	}

	public static Builder newBuilder()
	{
	    return Builder.create( );
	}

	public Builder newBuilderForType()
	{
	    return newBuilder( );
	}

	public static Builder newBuilder( Packet.ReqPacket prototype )
	{
	    return newBuilder( ).mergeFrom( prototype );
	}

	public Builder toBuilder()
	{
	    return newBuilder( this );
	}

	@java.lang.Override
	protected Builder newBuilderForType( com.google.protobuf.GeneratedMessage.BuilderParent parent )
	{
	    Builder builder = new Builder( parent );
	    return builder;
	}

	/**
	 * Protobuf type {@code ReqPacket}
	 * 
	 * <pre>
	 * ============================================ 请求包与响应包
	 * </pre>
	 */
	public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder< Builder > implements Packet.ReqPacketOrBuilder
	{
	    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
	    {
		return Packet.internal_static_ReqPacket_descriptor;
	    }

	    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	    {
		return Packet.internal_static_ReqPacket_fieldAccessorTable.ensureFieldAccessorsInitialized( Packet.ReqPacket.class , Packet.ReqPacket.Builder.class );
	    }

	    // Construct using Packet.ReqPacket.newBuilder()
	    private Builder()
	    {
		maybeForceBuilderInitialization( );
	    }

	    private Builder( com.google.protobuf.GeneratedMessage.BuilderParent parent )
	    {
		super( parent );
		maybeForceBuilderInitialization( );
	    }

	    private void maybeForceBuilderInitialization()
	    {
		if( com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders )
		{}
	    }

	    private static Builder create()
	    {
		return new Builder( );
	    }

	    public Builder clear()
	    {
		super.clear( );
		mask_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000001 );
		udi_ = "";
		bitField0_ = ( bitField0_ & ~0x00000002 );
		action_ = com.google.protobuf.LazyStringArrayList.EMPTY;
		bitField0_ = ( bitField0_ & ~0x00000004 );
		params_ = java.util.Collections.emptyList( );
		bitField0_ = ( bitField0_ & ~0x00000008 );
		reqNo_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000010 );
		chnNo_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000020 );
		chnPos_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000040 );
		clientId_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000080 );
		clientPos_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000100 );
		clientVer_ = "";
		bitField0_ = ( bitField0_ & ~0x00000200 );
		rsaKeyVer_ = "";
		bitField0_ = ( bitField0_ & ~0x00000400 );
		return this;
	    }

	    public Builder clone()
	    {
		return create( ).mergeFrom( buildPartial( ) );
	    }

	    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
	    {
		return Packet.internal_static_ReqPacket_descriptor;
	    }

	    public Packet.ReqPacket getDefaultInstanceForType()
	    {
		return Packet.ReqPacket.getDefaultInstance( );
	    }

	    public Packet.ReqPacket build()
	    {
		Packet.ReqPacket result = buildPartial( );
		if( !result.isInitialized( ) )
		{
		    throw newUninitializedMessageException( result );
		}
		return result;
	    }

	    public Packet.ReqPacket buildPartial()
	    {
		Packet.ReqPacket result = new Packet.ReqPacket( this );
		int from_bitField0_ = bitField0_;
		int to_bitField0_ = 0;
		if( ( ( from_bitField0_ & 0x00000001 ) == 0x00000001 ) )
		{
		    to_bitField0_ |= 0x00000001;
		}
		result.mask_ = mask_;
		if( ( ( from_bitField0_ & 0x00000002 ) == 0x00000002 ) )
		{
		    to_bitField0_ |= 0x00000002;
		}
		result.udi_ = udi_;
		if( ( ( bitField0_ & 0x00000004 ) == 0x00000004 ) )
		{
		    action_ = new com.google.protobuf.UnmodifiableLazyStringList( action_ );
		    bitField0_ = ( bitField0_ & ~0x00000004 );
		}
		result.action_ = action_;
		if( ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
		{
		    params_ = java.util.Collections.unmodifiableList( params_ );
		    bitField0_ = ( bitField0_ & ~0x00000008 );
		}
		result.params_ = params_;
		if( ( ( from_bitField0_ & 0x00000010 ) == 0x00000010 ) )
		{
		    to_bitField0_ |= 0x00000004;
		}
		result.reqNo_ = reqNo_;
		if( ( ( from_bitField0_ & 0x00000020 ) == 0x00000020 ) )
		{
		    to_bitField0_ |= 0x00000008;
		}
		result.chnNo_ = chnNo_;
		if( ( ( from_bitField0_ & 0x00000040 ) == 0x00000040 ) )
		{
		    to_bitField0_ |= 0x00000010;
		}
		result.chnPos_ = chnPos_;
		if( ( ( from_bitField0_ & 0x00000080 ) == 0x00000080 ) )
		{
		    to_bitField0_ |= 0x00000020;
		}
		result.clientId_ = clientId_;
		if( ( ( from_bitField0_ & 0x00000100 ) == 0x00000100 ) )
		{
		    to_bitField0_ |= 0x00000040;
		}
		result.clientPos_ = clientPos_;
		if( ( ( from_bitField0_ & 0x00000200 ) == 0x00000200 ) )
		{
		    to_bitField0_ |= 0x00000080;
		}
		result.clientVer_ = clientVer_;
		if( ( ( from_bitField0_ & 0x00000400 ) == 0x00000400 ) )
		{
		    to_bitField0_ |= 0x00000100;
		}
		result.rsaKeyVer_ = rsaKeyVer_;
		result.bitField0_ = to_bitField0_;
		onBuilt( );
		return result;
	    }

	    public Builder mergeFrom( com.google.protobuf.Message other )
	    {
		if( other instanceof Packet.ReqPacket )
		{
		    return mergeFrom( (Packet.ReqPacket)other );
		}
		else
		{
		    super.mergeFrom( other );
		    return this;
		}
	    }

	    public Builder mergeFrom( Packet.ReqPacket other )
	    {
		if( other == Packet.ReqPacket.getDefaultInstance( ) )
		    return this;
		if( other.hasMask( ) )
		{
		    setMask( other.getMask( ) );
		}
		if( other.hasUdi( ) )
		{
		    bitField0_ |= 0x00000002;
		    udi_ = other.udi_;
		    onChanged( );
		}
		if( !other.action_.isEmpty( ) )
		{
		    if( action_.isEmpty( ) )
		    {
			action_ = other.action_;
			bitField0_ = ( bitField0_ & ~0x00000004 );
		    }
		    else
		    {
			ensureActionIsMutable( );
			action_.addAll( other.action_ );
		    }
		    onChanged( );
		}
		if( !other.params_.isEmpty( ) )
		{
		    if( params_.isEmpty( ) )
		    {
			params_ = other.params_;
			bitField0_ = ( bitField0_ & ~0x00000008 );
		    }
		    else
		    {
			ensureParamsIsMutable( );
			params_.addAll( other.params_ );
		    }
		    onChanged( );
		}
		if( other.hasReqNo( ) )
		{
		    setReqNo( other.getReqNo( ) );
		}
		if( other.hasChnNo( ) )
		{
		    setChnNo( other.getChnNo( ) );
		}
		if( other.hasChnPos( ) )
		{
		    setChnPos( other.getChnPos( ) );
		}
		if( other.hasClientId( ) )
		{
		    setClientId( other.getClientId( ) );
		}
		if( other.hasClientPos( ) )
		{
		    setClientPos( other.getClientPos( ) );
		}
		if( other.hasClientVer( ) )
		{
		    bitField0_ |= 0x00000200;
		    clientVer_ = other.clientVer_;
		    onChanged( );
		}
		if( other.hasRsaKeyVer( ) )
		{
		    bitField0_ |= 0x00000400;
		    rsaKeyVer_ = other.rsaKeyVer_;
		    onChanged( );
		}
		this.mergeUnknownFields( other.getUnknownFields( ) );
		return this;
	    }

	    public final boolean isInitialized()
	    {
		if( !hasMask( ) )
		{

		    return false;
		}
		if( !hasUdi( ) )
		{

		    return false;
		}
		if( !hasReqNo( ) )
		{

		    return false;
		}
		if( !hasClientId( ) )
		{

		    return false;
		}
		return true;
	    }

	    public Builder mergeFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	    {
		Packet.ReqPacket parsedMessage = null;
		try
		{
		    parsedMessage = PARSER.parsePartialFrom( input , extensionRegistry );
		}
		catch ( com.google.protobuf.InvalidProtocolBufferException e )
		{
		    parsedMessage = (Packet.ReqPacket)e.getUnfinishedMessage( );
		    throw e;
		}
		finally
		{
		    if( parsedMessage != null )
		    {
			mergeFrom( parsedMessage );
		    }
		}
		return this;
	    }

	    private int bitField0_;

	    // required int32 mask = 1;
	    private int mask_;

	    /**
	     * <code>required int32 mask = 1;</code>
	     * 
	     * <pre>
	     * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	     * </pre>
	     */
	    public boolean hasMask()
	    {
		return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	    }

	    /**
	     * <code>required int32 mask = 1;</code>
	     * 
	     * <pre>
	     * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	     * </pre>
	     */
	    public int getMask()
	    {
		return mask_;
	    }

	    /**
	     * <code>required int32 mask = 1;</code>
	     * 
	     * <pre>
	     * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	     * </pre>
	     */
	    public Builder setMask( int value )
	    {
		bitField0_ |= 0x00000001;
		mask_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required int32 mask = 1;</code>
	     * 
	     * <pre>
	     * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	     * </pre>
	     */
	    public Builder clearMask()
	    {
		bitField0_ = ( bitField0_ & ~0x00000001 );
		mask_ = 0;
		onChanged( );
		return this;
	    }

	    // required string udi = 2;
	    private java.lang.Object udi_ = "";

	    /**
	     * <code>required string udi = 2;</code>
	     * 
	     * <pre>
	     * 设备信息
	     * </pre>
	     */
	    public boolean hasUdi()
	    {
		return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	    }

	    /**
	     * <code>required string udi = 2;</code>
	     * 
	     * <pre>
	     * 设备信息
	     * </pre>
	     */
	    public java.lang.String getUdi()
	    {
		java.lang.Object ref = udi_;
		if( ! ( ref instanceof java.lang.String ) )
		{
		    java.lang.String s = ( (com.google.protobuf.ByteString)ref ).toStringUtf8( );
		    udi_ = s;
		    return s;
		}
		else
		{
		    return (java.lang.String)ref;
		}
	    }

	    /**
	     * <code>required string udi = 2;</code>
	     * 
	     * <pre>
	     * 设备信息
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getUdiBytes()
	    {
		java.lang.Object ref = udi_;
		if( ref instanceof String )
		{
		    com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		    udi_ = b;
		    return b;
		}
		else
		{
		    return (com.google.protobuf.ByteString)ref;
		}
	    }

	    /**
	     * <code>required string udi = 2;</code>
	     * 
	     * <pre>
	     * 设备信息
	     * </pre>
	     */
	    public Builder setUdi( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000002;
		udi_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string udi = 2;</code>
	     * 
	     * <pre>
	     * 设备信息
	     * </pre>
	     */
	    public Builder clearUdi()
	    {
		bitField0_ = ( bitField0_ & ~0x00000002 );
		udi_ = getDefaultInstance( ).getUdi( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string udi = 2;</code>
	     * 
	     * <pre>
	     * 设备信息
	     * </pre>
	     */
	    public Builder setUdiBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000002;
		udi_ = value;
		onChanged( );
		return this;
	    }

	    // repeated string action = 3;
	    private com.google.protobuf.LazyStringList action_ = com.google.protobuf.LazyStringArrayList.EMPTY;

	    private void ensureActionIsMutable()
	    {
		if( ! ( ( bitField0_ & 0x00000004 ) == 0x00000004 ) )
		{
		    action_ = new com.google.protobuf.LazyStringArrayList( action_ );
		    bitField0_ |= 0x00000004;
		}
	    }

	    /**
	     * <code>repeated string action = 3;</code>
	     * 
	     * <pre>
	     * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	     * </pre>
	     */
	    public java.util.List< java.lang.String > getActionList()
	    {
		return java.util.Collections.unmodifiableList( action_ );
	    }

	    /**
	     * <code>repeated string action = 3;</code>
	     * 
	     * <pre>
	     * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	     * </pre>
	     */
	    public int getActionCount()
	    {
		return action_.size( );
	    }

	    /**
	     * <code>repeated string action = 3;</code>
	     * 
	     * <pre>
	     * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	     * </pre>
	     */
	    public java.lang.String getAction( int index )
	    {
		return action_.get( index );
	    }

	    /**
	     * <code>repeated string action = 3;</code>
	     * 
	     * <pre>
	     * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getActionBytes( int index )
	    {
		return action_.getByteString( index );
	    }

	    /**
	     * <code>repeated string action = 3;</code>
	     * 
	     * <pre>
	     * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	     * </pre>
	     */
	    public Builder setAction( int index , java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureActionIsMutable( );
		action_.set( index , value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string action = 3;</code>
	     * 
	     * <pre>
	     * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	     * </pre>
	     */
	    public Builder addAction( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureActionIsMutable( );
		action_.add( value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string action = 3;</code>
	     * 
	     * <pre>
	     * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	     * </pre>
	     */
	    public Builder addAllAction( java.lang.Iterable< java.lang.String > values )
	    {
		ensureActionIsMutable( );
		super.addAll( values , action_ );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string action = 3;</code>
	     * 
	     * <pre>
	     * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	     * </pre>
	     */
	    public Builder clearAction()
	    {
		action_ = com.google.protobuf.LazyStringArrayList.EMPTY;
		bitField0_ = ( bitField0_ & ~0x00000004 );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string action = 3;</code>
	     * 
	     * <pre>
	     * 操作（协议更新，在协议名后加版本号，如：RegUser_V2）
	     * </pre>
	     */
	    public Builder addActionBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureActionIsMutable( );
		action_.add( value );
		onChanged( );
		return this;
	    }

	    // repeated bytes params = 4;
	    private java.util.List< com.google.protobuf.ByteString > params_ = java.util.Collections.emptyList( );

	    private void ensureParamsIsMutable()
	    {
		if( ! ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
		{
		    params_ = new java.util.ArrayList< com.google.protobuf.ByteString >( params_ );
		    bitField0_ |= 0x00000008;
		}
	    }

	    /**
	     * <code>repeated bytes params = 4;</code>
	     * 
	     * <pre>
	     * 参数（根据action中定义的操作，上传对应的请求参数）
	     * </pre>
	     */
	    public java.util.List< com.google.protobuf.ByteString > getParamsList()
	    {
		return java.util.Collections.unmodifiableList( params_ );
	    }

	    /**
	     * <code>repeated bytes params = 4;</code>
	     * 
	     * <pre>
	     * 参数（根据action中定义的操作，上传对应的请求参数）
	     * </pre>
	     */
	    public int getParamsCount()
	    {
		return params_.size( );
	    }

	    /**
	     * <code>repeated bytes params = 4;</code>
	     * 
	     * <pre>
	     * 参数（根据action中定义的操作，上传对应的请求参数）
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getParams( int index )
	    {
		return params_.get( index );
	    }

	    /**
	     * <code>repeated bytes params = 4;</code>
	     * 
	     * <pre>
	     * 参数（根据action中定义的操作，上传对应的请求参数）
	     * </pre>
	     */
	    public Builder setParams( int index , com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureParamsIsMutable( );
		params_.set( index , value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated bytes params = 4;</code>
	     * 
	     * <pre>
	     * 参数（根据action中定义的操作，上传对应的请求参数）
	     * </pre>
	     */
	    public Builder addParams( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureParamsIsMutable( );
		params_.add( value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated bytes params = 4;</code>
	     * 
	     * <pre>
	     * 参数（根据action中定义的操作，上传对应的请求参数）
	     * </pre>
	     */
	    public Builder addAllParams( java.lang.Iterable< ? extends com.google.protobuf.ByteString > values )
	    {
		ensureParamsIsMutable( );
		super.addAll( values , params_ );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated bytes params = 4;</code>
	     * 
	     * <pre>
	     * 参数（根据action中定义的操作，上传对应的请求参数）
	     * </pre>
	     */
	    public Builder clearParams()
	    {
		params_ = java.util.Collections.emptyList( );
		bitField0_ = ( bitField0_ & ~0x00000008 );
		onChanged( );
		return this;
	    }

	    // required int32 reqNo = 5;
	    private int reqNo_;

	    /**
	     * <code>required int32 reqNo = 5;</code>
	     * 
	     * <pre>
	     * 请求顺序号
	     * </pre>
	     */
	    public boolean hasReqNo()
	    {
		return ( ( bitField0_ & 0x00000010 ) == 0x00000010 );
	    }

	    /**
	     * <code>required int32 reqNo = 5;</code>
	     * 
	     * <pre>
	     * 请求顺序号
	     * </pre>
	     */
	    public int getReqNo()
	    {
		return reqNo_;
	    }

	    /**
	     * <code>required int32 reqNo = 5;</code>
	     * 
	     * <pre>
	     * 请求顺序号
	     * </pre>
	     */
	    public Builder setReqNo( int value )
	    {
		bitField0_ |= 0x00000010;
		reqNo_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required int32 reqNo = 5;</code>
	     * 
	     * <pre>
	     * 请求顺序号
	     * </pre>
	     */
	    public Builder clearReqNo()
	    {
		bitField0_ = ( bitField0_ & ~0x00000010 );
		reqNo_ = 0;
		onChanged( );
		return this;
	    }

	    // optional int32 chnNo = 6;
	    private int chnNo_;

	    /**
	     * <code>optional int32 chnNo = 6;</code>
	     * 
	     * <pre>
	     * 渠道号（由后台分配给渠道并传入，默认为0）
	     * </pre>
	     */
	    public boolean hasChnNo()
	    {
		return ( ( bitField0_ & 0x00000020 ) == 0x00000020 );
	    }

	    /**
	     * <code>optional int32 chnNo = 6;</code>
	     * 
	     * <pre>
	     * 渠道号（由后台分配给渠道并传入，默认为0）
	     * </pre>
	     */
	    public int getChnNo()
	    {
		return chnNo_;
	    }

	    /**
	     * <code>optional int32 chnNo = 6;</code>
	     * 
	     * <pre>
	     * 渠道号（由后台分配给渠道并传入，默认为0）
	     * </pre>
	     */
	    public Builder setChnNo( int value )
	    {
		bitField0_ |= 0x00000020;
		chnNo_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional int32 chnNo = 6;</code>
	     * 
	     * <pre>
	     * 渠道号（由后台分配给渠道并传入，默认为0）
	     * </pre>
	     */
	    public Builder clearChnNo()
	    {
		bitField0_ = ( bitField0_ & ~0x00000020 );
		chnNo_ = 0;
		onChanged( );
		return this;
	    }

	    // optional int32 chnPos = 7;
	    private int chnPos_;

	    /**
	     * <code>optional int32 chnPos = 7;</code>
	     * 
	     * <pre>
	     * 渠道位置（由后台分配给渠道或SDK传入，确定如：广告位第二个广告等位置信息，默认为0。又如帐号中心，可能会有多个位置可以跳游戏中心，渠道位置会不一样）
	     * </pre>
	     */
	    public boolean hasChnPos()
	    {
		return ( ( bitField0_ & 0x00000040 ) == 0x00000040 );
	    }

	    /**
	     * <code>optional int32 chnPos = 7;</code>
	     * 
	     * <pre>
	     * 渠道位置（由后台分配给渠道或SDK传入，确定如：广告位第二个广告等位置信息，默认为0。又如帐号中心，可能会有多个位置可以跳游戏中心，渠道位置会不一样）
	     * </pre>
	     */
	    public int getChnPos()
	    {
		return chnPos_;
	    }

	    /**
	     * <code>optional int32 chnPos = 7;</code>
	     * 
	     * <pre>
	     * 渠道位置（由后台分配给渠道或SDK传入，确定如：广告位第二个广告等位置信息，默认为0。又如帐号中心，可能会有多个位置可以跳游戏中心，渠道位置会不一样）
	     * </pre>
	     */
	    public Builder setChnPos( int value )
	    {
		bitField0_ |= 0x00000040;
		chnPos_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional int32 chnPos = 7;</code>
	     * 
	     * <pre>
	     * 渠道位置（由后台分配给渠道或SDK传入，确定如：广告位第二个广告等位置信息，默认为0。又如帐号中心，可能会有多个位置可以跳游戏中心，渠道位置会不一样）
	     * </pre>
	     */
	    public Builder clearChnPos()
	    {
		bitField0_ = ( bitField0_ & ~0x00000040 );
		chnPos_ = 0;
		onChanged( );
		return this;
	    }

	    // required int32 clientId = 8;
	    private int clientId_;

	    /**
	     * <code>required int32 clientId = 8;</code>
	     * 
	     * <pre>
	     * 应用的ID（直接与服务端沟通的应用的ID）(定义: 1=帐号账户 , 2= 应用商店 , 3= PcSuite, 4= 桌面)
	     * </pre>
	     */
	    public boolean hasClientId()
	    {
		return ( ( bitField0_ & 0x00000080 ) == 0x00000080 );
	    }

	    /**
	     * <code>required int32 clientId = 8;</code>
	     * 
	     * <pre>
	     * 应用的ID（直接与服务端沟通的应用的ID）(定义: 1=帐号账户 , 2= 应用商店 , 3= PcSuite, 4= 桌面)
	     * </pre>
	     */
	    public int getClientId()
	    {
		return clientId_;
	    }

	    /**
	     * <code>required int32 clientId = 8;</code>
	     * 
	     * <pre>
	     * 应用的ID（直接与服务端沟通的应用的ID）(定义: 1=帐号账户 , 2= 应用商店 , 3= PcSuite, 4= 桌面)
	     * </pre>
	     */
	    public Builder setClientId( int value )
	    {
		bitField0_ |= 0x00000080;
		clientId_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required int32 clientId = 8;</code>
	     * 
	     * <pre>
	     * 应用的ID（直接与服务端沟通的应用的ID）(定义: 1=帐号账户 , 2= 应用商店 , 3= PcSuite, 4= 桌面)
	     * </pre>
	     */
	    public Builder clearClientId()
	    {
		bitField0_ = ( bitField0_ & ~0x00000080 );
		clientId_ = 0;
		onChanged( );
		return this;
	    }

	    // optional int32 clientPos = 9;
	    private int clientPos_;

	    /**
	     * <code>optional int32 clientPos = 9;</code>
	     * 
	     * <pre>
	     * 应用的位置（直接与服务端沟通的应用的位置ID，与渠道位置类似）
	     * </pre>
	     */
	    public boolean hasClientPos()
	    {
		return ( ( bitField0_ & 0x00000100 ) == 0x00000100 );
	    }

	    /**
	     * <code>optional int32 clientPos = 9;</code>
	     * 
	     * <pre>
	     * 应用的位置（直接与服务端沟通的应用的位置ID，与渠道位置类似）
	     * </pre>
	     */
	    public int getClientPos()
	    {
		return clientPos_;
	    }

	    /**
	     * <code>optional int32 clientPos = 9;</code>
	     * 
	     * <pre>
	     * 应用的位置（直接与服务端沟通的应用的位置ID，与渠道位置类似）
	     * </pre>
	     */
	    public Builder setClientPos( int value )
	    {
		bitField0_ |= 0x00000100;
		clientPos_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional int32 clientPos = 9;</code>
	     * 
	     * <pre>
	     * 应用的位置（直接与服务端沟通的应用的位置ID，与渠道位置类似）
	     * </pre>
	     */
	    public Builder clearClientPos()
	    {
		bitField0_ = ( bitField0_ & ~0x00000100 );
		clientPos_ = 0;
		onChanged( );
		return this;
	    }

	    // optional string clientVer = 10;
	    private java.lang.Object clientVer_ = "";

	    /**
	     * <code>optional string clientVer = 10;</code>
	     * 
	     * <pre>
	     * 应用的版本（应用的版本由通用的版本号规则定义）
	     * </pre>
	     */
	    public boolean hasClientVer()
	    {
		return ( ( bitField0_ & 0x00000200 ) == 0x00000200 );
	    }

	    /**
	     * <code>optional string clientVer = 10;</code>
	     * 
	     * <pre>
	     * 应用的版本（应用的版本由通用的版本号规则定义）
	     * </pre>
	     */
	    public java.lang.String getClientVer()
	    {
		java.lang.Object ref = clientVer_;
		if( ! ( ref instanceof java.lang.String ) )
		{
		    java.lang.String s = ( (com.google.protobuf.ByteString)ref ).toStringUtf8( );
		    clientVer_ = s;
		    return s;
		}
		else
		{
		    return (java.lang.String)ref;
		}
	    }

	    /**
	     * <code>optional string clientVer = 10;</code>
	     * 
	     * <pre>
	     * 应用的版本（应用的版本由通用的版本号规则定义）
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getClientVerBytes()
	    {
		java.lang.Object ref = clientVer_;
		if( ref instanceof String )
		{
		    com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		    clientVer_ = b;
		    return b;
		}
		else
		{
		    return (com.google.protobuf.ByteString)ref;
		}
	    }

	    /**
	     * <code>optional string clientVer = 10;</code>
	     * 
	     * <pre>
	     * 应用的版本（应用的版本由通用的版本号规则定义）
	     * </pre>
	     */
	    public Builder setClientVer( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000200;
		clientVer_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional string clientVer = 10;</code>
	     * 
	     * <pre>
	     * 应用的版本（应用的版本由通用的版本号规则定义）
	     * </pre>
	     */
	    public Builder clearClientVer()
	    {
		bitField0_ = ( bitField0_ & ~0x00000200 );
		clientVer_ = getDefaultInstance( ).getClientVer( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional string clientVer = 10;</code>
	     * 
	     * <pre>
	     * 应用的版本（应用的版本由通用的版本号规则定义）
	     * </pre>
	     */
	    public Builder setClientVerBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000200;
		clientVer_ = value;
		onChanged( );
		return this;
	    }

	    // optional string rsaKeyVer = 11;
	    private java.lang.Object rsaKeyVer_ = "";

	    /**
	     * <code>optional string rsaKeyVer = 11;</code>
	     * 
	     * <pre>
	     * 当前程序的RSA - KEY的版本标识
	     * </pre>
	     */
	    public boolean hasRsaKeyVer()
	    {
		return ( ( bitField0_ & 0x00000400 ) == 0x00000400 );
	    }

	    /**
	     * <code>optional string rsaKeyVer = 11;</code>
	     * 
	     * <pre>
	     * 当前程序的RSA - KEY的版本标识
	     * </pre>
	     */
	    public java.lang.String getRsaKeyVer()
	    {
		java.lang.Object ref = rsaKeyVer_;
		if( ! ( ref instanceof java.lang.String ) )
		{
		    java.lang.String s = ( (com.google.protobuf.ByteString)ref ).toStringUtf8( );
		    rsaKeyVer_ = s;
		    return s;
		}
		else
		{
		    return (java.lang.String)ref;
		}
	    }

	    /**
	     * <code>optional string rsaKeyVer = 11;</code>
	     * 
	     * <pre>
	     * 当前程序的RSA - KEY的版本标识
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getRsaKeyVerBytes()
	    {
		java.lang.Object ref = rsaKeyVer_;
		if( ref instanceof String )
		{
		    com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		    rsaKeyVer_ = b;
		    return b;
		}
		else
		{
		    return (com.google.protobuf.ByteString)ref;
		}
	    }

	    /**
	     * <code>optional string rsaKeyVer = 11;</code>
	     * 
	     * <pre>
	     * 当前程序的RSA - KEY的版本标识
	     * </pre>
	     */
	    public Builder setRsaKeyVer( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000400;
		rsaKeyVer_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional string rsaKeyVer = 11;</code>
	     * 
	     * <pre>
	     * 当前程序的RSA - KEY的版本标识
	     * </pre>
	     */
	    public Builder clearRsaKeyVer()
	    {
		bitField0_ = ( bitField0_ & ~0x00000400 );
		rsaKeyVer_ = getDefaultInstance( ).getRsaKeyVer( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional string rsaKeyVer = 11;</code>
	     * 
	     * <pre>
	     * 当前程序的RSA - KEY的版本标识
	     * </pre>
	     */
	    public Builder setRsaKeyVerBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000400;
		rsaKeyVer_ = value;
		onChanged( );
		return this;
	    }

	    // @@protoc_insertion_point(builder_scope:ReqPacket)
	}

	static
	{
	    defaultInstance = new ReqPacket( true );
	    defaultInstance.initFields( );
	}

	// @@protoc_insertion_point(class_scope:ReqPacket)
    }

    public interface RspPacketOrBuilder extends com.google.protobuf.MessageOrBuilder
    {

	// required int32 mask = 1;
	/**
	 * <code>required int32 mask = 1;</code>
	 * 
	 * <pre>
	 * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	 * </pre>
	 */
	boolean hasMask();

	/**
	 * <code>required int32 mask = 1;</code>
	 * 
	 * <pre>
	 * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	 * </pre>
	 */
	int getMask();

	// required int32 rescode = 2;
	/**
	 * <code>required int32 rescode = 2;</code>
	 * 
	 * <pre>
	 * 响应码（定义：0=成功-至少有一个响应的Action，100=异常错误...）
	 * </pre>
	 */
	boolean hasRescode();

	/**
	 * <code>required int32 rescode = 2;</code>
	 * 
	 * <pre>
	 * 响应码（定义：0=成功-至少有一个响应的Action，100=异常错误...）
	 * </pre>
	 */
	int getRescode();

	// required string resmsg = 3;
	/**
	 * <code>required string resmsg = 3;</code>
	 * 
	 * <pre>
	 * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	 * </pre>
	 */
	boolean hasResmsg();

	/**
	 * <code>required string resmsg = 3;</code>
	 * 
	 * <pre>
	 * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	 * </pre>
	 */
	java.lang.String getResmsg();

	/**
	 * <code>required string resmsg = 3;</code>
	 * 
	 * <pre>
	 * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	 * </pre>
	 */
	com.google.protobuf.ByteString getResmsgBytes();

	// repeated string action = 4;
	/**
	 * <code>repeated string action = 4;</code>
	 * 
	 * <pre>
	 * 响应操作
	 * </pre>
	 */
	java.util.List< java.lang.String > getActionList();

	/**
	 * <code>repeated string action = 4;</code>
	 * 
	 * <pre>
	 * 响应操作
	 * </pre>
	 */
	int getActionCount();

	/**
	 * <code>repeated string action = 4;</code>
	 * 
	 * <pre>
	 * 响应操作
	 * </pre>
	 */
	java.lang.String getAction( int index );

	/**
	 * <code>repeated string action = 4;</code>
	 * 
	 * <pre>
	 * 响应操作
	 * </pre>
	 */
	com.google.protobuf.ByteString getActionBytes( int index );

	// repeated bytes params = 5;
	/**
	 * <code>repeated bytes params = 5;</code>
	 * 
	 * <pre>
	 * 响应参数
	 * </pre>
	 */
	java.util.List< com.google.protobuf.ByteString > getParamsList();

	/**
	 * <code>repeated bytes params = 5;</code>
	 * 
	 * <pre>
	 * 响应参数
	 * </pre>
	 */
	int getParamsCount();

	/**
	 * <code>repeated bytes params = 5;</code>
	 * 
	 * <pre>
	 * 响应参数
	 * </pre>
	 */
	com.google.protobuf.ByteString getParams( int index );
    }

    /**
     * Protobuf type {@code RspPacket}
     */
    public static final class RspPacket extends com.google.protobuf.GeneratedMessage implements RspPacketOrBuilder
    {
	// Use RspPacket.newBuilder() to construct.
	private RspPacket( com.google.protobuf.GeneratedMessage.Builder< ? > builder )
	{
	    super( builder );
	    this.unknownFields = builder.getUnknownFields( );
	}

	private RspPacket( boolean noInit )
	{
	    this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance( );
	}

	private static final RspPacket defaultInstance;

	public static RspPacket getDefaultInstance()
	{
	    return defaultInstance;
	}

	public RspPacket getDefaultInstanceForType()
	{
	    return defaultInstance;
	}

	private final com.google.protobuf.UnknownFieldSet unknownFields;

	@java.lang.Override
	public final com.google.protobuf.UnknownFieldSet getUnknownFields()
	{
	    return this.unknownFields;
	}

	private RspPacket( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    initFields( );
	    int mutable_bitField0_ = 0;
	    com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet.newBuilder( );
	    try
	    {
		boolean done = false;
		while ( !done )
		{
		    int tag = input.readTag( );
		    switch ( tag )
		    {
			case 0 :
			    done = true;
			    break;
			default :
			{
			    if( !parseUnknownField( input , unknownFields , extensionRegistry , tag ) )
			    {
				done = true;
			    }
			    break;
			}
			case 8 :
			{
			    bitField0_ |= 0x00000001;
			    mask_ = input.readInt32( );
			    break;
			}
			case 16 :
			{
			    bitField0_ |= 0x00000002;
			    rescode_ = input.readInt32( );
			    break;
			}
			case 26 :
			{
			    bitField0_ |= 0x00000004;
			    resmsg_ = input.readBytes( );
			    break;
			}
			case 34 :
			{
			    if( ! ( ( mutable_bitField0_ & 0x00000008 ) == 0x00000008 ) )
			    {
				action_ = new com.google.protobuf.LazyStringArrayList( );
				mutable_bitField0_ |= 0x00000008;
			    }
			    action_.add( input.readBytes( ) );
			    break;
			}
			case 42 :
			{
			    if( ! ( ( mutable_bitField0_ & 0x00000010 ) == 0x00000010 ) )
			    {
				params_ = new java.util.ArrayList< com.google.protobuf.ByteString >( );
				mutable_bitField0_ |= 0x00000010;
			    }
			    params_.add( input.readBytes( ) );
			    break;
			}
		    }
		}
	    }
	    catch ( com.google.protobuf.InvalidProtocolBufferException e )
	    {
		throw e.setUnfinishedMessage( this );
	    }
	    catch ( java.io.IOException e )
	    {
		throw new com.google.protobuf.InvalidProtocolBufferException( e.getMessage( ) ).setUnfinishedMessage( this );
	    }
	    finally
	    {
		if( ( ( mutable_bitField0_ & 0x00000008 ) == 0x00000008 ) )
		{
		    action_ = new com.google.protobuf.UnmodifiableLazyStringList( action_ );
		}
		if( ( ( mutable_bitField0_ & 0x00000010 ) == 0x00000010 ) )
		{
		    params_ = java.util.Collections.unmodifiableList( params_ );
		}
		this.unknownFields = unknownFields.build( );
		makeExtensionsImmutable( );
	    }
	}

	public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
	{
	    return Packet.internal_static_RspPacket_descriptor;
	}

	protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	{
	    return Packet.internal_static_RspPacket_fieldAccessorTable.ensureFieldAccessorsInitialized( Packet.RspPacket.class , Packet.RspPacket.Builder.class );
	}

	public static com.google.protobuf.Parser< RspPacket > PARSER = new com.google.protobuf.AbstractParser< RspPacket >( )
	{
	    public RspPacket parsePartialFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	    {
		return new RspPacket( input , extensionRegistry );
	    }
	};

	@java.lang.Override
	public com.google.protobuf.Parser< RspPacket > getParserForType()
	{
	    return PARSER;
	}

	private int bitField0_;
	// required int32 mask = 1;
	public static final int MASK_FIELD_NUMBER = 1;
	private int mask_;

	/**
	 * <code>required int32 mask = 1;</code>
	 * 
	 * <pre>
	 * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	 * </pre>
	 */
	public boolean hasMask()
	{
	    return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	}

	/**
	 * <code>required int32 mask = 1;</code>
	 * 
	 * <pre>
	 * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	 * </pre>
	 */
	public int getMask()
	{
	    return mask_;
	}

	// required int32 rescode = 2;
	public static final int RESCODE_FIELD_NUMBER = 2;
	private int rescode_;

	/**
	 * <code>required int32 rescode = 2;</code>
	 * 
	 * <pre>
	 * 响应码（定义：0=成功-至少有一个响应的Action，100=异常错误...）
	 * </pre>
	 */
	public boolean hasRescode()
	{
	    return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	}

	/**
	 * <code>required int32 rescode = 2;</code>
	 * 
	 * <pre>
	 * 响应码（定义：0=成功-至少有一个响应的Action，100=异常错误...）
	 * </pre>
	 */
	public int getRescode()
	{
	    return rescode_;
	}

	// required string resmsg = 3;
	public static final int RESMSG_FIELD_NUMBER = 3;
	private java.lang.Object resmsg_;

	/**
	 * <code>required string resmsg = 3;</code>
	 * 
	 * <pre>
	 * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	 * </pre>
	 */
	public boolean hasResmsg()
	{
	    return ( ( bitField0_ & 0x00000004 ) == 0x00000004 );
	}

	/**
	 * <code>required string resmsg = 3;</code>
	 * 
	 * <pre>
	 * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	 * </pre>
	 */
	public java.lang.String getResmsg()
	{
	    java.lang.Object ref = resmsg_;
	    if( ref instanceof java.lang.String )
	    {
		return (java.lang.String)ref;
	    }
	    else
	    {
		com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString)ref;
		java.lang.String s = bs.toStringUtf8( );
		if( bs.isValidUtf8( ) )
		{
		    resmsg_ = s;
		}
		return s;
	    }
	}

	/**
	 * <code>required string resmsg = 3;</code>
	 * 
	 * <pre>
	 * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	 * </pre>
	 */
	public com.google.protobuf.ByteString getResmsgBytes()
	{
	    java.lang.Object ref = resmsg_;
	    if( ref instanceof java.lang.String )
	    {
		com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		resmsg_ = b;
		return b;
	    }
	    else
	    {
		return (com.google.protobuf.ByteString)ref;
	    }
	}

	// repeated string action = 4;
	public static final int ACTION_FIELD_NUMBER = 4;
	private com.google.protobuf.LazyStringList action_;

	/**
	 * <code>repeated string action = 4;</code>
	 * 
	 * <pre>
	 * 响应操作
	 * </pre>
	 */
	public java.util.List< java.lang.String > getActionList()
	{
	    return action_;
	}

	/**
	 * <code>repeated string action = 4;</code>
	 * 
	 * <pre>
	 * 响应操作
	 * </pre>
	 */
	public int getActionCount()
	{
	    return action_.size( );
	}

	/**
	 * <code>repeated string action = 4;</code>
	 * 
	 * <pre>
	 * 响应操作
	 * </pre>
	 */
	public java.lang.String getAction( int index )
	{
	    return action_.get( index );
	}

	/**
	 * <code>repeated string action = 4;</code>
	 * 
	 * <pre>
	 * 响应操作
	 * </pre>
	 */
	public com.google.protobuf.ByteString getActionBytes( int index )
	{
	    return action_.getByteString( index );
	}

	// repeated bytes params = 5;
	public static final int PARAMS_FIELD_NUMBER = 5;
	private java.util.List< com.google.protobuf.ByteString > params_;

	/**
	 * <code>repeated bytes params = 5;</code>
	 * 
	 * <pre>
	 * 响应参数
	 * </pre>
	 */
	public java.util.List< com.google.protobuf.ByteString > getParamsList()
	{
	    return params_;
	}

	/**
	 * <code>repeated bytes params = 5;</code>
	 * 
	 * <pre>
	 * 响应参数
	 * </pre>
	 */
	public int getParamsCount()
	{
	    return params_.size( );
	}

	/**
	 * <code>repeated bytes params = 5;</code>
	 * 
	 * <pre>
	 * 响应参数
	 * </pre>
	 */
	public com.google.protobuf.ByteString getParams( int index )
	{
	    return params_.get( index );
	}

	private void initFields()
	{
	    mask_ = 0;
	    rescode_ = 0;
	    resmsg_ = "";
	    action_ = com.google.protobuf.LazyStringArrayList.EMPTY;
	    params_ = java.util.Collections.emptyList( );
	}

	private byte memoizedIsInitialized = -1;

	public final boolean isInitialized()
	{
	    byte isInitialized = memoizedIsInitialized;
	    if( isInitialized != -1 )
		return isInitialized == 1;

	    if( !hasMask( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    if( !hasRescode( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    if( !hasResmsg( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    memoizedIsInitialized = 1;
	    return true;
	}

	public void writeTo( com.google.protobuf.CodedOutputStream output ) throws java.io.IOException
	{
	    getSerializedSize( );
	    if( ( ( bitField0_ & 0x00000001 ) == 0x00000001 ) )
	    {
		output.writeInt32( 1 , mask_ );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		output.writeInt32( 2 , rescode_ );
	    }
	    if( ( ( bitField0_ & 0x00000004 ) == 0x00000004 ) )
	    {
		output.writeBytes( 3 , getResmsgBytes( ) );
	    }
	    for( int i = 0 ; i < action_.size( ) ; i++ )
	    {
		output.writeBytes( 4 , action_.getByteString( i ) );
	    }
	    for( int i = 0 ; i < params_.size( ) ; i++ )
	    {
		output.writeBytes( 5 , params_.get( i ) );
	    }
	    getUnknownFields( ).writeTo( output );
	}

	private int memoizedSerializedSize = -1;

	public int getSerializedSize()
	{
	    int size = memoizedSerializedSize;
	    if( size != -1 )
		return size;

	    size = 0;
	    if( ( ( bitField0_ & 0x00000001 ) == 0x00000001 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 1 , mask_ );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 2 , rescode_ );
	    }
	    if( ( ( bitField0_ & 0x00000004 ) == 0x00000004 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 3 , getResmsgBytes( ) );
	    }
	    {
		int dataSize = 0;
		for( int i = 0 ; i < action_.size( ) ; i++ )
		{
		    dataSize += com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag( action_.getByteString( i ) );
		}
		size += dataSize;
		size += 1 * getActionList( ).size( );
	    }
	    {
		int dataSize = 0;
		for( int i = 0 ; i < params_.size( ) ; i++ )
		{
		    dataSize += com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag( params_.get( i ) );
		}
		size += dataSize;
		size += 1 * getParamsList( ).size( );
	    }
	    size += getUnknownFields( ).getSerializedSize( );
	    memoizedSerializedSize = size;
	    return size;
	}

	private static final long serialVersionUID = 0L;

	@java.lang.Override
	protected java.lang.Object writeReplace() throws java.io.ObjectStreamException
	{
	    return super.writeReplace( );
	}

	public static Packet.RspPacket parseFrom( com.google.protobuf.ByteString data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Packet.RspPacket parseFrom( com.google.protobuf.ByteString data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Packet.RspPacket parseFrom( byte [] data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Packet.RspPacket parseFrom( byte [] data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Packet.RspPacket parseFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Packet.RspPacket parseFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input , extensionRegistry );
	}

	public static Packet.RspPacket parseDelimitedFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input );
	}

	public static Packet.RspPacket parseDelimitedFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input , extensionRegistry );
	}

	public static Packet.RspPacket parseFrom( com.google.protobuf.CodedInputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Packet.RspPacket parseFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input , extensionRegistry );
	}

	public static Builder newBuilder()
	{
	    return Builder.create( );
	}

	public Builder newBuilderForType()
	{
	    return newBuilder( );
	}

	public static Builder newBuilder( Packet.RspPacket prototype )
	{
	    return newBuilder( ).mergeFrom( prototype );
	}

	public Builder toBuilder()
	{
	    return newBuilder( this );
	}

	@java.lang.Override
	protected Builder newBuilderForType( com.google.protobuf.GeneratedMessage.BuilderParent parent )
	{
	    Builder builder = new Builder( parent );
	    return builder;
	}

	/**
	 * Protobuf type {@code RspPacket}
	 */
	public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder< Builder > implements Packet.RspPacketOrBuilder
	{
	    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
	    {
		return Packet.internal_static_RspPacket_descriptor;
	    }

	    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	    {
		return Packet.internal_static_RspPacket_fieldAccessorTable.ensureFieldAccessorsInitialized( Packet.RspPacket.class , Packet.RspPacket.Builder.class );
	    }

	    // Construct using Packet.RspPacket.newBuilder()
	    private Builder()
	    {
		maybeForceBuilderInitialization( );
	    }

	    private Builder( com.google.protobuf.GeneratedMessage.BuilderParent parent )
	    {
		super( parent );
		maybeForceBuilderInitialization( );
	    }

	    private void maybeForceBuilderInitialization()
	    {
		if( com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders )
		{}
	    }

	    private static Builder create()
	    {
		return new Builder( );
	    }

	    public Builder clear()
	    {
		super.clear( );
		mask_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000001 );
		rescode_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000002 );
		resmsg_ = "";
		bitField0_ = ( bitField0_ & ~0x00000004 );
		action_ = com.google.protobuf.LazyStringArrayList.EMPTY;
		bitField0_ = ( bitField0_ & ~0x00000008 );
		params_ = java.util.Collections.emptyList( );
		bitField0_ = ( bitField0_ & ~0x00000010 );
		return this;
	    }

	    public Builder clone()
	    {
		return create( ).mergeFrom( buildPartial( ) );
	    }

	    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
	    {
		return Packet.internal_static_RspPacket_descriptor;
	    }

	    public Packet.RspPacket getDefaultInstanceForType()
	    {
		return Packet.RspPacket.getDefaultInstance( );
	    }

	    public Packet.RspPacket build()
	    {
		Packet.RspPacket result = buildPartial( );
		if( !result.isInitialized( ) )
		{
		    throw newUninitializedMessageException( result );
		}
		return result;
	    }

	    public Packet.RspPacket buildPartial()
	    {
		Packet.RspPacket result = new Packet.RspPacket( this );
		int from_bitField0_ = bitField0_;
		int to_bitField0_ = 0;
		if( ( ( from_bitField0_ & 0x00000001 ) == 0x00000001 ) )
		{
		    to_bitField0_ |= 0x00000001;
		}
		result.mask_ = mask_;
		if( ( ( from_bitField0_ & 0x00000002 ) == 0x00000002 ) )
		{
		    to_bitField0_ |= 0x00000002;
		}
		result.rescode_ = rescode_;
		if( ( ( from_bitField0_ & 0x00000004 ) == 0x00000004 ) )
		{
		    to_bitField0_ |= 0x00000004;
		}
		result.resmsg_ = resmsg_;
		if( ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
		{
		    action_ = new com.google.protobuf.UnmodifiableLazyStringList( action_ );
		    bitField0_ = ( bitField0_ & ~0x00000008 );
		}
		result.action_ = action_;
		if( ( ( bitField0_ & 0x00000010 ) == 0x00000010 ) )
		{
		    params_ = java.util.Collections.unmodifiableList( params_ );
		    bitField0_ = ( bitField0_ & ~0x00000010 );
		}
		result.params_ = params_;
		result.bitField0_ = to_bitField0_;
		onBuilt( );
		return result;
	    }

	    public Builder mergeFrom( com.google.protobuf.Message other )
	    {
		if( other instanceof Packet.RspPacket )
		{
		    return mergeFrom( (Packet.RspPacket)other );
		}
		else
		{
		    super.mergeFrom( other );
		    return this;
		}
	    }

	    public Builder mergeFrom( Packet.RspPacket other )
	    {
		if( other == Packet.RspPacket.getDefaultInstance( ) )
		    return this;
		if( other.hasMask( ) )
		{
		    setMask( other.getMask( ) );
		}
		if( other.hasRescode( ) )
		{
		    setRescode( other.getRescode( ) );
		}
		if( other.hasResmsg( ) )
		{
		    bitField0_ |= 0x00000004;
		    resmsg_ = other.resmsg_;
		    onChanged( );
		}
		if( !other.action_.isEmpty( ) )
		{
		    if( action_.isEmpty( ) )
		    {
			action_ = other.action_;
			bitField0_ = ( bitField0_ & ~0x00000008 );
		    }
		    else
		    {
			ensureActionIsMutable( );
			action_.addAll( other.action_ );
		    }
		    onChanged( );
		}
		if( !other.params_.isEmpty( ) )
		{
		    if( params_.isEmpty( ) )
		    {
			params_ = other.params_;
			bitField0_ = ( bitField0_ & ~0x00000010 );
		    }
		    else
		    {
			ensureParamsIsMutable( );
			params_.addAll( other.params_ );
		    }
		    onChanged( );
		}
		this.mergeUnknownFields( other.getUnknownFields( ) );
		return this;
	    }

	    public final boolean isInitialized()
	    {
		if( !hasMask( ) )
		{

		    return false;
		}
		if( !hasRescode( ) )
		{

		    return false;
		}
		if( !hasResmsg( ) )
		{

		    return false;
		}
		return true;
	    }

	    public Builder mergeFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	    {
		Packet.RspPacket parsedMessage = null;
		try
		{
		    parsedMessage = PARSER.parsePartialFrom( input , extensionRegistry );
		}
		catch ( com.google.protobuf.InvalidProtocolBufferException e )
		{
		    parsedMessage = (Packet.RspPacket)e.getUnfinishedMessage( );
		    throw e;
		}
		finally
		{
		    if( parsedMessage != null )
		    {
			mergeFrom( parsedMessage );
		    }
		}
		return this;
	    }

	    private int bitField0_;

	    // required int32 mask = 1;
	    private int mask_;

	    /**
	     * <code>required int32 mask = 1;</code>
	     * 
	     * <pre>
	     * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	     * </pre>
	     */
	    public boolean hasMask()
	    {
		return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	    }

	    /**
	     * <code>required int32 mask = 1;</code>
	     * 
	     * <pre>
	     * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	     * </pre>
	     */
	    public int getMask()
	    {
		return mask_;
	    }

	    /**
	     * <code>required int32 mask = 1;</code>
	     * 
	     * <pre>
	     * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	     * </pre>
	     */
	    public Builder setMask( int value )
	    {
		bitField0_ |= 0x00000001;
		mask_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required int32 mask = 1;</code>
	     * 
	     * <pre>
	     * 掩码值（定义：1=params_gzip，2=params_rsa...位运算）
	     * </pre>
	     */
	    public Builder clearMask()
	    {
		bitField0_ = ( bitField0_ & ~0x00000001 );
		mask_ = 0;
		onChanged( );
		return this;
	    }

	    // required int32 rescode = 2;
	    private int rescode_;

	    /**
	     * <code>required int32 rescode = 2;</code>
	     * 
	     * <pre>
	     * 响应码（定义：0=成功-至少有一个响应的Action，100=异常错误...）
	     * </pre>
	     */
	    public boolean hasRescode()
	    {
		return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	    }

	    /**
	     * <code>required int32 rescode = 2;</code>
	     * 
	     * <pre>
	     * 响应码（定义：0=成功-至少有一个响应的Action，100=异常错误...）
	     * </pre>
	     */
	    public int getRescode()
	    {
		return rescode_;
	    }

	    /**
	     * <code>required int32 rescode = 2;</code>
	     * 
	     * <pre>
	     * 响应码（定义：0=成功-至少有一个响应的Action，100=异常错误...）
	     * </pre>
	     */
	    public Builder setRescode( int value )
	    {
		bitField0_ |= 0x00000002;
		rescode_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required int32 rescode = 2;</code>
	     * 
	     * <pre>
	     * 响应码（定义：0=成功-至少有一个响应的Action，100=异常错误...）
	     * </pre>
	     */
	    public Builder clearRescode()
	    {
		bitField0_ = ( bitField0_ & ~0x00000002 );
		rescode_ = 0;
		onChanged( );
		return this;
	    }

	    // required string resmsg = 3;
	    private java.lang.Object resmsg_ = "";

	    /**
	     * <code>required string resmsg = 3;</code>
	     * 
	     * <pre>
	     * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	     * </pre>
	     */
	    public boolean hasResmsg()
	    {
		return ( ( bitField0_ & 0x00000004 ) == 0x00000004 );
	    }

	    /**
	     * <code>required string resmsg = 3;</code>
	     * 
	     * <pre>
	     * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	     * </pre>
	     */
	    public java.lang.String getResmsg()
	    {
		java.lang.Object ref = resmsg_;
		if( ! ( ref instanceof java.lang.String ) )
		{
		    java.lang.String s = ( (com.google.protobuf.ByteString)ref ).toStringUtf8( );
		    resmsg_ = s;
		    return s;
		}
		else
		{
		    return (java.lang.String)ref;
		}
	    }

	    /**
	     * <code>required string resmsg = 3;</code>
	     * 
	     * <pre>
	     * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getResmsgBytes()
	    {
		java.lang.Object ref = resmsg_;
		if( ref instanceof String )
		{
		    com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		    resmsg_ = b;
		    return b;
		}
		else
		{
		    return (com.google.protobuf.ByteString)ref;
		}
	    }

	    /**
	     * <code>required string resmsg = 3;</code>
	     * 
	     * <pre>
	     * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	     * </pre>
	     */
	    public Builder setResmsg( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000004;
		resmsg_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string resmsg = 3;</code>
	     * 
	     * <pre>
	     * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	     * </pre>
	     */
	    public Builder clearResmsg()
	    {
		bitField0_ = ( bitField0_ & ~0x00000004 );
		resmsg_ = getDefaultInstance( ).getResmsg( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string resmsg = 3;</code>
	     * 
	     * <pre>
	     * 响应消息（成功或失败消息，不为空时则由客户端统一提示）
	     * </pre>
	     */
	    public Builder setResmsgBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000004;
		resmsg_ = value;
		onChanged( );
		return this;
	    }

	    // repeated string action = 4;
	    private com.google.protobuf.LazyStringList action_ = com.google.protobuf.LazyStringArrayList.EMPTY;

	    private void ensureActionIsMutable()
	    {
		if( ! ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
		{
		    action_ = new com.google.protobuf.LazyStringArrayList( action_ );
		    bitField0_ |= 0x00000008;
		}
	    }

	    /**
	     * <code>repeated string action = 4;</code>
	     * 
	     * <pre>
	     * 响应操作
	     * </pre>
	     */
	    public java.util.List< java.lang.String > getActionList()
	    {
		return java.util.Collections.unmodifiableList( action_ );
	    }

	    /**
	     * <code>repeated string action = 4;</code>
	     * 
	     * <pre>
	     * 响应操作
	     * </pre>
	     */
	    public int getActionCount()
	    {
		return action_.size( );
	    }

	    /**
	     * <code>repeated string action = 4;</code>
	     * 
	     * <pre>
	     * 响应操作
	     * </pre>
	     */
	    public java.lang.String getAction( int index )
	    {
		return action_.get( index );
	    }

	    /**
	     * <code>repeated string action = 4;</code>
	     * 
	     * <pre>
	     * 响应操作
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getActionBytes( int index )
	    {
		return action_.getByteString( index );
	    }

	    /**
	     * <code>repeated string action = 4;</code>
	     * 
	     * <pre>
	     * 响应操作
	     * </pre>
	     */
	    public Builder setAction( int index , java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureActionIsMutable( );
		action_.set( index , value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string action = 4;</code>
	     * 
	     * <pre>
	     * 响应操作
	     * </pre>
	     */
	    public Builder addAction( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureActionIsMutable( );
		action_.add( value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string action = 4;</code>
	     * 
	     * <pre>
	     * 响应操作
	     * </pre>
	     */
	    public Builder addAllAction( java.lang.Iterable< java.lang.String > values )
	    {
		ensureActionIsMutable( );
		super.addAll( values , action_ );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string action = 4;</code>
	     * 
	     * <pre>
	     * 响应操作
	     * </pre>
	     */
	    public Builder clearAction()
	    {
		action_ = com.google.protobuf.LazyStringArrayList.EMPTY;
		bitField0_ = ( bitField0_ & ~0x00000008 );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string action = 4;</code>
	     * 
	     * <pre>
	     * 响应操作
	     * </pre>
	     */
	    public Builder addActionBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureActionIsMutable( );
		action_.add( value );
		onChanged( );
		return this;
	    }

	    // repeated bytes params = 5;
	    private java.util.List< com.google.protobuf.ByteString > params_ = java.util.Collections.emptyList( );

	    private void ensureParamsIsMutable()
	    {
		if( ! ( ( bitField0_ & 0x00000010 ) == 0x00000010 ) )
		{
		    params_ = new java.util.ArrayList< com.google.protobuf.ByteString >( params_ );
		    bitField0_ |= 0x00000010;
		}
	    }

	    /**
	     * <code>repeated bytes params = 5;</code>
	     * 
	     * <pre>
	     * 响应参数
	     * </pre>
	     */
	    public java.util.List< com.google.protobuf.ByteString > getParamsList()
	    {
		return java.util.Collections.unmodifiableList( params_ );
	    }

	    /**
	     * <code>repeated bytes params = 5;</code>
	     * 
	     * <pre>
	     * 响应参数
	     * </pre>
	     */
	    public int getParamsCount()
	    {
		return params_.size( );
	    }

	    /**
	     * <code>repeated bytes params = 5;</code>
	     * 
	     * <pre>
	     * 响应参数
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getParams( int index )
	    {
		return params_.get( index );
	    }

	    /**
	     * <code>repeated bytes params = 5;</code>
	     * 
	     * <pre>
	     * 响应参数
	     * </pre>
	     */
	    public Builder setParams( int index , com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureParamsIsMutable( );
		params_.set( index , value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated bytes params = 5;</code>
	     * 
	     * <pre>
	     * 响应参数
	     * </pre>
	     */
	    public Builder addParams( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureParamsIsMutable( );
		params_.add( value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated bytes params = 5;</code>
	     * 
	     * <pre>
	     * 响应参数
	     * </pre>
	     */
	    public Builder addAllParams( java.lang.Iterable< ? extends com.google.protobuf.ByteString > values )
	    {
		ensureParamsIsMutable( );
		super.addAll( values , params_ );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated bytes params = 5;</code>
	     * 
	     * <pre>
	     * 响应参数
	     * </pre>
	     */
	    public Builder clearParams()
	    {
		params_ = java.util.Collections.emptyList( );
		bitField0_ = ( bitField0_ & ~0x00000010 );
		onChanged( );
		return this;
	    }

	    // @@protoc_insertion_point(builder_scope:RspPacket)
	}

	static
	{
	    defaultInstance = new RspPacket( true );
	    defaultInstance.initFields( );
	}

	// @@protoc_insertion_point(class_scope:RspPacket)
    }

    public interface RspRsaKeyOrBuilder extends com.google.protobuf.MessageOrBuilder
    {

	// required string rsaVer = 1;
	/**
	 * <code>required string rsaVer = 1;</code>
	 * 
	 * <pre>
	 * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	 * </pre>
	 */
	boolean hasRsaVer();

	/**
	 * <code>required string rsaVer = 1;</code>
	 * 
	 * <pre>
	 * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	 * </pre>
	 */
	java.lang.String getRsaVer();

	/**
	 * <code>required string rsaVer = 1;</code>
	 * 
	 * <pre>
	 * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	 * </pre>
	 */
	com.google.protobuf.ByteString getRsaVerBytes();

	// required string rsaKey = 2;
	/**
	 * <code>required string rsaKey = 2;</code>
	 * 
	 * <pre>
	 * RSA-KEY ( 格式: n,e )
	 * </pre>
	 */
	boolean hasRsaKey();

	/**
	 * <code>required string rsaKey = 2;</code>
	 * 
	 * <pre>
	 * RSA-KEY ( 格式: n,e )
	 * </pre>
	 */
	java.lang.String getRsaKey();

	/**
	 * <code>required string rsaKey = 2;</code>
	 * 
	 * <pre>
	 * RSA-KEY ( 格式: n,e )
	 * </pre>
	 */
	com.google.protobuf.ByteString getRsaKeyBytes();
    }

    /**
     * Protobuf type {@code RspRsaKey}
     */
    public static final class RspRsaKey extends com.google.protobuf.GeneratedMessage implements RspRsaKeyOrBuilder
    {
	// Use RspRsaKey.newBuilder() to construct.
	private RspRsaKey( com.google.protobuf.GeneratedMessage.Builder< ? > builder )
	{
	    super( builder );
	    this.unknownFields = builder.getUnknownFields( );
	}

	private RspRsaKey( boolean noInit )
	{
	    this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance( );
	}

	private static final RspRsaKey defaultInstance;

	public static RspRsaKey getDefaultInstance()
	{
	    return defaultInstance;
	}

	public RspRsaKey getDefaultInstanceForType()
	{
	    return defaultInstance;
	}

	private final com.google.protobuf.UnknownFieldSet unknownFields;

	@java.lang.Override
	public final com.google.protobuf.UnknownFieldSet getUnknownFields()
	{
	    return this.unknownFields;
	}

	private RspRsaKey( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    initFields( );
	    com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet.newBuilder( );
	    try
	    {
		boolean done = false;
		while ( !done )
		{
		    int tag = input.readTag( );
		    switch ( tag )
		    {
			case 0 :
			    done = true;
			    break;
			default :
			{
			    if( !parseUnknownField( input , unknownFields , extensionRegistry , tag ) )
			    {
				done = true;
			    }
			    break;
			}
			case 10 :
			{
			    bitField0_ |= 0x00000001;
			    rsaVer_ = input.readBytes( );
			    break;
			}
			case 18 :
			{
			    bitField0_ |= 0x00000002;
			    rsaKey_ = input.readBytes( );
			    break;
			}
		    }
		}
	    }
	    catch ( com.google.protobuf.InvalidProtocolBufferException e )
	    {
		throw e.setUnfinishedMessage( this );
	    }
	    catch ( java.io.IOException e )
	    {
		throw new com.google.protobuf.InvalidProtocolBufferException( e.getMessage( ) ).setUnfinishedMessage( this );
	    }
	    finally
	    {
		this.unknownFields = unknownFields.build( );
		makeExtensionsImmutable( );
	    }
	}

	public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
	{
	    return Packet.internal_static_RspRsaKey_descriptor;
	}

	protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	{
	    return Packet.internal_static_RspRsaKey_fieldAccessorTable.ensureFieldAccessorsInitialized( Packet.RspRsaKey.class , Packet.RspRsaKey.Builder.class );
	}

	public static com.google.protobuf.Parser< RspRsaKey > PARSER = new com.google.protobuf.AbstractParser< RspRsaKey >( )
	{
	    public RspRsaKey parsePartialFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	    {
		return new RspRsaKey( input , extensionRegistry );
	    }
	};

	@java.lang.Override
	public com.google.protobuf.Parser< RspRsaKey > getParserForType()
	{
	    return PARSER;
	}

	private int bitField0_;
	// required string rsaVer = 1;
	public static final int RSAVER_FIELD_NUMBER = 1;
	private java.lang.Object rsaVer_;

	/**
	 * <code>required string rsaVer = 1;</code>
	 * 
	 * <pre>
	 * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	 * </pre>
	 */
	public boolean hasRsaVer()
	{
	    return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	}

	/**
	 * <code>required string rsaVer = 1;</code>
	 * 
	 * <pre>
	 * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	 * </pre>
	 */
	public java.lang.String getRsaVer()
	{
	    java.lang.Object ref = rsaVer_;
	    if( ref instanceof java.lang.String )
	    {
		return (java.lang.String)ref;
	    }
	    else
	    {
		com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString)ref;
		java.lang.String s = bs.toStringUtf8( );
		if( bs.isValidUtf8( ) )
		{
		    rsaVer_ = s;
		}
		return s;
	    }
	}

	/**
	 * <code>required string rsaVer = 1;</code>
	 * 
	 * <pre>
	 * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	 * </pre>
	 */
	public com.google.protobuf.ByteString getRsaVerBytes()
	{
	    java.lang.Object ref = rsaVer_;
	    if( ref instanceof java.lang.String )
	    {
		com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		rsaVer_ = b;
		return b;
	    }
	    else
	    {
		return (com.google.protobuf.ByteString)ref;
	    }
	}

	// required string rsaKey = 2;
	public static final int RSAKEY_FIELD_NUMBER = 2;
	private java.lang.Object rsaKey_;

	/**
	 * <code>required string rsaKey = 2;</code>
	 * 
	 * <pre>
	 * RSA-KEY ( 格式: n,e )
	 * </pre>
	 */
	public boolean hasRsaKey()
	{
	    return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	}

	/**
	 * <code>required string rsaKey = 2;</code>
	 * 
	 * <pre>
	 * RSA-KEY ( 格式: n,e )
	 * </pre>
	 */
	public java.lang.String getRsaKey()
	{
	    java.lang.Object ref = rsaKey_;
	    if( ref instanceof java.lang.String )
	    {
		return (java.lang.String)ref;
	    }
	    else
	    {
		com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString)ref;
		java.lang.String s = bs.toStringUtf8( );
		if( bs.isValidUtf8( ) )
		{
		    rsaKey_ = s;
		}
		return s;
	    }
	}

	/**
	 * <code>required string rsaKey = 2;</code>
	 * 
	 * <pre>
	 * RSA-KEY ( 格式: n,e )
	 * </pre>
	 */
	public com.google.protobuf.ByteString getRsaKeyBytes()
	{
	    java.lang.Object ref = rsaKey_;
	    if( ref instanceof java.lang.String )
	    {
		com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		rsaKey_ = b;
		return b;
	    }
	    else
	    {
		return (com.google.protobuf.ByteString)ref;
	    }
	}

	private void initFields()
	{
	    rsaVer_ = "";
	    rsaKey_ = "";
	}

	private byte memoizedIsInitialized = -1;

	public final boolean isInitialized()
	{
	    byte isInitialized = memoizedIsInitialized;
	    if( isInitialized != -1 )
		return isInitialized == 1;

	    if( !hasRsaVer( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    if( !hasRsaKey( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    memoizedIsInitialized = 1;
	    return true;
	}

	public void writeTo( com.google.protobuf.CodedOutputStream output ) throws java.io.IOException
	{
	    getSerializedSize( );
	    if( ( ( bitField0_ & 0x00000001 ) == 0x00000001 ) )
	    {
		output.writeBytes( 1 , getRsaVerBytes( ) );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		output.writeBytes( 2 , getRsaKeyBytes( ) );
	    }
	    getUnknownFields( ).writeTo( output );
	}

	private int memoizedSerializedSize = -1;

	public int getSerializedSize()
	{
	    int size = memoizedSerializedSize;
	    if( size != -1 )
		return size;

	    size = 0;
	    if( ( ( bitField0_ & 0x00000001 ) == 0x00000001 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 1 , getRsaVerBytes( ) );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 2 , getRsaKeyBytes( ) );
	    }
	    size += getUnknownFields( ).getSerializedSize( );
	    memoizedSerializedSize = size;
	    return size;
	}

	private static final long serialVersionUID = 0L;

	@java.lang.Override
	protected java.lang.Object writeReplace() throws java.io.ObjectStreamException
	{
	    return super.writeReplace( );
	}

	public static Packet.RspRsaKey parseFrom( com.google.protobuf.ByteString data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Packet.RspRsaKey parseFrom( com.google.protobuf.ByteString data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Packet.RspRsaKey parseFrom( byte [] data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Packet.RspRsaKey parseFrom( byte [] data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Packet.RspRsaKey parseFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Packet.RspRsaKey parseFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input , extensionRegistry );
	}

	public static Packet.RspRsaKey parseDelimitedFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input );
	}

	public static Packet.RspRsaKey parseDelimitedFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input , extensionRegistry );
	}

	public static Packet.RspRsaKey parseFrom( com.google.protobuf.CodedInputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Packet.RspRsaKey parseFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input , extensionRegistry );
	}

	public static Builder newBuilder()
	{
	    return Builder.create( );
	}

	public Builder newBuilderForType()
	{
	    return newBuilder( );
	}

	public static Builder newBuilder( Packet.RspRsaKey prototype )
	{
	    return newBuilder( ).mergeFrom( prototype );
	}

	public Builder toBuilder()
	{
	    return newBuilder( this );
	}

	@java.lang.Override
	protected Builder newBuilderForType( com.google.protobuf.GeneratedMessage.BuilderParent parent )
	{
	    Builder builder = new Builder( parent );
	    return builder;
	}

	/**
	 * Protobuf type {@code RspRsaKey}
	 */
	public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder< Builder > implements Packet.RspRsaKeyOrBuilder
	{
	    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
	    {
		return Packet.internal_static_RspRsaKey_descriptor;
	    }

	    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	    {
		return Packet.internal_static_RspRsaKey_fieldAccessorTable.ensureFieldAccessorsInitialized( Packet.RspRsaKey.class , Packet.RspRsaKey.Builder.class );
	    }

	    // Construct using Packet.RspRsaKey.newBuilder()
	    private Builder()
	    {
		maybeForceBuilderInitialization( );
	    }

	    private Builder( com.google.protobuf.GeneratedMessage.BuilderParent parent )
	    {
		super( parent );
		maybeForceBuilderInitialization( );
	    }

	    private void maybeForceBuilderInitialization()
	    {
		if( com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders )
		{}
	    }

	    private static Builder create()
	    {
		return new Builder( );
	    }

	    public Builder clear()
	    {
		super.clear( );
		rsaVer_ = "";
		bitField0_ = ( bitField0_ & ~0x00000001 );
		rsaKey_ = "";
		bitField0_ = ( bitField0_ & ~0x00000002 );
		return this;
	    }

	    public Builder clone()
	    {
		return create( ).mergeFrom( buildPartial( ) );
	    }

	    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
	    {
		return Packet.internal_static_RspRsaKey_descriptor;
	    }

	    public Packet.RspRsaKey getDefaultInstanceForType()
	    {
		return Packet.RspRsaKey.getDefaultInstance( );
	    }

	    public Packet.RspRsaKey build()
	    {
		Packet.RspRsaKey result = buildPartial( );
		if( !result.isInitialized( ) )
		{
		    throw newUninitializedMessageException( result );
		}
		return result;
	    }

	    public Packet.RspRsaKey buildPartial()
	    {
		Packet.RspRsaKey result = new Packet.RspRsaKey( this );
		int from_bitField0_ = bitField0_;
		int to_bitField0_ = 0;
		if( ( ( from_bitField0_ & 0x00000001 ) == 0x00000001 ) )
		{
		    to_bitField0_ |= 0x00000001;
		}
		result.rsaVer_ = rsaVer_;
		if( ( ( from_bitField0_ & 0x00000002 ) == 0x00000002 ) )
		{
		    to_bitField0_ |= 0x00000002;
		}
		result.rsaKey_ = rsaKey_;
		result.bitField0_ = to_bitField0_;
		onBuilt( );
		return result;
	    }

	    public Builder mergeFrom( com.google.protobuf.Message other )
	    {
		if( other instanceof Packet.RspRsaKey )
		{
		    return mergeFrom( (Packet.RspRsaKey)other );
		}
		else
		{
		    super.mergeFrom( other );
		    return this;
		}
	    }

	    public Builder mergeFrom( Packet.RspRsaKey other )
	    {
		if( other == Packet.RspRsaKey.getDefaultInstance( ) )
		    return this;
		if( other.hasRsaVer( ) )
		{
		    bitField0_ |= 0x00000001;
		    rsaVer_ = other.rsaVer_;
		    onChanged( );
		}
		if( other.hasRsaKey( ) )
		{
		    bitField0_ |= 0x00000002;
		    rsaKey_ = other.rsaKey_;
		    onChanged( );
		}
		this.mergeUnknownFields( other.getUnknownFields( ) );
		return this;
	    }

	    public final boolean isInitialized()
	    {
		if( !hasRsaVer( ) )
		{

		    return false;
		}
		if( !hasRsaKey( ) )
		{

		    return false;
		}
		return true;
	    }

	    public Builder mergeFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	    {
		Packet.RspRsaKey parsedMessage = null;
		try
		{
		    parsedMessage = PARSER.parsePartialFrom( input , extensionRegistry );
		}
		catch ( com.google.protobuf.InvalidProtocolBufferException e )
		{
		    parsedMessage = (Packet.RspRsaKey)e.getUnfinishedMessage( );
		    throw e;
		}
		finally
		{
		    if( parsedMessage != null )
		    {
			mergeFrom( parsedMessage );
		    }
		}
		return this;
	    }

	    private int bitField0_;

	    // required string rsaVer = 1;
	    private java.lang.Object rsaVer_ = "";

	    /**
	     * <code>required string rsaVer = 1;</code>
	     * 
	     * <pre>
	     * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	     * </pre>
	     */
	    public boolean hasRsaVer()
	    {
		return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	    }

	    /**
	     * <code>required string rsaVer = 1;</code>
	     * 
	     * <pre>
	     * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	     * </pre>
	     */
	    public java.lang.String getRsaVer()
	    {
		java.lang.Object ref = rsaVer_;
		if( ! ( ref instanceof java.lang.String ) )
		{
		    java.lang.String s = ( (com.google.protobuf.ByteString)ref ).toStringUtf8( );
		    rsaVer_ = s;
		    return s;
		}
		else
		{
		    return (java.lang.String)ref;
		}
	    }

	    /**
	     * <code>required string rsaVer = 1;</code>
	     * 
	     * <pre>
	     * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getRsaVerBytes()
	    {
		java.lang.Object ref = rsaVer_;
		if( ref instanceof String )
		{
		    com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		    rsaVer_ = b;
		    return b;
		}
		else
		{
		    return (com.google.protobuf.ByteString)ref;
		}
	    }

	    /**
	     * <code>required string rsaVer = 1;</code>
	     * 
	     * <pre>
	     * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	     * </pre>
	     */
	    public Builder setRsaVer( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000001;
		rsaVer_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string rsaVer = 1;</code>
	     * 
	     * <pre>
	     * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	     * </pre>
	     */
	    public Builder clearRsaVer()
	    {
		bitField0_ = ( bitField0_ & ~0x00000001 );
		rsaVer_ = getDefaultInstance( ).getRsaVer( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string rsaVer = 1;</code>
	     * 
	     * <pre>
	     * RSA版本标识（一般RSA版本标识会比RSA-KEY要短很多，以节省流量）
	     * </pre>
	     */
	    public Builder setRsaVerBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000001;
		rsaVer_ = value;
		onChanged( );
		return this;
	    }

	    // required string rsaKey = 2;
	    private java.lang.Object rsaKey_ = "";

	    /**
	     * <code>required string rsaKey = 2;</code>
	     * 
	     * <pre>
	     * RSA-KEY ( 格式: n,e )
	     * </pre>
	     */
	    public boolean hasRsaKey()
	    {
		return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	    }

	    /**
	     * <code>required string rsaKey = 2;</code>
	     * 
	     * <pre>
	     * RSA-KEY ( 格式: n,e )
	     * </pre>
	     */
	    public java.lang.String getRsaKey()
	    {
		java.lang.Object ref = rsaKey_;
		if( ! ( ref instanceof java.lang.String ) )
		{
		    java.lang.String s = ( (com.google.protobuf.ByteString)ref ).toStringUtf8( );
		    rsaKey_ = s;
		    return s;
		}
		else
		{
		    return (java.lang.String)ref;
		}
	    }

	    /**
	     * <code>required string rsaKey = 2;</code>
	     * 
	     * <pre>
	     * RSA-KEY ( 格式: n,e )
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getRsaKeyBytes()
	    {
		java.lang.Object ref = rsaKey_;
		if( ref instanceof String )
		{
		    com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		    rsaKey_ = b;
		    return b;
		}
		else
		{
		    return (com.google.protobuf.ByteString)ref;
		}
	    }

	    /**
	     * <code>required string rsaKey = 2;</code>
	     * 
	     * <pre>
	     * RSA-KEY ( 格式: n,e )
	     * </pre>
	     */
	    public Builder setRsaKey( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000002;
		rsaKey_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string rsaKey = 2;</code>
	     * 
	     * <pre>
	     * RSA-KEY ( 格式: n,e )
	     * </pre>
	     */
	    public Builder clearRsaKey()
	    {
		bitField0_ = ( bitField0_ & ~0x00000002 );
		rsaKey_ = getDefaultInstance( ).getRsaKey( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string rsaKey = 2;</code>
	     * 
	     * <pre>
	     * RSA-KEY ( 格式: n,e )
	     * </pre>
	     */
	    public Builder setRsaKeyBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000002;
		rsaKey_ = value;
		onChanged( );
		return this;
	    }

	    // @@protoc_insertion_point(builder_scope:RspRsaKey)
	}

	static
	{
	    defaultInstance = new RspRsaKey( true );
	    defaultInstance.initFields( );
	}

	// @@protoc_insertion_point(class_scope:RspRsaKey)
    }

    private static com.google.protobuf.Descriptors.Descriptor internal_static_ReqPacket_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_ReqPacket_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.Descriptor internal_static_RspPacket_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_RspPacket_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.Descriptor internal_static_RspRsaKey_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_RspRsaKey_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor()
    {
	return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
    static
    {
	java.lang.String[] descriptorData = { "\n\014Packet.proto\"\277\001\n\tReqPacket\022\014\n\004mask\030\001 \002"
		+ "(\005\022\013\n\003udi\030\002 \002(\t\022\016\n\006action\030\003 \003(\t\022\016\n\006param"
		+ "s\030\004 \003(\014\022\r\n\005reqNo\030\005 \002(\005\022\r\n\005chnNo\030\006 \001(\005\022\016\n"
		+ "\006chnPos\030\007 \001(\005\022\020\n\010clientId\030\010 \002(\005\022\021\n\tclien" + "tPos\030\t \001(\005\022\021\n\tclientVer\030\n \001(\t\022\021\n\trsaKeyV"
		+ "er\030\013 \001(\t\"Z\n\tRspPacket\022\014\n\004mask\030\001 \002(\005\022\017\n\007r" + "escode\030\002 \002(\005\022\016\n\006resmsg\030\003 \002(\t\022\016\n\006action\030\004"
		+ " \003(\t\022\016\n\006params\030\005 \003(\014\"+\n\tRspRsaKey\022\016\n\006rsa" + "Ver\030\001 \002(\t\022\016\n\006rsaKey\030\002 \002(\t*8\n\010MaskCode\022\013\n"
		+ "\007DEFAULT\020\000\022\017\n\013PARAMS_GZIP\020\001\022\016\n\nPARAMS_RS" , "A\020\002" };
	com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner( )
	{
	    public com.google.protobuf.ExtensionRegistry assignDescriptors( com.google.protobuf.Descriptors.FileDescriptor root )
	    {
		descriptor = root;
		internal_static_ReqPacket_descriptor = getDescriptor( ).getMessageTypes( ).get( 0 );
		internal_static_ReqPacket_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable( internal_static_ReqPacket_descriptor ,
			new java.lang.String [] { "Mask" , "Udi" , "Action" , "Params" , "ReqNo" , "ChnNo" , "ChnPos" , "ClientId" , "ClientPos" , "ClientVer" , "RsaKeyVer" , } );
		internal_static_RspPacket_descriptor = getDescriptor( ).getMessageTypes( ).get( 1 );
		internal_static_RspPacket_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable( internal_static_RspPacket_descriptor ,
			new java.lang.String [] { "Mask" , "Rescode" , "Resmsg" , "Action" , "Params" , } );
		internal_static_RspRsaKey_descriptor = getDescriptor( ).getMessageTypes( ).get( 2 );
		internal_static_RspRsaKey_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable( internal_static_RspRsaKey_descriptor ,
			new java.lang.String [] { "RsaVer" , "RsaKey" , } );
		return null;
	    }
	};
	com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom( descriptorData , new com.google.protobuf.Descriptors.FileDescriptor [] { } , assigner );
    }

    // @@protoc_insertion_point(outer_class_scope)
}
