import java.util.*;
import java.math.*;
public class ����_2133�� {
	
	static int dp[] ;
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new int[31];
		dp[0] =1; // 0�� �� 1�� ������ش�.
		dp[1] = 0;
		if(n>1)
			dp[2] = 3;
		
		for(int i=4;i<=n;i+=2) { // 4���� 2�� �����ݺ�
			dp[i] = 3*dp[i-2]; // i-2��° dp�� *3
			for(int j=0;j<i-2;j+=2) { // 0���� i-2�� ° ������ ���� ��� �ݺ�
				dp[i]+=dp[j] * 2; // ���� dp[i-2] *3 �� ���� ����ؼ� �����ش�.
			}
		}
		
		System.out.println(dp[n]);
	
				
		
		
			
	}
	
}