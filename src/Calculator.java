import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Calculator {
    private Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public int add(String input){
        if(isBlank(input)) return 0;

        List<Integer> nums = getNums(input);

        int total = 0;
        for(Integer num : nums){
            total += num;
        }

        return total;
    }

    private boolean isBlank(String input){
        if(input.isBlank() || input == null)
            return true;

        return false;
    }

    private List<Integer> getNums(String input){
        List<String> datas = getSeperatorRegexAndNums(input);

        return Arrays.stream(datas.get(1).split(datas.get(0)))
                .map(value -> {
                    int n = Integer.parseInt(value);
                    checkNegative(n);
                    return n;
                }).collect(Collectors.toList());
    }

    private List<String> getSeperatorRegexAndNums(String input){
        Matcher matcher = pattern.matcher(input);
        if(matcher.find())
            return List.of(",|:|" + Pattern.quote(matcher.group(1)), matcher.group(2));

        return List.of(",|:", input);
    }

    private void checkNegative(int value){
        if(value < 0) throw new IllegalArgumentException();
    }
}