package 백준_10814번;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class 백준_10814번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            Scanner scan=new Scanner(System.in);
            int N=scan.nextInt();
            String[][] s=new String[N][2];
            for(int i=0;i<N;i++)
            {
            	s[i][0]=scan.next();
            	s[i][1]=scan.next();
            }
            Arrays.sort(s,new Comparator<String[]>() {
            	public int compare(String[] o1,String[] o2 )
            	{
            			int a=Integer.parseInt(o1[0]);
            			int b=Integer.parseInt(o2[0]);
            			return (a-b);
            	}
            });
            for(int i=0;i<N;i++)
            {
            	System.out.println(s[i][0]+" "+s[i][1]);
            }
	}

}
