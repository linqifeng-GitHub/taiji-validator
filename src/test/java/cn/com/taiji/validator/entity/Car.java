package cn.com.taiji.validator.entity;

import javax.validation.constraints.NotNull;

import cn.com.taiji.validator.constraints.PlateNumber;
import cn.com.taiji.validator.constraints.VIN;
import cn.com.taiji.validator.constraintvalidation.PlateNumberType;

public class Car {
	
	@NotNull
	@VIN
	private String VIN;
	@NotNull
	@PlateNumber(type=PlateNumberType.STRICT,message="车牌号格式不正确！")
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