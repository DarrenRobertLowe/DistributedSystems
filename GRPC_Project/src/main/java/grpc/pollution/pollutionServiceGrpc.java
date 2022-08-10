package grpc.pollution;

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
    comments = "Source: pollutionService.proto")
public final class pollutionServiceGrpc {

  private pollutionServiceGrpc() {}

  public static final String SERVICE_NAME = "pollutionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.pollution.airPollution,
      grpc.pollution.response> getStreamPollutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamPollution",
      requestType = grpc.pollution.airPollution.class,
      responseType = grpc.pollution.response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.pollution.airPollution,
      grpc.pollution.response> getStreamPollutionMethod() {
    io.grpc.MethodDescriptor<grpc.pollution.airPollution, grpc.pollution.response> getStreamPollutionMethod;
    if ((getStreamPollutionMethod = pollutionServiceGrpc.getStreamPollutionMethod) == null) {
      synchronized (pollutionServiceGrpc.class) {
        if ((getStreamPollutionMethod = pollutionServiceGrpc.getStreamPollutionMethod) == null) {
          pollutionServiceGrpc.getStreamPollutionMethod = getStreamPollutionMethod = 
              io.grpc.MethodDescriptor.<grpc.pollution.airPollution, grpc.pollution.response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "pollutionService", "StreamPollution"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pollution.airPollution.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pollution.response.getDefaultInstance()))
                  .setSchemaDescriptor(new pollutionServiceMethodDescriptorSupplier("StreamPollution"))
                  .build();
          }
        }
     }
     return getStreamPollutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.pollution.locationRequest,
      grpc.pollution.regionalPollutionResponse> getGetLocalAirPollutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLocalAirPollution",
      requestType = grpc.pollution.locationRequest.class,
      responseType = grpc.pollution.regionalPollutionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.pollution.locationRequest,
      grpc.pollution.regionalPollutionResponse> getGetLocalAirPollutionMethod() {
    io.grpc.MethodDescriptor<grpc.pollution.locationRequest, grpc.pollution.regionalPollutionResponse> getGetLocalAirPollutionMethod;
    if ((getGetLocalAirPollutionMethod = pollutionServiceGrpc.getGetLocalAirPollutionMethod) == null) {
      synchronized (pollutionServiceGrpc.class) {
        if ((getGetLocalAirPollutionMethod = pollutionServiceGrpc.getGetLocalAirPollutionMethod) == null) {
          pollutionServiceGrpc.getGetLocalAirPollutionMethod = getGetLocalAirPollutionMethod = 
              io.grpc.MethodDescriptor.<grpc.pollution.locationRequest, grpc.pollution.regionalPollutionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "pollutionService", "GetLocalAirPollution"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pollution.locationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pollution.regionalPollutionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new pollutionServiceMethodDescriptorSupplier("GetLocalAirPollution"))
                  .build();
          }
        }
     }
     return getGetLocalAirPollutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.pollution.deviceStatusRequest,
      grpc.pollution.deviceStatusResponse> getGetDeviceStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeviceStatus",
      requestType = grpc.pollution.deviceStatusRequest.class,
      responseType = grpc.pollution.deviceStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.pollution.deviceStatusRequest,
      grpc.pollution.deviceStatusResponse> getGetDeviceStatusMethod() {
    io.grpc.MethodDescriptor<grpc.pollution.deviceStatusRequest, grpc.pollution.deviceStatusResponse> getGetDeviceStatusMethod;
    if ((getGetDeviceStatusMethod = pollutionServiceGrpc.getGetDeviceStatusMethod) == null) {
      synchronized (pollutionServiceGrpc.class) {
        if ((getGetDeviceStatusMethod = pollutionServiceGrpc.getGetDeviceStatusMethod) == null) {
          pollutionServiceGrpc.getGetDeviceStatusMethod = getGetDeviceStatusMethod = 
              io.grpc.MethodDescriptor.<grpc.pollution.deviceStatusRequest, grpc.pollution.deviceStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "pollutionService", "GetDeviceStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pollution.deviceStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pollution.deviceStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new pollutionServiceMethodDescriptorSupplier("GetDeviceStatus"))
                  .build();
          }
        }
     }
     return getGetDeviceStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.pollution.allDeviceStatusRequest,
      grpc.pollution.allDeviceStatusResponse> getGetAllDeviceStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllDeviceStatus",
      requestType = grpc.pollution.allDeviceStatusRequest.class,
      responseType = grpc.pollution.allDeviceStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.pollution.allDeviceStatusRequest,
      grpc.pollution.allDeviceStatusResponse> getGetAllDeviceStatusMethod() {
    io.grpc.MethodDescriptor<grpc.pollution.allDeviceStatusRequest, grpc.pollution.allDeviceStatusResponse> getGetAllDeviceStatusMethod;
    if ((getGetAllDeviceStatusMethod = pollutionServiceGrpc.getGetAllDeviceStatusMethod) == null) {
      synchronized (pollutionServiceGrpc.class) {
        if ((getGetAllDeviceStatusMethod = pollutionServiceGrpc.getGetAllDeviceStatusMethod) == null) {
          pollutionServiceGrpc.getGetAllDeviceStatusMethod = getGetAllDeviceStatusMethod = 
              io.grpc.MethodDescriptor.<grpc.pollution.allDeviceStatusRequest, grpc.pollution.allDeviceStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "pollutionService", "GetAllDeviceStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pollution.allDeviceStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.pollution.allDeviceStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new pollutionServiceMethodDescriptorSupplier("GetAllDeviceStatus"))
                  .build();
          }
        }
     }
     return getGetAllDeviceStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static pollutionServiceStub newStub(io.grpc.Channel channel) {
    return new pollutionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static pollutionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new pollutionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static pollutionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new pollutionServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class pollutionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.pollution.airPollution> streamPollution(
        io.grpc.stub.StreamObserver<grpc.pollution.response> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamPollutionMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.pollution.locationRequest> getLocalAirPollution(
        io.grpc.stub.StreamObserver<grpc.pollution.regionalPollutionResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetLocalAirPollutionMethod(), responseObserver);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void getDeviceStatus(grpc.pollution.deviceStatusRequest request,
        io.grpc.stub.StreamObserver<grpc.pollution.deviceStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeviceStatusMethod(), responseObserver);
    }

    /**
     */
    public void getAllDeviceStatus(grpc.pollution.allDeviceStatusRequest request,
        io.grpc.stub.StreamObserver<grpc.pollution.allDeviceStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllDeviceStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamPollutionMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.pollution.airPollution,
                grpc.pollution.response>(
                  this, METHODID_STREAM_POLLUTION)))
          .addMethod(
            getGetLocalAirPollutionMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.pollution.locationRequest,
                grpc.pollution.regionalPollutionResponse>(
                  this, METHODID_GET_LOCAL_AIR_POLLUTION)))
          .addMethod(
            getGetDeviceStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.pollution.deviceStatusRequest,
                grpc.pollution.deviceStatusResponse>(
                  this, METHODID_GET_DEVICE_STATUS)))
          .addMethod(
            getGetAllDeviceStatusMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.pollution.allDeviceStatusRequest,
                grpc.pollution.allDeviceStatusResponse>(
                  this, METHODID_GET_ALL_DEVICE_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class pollutionServiceStub extends io.grpc.stub.AbstractStub<pollutionServiceStub> {
    private pollutionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pollutionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pollutionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pollutionServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.pollution.airPollution> streamPollution(
        io.grpc.stub.StreamObserver<grpc.pollution.response> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getStreamPollutionMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.pollution.locationRequest> getLocalAirPollution(
        io.grpc.stub.StreamObserver<grpc.pollution.regionalPollutionResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getGetLocalAirPollutionMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public void getDeviceStatus(grpc.pollution.deviceStatusRequest request,
        io.grpc.stub.StreamObserver<grpc.pollution.deviceStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDeviceStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllDeviceStatus(grpc.pollution.allDeviceStatusRequest request,
        io.grpc.stub.StreamObserver<grpc.pollution.allDeviceStatusResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllDeviceStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class pollutionServiceBlockingStub extends io.grpc.stub.AbstractStub<pollutionServiceBlockingStub> {
    private pollutionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pollutionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pollutionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pollutionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public grpc.pollution.deviceStatusResponse getDeviceStatus(grpc.pollution.deviceStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetDeviceStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<grpc.pollution.allDeviceStatusResponse> getAllDeviceStatus(
        grpc.pollution.allDeviceStatusRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllDeviceStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class pollutionServiceFutureStub extends io.grpc.stub.AbstractStub<pollutionServiceFutureStub> {
    private pollutionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private pollutionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected pollutionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new pollutionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.pollution.deviceStatusResponse> getDeviceStatus(
        grpc.pollution.deviceStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDeviceStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DEVICE_STATUS = 0;
  private static final int METHODID_GET_ALL_DEVICE_STATUS = 1;
  private static final int METHODID_STREAM_POLLUTION = 2;
  private static final int METHODID_GET_LOCAL_AIR_POLLUTION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final pollutionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(pollutionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DEVICE_STATUS:
          serviceImpl.getDeviceStatus((grpc.pollution.deviceStatusRequest) request,
              (io.grpc.stub.StreamObserver<grpc.pollution.deviceStatusResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_DEVICE_STATUS:
          serviceImpl.getAllDeviceStatus((grpc.pollution.allDeviceStatusRequest) request,
              (io.grpc.stub.StreamObserver<grpc.pollution.allDeviceStatusResponse>) responseObserver);
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
        case METHODID_STREAM_POLLUTION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamPollution(
              (io.grpc.stub.StreamObserver<grpc.pollution.response>) responseObserver);
        case METHODID_GET_LOCAL_AIR_POLLUTION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getLocalAirPollution(
              (io.grpc.stub.StreamObserver<grpc.pollution.regionalPollutionResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class pollutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    pollutionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.pollution.PollutionServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("pollutionService");
    }
  }

  private static final class pollutionServiceFileDescriptorSupplier
      extends pollutionServiceBaseDescriptorSupplier {
    pollutionServiceFileDescriptorSupplier() {}
  }

  private static final class pollutionServiceMethodDescriptorSupplier
      extends pollutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    pollutionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (pollutionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new pollutionServiceFileDescriptorSupplier())
              .addMethod(getStreamPollutionMethod())
              .addMethod(getGetLocalAirPollutionMethod())
              .addMethod(getGetDeviceStatusMethod())
              .addMethod(getGetAllDeviceStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
