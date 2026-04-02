import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder  sb = new StringBuilder(); 
	static int[]mapper= new int[100001];
	static int n ;
	static StringTokenizer st ; 
	static PriorityQueue<int[]>hardHeap ;
	static PriorityQueue<int[]>easyHeap;
	static boolean recommand(PriorityQueue<int[]> pq) {
		while(! pq.isEmpty()) {
			int[] now =  pq.poll();
			if(mapper[now[1]] != now[0]) continue;
			sb.append(now[1]).append('\n');
			pq.add(now);
			return true;
		}
		return false;
	}
	
	static void insert(int pro ,int diff)  { 
		mapper[pro] = diff;
		hardHeap.add(new int[] {diff, pro});
		easyHeap.add(new int[] {diff, pro});
		
	}
	public static void main(String[] args) throws IOException {
		
		n= Integer.parseInt(br.readLine());
		//난이도 // 문제 번호 
		hardHeap = new PriorityQueue<>((a,b)->{
					if( b[0]==a[0] ) return  b[1]-a[1]; 
					return b[0]	 - a[0]; 
			});
		easyHeap = new PriorityQueue<>((a,b)->{
			if( b[0]==a[0] ) return  a[1] - b[1]; 
			return a[0]	 - b[0]; 
		});
		Arrays.fill(mapper, -1);			
		for(int i =0  ;i< n ;++i) {
			st = new StringTokenizer(br.readLine());
			int pro =Integer.parseInt(st.nextToken()) ; 
			int diff = Integer.parseInt(st.nextToken());
			insert(pro, diff);
		}
		
	
		n =  Integer.parseInt(br.readLine());
		//while  최대 20만회 + 100
		for(int i = 0 ;i< n;++i) {
			st =  new StringTokenizer(br.readLine()) ; 
			char c = st.nextToken().charAt(0);
			int pro = -1;int diff =-1;
			switch(c) {
			case 'a':
				pro =Integer.parseInt(st.nextToken()) ; 
				diff = Integer.parseInt(st.nextToken());
				insert(pro, diff);
				break;
			case 'r':
				int rec = Integer.parseInt(st.nextToken());
				if(rec ==1 ) 
					recommand(hardHeap);
				else
					recommand(easyHeap);
				break;
			case 's':
				pro =Integer.parseInt(st.nextToken()) ; 
				mapper[pro]=-1;
				break;
			}
		}
		System.out.print(sb);
	}

}
