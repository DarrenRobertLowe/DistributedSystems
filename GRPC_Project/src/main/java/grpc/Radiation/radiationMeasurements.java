// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: radiationService.proto

package grpc.Radiation;

/**
 * <pre>
 * For the IoT Devices
 * each IoT device will track radiation levels in the water supply
 * and forward the information to the server.
 * </pre>
 *
 * Protobuf type {@code radiationMeasurements}
 */
public  final class radiationMeasurements extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:radiationMeasurements)
    radiationMeasurementsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use radiationMeasurements.newBuilder() to construct.
  private radiationMeasurements(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private radiationMeasurements() {
    picocuries_ = 0;
    clientID_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private radiationMeasurements(
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

            picocuries_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            clientID_ = s;
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
    return grpc.Radiation.RadiationServiceImpl.internal_static_radiationMeasurements_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.Radiation.RadiationServiceImpl.internal_static_radiationMeasurements_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.Radiation.radiationMeasurements.class, grpc.Radiation.radiationMeasurements.Builder.class);
  }

  public static final int PICOCURIES_FIELD_NUMBER = 1;
  private int picocuries_;
  /**
   * <code>int32 picocuries = 1;</code>
   */
  public int getPicocuries() {
    return picocuries_;
  }

  public static final int CLIENTID_FIELD_NUMBER = 2;
  private volatile java.lang.Object clientID_;
  /**
   * <code>string clientID = 2;</code>
   */
  public java.lang.String getClientID() {
    java.lang.Object ref = clientID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      clientID_ = s;
      return s;
    }
  }
  /**
   * <code>string clientID = 2;</code>
   */
  public com.google.protobuf.ByteString
      getClientIDBytes() {
    java.lang.Object ref = clientID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      clientID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (picocuries_ != 0) {
      output.writeInt32(1, picocuries_);
    }
    if (!getClientIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, clientID_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (picocuries_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, picocuries_);
    }
    if (!getClientIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, clientID_);
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
    if (!(obj instanceof grpc.Radiation.radiationMeasurements)) {
      return super.equals(obj);
    }
    grpc.Radiation.radiationMeasurements other = (grpc.Radiation.radiationMeasurements) obj;

    boolean result = true;
    result = result && (getPicocuries()
        == other.getPicocuries());
    result = result && getClientID()
        .equals(other.getClientID());
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
    hash = (37 * hash) + PICOCURIES_FIELD_NUMBER;
    hash = (53 * hash) + getPicocuries();
    hash = (37 * hash) + CLIENTID_FIELD_NUMBER;
    hash = (53 * hash) + getClientID().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.Radiation.radiationMeasurements parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Radiation.radiationMeasurements parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Radiation.radiationMeasurements parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Radiation.radiationMeasurements parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Radiation.radiationMeasurements parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.Radiation.radiationMeasurements parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.Radiation.radiationMeasurements parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.Radiation.radiationMeasurements parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.Radiation.radiationMeasurements parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.Radiation.radiationMeasurements parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.Radiation.radiationMeasurements parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.Radiation.radiationMeasurements parseFrom(
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
  public static Builder newBuilder(grpc.Radiation.radiationMeasurements prototype) {
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
   * For the IoT Devices
   * each IoT device will track radiation levels in the water supply
   * and forward the information to the server.
   * </pre>
   *
   * Protobuf type {@code radiationMeasurements}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:radiationMeasurements)
      grpc.Radiation.radiationMeasurementsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.Radiation.RadiationServiceImpl.internal_static_radiationMeasurements_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.Radiation.RadiationServiceImpl.internal_static_radiationMeasurements_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.Radiation.radiationMeasurements.class, grpc.Radiation.radiationMeasurements.Builder.class);
    }

    // Construct using grpc.Radiation.radiationMeasurements.newBuilder()
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
      picocuries_ = 0;

      clientID_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.Radiation.RadiationServiceImpl.internal_static_radiationMeasurements_descriptor;
    }

    @java.lang.Override
    public grpc.Radiation.radiationMeasurements getDefaultInstanceForType() {
      return grpc.Radiation.radiationMeasurements.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.Radiation.radiationMeasurements build() {
      grpc.Radiation.radiationMeasurements result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.Radiation.radiationMeasurements buildPartial() {
      grpc.Radiation.radiationMeasurements result = new grpc.Radiation.radiationMeasurements(this);
      result.picocuries_ = picocuries_;
      result.clientID_ = clientID_;
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
      if (other instanceof grpc.Radiation.radiationMeasurements) {
        return mergeFrom((grpc.Radiation.radiationMeasurements)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.Radiation.radiationMeasurements other) {
      if (other == grpc.Radiation.radiationMeasurements.getDefaultInstance()) return this;
      if (other.getPicocuries() != 0) {
        setPicocuries(other.getPicocuries());
      }
      if (!other.getClientID().isEmpty()) {
        clientID_ = other.clientID_;
        onChanged();
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
      grpc.Radiation.radiationMeasurements parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.Radiation.radiationMeasurements) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int picocuries_ ;
    /**
     * <code>int32 picocuries = 1;</code>
     */
    public int getPicocuries() {
      return picocuries_;
    }
    /**
     * <code>int32 picocuries = 1;</code>
     */
    public Builder setPicocuries(int value) {
      
      picocuries_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 picocuries = 1;</code>
     */
    public Builder clearPicocuries() {
      
      picocuries_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object clientID_ = "";
    /**
     * <code>string clientID = 2;</code>
     */
    public java.lang.String getClientID() {
      java.lang.Object ref = clientID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string clientID = 2;</code>
     */
    public com.google.protobuf.ByteString
        getClientIDBytes() {
      java.lang.Object ref = clientID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        clientID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string clientID = 2;</code>
     */
    public Builder setClientID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      clientID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string clientID = 2;</code>
     */
    public Builder clearClientID() {
      
      clientID_ = getDefaultInstance().getClientID();
      onChanged();
      return this;
    }
    /**
     * <code>string clientID = 2;</code>
     */
    public Builder setClientIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      clientID_ = value;
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


    // @@protoc_insertion_point(builder_scope:radiationMeasurements)
  }

  // @@protoc_insertion_point(class_scope:radiationMeasurements)
  private static final grpc.Radiation.radiationMeasurements DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.Radiation.radiationMeasurements();
  }

  public static grpc.Radiation.radiationMeasurements getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<radiationMeasurements>
      PARSER = new com.google.protobuf.AbstractParser<radiationMeasurements>() {
    @java.lang.Override
    public radiationMeasurements parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new radiationMeasurements(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<radiationMeasurements> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<radiationMeasurements> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.Radiation.radiationMeasurements getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

