package hw1;

/*Підрахувати добуток аргументів командного рядка. Якщо аргументи не є

цілими числами, вивести про це повідомлення.
 */

public class B01_03 {

    public static void main(String[] args) {
        int s = 1;

        for(int i=0; i<args.length; i++ ) {
            try {
                s *= Integer.parseInt(args[i]);
            }
            catch(NumberFormatException e){
                System.out.println("Аргументи не є цілими числами");
            }
        }
        System.out.println(s);

    }

}