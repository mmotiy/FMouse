package com.mmotiy.app;

import com.mmotiy.service.Mouse;

public class FMApp {
	private FMConfiguration configuration ;
	
	private FMServer fmServer;
	
	private Mouse mouse;
	
	public FMApp() {
		this.configuration = new FMConfiguration();
		this.mouse = new Mouse();
		this.fmServer = new FMServer();
		init(this);
	}

	private void init(FMApp app) {
		app.fmServer.start(app);
	}

	public FMConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(FMConfiguration configuration) {
		this.configuration = configuration;
	}

	public FMServer getFmServer() {
		return fmServer;
	}

	public void setFmServer(FMServer fmServer) {
		this.fmServer = fmServer;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
	
}
