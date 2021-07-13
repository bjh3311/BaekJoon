import java.util.*;
import java.io.*;
public class 백준_1339번 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] az=new int[26];
		for(int i=0;i<N;i++)
		{
			String s=br.readLine();
			int length=s.length();
			int count=length;
			int value=(int)Math.pow(10,count-1);
			for(int j=0;j<length;j++)
			{
				int index=(int)(s.charAt(j))-65;
				az[index]+=value;
				value=value/10;
			}
		}
		Arrays.sort(az);//내림차순
		int result=0;
		int order=9;
		for(int i=25;i>=0;i--)
		{
			result+=az[i]*order;
			order--;
		}
		System.out.println(result);

	}

}
