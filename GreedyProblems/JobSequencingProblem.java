import java.util.Arrays;

// Problem Statement: You are given a set of N jobs where each job comes with a
//  deadline and profit. The profit can only be earned upon completing the job within its 
// deadline. Find the number of jobs done and the maximum profit that can be obtained.
//  Each job takes a single unit of time and only one job can be performed at a time.

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class JobSequencingProblem {
    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);

        solve ob = new solve();

        // function call
        int[] res = ob.JobScheduling(arr, 4);
        System.out.println(res[0] + " " + res[1]);
    }
}

class solve{

    public int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr,(a,b)->(b.profit - a.profit));
        int maxi = 0;
        // find the max deadline
        for(int i =0;i<n;i++){
            if(arr[i].deadline > maxi){
                maxi = arr[i].deadline;
            }
        }
        // create a new array and fill -1 in it
        int [] result = new int[maxi+1];
        for(int i=1;i<=maxi;i++){
            result[i] = -1;
        }
        int countJobs =0, jobProfit =0;
        for(int i=0;i<n;i++){
            // we already sorted in decreasing order of deadline
            for(int j = arr[i].deadline;j>0;j--){
                // Free slot found
                if(result[j] == -1){
                    // if not occupied then occupy it with i
                    result[j] = i;
                    // increment countjobs
                    countJobs++;
                    // calculate the max profit
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        // for storing total number of jobs performed and their total profit
        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;
    }
    
}