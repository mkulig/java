//package pl.krakow.up.s138049;

public class Horse {
    private String name;
    private String breed;
    private int age;
    private float price;
    private int birthDay;

    @Override
    public String toString() {
        return "Hours(name: " + name + ", breed: " + breed + ", age: " + age + ", price: " + price + " EUR, year: " + birthDay + ")";
    }

    public Horse(String name, String breed, int age, float price) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.price = price;
        this.birthDay = 2019 - this.age;
    }

    public void setHorseName(String name) {
        this.name = name;
    }
    public void setHorseBreed(String breed) {
        this.breed = breed;
    }
    public void setHorseAge(int age) {
        this.age = age;
    }
    public void setHorsePrice(float price) {
        this.price = price;
    }

    @Override
    public Horse clone() throws CloneNotSupportedException {
        return (Horse) super.clone();
    }

    public String getHorseName() {
        return this.name;
    }
    public String getHorseBreed() {
        return this.breed;
    }
    public float getHorsePrice() {
        return this.price;
    }
    public int getHorseAge() {
        return this.age;
    }
    public int getHorseYear() {
        return 2019 - age;
    }
}
