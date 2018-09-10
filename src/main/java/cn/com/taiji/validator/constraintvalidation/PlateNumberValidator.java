package cn.com.taiji.validator.constraintvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.com.taiji.validator.constraints.Matches;
import cn.com.taiji.validator.constraints.PlateNumber;

/**
 * 2017年8月13日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 */

public class PlateNumberValidator implements ConstraintValidator<PlateNumber, String> {

	private PlateNumberType type;

	public void initialize(PlateNumber constraintAnnotation) {
		this.type = constraintAnnotation.type();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean match = checkPlateNo(value);
		return match;
	}

	/**
	 * 检验车牌格式
	 * 
	 * @param vin
	 * @return
	 */
	public boolean checkPlateNo(String plateNo) {
		if(plateNo==null){
    		return false;
    	}
		Pattern pattern = null;
		if (PlateNumberType.LOOSE.equals(this.type)) {
			pattern = Pattern.compile("([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1})");
		} else {
			pattern = Pattern.compile("([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})");
		}

		Matcher matcher = pattern.matcher(plateNo);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public PlateNumberType getType() {
		return type;
	}

	public void setType(PlateNumberType type) {
		this.type = type;
	}

}