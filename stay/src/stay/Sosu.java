package stay;

public class Sosu {

	public static void main(String[] args) {
		//2~1000까지 완전수의 개수를 화면에 출력
		//완전수 - 자기 자신을 제외한 약수의 합이 자기 자신인 수
		//6 - 1, 2, 3, 6 : 1+2+3=6
		//약수는 나누어 떨어지는 수
				int x = 2;
				int cnt2 = 0;
		
				while(x<=1000) {
				
					int sum=0;
					int y=1;
					//1과 자기 자신이 아닌 수에서 x의 약수의  합 구하기
					while(y<x) {
						if(x%y ==0) {
							sum = sum + y;
						}
						y=y+1;
					}
					
					if(sum == x) {
						cnt2 = cnt2 +1;
					}
					
					x=x+1;
				}
				System.out.println(cnt2);


		//2부터 1000까지 소수의 개수
		//소수(prime):1과 자기 자신으로만 나누어 떨어지는 수
				int i = 2;
				int sosu = 0;
				int cnt = 0;
				boolean flag = false;
				
				while(i<=1000){
					int j = 2;
					
					while(true) {
						if(i==j) break;
						if(i % j == 0) { flag = true; break;}
						j=j+1;
					}
					
					if(flag == false) {
						sosu = sosu+1;
					}
					
					i=i+1;
					flag = false;
				}
				
				
				System.out.println(sosu);
	}

}
