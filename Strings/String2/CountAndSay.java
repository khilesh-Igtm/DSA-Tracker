// The first term is "1"

// Second term is "11", generated by reading first term as "One(frequency) 1(number itself)" 
// (There is one 1 in previous term)

// Third term is "21", generated by reading second term as "Two 1"

// Fourth term is "1211", generated by reading third term as "One 2 One 1" 

// and so on



class CountAndSay {
    public static void main(String[] args) {
        int n = 4;
        countAndSay(n);
    }
    // public static String countAndSay(int n) {
    // // Tc is O(n*result) and Sc is O(n)

    // // check the base case
    // if (n <= 0)
    // return null;

    // // it's given that "1" is count and said as 1
    // String result = "1";
    // int i = 1;

    // while (i < n) {
    // // mutable string storage
    // StringBuilder sb = new StringBuilder();
    // int count = 1;
    // for (int j = 1; j < result.length(); j++) {
    // if (result.charAt(j) == result.charAt(j - 1)) {
    // count++;
    // } else {
    // // add frequency and the number itself to the sb
    // sb.append(count);
    // sb.append(result.charAt(j - 1));
    // count = 1;
    // }
    // }

    // sb.append(count);
    // sb.append(result.charAt(result.length() - 1));
    // result = sb.toString();
    // i++;
    // }

    // return result;
    // }

    // Using Recursion

    private static String countAndSay(int n) {
        if (n == 1)
            return "1";
        // recursive call
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        // this is just for starting 
        char ch = '!';
        int frequency = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ch) {
                if (frequency > 0) {
                    sb.append(frequency);
                    sb.append(ch);
                }
                frequency = 0;
                ch = s.charAt(i);

            }
            frequency++;
            i++;
        }
        sb.append(frequency);
        sb.append(ch);
        return sb.toString();
    }
}