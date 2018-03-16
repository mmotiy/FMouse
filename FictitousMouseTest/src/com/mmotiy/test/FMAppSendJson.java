package com.mmotiy.test;

import java.io.OutputStream;
import java.net.Socket;

import com.alibaba.fastjson.JSON;
import com.mmotiy.dto.TagINPUT;

public class FMAppSendJson {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 12580);
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(JSON.toJSONString(new TagINPUT()).getBytes());
		outputStream.flush();
		outputStream.close();
		socket.close();
	}
}
