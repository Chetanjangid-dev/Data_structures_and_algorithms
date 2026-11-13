
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int[] ans = new int[queries.length];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            if (map.containsKey(queries[i])) {
                map.get(queries[i]).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(queries[i], temp);
            }
        }

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(queries);

        int first = 0;
        int second = 0;

        // Frequency map outside the loop
        HashMap<Integer, Integer> mapu = new HashMap<>();

        for (int query : queries) {

            int start = query - x;
            int end = query;

            while (second < logs.length && logs[second][1] <= end) {

                int id = logs[second][0];

                mapu.put(id, mapu.getOrDefault(id, 0) + 1);

                second++;
            }

            while (first < second && logs[first][1] < start) {

                int id = logs[first][0];

                if (mapu.get(id) == 1) {
                    mapu.remove(id);
                } else {
                    mapu.put(id, mapu.get(id) - 1);
                }

                first++;
            }

            int count = n - mapu.size();

            for (int j : map.get(query)) {
                ans[j] = count;
            }
        }

        return ans;
    }
}
