package com.gledx.thegreatcube;

public class Frame {
	private int length;
	private Sprite spr;
	private int numDisplay;
	public Frame(Sprite spr, int length) {
		// TODO Auto-generated constructor stub
		this.spr = spr;
		this.length = length;
		numDisplay = 0;
	}
	public boolean render() {
		// TODO Auto-generated method stub
		spr.render();
		numDisplay ++;
		if(numDisplay >= length){
			numDisplay = 0;
			return true;
		}
		return false;
	}

}
