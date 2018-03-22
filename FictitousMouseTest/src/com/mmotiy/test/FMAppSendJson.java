package com.mmotiy.test;

import java.io.OutputStream;
import java.net.Socket;

import com.mmotiy.dto.TagINPUT;
import com.mmotiy.dto.TagMOUSEINPUT;
import com.mmotiy.util.DtoBytesUtil;
import com.mmotiy.util.FMConstants;

public class FMAppSendJson {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 12580);
		socket.setSoTimeout(300);
		OutputStream outputStream = socket.getOutputStream();
		TagINPUT tagINPUT = new TagINPUT();
		tagINPUT.type = FMConstants.INPUT_MOUSE;
		TagMOUSEINPUT mouseinput = new TagMOUSEINPUT();
		mouseinput.dx = -1;
		mouseinput.dy = -1;
		mouseinput.time = 0;
		mouseinput.dwFlags = FMConstants.MOUSEEVENTF_MOVE;
		tagINPUT.tagMOUSEINPUT = mouseinput;
		outputStream.write(DtoBytesUtil.toBytes(tagINPUT));
		outputStream.flush();
		
		for(int i=0;i<10;i++) {
			Thread.sleep(100);
			outputStream.write(DtoBytesUtil.toBytes(tagINPUT)); 
			outputStream.flush();
		}
		outputStream.close();
		socket.close();
	}
}
