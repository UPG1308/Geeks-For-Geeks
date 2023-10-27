
class Solution{
    static int minimumNumberOfDeletions(String S) {
        //your code here
        int len = S.length();
        String str = reverse(S, len);
        int palindromeLength = longestCommonSubsequence(S, str);
        return len - palindromeLength;
    }
    public static String reverse(String s, int n){
        String str = "";
        for(int i = n - 1; i >= 0; i--)str = str + s.charAt(i);
        return str;
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int dp[][] = new int[l1 + 1][l2 + 1];
        for(int[] i: dp)Arrays.fill(i, -1);
        
        return func(l1 - 1, l2 - 1, text1, text2, dp);
    }

    public static int func(int ind1, int ind2, String text1, String text2, int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(text1.charAt(ind1) == text2.charAt(ind2)){
            return dp[ind1][ind2] = 1 + func(ind1 - 1, ind2 - 1, text1, text2, dp);
        }
        return dp[ind1][ind2] = Math.max(func(ind1 - 1, ind2, text1, text2, dp),func(ind1, ind2 - 1, text1, text2, dp));
    }
}
