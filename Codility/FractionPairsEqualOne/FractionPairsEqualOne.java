import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FractionPairsEqualOne {
    public static void main(String[] args) {
        FractionPairsEqualOne s = new FractionPairsEqualOne();

        int[] X = new int[]{1,1,2};
        int[] Y = new int[]{3,2,3};
        
        int res = s.countPairsEqOne(X, Y);
        System.out.println("test1:" + res);

        X = new int[]{1,1,1};
        Y = new int[]{2,2,2};
        res = s.countPairsEqOne(X, Y);
        System.out.println("test2:" + res);
    }

    public int countPairsEqOne(int[] X, int[] Y) {
        Map<String, Integer> map = new HashMap<>();
        int n = X.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            BigInteger xi = BigInteger.valueOf(X[i]);
            BigInteger yi = BigInteger.valueOf(Y[i]);
            BigInteger gcd = xi.gcd(yi);
            xi = xi.divide(gcd);
            yi = yi.divide(gcd);
            String key = xi + "/" + yi; 
            String pairKey = yi.subtract(xi) + "/" + yi; 
            if(map.containsKey(pairKey)){
                count += map.get(pairKey);
                count = count % (int)(Math.pow(10, 9) + 7);
            }

            int val = map.getOrDefault(key, 0);
            map.put(key, val+1);
        }
        return count;
    }
}

