import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by VMikkilineni on 3/18/2015.
 */

public class C1E1 {
    
    public static void main(String... args)throws Exception{
        String[] array=getWordsAsArray();

        CopyOnWriteArraySet<Long> threadIds=new CopyOnWriteArraySet<Long>();
        Long startTime=System.currentTimeMillis();
        threadIds.add(Thread.currentThread().getId());
        Arrays.sort(array, (a, b) -> {
            threadIds.add(Thread.currentThread().getId());
            return a.compareTo(b);
        });
        Long endTime=System.currentTimeMillis();
        System.out.println("Serial sort period= "+(endTime-startTime));
        System.out.println("ThreadIds ="+threadIds.toString());
        array=getWordsAsArray();
        threadIds.clear();
        threadIds.add(Thread.currentThread().getId());
        Long startTime2=System.currentTimeMillis();
        Arrays.parallelSort(array, (a,b)->{
            threadIds.add(Thread.currentThread().getId());
            return a.compareTo(b);
        });
        Long endTime2=System.currentTimeMillis();
        System.out.println("Parallel sort period= "+(endTime2-startTime2));
        System.out.println("ThreadIds ="+threadIds.toString());
        
    }

    private static String[] getWordsAsArray() throws Exception {
        Path path= Paths.get("C:\\Users\\VMikkilineni\\SampleLargeTxt.txt");
        List<String> result=new ArrayList<String>();
        try(BufferedReader reader=Files.newBufferedReader(path) ){
            String line=null;
            while ((line=reader.readLine())!=null){
                result.add(line);
            }

        }

        return result.toArray(new String[result.size()]);
    }
}
