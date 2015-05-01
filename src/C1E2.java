import java.io.File;
import java.util.Arrays;

/**
 * Created by VMikkilineni on 3/18/2015.
 */
public class C1E2 {
    public static void main(String[]args){
     
        Arrays.asList(getChildDirsWithLambda("C:\\")).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        Arrays.asList(getMethodDirsWithMethodRef(".")).forEach(System.out::println);
    }

    private static File[] getMethodDirsWithMethodRef(String s) {

        File file=new File(s);
        return file.listFiles(d ->d.isDirectory());

    }

    private static File[] getChildDirsWithLambda(String s) {
        File file=new File(s);
        return file.listFiles(File::isDirectory);
        
    }
}
