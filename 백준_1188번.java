import java.util.Scanner;
public class ����_1188�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		double N=scan.nextDouble();//�Ҽ��� ����
		double N_temp=N;
		double M=scan.nextDouble();//��а� ��
		double M_temp=M;
		double mod=M%N;
		if(M==N)
		{
			System.out.println("0");
			System.exit(0);
		}
		else
		{
			while(true)
			{
				if(mod==0)
				{
					System.out.println((int)(M-N_temp));
					break;
				}
				M_temp=N_temp;
				N_temp=mod;
				mod=M_temp%N_temp;
			}
		}
		
		
	}

}
