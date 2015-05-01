import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by VMikkilineni on 3/18/2015.
 */
public class C1E4 {
    static Comparator<File> comp=(f1,f2)->{
        if(f1.isDirectory()&&!f2.isDirectory()){
            return -1;
        }else if(!f1.isDirectory()&&f2.isDirectory()){
            return 11;
        }else{
            return f1.compareTo(f2);
        }
    };
    public static void main(String... args){
        File[] files=sort(".");
        Arrays.asList(files).forEach(System.out::println);
    }

    private static File[] sort(String s) {
        File dir=new File(s);
        File[] dirFiles=dir.listFiles();
        Arrays.sort(dirFiles,comp);
        return dirFiles;
    }
}
