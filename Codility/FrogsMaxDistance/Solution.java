import java.util.HashMap;

public class FrogsMaxDistance {

    public static void main(String[] args) {
        FrogsMaxDistance s = new FrogsMaxDistance();
        System.out.println(s.solution(new int[] { 1, 1, 1, 1, 2, 3, 2, 1, 0 }));
        System.out.println(s.solution(new int[] { 3, 2, 1 }));
        System.out.println(s.solution(new int[] { 5, 5, 4, 3, 2}));
        System.out.println(s.solution(new int[] { 1, 2, 3, 3, 2, 1, 2, 2, 3, 3, 2, 1 }));
    }

    public int solution(int[] blocks) {
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

    
}
// Example test: [2, 6, 8, 5]
// OK

// Example test: [1, 5, 5, 2, 6]
// OK

// Example test: [1, 1]
// OK
