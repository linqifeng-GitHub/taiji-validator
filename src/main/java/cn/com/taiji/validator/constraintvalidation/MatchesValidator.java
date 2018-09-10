package cn.com.taiji.validator.constraintvalidation;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import cn.com.taiji.validator.constraints.Matches;

/**
 * 2017年7月4日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部
 */

public class MatchesValidator implements ConstraintValidator<Matches, Object> {
	private String field;
	private String verifyField;

	public void initialize(Matches matches) {
		this.field = matches.field();
		this.verifyField = matches.verifyField();
	}

	@SuppressWarnings("deprecation")
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			String fieldValue = BeanUtils.getProperty(value, field);
			String verifyFieldValue = BeanUtils.getProperty(value, verifyField);
			boolean valid = (fieldValue == null) && (verifyFieldValue == null);
			if (valid) {
				return true;
			}

			boolean match = (fieldValue != null) && fieldValue.equals(verifyFieldValue);
			if (!match) {
				String messageTemplate = context.getDefaultConstraintMessageTemplate();
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(messageTemplate).addNode(verifyField).addConstraintViolation();
			}
			return match;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return true;
	}
}