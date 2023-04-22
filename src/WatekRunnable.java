public class WatekRunnable implements Runnable{
    private Obraz obraz;
    private int id;
    private int a;
    private int b;
    WatekRunnable( int a, int b,Obraz obraz,int id ) {
        this.obraz = obraz;
        this.a = a;
        this.b = b;
        this.id=id;
    }
    @Override
    public void run() {
        obraz.calculate_histogram_parallel_dec(a, b);
        obraz.print_histogram_parallel_dec(a, b,id );
    }
}
