import java.io.*;
import java.util.*;

class radix_sort {
	static int max_data;
	static int[] data;


	static int input(){
		Scanner scan = new Scanner(System.in);

		int input_data;

		input_data = scan.nextInt();
		return input_data;

	}

	static void insert_to_array(){
		data = new int[max_data];
		for (int i=0;i < max_data ;i++ ) {
			System.out.print("data ke "+i+" : ");
			data[i] = input();
		}
	}

	static void radixsort(int[] a)  
    {  
        int i, m = a[0], exp = 1, n = max_data;
        int[] b = new int[10];
        
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;        
        }
    }

    static void radixsort_desc(int[] a)  
    {  
       
        int i, m = a[0], exp = 1, n = max_data;
        int[] b = new int[10];
        
        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];
        
        while (m / exp > 0)
        {
            int[] bucket = new int[10];
 
           	for (i=0; i<n; i++)
            bucket[9-a[i]/exp%10]++;         // changed this line
       		for (i=1; i<10; i++)
            bucket[i]+=bucket[i-1];
        	for (i=n-1; i>=0; i--)
            b[--bucket[9-a[i]/exp%10]]=a[i]; // changed this line
        	for (i=0; i<n;i++){
            a[i]=b[i];                       // changed this line
        }
        	exp*=10; 
        }
    }



	public static void main(String[] args) {
		System.out.print("masukan max data : ");
		max_data = input();
		insert_to_array();
		radixsort(data);
		System.out.println("Elements after sorting ");        
        for (int i = 0; i < max_data; i++)
            System.out.print(data[i]+" ");            
        
        System.out.println();

        radixsort_desc(data);
		System.out.println("Elements after sorting desc ");        
        for (int i = 0; i < max_data; i++)
            System.out.print(data[i]+" "); 
	}
}
