package grpc.newService;

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
    comments = "Source: newService.proto")
public final class newServiceGrpc {

  private newServiceGrpc() {}

  public static final String SERVICE_NAME = "newService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.newService.containsString,
      grpc.newService.containsString> getGetFirstStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFirstString",
      requestType = grpc.newService.containsString.class,
      responseType = grpc.newService.containsString.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.newService.containsString,
      grpc.newService.containsString> getGetFirstStringMethod() {
    io.grpc.MethodDescriptor<grpc.newService.containsString, grpc.newService.containsString> getGetFirstStringMethod;
    if ((getGetFirstStringMethod = newServiceGrpc.getGetFirstStringMethod) == null) {
      synchronized (newServiceGrpc.class) {
        if ((getGetFirstStringMethod = newServiceGrpc.getGetFirstStringMethod) == null) {
          newServiceGrpc.getGetFirstStringMethod = getGetFirstStringMethod = 
              io.grpc.MethodDescriptor.<grpc.newService.containsString, grpc.newService.containsString>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "newService", "GetFirstString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.newService.containsString.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.newService.containsString.getDefaultInstance()))
                  .setSchemaDescriptor(new newServiceMethodDescriptorSupplier("GetFirstString"))
                  .build();
          }
        }
     }
     return getGetFirstStringMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static newServiceStub newStub(io.grpc.Channel channel) {
    return new newServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static newServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new newServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static newServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new newServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class newServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFirstString(grpc.newService.containsString request,
        io.grpc.stub.StreamObserver<grpc.newService.containsString> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFirstStringMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFirstStringMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.newService.containsString,
                grpc.newService.containsString>(
                  this, METHODID_GET_FIRST_STRING)))
          .build();
    }
  }

  /**
   */
  public static final class newServiceStub extends io.grpc.stub.AbstractStub<newServiceStub> {
    private newServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private newServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected newServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new newServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFirstString(grpc.newService.containsString request,
        io.grpc.stub.StreamObserver<grpc.newService.containsString> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFirstStringMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class newServiceBlockingStub extends io.grpc.stub.AbstractStub<newServiceBlockingStub> {
    private newServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private newServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected newServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new newServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.newService.containsString getFirstString(grpc.newService.containsString request) {
      return blockingUnaryCall(
          getChannel(), getGetFirstStringMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class newServiceFutureStub extends io.grpc.stub.AbstractStub<newServiceFutureStub> {
    private newServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private newServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected newServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new newServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.newService.containsString> getFirstString(
        grpc.newService.containsString request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFirstStringMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FIRST_STRING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final newServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(newServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FIRST_STRING:
          serviceImpl.getFirstString((grpc.newService.containsString) request,
              (io.grpc.stub.StreamObserver<grpc.newService.containsString>) responseObserver);
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

  private static abstract class newServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    newServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.newService.NewServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("newService");
    }
  }

  private static final class newServiceFileDescriptorSupplier
      extends newServiceBaseDescriptorSupplier {
    newServiceFileDescriptorSupplier() {}
  }

  private static final class newServiceMethodDescriptorSupplier
      extends newServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    newServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (newServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new newServiceFileDescriptorSupplier())
              .addMethod(getGetFirstStringMethod())
              .build();
        }
      }
    }
    return result;
  }
}
