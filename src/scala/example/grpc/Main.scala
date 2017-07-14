package example.grpc

import example.grpc.service.{MyServiceGrpc, Request}

object Main extends App {
  val channel = io.grpc.ManagedChannelBuilder.forAddress("localhost", 3000).usePlaintext(true).build
  val blockingStub = MyServiceGrpc.blockingStub(channel)
  val response = blockingStub.handle(Request())
  println(response)
}
