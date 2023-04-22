class Watek extends Thread {
    private int id;
    private Obraz obraz;

    Watek(int id, Obraz obraz) {
        this.id = id;
        this.obraz = obraz;
    }
    public void run() {
        obraz.calculate_histogram_parallel(id);
        obraz.print_histogram_parallel(id);
    }
}