import java.util.*;

public class Main {
    /**
     Урок 3. Коллекции JAVA: Введение
     1. Создать новый список, добавить несколько строк и вывести коллекцию на экран.
     2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
     3. Вставить элемент в список массивов в первой позиции.
     4. Извлечь элемент (по указанному индексу) из заданного списка.
     5. Обновить определенный элемент списка по заданному индексу.
     6. Удалить третий элемент из списка.
     7. Поиска элемента в списке по строке.
     8. *Сортировка заданного списка массивов.
     9. *Копирования одного списка массивов в другой.
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //1.
        List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        System.out.println("1 : " + list);

        //2.
        List<String> colors = Arrays.asList("Red","Orange","Yellow","Green","Cyan","Blue","Purple");
        for (int i = 0; i < colors.size(); i++) {
            colors.set(i, colors.get(i) + "!");
        }
        System.out.println("2 : " + colors);
        //3.
        List<String[]> arrays = new ArrayList<String[]>();
        String[] arr1 = new String[] {"str1", "str2", "str3"};
        String[] arr2 = new String[] {"str21", "str22", "str23"};
        arrays.add(arr1);
        arrays.add(arr2);
        arrays.add(0, new String[] {"str31","str32","str33"});
        System.out.println("3 : " + toStringListArray(arrays));
        //4.
        String str = list.get(1);
        System.out.println("4 : " + str);
        //5.
        list.set(1, "String21");
        System.out.println("5 : " + list.get(1));
        //6.
        list.remove(3);
        System.out.println("6 : " + list);
        //7.
        for (String s : list) {
            if (s.contains("3")) {
                System.out.println("7 : " + s + " contain 3");
            }
        }
        //8.
        Collections.sort(arrays, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Arrays.compare(o1, o2);
            }
        });
        System.out.println("8 : " + toStringListArray(arrays));
        //9.
        List<String[]> arraysCopy = new ArrayList();
        for (int i = 0; i < arrays.size(); i++) {
            arraysCopy.add(Arrays.copyOf(arrays.get(i), arrays.get(i).length));
        }
        System.out.println("9 : original : " + toStringListArray(arrays));
        System.out.println("9 : copy : " + toStringListArray(arraysCopy));
    }

    public static String toStringListArray(List<String[]> list) {
        StringBuilder sb = new StringBuilder();
        for (String[] arr : list) {
            sb.append(Arrays.toString(arr));
        }
        return sb.toString();
    }
}