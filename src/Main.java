import java.util.*;
import java.util.stream.Collectors;

/**
 * Description of the class or method
 *
 * @author HukoJlauII
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();
        arrayList = generateRandomList(arrayList);
        linkedList = generateRandomList(linkedList);
        hashMap = generateRandomMap(hashMap);
        treeMap = generateRandomMap(treeMap);
        testList(arrayList);
        testList(linkedList);
        testMap(hashMap);
        testMap(treeMap);
        swapMap(hashMap);
    }

    public static void testList(List<Integer> list) {
        Random random = new Random();
        long start = System.nanoTime();
        list.add(random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("Вставка в " + list.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        list.remove(0);
        System.out.println("Удаление первого элемента " + list.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        list.remove(list.size() - 1);
        System.out.println("Удаление последнего элемента " + list.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        list.remove(list.size() / 2);
        System.out.println("Удаление среднего элемента " + list.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        list.contains(7);
        System.out.println("Удачный поиск элемента " + list.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        list.contains(-1);
        System.out.println("Неудачный поиск элемента " + list.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        System.out.println("------------------------------------------------------------------------");
    }

    public static void testMap(Map<Integer, Integer> map) {
        Random random = new Random();
        long start = System.nanoTime();
        map.put(map.size(), random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("Вставка в " + map.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        map.remove(0);
        System.out.println("Удаление первого элемента " + map.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        map.remove(map.size() - 1);
        System.out.println("Удаление последнего элемента " + map.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        map.remove(map.size() / 2);
        System.out.println("Удаление среднего элемента " + map.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        map.containsKey(1);
        System.out.println("Удачный поиск элемента по ключу" + map.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        map.containsKey(-1);
        System.out.println("Неудачный поиск элемента по ключу" + map.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        map.containsValue(1);
        System.out.println("Удачный поиск элемента по значению" + map.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        start = System.nanoTime();
        map.containsValue(-1);
        System.out.println("Неудачный поиск элемента по значению" + map.getClass().getName() + ": " + (System.nanoTime() - start) + "нс");

        System.out.println("------------------------------------------------------------------------");
    }

    public static List<Integer> generateRandomList(List<Integer> list) {
//        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        return list;
    }

    public static Map<Integer, Integer> generateRandomMap(Map<Integer, Integer> map) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            map.put(i, random.nextInt(0, 100));
        }
        return map;
    }

    public static void swapMap(Map<Integer, Integer> map) {

        System.out.println("Изначальный словарь:\n" + map);

        Map<Integer, Integer> swappedMap = new HashMap<>();
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            swappedMap.put(value, key);
        }

        System.out.println("Изменённый словарь:\n" + swappedMap);

        Map<Integer, Integer> streamMap = map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (a, b) -> a, HashMap::new));

        System.out.println("Изменённый словарь с помощью stream:\n" + streamMap);
    }
}