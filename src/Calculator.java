import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {

    private String customSeperator;
    private int total;

    public int add(String input){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if(input.isBlank() || input == null)
            return 0;


        if(m.find()) {
            customSeperator = m.group(1);
            input = m.group(2);
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

    public void reset(){
        this.total = 0;
        this.customSeperator = null;
    }
}