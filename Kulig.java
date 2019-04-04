import java.text.SimpleDateFormat;
import java.util.*;
//Declaration package
//package pl.krakow.up.s138049;
/*Homework Class: Introduction to JAVA language*/
public class Kulig  implements Comparable<Kulig>, Cloneable {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static List<Kulig> tab = new ArrayList<Kulig>();

    private int id;
    private Date created;
    private String driver;
    private String eventDay;
    private String description;
    private Horse horse;
    private static int countEvent = 0;

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public String toString() {
        SimpleDateFormat aa = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return "Kulig(" + "ID: " + id + ",Created: " + aa.format(created) + ",Description: " + description + ",Driver: " + driver + ",Day: " + eventDay + "  Hourse: " + horse + ")";
    }

    @Override
    public int compareTo(Kulig k) {
        if(this.driver.compareTo(k.driver) > 0)
            return 1;
        if(this.driver.compareTo(k.driver) < 0)
            return -1;
        else
        {
            if(this.getHorseName().compareTo(k.getHorseName()) > 0)
                return 1;
            if (this.getHorseName().compareTo(k.getHorseName()) < 0)
                return -1;
        }
        return 0;
    }

    public Kulig() {
        this.id = getCountEvent();
        this.created = new Date();
        this.driver = "None";
        this.eventDay = "20.03.2019";
        this.description = "somethings";
        this.horse = new Horse("Kasztan", "Standardbred", 4, 8200);
        setCountEvent();
    }

    public Kulig(String driver, String eventDay, String description) {
        this.id = getCountEvent();
        this.created = new Date();
        this.driver = driver;
        this.eventDay = eventDay;
        this.description = description;
        this.horse = new Horse("Kasztan", "Standardbred", 7, 8200);
        setCountEvent();
    }

