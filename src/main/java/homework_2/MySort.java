package homework_2;

import java.util.ArrayList;

public class MySort {
    public static void sort(ArrayList<Notebook> notebooks) {

        Notebook notebook = new Notebook();

        int[][][] index = new int[notebook.getListManufacturerLength()][notebook.getRamsLength()][notebook.getPriceLength()];

        for (Notebook value : notebooks) {
            index[value.getManufacturerIndex()][value.getRamIndex()][value.getPriceIndex()]++;
        }

//        print(index);
//        System.out.println();

        int result = 0;
        for (int m = index.length - 1; m >= 0; m--) {
            for (int r = index[m].length - 1; r >= 0; r--) {
                for (int p = index[m][r].length - 1; p >= 0; p--) {
                    if (m == index.length - 1 && r == index[m].length - 1 && p == index[m][r].length - 1) {
                        index[m][r][p] = notebooks.size() - index[m][r][p];
                        result = index[m][r][p];
                    } else {
                        index[m][r][p] = result - index[m][r][p];
                        result = index[m][r][p];
                    }
                }
            }
        }

//        print(index);

        ArrayList<Notebook> arrayList = new ArrayList<>(notebooks);

        int m, r, p;

        for (int i = 0; i < notebooks.size(); i++) {

            m = arrayList.get(i).getManufacturerIndex();
            r = arrayList.get(i).getRamIndex();
            p = arrayList.get(i).getPriceIndex();

            notebooks.set(index[m][r][p], arrayList.get(i));

            index[m][r][p]++;
        }
    }

    private static void print(int[][][] index) {
        for (int[][] ints : index) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    System.out.print(i + ", ");
                }
                System.out.print("]   [");
            }
            System.out.println();
        }
    }
}