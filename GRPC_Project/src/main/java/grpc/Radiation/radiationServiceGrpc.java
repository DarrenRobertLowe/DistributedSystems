package grpc.Radiation;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: radiationService.proto")
public final class radiationServiceGrpc {

  private radiationServiceGrpc() {}

  public static final String SERVICE_NAME = "radiationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Radiation.newRequestInteger,
      grpc.Radiation.containsString> getStreamRadiationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamRadiation",
      requestType = grpc.Radiation.newRequestInteger.class,
      responseType = grpc.Radiation.containsString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Radiation.newRequestInteger,
      grpc.Radiation.containsString> getStreamRadiationMethod() {
    io.grpc.MethodDescriptor<grpc.Radiation.newRequestInteger, grpc.Radiation.containsString> getStreamRadiationMethod;
    if ((getStreamRadiationMethod = radiationServiceGrpc.getStreamRadiationMethod) == null) {
      synchronized (radiationServiceGrpc.class) {
        if ((getStreamRadiationMethod = radiationServiceGrpc.getStreamRadiationMethod) == null) {
          radiationServiceGrpc.getStreamRadiationMethod = getStreamRadiationMethod = 
              io.grpc.MethodDescriptor.<grpc.Radiation.newRequestInteger, grpc.Radiation.containsString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "radiationService", "StreamRadiation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Radiation.newRequestInteger.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Radiation.containsString.getDefaultInstance()))
                  .setSchemaDescriptor(new radiationServiceMethodDescriptorSupplier("StreamRadiation"))
                  .build();
          }
        }
     }
     return getStreamRadiationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Radiation.radiationLevels,
      grpc.Radiation.levelsStream> getGetRadiationLevelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRadiationLevels",
      requestType = grpc.Radiation.radiationLevels.class,
      responseType = grpc.Radiation.levelsStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Radiation.radiationLevels,
      grpc.Radiation.levelsStream> getGetRadiationLevelsMethod() {
    io.grpc.MethodDescriptor<grpc.Radiation.radiationLevels, grpc.Radiation.levelsStream> getGetRadiationLevelsMethod;
    if ((getGetRadiationLevelsMethod = radiationServiceGrpc.getGetRadiationLevelsMethod) == null) {
      synchronized (radiationServiceGrpc.class) {
        if ((getGetRadiationLevelsMethod = radiationServiceGrpc.getGetRadiationLevelsMethod) == null) {
          radiationServiceGrpc.getGetRadiationLevelsMethod = getGetRadiationLevelsMethod = 
              io.grpc.MethodDescriptor.<grpc.Radiation.radiationLevels, grpc.Radiation.levelsStream>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "radiationService", "GetRadiationLevels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Radiation.radiationLevels.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Radiation.levelsStream.getDefaultInstance()))
                  .setSchemaDescriptor(new radiationServiceMethodDescriptorSupplier("GetRadiationLevels"))
                  .build();
          }
        }
     }
     return getGetRadiationLevelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Radiation.requestRadiationAlerts,
      grpc.Radiation.radiationAlert> getGetRadiationWarningsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRadiationWarnings",
      requestType = grpc.Radiation.requestRadiationAlerts.class,
      responseType = grpc.Radiation.radiationAlert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Radiation.requestRadiationAlerts,
      grpc.Radiation.radiationAlert> getGetRadiationWarningsMethod() {
    io.grpc.MethodDescriptor<grpc.Radiation.requestRadiationAlerts, grpc.Radiation.radiationAlert> getGetRadiationWarningsMethod;
    if ((getGetRadiationWarningsMethod = radiationServiceGrpc.getGetRadiationWarningsMethod) == null) {
      synchronized (radiationServiceGrpc.class) {
        if ((getGetRadiationWarningsMethod = radiationServiceGrpc.getGetRadiationWarningsMethod) == null) {
          radiationServiceGrpc.getGetRadiationWarningsMethod = getGetRadiationWarningsMethod = 
              io.grpc.MethodDescriptor.<grpc.Radiation.requestRadiationAlerts, grpc.Radiation.radiationAlert>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "radiationService", "GetRadiationWarnings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Radiation.requestRadiationAlerts.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Radiation.radiationAlert.getDefaultInstance()))
                  .setSchemaDescriptor(new radiationServiceMethodDescriptorSupplier("GetRadiationWarnings"))
                  .build();
          }
        }
     }
     return getGetRadiationWarningsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Radiation.containsString,
      grpc.Radiation.containsString> getSendStringClientStreamingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendStringClientStreaming",
      requestType = grpc.Radiation.containsString.class,
      responseType = grpc.Radiation.containsString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.Radiation.containsString,
      grpc.Radiation.containsString> getSendStringClientStreamingMethod() {
    io.grpc.MethodDescriptor<grpc.Radiation.containsString, grpc.Radiation.containsString> getSendStringClientStreamingMethod;
    if ((getSendStringClientStreamingMethod = radiationServiceGrpc.getSendStringClientStreamingMethod) == null) {
      synchronized (radiationServiceGrpc.class) {
        if ((getSendStringClientStreamingMethod = radiationServiceGrpc.getSendStringClientStreamingMethod) == null) {
          radiationServiceGrpc.getSendStringClientStreamingMethod = getSendStringClientStreamingMethod = 
              io.grpc.MethodDescriptor.<grpc.Radiation.containsString, grpc.Radiation.containsString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "radiationService", "SendStringClientStreaming"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Radiation.containsString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Radiation.containsString.getDefaultInstance()))
                  .setSchemaDescriptor(new radiationServiceMethodDescriptorSupplier("SendStringClientStreaming"))
                  .build();
          }
        }
     }
     return getSendStringClientStreamingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static radiationServiceStub newStub(io.grpc.Channel channel) {
    return new radiationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static radiationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new radiationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static radiationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new radiationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class radiationServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *rpc StreamRadiation(stream radiationTrack) returns (radiationResponse){}			// client to server streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.Radiation.newRequestInteger> streamRadiation(
        io.grpc.stub.StreamObserver<grpc.Radiation.containsString> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamRadiationMethod(), responseObserver);
    }

    /**
     */
    public void getRadiationLevels(grpc.Radiation.radiationLevels request,
        io.grpc.stub.StreamObserver<grpc.Radiation.levelsStream> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRadiationLevelsMethod(), responseObserver);
    }

