package brightstar.java.basic.enumm.scene.errorcode;

public enum GatewayErrorCode implements ErrorCode{
	;
	
	
	
	private String code;
	private String desc;
	private ErrorType errorType;
	
	private GatewayErrorCode(String code,String desc,String type) {
		
	}

	@Override
	public String getErrorCode() {
		String gatewayErrorCodePrefix = "004-001-";
		return gatewayErrorCodePrefix+this.getErrorType()+this.getCode();
	}

	@Override
	public String getErrorDescription() {
		return this.getDesc();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}

}
