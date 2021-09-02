import java.util.*;
import java.io.*;
public class 카카오_문자열압축 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		System.out.println(solution(s));
	}
	public static int solution(String s)
	{
		int len=s.length()%2==0?s.length()/2:(s.length()/2)+1;//최대 압축이 가능한 길이는 절반
		int answer=Integer.MAX_VALUE;
		for(int i=1;i<=len;i++)
		{
			StringBuilder sb=new StringBuilder("");
			int left=0;
			int right=left+i;
			int cnt=1;//현재 중복된 문자열이 몇개인지
			String s1=s.substring(left,left+i);
			sb.append(s1);//압축 문자열에 추가
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
