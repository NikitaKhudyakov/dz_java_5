import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class task {

    public static void telef(Map<String, ArrayList> telfone) {

        System.out.println(Arrays.asList(telfone));
        return;
    }

    public static void main(String[] args) {
        Map<String, ArrayList> telfone = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int selection = 0;

        String menu = ("Выберите команду: 1 - Добавить контакт, 2 - Вывести всех, 3 - Выход");

        do {
            System.out.println(menu);
            selection = scan.nextInt();

            switch (selection) {
                case 1:

                    System.out.println("Введите Имя");
                    String name = scan.next();
                    System.out.println("Введите номер");
                    var numb = scan.nextInt();
                    ArrayList<Integer> arrInt = new ArrayList<>();
                    if (telfone.containsKey(name)) {
                        arrInt = telfone.get(name);
                        arrInt.add(numb);
                        telfone.put(name, arrInt);
                    }

                    else {
                        ArrayList<Integer> arrInt1 = new ArrayList<>();
                        arrInt1.add(numb);
                        telfone.put(name, arrInt1);
                    }
                    break;

                case 2:
                    Print(telfone);
                    break;

                case 3:
                    System.out.println("Конец работы!");
                    break;

            }

        } while (selection != 3);
    }


static void Print(Map<String, ArrayList> telfone) {

        Set <String> keySet = telfone.keySet();
        int max = 0;
        int min = 1000;
        for (var item : telfone.entrySet()) {
            if (max < item.getValue().size())
                max = item.getValue().size();
            if (min > item.getValue().size())
                min = item.getValue().size();
        }
        Stack<String> str = new Stack<>();
        int number = min;
        while (number <= max) {

            for (var i : telfone.entrySet()) {
                if (i.getValue().size() == number) {
                    str.push(i.getKey());
                }  
            }
            number += 1;
        }
        String name;
        for (int i = 0; i < keySet.size(); i++) {
            name = str.pop();
            for (var item : telfone.entrySet()) {
                if (name == item.getKey()) {
                    System.out.printf(item.getKey());
                    System.out.println(item.getValue());
                }
            }
        }
        System.out.println();
    }
}