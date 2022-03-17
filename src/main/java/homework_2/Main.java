package homework_2;

import java.util.ArrayList;

public class Main {
    private static Long time;
    private static final long NOTEBOOKS_SIZE = 50000;
    public static void main(String[] args) {

//  ###1. Отсортировать массив, состоящий из экземпляров класса Notebook в количестве 10000 штук.
//        Условия для сортировки:
//`1)` по цене. От 500 до 2000 долларов с шагом в 50
//        если цена равная, то
//`2)` по кол-ву оперативной памяти (от 4 до 24 с шагом 4)
//        если памяти тоже равное количество, то `3)` по производителю:
//        Lenovo, Asos, MacNote, Acer, Xiaomi
//        Добиваться максимально оптимальной сложности О-большая

        startTime();

        ArrayList<Notebook> arrayList = new ArrayList<>();
        for (int i = 0; i < NOTEBOOKS_SIZE; i++) {
            arrayList.add(new Notebook());
        }

        endTime();

//        System.out.println(arrayList);

        System.out.println("Время создания массива из " + NOTEBOOKS_SIZE + " объектов -> " + time + " ms");

        startTime();

        MySort.sort(arrayList);   // Время полной сортировки по всем параметрам
        // 1 000 000 -> 132 ms // 100 000 -> 30 ms // 50 000 -> 39 ms // 10 000 -> 17 ms

//        SelectionSort.sort(arrayList); // Время сортировки 50 000 объектов только по цене составило -> 12085 ms

        endTime();

//        System.out.println(arrayList);

        System.out.println("Время сортировки массива из " + NOTEBOOKS_SIZE + " объектов -> " + time + " ms");
    }

    public static void startTime() {
        time = System.currentTimeMillis();
    }

    public static void endTime() {
        time = System.currentTimeMillis() - time;
    }
}
