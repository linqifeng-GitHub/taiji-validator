package cn.com.taiji.validator.constraintvalidation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.com.taiji.validator.constraints.Money;
/**
 * 2017年7月4日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 */

public class MoneyValidator implements ConstraintValidator<Money, Double> {  
   
    private String moneyReg = "^\\d+(\\.\\d{1,2})?$";//表示金额的正则表达式  
    private Pattern moneyPattern = Pattern.compile(moneyReg);  
     
    public void initialize(Money money) {  
       // TODO Auto-generated method stub  
        
    }  
   
    public boolean isValid(Double value, ConstraintValidatorContext arg1) {  
       // TODO Auto-generated method stub  
       if (value == null)  
           return true;  
       return moneyPattern.matcher(value.toString()).matches();  
    }  
   
}  