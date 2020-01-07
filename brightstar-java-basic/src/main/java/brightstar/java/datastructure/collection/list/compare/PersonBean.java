package brightstar.java.datastructure.collection.list.compare;


/**
 * Comparable 内部排序
 * 实现按年龄排序
 * */
public class PersonBean implements Comparable<PersonBean>{

	String name;
	
	int age;
	
	
	/**
	 * 比较者大于被比较者（也就是compareTo方法里面的对象），那么返回正整数
	 * 比较者等于被比较者，那么返回0
	 * 比较者小于被比较者，那么返回负整数
	 * */
	@Override
	public int compareTo(PersonBean p) {
		// TODO Auto-generated method stub
		return this.age - p.getAge();
	}

	public String getName() {
		return name;
	}

	
	
	public PersonBean(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonBean [name=" + name + ", age=" + age + "]";
	}

}
