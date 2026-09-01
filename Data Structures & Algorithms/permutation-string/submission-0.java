class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Frequency of characters in s1
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);

            // Add current character
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            // Keep window size equal to s1.length()
            if (right - left + 1 > s1.length()) {

                char leftChar = s2.charAt(left);

                map2.put(leftChar, map2.get(leftChar) - 1);

                if (map2.get(leftChar) == 0) {
                    map2.remove(leftChar);
                }

                left++;
            }

            // Check if current window is a permutation
            if (map1.equals(map2)) {
                return true;
            }
        }

        return false;
    }
}