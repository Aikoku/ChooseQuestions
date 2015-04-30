/**
 * Created by Mark on 27.06.2014.
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, List<Integer>> pplM = new HashMap<String, List<Integer>>();
        Random rand = new Random();
        int avgQuestions;
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 33, 38, 39, 40, 47};
        String[] str = {"firstName","secondName","thirdName"};

        int totalPpl = str.length;
        avgQuestions = arr.length / totalPpl;

        printArray(arr);

        System.out.println("\n\nВсего вопросов: " + arr.length);
        System.out.println("Всего участников: " + totalPpl);
        System.out.println("Каждому по " + avgQuestions + " вопроса(ов)");
        System.out.println("Было не распределено " + (arr.length - avgQuestions * str.length) + " вопроса(ов)");
        int random;
        ArrayList<Integer> temp;
//        printArrayZero(arr);

        for (int n = 0; n < str.length; n++) {
            temp = new ArrayList<Integer>();
            for (int j = 0; j < avgQuestions; j++) {
                random = rand.nextInt(arr.length);
//                    System.out.printf("%3s ", arr[random]);
                if (arr[random] != 0) {
                    temp.add(arr[random]);
                    arr[random] = 0;
                } else {
                    do {
                        random = rand.nextInt(arr.length);
                    } while (arr[random] == 0);
                    temp.add(arr[random]);
                    arr[random] = 0;
                }
                printArrayZero(arr);
            }
//            System.out.println(" set = " + n);
            pplM.put(str[n], temp);
        }
        printPpl(pplM);
        printRemaining(arr);
        printEmail(str);
//        printArrayZero(arr);

    }

    private static void printRemaining(int[] arr) {
        String strTemp = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                strTemp += arr[i]+" ";
            }
        }
        if (strTemp.isEmpty()) {
            System.out.println("Все вопросы были распределены.");
        } else {
            System.out.println("Вопрос(ы) оставшийся(еся) без внимания: " + strTemp);
        }
    }

    private static void printPpl(HashMap<String, List<Integer>> pplM) {
        System.out.println();
        for (Map.Entry<String, List<Integer>> entry : pplM.entrySet()) {
            String key = entry.getKey();
            List<Integer> value = entry.getValue();
            System.out.printf("%15s = ", key);
            for (int i = 0; i < value.size(); i++) {
                System.out.print(value.get(i) + " ");
            }
            System.out.println();

        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4s) arr = " + arr[i] + "\t", i);
            if (i % 5 == 4 && i != 0) {
                System.out.println();
            }
        }
    }


    private static void printEmail(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4s, ", arr[i]);
        }
    }

    private static void printArrayZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3s", arr[i]);
            if (i % 44 == 43 && i != 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
