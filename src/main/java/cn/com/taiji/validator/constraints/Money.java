package cn.com.taiji.validator.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cn.com.taiji.validator.constraintvalidation.MoneyValidator;

/**
 * 2017年7月4日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 * 金额
 */

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MoneyValidator.class)
public @interface Money {

	String message() default "javax.validation.constraints.Money.message";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}