package Lesson3;

public class EasyPart4Base {
    public static void main(String[] args) {
        EasyPart4Squirrel firstAnimalSquirrel = new EasyPart4Squirrel("Машка 001", 1);
        EasyPart4Lion secondAnimalLion = new EasyPart4Lion();

        secondAnimalLion.setName("Lion king");
        secondAnimalLion.setTailLength(78);

        System.out.println(secondAnimalLion.getName());
    }

}
