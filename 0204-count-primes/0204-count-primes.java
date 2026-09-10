class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;

        int[] isprime = new int[n];
        int count = 0;

        for (int num = 2; num < n; num++) {

            if (isprime[num] == 0) {
                count++;

                // Only mark if num has a multiple below n
                if ((long) num * num < n) {

                    for (long multiple = (long) num * num;
                         multiple < n;
                         multiple += num) {

                        isprime[(int) multiple] = 1;
                    }
                }
            }
        }

        return count;
    }
}