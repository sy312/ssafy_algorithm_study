package week8.BJ1034Lamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] lamp = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				lamp[i][j] = str.charAt(j) - '0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		//출력확인
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(lamp[i][j]);
//			} System.out.println();
//		}
		
		int max = 0; //가장 큰 값 출력
		for(int i=0; i<N; i++) {
			int zeroCnt = 0;
			
			//0의 개수 세기
			for(int j=0; j<M; j++) {
				if(lamp[i][j] == 0 ) {
					zeroCnt++;
				}
			}
			//System.out.println(zeroCnt);
			
			int lightOn = 0; //불이 켜진 행의 개수
			if(zeroCnt <= K && zeroCnt%2 == K%2) { //K보다 크고, 둘이 홀짝이 같을 때
				for(int j=0; j<N; j++) {
					if(check(lamp[i], lamp[j])) { //현재 행과 동일한 형태의 행이 있다면
						lightOn++; //불 켜진 행의 개수 증가
					}
				}
				//System.out.println(lightOn);
				max = Math.max(max, lightOn);
			}
		}
		
		System.out.println(max);
		
	}

	private static boolean check(int[] arr, int[] arr2) {
		for(int i=0; i<M; i++) {
			if(arr[i] != arr2[i]) { //두 행의 값이 같지않으면
				return false; //false 리턴
			}
		}
		return true; //같다면 true 리턴
	}
	
}
