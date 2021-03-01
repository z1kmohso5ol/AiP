import java.util.Scanner;
class Node {
    public int value;
    public Node next;
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class lab3 {
    
    public static void main(String[] args) {
    int Summa = 0, Kolichectvo = 0, i = 1, max = 1, min = 1, rab = 0;
    double avg = 0;

    Scanner sc = new Scanner(System.in);
    System.out.println("Введите количество элементов в списке ");
    int m = sc.nextInt() - 1;
    System.out.println("Введите значение 1 числа ");
    int k = sc.nextInt();
    Node head = new Node(k, null);
    Node tail = head;
    for (; m != 0; m--) {
        i += 1;
        System.out.println("Введите значение " + i + " числа ");
        int a = sc.nextInt();
        tail.next = new Node(a, null);
        tail = tail.next;
    }

    Node ref = head;
    while (ref != null) {
        if (ref.value % 2 == 0) {
            rab += 1;
            min=ref.value;
        }
        ref = ref.next;
    }

    if (rab != 0) {
        ref = head;
        while (ref != null) {
            if (ref.value > max & ref.value % 3 == 0) {
                max = ref.value;
            }
            if (ref.value < min & ref.value % 3 == 0) {
                min = ref.value;
            }
            if (ref.value % 3 == 0) {
                Summa += ref.value;
                ref = ref.next;
                Kolichectvo += 1;
            } else ref = ref.next;
        }
        if (Kolichectvo != 0) {
            avg = (double) Summa / Kolichectvo;
        }
    }
    if (rab!=0){
        System.out.println();
        System.out.println("Сумма чисел которые делятся на 3: " + Summa);
        System.out.println("Количество чисел которые делятся на 3: " + Kolichectvo);
        System.out.println("Среднее значение чисел которые делятся на 3: " + avg);
        System.out.println("Максимальное значение чисел которые делятся на 3: " + max);
        System.out.println("Минимальное  значение чисел которые делятся на 3: " + min);}
    else
        System.out.println("Чисел которые делятся на 3 нет:");


    System.out.println();
    ref = head;
    while (ref != null) {
        if (ref.value == max) {
            ref.value = min;}
        else if (ref.value == min) {
            ref.value = max;
        }
        ref = ref.next;
    }
    ref = head;
    while (ref != null) {
        System.out.print(" " + ref.value);
        ref = ref.next;
    }
}
}
