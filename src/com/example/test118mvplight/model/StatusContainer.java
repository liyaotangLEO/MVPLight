package com.example.test118mvplight.model;


/**
 * 状态容器，单例模式，通过getStatusContainer(); 获取实例
 * @author Administrator
 *
 * 保存状态
 */
public class StatusContainer {
	
	private static StatusContainer mStatusContainer;
	
	private StatusContainer() {
	}
	
	public static StatusContainer getStatusContainer() {
		if (null == mStatusContainer)
			mStatusContainer = new StatusContainer();
		return mStatusContainer;
	}

	/** 灯是否亮了 */
	private boolean isLightOn = false;

	public boolean isLightOn() {
		return isLightOn;
	}

	public void setLightOn(boolean isLightOn) {
		this.isLightOn = isLightOn;
	}
	
}
