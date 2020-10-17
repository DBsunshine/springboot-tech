package tech.sun.netty;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: springboot_tech
 * @description: netty NIO 服务器端
 * @author: 孙东昊
 * @create: 2020-10-10 17:05
 **/
public class NioService {

    public static void main(String[] args) throws Exception {

        //创建 ServerSocketChannel -> Selector

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到 selector

        Selector selector = Selector.open();

        //绑定端口6666,在服务器监听

        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        //设置为非阻塞

        serverSocketChannel.configureBlocking(Boolean.FALSE);

        //把 serverSocketChannel 注册到 selector 关心 事件为 OP_ACCEPT

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端

        while (true) {

            //设置等待一秒,没有事件发生就返回
            if(selector.select() == 0) {
                continue;
            }

            /*
            如果返回值大于0(表示已经获取到关注的事件),
            就获取相关的 SelectionKey 集合(selector.selectedKeys())
             */

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {

                //获取 selectionKey

                SelectionKey key = keyIterator.next();

                //根据 key 对应的通道发生的事件做相应的处理

                if (key.isAcceptable()) {

                    /*
                    如果是 OP_ACCEPT, 有新客户端连接
                    给该客户端生成一个SocketChannel
                     */

                    SocketChannel socketChannel = serverSocketChannel.accept();

                    System.out.println("客户端生成了一个socketChannel" + socketChannel.hashCode() + socketChannel.toString());

                    //将 socketChannel 设置为非阻塞

                    socketChannel.configureBlocking(Boolean.FALSE);

                    //将 socketChannel 注册到 selector, 关注事件 OP_ACCEPT 同时给 socketChannel 关联一个 buffer

                    socketChannel.register(selector, SelectionKey.OP_ACCEPT, ByteBuffer.allocate(1024));
                }

                if (key.isReadable()) {
                    /* 发生 OP_READ
                    通过 key 反向获取对应的 channel
                     */

                    SocketChannel channel = (SocketChannel)key.channel();

                    //获取到关联 channel 的 buffer

                    ByteBuffer buffer = (ByteBuffer) key.attachment();

                    channel.read(buffer);

                    System.out.println("from 客户端" +  new String(buffer.array()));

                }

                //手动从集合中移动当前的 selectionKey, 防止重复操作
                keyIterator.remove();
            }
        }
    }
}
