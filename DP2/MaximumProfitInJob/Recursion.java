package MaximumProfitInJob;

import java.util.Arrays;

// TC : O(n * 2^n)
// SC : O(n)

class Job{
    public int start, end, profit;
    Job(int start,int end,int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}

public class Recursion {
    public static void main(String[] args) {
        int[] start = {1,2,3,3};
        int[] end = {3,4,5,6};
        int[] profit = {50,10,40,70};
        System.out.println(jobScheduling(start,end,profit));
    }

    private static int jobScheduling(int[] start, int[] end, int[] profit) {
        int n = start.length;
        Job[] jobs = new Job[n];
        for(int i=0;i<n;i++){
            jobs[i] = new Job(start[i], end[i], profit[i]);
        }
        // sort the array on the basis of starting interval as we have made an array
        // of Job type where each job consist of start,end ,profit.
        Arrays.sort(jobs,(j1,j2)->{
            return Integer.compare(j1.start, j2.start);
        });
        return recursiveUtil(jobs,0,n);


    }

    private static int recursiveUtil(Job[] jobs, int index, int n) {
        // base case
        if(index >= n) return 0;
        // if we take the starting index as in profit
        int include = jobs[index].profit;
        // get next non-conflicting job that we would pick
        int gncj = findIndexOfNonConflictingJob(jobs,index,n);
        // if next is not null then take it , here not null will happen
        // if the starting interval of next job is greater than the end interval of
        // current job
        if(gncj != -1){
            include += recursiveUtil(jobs, gncj, n);
        }
        // if we don't take 
        int exlude = recursiveUtil(jobs, index+1, n);
        return Math.max(include, exlude);
    }

    private static int findIndexOfNonConflictingJob(Job[] jobs, int index, int n) {
        for(int i = index+1;i<n;i++){
            if(jobs[i].start>=jobs[index].end){
                return i;
            }
        }
        return -1;
    }
}
