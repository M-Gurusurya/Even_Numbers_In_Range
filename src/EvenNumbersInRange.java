import java.util.Scanner;

public class EvenNumbersInRange {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=scanner.nextInt();
        int array[]=new int[size];
        for(int i=0;i<size;i++)
        {
            array[i]=scanner.nextInt();
        }
        System.out.println("enter no.of ranges");
        int length=scanner.nextInt();
        int queries[][]=new int[length][2];
        for(int i=0;i<length;i++)
        {
            for(int j=0;j<2;j++)
            {
                queries[i][j]=scanner.nextInt();
            }
        }
        findPrefixSum(array,size,queries,length);

    }
    public static void findPrefixSum(int array[],int size,int queries[][],int length) {
        int p[]=new int[size];
        if(array[0]%2==0)
            p[0] =1;
        else
            p[0]=0;
        for (int i = 1; i < size; i++) {
            int k=0;
            if(array[i]%2==0)
                k=1;
            p[i] = p[i-1] + k;
        }
        int j=0;
        while (length>0)
        {
            int l=queries[j][0];
            int r=queries[j][1];
            if(l==0)
            {
                System.out.print(p[r]+" ");
            }
            else {
                System.out.print(p[r]-p[l-1]+" ");
            }
            length--;
            j++;
        }
    }
}
