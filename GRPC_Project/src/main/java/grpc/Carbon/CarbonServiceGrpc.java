package grpc.Carbon;

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
    comments = "Source: carbonService.proto")
public final class carbonServiceGrpc {

  private carbonServiceGrpc() {}

  public static final String SERVICE_NAME = "carbonService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.Carbon.carbonFlightRequest,
      grpc.Carbon.responseString> getCalculateCarbonFlightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculateCarbonFlight",
      requestType = grpc.Carbon.carbonFlightRequest.class,
      responseType = grpc.Carbon.responseString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Carbon.carbonFlightRequest,
      grpc.Carbon.responseString> getCalculateCarbonFlightMethod() {
    io.grpc.MethodDescriptor<grpc.Carbon.carbonFlightRequest, grpc.Carbon.responseString> getCalculateCarbonFlightMethod;
    if ((getCalculateCarbonFlightMethod = carbonServiceGrpc.getCalculateCarbonFlightMethod) == null) {
      synchronized (carbonServiceGrpc.class) {
        if ((getCalculateCarbonFlightMethod = carbonServiceGrpc.getCalculateCarbonFlightMethod) == null) {
          carbonServiceGrpc.getCalculateCarbonFlightMethod = getCalculateCarbonFlightMethod = 
              io.grpc.MethodDescriptor.<grpc.Carbon.carbonFlightRequest, grpc.Carbon.responseString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "carbonService", "CalculateCarbonFlight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Carbon.carbonFlightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Carbon.responseString.getDefaultInstance()))
                  .setSchemaDescriptor(new carbonServiceMethodDescriptorSupplier("CalculateCarbonFlight"))
                  .build();
          }
        }
     }
     return getCalculateCarbonFlightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.Carbon.carbonDriveRequest,
      grpc.Carbon.responseString> getCalculateCarbonDriveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculateCarbonDrive",
      requestType = grpc.Carbon.carbonDriveRequest.class,
      responseType = grpc.Carbon.responseString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.Carbon.carbonDriveRequest,
      grpc.Carbon.responseString> getCalculateCarbonDriveMethod() {
    io.grpc.MethodDescriptor<grpc.Carbon.carbonDriveRequest, grpc.Carbon.responseString> getCalculateCarbonDriveMethod;
    if ((getCalculateCarbonDriveMethod = carbonServiceGrpc.getCalculateCarbonDriveMethod) == null) {
      synchronized (carbonServiceGrpc.class) {
        if ((getCalculateCarbonDriveMethod = carbonServiceGrpc.getCalculateCarbonDriveMethod) == null) {
          carbonServiceGrpc.getCalculateCarbonDriveMethod = getCalculateCarbonDriveMethod = 
              io.grpc.MethodDescriptor.<grpc.Carbon.carbonDriveRequest, grpc.Carbon.responseString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "carbonService", "CalculateCarbonDrive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Carbon.carbonDriveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.Carbon.responseString.getDefaultInstance()))
                  .setSchemaDescriptor(new carbonServiceMethodDescriptorSupplier("CalculateCarbonDrive"))
                  .build();
          }
        }
     }
     return getCalculateCarbonDriveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static carbonServiceStub newStub(io.grpc.Channel channel) {
    return new carbonServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static carbonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new carbonServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static carbonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new carbonServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class carbonServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void calculateCarbonFlight(grpc.Carbon.carbonFlightRequest request,
        io.grpc.stub.StreamObserver<grpc.Carbon.responseString> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateCarbonFlightMethod(), responseObserver);
    }

    /**
     */
    public void calculateCarbonDrive(grpc.Carbon.carbonDriveRequest request,
        io.grpc.stub.StreamObserver<grpc.Carbon.responseString> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateCarbonDriveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateCarbonFlightMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Carbon.carbonFlightRequest,
                grpc.Carbon.responseString>(
                  this, METHODID_CALCULATE_CARBON_FLIGHT)))
          .addMethod(
            getCalculateCarbonDriveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.Carbon.carbonDriveRequest,
                grpc.Carbon.responseString>(
                  this, METHODID_CALCULATE_CARBON_DRIVE)))
          .build();
    }
  }

  /**
   */
  public static final class carbonServiceStub extends io.grpc.stub.AbstractStub<carbonServiceStub> {
    private carbonServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private carbonServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected carbonServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new carbonServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void calculateCarbonFlight(grpc.Carbon.carbonFlightRequest request,
        io.grpc.stub.StreamObserver<grpc.Carbon.responseString> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateCarbonFlightMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void calculateCarbonDrive(grpc.Carbon.carbonDriveRequest request,
        io.grpc.stub.StreamObserver<grpc.Carbon.responseString> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateCarbonDriveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class carbonServiceBlockingStub extends io.grpc.stub.AbstractStub<carbonServiceBlockingStub> {
    private carbonServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private carbonServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected carbonServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new carbonServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public grpc.Carbon.responseString calculateCarbonFlight(grpc.Carbon.carbonFlightRequest request) {
      return blockingUnaryCall(
          getChannel(), getCalculateCarbonFlightMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.Carbon.responseString calculateCarbonDrive(grpc.Carbon.carbonDriveRequest request) {
      return blockingUnaryCall(
          getChannel(), getCalculateCarbonDriveMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class carbonServiceFutureStub extends io.grpc.stub.AbstractStub<carbonServiceFutureStub> {
    private carbonServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private carbonServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected carbonServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new carbonServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Carbon.responseString> calculateCarbonFlight(
        grpc.Carbon.carbonFlightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculateCarbonFlightMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.Carbon.responseString> calculateCarbonDrive(
        grpc.Carbon.carbonDriveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculateCarbonDriveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE_CARBON_FLIGHT = 0;
  private static final int METHODID_CALCULATE_CARBON_DRIVE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final carbonServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(carbonServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE_CARBON_FLIGHT:
          serviceImpl.calculateCarbonFlight((grpc.Carbon.carbonFlightRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Carbon.responseString>) responseObserver);
          break;
        case METHODID_CALCULATE_CARBON_DRIVE:
          serviceImpl.calculateCarbonDrive((grpc.Carbon.carbonDriveRequest) request,
              (io.grpc.stub.StreamObserver<grpc.Carbon.responseString>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class carbonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    carbonServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.Carbon.CarbonServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("carbonService");
    }
  }

  private static final class carbonServiceFileDescriptorSupplier
      extends carbonServiceBaseDescriptorSupplier {
    carbonServiceFileDescriptorSupplier() {}
  }

  private static final class carbonServiceMethodDescriptorSupplier
      extends carbonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    carbonServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (carbonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new carbonServiceFileDescriptorSupplier())
              .addMethod(getCalculateCarbonFlightMethod())
              .addMethod(getCalculateCarbonDriveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
