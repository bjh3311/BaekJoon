import java.util.*;
import java.io.*;
public class 카카오_뉴스클러스터링 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str1=br.readLine();
		String str2=br.readLine();
		System.out.println(solution(str1.toUpperCase(),str2.toUpperCase()));//대소문자를 구별하지 않기때문에 
		

	}
	public static int solution(String str1,String str2)
	{
		HashSet<String> set=new HashSet<String>();
		int inter=0;//교집합 크기
		int sum=0;//합칩합 크기
		for(int i=0;i<str1.length();i++)
		{
			
		}
		float answer=sum/inter;
		
		return (int)(answer*65536);
	}

}
