import java.util.InputMismatchException;
import java.util.Scanner;


public class Lab4_7 {
    public static void main(String[] args) {
        try {
            System.out.println("Введите количество чисел в массиве");
            Scanner sc= new Scanner(System.in);
            byte a = sc.nextByte();
            int k=0,b=1,c=0;
            float max = 1;
            float arr[] = new float[a];
            for (byte i=0; i < a ;i++){
                float number = sc.nextFloat();
                arr[i]=number;
            }
            for (byte i=0; i < a ;i++){
                System.out.print(arr[i]+" ");
            }
            for (byte i=0; i < a ;i++){
                if (max<arr[i]){
                    max=arr[i];
                    b+=1;
                    c=i+1;
                }
                if (arr[i]>0){
                    k+=1;
                }
                if(k==0)
                    System.out.println("В массиве отсутсвуют положительные элементы");
            }
            if ( b!=1){
                System.out.println();
                System.out.println("Максимум среди положительных элементов = "+ max);
                System.out.println("Номер максимума среди отрицательных элементов = "+ c);
            }
        } catch(InputMismatchException e){
            System.out.println("Ошибка при вводе числа");
        } catch(RuntimeException qe){
        }

    }
}
