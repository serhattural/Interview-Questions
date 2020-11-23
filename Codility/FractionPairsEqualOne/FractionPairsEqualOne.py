class Solution(object):
    def gcd(self, a, b):
        if b == 0:
            return a
        else:
            return self.gcd(b, (a % b))
        
    def countPairsEqOne(self, X, Y):
        maxCountValue = (pow(10,9) + 7)
        mapFr = {}
        n = len(X)
        count = 0
        for i in range(n):
            xi = X[i]
            yi = Y[i]
            gcdXY = self.gcd(xi, yi)
            xi = xi/gcdXY
            yi = yi/gcdXY
            key = "{}/{}".format(xi, yi)
            pairkey = "{}/{}".format(yi-xi, yi)
            if pairkey in mapFr:
                count += mapFr[pairkey]
                count = count % maxCountValue
                
            mapFr[key] = mapFr.get(key, 0) + 1
        
        return count

s = Solution()
X = [1,1,2];
Y = [3,2,3];
print("test1: ", s.countPairsEqOne(X, Y))
X = [1,1,1];
Y = [2,2,2];
print("test2: ", s.countPairsEqOne(X, Y))
