import java.util.*;
import java.io.*;
class Node
{
	int num;
	Node left;
	Node right;
	public Node(int num)
	{
		this.num=num;
	}
	public void insert(int n)
	{
		if(n<this.num)//���� ����Ʈ���� �����Ѵ�
		{
			if(this.left==null)
			{
				this.left=new Node(n);
			}
			else
			{
				this.left.insert(n);
			}
		}
		else//������ ����Ʈ���� �����Ѵ�
		{
			if(this.right==null)
			{
				this.right=new Node(n);
			}
			else
			{
				this.right.insert(n);
			}
		}
	}
}
public class ����_5639�� {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int temp=Integer.parseInt(br.readLine());
		Node root=new Node(temp);
		String s;
		while(true)
		{
			s=br.readLine();
			if(s==null||s.equals(""))//�Է��� ��������� break
			{
				break;
			}
			int key=Integer.parseInt(s);
			root.insert(key);
		}
		postorder(root);
		
	}
	public static void postorder(Node now)
	{
		if(now==null)
		{
			return;
		}
		postorder(now.left);
		postorder(now.right);
		System.out.println(now.num);
		
	}
}
