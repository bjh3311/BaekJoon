import java.util.*;
import java.io.*;

public class 프로그래머스_스킬체크Level2_1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] numbers=new int[N];
		String[] s=br.readLine().split(" ");
		for(int i=0;i<N;i++)
		{
			numbers[i]=Integer.parseInt(s[i]);
		}
		System.out.println(solution(numbers));

	}
	public static String solution(int[] numbers)
	{
		String answer="";
		String[] tmp=new String[numbers.length];
		for(int i=0;i<numbers.length;i++)
		{
			tmp[i]=String.valueOf(numbers[i]);
		}
		Arrays.sort(tmp,new Comparator<String>() {
			public int compare(String o1,String o2)
			{
				return (o2+o1).compareTo(o1+o2);
			}
		});
		if(tmp[0].equals("0"))
		{
			return "0";
		}
		for(int i=0;i<tmp.length;i++)
		{
			answer=answer+tmp[i];
		}
		return answer;
	}
}
