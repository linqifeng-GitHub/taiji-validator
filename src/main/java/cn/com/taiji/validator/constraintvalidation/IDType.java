package cn.com.taiji.validator.constraintvalidation;

/**
 * @author zhaogl
 * @Description:
 * @date 2018年8月14日 下午5:56:49
 * @version 1.0
 * @since 1.0
 */

public enum IDType
{
	IDCARD("身份证"), // 身份证
	TAIBAOCARD("台胞证"), // 台胞证
	RETURNHOMECARD("回乡证"), // 回乡证
	PASSPORT("护照"), // 护照
	RESIDENCEPERMIT("居住证")// 居住证
	;
	private String value;

	private IDType(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

}
