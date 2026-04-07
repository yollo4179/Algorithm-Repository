import java.io.*;
import java.util.*;

public class Main {

	static int n, q;
	static boolean[] arr;
	static HashSet<Integer>[] set;
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		set = (HashSet<Integer>[]) new HashSet[n + 1];
	
		for (int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			/* 크기 입력값 날립니다. */
			Integer.parseInt(st.nextToken());
			set[i]=new HashSet();
			while (st.hasMoreTokens()) {
				set[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		// 입력을 완료하였습니다.
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine());

			int query = Integer.parseInt(st.nextToken());

			switch (query) {
			case 1: {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (set[a].size() < set[b].size()) {
					set[b].addAll(set[a]);
					set[a] = set[b];
				}
				else {
					set[a].addAll(set[b]);
				}
				set[b] = new HashSet<>();
				break;
			}
			case 2: {
				int a = Integer.parseInt(st.nextToken());
				sb.append(set[a].size()).append("\n");
				break;
			}
			}

		}
		System.out.print(sb);
	}
}
