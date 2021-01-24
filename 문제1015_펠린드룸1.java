package πÆ¡¶1015_∆Á∏∞µÂ∑Î1;
import java.util.Scanner;

public class πÆ¡¶1015_∆Á∏∞µÂ∑Î1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();	
		int answer=1;//∆Á∏∞µÂ∑Î¿Ã∏È 1
		if(N==0)
		{
			answer=1;
		}
		else
		{
			int length=(int)(Math.log10(N)+1);
			int[] arr=new int[length];
			for(int i=0;i<length;i++)
			{
				arr[i]=N%10;
				N=N/10;
			}
			
			for(int i=0;i<length/2;i++)
			{
				if(arr[i]!=arr[length-i-1])
				{
					answer=0;
					break;
				}
			}
		}
		
		if(answer==1)
		{
			System.out.println(1);
		}
		else
		{
			System.out.println(0);
		}
		
		
	}

}
