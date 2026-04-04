import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder  sb = new StringBuilder(); 
	static StringTokenizer st;
	static int[][] origin;
	static int[][] temp;
	static int [] castles = new int[3]; //mC3
	static int [] pick=  new int[3];
	static int[] dr =  {0,-1,0};
	static int[] dc =  {-1,0,1};
	static int n ;
	static int m;
	static int d; 
	static int ans = 0 ;
	final static int NUM_CASTLES=3;
	static int doSimul() {
		int ret =0;
		for(int i = 0 ;i<n;++i) temp[i] = Arrays.copyOf(origin[i], m);
		int phase = n;
		while(phase-->0) { 
			//pick the best
			for(int i =0;i<3;++i) {
				int best =Integer.MAX_VALUE;
				int pos =-1;
				boolean[][] vis= new boolean [n][m];
				Queue<int[]>q= new ArrayDeque<>();
				q.add(new int[] {phase, castles[i], 1 });//r,c,d 
				vis[n-1][castles[i]]=true;
				while(!q.isEmpty()) {
					int[] now = q.poll();
					if(now[2] > d)continue;
					if(temp[now[0]][now[1]]==1) {
						pos= now[0]*m +now[1];
						break;
					}
					for(int d = 0 ;d<3;++d) {
						int nr = now[0]+dr[d];
						int nc = now[1]+dc[d];
						if(nr<0||nr>=n|| nc<0 ||nc>=m)continue;
						if(vis[nr][nc]==true)continue;
						vis[nr][nc]=true;
						q.add(new int[] {nr,nc,now[2]+1});
					}
				}
				pick[i]=pos;
			}
			//remove
			for(int i = 0 ;i< 3;++i) {
				if(pick[i]== -1 )continue;
				int r = pick[i] / m;
				int c = pick[i] % m;
				if(temp[r][c]==0)continue;
				temp[r][c]=0;
				ret++;
			}	
		}
		return ret;
	}
	static void comb(int lv, int start) {
		if(lv >= NUM_CASTLES) {
			ans=Math.max(ans,doSimul());
			return;
		}
		for(int c = start ;c< m;++c) {	
			castles[lv]=c;
			comb(lv+1,c+1);
		}
	}
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n= Integer.parseInt(st.nextToken());
		m= Integer.parseInt(st.nextToken());
		d= Integer.parseInt(st.nextToken());
		origin = new int[n][m];
		temp = new int[n][m];
		for(int i = 0 ;i<n;++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;++j) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0);
		System.out.print(ans);
	}

}
