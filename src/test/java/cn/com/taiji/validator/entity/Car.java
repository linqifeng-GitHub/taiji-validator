package cn.com.taiji.validator.entity;

import cn.com.taiji.validator.constraints.VIN;

public class Car {
	
	@VIN
	private String VIN;
	private String plateNum;
	
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String VIN) {
		this.VIN = VIN;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	
}