// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: carbonService.proto

package grpc.Carbon;

/**
 * Protobuf type {@code carbonDriveRequest}
 */
public  final class carbonDriveRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:carbonDriveRequest)
    carbonDriveRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use carbonDriveRequest.newBuilder() to construct.
  private carbonDriveRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private carbonDriveRequest() {
    milesInput_ = 0;
    mpgInput_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private carbonDriveRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            milesInput_ = input.readInt32();
            break;
          }
          case 16: {

            mpgInput_ = input.readInt32();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.Carbon.CarbonServiceImpl.internal_static_carbonDriveRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.Carbon.CarbonServiceImpl.internal_static_carbonDriveRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.Carbon.carbonDriveRequest.class, grpc.Carbon.carbonDriveRequest.Builder.class);
  }

  public static final int MILESINPUT_FIELD_NUMBER = 1;
  private int milesInput_;
  /**
   * <code>int32 milesInput = 1;</code>
   */
  public int getMilesInput() {
    return milesInput_;
  }

  public static final int MPGINPUT_FIELD_NUMBER = 2;
  private int mpgInput_;
  /**
   * <code>int32 mpgInput = 2;</code>
   */
  public int getMpgInput() {
    return mpgInput_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (milesInput_ != 0) {
      output.writeInt32(1, milesInput_);
    }
    if (mpgInput_ != 0) {
      output.writeInt32(2, mpgInput_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (milesInput_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, milesInput_);
    }
    if (mpgInput_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, mpgInput_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.Carbon.carbonDriveRequest)) {
      return super.equals(obj);
    }
    grpc.Carbon.carbonDriveRequest other = (grpc.Carbon.carbonDriveRequest) obj;

    boolean result = true;
    result = result && (getMilesInput()
        == other.getMilesInput());
    result = result && (getMpgInput()
        == other.getMpgInput());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MILESINPUT_FIELD_NUMBER;
    hash = (53 * hash) + getMilesInput();
    hash = (37 * hash) + MPGINPUT_FIELD_NUMBER;
    hash = (53 * hash) + getMpgInput();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.Carbon.carbonDriveRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Carbon.carbonDriveRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Carbon.carbonDriveRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Carbon.carbonDriveRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Carbon.carbonDriveRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Carbon.carbonDriveRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Carbon.carbonDriveRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.Carbon.carbonDriveRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.Carbon.carbonDriveRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.Carbon.carbonDriveRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.Carbon.carbonDriveRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.Carbon.carbonDriveRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.Carbon.carbonDriveRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code carbonDriveRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:carbonDriveRequest)
      grpc.Carbon.carbonDriveRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.Carbon.CarbonServiceImpl.internal_static_carbonDriveRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.Carbon.CarbonServiceImpl.internal_static_carbonDriveRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.Carbon.carbonDriveRequest.class, grpc.Carbon.carbonDriveRequest.Builder.class);
    }

    // Construct using grpc.Carbon.carbonDriveRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      milesInput_ = 0;

      mpgInput_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.Carbon.CarbonServiceImpl.internal_static_carbonDriveRequest_descriptor;
    }

    @java.lang.Override
    public grpc.Carbon.carbonDriveRequest getDefaultInstanceForType() {
      return grpc.Carbon.carbonDriveRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.Carbon.carbonDriveRequest build() {
      grpc.Carbon.carbonDriveRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.Carbon.carbonDriveRequest buildPartial() {
      grpc.Carbon.carbonDriveRequest result = new grpc.Carbon.carbonDriveRequest(this);
      result.milesInput_ = milesInput_;
      result.mpgInput_ = mpgInput_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.Carbon.carbonDriveRequest) {
        return mergeFrom((grpc.Carbon.carbonDriveRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.Carbon.carbonDriveRequest other) {
      if (other == grpc.Carbon.carbonDriveRequest.getDefaultInstance()) return this;
      if (other.getMilesInput() != 0) {
        setMilesInput(other.getMilesInput());
      }
      if (other.getMpgInput() != 0) {
        setMpgInput(other.getMpgInput());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.Carbon.carbonDriveRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.Carbon.carbonDriveRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int milesInput_ ;
    /**
     * <code>int32 milesInput = 1;</code>
     */
    public int getMilesInput() {
      return milesInput_;
    }
    /**
     * <code>int32 milesInput = 1;</code>
     */
    public Builder setMilesInput(int value) {
      
      milesInput_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 milesInput = 1;</code>
     */
    public Builder clearMilesInput() {
      
      milesInput_ = 0;
      onChanged();
      return this;
    }

    private int mpgInput_ ;
    /**
     * <code>int32 mpgInput = 2;</code>
     */
    public int getMpgInput() {
      return mpgInput_;
    }
    /**
     * <code>int32 mpgInput = 2;</code>
     */
    public Builder setMpgInput(int value) {
      
      mpgInput_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 mpgInput = 2;</code>
     */
    public Builder clearMpgInput() {
      
      mpgInput_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:carbonDriveRequest)
  }

  // @@protoc_insertion_point(class_scope:carbonDriveRequest)
  private static final grpc.Carbon.carbonDriveRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.Carbon.carbonDriveRequest();
  }

  public static grpc.Carbon.carbonDriveRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<carbonDriveRequest>
      PARSER = new com.google.protobuf.AbstractParser<carbonDriveRequest>() {
    @java.lang.Override
    public carbonDriveRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new carbonDriveRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<carbonDriveRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<carbonDriveRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.Carbon.carbonDriveRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

