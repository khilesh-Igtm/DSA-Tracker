class RepeatedStringMatch{
    public static void main(String[]args){
        String a = "a";
        String b = "aa";
        matchstring(a,b);
    }

    // 1st Approach

    // private static int matchstring(String A, String B){
    //     // creating a stringbuilder for storing A and stored A here
    //     StringBuilder sb = new StringBuilder(A);
    //     int i =1;
    //     // Add in A until it is less than B
    //     while(sb.length()<B.length()){
    //         i++;
    //         sb.append(A);
    //     }
    //     // now check after adding in A , b is substring of A or not
    //     if(sb.indexOf(B)!=-1){
    //         return i;
    //     }
    //     // else add one more time
    //     sb.append(A);
    //     i++;
    //     // check after appended B is substring of A or not 
    //     // if yes then return i else return -1
    //     return sb.indexOf(B) != -1 ?i: -1;
    // }


    private static int matchstring(String a, String b) {
        String duplicate = a;
        int answer = 1;
        while(a.length()<b.length()){
            // if a length is smaller than b , then add append a string to a to make it's size
            // comparable with b or greater
            a = a+duplicate;
            // and the moment we increase the size , increment our answer by 1
            answer++;
        }
        if(check(a,b)){
            // b is not present in string a so there is posssibility that a+duplicate will have it
            return answer;
        }
        if(check(a+duplicate,b)){
            // if a+duplicate has the substring b then we increment answer+1 as we have added a duplicate
            return answer+1;

        }
        return -1;
    }

    private static boolean check(String a, String b) {
        int n = a.length(), m = b.length();
        for(int i=0;i<=n-m;i++){
            // n-m is done to prevent IndexOutOfBoundsException
            int j ;
            for(j=0;j<m;j++){
                // i+j because we have duplicated the a and we want to check from every 
                // substring that is not equal to b  string. So we break this j loop and
                // start from next i index.
                if(a.charAt(i+j) != b.charAt(j)){
                    
        // For current index i,
        // check for pattern match
                    break;
                }
            }
            if(j==m){
                //means that we have successfully moved through all the length of b
                // i.e b is present in a
                return true;
            }

        }
        return false;
    }

}