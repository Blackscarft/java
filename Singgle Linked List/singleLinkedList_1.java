class data {
	int nilai;
	data next;

	public data(int n,data nex){
		nilai = n;
		next = nex;
	}
}

public class singleLinkedList_1 {
	private static data head;
	private static int list;

	public singleLinkedList_1() {
		head = null;
	}

	static boolean isEmpty() {
		return head == null;
	}

	static void insert(int n) {
		data temp;
		temp = new data(n, head);
		head = temp;
		System.out.println("Nilai "+n+" masuk linked list");
		list++;
	}

	static void insertAfter(int n,int index) {
		if (isEmpty()) {
			System.out.println("Linked list Kosong");
		} else {
			if (index > list) {
				System.out.println("Melebihi panjang List!");
			} else {
				data temp = head;
				data fixed;
				for (int i = 1;i < index ;i++ ) {
					temp = temp.next;
				}
				fixed = new data(n, temp.next);
				temp.next = fixed;
				System.out.println("Nilai "+n+" masuk linked list");
				list++;
			}
		}
	}

	static void insertBefore(int n, int index){
		if (isEmpty()) {
			System.out.println("Linked list Kosong");
		} else {
			if (index > list) {
				System.out.println("Melebihi panjang List!");
			} else {
				data temp = head;
				data fixed;
				if ((head.nilai == temp.nilai) && (index==1)) {
					temp = new data(n, head);
					head = temp;
					System.out.println("Nilai "+n+" masuk linked list");
					list++;
				} else {
					fixed = new data(n, temp.next);
					temp.next = fixed;
					System.out.println("Nilai "+n+" masuk linked list");
					list++;
				}
			}
		}
	}

	static void delete() {
		if (isEmpty()) {
			System.out.println("Linked list Kosong");
		} else {
			System.out.println("Nilai "+head.nilai+" terhapus");
			head=head.next;
			list--;
		}
	}

	static void delLinkedList(int index) {
		if (isEmpty()) {
			System.out.println("Linked list Kosong");
		} else {
			if (index > list) {
				System.out.println("Melebihi panjang List!");
			} else {
				data temp = head;
				for (int i = 1;i < index ;i++ ) {
					temp = temp.next;
				}

				if ((head.nilai == temp.nilai) && (index==1)) {
					System.out.println("Nilai "+head.nilai+" pada indeks "+index+" dihapus");
					head = head.next;
					list--;
				} else {
					System.out.println("Nilai "+temp.next.nilai+" pada indeks "+index+" dihapus");
					temp.next = temp.next.next;
					list--;
				}
			}
		}
	}

	static void findList(int i){
		data temp = head;
		int x=0;
		boolean hasil = false;
		while(temp != null) {
			x++;
			if (temp.nilai == i) {
				hasil = true;
				break;
			}
			temp = temp.next;
		}

		if (hasil) {
			System.out.println("Nilai "+i+" ditemukan pada list ke "+x);
		} else{
			System.out.println("Tidak ditemukan");
		}
	}

	static void display() {
		data temp = head;
		System.out.println("Jumlah data dalam list : "+list);
		while(head != null){
			System.out.println("Isi linked list : "+temp.nilai);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		singleLinkedList_1 a = new singleLinkedList_1();
		a.delete();
		a.insert(12);	
		a.insert(2);	
		a.insert(1);	
		a.insert(34);	
		a.delete();	
		a.insertAfter(13, 1);
		a.insertBefore(15, 1);
		a.delLinkedList(2);
		a.findList(15);
		a.display();
	}


}