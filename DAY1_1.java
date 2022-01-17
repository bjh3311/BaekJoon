import java.util.*;
import java.io.*;
public class DAY1_1 {

	public static int L;
	public static int C;
	public static String[] s;
	public static String[] mo= {"a","i","o","e","u"};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine().split(" ");
		L=Integer.parseInt(s[0]);
		C=Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		Arrays.sort(s);//오름차순으로 정렬
		DFS(0,0,"");
		
		//1. 체크인 -생략 가능
		//2. 목적지인가?? - 길이 + 자음,모음 개수
		//3. 연결된 곳을 순회 - 나보다 높은 알파벳
		//4. 갈 수 있는가? - 생략 가능
		//5. 간다 -dfs(next) -> 자음,모음
		//6. 체크아웃- 생략 가능
		}
	public static void DFS(int n,int index,String temp)
	{
		if(n==L)//목적지에 도착햇는가??
		{
			int moem=0;
			for(int i=0;i<L;i++)
			{
				for(int j=0;j<5;j++)
				{
					if(temp.substring(i,i+1).equals(mo[j]))
					{
						moem++;
					}
				}
			}
			if(moem>=1&&L-moem>=2)//자음이 2개보다 많고 모음이 1개보다 많으면 정답이다
			{
				System.out.println(temp);
			}
			else
			{
				return;
			}
		}
		for(int i=index;i<C;i++)
		{
			DFS(n+1,i+1,temp+s[i]);
		}
	}
}
