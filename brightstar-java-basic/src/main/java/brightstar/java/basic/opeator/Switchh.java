package brightstar.java.basic.opeator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Switchh {
	final static Logger logger = LoggerFactory.getLogger(Switchh.class);

	/**
	 * switch 语句中的变量类型可以是：
	 * 		byte、short、int、char
	 * 		String
	 * 		Enum
	 * 
	 */
	public final static void main(String[] args) {
		int i = 1;
		String str = "A";
		innerEnum e = innerEnum.ea;
		
		
		
		switch (i) {
		case 0:
			System.out.println("case:0");
			break;
		case 1:
			System.out.println("case:1");
			break;
		default:
			System.out.println("case:default");
		}

		switch (str) {
		case "A":
			System.out.println("case:A");
			break;
		case "B":
			System.out.println("case:B");
			break;
		}
		
		switch (e) {
		case ea:
			System.out.println("case:ea");
			break;
		case eb:
			System.out.println("case:eb");
			break;
		default:
			System.out.println("case:edefault");
		}

	}

	static enum innerEnum {
		ea, eb;
	};

}
