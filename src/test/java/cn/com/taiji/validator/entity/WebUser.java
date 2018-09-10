package cn.com.taiji.validator.entity;

import cn.com.taiji.validator.constraints.CNName;
import cn.com.taiji.validator.constraints.DateMatch;
import cn.com.taiji.validator.constraints.IdCardNumber;
import cn.com.taiji.validator.constraints.Identification;
import cn.com.taiji.validator.constraints.Matches;
import cn.com.taiji.validator.constraints.Money;
import cn.com.taiji.validator.constraints.Number;
import cn.com.taiji.validator.constraints.PhoneNumber;
import cn.com.taiji.validator.constraints.URL;

@Identification(idTypeField="idType",idCardField="idCardNumber",message = "格式不正确")
@Matches(field = "password", verifyField = "confirmPassword", message = "confirmNewPassword和password不一致")
public class WebUser {

	private String loginName;

	private int age;

	private String name;
	
	@CNName(message = "中文姓名格式不正确！")
	private String CNName;

	private String idType;
	
	@IdCardNumber(message = "身份证号格式不正确")
	private String idCardNumber;

	@PhoneNumber(message = "手机号格式不正确！")
	private String phoneNumber;

	@Money(message = "price不符合格式")
	private Double price;
	@Number(message="必须输入数字！")
	private String password;

	private String confirmPassword;

	@URL(message="url格式不正确！")
	private String url;
	
	@DateMatch(message="日期格式不正确！")
	private String birthday;
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

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

	public String getCNName() {
		return CNName;
	}

	public void setCNName(String cNName) {
		CNName = cNName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIdType()
	{
		return idType;
	}

	public void setIdType(String idType)
	{
		this.idType = idType;
	}
	
}