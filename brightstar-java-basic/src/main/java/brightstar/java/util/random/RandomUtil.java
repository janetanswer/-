package brightstar.java.util.random;

import java.util.Random;

public class RandomUtil {

	public static void main(String[] args) {
		System.out.println(genRandomInt(0,5));
	}
	
	
	public static int genRandomInt(int start,int end) {
		Random random = new Random(); 
		return random.nextInt(end - start + 1) + start;
	}

}
