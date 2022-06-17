package Lesson3;

public class EasyPart4Squirrel {
        String idAnimal;
        int age;


    EasyPart4Squirrel(String idAnimalValue, int ageValue){
        this.idAnimal = idAnimalValue;
        this.age = ageValue;
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }
}
