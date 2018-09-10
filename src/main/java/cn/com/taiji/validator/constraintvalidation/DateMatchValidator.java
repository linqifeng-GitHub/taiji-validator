package cn.com.taiji.validator.constraintvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.com.taiji.validator.constraints.DateMatch;

/**
 * 2017年8月13日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 */

public class DateMatchValidator implements ConstraintValidator<DateMatch, String> {

	public void initialize(DateMatch constraintAnnotation)
	{
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(String date, ConstraintValidatorContext context) {
		boolean match =  checkDate(date);
		return match;
	}
	
	private boolean checkDate(String date)
	{
		String regex= "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/]((((0?[13578])|(1[02]))[\\-\\/]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/]((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/]((((0?[13578])|(1[02]))[\\-\\/]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/]((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/]((0?[1-9])|(1[0-9])|(2[0-8]))))))";   
        Pattern pattern = Pattern.compile(regex);    
        Matcher matcher = pattern.matcher(date);    
        if(matcher.matches())   
        {   
             return true;  
        }
        return false;
	}

}