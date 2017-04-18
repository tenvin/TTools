package com.twg.ttools.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AIOClient {
    final AsynchronousSocketChannel client;
    InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1",8001);

    public AIOClient() throws IOException {
        this.client = AsynchronousSocketChannel.open();

    }

    public void start(String msg) {
        CompletionHandler<Void, ? super Object> handler = new CompletionHandler<Void,Object>(){
            @Override
            public void completed(Void result, Object attachment) {
                client.write(ByteBuffer.wrap(msg.getBytes()),null,
                        new CompletionHandler<Integer,Object>(){

                            @Override
                            public void completed(Integer result,
                                                  Object attachment) {
                                final ByteBuffer buffer = ByteBuffer.allocate(1024);
                                client.read(buffer,buffer,new CompletionHandler<Integer,ByteBuffer>(){

                                    @Override
                                    public void completed(Integer result,
                                                          ByteBuffer attachment) {
                                        buffer.flip();
                                        System.out.println(new String(buffer.array()));
                                        try {
                                            client.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void failed(Throwable exc,
                                                       ByteBuffer attachment) {
                                    }

                                });
                            }

                            @Override
                            public void failed(Throwable exc, Object attachment) {
                            }

                        });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
            }

        };

        client.connect(serverAddress, null, handler);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String... args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("ThreadName:" + Thread.currentThread().getName());
                        new AIOClient().start(Thread.currentThread().getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.shutdown();

        //new AIOClient().start("hello");

    }
}