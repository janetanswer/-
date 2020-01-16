package brightstar.java.basic.lambda.functionalInterface;

public interface FunctionalInterface {
	
	public void fun();
	
	default String otherFun(String str) {
		return "";
	}

}
