import java.util.Arrays;
import java.util.regex.Pattern;


public class Calculator {

    private String customSeperator;
    private int total;

    public int add(String input){

        if(input.isBlank() || input == null)
            return 0;

        if(input.contains("//") && input.contains("\n")) {
            customSeperator = String.valueOf(input.charAt(2));
            input = input.substring(4);
        }

        Arrays.stream(input.split(",|:")).forEach(s -> {
            if(customSeperator != null)
                total += Arrays.stream(s.split(Pattern.quote(customSeperator))).mapToInt(value -> {
                    int intValue = Integer.parseInt(value);

                    if(intValue < 0) throw new IllegalArgumentException();

                    return intValue;
                }).sum();
            else {
                int intValue = Integer.parseInt(s);

                if(intValue < 0) throw new IllegalArgumentException();

                total += intValue;
            }
        });

        return total;
    }
}