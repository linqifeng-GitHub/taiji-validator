package cn.com.taiji.validator.constraintvalidation;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.com.taiji.validator.constraints.CreditCode;

/**
 * 2017年7月4日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 */

public class CreditCodeValidator implements ConstraintValidator<CreditCode, String> {

	public void initialize(CreditCode constraintAnnotation)
	{
		// TODO Auto-generated method stub
		
	}

	public boolean isValid(String creditCode, ConstraintValidatorContext context) {
		boolean match =  checkCreditCode(creditCode);
		return match;
	}
	
	private boolean checkCreditCode(String creditCode)
	{
		if ((creditCode.equals("")) || creditCode.length() != 18) {
            return false;
        }
        String baseCode = "0123456789ABCDEFGHJKLMNPQRTUWXY";
        char[] baseCodeArray = baseCode.toCharArray();
        Map<Character, Integer> codes = new HashMap<Character, Integer>();
        for (int i = 0; i < baseCode.length(); i++) {
            codes.put(baseCodeArray[i], i);
        }
        char[] creditCodeArray = creditCode.toCharArray();
        Character check = creditCodeArray[17];
        if (baseCode.indexOf(check) == -1) {
            return false;
        }
        int[] wi = { 1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28 };
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            Character key = creditCodeArray[i];
            if (baseCode.indexOf(key) == -1) {
                return false;
            }
            sum += (codes.get(key) * wi[i]);
        }
        int value = 31 - sum % 31;
        return value == codes.get(check);
	}

}