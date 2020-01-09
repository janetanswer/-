package brightstar.java.lambda.functionalInterface;



/**
 * 函数式接口:只有一个抽象方法的接口,接口中可以存在其它的非抽象方法。
 * 
 * 1． 定义一个函数式接口:FunctionalInterface、 FunctionalInterface2、FunctionalInterface3
 * 2. 用Lambda表达式实例化接口
 * 3. 可以直接调用接口里的方法，也可以直接使用返回值
 *
 */
public class InfUtil {

	public static void main(String[] args) {
		FunctionalInterface inf = () -> System.out.println("do something");
		inf.fun();
		
		FunctionalInterface2 inf2 = (s) -> System.out.println(s+" do something");
		inf2.funWithPara("FunctionalInterface2");
		
		System.out.println("5+6="+InfUtil.operate(5, 6, (a,b)->a+b));

	}
	
	private static int operate(int a, int b, FunctionalInterface3 mathOperation){
		return mathOperation.funWithParaAndRet(a, b);
	}

}
