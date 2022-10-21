import java.util.Arrays;
import java.util.Comparator;

class Item{
    int value , weight;
    Item(int x , int y){
        this.value = x;
        this.weight =y;
    }
}

class itemComparator implements Comparator<Item>{
    public int compare(Item a , Item b){
        // getting on decreasing order of value/weight.
        double r1 = (double)(a.value)/(double)(a.weight);
        double r2 = (double)(b.value)/(double)(b.weight);
        if(r1<r2) return 1;
        else if(r1 > r2) return -1;
        else return 0;
    }
}



public class FractionalKnapSack {
    public static void main(String[] args) {
        int n = 3, weight = 50;
        Item arr[] = { new Item(100, 20), new Item(60, 10), new Item(120, 30) };
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is " + ans);
    }

    private static double fractionalKnapsack(int W, Item[] arr, int n) {
        // sorted in decreasing order of ratio
        Arrays.sort(arr,new itemComparator());
        // current answer
        int curWeight = 0;
        // final answer
        double finalValue = 0.0;
        for(int i=0;i<n;i++){
            if(curWeight + arr[i].weight <=W){
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            }
            else{
                // getting the fraction of the value to add up and get max profit
                int remain = W - curWeight;
                finalValue += ((double)arr[i].value/(double)arr[i].weight) *(double) remain;
                break;
            }
        }
        return finalValue;
    }
}
