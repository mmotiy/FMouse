package com.mmotiy.app;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mmotiy.util.DtoBytesUtil;

public class FMServer {
	static private Logger logger = LoggerFactory.getLogger(FMServer.class);

	private volatile boolean running = true;
	private ServerSocket serverSocket;

	public FMServer() {

	}

	public void start(FMApp fmApp) {
		FMConfiguration configuration = fmApp.getConfiguration();
		try {
			this.serverSocket = new ServerSocket(
					Integer.valueOf((String) configuration.getProperties().get("server.port")));
			while (this.running) {
				Socket accept = serverSocket.accept();
				accept.setSoTimeout(300);
				InputStream inputStream = accept.getInputStream();
				byte[] bytes = new byte[30];
				byte[] buffer = new byte[30];
				int len = 0;
				int total = 0;
				while ((len = inputStream.read(bytes)) != 0) {
					if (len == 30) {
						fmApp.getMouse().mouse(DtoBytesUtil.toDto(bytes));
					}
					/*else {
						System.arraycopy(bytes, 0, buffer, total, len);
						total += len;
						if (total == 30) {
							fmApp.getMouse().mouse(DtoBytesUtil.toDto(buffer));
							total = 0;
						}
					}*/
				}

			}
		} catch (IOException e) {
			logger.error("FMServer IOEXception", e);
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

}
