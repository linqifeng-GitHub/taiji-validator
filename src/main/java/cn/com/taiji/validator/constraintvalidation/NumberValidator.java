package cn.com.taiji.validator.constraintvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.com.taiji.validator.constraints.Number;

/**
 * 2017年8月13日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 */

public class NumberValidator implements ConstraintValidator<Number, String> {

	public void initialize(Number constraintAnnotation)
	{
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(String numberstr, ConstraintValidatorContext context) {
		boolean match =  checkNumber(numberstr);
		return match;
	}
	
	private boolean checkNumber(String numberstr)
	{
		String regex="^\\d+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(numberstr);
		if(matcher.matches()){
			return true;
		}
    	return false;
	}

}