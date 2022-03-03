package homework_2;

import java.util.ArrayList;

public class SelectionSort {
    public static void sort(ArrayList<Notebook> notebooks) {

        int len  = notebooks.size();

        // сортировка по цене
        for (int i = 0; i < len; i++) {
            int min = i;
            int max = i;

            for (int j = i + 1; j < len; j++) {
                if (notebooks.get(j).getPrice() > notebooks.get(max).getPrice()) {
                    max = j;
                }
                if (notebooks.get(j).getPrice() < notebooks.get(min).getPrice()) {
                    min = j;
                }
            }

            willChangePlaces(notebooks, i, min);

            if (i != max) {
                willChangePlaces(notebooks, len - 1, max);
                len--;
            } else {
                willChangePlaces(notebooks, len - 1, min);
            }
        }
    }

    private static void willChangePlaces(ArrayList<Notebook> notebooks, int j, int i) {
        Notebook notebook = notebooks.get(j);
        notebooks.set(j, notebooks.get(i));
        notebooks.set(i, notebook);
    }
}
