package com.example.test118mvplight.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test118mvplight.R;
import com.example.test118mvplight.presenter.MainPresenter;
import com.example.test118mvplight.view.ILightView;
import com.example.test118mvplight.view.IMoveView;

/**
 * MainActivity 和 interface LightView 负责View层UI刷新任务
 * 
 * LightPresenter 负责Presenter层逻辑任务
 * 
 * StatusContrainer 负责Model层数据处理任务
 * 
 * 三层连通的接口
 * View 
 * 	 | Activity 创建Presenter实例
 *   | Activity作为XXXView实例，传给Presenter实例
 * Presenter
 * 	 | Presenter获取Model实例
 * Model
 * 
 * 2017.08.29
 * 使用多个IView，一个Activity，一个Presenter
 * 代码一分为三，Activity 负责View，Presenter 负责View和Model交互，Model 负责Model
 * 
 * 
 * @author liyaotang
 *
 */
public class MainActivity extends Activity implements ILightView, IMoveView {
	
	private MainPresenter mMaintPresenter;
	private ImageView lightImg;
	
	private Handler mHandler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	
	private void init() {
		mMaintPresenter = new MainPresenter(this);
		lightImg = (ImageView)findViewById(R.id.light);
	}
	
	/** onClick，开关灯 */
	public void lightSwith(View view) {
		mMaintPresenter.lightSwitch();
	}
	
	/** onClick，前进 */
	public void forward(View view) {
		mMaintPresenter.forward();
	}
	
	/** onClick，后退 */
	public void backward(View view) {
		mMaintPresenter.backward();
	}
	
	public void printRecord(View view) {
		mMaintPresenter.printRecord();
	}

	@Override
	public void lightOn() {
		lightImg.setImageResource(R.drawable.cameraen);
	}

	@Override
	public void lightOff() {
		lightImg.setImageResource(R.drawable.cameradis);
	}

	@Override
	public void onForward() {
		lightOn();
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				lightOff();
			}
		}, 500);
		
	}

	@Override
	public void onBackward() {
		lightOn();
	}

	@Override
	public void printMoveRecord(String record) {
		TextView text = (TextView) findViewById(R.id.print_record);
		text.setText(record);
	}
	
}
