import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Calculator {
    private Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public int add(String input){
        if(isBlank(input)) return 0;

        return sum(toIntegers(split(input)));
    }

    private boolean isBlank(String input){
        if(input.isBlank() || input == null)
            return true;

        return false;
    }
    
    private List<Integer> toIntegers(String[] values){
        return Arrays.stream(values).map(value -> toPositive(value)).collect(Collectors.toList());
    }

    private Integer toPositive(String value){
        int n = Integer.parseInt(value);
        if(n < 0) throw new IllegalArgumentException();

        return n;
    }

    private String[] split(String input) {
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()) {
            String customSeparater = Pattern.quote(matcher.group(1));
            return matcher.group(2).split(",|:|" + customSeparater);
        }

        return input.split(",|:");
    }

    private int sum(List<Integer> nums){
        int total = 0;

        for(Integer num : nums){
            total += num;
        }

        return total;
    }
}