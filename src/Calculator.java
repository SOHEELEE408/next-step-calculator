import java.util.Arrays;


public class Calculator {

    private String customSeperator;
    private int total;

    public int add(String input){

        if(input.isBlank())
            return 0;

        if(input.contains("//") && input.contains("\n")) {
            customSeperator = String.valueOf(input.charAt(2));
            input = input.substring(4);
        }

        Arrays.stream(input.split(",")).forEach(s -> {
            Arrays.stream(s.split(":")).forEach(ss -> {
                if(customSeperator != null)
                    total += Arrays.stream(ss.split(customSeperator)).mapToInt(value -> {
                        int intValue = Integer.parseInt(value);

                        if(intValue < 0) throw new IllegalArgumentException();

                        return intValue;
                    }).sum();
                else {
                    int intValue = Integer.parseInt(ss);

                    if(intValue < 0) throw new IllegalArgumentException();

                    total += intValue;
                }
            });
        });

        return total;
    }

}























/*

private List<Integer> inputss;


 */
