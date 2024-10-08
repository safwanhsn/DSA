package Demo;

public class Main {
    public static void main(String[] args) {
        Bag myBag = new Bag();
        myBag.add("Hi");
        myBag.add("Hi");
        myBag.add("Bye");
        System.out.println(myBag.find("Hi"));
        myBag.showAll();
        myBag.remove("Hi");
        System.out.println(myBag.find("Hi"));
        myBag.showAll();
    }
}
