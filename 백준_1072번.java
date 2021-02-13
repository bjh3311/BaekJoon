import java.util.Scanner;
public class น้มุ_1072น๘ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		long X=scan.nextLong();
		long Y=scan.nextLong();
		long Z=Y*100/X;
		if(Z>=99)
		{
			System.out.println("-1");
			return;
		}
		long left=1;
		long right=1000000000;
		long mid=0;
		long result=(left+right)/2;
		while(left<=right)
		{
			mid=(left+right)/2;
			System.out.println("left="+left);
			System.out.println("right="+right);
			System.out.println(mid);
		    if((Y+mid)*100/(X+mid)==Z)
			{
				left=mid+1;
			}
			else
			{
				right=mid-1;
			}
		}
		System.out.println(left);

	}

}
