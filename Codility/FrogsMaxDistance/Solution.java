import java.util.HashMap;

public class Question2 {

    public static void main(String[] args) {
        Question2 s = new Question2();
        System.out.println(s.solution2(new int[] { 1, 1, 1, 1, 2, 3, 2, 1, 0 }));
        System.out.println(s.solution2(new int[] { 3, 2, 1 }));
        System.out.println(s.solution2(new int[] { 5, 5, 4, 3, 2}));
        System.out.println(s.solution2(new int[] { 1, 2, 3, 3, 2, 1, 2, 2, 3, 3, 2, 1 }));
    }

    public int solution2(int[] blocks) {
        int leftTop = 0;
        int leftCur = 0;
        int maxDist = 0;
        for (int i = 1; i < blocks.length; i++) {
            int dist = 0;
            if (blocks[i - 1] < blocks[i]) {
                leftTop = i;
            } else if(blocks[i - 1] == blocks[i]){

            } else {
                leftCur = leftTop;
            }
            dist = i - leftCur;
            maxDist = Math.max(maxDist, dist);
        }

        return maxDist;
    }

    public int solution(int[] blocks) {
        // write your code in Java SE 8
        int leftTopi = 0;
        int rightTopi = 0;
        int leftTopiLast = 0;
        int maxDist = 0;

        for (int i = 1; i < blocks.length; i++) {
            // Increscing
            if (blocks[i - 1] < blocks[i]) {
                rightTopi = i;
                leftTopiLast = i;
            }
            // Equal
            else if (blocks[i - 1] == blocks[i]) {
                rightTopi = i;
            }
            // Decreasing
            else {
                leftTopi = leftTopiLast;
            }

            maxDist = Math.max(maxDist, i - leftTopiLast);
        }

        return maxDist + 1;
    }
}
// Example test: [2, 6, 8, 5]
// OK

// Example test: [1, 5, 5, 2, 6]
// OK

// Example test: [1, 1]
// OK
