import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder  sb = new StringBuilder(); 
	static StringTokenizer st ;
	static int v,e;
	static ArrayList<int[]>[] adj;
	
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		v= Integer.parseInt(st.nextToken());
		e= Integer.parseInt(st.nextToken());
		
		adj = (ArrayList<int[]>[]) new ArrayList[1+v];
		for(int i = 1;i< v+1;++i)
			adj[i]=new  ArrayList<int[]>();
		
		for(int i = 0 ;i<e;++i) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			adj[a].add(new int[] {w,b});
			adj[b].add(new int[] {w,a});
		}
		boolean[] vis = new boolean[v+1];
		int start =1;
		PriorityQueue<int[]> pq =new PriorityQueue<int[]>(
				(a,b)->Integer.compare(a[0],b[0])
				);
		
		pq.add(new int[] {0,start});
		int ans =0;int cnt=0;
		while(!pq.isEmpty()) {
			int[] poll = pq.poll();
			int w = poll[0];
			int now =poll[1];
			if(vis[now]==true)continue;
			if(cnt == v)break; //v를 다 방문하면 종료
			ans+=w; cnt++;vis[now]=true;
			for(int i= 0 ;i<adj[now].size();++i) {
				int[] edge = adj[now].get(i);
				int nxt = edge[1];
				if(vis[nxt])continue;
				int cost = edge[0];
				pq.add(new int[] {cost,nxt});
			}
		}
		
		System.out.print(ans);
	}

}
