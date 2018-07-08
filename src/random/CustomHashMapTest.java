package random;

public class CustomHashMapTest {
public static void main(String[] args) {
	CustomHashMap<Integer, String> cm=new CustomHashMap<>();
	cm.put(1, "Satyaki");
	cm.put(1, "Satyaki");
	cm.put(2, "John");
	cm.put(3, "Peter");
	cm.put(4, "Tom");
	cm.put(2, "John");
	cm.put(5, "John");
	cm.put(6, "Peter");
	cm.put(7, "Tom");
	cm.put(8, "John");
	cm.put(9, "Peter");
	cm.put(10, "Tom");
	cm.put(11, "John");
	cm.put(12, "Peter");
	cm.put(13, "Tom");
	cm.put(14, "John");
	cm.put(15, "Peter");
	cm.put(16, "Tom");
	System.out.println(cm.toString());
	System.out.println(cm.get(4));
}
}
