package com.example.test118mvplight.presenter;

import android.content.Context;

import com.example.test118mvplight.model.MoveRecord;
import com.example.test118mvplight.model.StatusContainer;
import com.example.test118mvplight.view.ILightView;
import com.example.test118mvplight.view.IMoveView;

public class MainPresenter {
	
	public ILightView mLightView;
	
	public IMoveView mMoveView;
	
	public StatusContainer mStatusContainer;
	
	private MoveRecord mMoveRecord = new MoveRecord();
	
	public MainPresenter(Context context) {
		this.mLightView = (ILightView)context;
		this.mMoveView = (IMoveView)context;
		mStatusContainer = StatusContainer.getStatusContainer();
	}
	
	/** 开关灯 */
	public void lightSwitch() {
		boolean isLightOn = mStatusContainer.isLightOn();
		if (isLightOn)
			mLightView.lightOff();
		else
			mLightView.lightOn();
		mStatusContainer.setLightOn(!isLightOn);
	}
	
	public void forward() {
		// UI操作
		mMoveView.onForward();
		// 数据操作
		mMoveRecord.add(1);
	}
	
	public void backward() {
		// UI操作
		mMoveView.onBackward();
		// 数据操作
		mMoveRecord.add(0);
	}
	
	public void printRecord() {
		StringBuffer sb = new StringBuffer();
		for (int move : mMoveRecord) {
			sb.append(move);
		}
		mMoveView.printMoveRecord(sb.toString());
	}

}
