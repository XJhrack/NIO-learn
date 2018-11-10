package com.localhost.nio;


import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ByteBufferDemo {
	public void readFile(String fileName){
		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
			FileChannel fileChannel = randomAccessFile.getChannel();
			
			ByteBuffer byteBuffer = ByteBuffer.allocate(48);
			
			int size;
			while((size = fileChannel.read(byteBuffer)) != -1){
				//ByteBuffer从写模式变成读模式
				byteBuffer.flip();
				Charset charset = Charset.forName("GBK"); //要与文本编码一致，否则报错
				System.out.println(charset.newDecoder().decode(byteBuffer).toString());
				byteBuffer.clear();
			}
			
			fileChannel.close();
			randomAccessFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
