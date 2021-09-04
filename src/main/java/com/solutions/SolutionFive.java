package com.solutions;

public class SolutionFive {
    public String longestPalindrome(String s) {
        int size = s.length();
        if (size == 0) return "";
        int[][] dp = new int[size][size]; //dp[i][j]表示：如果Si~Sj是回文串则为其长度，否则等于-1
        int max = 1; //记录最长的回文串的长度
        int start = 0; //记录最长的回文串的初始下标
        for (int len = 1; len <= size; len++) {
            for (int i = 0; i + len - 1 < size; i++) {
               int j=i+len-1;
               if(len==1){
                   dp[i][j]=1;
               }
               else if(len==2){
                   if(s.charAt(i)==s.charAt(j)){
                       dp[i][j]=2;
                       if(dp[i][j]>max){
                           max=dp[i][j];
                           start=i;
                       }
                   }
                   else {
                       dp[i][j]=-1;
                   }
               }
               else{
                   if(dp[i+1][j-1]!=-1){
                       if(s.charAt(i)==s.charAt(j)){
                           dp[i][j]=dp[i+1][j-1]+2;
                           if(dp[i][j]>max){
                               max=dp[i][j];
                               start=i;
                           }
                       }
                       else{
                           dp[i][j]=-1;
                       }
                   }
                   else{
                       dp[i][j]=-1;
                   }
               }
            }

        }
        return s.substring(start,start+max);

    }
}
