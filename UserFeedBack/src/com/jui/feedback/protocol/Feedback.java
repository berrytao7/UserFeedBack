package com.jui.feedback.protocol;

public final class Feedback
{
    private Feedback()
    {}

    public static void registerAllExtensions( com.google.protobuf.ExtensionRegistry registry )
    {}

    public interface ReqFeedbackOrBuilder extends com.google.protobuf.MessageOrBuilder
    {

	// required int32 feedbackType = 1;
	/**
	 * <code>required int32 feedbackType = 1;</code>
	 * 
	 * <pre>
	 * 反馈类型，从1开始，1表示系统自动重启，2表示耗电过多，3表示应用异常退出
	 * </pre>
	 */
	boolean hasFeedbackType();

	/**
	 * <code>required int32 feedbackType = 1;</code>
	 * 
	 * <pre>
	 * 反馈类型，从1开始，1表示系统自动重启，2表示耗电过多，3表示应用异常退出
	 * </pre>
	 */
	int getFeedbackType();

	// required string description = 2;
	/**
	 * <code>required string description = 2;</code>
	 * 
	 * <pre>
	 * 问题描述
	 * </pre>
	 */
	boolean hasDescription();

	/**
	 * <code>required string description = 2;</code>
	 * 
	 * <pre>
	 * 问题描述
	 * </pre>
	 */
	java.lang.String getDescription();

	/**
	 * <code>required string description = 2;</code>
	 * 
	 * <pre>
	 * 问题描述
	 * </pre>
	 */
	com.google.protobuf.ByteString getDescriptionBytes();

	// optional string machineType = 3;
	/**
	 * <code>optional string machineType = 3;</code>
	 * 
	 * <pre>
	 * 机器类型
	 * </pre>
	 */
	boolean hasMachineType();

	/**
	 * <code>optional string machineType = 3;</code>
	 * 
	 * <pre>
	 * 机器类型
	 * </pre>
	 */
	java.lang.String getMachineType();

	/**
	 * <code>optional string machineType = 3;</code>
	 * 
	 * <pre>
	 * 机器类型
	 * </pre>
	 */
	com.google.protobuf.ByteString getMachineTypeBytes();

	// repeated string imageUrls = 4;
	/**
	 * <code>repeated string imageUrls = 4;</code>
	 * 
	 * <pre>
	 * 反馈的图片在云存储上的路径
	 * </pre>
	 */
	java.util.List< java.lang.String > getImageUrlsList();

	/**
	 * <code>repeated string imageUrls = 4;</code>
	 * 
	 * <pre>
	 * 反馈的图片在云存储上的路径
	 * </pre>
	 */
	int getImageUrlsCount();

	/**
	 * <code>repeated string imageUrls = 4;</code>
	 * 
	 * <pre>
	 * 反馈的图片在云存储上的路径
	 * </pre>
	 */
	java.lang.String getImageUrls( int index );

	/**
	 * <code>repeated string imageUrls = 4;</code>
	 * 
	 * <pre>
	 * 反馈的图片在云存储上的路径
	 * </pre>
	 */
	com.google.protobuf.ByteString getImageUrlsBytes( int index );

	// optional string contactInfo = 5;
	/**
	 * <code>optional string contactInfo = 5;</code>
	 * 
	 * <pre>
	 * 联系方式
	 * </pre>
	 */
	boolean hasContactInfo();

	/**
	 * <code>optional string contactInfo = 5;</code>
	 * 
	 * <pre>
	 * 联系方式
	 * </pre>
	 */
	java.lang.String getContactInfo();

	/**
	 * <code>optional string contactInfo = 5;</code>
	 * 
	 * <pre>
	 * 联系方式
	 * </pre>
	 */
	com.google.protobuf.ByteString getContactInfoBytes();
    }

    /**
     * Protobuf type {@code ReqFeedback}
     * 
     * <pre>
     * ============================================ 提交用户反馈信息
     * </pre>
     */
    public static final class ReqFeedback extends com.google.protobuf.GeneratedMessage implements ReqFeedbackOrBuilder
    {
	// Use ReqFeedback.newBuilder() to construct.
	private ReqFeedback( com.google.protobuf.GeneratedMessage.Builder< ? > builder )
	{
	    super( builder );
	    this.unknownFields = builder.getUnknownFields( );
	}

	private ReqFeedback( boolean noInit )
	{
	    this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance( );
	}

	private static final ReqFeedback defaultInstance;

	public static ReqFeedback getDefaultInstance()
	{
	    return defaultInstance;
	}

	public ReqFeedback getDefaultInstanceForType()
	{
	    return defaultInstance;
	}

	private final com.google.protobuf.UnknownFieldSet unknownFields;

	@java.lang.Override
	public final com.google.protobuf.UnknownFieldSet getUnknownFields()
	{
	    return this.unknownFields;
	}

