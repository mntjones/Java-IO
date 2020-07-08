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
            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            buffer.putInt(245);
            buffer.putInt(-98765);

            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            buffer.putInt(1000);
            buffer.flip();
            binChannel.write(buffer);


//            // allocating
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//            buffer.flip();
//
//            int numBytes = binChannel.write(buffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            // resets the buffer back to zero
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            // uses java.nio
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            outputBytes[0] ='a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
//            if (buffer.hasArray()) {
//                //System.out.println("byte buffer = " + new String(buffer.array()));
//                System.out.println("byte buffer = " + new String(outputBytes));
//
//            }
//
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//
//            // Absolute read for intBuffer.getInt();
//            System.out.println(intBuffer.getInt(0));
//
//            intBuffer.flip();
//            numBytes = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0));
//            System.out.println(intBuffer.getInt());
//
//            // Relative read for intBuffer.getInt()
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt());
////
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt());
//
//            channel.close();
//            ra.close();
//            //System.out.println("output bytes = " + new String(outputBytes));
//
//
//    // uses java.io
////            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
////            byte[] b = new byte[outputBytes.length];
////            ra.read(b);
////            System.out.println(new String(b));
////
////            long int1 = ra.readInt();
////            long int2 = ra.readInt();
////
////            System.out.println(int1);
////            System.out.println(int2);
//
//            //write to data.txt file
////            FileInputStream file = new FileInputStream("data.txt");
////            FileChannel channel = file.getChannel();
////            Path dataPath = FileSystems.getDefault().getPath("data.txt");
////            // StandardOpenOption appends to file - default is to create new or wipe out existing file
////            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
////            List<String> lines = Files.readAllLines(dataPath);
////
////            for (String line : lines) {
////                System.out.println(line);
////            }
        }
	    catch(IOException e) {
	        e.printStackTrace();
        }
    }
}
