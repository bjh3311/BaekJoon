import java.util.*;

public class 프로그래머스_이모티콘할인 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] users= {{40,10000},{25,10000}};
		int[] emoticons= {7000,9000};
		int[] result=solution(users,emoticons);
		for(int temp : result)
		{
			System.out.print(temp+" ");
		}
	}
	public static int[] discount= {10,20,30,40};//이모티콘 할인율
	public static int N;//이모티콘 개수
	public static int[] emo;//이모티콘 가격
	public static int[][] customer;
	public static int plus=Integer.MIN_VALUE;//이모티콘 플러스 가입자
	public static int outcome=Integer.MIN_VALUE;//매출
	public static int[] solution(int[][] users,int[] emoticons)
	{

		N=emoticons.length;
		int[] percent=new int[N];
		emo=emoticons.clone();
		customer=users.clone();
		backtrack(percent,0);
		int[] answer= {plus,outcome};
		return answer;
	}
	public static void backtrack(int[] percent,int n)
	{
		if(n==N)
		{
			calculate(percent);
			return;
		}
		for(int i=0;i<4;i++)
		{
			percent[n]=discount[i];
			backtrack(percent,n+1);
		}
	}
	public static void calculate(int[] percent)//이모티콘 각각의 할인율이 적용되었다
	{
		int[] temp=new int[N];//할인율이 적용된 가격
		for(int i=0;i<N;i++)
		{
			temp[i]=emo[i]/100*(100-percent[i]);
		}
		int temp_plus=0;//설정된 할인율에서 이모티콘 플러스가입자 수
		int temp_outcome=0;//설정된 할인율에서 매출
		for(int i=0;i<customer.length;i++)//모든 소비자 조사
		{
			int price=0;//각 소비자 별로 쓴 금액
			for(int j=0;j<N;j++)
			{
				if(percent[j]>=customer[i][0])//소비자가 설정한 할인율보다 높다면 구매
				{
					price=price+temp[j];
				}
			}
			if(price>=customer[i][1])//만약 총금액이 설정한 금액보다 큰 경우
			{
				temp_plus++;
			}
			else//작을경우 그냥 그 가격 그대로 간다
			{
				temp_outcome=temp_outcome+price;
			}
		}
		if(plus==temp_plus)
		{
			outcome=Math.max(outcome, temp_outcome);
		}
		else if(plus<temp_plus)
		{
			plus=temp_plus;
			outcome=temp_outcome;
		}
	}

}
