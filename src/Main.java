public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int total = calculator.add("1:2,-3");

        System.out.println(total);
    }
}