	private ReqFeedback( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
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
			    feedbackType_ = input.readInt32( );
			    break;
			}
			case 18 :
			{
			    bitField0_ |= 0x00000002;
			    description_ = input.readBytes( );
			    break;
			}
			case 26 :
			{
			    bitField0_ |= 0x00000004;
			    machineType_ = input.readBytes( );
			    break;
			}
			case 34 :
			{
			    if( ! ( ( mutable_bitField0_ & 0x00000008 ) == 0x00000008 ) )
			    {
				imageUrls_ = new com.google.protobuf.LazyStringArrayList( );
				mutable_bitField0_ |= 0x00000008;
			    }
			    imageUrls_.add( input.readBytes( ) );
			    break;
			}
			case 42 :
			{
			    bitField0_ |= 0x00000008;
			    contactInfo_ = input.readBytes( );
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
		    imageUrls_ = new com.google.protobuf.UnmodifiableLazyStringList( imageUrls_ );
		}
		this.unknownFields = unknownFields.build( );
		makeExtensionsImmutable( );
	    }
	}

	public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
	{
	    return Feedback.internal_static_ReqFeedback_descriptor;
	}

	protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	{
	    return Feedback.internal_static_ReqFeedback_fieldAccessorTable.ensureFieldAccessorsInitialized( Feedback.ReqFeedback.class , Feedback.ReqFeedback.Builder.class );
	}

	public static com.google.protobuf.Parser< ReqFeedback > PARSER = new com.google.protobuf.AbstractParser< ReqFeedback >( )
	{
	    public ReqFeedback parsePartialFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	    {
		return new ReqFeedback( input , extensionRegistry );
	    }
	};

	@java.lang.Override
	public com.google.protobuf.Parser< ReqFeedback > getParserForType()
	{
	    return PARSER;
	}

	private int bitField0_;
	// required int32 feedbackType = 1;
	public static final int FEEDBACKTYPE_FIELD_NUMBER = 1;
	private int feedbackType_;

	/**
	 * <code>required int32 feedbackType = 1;</code>
	 * 
	 * <pre>
	 * 反馈类型，从1开始，1表示系统自动重启，2表示耗电过多，3表示应用异常退出
	 * </pre>
	 */
	public boolean hasFeedbackType()
	{
	    return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	}

	/**
	 * <code>required int32 feedbackType = 1;</code>
	 * 
	 * <pre>
	 * 反馈类型，从1开始，1表示系统自动重启，2表示耗电过多，3表示应用异常退出
	 * </pre>
	 */
	public int getFeedbackType()
	{
	    return feedbackType_;
	}

	// required string description = 2;
	public static final int DESCRIPTION_FIELD_NUMBER = 2;
	private java.lang.Object description_;

	/**
	 * <code>required string description = 2;</code>
	 * 
	 * <pre>
	 * 问题描述
	 * </pre>
	 */
	public boolean hasDescription()
	{
	    return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	}

	/**
	 * <code>required string description = 2;</code>
	 * 
	 * <pre>
	 * 问题描述
	 * </pre>
	 */
	public java.lang.String getDescription()
	{
	    java.lang.Object ref = description_;
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
		    description_ = s;
		}
		return s;
	    }
	}

	/**
	 * <code>required string description = 2;</code>
	 * 
	 * <pre>
	 * 问题描述
	 * </pre>
	 */
	public com.google.protobuf.ByteString getDescriptionBytes()
	{
	    java.lang.Object ref = description_;
	    if( ref instanceof java.lang.String )
	    {
		com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		description_ = b;
		return b;
	    }
	    else
	    {
		return (com.google.protobuf.ByteString)ref;
	    }
	}

	// optional string machineType = 3;
	public static final int MACHINETYPE_FIELD_NUMBER = 3;
	private java.lang.Object machineType_;

	/**
	 * <code>optional string machineType = 3;</code>
	 * 
	 * <pre>
	 * 机器类型
	 * </pre>
	 */
	public boolean hasMachineType()
	{
	    return ( ( bitField0_ & 0x00000004 ) == 0x00000004 );
	}

	/**
	 * <code>optional string machineType = 3;</code>
	 * 
	 * <pre>
	 * 机器类型
	 * </pre>
	 */
	public java.lang.String getMachineType()
	{
	    java.lang.Object ref = machineType_;
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
		    machineType_ = s;
		}
		return s;
	    }
	}

	/**
	 * <code>optional string machineType = 3;</code>
	 * 
	 * <pre>
	 * 机器类型
	 * </pre>
	 */
	public com.google.protobuf.ByteString getMachineTypeBytes()
	{
	    java.lang.Object ref = machineType_;
	    if( ref instanceof java.lang.String )
	    {
		com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		machineType_ = b;
		return b;
	    }
	    else
	    {
		return (com.google.protobuf.ByteString)ref;
	    }
	}

	// repeated string imageUrls = 4;
	public static final int IMAGEURLS_FIELD_NUMBER = 4;
	private com.google.protobuf.LazyStringList imageUrls_;

	/**
	 * <code>repeated string imageUrls = 4;</code>
	 * 
	 * <pre>
	 * 反馈的图片在云存储上的路径
	 * </pre>
	 */
	public java.util.List< java.lang.String > getImageUrlsList()
	{
	    return imageUrls_;
	}

	/**
	 * <code>repeated string imageUrls = 4;</code>
	 * 
	 * <pre>
	 * 反馈的图片在云存储上的路径
	 * </pre>
	 */
	public int getImageUrlsCount()
	{
	    return imageUrls_.size( );
	}

	/**
	 * <code>repeated string imageUrls = 4;</code>
	 * 
	 * <pre>
	 * 反馈的图片在云存储上的路径
	 * </pre>
	 */
	public java.lang.String getImageUrls( int index )
	{
	    return imageUrls_.get( index );
	}

	/**
	 * <code>repeated string imageUrls = 4;</code>
	 * 
	 * <pre>
	 * 反馈的图片在云存储上的路径
	 * </pre>
	 */
	public com.google.protobuf.ByteString getImageUrlsBytes( int index )
	{
	    return imageUrls_.getByteString( index );
	}

	// optional string contactInfo = 5;
	public static final int CONTACTINFO_FIELD_NUMBER = 5;
	private java.lang.Object contactInfo_;

	/**
	 * <code>optional string contactInfo = 5;</code>
	 * 
	 * <pre>
	 * 联系方式
	 * </pre>
	 */
	public boolean hasContactInfo()
	{
	    return ( ( bitField0_ & 0x00000008 ) == 0x00000008 );
	}

	/**
	 * <code>optional string contactInfo = 5;</code>
	 * 
	 * <pre>
	 * 联系方式
	 * </pre>
	 */
	public java.lang.String getContactInfo()
	{
	    java.lang.Object ref = contactInfo_;
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
		    contactInfo_ = s;
		}
		return s;
	    }
	}

	/**
	 * <code>optional string contactInfo = 5;</code>
	 * 
	 * <pre>
	 * 联系方式
	 * </pre>
	 */
	public com.google.protobuf.ByteString getContactInfoBytes()
	{
	    java.lang.Object ref = contactInfo_;
	    if( ref instanceof java.lang.String )
	    {
		com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		contactInfo_ = b;
		return b;
	    }
	    else
	    {
		return (com.google.protobuf.ByteString)ref;
	    }
	}

	private void initFields()
	{
	    feedbackType_ = 0;
	    description_ = "";
	    machineType_ = "";
	    imageUrls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
	    contactInfo_ = "";
	}

	private byte memoizedIsInitialized = -1;

	public final boolean isInitialized()
	{
	    byte isInitialized = memoizedIsInitialized;
	    if( isInitialized != -1 )
		return isInitialized == 1;

	    if( !hasFeedbackType( ) )
	    {
		memoizedIsInitialized = 0;
		return false;
	    }
	    if( !hasDescription( ) )
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
		output.writeInt32( 1 , feedbackType_ );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		output.writeBytes( 2 , getDescriptionBytes( ) );
	    }
	    if( ( ( bitField0_ & 0x00000004 ) == 0x00000004 ) )
	    {
		output.writeBytes( 3 , getMachineTypeBytes( ) );
	    }
	    for( int i = 0 ; i < imageUrls_.size( ) ; i++ )
	    {
		output.writeBytes( 4 , imageUrls_.getByteString( i ) );
	    }
	    if( ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
	    {
		output.writeBytes( 5 , getContactInfoBytes( ) );
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
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 1 , feedbackType_ );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 2 , getDescriptionBytes( ) );
	    }
	    if( ( ( bitField0_ & 0x00000004 ) == 0x00000004 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 3 , getMachineTypeBytes( ) );
	    }
	    {
		int dataSize = 0;
		for( int i = 0 ; i < imageUrls_.size( ) ; i++ )
		{
		    dataSize += com.google.protobuf.CodedOutputStream.computeBytesSizeNoTag( imageUrls_.getByteString( i ) );
		}
		size += dataSize;
		size += 1 * getImageUrlsList( ).size( );
	    }
	    if( ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 5 , getContactInfoBytes( ) );
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

	public static Feedback.ReqFeedback parseFrom( com.google.protobuf.ByteString data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Feedback.ReqFeedback parseFrom( com.google.protobuf.ByteString data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Feedback.ReqFeedback parseFrom( byte [] data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Feedback.ReqFeedback parseFrom( byte [] data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Feedback.ReqFeedback parseFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Feedback.ReqFeedback parseFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input , extensionRegistry );
	}

	public static Feedback.ReqFeedback parseDelimitedFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input );
	}

	public static Feedback.ReqFeedback parseDelimitedFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input , extensionRegistry );
	}

	public static Feedback.ReqFeedback parseFrom( com.google.protobuf.CodedInputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Feedback.ReqFeedback parseFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
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

	public static Builder newBuilder( Feedback.ReqFeedback prototype )
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
	 * Protobuf type {@code ReqFeedback}
	 * 
	 * <pre>
	 * ============================================ 提交用户反馈信息
	 * </pre>
	 */
	public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder< Builder > implements Feedback.ReqFeedbackOrBuilder
	{
	    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
	    {
		return Feedback.internal_static_ReqFeedback_descriptor;
	    }

	    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	    {
		return Feedback.internal_static_ReqFeedback_fieldAccessorTable.ensureFieldAccessorsInitialized( Feedback.ReqFeedback.class , Feedback.ReqFeedback.Builder.class );
	    }

	    // Construct using Feedback.ReqFeedback.newBuilder()
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
		feedbackType_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000001 );
		description_ = "";
		bitField0_ = ( bitField0_ & ~0x00000002 );
		machineType_ = "";
		bitField0_ = ( bitField0_ & ~0x00000004 );
		imageUrls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
		bitField0_ = ( bitField0_ & ~0x00000008 );
		contactInfo_ = "";
		bitField0_ = ( bitField0_ & ~0x00000010 );
		return this;
	    }

	    public Builder clone()
	    {
		return create( ).mergeFrom( buildPartial( ) );
	    }

	    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
	    {
		return Feedback.internal_static_ReqFeedback_descriptor;
	    }

	    public Feedback.ReqFeedback getDefaultInstanceForType()
	    {
		return Feedback.ReqFeedback.getDefaultInstance( );
	    }

	    public Feedback.ReqFeedback build()
	    {
		Feedback.ReqFeedback result = buildPartial( );
		if( !result.isInitialized( ) )
		{
		    throw newUninitializedMessageException( result );
		}
		return result;
	    }

	    public Feedback.ReqFeedback buildPartial()
	    {
		Feedback.ReqFeedback result = new Feedback.ReqFeedback( this );
		int from_bitField0_ = bitField0_;
		int to_bitField0_ = 0;
		if( ( ( from_bitField0_ & 0x00000001 ) == 0x00000001 ) )
		{
		    to_bitField0_ |= 0x00000001;
		}
		result.feedbackType_ = feedbackType_;
		if( ( ( from_bitField0_ & 0x00000002 ) == 0x00000002 ) )
		{
		    to_bitField0_ |= 0x00000002;
		}
		result.description_ = description_;
		if( ( ( from_bitField0_ & 0x00000004 ) == 0x00000004 ) )
		{
		    to_bitField0_ |= 0x00000004;
		}
		result.machineType_ = machineType_;
		if( ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
		{
		    imageUrls_ = new com.google.protobuf.UnmodifiableLazyStringList( imageUrls_ );
		    bitField0_ = ( bitField0_ & ~0x00000008 );
		}
		result.imageUrls_ = imageUrls_;
		if( ( ( from_bitField0_ & 0x00000010 ) == 0x00000010 ) )
		{
		    to_bitField0_ |= 0x00000008;
		}
		result.contactInfo_ = contactInfo_;
		result.bitField0_ = to_bitField0_;
		onBuilt( );
		return result;
	    }

	    public Builder mergeFrom( com.google.protobuf.Message other )
	    {
		if( other instanceof Feedback.ReqFeedback )
		{
		    return mergeFrom( (Feedback.ReqFeedback)other );
		}
		else
		{
		    super.mergeFrom( other );
		    return this;
		}
	    }

	    public Builder mergeFrom( Feedback.ReqFeedback other )
	    {
		if( other == Feedback.ReqFeedback.getDefaultInstance( ) )
		    return this;
		if( other.hasFeedbackType( ) )
		{
		    setFeedbackType( other.getFeedbackType( ) );
		}
		if( other.hasDescription( ) )
		{
		    bitField0_ |= 0x00000002;
		    description_ = other.description_;
		    onChanged( );
		}
		if( other.hasMachineType( ) )
		{
		    bitField0_ |= 0x00000004;
		    machineType_ = other.machineType_;
		    onChanged( );
		}
		if( !other.imageUrls_.isEmpty( ) )
		{
		    if( imageUrls_.isEmpty( ) )
		    {
			imageUrls_ = other.imageUrls_;
			bitField0_ = ( bitField0_ & ~0x00000008 );
		    }
		    else
		    {
			ensureImageUrlsIsMutable( );
			imageUrls_.addAll( other.imageUrls_ );
		    }
		    onChanged( );
		}
		if( other.hasContactInfo( ) )
		{
		    bitField0_ |= 0x00000010;
		    contactInfo_ = other.contactInfo_;
		    onChanged( );
		}
		this.mergeUnknownFields( other.getUnknownFields( ) );
		return this;
	    }

	    public final boolean isInitialized()
	    {
		if( !hasFeedbackType( ) )
		{

		    return false;
		}
		if( !hasDescription( ) )
		{

		    return false;
		}
		return true;
	    }

	    public Builder mergeFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	    {
		Feedback.ReqFeedback parsedMessage = null;
		try
		{
		    parsedMessage = PARSER.parsePartialFrom( input , extensionRegistry );
		}
		catch ( com.google.protobuf.InvalidProtocolBufferException e )
		{
		    parsedMessage = (Feedback.ReqFeedback)e.getUnfinishedMessage( );
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

	    // required int32 feedbackType = 1;
	    private int feedbackType_;

	    /**
	     * <code>required int32 feedbackType = 1;</code>
	     * 
	     * <pre>
	     * 反馈类型，从1开始，1表示系统自动重启，2表示耗电过多，3表示应用异常退出
	     * </pre>
	     */
	    public boolean hasFeedbackType()
	    {
		return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	    }

	    /**
	     * <code>required int32 feedbackType = 1;</code>
	     * 
	     * <pre>
	     * 反馈类型，从1开始，1表示系统自动重启，2表示耗电过多，3表示应用异常退出
	     * </pre>
	     */
	    public int getFeedbackType()
	    {
		return feedbackType_;
	    }

	    /**
	     * <code>required int32 feedbackType = 1;</code>
	     * 
	     * <pre>
	     * 反馈类型，从1开始，1表示系统自动重启，2表示耗电过多，3表示应用异常退出
	     * </pre>
	     */
	    public Builder setFeedbackType( int value )
	    {
		bitField0_ |= 0x00000001;
		feedbackType_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required int32 feedbackType = 1;</code>
	     * 
	     * <pre>
	     * 反馈类型，从1开始，1表示系统自动重启，2表示耗电过多，3表示应用异常退出
	     * </pre>
	     */
	    public Builder clearFeedbackType()
	    {
		bitField0_ = ( bitField0_ & ~0x00000001 );
		feedbackType_ = 0;
		onChanged( );
		return this;
	    }

	    // required string description = 2;
	    private java.lang.Object description_ = "";

	    /**
	     * <code>required string description = 2;</code>
	     * 
	     * <pre>
	     * 问题描述
	     * </pre>
	     */
	    public boolean hasDescription()
	    {
		return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	    }

	    /**
	     * <code>required string description = 2;</code>
	     * 
	     * <pre>
	     * 问题描述
	     * </pre>
	     */
	    public java.lang.String getDescription()
	    {
		java.lang.Object ref = description_;
		if( ! ( ref instanceof java.lang.String ) )
		{
		    java.lang.String s = ( (com.google.protobuf.ByteString)ref ).toStringUtf8( );
		    description_ = s;
		    return s;
		}
		else
		{
		    return (java.lang.String)ref;
		}
	    }

	    /**
	     * <code>required string description = 2;</code>
	     * 
	     * <pre>
	     * 问题描述
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getDescriptionBytes()
	    {
		java.lang.Object ref = description_;
		if( ref instanceof String )
		{
		    com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		    description_ = b;
		    return b;
		}
		else
		{
		    return (com.google.protobuf.ByteString)ref;
		}
	    }

	    /**
	     * <code>required string description = 2;</code>
	     * 
	     * <pre>
	     * 问题描述
	     * </pre>
	     */
	    public Builder setDescription( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000002;
		description_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string description = 2;</code>
	     * 
	     * <pre>
	     * 问题描述
	     * </pre>
	     */
	    public Builder clearDescription()
	    {
		bitField0_ = ( bitField0_ & ~0x00000002 );
		description_ = getDefaultInstance( ).getDescription( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string description = 2;</code>
	     * 
	     * <pre>
	     * 问题描述
	     * </pre>
	     */
	    public Builder setDescriptionBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000002;
		description_ = value;
		onChanged( );
		return this;
	    }

	    // optional string machineType = 3;
	    private java.lang.Object machineType_ = "";

	    /**
	     * <code>optional string machineType = 3;</code>
	     * 
	     * <pre>
	     * 机器类型
	     * </pre>
	     */
	    public boolean hasMachineType()
	    {
		return ( ( bitField0_ & 0x00000004 ) == 0x00000004 );
	    }

	    /**
	     * <code>optional string machineType = 3;</code>
	     * 
	     * <pre>
	     * 机器类型
	     * </pre>
	     */
	    public java.lang.String getMachineType()
	    {
		java.lang.Object ref = machineType_;
		if( ! ( ref instanceof java.lang.String ) )
		{
		    java.lang.String s = ( (com.google.protobuf.ByteString)ref ).toStringUtf8( );
		    machineType_ = s;
		    return s;
		}
		else
		{
		    return (java.lang.String)ref;
		}
	    }

	    /**
	     * <code>optional string machineType = 3;</code>
	     * 
	     * <pre>
	     * 机器类型
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getMachineTypeBytes()
	    {
		java.lang.Object ref = machineType_;
		if( ref instanceof String )
		{
		    com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		    machineType_ = b;
		    return b;
		}
		else
		{
		    return (com.google.protobuf.ByteString)ref;
		}
	    }

	    /**
	     * <code>optional string machineType = 3;</code>
	     * 
	     * <pre>
	     * 机器类型
	     * </pre>
	     */
	    public Builder setMachineType( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000004;
		machineType_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional string machineType = 3;</code>
	     * 
	     * <pre>
	     * 机器类型
	     * </pre>
	     */
	    public Builder clearMachineType()
	    {
		bitField0_ = ( bitField0_ & ~0x00000004 );
		machineType_ = getDefaultInstance( ).getMachineType( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional string machineType = 3;</code>
	     * 
	     * <pre>
	     * 机器类型
	     * </pre>
	     */
	    public Builder setMachineTypeBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000004;
		machineType_ = value;
		onChanged( );
		return this;
	    }

	    // repeated string imageUrls = 4;
	    private com.google.protobuf.LazyStringList imageUrls_ = com.google.protobuf.LazyStringArrayList.EMPTY;

	    private void ensureImageUrlsIsMutable()
	    {
		if( ! ( ( bitField0_ & 0x00000008 ) == 0x00000008 ) )
		{
		    imageUrls_ = new com.google.protobuf.LazyStringArrayList( imageUrls_ );
		    bitField0_ |= 0x00000008;
		}
	    }

	    /**
	     * <code>repeated string imageUrls = 4;</code>
	     * 
	     * <pre>
	     * 反馈的图片在云存储上的路径
	     * </pre>
	     */
	    public java.util.List< java.lang.String > getImageUrlsList()
	    {
		return java.util.Collections.unmodifiableList( imageUrls_ );
	    }

	    /**
	     * <code>repeated string imageUrls = 4;</code>
	     * 
	     * <pre>
	     * 反馈的图片在云存储上的路径
	     * </pre>
	     */
	    public int getImageUrlsCount()
	    {
		return imageUrls_.size( );
	    }

	    /**
	     * <code>repeated string imageUrls = 4;</code>
	     * 
	     * <pre>
	     * 反馈的图片在云存储上的路径
	     * </pre>
	     */
	    public java.lang.String getImageUrls( int index )
	    {
		return imageUrls_.get( index );
	    }

	    /**
	     * <code>repeated string imageUrls = 4;</code>
	     * 
	     * <pre>
	     * 反馈的图片在云存储上的路径
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getImageUrlsBytes( int index )
	    {
		return imageUrls_.getByteString( index );
	    }

	    /**
	     * <code>repeated string imageUrls = 4;</code>
	     * 
	     * <pre>
	     * 反馈的图片在云存储上的路径
	     * </pre>
	     */
	    public Builder setImageUrls( int index , java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureImageUrlsIsMutable( );
		imageUrls_.set( index , value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string imageUrls = 4;</code>
	     * 
	     * <pre>
	     * 反馈的图片在云存储上的路径
	     * </pre>
	     */
	    public Builder addImageUrls( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureImageUrlsIsMutable( );
		imageUrls_.add( value );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string imageUrls = 4;</code>
	     * 
	     * <pre>
	     * 反馈的图片在云存储上的路径
	     * </pre>
	     */
	    public Builder addAllImageUrls( java.lang.Iterable< java.lang.String > values )
	    {
		ensureImageUrlsIsMutable( );
		super.addAll( values , imageUrls_ );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string imageUrls = 4;</code>
	     * 
	     * <pre>
	     * 反馈的图片在云存储上的路径
	     * </pre>
	     */
	    public Builder clearImageUrls()
	    {
		imageUrls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
		bitField0_ = ( bitField0_ & ~0x00000008 );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>repeated string imageUrls = 4;</code>
	     * 
	     * <pre>
	     * 反馈的图片在云存储上的路径
	     * </pre>
	     */
	    public Builder addImageUrlsBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		ensureImageUrlsIsMutable( );
		imageUrls_.add( value );
		onChanged( );
		return this;
	    }

	    // optional string contactInfo = 5;
	    private java.lang.Object contactInfo_ = "";

	    /**
	     * <code>optional string contactInfo = 5;</code>
	     * 
	     * <pre>
	     * 联系方式
	     * </pre>
	     */
	    public boolean hasContactInfo()
	    {
		return ( ( bitField0_ & 0x00000010 ) == 0x00000010 );
	    }

	    /**
	     * <code>optional string contactInfo = 5;</code>
	     * 
	     * <pre>
	     * 联系方式
	     * </pre>
	     */
	    public java.lang.String getContactInfo()
	    {
		java.lang.Object ref = contactInfo_;
		if( ! ( ref instanceof java.lang.String ) )
		{
		    java.lang.String s = ( (com.google.protobuf.ByteString)ref ).toStringUtf8( );
		    contactInfo_ = s;
		    return s;
		}
		else
		{
		    return (java.lang.String)ref;
		}
	    }

	    /**
	     * <code>optional string contactInfo = 5;</code>
	     * 
	     * <pre>
	     * 联系方式
	     * </pre>
	     */
	    public com.google.protobuf.ByteString getContactInfoBytes()
	    {
		java.lang.Object ref = contactInfo_;
		if( ref instanceof String )
		{
		    com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8( (java.lang.String)ref );
		    contactInfo_ = b;
		    return b;
		}
		else
		{
		    return (com.google.protobuf.ByteString)ref;
		}
	    }

	    /**
	     * <code>optional string contactInfo = 5;</code>
	     * 
	     * <pre>
	     * 联系方式
	     * </pre>
	     */
	    public Builder setContactInfo( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000010;
		contactInfo_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional string contactInfo = 5;</code>
	     * 
	     * <pre>
	     * 联系方式
	     * </pre>
	     */
	    public Builder clearContactInfo()
	    {
		bitField0_ = ( bitField0_ & ~0x00000010 );
		contactInfo_ = getDefaultInstance( ).getContactInfo( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>optional string contactInfo = 5;</code>
	     * 
	     * <pre>
	     * 联系方式
	     * </pre>
	     */
	    public Builder setContactInfoBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000010;
		contactInfo_ = value;
		onChanged( );
		return this;
	    }

	    // @@protoc_insertion_point(builder_scope:ReqFeedback)
	}

	static
	{
	    defaultInstance = new ReqFeedback( true );
	    defaultInstance.initFields( );
	}

	// @@protoc_insertion_point(class_scope:ReqFeedback)
    }

    public interface RspFeedbackOrBuilder extends com.google.protobuf.MessageOrBuilder
    {

	// required int32 rescode = 1;
	/**
	 * <code>required int32 rescode = 1;</code>
	 * 
	 * <pre>
	 * 返回码：0=成功，1=失败
	 * </pre>
	 */
	boolean hasRescode();

	/**
	 * <code>required int32 rescode = 1;</code>
	 * 
	 * <pre>
	 * 返回码：0=成功，1=失败
	 * </pre>
	 */
	int getRescode();

	// required string resmsg = 2;
	/**
	 * <code>required string resmsg = 2;</code>
	 * 
	 * <pre>
	 * 返回消息
	 * </pre>
	 */
	boolean hasResmsg();

	/**
	 * <code>required string resmsg = 2;</code>
	 * 
	 * <pre>
	 * 返回消息
	 * </pre>
	 */
	java.lang.String getResmsg();

	/**
	 * <code>required string resmsg = 2;</code>
	 * 
	 * <pre>
	 * 返回消息
	 * </pre>
	 */
	com.google.protobuf.ByteString getResmsgBytes();
    }

    /**
     * Protobuf type {@code RspFeedback}
     */
    public static final class RspFeedback extends com.google.protobuf.GeneratedMessage implements RspFeedbackOrBuilder
    {
	// Use RspFeedback.newBuilder() to construct.
	private RspFeedback( com.google.protobuf.GeneratedMessage.Builder< ? > builder )
	{
	    super( builder );
	    this.unknownFields = builder.getUnknownFields( );
	}

	private RspFeedback( boolean noInit )
	{
	    this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance( );
	}

	private static final RspFeedback defaultInstance;

	public static RspFeedback getDefaultInstance()
	{
	    return defaultInstance;
	}

	public RspFeedback getDefaultInstanceForType()
	{
	    return defaultInstance;
	}

	private final com.google.protobuf.UnknownFieldSet unknownFields;

	@java.lang.Override
	public final com.google.protobuf.UnknownFieldSet getUnknownFields()
	{
	    return this.unknownFields;
	}

	private RspFeedback( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
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
			case 8 :
			{
			    bitField0_ |= 0x00000001;
			    rescode_ = input.readInt32( );
			    break;
			}
			case 18 :
			{
			    bitField0_ |= 0x00000002;
			    resmsg_ = input.readBytes( );
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
	    return Feedback.internal_static_RspFeedback_descriptor;
	}

	protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	{
	    return Feedback.internal_static_RspFeedback_fieldAccessorTable.ensureFieldAccessorsInitialized( Feedback.RspFeedback.class , Feedback.RspFeedback.Builder.class );
	}

	public static com.google.protobuf.Parser< RspFeedback > PARSER = new com.google.protobuf.AbstractParser< RspFeedback >( )
	{
	    public RspFeedback parsePartialFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	    {
		return new RspFeedback( input , extensionRegistry );
	    }
	};

	@java.lang.Override
	public com.google.protobuf.Parser< RspFeedback > getParserForType()
	{
	    return PARSER;
	}

	private int bitField0_;
	// required int32 rescode = 1;
	public static final int RESCODE_FIELD_NUMBER = 1;
	private int rescode_;

	/**
	 * <code>required int32 rescode = 1;</code>
	 * 
	 * <pre>
	 * 返回码：0=成功，1=失败
	 * </pre>
	 */
	public boolean hasRescode()
	{
	    return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	}

	/**
	 * <code>required int32 rescode = 1;</code>
	 * 
	 * <pre>
	 * 返回码：0=成功，1=失败
	 * </pre>
	 */
	public int getRescode()
	{
	    return rescode_;
	}

	// required string resmsg = 2;
	public static final int RESMSG_FIELD_NUMBER = 2;
	private java.lang.Object resmsg_;

	/**
	 * <code>required string resmsg = 2;</code>
	 * 
	 * <pre>
	 * 返回消息
	 * </pre>
	 */
	public boolean hasResmsg()
	{
	    return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	}

	/**
	 * <code>required string resmsg = 2;</code>
	 * 
	 * <pre>
	 * 返回消息
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
	 * <code>required string resmsg = 2;</code>
	 * 
	 * <pre>
	 * 返回消息
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

	private void initFields()
	{
	    rescode_ = 0;
	    resmsg_ = "";
	}

	private byte memoizedIsInitialized = -1;

	public final boolean isInitialized()
	{
	    byte isInitialized = memoizedIsInitialized;
	    if( isInitialized != -1 )
		return isInitialized == 1;

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
		output.writeInt32( 1 , rescode_ );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		output.writeBytes( 2 , getResmsgBytes( ) );
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
		size += com.google.protobuf.CodedOutputStream.computeInt32Size( 1 , rescode_ );
	    }
	    if( ( ( bitField0_ & 0x00000002 ) == 0x00000002 ) )
	    {
		size += com.google.protobuf.CodedOutputStream.computeBytesSize( 2 , getResmsgBytes( ) );
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

	public static Feedback.RspFeedback parseFrom( com.google.protobuf.ByteString data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Feedback.RspFeedback parseFrom( com.google.protobuf.ByteString data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Feedback.RspFeedback parseFrom( byte [] data ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data );
	}

	public static Feedback.RspFeedback parseFrom( byte [] data , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws com.google.protobuf.InvalidProtocolBufferException
	{
	    return PARSER.parseFrom( data , extensionRegistry );
	}

	public static Feedback.RspFeedback parseFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Feedback.RspFeedback parseFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input , extensionRegistry );
	}

	public static Feedback.RspFeedback parseDelimitedFrom( java.io.InputStream input ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input );
	}

	public static Feedback.RspFeedback parseDelimitedFrom( java.io.InputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
	{
	    return PARSER.parseDelimitedFrom( input , extensionRegistry );
	}

	public static Feedback.RspFeedback parseFrom( com.google.protobuf.CodedInputStream input ) throws java.io.IOException
	{
	    return PARSER.parseFrom( input );
	}

	public static Feedback.RspFeedback parseFrom( com.google.protobuf.CodedInputStream input , com.google.protobuf.ExtensionRegistryLite extensionRegistry ) throws java.io.IOException
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

	public static Builder newBuilder( Feedback.RspFeedback prototype )
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
	 * Protobuf type {@code RspFeedback}
	 */
	public static final class Builder extends com.google.protobuf.GeneratedMessage.Builder< Builder > implements Feedback.RspFeedbackOrBuilder
	{
	    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor()
	    {
		return Feedback.internal_static_RspFeedback_descriptor;
	    }

	    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable()
	    {
		return Feedback.internal_static_RspFeedback_fieldAccessorTable.ensureFieldAccessorsInitialized( Feedback.RspFeedback.class , Feedback.RspFeedback.Builder.class );
	    }

	    // Construct using Feedback.RspFeedback.newBuilder()
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
		rescode_ = 0;
		bitField0_ = ( bitField0_ & ~0x00000001 );
		resmsg_ = "";
		bitField0_ = ( bitField0_ & ~0x00000002 );
		return this;
	    }

	    public Builder clone()
	    {
		return create( ).mergeFrom( buildPartial( ) );
	    }

	    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType()
	    {
		return Feedback.internal_static_RspFeedback_descriptor;
	    }

	    public Feedback.RspFeedback getDefaultInstanceForType()
	    {
		return Feedback.RspFeedback.getDefaultInstance( );
	    }

	    public Feedback.RspFeedback build()
	    {
		Feedback.RspFeedback result = buildPartial( );
		if( !result.isInitialized( ) )
		{
		    throw newUninitializedMessageException( result );
		}
		return result;
	    }

	    public Feedback.RspFeedback buildPartial()
	    {
		Feedback.RspFeedback result = new Feedback.RspFeedback( this );
		int from_bitField0_ = bitField0_;
		int to_bitField0_ = 0;
		if( ( ( from_bitField0_ & 0x00000001 ) == 0x00000001 ) )
		{
		    to_bitField0_ |= 0x00000001;
		}
		result.rescode_ = rescode_;
		if( ( ( from_bitField0_ & 0x00000002 ) == 0x00000002 ) )
		{
		    to_bitField0_ |= 0x00000002;
		}
		result.resmsg_ = resmsg_;
		result.bitField0_ = to_bitField0_;
		onBuilt( );
		return result;
	    }

	    public Builder mergeFrom( com.google.protobuf.Message other )
	    {
		if( other instanceof Feedback.RspFeedback )
		{
		    return mergeFrom( (Feedback.RspFeedback)other );
		}
		else
		{
		    super.mergeFrom( other );
		    return this;
		}
	    }

	    public Builder mergeFrom( Feedback.RspFeedback other )
	    {
		if( other == Feedback.RspFeedback.getDefaultInstance( ) )
		    return this;
		if( other.hasRescode( ) )
		{
		    setRescode( other.getRescode( ) );
		}
		if( other.hasResmsg( ) )
		{
		    bitField0_ |= 0x00000002;
		    resmsg_ = other.resmsg_;
		    onChanged( );
		}
		this.mergeUnknownFields( other.getUnknownFields( ) );
		return this;
	    }

	    public final boolean isInitialized()
	    {
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
		Feedback.RspFeedback parsedMessage = null;
		try
		{
		    parsedMessage = PARSER.parsePartialFrom( input , extensionRegistry );
		}
		catch ( com.google.protobuf.InvalidProtocolBufferException e )
		{
		    parsedMessage = (Feedback.RspFeedback)e.getUnfinishedMessage( );
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

	    // required int32 rescode = 1;
	    private int rescode_;

	    /**
	     * <code>required int32 rescode = 1;</code>
	     * 
	     * <pre>
	     * 返回码：0=成功，1=失败
	     * </pre>
	     */
	    public boolean hasRescode()
	    {
		return ( ( bitField0_ & 0x00000001 ) == 0x00000001 );
	    }

	    /**
	     * <code>required int32 rescode = 1;</code>
	     * 
	     * <pre>
	     * 返回码：0=成功，1=失败
	     * </pre>
	     */
	    public int getRescode()
	    {
		return rescode_;
	    }

	    /**
	     * <code>required int32 rescode = 1;</code>
	     * 
	     * <pre>
	     * 返回码：0=成功，1=失败
	     * </pre>
	     */
	    public Builder setRescode( int value )
	    {
		bitField0_ |= 0x00000001;
		rescode_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required int32 rescode = 1;</code>
	     * 
	     * <pre>
	     * 返回码：0=成功，1=失败
	     * </pre>
	     */
	    public Builder clearRescode()
	    {
		bitField0_ = ( bitField0_ & ~0x00000001 );
		rescode_ = 0;
		onChanged( );
		return this;
	    }

	    // required string resmsg = 2;
	    private java.lang.Object resmsg_ = "";

	    /**
	     * <code>required string resmsg = 2;</code>
	     * 
	     * <pre>
	     * 返回消息
	     * </pre>
	     */
	    public boolean hasResmsg()
	    {
		return ( ( bitField0_ & 0x00000002 ) == 0x00000002 );
	    }

	    /**
	     * <code>required string resmsg = 2;</code>
	     * 
	     * <pre>
	     * 返回消息
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
	     * <code>required string resmsg = 2;</code>
	     * 
	     * <pre>
	     * 返回消息
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
	     * <code>required string resmsg = 2;</code>
	     * 
	     * <pre>
	     * 返回消息
	     * </pre>
	     */
	    public Builder setResmsg( java.lang.String value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000002;
		resmsg_ = value;
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string resmsg = 2;</code>
	     * 
	     * <pre>
	     * 返回消息
	     * </pre>
	     */
	    public Builder clearResmsg()
	    {
		bitField0_ = ( bitField0_ & ~0x00000002 );
		resmsg_ = getDefaultInstance( ).getResmsg( );
		onChanged( );
		return this;
	    }

	    /**
	     * <code>required string resmsg = 2;</code>
	     * 
	     * <pre>
	     * 返回消息
	     * </pre>
	     */
	    public Builder setResmsgBytes( com.google.protobuf.ByteString value )
	    {
		if( value == null )
		{
		    throw new NullPointerException( );
		}
		bitField0_ |= 0x00000002;
		resmsg_ = value;
		onChanged( );
		return this;
	    }

	    // @@protoc_insertion_point(builder_scope:RspFeedback)
	}

	static
	{
	    defaultInstance = new RspFeedback( true );
	    defaultInstance.initFields( );
	}

	// @@protoc_insertion_point(class_scope:RspFeedback)
    }

    private static com.google.protobuf.Descriptors.Descriptor internal_static_ReqFeedback_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_ReqFeedback_fieldAccessorTable;
    private static com.google.protobuf.Descriptors.Descriptor internal_static_RspFeedback_descriptor;
    private static com.google.protobuf.GeneratedMessage.FieldAccessorTable internal_static_RspFeedback_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor()
    {
	return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
    static
    {
	java.lang.String[] descriptorData = { "\n\016Feedback.proto\"u\n\013ReqFeedback\022\024\n\014feedb" + "ackType\030\001 \002(\005\022\023\n\013description\030\002 \002(\t\022\023\n\013ma"
		+ "chineType\030\003 \001(\t\022\021\n\timageUrls\030\004 \003(\t\022\023\n\013co" + "ntactInfo\030\005 \001(\t\".\n\013RspFeedback\022\017\n\007rescod"
		+ "e\030\001 \002(\005\022\016\n\006resmsg\030\002 \002(\t" };
	com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner( )
	{
	    public com.google.protobuf.ExtensionRegistry assignDescriptors( com.google.protobuf.Descriptors.FileDescriptor root )
	    {
		descriptor = root;
		internal_static_ReqFeedback_descriptor = getDescriptor( ).getMessageTypes( ).get( 0 );
		internal_static_ReqFeedback_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable( internal_static_ReqFeedback_descriptor ,
			new java.lang.String [] { "FeedbackType" , "Description" , "MachineType" , "ImageUrls" , "ContactInfo" , } );
		internal_static_RspFeedback_descriptor = getDescriptor( ).getMessageTypes( ).get( 1 );
		internal_static_RspFeedback_fieldAccessorTable = new com.google.protobuf.GeneratedMessage.FieldAccessorTable( internal_static_RspFeedback_descriptor ,
			new java.lang.String [] { "Rescode" , "Resmsg" , } );
		return null;
	    }
	};
	com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom( descriptorData , new com.google.protobuf.Descriptors.FileDescriptor [] { } , assigner );
    }

    // @@protoc_insertion_point(outer_class_scope)
}
