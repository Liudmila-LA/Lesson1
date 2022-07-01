package Lesson7;

public class Car {
    double price;

    Car(double price){
       this.price = price;
    }
    public boolean printPrice() {
        if (this.price < 0) {
            System.out.println("Неизвестна мне");
            return false;
        } else {
            System.out.printf("%.2f %n", this.price);
            return true;
        }
    }
}

