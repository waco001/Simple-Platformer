package com.gledx.simpleplatformer.engine;

import java.util.ArrayList;

public class Animation {
	private ArrayList<Frame> frame;
	private int currentFrame;
	
	public Animation() {
		// TODO Auto-generated constructor stub
		frame = new ArrayList<Frame>();
	}
	
	public void render(){
		Frame temp = frame.get(currentFrame);
		if(temp.render()){
			currentFrame ++;
			currentFrame %= frame.size();
		}
	}
}
