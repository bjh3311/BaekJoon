import java.util.*;
import java.io.*;
public class īī��_����Ŭ�����͸� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str1=br.readLine();
		String str2=br.readLine();
		System.out.println(solution(str1.toUpperCase(),str2.toUpperCase()));//��ҹ��ڸ� �������� �ʱ⶧���� 
		

	}
	public static int solution(String str1,String str2)
	{
		HashSet<String> set=new HashSet<String>();
		int inter=0;//������ ũ��
		int sum=0;//��Ĩ�� ũ��
		for(int i=0;i<str1.length();i++)
		{
			
		}
		float answer=sum/inter;
		
		return (int)(answer*65536);
	}

}
