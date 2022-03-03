package homework_1;

public class Homework_1 {
    public static void main(String[] args) {
        /*
        1. Прочитать в книге "Грокаем алгоритмы" или в предложенных материалах про алгоритмы и О-большое.

        2. Определить сложность следующих алгоритмов:

        -. Поиск элемента массива с известным индексом                 - O(1)
        -. Дублирование одномерного массива через foreach              - O(n)
        -. Удаление элемента массива с известным индексом без сдвига   - O(1)
        -. Удаление элемента массива с неизвестным индексом без сдвига - O(n)
        -. Удаление элемента массива с неизвестным индексом со сдвига  - O(n)



        3. Определить сложность следующих алгоритмов. Сколько произойдет итераций?
        a)
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {            - O(n)
            for (int j = 1; j < n; j *= 2) {     - O(log(n))
                arrayList.add(i * j);            - В конец O(1) / В начало O(n)  Среднее - O(n/2) -> O(n)
            }
        } O(n * log(n))    /    O(n * (log(n) * n)) == O(n^2 * log(n))


        b)
        int n = 10000;
        List<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {       - O(n/2) -> O(n)
            for (int j = i; j < n; j++) {      - O(n/2) -> O(n)
                arrayList2.add(i * j);         - В конец O(1) / В начало O(n)  Среднее - O(n/2) -> O(n)
            }
        } O(n^2)   /  O(n^3)


        с)
        int n = 10000;
        List<Integer> arrayList3 = new ArrayList<>();
        for (int i = 0; i < n; i++) {         - цикл дойдёт до i == 9 -> O(10)
            for (int j = 0; j < n; j++) {     - При каждом запуске внешнего цикла внутренний цикл уменьшает
                                                n в 2 раза -> 5000 / 2500 / 1250 / 625 / 312 / 156 / 78 / 39
                                                19 / 9 (здесь внутренний и внешним цикл встретились по значению n
                                                кол-во итераций обеих циклов  9991 -> O(n)
                arrayList3.add(i * j);        - В конец O(1) / В начало O(n)  Среднее - O(n/2) -> O(n)
                n--;
            }
        } O(n) / O(n^2)


        d*)
        factorial(BigInteger.valueOf(10000));
        public static BigInteger factorial(BigInteger n) {
            if (n.equals(BigInteger.ONE)) {
                return n;
            }
            return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
        } O(n)


        e*)
        fib(BigInteger.valueOf(50));
        public static BigInteger fib(BigInteger n) {
            if (n.equals(BigInteger.ONE) || n.equals(BigInteger.TWO)) {
                return n;
            }
            return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
    } O (2^n)
*/
    }
}
