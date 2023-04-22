import java.util.Scanner;


class Histogram_test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Set image size: n (#rows), m(#kolumns)");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Obraz obraz_1 = new Obraz(n, m);

        obraz_1.calculate_histogram();
        //obraz_1.print_histogram();

        System.out.println("Set number of threads");
        int num_threads = scanner.nextInt();

//        Watek[] NewThr = new Watek[num_threads];
//
//        for (int i = 0; i < num_threads; i++) {
//            (NewThr[i] = new Watek(i,obraz_1)).start();
//        }
//
//        for (int i = 0; i < num_threads; i++) {
//            try {
//                NewThr[i].join();
//            } catch (InterruptedException e) {}
//        }
//        obraz_1.compare_histogram(num_threads);

        Thread[] NewThr2 = new Thread[num_threads];
        int chars_quantity = 20;
        int tThread = (chars_quantity / num_threads);
        for (int i = 0; i < num_threads; i++) {
            int a = tThread * i;
            int b = Math.min(((i + 1) * tThread), chars_quantity);
            NewThr2[i] = new Thread(new WatekRunnable(a, b, obraz_1, i));
            NewThr2[i].start();
        }
        for (int i = 0; i < num_threads; i++) {
            try {
                NewThr2[i].join();
            } catch (InterruptedException e) {
            }
        }
        obraz_1.compare_histogram(num_threads);

    }




}

