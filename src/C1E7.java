/**
 * Created by VMikkilineni on 3/19/2015.
 */
public class C1E7 {
    public static Runnable andThen(Runnable first, Runnable second){
        return()->{
            System.out.println("andThen : "+Thread.currentThread().getId());
            new Thread(first).start();
            new Thread(second).start();
        };
    }
    public static void main(String[] args){
        (new Thread(andThen(
                ()->{
                    System.out.println("First : " + Thread.currentThread().getId());
                }
                ,()->{
                    System.out.println("Second: "+Thread.currentThread().getId());
                }
        ))).start();
    }
}