    public Kulig(String driver, String eventDay, String description, String nameOfHorse, String breedOfHorse, int ageOfHorse, float priceOfHorse) {
        this.id = getCountEvent();
        this.created = new Date();
        this.driver = driver;
        this.eventDay = eventDay;
        this.description = description;
        this.horse = new Horse(nameOfHorse, breedOfHorse, ageOfHorse, priceOfHorse);
        setCountEvent();
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    private int getId() {
        return this.id;
    }

    public String getDriver() {
        return this.driver;
    }

    public String getDayEvent() {
        return this.eventDay;
    }

    public String getHorseName() {
        return horse.getHorseName();
    }

    public static int getCountEvent() {
        return countEvent;
    }

    private void setCountEvent() {
        this.id = Kulig.countEvent++;
    }

    private void setDescription(String desc) {
        this.description = desc;
    }

    private void setDayEvent(String eventDay) {
        this.eventDay = eventDay;
    }

    private void setHorse(String name, String breed, int age, float price) {
        horse.setHorseName(name);
        horse.setHorseAge(age);
        horse.setHorsePrice(price);
        horse.setHorseBreed(breed);
    }

    public static final Comparator<Kulig> BY_NAME = new ByName();
    private static class ByName implements Comparator<Kulig> {
        @Override
        public int compare(Kulig v, Kulig w){
            // v.name is a String, and a String object is Comparable
            return v.getDriver().compareTo(w.getDriver());
        }
    }


    public static void main(String[] args) throws CloneNotSupportedException {
       //test
        tab.add(new Kulig("b", "20.11.2001", "dlugie cos","d","normalsbreed", 10, 1));
        tab.add(new Kulig("x", "20.11.2001", "dlugie cos","c","normalsbreed", 1, 20));
        tab.add(new Kulig("x", "20.11.2001", "dlugie cos","b","normalsbreed", 2, 202));
        tab.add(new Kulig("a", "20.11.2001", "dlugie cos","a","normalsbreed", 10, 72));
        tab.add((Kulig)tab.get(0).clone());
        //test
        System.out.println(CYAN + "\t\tWelcome in my aps!" + RESET);
        for (; ; ) {

            Collections.sort(tab);
            System.out.println(YELLOW + "\t\t\tMENU" + RESET);
            System.out.println(BLUE + "1." + GREEN + " Show all event" + RESET);
            System.out.println(BLUE + "2." + GREEN + " Create new event" + RESET);
            System.out.println(BLUE + "3." + GREEN + " Remove event" + RESET);
            System.out.println(BLUE + "4." + GREEN + " Modify event" + RESET);
            System.out.println(BLUE + "5." + GREEN + " Exit" + RESET);

            Scanner var = new Scanner(System.in);
            try {
                System.out.print(PURPLE + "Your choose: ");
                int choose = var.nextInt();
                switch (choose) {
                    case 1:
                        showAll();
                        break;
                    case 2:
                        createEvent();
                        break;
                    case 3:
                        removeEvent();
                        break;
                    case 4:
                        modifyEvent();
                        break;
                    case 5:
                        System.out.println(BLUE + "\n\t\tSee you soon!" + RESET);
                        System.exit(0);
                    default:
                        cellpic();
                        System.out.println(RED + "Wrong number option!" + RESET);
                        cellpic();
                }
            } catch (InputMismatchException e) {
                cellpic();
                System.out.println(RED + "Wrong format variable! Only numbers!");
                cellpic();
            }


        }

    }


    private static void modifyEvent() {
        showAll();
        if (tab.size() > 0) {
            System.out.print(PURPLE + "ID event to modify: " + RESET);
            Scanner scan = new Scanner(System.in);
            int id = scan.nextInt();
            int temp = -1;
            cellpic();
            loop:
            for (Kulig i : tab) {
                if (i.id == id) {
                    temp = tab.indexOf(i);
                    System.out.println(YELLOW + "\t\tMENU MODIFY" + RESET);
                    System.out.println(BLUE + "1." + GREEN + " Modify all" + RESET);
                    System.out.println(BLUE + "2." + GREEN + " Modify name driver" + RESET);
                    System.out.println(BLUE + "3." + GREEN + " Modify event day" + RESET);
                    System.out.println(BLUE + "4." + GREEN + " Modify description" + RESET);
                    System.out.println(BLUE + "5." + GREEN + " Modify horse" + RESET);
                    System.out.println(BLUE + "6." + GREEN + " Back to main menu" + RESET);
                    System.out.print(PURPLE + "Your choose: ");
                    int choose = scan.nextInt();
                    Scanner aa = new Scanner(System.in);
                    cellpic();
                    switch (choose) {
                        case 1:
                            System.out.print(PURPLE + "Driver name: " + RESET);
                            String name = aa.nextLine();
                            System.out.print(PURPLE + "Day event (mm/dd/yyyy): " + RESET);
                            String eventDay = aa.nextLine();
                            System.out.print(PURPLE + "Description: " + RESET);
                            String desc = aa.nextLine();
                            cellpic();
                            System.out.print(PURPLE + "Horse name: " + RESET);
                            String horseName = aa.nextLine();
                            System.out.print(PURPLE + "Horse breed: " + RESET);
                            String horseBreed = aa.nextLine();
                            System.out.print(PURPLE + "Horse age: " + RESET);
                            int horseAge = aa.nextInt();
                            System.out.print(PURPLE + "Horse price: " + RESET);
                            float horsePrice = aa.nextFloat();
                            tab.get(temp).setDriver(name);
                            tab.get(temp).setDayEvent(eventDay);
                            tab.get(temp).setDescription(desc);
                            tab.get(temp).setHorse(horseName, horseBreed, horseAge, horsePrice);
                            break;
                        case 2:
                            System.out.print(PURPLE + "Driver name: " + RESET);
                            String nameDrive = aa.nextLine();
                            tab.get(temp).setDriver(nameDrive);
                            break;
                        case 3:
                            System.out.print(PURPLE + "Event day: " + RESET);
                            String dayEvent = aa.nextLine();
                            tab.get(temp).setDayEvent(dayEvent);
                            break;
                        case 4:
                            System.out.print(PURPLE + "Description: " + RESET);
                            String description = aa.nextLine();
                            tab.get(temp).setDescription(description);
                            break;
                        case 5:
                            System.out.print(PURPLE + "Horse name: " + RESET);
                            String horseN = aa.nextLine();
                            System.out.print(PURPLE + "Horse breed: " + RESET);
                            String horseB = aa.nextLine();
                            System.out.print(PURPLE + "Horse age: " + RESET);
                            int horseA = aa.nextInt();
                            System.out.print(PURPLE + "Horse price: " + RESET);
                            float horseP = aa.nextFloat();
                            tab.get(temp).setHorse(horseN, horseB, horseA, horseP);
                        case 6:
                            break loop;
                        default:
                            cellpic();
                            System.out.println(RED + "Wrong number option!" + RESET);
                            cellpic();
                    }
                }
            }
            if (temp < 0)
                System.out.println(RED + "No ID event on list." + RESET);
            cellpic();
        }
    }

    private static void removeEvent() {
        showAll();
        if (tab.size() > 0) {
            System.out.print(PURPLE + "ID event to remove: " + RESET);
            Scanner scan = new Scanner(System.in);
            int id = scan.nextInt();
            int temp = -1;
            for (Kulig i : tab)
                if (i.id == id)
                    temp = tab.indexOf(i);
            if (temp >= 0)
                try {
                    tab.remove(temp);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(RED + "ID is not found.");
                }
            else
                System.out.println(RED + "No events on list." + RESET);
            cellpic();
        }


    }

    private static void createEvent() {
        cellpic();
        System.out.print(PURPLE + "Driver name: " + RESET);
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.print(PURPLE + "Day event (mm/dd/yyyy): " + RESET);
        String eventDay = scan.nextLine();
        System.out.print(PURPLE + "Description: " + RESET);
        String desc = scan.nextLine();
        cellpic();
        System.out.print(PURPLE + "Horse name: " + RESET);
        String horseName = scan.nextLine();
        System.out.print(PURPLE + "Horse breed: " + RESET);
        String horseBreed = scan.nextLine();
        System.out.print(PURPLE + "Horse age: " + RESET);
        int horseAge = scan.nextInt();
        System.out.print(PURPLE + "Horse price: " + RESET);
        float horsePrice = scan.nextFloat();
        tab.add(new Kulig(name, eventDay, desc, horseName, horseBreed, horseAge, horsePrice));
        cellpic();
    }

    private static void showAll() {
        cellpicLong();
        if (tab.size() > 0) {
            SimpleDateFormat date = new SimpleDateFormat("dd/MM hh:mm:ss");
            System.out.println(YELLOW + "List of events (" + tab.size() + " events)");
            System.out.println(GREEN + "ID\t\tCREATED\t\t\t\tDRIVER\t\t\tDESCRIPTION\t\t\t\tDAY\t\t\t\t\t\tHORSE NAME\t\tBREED\t\t\t\tAGE\t\tPRICE\t\t\tYEAR");
            for (Kulig i : tab)
                System.out.println(BLUE + i.id + "\t\t" + date.format(i.created) + "\t\t" + i.driver + "\t\t\t" + i.description + "\t\t\t\t" + i.eventDay + "\t\t\t\t" +
                        i.horse.getHorseName() + "\t\t\t" + i.horse.getHorseBreed() + "\t\t" + i.horse.getHorseAge() + "\t\t" + i.horse.getHorsePrice() + " EUR\t\t" + i.horse.getHorseYear() + RESET);
        } else
            System.out.println(RED + "No events on list." + RESET);
        cellpicLong();

    }

    private static void cellpic() {
        for (int i = 0; i < 5; i++)
            System.out.print(CYAN + "--------" + RESET);
        System.out.println();
    }

    private static void cellpicLong() {
        for (int i = 0; i < 20; i++)
            System.out.print(CYAN + "--------" + RESET);
        System.out.println();
    }
}
