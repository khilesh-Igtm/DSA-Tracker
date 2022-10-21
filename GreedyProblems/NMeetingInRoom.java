import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class meeting {
    int start;
    int end;
    int pos;

    meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetingComparator implements Comparator<meeting> {
    public int compare(meeting o1, meeting o2) {
        // means already sorted don't do anything
        if (o1.end < o2.end)
            return -1;
        // reverse
        else if (o1.end > o2.end)
            return 1;
        // if both end are equal then compare their position
        else if (o1.pos < o2.pos)
            return -1;
        return 1;
    }
}

class NMeetingInRoom {
    public static void main(String[] args) {
        int n = 6;
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 5, 7, 9, 9 };
        maxMeetings(start, end, n);
    }

    private static void maxMeetings(int[] start, int[] end, int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            // adding all meeting to my arraylist
            meet.add(new meeting(start[i], end[i], i + 1));
        }
        // created a reference of meetingComparator
        meetingComparator mc = new meetingComparator();
        // sorting on the basis of their end intervals
        Collections.sort(meet, mc);
        // ans for storing my final answer
        ArrayList<Integer> ans = new ArrayList<>();
        // we just added our 1st interval bcz 1st interval will always happen
        ans.add(meet.get(0).pos);
        // end time of 1st interval is stored here and keeps updating
        int limit = meet.get(0).end;

        // starts checking the end interval of previous with start interval of
        // current and if condition satisfy
        // then add them to our final answer
        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                ans.add(meet.get(i).pos);
            }
        }
        // for printing the final answer
        System.out.println("The order in which the meetings will be performed is ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }
}