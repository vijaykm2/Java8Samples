import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * Created by VMikkilineni on 3/18/2015.
 */
public class C1E3 {
    public static void main(String...args){
        Arrays.asList(getMethodDirsWithLambda("C://FirefoxBeta","exe")).forEach(System.out::println);
    }
    FilenameFilter filter=(d,s)->{
        if(d.getName().endsWith(s)){
            return true;
        }
        return false;
    };
    String fil="exe";
    private static File[] getMethodDirsWithLambda(String s,String e) {

        File file=new File(s);

        return file.listFiles((d)->d.getName().endsWith(e));

    }
}
