package Lesson3;

public class EasyPart3 {
    public static void main(String[] args) {
        boolean chicken = false;
        boolean vegetables = true;
        boolean sour = false;
        boolean toast = true;
        boolean sausage = true;
        boolean eggs = false;

        if (vegetables) { // овощи нужны для любого из 3 салатов
            if (chicken && sour && toast) {
                System.out.println("Цезарь");
            } else if (eggs && (chicken || sausage)) {
                System.out.println("Оливье");
            } else {
                System.out.println("Овощной");
            }
        } else {
            System.out.println("У меня ничего нет");
        }
        //по условию не совсем понятно - выводить эту строку когда у повора вообще ничего нет
        //или когда у него не хватает ингридиентов хотя бы на один салат. Но пусть будет так, не будем усложнять.

    }
}

