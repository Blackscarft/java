package stack;
import java.io.*;
public class Stack {
    private int max; // inisialisasi variable global
    private String[] stackarray; // inisialisasi variable global
    private int top; // inisialisasi variable global

    public static void main(String[] args) {
        Stack stack = new Stack();
	stack.inisialisasi(3); // memanggil methode inisialisasi dengan parameter 3
	stack.push("mangga"); // memanggil methode push dengan parameter mangga
	stack.push("durian"); // memanggil methode push dengan parameter durian
	stack.push("semangka"); // memanggil methode push dengan parameter semangka
	stack.view(); // memanggil metode view
	stack.push("jeruk"); // memanggil methode push dengan parameter jeruk
	stack.push("melon"); // memanggil methode push dengan parameter melon
	stack.pop(); // memanggil metode pop
	stack.pop(); // memanggil metode pop
	stack.view(); // memanggil metode view
	stack.pop(); // memanggil metode pop
	stack.pop(); // memanggil metode pop
	stack.pop(); // memanggil metode pop
	stack.push("pisang"); // memanggil methode push dengan parameter pisang
	stack.push("belimbing"); // memanggil methode push dengan parameter belimbing
	stack.push("nanas"); // memanggil methode push dengan parameter nanas
	stack.push("jambu"); // memanggil methode push dengan parameter jambu
	stack.pop(); // memanggil metode pop
	stack.view(); // memanggil metode view
    }
    
    // methode inisialisasi untuk inisialisasi variable awal
    public void inisialisasi(int data) {
	max = data;
	stackarray = new String[max];
	top = -1;
    }
    // methode push untuk menambah data ke stack
    public void push(String data) {
	if (top >= max -1 ) {
            System.out.println("Stack penuh "+ data +" tidak bisa dimasukan");
	} else {
            top++;
            stackarray[top] = data;
            System.out.println(data + " Masuk ke stack");
        }
    }

    // methode pop untuk mengelurkan data pada stack
    public String pop() {
        String temp;
	if (top >= 0) {
            temp = stackarray[top];
            System.out.println(temp + " Keluar dari stack");
            top--;
            return (temp);
	} else {
            System.out.println("Stack sudah Kosong");
            return ("-1");
            }
    }

    // methode view untuk menampilkan data datri stack
    public void view() {
	System.out.println("Isi Stack : ");
	for (int i=0;i <= top ;i++ ) {
            System.out.print(stackarray[i] + " ");
            System.out.println();
        }
    }
    
}
