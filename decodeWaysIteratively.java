class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 1; 
        }else if(s.length() == 1){
            return s.charAt(0) == '0' ? 0 : 1;
        }
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int currLength = 2; currLength <= s.length(); currLength++){
            int oneDigit = Integer.valueOf(s.substring(currLength-1,currLength)); //get one digit.
            if(oneDigit >=1 && oneDigit<=9){
                ways[currLength] = ways[currLength-1]; //depends on if the previous one can be individual
                //carry the individual possibility
            }
            int twoDigit = Integer.valueOf(s.substring(currLength-2,currLength)); //looking back pair
            if(twoDigit>=10 && twoDigit<=26){
                ways[currLength]+= ways[currLength-2]; //can the prev,prev be mapped? by itself or as a team
            }
        }
        return ways[s.length()];
    }
}
