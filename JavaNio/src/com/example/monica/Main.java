package com.example.monica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()){

	        ByteBuffer buffer = ByteBuffer.allocate(100);
//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            // chaining
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
//            buffer.flip();

            // Seekable Byte channel Interface - 6 methods (FileChannel class)
            // read(ByteBuffer) - reads byte beginning at channel's current position - updates the read accordingly
            // write(ByteBuffer) - same as read, except it writes. Exception - if datasource is opened in APPEND mode, then
                                // first write takes place at end of datasource
            // position() - returns channel's position
            // position(long) - sets channel's position to passed value
            // truncate(long) - truncates the size of datasource to passed value
            // size() - returns size of datasource


            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1pos = outputBytes.length;
            buffer.putInt(245);
            long int2pos = int1pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3pos = int2pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            // switch from reading to writing, so need to flip
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("input String = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());

            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("input String2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());

        }
	    catch(IOException e) {
	        e.printStackTrace();
        }
    }
}
