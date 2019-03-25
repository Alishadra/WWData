package com.workWithData.entity;

public class ConnectionEntity {
	
	private int sessionId;
	
	private long time;
	
	private String ip;

	public ConnectionEntity(long time2, int sessionId2, String ip2) {
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	@Override
	public String toString() {
		
		return time + " " + sessionId + " " + ip;
	}

	
	

}
