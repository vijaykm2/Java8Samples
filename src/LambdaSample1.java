import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * Created by VMikkilineni on 3/6/2015.
 */
public class LambdaSample1 {
    static Comparator<String> com=(first,second)->Integer.compare(first.length(),second.length());
    public static void main(String... args){
        String[] strings={"ind","America","England","vijay","Reddit","hippopotamus"};
        List<String> ls=new ArrayList<String>(Arrays.asList(strings));
        System.out.println(ls.toString());
        ls.sort(com);
        System.out.println(ls.toString());

            }

}
