package stack;

import static java.lang.System.exit;
public class linkedstack {
    public static void main(String[] args) {
        stacklinkedlist obj = new stacklinkedlist(); // inisiaisasi class stacklinkedlist
        obj.push("brokoli"); //memnaggil methode push dengan parameter brokoli
	obj.push("kol"); //memnaggil methode push dengan parameter kol
	obj.push("bayam"); //memnaggil methode push dengan parameter bayam
	obj.push("kubis"); //memnaggil methode push dengan parameter kubis
	obj.display(); //memanggil methode display
	System.out.println("top : "+obj.peek()); // manampilkan methode peek
	obj.pop(); // memanggil methode pop
	obj.pop(); // memanggil methode pop
	obj.display(); // memanggil methode display
	System.out.println("top : "+obj.peek()); // manampilkan methode peek
    }
}

class stacklinkedlist {
    // class node untuk inisialisasi
    private class Node {
	String data;
	Node link;
    }
    Node top;

    // methode construct
    stacklinkedlist() {
	this.top = null;
    }
    
    // methode push digunakan untuk menambah data ke list
    public void push(String data){
	Node temp = new Node(); // inisialisasi node
	if (temp == null) { // cek apakah null
            System.out.println("stack penuh"); //tampilkan
            return; // kembalikan
	}
            temp.data = data; //isi data
            temp.link = top; // data top
            top = temp; // 
	}

    //methode isEmpty untuk mengcek apakah top = kosong /null
    public boolean isEmpty(){
        return top == null;
    }

    // methode peek untuk mengetahui top dari data
    public String peek(){
        if (!isEmpty()) { // cek apakah tidak kosong
            return top.data; // kembalikan data top
	} else {
            System.out.println("stack kosong"); // tampilkan
            return "-1";
        }
    }

    // methode untuk mengeluarkan data dari stack
    public void pop(){
    	if (top == null) { // cek apakah top = kosong
            System.out.println("stack kosong"); // tampilkan
            return; // kembalikan
	}
        top = (top).link; // jika tidak top = data paling atas di link
    }

    // methode display untuk menampilkan data stack
    public void display(){
        if (top == null) { // cek apakah top = kosong
            System.out.println("stack kosong"); // tampilkan
            exit(1); // keluar program
	} else { // jika tidak
            Node temp = top; 
            while(temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
            }
	}
    }
}
