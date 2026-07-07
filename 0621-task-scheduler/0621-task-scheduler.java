class Solution {
    public int leastInterval(char[] tasks, int n) {
      
        HashMap<Character, Integer> freq = new HashMap<>();

        int max = 0;
        int countofmax = 0;

        for (int i = 0; i < tasks.length; i++) {
            if (freq.containsKey(tasks[i])) {
                freq.put(tasks[i], freq.get(tasks[i]) + 1);
            } else {
                freq.put(tasks[i], 1);
            }

            max = Math.max(max, freq.get(tasks[i]));
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == max) {
                countofmax++;
            }
        }
    return Math.max(tasks.length,(max-1)*(n+1)+countofmax);
    }
}