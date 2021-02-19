import java.io.*;
public class ����_2239�� {

	public static int[][] sdoku=new int[9][9];
	public static boolean[][] garo=new boolean[9][10];
	public static boolean[][] sero=new boolean[9][10];
	public static boolean[][] square=new boolean[10][10];
	public static void fill(int count)
	{
		if(count==81)
		{
			for(int i=0;i<=8;i++)
			{
				for(int j=0;j<=8;j++)
				{
					System.out.print(sdoku[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}//count�� blank�� ��ä����� �����ϴ� ���� ������ ����ϰ� �ý�������
		int i=count/9;
		int j=count%9;
		if(sdoku[i][j]==0)
		{
			int k=3*(i/3)+(j/3)+1;//�־��� i,j ��ġ�� ���° �簢������				
			for(int n=1;n<=9;n++)
			{//1����9���� �ش�ĭ�� �Է��� �������� Ȯ��
			   if(!garo[i][n]&&!sero[j][n]&&!square[k][n])
			   {
				 sdoku[i][j]=n;		
				 garo[i][n]=true;
				 sero[j][n]=true;
				 square[k][n]=true;
				 fill(count+1);
				 sdoku[i][j]=0;		
	 		     garo[i][n]=false;
				 sero[j][n]=false;
				 square[k][n]=false;
			   }
						
		    }
		}			
		else
		{
			fill(count+1);
		}
	}	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s;
		int k;
		for(int i=0;i<=8;i++)
		{
			s=br.readLine().split("");
			for(int j=0;j<=8;j++)
			{
				k=3*(i/3)+(j/3)+1;
				sdoku[i][j]=Integer.parseInt(s[j]);
				if(Integer.parseInt(s[j])!=0)
				{
					garo[i][Integer.parseInt(s[j])]=true;
					sero[j][Integer.parseInt(s[j])]=true;
					square[k][Integer.parseInt(s[j])]=true;
				}
			}
		}
		fill(0);
	}
}