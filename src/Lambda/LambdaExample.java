package Lambda;

public class LambdaExample {
    public static void main(String[] args) {
        MyInterface myInterface = text -> System.out.println(text);
        myInterface.printIt("Hello Lambda");
    }
}
