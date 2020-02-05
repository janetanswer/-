package brightstar.java.basic.enumm.scene.errorcode;

public enum ErrorType {
	
	/*成功类型错误代码*/
	Success("00"),
	PartSuccess("01"),
	
	/*服务内部错误*/
	StartError("11"),
	StopError("22"),
	
	/*存储类错误*/
	DbError("21"),
	RedisError("22"),
	CacheError("23"),
	
	/*外部系统交互错误*/
	RequestError("31"),
	ResponseError("32"),
	ConnectionError("33"),
	
	/*业务流程处理过程中的错误*/
	ProcessError("51");

	
	private String typeStr;
	
	private ErrorType(String typeStr) {
		this.typeStr = typeStr;
	}
}
