import java.util.*;
import java.io.*;
 
public class Main {
	
	static int n ; 
	static int d ;
	static int k;
	static int c;
	static int[] su;

	
	public static void main(String[] args) throws Exception {
		StringTokenizer st ; 
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		st = new StringTokenizer( br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		su = new int[n];
		for(int i = 0 ;i<n;++i) {
			su[i]= Integer.parseInt(br.readLine());
		}
		int ans = 0 ;
		//30000*3000=90000000
		for(int i = 0 ;i< n;++i) {
			boolean[] map= new boolean[d+1]; 
			int cnt = 0 ; 
			for(int j=0;j<k;++j) {
				if(map[ su[(i+j)%n ] ] == true) continue;
				map[ su[(i+j)%n]]=true;
				++cnt;
			}
			if(map[c] == false) ++cnt;
			ans=Math.max(ans, cnt);
		}
		
		System.out.print(ans);
	}

}