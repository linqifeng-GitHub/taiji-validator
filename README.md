# taiji-validator
请各位大神一块完善系统功能<br/>
https://github.com/linqifeng-GitHub/taiji-validator
太极计算机股份有限公司基于JSR303标准扩展开发的注解式校验工具，支持身份证号、车辆VIN、等等
例如：
定义实体类

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

public class AppTest {

	@Test
	public void WebUserValidationTest() throws Exception{
	
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
}
