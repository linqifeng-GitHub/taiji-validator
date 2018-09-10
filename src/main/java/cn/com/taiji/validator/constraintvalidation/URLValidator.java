package cn.com.taiji.validator.constraintvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.com.taiji.validator.constraints.URL;

/**
 * 2017年8月10日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 */

public class URLValidator implements ConstraintValidator<URL, String> {

	public void initialize(URL constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean match = checkURL(value);
		return match;
	}
	
	 /**
     * 校验URL格式
     * @param url
     * @return
     */
    public static boolean checkURL(String url) {
    	if(url==null){
    		return false;
    	}
    	String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
    	Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);
		if (matcher.matches()) {
			return true;
		}
    	return false;
    }
    
    
}