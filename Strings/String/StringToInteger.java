// Conditions :
// If we look at 1st testcase. We have Given a string with numerical values & we will simply
//  return in Integral value and return 42. If we look at 2nd testcase. First we see we have 
//  some space "and it's clearly mentioned in question, we need to discard whitespace", then we
// takecare of sign & use sign as it is & finally use numerical value return -42. If we look 
// at 3rd testcase. We look for whitespace, but we dont have it. Then we will see wether it
// have a sign or not. Then we will see wether the 1st value numerical or not. So, we found it
// is and simply go for 4193, again we will check after this numerical value do we have more 
// numerical value & states No. then we simply return 4193 Coming to 4th testcase. We see that
// it dont have whitespace, dont have any sign. And very first sequence is non-numerical and 
// simply return 0 Coming to 5th testcase. We clearly see that no is out of range, we simply 
// return -2^31.

// Tc is O(n) and Sc is O(1)

public class StringToInteger {
    public static void main(String[] args) {
        String s = "45";
        atoi(s);
    }

    private static int atoi(String s) {
        if (s.equals(""))
            return 0;
        // helper variables
        int result = 0, i = 0, sign = 1;
        // get rid of whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        // check for sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            // change if negative, iterate
            if (s.charAt(i++) == '-') {
                sign = -1;
            }
        }
        // now iterate across digits if any should only be in range 0-9
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            // check if we will go over the max
            // if our digit is greater than int maximum  value/10 , or if our digit is greater
            // than int maximum value/10 and
            // the last digit is greater than 7 then we need to return integer max or mini
            // value depending upon the sign
            // we consider 7 because 7 is the last digit of integer max value and any digit
            // before 7 will not happen int overflow

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {

                if (sign == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            // update result '42' -> 4*10 + 2 like digit sum problem logic
            // we subtract 0 because we don't know the ascii value of i index charcater
            // so we subtract the smallest possible number and get that number in integer
            // format.
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return sign * result;
    }
}
