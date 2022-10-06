package week8.SWEA5658TreasureBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
		for(int tc = 1; tc<=T; tc++) { //테스트 케이스만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //N개의 숫자 입력
			int K = Integer.parseInt(st.nextToken()); //K번쨰 숫자 출력
			
			String str = br.readLine(); //N개의 숫자 읽어오기
			List<Character> list = new ArrayList<>(); //숫자를 담을 char형 리스트 선언
			for(int i=0; i<N; i++) {
				list.add(str.charAt(i));
			}
			
			//출력확인
			//System.out.println(list.toString());
			
			int num = N/4; //나누는 개수
			List<String> result = new ArrayList<>(); //결과 String을 담을 리스트
			for(int i=0; i<num; i++) { //반복하면서 숫자 나누기
				String tmp = ""; //나누어진 숫자를 담을 String
				int cnt = 0; //나누는 개수를 체크하기 위해
				for(int j=0; j<N; j++) {
					tmp += list.get(j); //꺼내서 담기
					//System.out.println(tmp);
					cnt++; //개수 증가
					
					if(cnt==num) { //담긴 숫자의 개수가 나누는 숫자의 개수랑 같을 때
						if(!result.contains(tmp)) { //리스트에 같은 값이 존재하지 않을 때만 추가
							result.add(tmp);							
						}
						//다시 초기화
						tmp =""; 
						cnt = 0;
					}
					
				}
				
				char ch = list.remove(list.size()-1); //마지막값을 빼서 처음으로 추가
				list.add(0, ch);
			}
			
			//출력확인
//			for(int i=0; i<result.size(); i++) {
//				System.out.print(result.get(i) + " ");
//			} System.out.println();
			
			//내림차순 정렬
			Collections.sort(result, Collections.reverseOrder());
			//System.out.println(result.toString());
			
			int resultNum = Integer.parseInt(result.get(K-1), 16); //16진수로 변환
			
			System.out.println("#" + tc + " " + resultNum);

		}

	}
	
}
