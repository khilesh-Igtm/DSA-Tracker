import java.util.ArrayList;
// import java.util.HashMap;

class MajorityElementby3{
    public static void main(String[] args) {
        int arr[] = {1,1,1, 2, 2,2,3, 3, 2};
        System.out.println(majorityelement(arr,5));
    }

    private static ArrayList<Integer> majorityelement(int[] arr, int n) {

        ////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////// Tc is O(n2) and Sc is O(1)
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     int count = 1;
        //     for(int j = i+1;j<n;j++){
        //         if(arr[j]==arr[i]) count++;
        //     }
        //     // if it is already present then don't add bcz we don't need duplicates there
        //     if(count>(n/3) && !ans.contains(arr[i]))
        //      ans.add(arr[i]);

        // }
        // return ans;


        // /////////////////////////////////////////////////////////////////////////////////////////////////
        /////// Tc is O(n) and Sc is O(1)

        // HashMap<Integer,Integer> map = new HashMap<>();
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(int i =0;i<n;i++){
        //     map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

        // }
        // for(int x : map.keySet()){
        //     if(map.get(x)>(n/3)){
        //         ans.add(x);
        //     }
        // }
        // return ans;

        //////////////////////////////////////////////////////////////////////////////////////////////////
        /////// Optimal (Moore's voting algo) Tc is O(n) and Sc is O(1)

        int number1 = -1, number2 = -1, count1 = 0, count2 = 0, len = arr.length;
    for (int i = 0; i < len; i++) {
      if (arr[i] == number1)
        count1++;
      else if (arr[i] == number2)
        count2++;
      else if (count1 == 0) {
        number1 = arr[i];
        count1 = 1;
      } else if (count2 == 0) {
        number2 = arr[i];
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    ArrayList < Integer > ans = new ArrayList < Integer > ();
    count1 = 0;
    count2 = 0;
    for (int i = 0; i < len; i++) {
      if (arr[i] == number1)
        count1++;
      else if (arr[i] == number2)
        count2++;
    }
    if (count1 > len / 3)
      ans.add(number1);
    if (count2 > len / 3)
      ans.add(number2);
    return ans;
    }
}