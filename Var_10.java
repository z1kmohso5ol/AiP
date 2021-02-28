package variant10;
import java.util.Scanner;

class Ozero{
    String name;
    double square;
    int mesto;
}

public class Ozera {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество озер=> ");
        int n = sc.nextInt(); // количество стран
        Ozero nazvanie[] = new Ozero[n];
        System.out.println("Введите информацию об озерах: ");
        for (int i = 0; i < nazvanie.length; i++) {
            sc.nextLine(); // очистка буфера
            nazvanie[i] = new Ozero();
            System.out.print("Название " + (i + 1) + "-й озера => ");
            nazvanie[i].name = sc.nextLine();
            System.out.print("Площадь " + (i + 1) + "-й озера => ");
            nazvanie[i].square = sc.nextDouble();
            System.out.print("Место " + (i + 1) + "-й озера => ");
            nazvanie[i].mesto = sc.nextInt();
        }

        System.out.println("\nХарактеристики стран:");
        for (Ozero str : nazvanie)
            System.out.println(" " + str.name + "\t" + str.square + " кв.м" + "\t" + str.mesto);

        int nommax = 0; // номер элемента для страны с максимальной
        // площадью (начальное значение)
        double max = nazvanie[nommax].square; // максимальная площадь
        // (начальное значение)
        for (int i = 0; i < nazvanie.length; i++)
            if (nazvanie[i].square > max) {
                max = nazvanie[i].square;
                nommax = i;
            }
        System.out.println("\nОзеро с максимальной площадью :");
        System.out.println("" + nazvanie[nommax].name + "\t" + nazvanie[nommax].square + " кв. м");

        // СОРТИРОВКА СТРАН ПО НАЗВАНИЮ
        for (int i = 0; i < nazvanie.length - 1; i++)
            for (int j = 0; j < nazvanie.length - i - 1; j++)
                if (nazvanie[j].name.compareTo(nazvanie[i + 1].name) > 0) {
                    Ozero rab = nazvanie[j]; //rab – рабочая переменная для перестановки
                    nazvanie[j] = nazvanie[j + 1];
                    nazvanie[j + 1] = rab;
                }
        System.out.println("\nОтсортированный список по названиям:");
        for (int i = 0; i < nazvanie.length; i++) {
            System.out.println(""+nazvanie[i].name +"\t"+nazvanie[i].square +"  кв. м");
        }

        // ПЛОЩАДЬ МЕНЬШЕ СРЕДНЕЙ
        double s=0; // суммарная площадь
        for (int i = 0; i < nazvanie.length; i++)
            s+=nazvanie[i].square;
        double sr=s/nazvanie.length; ; // средняя площадь
        System.out.println("Средняя площадь ="+sr);
        System.out.println("\nОзера, с площадью меньше средней");
        for (int i = 0; i < nazvanie.length; i++) {
            if (nazvanie[i].square<sr)
                System.out.println(nazvanie[i].name +"\t"+nazvanie[i].square +" кв. м");
        }

        // ПОИСК ПО НАЗВАНИЮ
        sc.nextLine(); // очистка буфера
        System.out.println("Введите название искомого озера=> ");
        String name=sc.nextLine();
        int nom=-1; // -1 – страна с искомым названием отсутствует

        for (int i = 0; i < nazvanie.length; i++)
            if (name.equalsIgnoreCase(nazvanie[i].name))
                nom=i;
        if (nom!= -1) {
            System.out.println("Такое озеро есть в списке. Это "
                    +nazvanie[nom].name+" "+nazvanie[nom].square+" кв. м, " +"место " +nazvanie[nom].mesto);
        }else System.out.println("Такого озера нет в списке");
    }
}
