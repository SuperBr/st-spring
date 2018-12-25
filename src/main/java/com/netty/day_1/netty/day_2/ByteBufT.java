package com.netty.day_1.netty.day_2;

import io.netty.buffer.*;

public class ByteBufT {

    public static void main(String[] args) {

      /*  ByteBuf byteBuf = Unpooled.directBuffer(1024);

        ByteBuf byteBuf1 = Unpooled.buffer();

        CompositeByteBuf com = Unpooled.compositeBuffer();

        System.out.println(byteBuf.hasArray());

        System.out.println(byteBuf1.hasArray());

        System.out.println(com.hasArray());


        ByteBufAllocator byteBufAllocator = new PooledByteBufAllocator();

        System.out.println(byteBufAllocator.buffer().hasArray()+"11");

        System.out.println(byteBufAllocator.directBuffer().hasArray());

        ByteBufAllocator byteBufAllocator1 = new UnpooledByteBufAllocator(true);

        System.out.println(byteBufAllocator1.buffer().hasArray());

        System.out.println(byteBufAllocator1.directBuffer().hasArray());
*/

        ByteBuf byteBuf = Unpooled.buffer(1024);

        System.out.println(byteBuf.hasArray());

        System.out.println(byteBuf.alloc().toString());

        byte[] arr = byteBuf.array();

        byteBuf.writeInt(12);

        byteBuf.writeInt(16);

        byteBuf.readInt();

     //   byteBuf.discardReadBytes();

        byteBuf.markReaderIndex();

        byteBuf.markWriterIndex();

        byteBuf.resetReaderIndex();

        ByteBuf buf = byteBuf.duplicate();

        ByteBuf copBuf = byteBuf.copy();




    }
}
