/**
 * Created by VMikkilineni on 3/19/2015.
 */
@FunctionalInterface
interface RunnableEx{
    void run() throws Exception;
}
public class C1E6 {
    public static Runnable uncheck(RunnableEx runner){
        Runnable runnable=()->{
            try{
                runner.run();
            }catch (Exception e){
                System.out.println("Exception ignored.  "+ e.toString());
            }
        };
        return runnable;
    }
    public static void main(String... args){
        new Thread(uncheck(()->{
            System.out.println("Inside Run ex thread id: "+Thread.currentThread().getId());
            Thread.sleep(1000);
            throw new Exception("Random Exception");

        })).start();
    }
}
