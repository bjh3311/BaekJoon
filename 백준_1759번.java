import java.util.Arrays;
import java.util.Scanner;
public class 백준_1759번 {

	public static int L;//암호의 길이
	public static int C;//주어진 문자의 개수
	public static char[] result;//결과값
	public static StringBuilder sb=new StringBuilder();//출력
	public static char[] CharArr;//주어진 문자들
	public static char[] MO_Arr= {'a','e','i','o','u'};//모음 배열
	public static int[] visited;//방문하지 않았으면 0 방문했으면 1
	public static int isable(char[] abc)//주어진 문장이 모음1개 자음2개를 만족하는지 확인
	{
		int MO=0;//모음 갯수
		int JA=0;//자음 갯수
		for(int i=0;i<abc.length;i++)
		{
			int Mo_temp=MO;
			for(int j=0;j<5;j++)
			{
				if(abc[i]==(MO_Arr[j]))
				{
					MO++;	
				}
			}
			if(MO==Mo_temp)
			{
				JA++;
			}//모음갯수에 변함이없다면 자음++;
		}
		
		if(MO==0||JA<2)
		{
			return 0;
		}
		else
		{
			return 1;
		}
		
	}
	public static void backtrack(int n)
	{
		if(n==L)//n이 암호의 길이와 같다면
		{
			if(isable(result)==1)//모음1개자음2개있는지 확인
			{
				for(int i=0;i<L;i++)
				{
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}
		if(n==0)
		{
			for(int i=0;i<C;i++)
			{
				if(visited[i]==0)
				{
					visited[i]=1;
					result[n]=CharArr[i];
					backtrack(n+1);
					visited[i]=0;
				}
			}
		}
		else
		{
			for(int i=0;i<C;i++)
			{
				if(visited[i]==0)
				{
					if(Character.compare(CharArr[i], result[n-1])>0)//사전순으로 증가를 위한 조건
					{
						visited[i]=1;
						result[n]=CharArr[i];
						backtrack(n+1);
						visited[i]=0;
					}
				}
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		L=scan.nextInt();
		C=scan.nextInt();
		CharArr=new char[C];
		result=new char[L];
		visited=new int[C];
		scan.nextLine();//개행 제거
		String[] s=scan.nextLine().split(" ");
        for(int i=0;i<C;i++)
        {
        	CharArr[i]=s[i].charAt(0);
        }
		Arrays.sort(CharArr);
		backtrack(0);
		System.out.println(sb.toString());
	}

}
