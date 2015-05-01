import java.util.ArrayList;
import java.util.List;

/**
 * Created by VMikkilineni on 3/19/2015.
 */
public class C1E8 {
    public static void main(String[] args){
        String[] names={"Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay","Paul","Peter","Mary","Vijay" };
        List<Runnable> runners=new ArrayList<Runnable>();
        for(String name:names){
            runners.add(()->{
                for(int i=0;i<100;i++){
                    System.out.println(name+" "+Thread.currentThread().getId());
                }

            });
        }
        for(Runnable r:runners){
            new Thread(r).start();
        }

        runners.clear();;
        for(int i=0;i<names.length;i++){
            final String name=names[i];
            runners.add(()->{
                for(int j=0;j<100;j++){
                    System.out.println(name+" "+Thread.currentThread().getId());
                }

            });
        }
        for(Runnable r:runners){
            new Thread(r).start();
        }


    }
}
