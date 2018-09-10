package cn.com.taiji.validator.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cn.com.taiji.validator.constraintvalidation.PlateNumberType;
import cn.com.taiji.validator.constraintvalidation.PlateNumberValidator;

/**
 * 2017年8月13日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 * 
 * 车牌号
 */

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PlateNumberValidator.class)
public @interface PlateNumber {
	
	PlateNumberType type() default PlateNumberType.LOOSE;

	String message() default "javax.validation.constraints.PlateNo.message";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}