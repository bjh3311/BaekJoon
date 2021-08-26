import java.util.*;
import java.io.*;
public class 카카오_뉴스클러스터링 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str1=br.readLine();
		String str2=br.readLine();
		System.out.println(solution(str1,str2));//대소문자를 구별하지 않기때문에 
	}
	public static int solution(String str1,String str2)
	{
		str1=str1.toUpperCase();
		str2=str2.toUpperCase();
		ArrayList<String> set1=new ArrayList<String>();
		ArrayList<String> set2=new ArrayList<String>();
		ArrayList<String> inter=new ArrayList<String>();
		ArrayList<String> union=new ArrayList<String>();
		for(int i=2;i<=str1.length();i++)
		{
			String temp=str1.substring(i-2,i);
			boolean proper=true;
			for(int j=0;j<2;j++)
			{
				if((int)temp.charAt(j)<65||(int)temp.charAt(j)>90)
				{
					proper=false;
				}
			}
			if(proper)
			{
				set1.add(temp);
			}
		}
		for(int i=2;i<=str2.length();i++)
		{
			String temp=str2.substring(i-2,i);
			boolean proper=true;
			for(int j=0;j<2;j++)
			{
				if((int)temp.charAt(j)<65||(int)temp.charAt(j)>90)
				{
					proper=false;
				}
			}
			if(proper)
			{
				set2.add(temp);
			}
			
		}
		Collections.sort(set1);
		Collections.sort(set2);
		for(String s:set1)
		{
			if(set2.remove(s))
			{
				inter.add(s);
			}
			union.add(s);
		}
		for(String s:set2)
		{
			union.add(s);
		}
		float answer=0;
		if(union.size()==0)
		{
			answer=1;
		}
		else
		{
			answer=(float)inter.size()/(float)union.size();
		}
		return (int)(answer*65536);
		
	}

}
