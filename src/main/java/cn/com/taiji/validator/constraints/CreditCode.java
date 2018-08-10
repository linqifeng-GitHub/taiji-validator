package cn.com.taiji.validator.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cn.com.taiji.validator.constraintvalidation.CreditCodeValidator;

/**
 * 2017年7月4日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 * 
 * 统一社会信用代码
 */

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreditCodeValidator.class)
public @interface CreditCode {

	String message() default "统一社会信用代码格式不正确";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}