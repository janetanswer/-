package brightstar.java.basic.memorylayout;

import org.openjdk.jol.info.ClassLayout;

/**
 * 
 * https://blog.csdn.net/super_x_man/article/details/81741073
 * 
 * 
 *	普通对象[new XX()] 的内存布局：
 *		对象头(markword)：8个字节
 *		类型指针（class pointer）：压缩后4个字节
 *		<数组长度：普通对象不占用这4个字节>
 *		实例数据（instance data）
 *		对齐（padding）：64位CPU读数据一次读8个字节，所以要求一个对象的整体大小%8==0
 *
 * 无锁状态无hashcode markword:
 * OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
 *    0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
 *    4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 *    8     4        (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
 *   12     4        (loss due to the next object alignment)
 * Instance size: 16 bytes
 * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
 *
 * unused:25 hash:31 -->| unused:1   age:4    biased_lock:1 lock:2
 * 00000000 00000000 00000000 0|0000000 00000000 00000000 00000000|0|0000|001
 *
 * 无锁状态markword:
 *		unused:25 hash:31 -->| unused:1   age:4    biased_lock:1 lock:2
 *
 *		25bit		31bit			1bit		4bit				1bit		2bit
 *		unused		对象的hashcode	unused		对象分代年龄(最多15)		是否偏向锁		锁标志位
 *				
 *		00000000 00000000 00000000 0--0000110 10011001 01101101 10111000--0--0000--0--01
 *
 * 偏向锁状态markword:
 *		JavaThread*:54 epoch:2 unused:1   age:4    biased_lock:1 lock:2 
 *		
 *		54bit
 *		偏向锁偏向的线程
 *
 *		00000000 00000000 00000000 00000000 00000001 10111110 111100--00--0--0000--1--01
 *
 *
 *	轻量级锁状态markword:
 *
 *		00000000 00000000 00000000 00000000 00000010 01111000 11110110 00110000
 *
 *  
 *		
 *
 */


public class MemoryLayout {
	
	public static void main(String[] args) {
//		obj();
//		array();
//		obj_biasedLock();
//		obj_cas();
		
		String str = "123";
		System.out.println(ClassLayout.parseInstance(str).toPrintable());
		
	}
	
	public static void obj() {
		
		/*
 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      8     4        (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
     12     4        (loss due to the next object alignment)
Instance size: 16 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 * 
		 * 
		 * 
		 * */
		Obj obj = new Obj();
		System.out.println(ClassLayout.parseInstance(obj).toPrintable());
		
		/*

 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
      0     4        (object header)                           01 b8 6d 99 (00000001 10111000 01101101 10011001) (-1720862719)
      4     4        (object header)                           06 00 00 00 (00000110 00000000 00000000 00000000) (6)
      8     4        (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
     12     4        (loss due to the next object alignment)
Instance size: 16 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 */
		obj.hashCode();
		System.out.println(ClassLayout.parseInstance(obj).toPrintable());
	}
	
	
	public static void array() {
		
		/*
 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      8     4        (object header)                           f5 00 00 f8 (11110101 00000000 00000000 11111000) (-134217483)
     12     4        (object header)                           03 00 00 00 (00000011 00000000 00000000 00000000) (3)
     16     3   byte [B.<elements>                             N/A
     19     5        (loss due to the next object alignment)
Instance size: 24 bytes
Space losses: 0 bytes internal + 5 bytes external = 5 bytes total
		 * */
		byte[] barray = new byte[] {0,1,2};
		System.out.println(ClassLayout.parseInstance(barray).toPrintable());
	}
	
	
	/**
	 * 偏向锁有4S延迟
	 * 可以用
	 * -XX:BiasedLockingStartupDelay=0
	 * 
	 */
	public static void obj_biasedLock() {
		
		/*
 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
      0     4        (object header)                           05 f0 be 01 (00000101 11110000 10111110 00000001) (29290501)
      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      8     4        (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
     12     4        (loss due to the next object alignment)
Instance size: 16 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 * */
		Obj obj = new Obj();
		synchronized(obj){
			System.out.println(ClassLayout.parseInstance(obj).toPrintable());
		}
		
	}
	
	/*
	 * 轻量级锁
	 */
	public static void obj_cas() {
		/*
brightstar.java.memorylayout.Obj object internals:
 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
      0     4        (object header)                           10 f1 60 02 (00010000 11110001 01100000 00000010) (39907600)
      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
      8     4        (object header)                           43 c0 00 f8 (01000011 11000000 00000000 11111000) (-134168509)
     12     4        (loss due to the next object alignment)
Instance size: 16 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
		 * */
		Obj obj = new Obj();
		obj.hashCode();
		synchronized(obj){
			System.out.println(ClassLayout.parseInstance(obj).toPrintable());
		}
		
	}

}
