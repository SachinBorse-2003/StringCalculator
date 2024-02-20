import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static String add(String numbers) {
        if (numbers.isEmpty()) {
            return "0";
        }

        String delimiter = ",|\n"; // Default delimiters
        String numsPart = numbers;

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf('\n');
            if (delimiterEndIndex != -1) {
                delimiter = Pattern.quote(numbers.substring(2, delimiterEndIndex));
                numsPart = numbers.substring(delimiterEndIndex + 1);
            }
        }

        // Split numbers based on delimiter(s)
        String[] nums = numsPart.split(delimiter);

        // Error handling
        List<String> errors = new ArrayList<>();
        List<Double> negativeNumbers = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            String num = nums[i].trim();
            if (num.isEmpty()) {
                if (i == nums.length - 1) {
                    errors.add("Number expected but EOF found.");
                } else {
                    errors.add(String.format("Number expected but ',' found at position %d.", numsPart.indexOf(",,") + 1));
                }
                continue;
            }

            try {
                double value = Double.parseDouble(num);
                if (value < 0) {
                    negativeNumbers.add(value);
                } else {
                    sum += value;
                }
            } catch (NumberFormatException e) {
                errors.add(String.format("Invalid number: '%s' at position %d.", num, numsPart.indexOf(num)));
            }
        }

        // Negative number error
        if (!negativeNumbers.isEmpty()) {
            errors.add("Negative not allowed : " + negativeNumbers.toString());
        }

        // Compile all error messages or return sum
        if (!errors.isEmpty()) {
            return String.join("\n", errors);
        } else {
            return String.format("%.1f", sum);
        }
    }
    public static String multiply(String numbers) {
        if (numbers.isEmpty()) {
            return "0";
        }

        String delimiter = ",|\n"; // Default delimiters
        String numsPart = numbers;

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf('\n');
            if (delimiterEndIndex != -1) {
                delimiter = Pattern.quote(numbers.substring(2, delimiterEndIndex));
                numsPart = numbers.substring(delimiterEndIndex + 1);
            }
        }

        // Split numbers based on delimiter(s)
        String[] nums = numsPart.split(delimiter);

        // Error handling
        List<String> errors = new ArrayList<>();
        List<Double> negativeNumbers = new ArrayList<>();
        double product = 1; // Start multiplication with 1
        boolean hasValidNumbers = false; // Track if we have at least one valid number

        for (int i = 0; i < nums.length; i++) {
            String num = nums[i].trim();
            if (num.isEmpty()) {
                if (i == nums.length - 1) {
                    errors.add("Number expected but EOF found.");
                } else {
                    errors.add(String.format("Number expected but ',' found at position %d.", numsPart.indexOf(",,") + 1));
                }
                continue;
            }

            try {
                double value = Double.parseDouble(num);
                if (value < 0) {
                    negativeNumbers.add(value);
                } else {
                    product *= value;
                    hasValidNumbers = true;
                }
            } catch (NumberFormatException e) {
                errors.add(String.format("Invalid number: '%s' at position %d.", num, numsPart.indexOf(num)));
            }
        }

        // Negative number error
        if (!negativeNumbers.isEmpty()) {
            errors.add("Negative not allowed : " + negativeNumbers.toString());
        }

        // Compile all error messages or return product
        if (!errors.isEmpty()) {
            return String.join("\n", errors);
        } else {
            // If no valid numbers were found, return "0" to indicate no operation was performed
            return hasValidNumbers ? String.format("%.1f", product) : "0";
        }
    }

    public static void main(String[] args) {
        System.out.println(add("-1,,2"));
    }

}
