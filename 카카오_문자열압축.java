import java.util.*;
import java.io.*;
public class īī��_���ڿ����� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		System.out.println(solution(s));
	}
	public static int solution(String s)
	{
		int len=s.length()%2==0?s.length()/2:(s.length()/2)+1;//�ִ� ������ ������ ���̴� ����
		int answer=Integer.MAX_VALUE;
		for(int i=1;i<=len;i++)
		{
			StringBuilder sb=new StringBuilder("");
			int left=0;
			int right=left+i;
			int cnt=1;//���� �ߺ��� ���ڿ��� �����
			String s1=s.substring(left,left+i);
			sb.append(s1);//���� ���ڿ��� �߰�
			while(right+i<=s.length())
			{
				String s2=s.substring(right,right+i);
				if(!s1.equals(s2))
				{
					left=right;
					s1=s2;
					if(cnt>1)
					{
						sb.insert(sb.length()-i, cnt);
					}
					sb.append(s1);
					cnt=1;
				}
				else
				{
					cnt++;
				}
				right=right+i;
			}
			if(cnt>1)
			{
				sb.insert(sb.length()-i, cnt);
			}
			sb.append(s.substring(right));
			answer=Math.min(sb.length(), answer);
		}
		return answer;
	}
}
