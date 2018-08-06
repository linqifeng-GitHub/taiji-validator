package cn.com.taiji.validator.entity;

import cn.com.taiji.validator.constraints.IdCardNumber;
import cn.com.taiji.validator.constraints.Matches;
import cn.com.taiji.validator.constraints.Money;


@Matches(field = "password", verifyField = "confirmPassword", message = "confirmNewPassword和password不一致")
public class WebUser {
	
	private String loginName;
	private int age;
	
	private String name;
	@IdCardNumber( message="idCardNumber格式不正确")
	private String idCardNumber;
	
	@Money(message="price不符合格式")
	private Double price;
	
	private String password;
	private String confirmPassword;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    public int getAge() {  
       return age;  
    }  
   
    public void setAge(int age) {  
       this.age = age;  
    }
	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}