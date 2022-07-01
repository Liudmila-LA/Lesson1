package Lesson7;

public class CarShop {

//    public CarShop(Car car){
//        this.car = car;
//    }

    public void sellCar(Car car){

        System.out.println("Здравствуй клиент, цена этого авто");
        boolean result = car.printPrice();
        if (result){
            System.out.println("Хочешь купить авто?");
        }else {
            System.out.println("Давайте посмотрим другое авто?");
        }
    }

}
