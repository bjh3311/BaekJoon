import java.util.*;
import java.io.*;
public class น้มุ_12904น๘ {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringBuilder S=new StringBuilder(br.readLine());
		StringBuilder T=new StringBuilder(br.readLine());
		while(T.length()>S.length())
		{
			if(T.charAt(T.length()-1)=='A')
			{
				T.deleteCharAt(T.length()-1);
				
			}
			else
			{
				T.deleteCharAt(T.length()-1);
				T=T.reverse();
			}
		}
		if(T.toString().equals(S.toString()))
		{
			System.out.println("1");
		}
		else
		{
			System.out.println("0");
		}
	}
}
