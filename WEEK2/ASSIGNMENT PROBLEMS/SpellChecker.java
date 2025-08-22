import java.util.Scanner;
public class SpellChecker {
    static String[] dictionary = {"hello","world","java","programming","spell","checker"};
    public static String[] splitWords(String sentence) {
        int count = 0;
        for(int i=0;i<sentence.length();i++) {
            if(sentence.charAt(i)==' '||i==sentence.length()-1) count++;
        }
        String[] words=new String[count];
        int start=0,idx=0;
        for(int i=0;i<sentence.length();i++) {
            if(sentence.charAt(i)==' '||i==sentence.length()-1) {
                int end=(i==sentence.length()-1)?i+1:i;
                words[idx++]=sentence.substring(start,end);
                start=i+1;
            }
        }
        return words;
    }
    public static int stringDistance(String a,String b) {
        int n=a.length(),m=b.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=i;
        for(int j=0;j<=m;j++) dp[0][j]=j;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[n][m];
    }
    public static String findClosest(String word) {
        String best=word; int min=Integer.MAX_VALUE;
        for(String d:dictionary) {
            int dist=stringDistance(word,d);
            if(dist<min) {min=dist;best=d;}
        }
        return (min<=2)?best:word;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String sentence=sc.nextLine();
        String[] words=splitWords(sentence);
        System.out.printf("%-15s %-15s %-10s %-10s\n","Word","Suggestion","Distance","Status");
        for(String w:words) {
            String s=findClosest(w);
            int d=stringDistance(w,s);
            String status=(d==0)?"Correct":"Misspelled";
            System.out.printf("%-15s %-15s %-10d %-10s\n",w,s,d,status);
        }
    }
}