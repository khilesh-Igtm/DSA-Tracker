// Given two version numbers, version1 and version2, compare them.
// Version numbers consist of one or more revisions joined by a dot '.'.
//  Each revision consists of digits and may contain leading zeros. Every
//  revision contains at least one character. 

// To compare version numbers, compare their revisions in left-to-right order.
//  Revisions are compared using their integer value ignoring any leading zeros.
//  This means that revisions 1 and 001 are considered equal. If a version number does 
// not specify a revision at an index, then treat the revision as 0. For example,
//  version 1.0 is less than version 1.1 because their revision 0s are the same, but
//  their revision 1s are 0 and 1 respectively, and 0 < 1.

// Return the following:
// If version1 < version2, return -1.
// If version1 > version2, return 1.
// Otherwise, return 0.

// Input: version1 = "1.01", version2 = "1.001"
// Output: 0
// Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1

// Input: version1 = "1.0", version2 = "1.0.0"
// Output: 0
// Explanation: version1 does not specify revision 2, which means it is treated as "0".

// Input: version1 = "0.1", version2 = "1.1"
// Output: -1
// Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
public class CompVersNum {
    public static void main(String[] args) {
        String  version1 = "1.1";
        String version2 = "1.1.1";
        System.out.println(version(version1,version2));
    }

    private static int version(String version1, String version2) {
        int len1 = version1.length(), len2 = version2.length();
        int i =0, j=0;
        while(i<len1 || j<len2){
            int temp1 =0;
            int temp2 =0;
            // checking till 1st '.' in version1 and version2 and then comparing
            // both the elements
            while(i<len1 && version1.charAt(i)!= '.'){
                temp1 = temp1*10 + version1.charAt(i++)-'0';
            }
            while(j<len2 && version2.charAt(j) != '.'){
                temp2 = temp2*10 + version2.charAt(j++)-'0';
            }
            if(temp1>temp2)return 1;
            else if(temp1<temp2) return -1;
            else{
                i++;
                j++;
            }
        }
        return 0;
    }
}
