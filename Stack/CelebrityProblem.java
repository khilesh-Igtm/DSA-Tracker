import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] Matrix = { { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 0 } };

        celebrity(Matrix);
    }

    private static void celebrity(int[][] matrix) {


        // Tc is O(n) and Sc is also O(n)
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<matrix.length;i++){
            st.push(i);
        }
        // jab tak stack me 2 ya 2 se elements honge to hum 2 elements ko pop karenge
        while(st.size()>=2){
            int i = st.pop();
            int j = st.pop();
            if(matrix[i][j]==1){
                // if i knows j , that means i is not a celebrity
                // so push back j
               st.push(j);
            }else{
                // if i doesn't know j means j is not a celebrity
                // so push back i  
                st.push(i);
            }
        }
        // aisa karte karte ,last me hamare pass 2 se kam elements bachenge stack me
        // aur ishe bhi bahar nikalo stack se and check kaor kya ye celebrity hai
        int pot = st.pop();
        // iske liye hum is element ke row and col check karnege
        for(int i=0;i<matrix.length;i++){
            // like (2,2) , (1,1), (3,3) ko check nahi karna kyuki ek celebrity khud ko janta
            // hai isliye is part ko skip karenge and next index ko check karenge
            if(i != pot){
                // means agr koi person ek element ko nahi janta ya phir ye element kishi person
                // ko janta hai , too ye celebrity nahi ho sakta
                if(matrix[i][pot] ==0 || matrix[pot][i]==1){
                    System.out.println("Not a celebrity");
                    return;

                }

            }
        }
        System.out.println(pot);
    }
}
