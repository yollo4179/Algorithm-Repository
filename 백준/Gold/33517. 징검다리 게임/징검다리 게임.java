import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr=new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		String commands = br.readLine();

		
		int numJumps = 0;
		
		int cntA = 0;
		int cntD = 0;
		
		for (int i = 0; i < commands.length(); ++i) {
			if (commands.charAt(i) == 'J')
				++numJumps;
		}
		if(numJumps ==0) {
			System.out.print( "NO" );
			return ;
		}
		int[][] memo = new int[numJumps+1][2];
		int j=0; int i = 0;
		int cnt = numJumps + 1; // cycle
		while (cnt > 0 &&numJumps>0) {
			if (commands.charAt(i) == 'J') {
				memo[j][0] = cntA;
				memo[j++][1] = cntD;
				cntA = 0;
				cntD = 0;
				cnt--;
			}
			if (commands.charAt(i) == 'A') {
				cntA++;
			}
			if (commands.charAt(i) == 'D') {
				cntD++;
			}
			++i;
			i = i % commands.length();
		}

		// m+n
		int nxtIdx = 1;
		int jump = 0;
		boolean win=true;
		while (nxtIdx <n) {
			
			if (arr[nxtIdx] >=0 && arr[nxtIdx] <= memo[jump][0]) {
				jump = 1+ (jump) % (numJumps);
				++nxtIdx;
			}
			else if (arr[nxtIdx] < 0 && memo[jump][1]>0 ) {
				jump = 1+ (jump) % (numJumps);
				++nxtIdx;
			}
			else {
				win = false;
				break;
			}
			
		}
		System.out.print( win?"YES":"NO" );
	}

}
