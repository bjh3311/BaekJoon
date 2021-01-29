package 백준_1181번;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
public class 백준_1181번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        String[] s=new String[N];
        scan.nextLine();//개행 버림
        for(int i=0;i<N;i++)
        {
        	s[i]=scan.nextLine();
        }
        Arrays.sort(s,new Comparator<String>() {
        	public int compare(String o1,String o2)
        	{
        		if(o1.length()==o2.length())
        		{
        			return o1.compareTo(o2);    			
        		}
        		else
        		{
        			return o1.length()-o2.length();
        		}
        		
        	}
        });
        System.out.println(s[0]);
        for(int i=1;i<N;i++)
        {
        	if(!s[i].equals(s[i-1]))
        	{
        		System.out.println(s[i]);
        	}
        }
        
	}

}
