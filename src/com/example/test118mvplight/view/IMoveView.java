package com.example.test118mvplight.view;

public interface IMoveView {
	
	/** 前进灯闪一下 */
	public void onForward();
	
	/** 后退灯常亮 */
	public void onBackward();
	
	/** 打印移动纪录 */
	public void printMoveRecord(String record);

}
