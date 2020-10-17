package tech.sun.netty;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @program: springboot_tech
 * @description: netty NIO 客户端
 * @author: 孙东昊
 * @create: 2020-10-10 17:58
 **/
public class NioClient {

    public static void main(String[] args) throws Exception {
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(Boolean.FALSE);
        //提供服务的端的 ip 和 段户口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {
            //不成功
            while (!socketChannel.finishConnect()) {
                System.out.println("连接... 客户端不会阻塞, 可以做其他工作..");
            }
        }

        //连接成功, 发送数据
        String str = "Hello netty";

        // Wraps a byte array into a buffer

        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());

        //发送数据, 将 buffer 数据写入 channel
        socketChannel.write(buffer);
        System.in.read();
    }
}
