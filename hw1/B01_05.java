package hw1;
import java.util.Scanner;

public class B01_05 {

    public static void main(String[] args) {
        int N, M;

        if(args.length >= 2) {
            N = Integer.parseInt(args[0]);
            M = Integer.parseInt(args[1]);
        }
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("N = ");
            N = in.nextInt();
            System.out.println("M = ");
            M = in.nextInt();
        }

        for(int i = 0;  i < N; i++) {
            int random = (int)(Math.random()*M);
            System.out.println(random);
        }

    }

}