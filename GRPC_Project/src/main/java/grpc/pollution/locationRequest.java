// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: pollutionService.proto

package grpc.pollution;

/**
 * <pre>
 * GetLocalAirPollution
 * With this method, clients send their geographic location to
 * the server so that the server can respond with information
 * regarding air pollution in the area of the client.
 * Note: according to a topic on StackOverflow, int32 would give
 * an accuracy anywhere on Earth with a precision &lt; 1cm, so it's
 * more than sufficient for our needs.
 * </pre>
 *
 * Protobuf type {@code locationRequest}
 */
public  final class locationRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:locationRequest)
    locationRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use locationRequest.newBuilder() to construct.
  private locationRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private locationRequest() {
    longitude_ = 0;
    latitude_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private locationRequest(
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

            longitude_ = input.readInt32();
            break;
          }
          case 16: {

            latitude_ = input.readInt32();
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
    return grpc.pollution.PollutionServiceImpl.internal_static_locationRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.pollution.PollutionServiceImpl.internal_static_locationRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.pollution.locationRequest.class, grpc.pollution.locationRequest.Builder.class);
  }

  public static final int LONGITUDE_FIELD_NUMBER = 1;
  private int longitude_;
  /**
   * <code>int32 longitude = 1;</code>
   */
  public int getLongitude() {
    return longitude_;
  }

  public static final int LATITUDE_FIELD_NUMBER = 2;
  private int latitude_;
  /**
   * <code>int32 latitude = 2;</code>
   */
  public int getLatitude() {
    return latitude_;
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
    if (longitude_ != 0) {
      output.writeInt32(1, longitude_);
    }
    if (latitude_ != 0) {
      output.writeInt32(2, latitude_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (longitude_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, longitude_);
    }
    if (latitude_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, latitude_);
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
    if (!(obj instanceof grpc.pollution.locationRequest)) {
      return super.equals(obj);
    }
    grpc.pollution.locationRequest other = (grpc.pollution.locationRequest) obj;

    boolean result = true;
    result = result && (getLongitude()
        == other.getLongitude());
    result = result && (getLatitude()
        == other.getLatitude());
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
    hash = (37 * hash) + LONGITUDE_FIELD_NUMBER;
    hash = (53 * hash) + getLongitude();
    hash = (37 * hash) + LATITUDE_FIELD_NUMBER;
    hash = (53 * hash) + getLatitude();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.pollution.locationRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.pollution.locationRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.pollution.locationRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.pollution.locationRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.pollution.locationRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.pollution.locationRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.pollution.locationRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.pollution.locationRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.pollution.locationRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.pollution.locationRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.pollution.locationRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.pollution.locationRequest parseFrom(
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
  public static Builder newBuilder(grpc.pollution.locationRequest prototype) {
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
   * <pre>
   * GetLocalAirPollution
   * With this method, clients send their geographic location to
   * the server so that the server can respond with information
   * regarding air pollution in the area of the client.
   * Note: according to a topic on StackOverflow, int32 would give
   * an accuracy anywhere on Earth with a precision &lt; 1cm, so it's
   * more than sufficient for our needs.
   * </pre>
   *
   * Protobuf type {@code locationRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:locationRequest)
      grpc.pollution.locationRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.pollution.PollutionServiceImpl.internal_static_locationRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.pollution.PollutionServiceImpl.internal_static_locationRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.pollution.locationRequest.class, grpc.pollution.locationRequest.Builder.class);
    }

    // Construct using grpc.pollution.locationRequest.newBuilder()
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
      longitude_ = 0;

      latitude_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.pollution.PollutionServiceImpl.internal_static_locationRequest_descriptor;
    }

    @java.lang.Override
    public grpc.pollution.locationRequest getDefaultInstanceForType() {
      return grpc.pollution.locationRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.pollution.locationRequest build() {
      grpc.pollution.locationRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.pollution.locationRequest buildPartial() {
      grpc.pollution.locationRequest result = new grpc.pollution.locationRequest(this);
      result.longitude_ = longitude_;
      result.latitude_ = latitude_;
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
      if (other instanceof grpc.pollution.locationRequest) {
        return mergeFrom((grpc.pollution.locationRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.pollution.locationRequest other) {
      if (other == grpc.pollution.locationRequest.getDefaultInstance()) return this;
      if (other.getLongitude() != 0) {
        setLongitude(other.getLongitude());
      }
      if (other.getLatitude() != 0) {
        setLatitude(other.getLatitude());
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
      grpc.pollution.locationRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.pollution.locationRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int longitude_ ;
    /**
     * <code>int32 longitude = 1;</code>
     */
    public int getLongitude() {
      return longitude_;
    }
    /**
     * <code>int32 longitude = 1;</code>
     */
    public Builder setLongitude(int value) {
      
      longitude_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 longitude = 1;</code>
     */
    public Builder clearLongitude() {
      
      longitude_ = 0;
      onChanged();
      return this;
    }

    private int latitude_ ;
    /**
     * <code>int32 latitude = 2;</code>
     */
    public int getLatitude() {
      return latitude_;
    }
    /**
     * <code>int32 latitude = 2;</code>
     */
    public Builder setLatitude(int value) {
      
      latitude_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 latitude = 2;</code>
     */
    public Builder clearLatitude() {
      
      latitude_ = 0;
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


    // @@protoc_insertion_point(builder_scope:locationRequest)
  }

  // @@protoc_insertion_point(class_scope:locationRequest)
  private static final grpc.pollution.locationRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.pollution.locationRequest();
  }

  public static grpc.pollution.locationRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<locationRequest>
      PARSER = new com.google.protobuf.AbstractParser<locationRequest>() {
    @java.lang.Override
    public locationRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new locationRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<locationRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<locationRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.pollution.locationRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
