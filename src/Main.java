import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Laptops> set = getLaptops();
        Map<String, String > creteries = readInput();
        Set<Laptops> sorted = sortLaptops(creteries, set);
        if (sorted.isEmpty()){
            System.out.println("Нет подходящих ноутбуков");
        } else {
            System.out.println(sorted);
        }

    }

    private static Set<Laptops> sortLaptops(Map<String, String> creteries, Set<Laptops> set){
        Set<Laptops> sorted = new HashSet<>();
        int invalid;
        for (Laptops laptop: set) {
            invalid = 0;
            for (String key: creteries.keySet()) {
                switch (key){
                    case "manufacturer":
                        if (!laptop.manufacturer.equals(creteries.get(key))){
                            invalid = invalid + 1;
                        }
                        break;

                    case "cpu":
                        if (!laptop.cpu_model.contains(creteries.get(key))){
                            invalid = invalid + 1;
                        }
                        break;

                    case "ram_value":
                        if (laptop.ram_volume != Integer.parseInt(creteries.get(key))){
                            invalid = invalid + 1;
                        }
                        break;

                    case "disk_size":
                        if (laptop.disk_size != Integer.parseInt(creteries.get(key))){
                            invalid = invalid + 1;
                        }
                        break;

                    case "diagonal":
                        if (!laptop.diagonal.equals(creteries.get(key))){
                            invalid = invalid + 1;
                        }
                        break;
                }
            }
            if (invalid == 0){
                sorted.add(laptop);
            }
        }
        return sorted;
    }
    private static Map<String, String > readInput() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        Map<String , String> creteries = new HashMap<>();
        int cretery = 10;
        System.out.println("Введите номер критерия от 1 до 5, где 1 - производитель, 2 - процессор, 3 - объём озу, 4 - объём диска, 5 - диагональ дисплея,  затем введите значение для критерия, для завершения ввода критериев филтрации введите 0");
        while (cretery != 0){
            cretery = Integer.parseInt(reader.readLine());
            switch (cretery){
                case (1):
                    if (!creteries.containsKey("manufacturer")){
                        creteries.put("manufacturer", reader.readLine());
                    } else {
                        System.out.println("Значение для этого критерия уже есть!");
                    }
                    break;
                case (2):
                    if (!creteries.containsKey("cpu")){
                        creteries.put("cpu", reader.readLine());
                    } else {
                        System.out.println("Значение для этого критерия уже есть!");
                    }
                    break;

                case (3):
                    if (!creteries.containsKey("ram_value")){
                        creteries.put("ram_value", reader.readLine());
                    } else {
                        System.out.println("Значение для этого критерия уже есть!");
                    }
                    break;

                case (4):
                    if (!creteries.containsKey("disk_size")){
                        creteries.put("disk_size", reader.readLine());
                    } else {
                        System.out.println("Значение для этого критерия уже есть!");
                    }
                    break;

                case (5):
                    if (!creteries.containsKey("diagonal")){
                        creteries.put("diagonal", reader.readLine());
                    } else {
                        System.out.println("Значение для этого критерия уже есть!");
                    }
                    break;

                case (0):
                    break;

                default:
                    System.out.println("Неизвестный критерий");
                    break;
            }

        }

        return creteries;
    }
    private static Set<Laptops> getLaptops() {
        Laptops laptop1 = new Laptops("Zenbook 15", "Asus", "intel core i5 1235U", "Nvidia mx450", 16, "15", 512, "Windows 11", "silver");
        Laptops laptop2 = new Laptops("Vivobook 15", "Asus", "intel core i5 1235U", "Iris Xe Graphics", 8, "15", 512, "Windows 11", "black");
        Laptops laptop3 = new Laptops("ThinkPad 14", "Lenovo", "intel core i5 1135g7", "Iris Xe Graphics", 8, "14", 512, "DOS", "white");
        Laptops laptop4 = new Laptops("Probook 440 G9", "HP", "intel core i5 1240P", "Iris Xe Graphics", 8, "14", 240, "Windows 11", "silver");
        Laptops laptop5 = new Laptops("Nitro 5", "Acer", "intel core i5 1135H", "Nvidia RTX 3060", 16, "15", 1024, "DOS", "black");

        Set<Laptops> set = new HashSet<>();
        set.add(laptop1);
        set.add(laptop2);
        set.add(laptop3);
        set.add(laptop4);
        set.add(laptop5);
        return set;
    }
}
