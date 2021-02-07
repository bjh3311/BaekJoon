import java.util.Scanner;
public class น้มุ_11758น๘ {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int[][] loc=new int[3][2];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				loc[i][j]=scan.nextInt();
			}
		}
		int a=(loc[1][0]-loc[0][0])*(loc[2][1]-loc[0][1])-(loc[1][1]-loc[0][1])*(loc[2][0]-loc[0][0]);
		if(a>0)
		{
			System.out.println("1");
		}
		else if(a==0)
		{
			System.out.println("0");
		}
		else
		{
			System.out.println("-1");
		}
			

	}

}
