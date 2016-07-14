
import java.util.HashMap;
import java.util.Set;
public class Replace {
public static void main(String[] args) {
HashMap<String,String> hm = new HashMap<String,String>();
String s1= args[0];
hm.put("test", "testing");
hm.put("hello", "hello world");
hm.put("123", "456");
System.out.println(hm);
System.out.println("initial string is: "+ s1);
Set<String> keys = hm.keySet();
for(String key: keys){
if( s1.contains(key))
s1=(s1.replaceAll(key, hm.get(key)));
}
System.out.println("\n Updated String is :" + s1);
}
}