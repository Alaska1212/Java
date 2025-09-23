package hw2;
import java.util.Scanner;
import java.util.Arrays;

//Ввести два цілі числа a, b та масив цілих чисел. Вивести всі числа, які лежать
//
//на відрізку [a, b].

public class B02_03 {
    public static void main(String[] args) {
        System.out.println("Введіть 2 цілих числа: ");

        Scanner in = new Scanner(System.in);
        System.out.print("a = ");
        double a = in.nextDouble();
        System.out.print("b = ");
        double b = in.nextDouble();

        System.out.print("Кількість чисел у масиві: ");
        int n = in.nextInt();

        System.out.println("Введіть масив: ");

        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
    }
        System.out.println("Числа які лежать на відрізку [a, b]: ");
        for(int i=0;i<array.length;i++){
            if(array[i]<b){
                if(array[i]>a){
                    System.out.println(array[i]);
                }
            }
        }
    }

}
