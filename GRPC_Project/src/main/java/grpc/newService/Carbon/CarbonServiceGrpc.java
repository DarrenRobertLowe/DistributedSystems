package grpc.newService.Carbon;

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
public final class CarbonServiceGrpc {

  private CarbonServiceGrpc() {}

  public static final String SERVICE_NAME = "CarbonService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.newService.Carbon.CarbonFlightRequest,
      grpc.newService.Carbon.CarbonFlightResponse> getCalculateCarbonFlightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calculateCarbonFlight",
      requestType = grpc.newService.Carbon.CarbonFlightRequest.class,
      responseType = grpc.newService.Carbon.CarbonFlightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.newService.Carbon.CarbonFlightRequest,
      grpc.newService.Carbon.CarbonFlightResponse> getCalculateCarbonFlightMethod() {
    io.grpc.MethodDescriptor<grpc.newService.Carbon.CarbonFlightRequest, grpc.newService.Carbon.CarbonFlightResponse> getCalculateCarbonFlightMethod;
    if ((getCalculateCarbonFlightMethod = CarbonServiceGrpc.getCalculateCarbonFlightMethod) == null) {
      synchronized (CarbonServiceGrpc.class) {
        if ((getCalculateCarbonFlightMethod = CarbonServiceGrpc.getCalculateCarbonFlightMethod) == null) {
          CarbonServiceGrpc.getCalculateCarbonFlightMethod = getCalculateCarbonFlightMethod = 
              io.grpc.MethodDescriptor.<grpc.newService.Carbon.CarbonFlightRequest, grpc.newService.Carbon.CarbonFlightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CarbonService", "calculateCarbonFlight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.newService.Carbon.CarbonFlightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.newService.Carbon.CarbonFlightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CarbonServiceMethodDescriptorSupplier("calculateCarbonFlight"))
                  .build();
          }
        }
     }
     return getCalculateCarbonFlightMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.newService.Carbon.CarbonDriveRequest,
      grpc.newService.Carbon.CarbonFlightResponse> getCalculateCarbonDriveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "calculateCarbonDrive",
      requestType = grpc.newService.Carbon.CarbonDriveRequest.class,
      responseType = grpc.newService.Carbon.CarbonFlightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.newService.Carbon.CarbonDriveRequest,
      grpc.newService.Carbon.CarbonFlightResponse> getCalculateCarbonDriveMethod() {
    io.grpc.MethodDescriptor<grpc.newService.Carbon.CarbonDriveRequest, grpc.newService.Carbon.CarbonFlightResponse> getCalculateCarbonDriveMethod;
    if ((getCalculateCarbonDriveMethod = CarbonServiceGrpc.getCalculateCarbonDriveMethod) == null) {
      synchronized (CarbonServiceGrpc.class) {
        if ((getCalculateCarbonDriveMethod = CarbonServiceGrpc.getCalculateCarbonDriveMethod) == null) {
          CarbonServiceGrpc.getCalculateCarbonDriveMethod = getCalculateCarbonDriveMethod = 
              io.grpc.MethodDescriptor.<grpc.newService.Carbon.CarbonDriveRequest, grpc.newService.Carbon.CarbonFlightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CarbonService", "calculateCarbonDrive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.newService.Carbon.CarbonDriveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.newService.Carbon.CarbonFlightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CarbonServiceMethodDescriptorSupplier("calculateCarbonDrive"))
                  .build();
          }
        }
     }
     return getCalculateCarbonDriveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CarbonServiceStub newStub(io.grpc.Channel channel) {
    return new CarbonServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CarbonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CarbonServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CarbonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CarbonServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CarbonServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void calculateCarbonFlight(grpc.newService.Carbon.CarbonFlightRequest request,
        io.grpc.stub.StreamObserver<grpc.newService.Carbon.CarbonFlightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateCarbonFlightMethod(), responseObserver);
    }

    /**
     */
    public void calculateCarbonDrive(grpc.newService.Carbon.CarbonDriveRequest request,
        io.grpc.stub.StreamObserver<grpc.newService.Carbon.CarbonFlightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateCarbonDriveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateCarbonFlightMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.newService.Carbon.CarbonFlightRequest,
                grpc.newService.Carbon.CarbonFlightResponse>(
                  this, METHODID_CALCULATE_CARBON_FLIGHT)))
          .addMethod(
            getCalculateCarbonDriveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.newService.Carbon.CarbonDriveRequest,
                grpc.newService.Carbon.CarbonFlightResponse>(
                  this, METHODID_CALCULATE_CARBON_DRIVE)))
          .build();
    }
  }

  /**
   */
  public static final class CarbonServiceStub extends io.grpc.stub.AbstractStub<CarbonServiceStub> {
    private CarbonServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarbonServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarbonServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarbonServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void calculateCarbonFlight(grpc.newService.Carbon.CarbonFlightRequest request,
        io.grpc.stub.StreamObserver<grpc.newService.Carbon.CarbonFlightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateCarbonFlightMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void calculateCarbonDrive(grpc.newService.Carbon.CarbonDriveRequest request,
        io.grpc.stub.StreamObserver<grpc.newService.Carbon.CarbonFlightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateCarbonDriveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CarbonServiceBlockingStub extends io.grpc.stub.AbstractStub<CarbonServiceBlockingStub> {
    private CarbonServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarbonServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarbonServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarbonServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public grpc.newService.Carbon.CarbonFlightResponse calculateCarbonFlight(grpc.newService.Carbon.CarbonFlightRequest request) {
      return blockingUnaryCall(
          getChannel(), getCalculateCarbonFlightMethod(), getCallOptions(), request);
    }

    /**
     */
    public grpc.newService.Carbon.CarbonFlightResponse calculateCarbonDrive(grpc.newService.Carbon.CarbonDriveRequest request) {
      return blockingUnaryCall(
          getChannel(), getCalculateCarbonDriveMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CarbonServiceFutureStub extends io.grpc.stub.AbstractStub<CarbonServiceFutureStub> {
    private CarbonServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CarbonServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarbonServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CarbonServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.newService.Carbon.CarbonFlightResponse> calculateCarbonFlight(
        grpc.newService.Carbon.CarbonFlightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculateCarbonFlightMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.newService.Carbon.CarbonFlightResponse> calculateCarbonDrive(
        grpc.newService.Carbon.CarbonDriveRequest request) {
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
    private final CarbonServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CarbonServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE_CARBON_FLIGHT:
          serviceImpl.calculateCarbonFlight((grpc.newService.Carbon.CarbonFlightRequest) request,
              (io.grpc.stub.StreamObserver<grpc.newService.Carbon.CarbonFlightResponse>) responseObserver);
          break;
        case METHODID_CALCULATE_CARBON_DRIVE:
          serviceImpl.calculateCarbonDrive((grpc.newService.Carbon.CarbonDriveRequest) request,
              (io.grpc.stub.StreamObserver<grpc.newService.Carbon.CarbonFlightResponse>) responseObserver);
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

  private static abstract class CarbonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CarbonServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.newService.Carbon.CarbonServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CarbonService");
    }
  }

  private static final class CarbonServiceFileDescriptorSupplier
      extends CarbonServiceBaseDescriptorSupplier {
    CarbonServiceFileDescriptorSupplier() {}
  }

  private static final class CarbonServiceMethodDescriptorSupplier
      extends CarbonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CarbonServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CarbonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CarbonServiceFileDescriptorSupplier())
              .addMethod(getCalculateCarbonFlightMethod())
              .addMethod(getCalculateCarbonDriveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
