class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int maxfreq=0;
        int result=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int right=0;right<s.length();right++) {
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            maxfreq=Math.max(maxfreq,map.get(ch));
            int windowlength=right-left+1;
            int replacement=windowlength-maxfreq;
            if(replacement>k) {
                char leftchar=s.charAt(left);
                map.put(leftchar,map.get(leftchar)-1);
                left++;

            }
            result=Math.max(result,right-left+1);


        }
        return result;
        
    }
}
