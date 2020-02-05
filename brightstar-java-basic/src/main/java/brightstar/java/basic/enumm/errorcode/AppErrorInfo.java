package brightstar.java.basic.enumm.errorcode;

import brightstar.java.basic.enumm.scene.errorcode.ErrorCode;

public enum AppErrorInfo implements ErrorCode{
	
	Success("00000","SUCCESS");
	
	
	
	private String errorCode;
	private String errorDesc;
	
	private AppErrorInfo(String errorCode,String errorDescription) {
		this.errorCode = errorCode;
		this.errorDesc = errorDescription;
	}
	
	@Override
	public String getErrorCode() {
		return "001-001-"+this.errorCode;
	}

	@Override
	public String getErrorDescription() {
		return this.errorDesc;
	}

}
