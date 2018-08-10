package cn.com.taiji.validator;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.junit.Test;

import cn.com.taiji.validator.entity.Car;
import cn.com.taiji.validator.entity.WebUser;

/**
 * 2018年7月4日
 * 
 * @AUTHOR 林奇峰
 * @EMAIL linqf@mail.taiji.com.cn
 * @DEPARTMENT 交通信息系统事业部 测试注解有没有生效
 */
public class AppTest {
	@Test
	public void WebUserValidationTest() throws Exception {
		WebUser webUser = new WebUser();
		webUser.setName("ewqewqe");
		webUser.setIdCardNumber("410927199110128010");
		webUser.setPassword("123456789");
		webUser.setConfirmPassword("123456789");
		webUser.setPrice(111.11);

		StringBuilder sb = new StringBuilder();
		Set<ConstraintViolation<WebUser>> validResult = Validation.buildDefaultValidatorFactory().getValidator().validate(webUser);
		for (Iterator<ConstraintViolation<WebUser>> iterator = validResult.iterator(); iterator.hasNext();) {
			ConstraintViolation<WebUser> constraintViolation = (ConstraintViolation<WebUser>) iterator.next();
			sb.append(constraintViolation.getMessage()).append(";");
		}

		System.out.println(sb.toString());
	}

	@Test
	public void CarValidationTest() throws Exception {
		Car car = new Car();
		car.setVIN("LFP84ACE6E1A631441");

		StringBuilder sb = new StringBuilder();
		Set<ConstraintViolation<Car>> validResult = Validation.buildDefaultValidatorFactory().getValidator().validate(car);
		for (Iterator<ConstraintViolation<Car>> iterator = validResult.iterator(); iterator.hasNext();) {
			ConstraintViolation<Car> constraintViolation = (ConstraintViolation<Car>) iterator.next();
			sb.append(constraintViolation.getMessage()).append(";");
		}

		System.out.println(sb.toString());
	}

}
