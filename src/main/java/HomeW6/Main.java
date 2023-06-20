
import HomeW6.Color;
        import HomeW6.FilterLaptop;
        import HomeW6.Laptop;
        import HomeW6.Manufacturer;

        import java.util.HashSet;
        import java.util.Scanner;
        import java.util.Set;

public class Main {

    public static void main(String[] args) {
//         Итоговая работа
/**Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
 *  Реализовать в java.
 Создать множество ноутбуков (Set).
 Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
 и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map или в Сет. Например:
 “Введите цифру, соответствующую необходимому критерию:
 1 - цвет
 2 - бренд**/
        Scanner in = new Scanner(System.in);
        Set<Laptop> laptops = new HashSet<>();
        System.out.println("Обновился ассортимент. Выберите  количество новых товаров");
        int pullLaptop = in.nextInt();
        for (int i = 0; i < pullLaptop ; i++) {
            laptops.add(new Laptop(Color.generateRandomColor(),Manufacturer.generateRandomManufacture()));
        }
        System.out.println(laptops);
        System.out.println("Выберите пункт:");
       System.out.println("1 - Вывод всего каталога");
        System.out.println("2 - Фильтрация по цветам");
        System.out.println("3 - Фильтрация по производителю");
        int parametrFilter = in.nextInt();
        in.nextLine();
        switch (parametrFilter) {
            case 1:
                FilterLaptop.fullLaptop(laptops);
                break;
            case 2:
                System.out.println("Введите цвет для фильтрации");
                String parametrColor = in.nextLine();
                laptops = FilterLaptop.filterColor(laptops,parametrColor);
                break;
            case 3:
                System.out.println("Введите производителя фильтрации");
                String parametrManufactures = in.nextLine();
                laptops = FilterLaptop.filterManufacturer(laptops,parametrManufactures);
                break;
            default:
                System.out.println("Такого пункта нет");
                break;
        }
        System.out.println("Результаты фильтрации:");
        if (laptops.isEmpty()) {
            System.out.println("Ошибка,не найдено");
        }
        else {
            for (Laptop lp:laptops) {
                System.out.println(lp);
            }
        }



    }
}
