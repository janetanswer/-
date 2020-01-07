package brightstar.java.basic.enumm;

public class EnumExample {

	public final static void main(String[] args) {

		/**************循环**************/
		for (Season season : Season.values()) {
			System.out.println(season +"	name:"+season.name() +"  ordinal:" + season.ordinal());
		}
		
		/**
		 * 单例模式可以保证在内存中只存在唯一一个实例，所以比较可以直接使用==
		 * */
		Season spring = Season.valueOf("SPRING");
		Season spring2 = Season.SPRING;
		System.out.println(spring==spring2);
		System.out.println(spring.equals(spring2));
		
		/**
		 * 顺序(ordinal)比较
		 * */
		System.out.println(Season.SPRING.compareTo(Season.SUMMER));
		System.out.println(Season.WINTER.compareTo(Season.AUTUMN));
		
		/**
		 * 自定义变量及方法
		 * */
		System.out.println(Season.SPRING+" feels "+Season.SPRING.getFeel());
		System.out.println(Season.SPRING+" has "+Season.SPRING.getDays()+" days");

	}

}