    /**
     */
    public void getRadiationWarnings(grpc.Radiation.requestRadiationAlerts request,
        io.grpc.stub.StreamObserver<grpc.Radiation.radiationAlert> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRadiationWarningsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.Radiation.containsString> sendStringClientStreaming(
        io.grpc.stub.StreamObserver<grpc.Radiation.containsString> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendStringClientStreamingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamRadiationMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.Radiation.newRequestInteger,
                grpc.Radiation.containsString>(
                  this, METHODID_STREAM_RADIATION)))
          .addMethod(
            getGetRadiationLevelsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.Radiation.radiationLevels,
                grpc.Radiation.levelsStream>(
                  this, METHODID_GET_RADIATION_LEVELS)))
          .addMethod(
            getGetRadiationWarningsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.Radiation.requestRadiationAlerts,
                grpc.Radiation.radiationAlert>(
                  this, METHODID_GET_RADIATION_WARNINGS)))
          .addMethod(
            getSendStringClientStreamingMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.Radiation.containsString,
                grpc.Radiation.containsString>(
                  this, METHODID_SEND_STRING_CLIENT_STREAMING)))
          .build();
    }
  }

  /**
   */
  public static final class radiationServiceStub extends io.grpc.stub.AbstractStub<radiationServiceStub> {
    private radiationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private radiationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected radiationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new radiationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *rpc StreamRadiation(stream radiationTrack) returns (radiationResponse){}			// client to server streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.Radiation.newRequestInteger> streamRadiation(
        io.grpc.stub.StreamObserver<grpc.Radiation.containsString> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getStreamRadiationMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getRadiationLevels(grpc.Radiation.radiationLevels request,
        io.grpc.stub.StreamObserver<grpc.Radiation.levelsStream> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetRadiationLevelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getRadiationWarnings(grpc.Radiation.requestRadiationAlerts request,
        io.grpc.stub.StreamObserver<grpc.Radiation.radiationAlert> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetRadiationWarningsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.Radiation.containsString> sendStringClientStreaming(
        io.grpc.stub.StreamObserver<grpc.Radiation.containsString> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSendStringClientStreamingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class radiationServiceBlockingStub extends io.grpc.stub.AbstractStub<radiationServiceBlockingStub> {
    private radiationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private radiationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected radiationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new radiationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<grpc.Radiation.levelsStream> getRadiationLevels(
        grpc.Radiation.radiationLevels request) {
      return blockingServerStreamingCall(
          getChannel(), getGetRadiationLevelsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.Radiation.radiationAlert> getRadiationWarnings(
        grpc.Radiation.requestRadiationAlerts request) {
      return blockingServerStreamingCall(
          getChannel(), getGetRadiationWarningsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class radiationServiceFutureStub extends io.grpc.stub.AbstractStub<radiationServiceFutureStub> {
    private radiationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private radiationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected radiationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new radiationServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_RADIATION_LEVELS = 0;
  private static final int METHODID_GET_RADIATION_WARNINGS = 1;
  private static final int METHODID_STREAM_RADIATION = 2;
  private static final int METHODID_SEND_STRING_CLIENT_STREAMING = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final radiationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(radiationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RADIATION_LEVELS:
          serviceImpl.getRadiationLevels((grpc.Radiation.radiationLevels) request,
              (io.grpc.stub.StreamObserver<grpc.Radiation.levelsStream>) responseObserver);
          break;
        case METHODID_GET_RADIATION_WARNINGS:
          serviceImpl.getRadiationWarnings((grpc.Radiation.requestRadiationAlerts) request,
              (io.grpc.stub.StreamObserver<grpc.Radiation.radiationAlert>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_RADIATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamRadiation(
              (io.grpc.stub.StreamObserver<grpc.Radiation.containsString>) responseObserver);
        case METHODID_SEND_STRING_CLIENT_STREAMING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendStringClientStreaming(
              (io.grpc.stub.StreamObserver<grpc.Radiation.containsString>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class radiationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    radiationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Radiation.RadiationServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("radiationService");
    }
  }

  private static final class radiationServiceFileDescriptorSupplier
      extends radiationServiceBaseDescriptorSupplier {
    radiationServiceFileDescriptorSupplier() {}
  }

  private static final class radiationServiceMethodDescriptorSupplier
      extends radiationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    radiationServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (radiationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new radiationServiceFileDescriptorSupplier())
              .addMethod(getStreamRadiationMethod())
              .addMethod(getGetRadiationLevelsMethod())
              .addMethod(getGetRadiationWarningsMethod())
              .addMethod(getSendStringClientStreamingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
