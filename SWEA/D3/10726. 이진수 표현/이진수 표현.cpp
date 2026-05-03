import java.util.*;
import java.io.*;

public class Solution {

    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, l;
    static int[] memo =new int[31];
    static int pow(int num,int k) {
    	if(memo[k]!=0) return memo[k];
    	if(k==0) return memo[k]= 1;
    	int val = pow(num,k/2);val*=val;
    	if((k & 1) == 1 ) val *= num;
    	return memo[k]= val;
    	
    }
    
    
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; ++tc) {
        	sb = new StringBuilder();
        	st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());           
            String ans = "OFF";
            int mask = 0 ;
            
            while(n -- >0) {
            	mask |= pow(2,n);
            }
            if( (m & mask ) ==mask ) 
            {
            	ans = "ON";
            }
            
            
            sb.append('#').append(tc).append(" ").append(ans);
            System.out.println(sb);

        }

    }

}

