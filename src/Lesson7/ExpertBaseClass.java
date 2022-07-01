package Lesson7;

public class ExpertBaseClass {
    public static void main(String[] args) {
        Human human = Human.builder().setName("Петр").setAge(20).setWeight(80).build();
        human.outInfo();

        Car car = new Car(-555.4);
        CarShop newShop = new CarShop();
        newShop.sellCar(car);
    }
}