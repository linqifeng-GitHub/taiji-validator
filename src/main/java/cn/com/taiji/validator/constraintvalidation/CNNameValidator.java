package cn.com.taiji.validator.constraintvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.com.taiji.validator.constraints.CNName;

/**
 * 2017年8月10日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 */

public class CNNameValidator implements ConstraintValidator<CNName, String> {

	public void initialize(CNName constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean match =  checkCNName(value);
		return match;
	}


	/**
	 * 判断字符串是否全部为中文字符组成
	 * @param str	检测的文字
	 * @return	true：为中文字符串，false:含有非中文字符
	 */
    public static boolean checkCNName(String str){
    	Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]+");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()){
			return true;
		}
    	return false;

    }

}