package Lesson7;

public class Human {
    private int age;
    private String name;
    private int weight;

    private Human(){

    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void outInfo(){
        System.out.printf("%s - возраст %d, вес %d. %n", this.name, this.age, this.weight);
    }
    static HumanBuilder builder(){
        return new HumanBuilder();
    }
    //@Override

    public static class HumanBuilder{
        private Human objectHuman;
        public  HumanBuilder(){
            this.objectHuman = new Human();
        }

        public Human build(){
            return this.objectHuman;
        }
        public HumanBuilder setAge(int age) {
            this.objectHuman.age = age;
            return this;
        }

        public HumanBuilder setName(String name) {
            this.objectHuman.name = name;
            return this;
        }

        public HumanBuilder setWeight(int weight) {
            this.objectHuman.weight = weight;
            return this;
        }


    }
}