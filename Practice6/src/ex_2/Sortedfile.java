package ex_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Sortedfile {
    public static void main(String[] args) throws IOException {
        String input = "intput ==> ";
        String output = "output ==> ";
        String fileNameInput = "part.txt";
        String fileNameOutput = "part_sorted.txt";
        int[] numbers = getRandomTenNumbersInRange(0, 50);

        Files.write(Paths.get(fileNameInput), convertArrayToString(numbers).getBytes());
        Files.lines(Paths.get(fileNameInput)).forEach(s -> System.out.println(input + s));
        bubbleSorter(numbers);
        Files.write(Paths.get(fileNameOutput), convertArrayToString(numbers).getBytes());
        Files.lines(Paths.get(fileNameOutput)).forEach(s -> System.out.println(output + s));
    }

    private static String convertArrayToString(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
            if (i < numbers.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private static int[] getRandomTenNumbersInRange(int min, int max) {
        int[] array = new int[10];
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = r.nextInt((max - min) + 1);
        }
        return array;
    }

    private static void toSwap(int first, int second, int[] array) { //метод меняет местами пару чисел массива
        int dummy = array[first];      //во временную переменную помещаем первый элемент
        array[first] = array[second];       //на место первого ставим второй элемент
        array[second] = dummy;          //вместо второго элемента пишем первый из временной памяти
    }

    private static void bubbleSorter(int[] array) {     //МЕТОД ПУЗЫРЬКОВОЙ СОРТИРОВКИ
        for (int out = array.length - 1; out >= 1; out--) {  //Внешний цикл
            for (int in = 0; in < out; in++) {       //Внутренний цикл
                if (array[in] > array[in + 1])             //Если порядок элементов нарушен
                    toSwap(in, in + 1, array);             //вызвать метод, меняющий местами
            }
        }
    }

}
