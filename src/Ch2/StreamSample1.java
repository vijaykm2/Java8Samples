package Ch2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by VMikkilineni on 4/2/2015.
 */
public class StreamSample1 {
    public static void main(String [] args){
        try{
            String contents= new String(Files.readAllBytes(Paths.get((new File("C:\\Users\\VMikkilineni\\Documents\\selenium\\Take screenshot sample method.txt")).toURI())), StandardCharsets.UTF_8);
            List<String > words= Arrays.asList(contents.split("[\\P{L}]+"));
            long count1=0;
            long count2=0;
            Long startTime1=System.currentTimeMillis();
          //  count1=words.stream().filter(w->w.length()>2).count();
            count1= (Stream.of(contents.split("[\\P{L}]+"))).filter(w->w.length()>10).filter(w->(w.contains("Se")||w.contains("se"))).count();
            Long endTime1=System.currentTimeMillis();
            System.out.println(count1+" Stream time: "+(endTime1-startTime1));
            Long startTime2=System.currentTimeMillis();
            count2=words.parallelStream().filter(w->w.length()>2).count();
            Long endTime2=System.currentTimeMillis();
            System.out.println(count2+" Stream time: "+(endTime2-startTime2));
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
