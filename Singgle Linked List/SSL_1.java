public class SSL_1{
	public static void main(String[] args) {
		list list = new list();

		list.createList();
		list.printElemen();
		System.out.println("========================");

		list.addFirst("67","Supermen","A");
		list.addAfter(list.getFirst(), "68","Betmen","A");
		list.addLast("69","Huluk","A");
		list.printElemen();
		System.out.println("========================");

		list.delLast();
		list.delAfter(list.getFirst());
		list.delFirst();
		list.printElemen();
		System.out.println("========================");

	}
}

class nilaiMatkul{
	String nim,nama,nilai;

	nilaiMatkul(){

	}

	void setNim(String nim){
		this.nim = nim;
	}

	String getNim() {
		return nim;
	}

	void setNama(String nama){
		this.nama = nama;
	}

	String getNama() {
		return nama;
	}

	void setNilai(String nilai){
		this.nilai = nilai;
	}

	String getNilai() {
		return nilai;
	}
}

class elemen{ 

	nilaiMatkul kontainer;
	elemen next;

	elemen(){
		kontainer = new nilaiMatkul();
	}

	nilaiMatkul getKontainer(){
		return kontainer;
	}

	void setNext(elemen next){
		this.next = next;
	}

	elemen getNext(){
		return next;
	}
}

class list{
	private elemen first;

	list(){

	}

	void setFirst(elemen first){
		this.first = first;
	}

	elemen getFirst(){
		return first;
	}

	void createList(){
		first = null;
	}

	int countElemen(){
		int hasil = 0;

		if (first != null) {
			elemen bantu;
			bantu = first;

			while (bantu != null){
				hasil = hasil + 1;
				bantu = bantu.getNext();
			}
		}

		return hasil;
	}

	void addFirst(String nim, String nama, String nilai){
		elemen baru;
		baru = new elemen();
		baru.getKontainer().setNim(nim);
		baru.getKontainer().setNama(nama);
		baru.getKontainer().setNilai(nilai);

		if (first == null) {
			baru.setNext(null);
		} else{
			baru.setNext(first);
		}

		first=baru;
		baru=null;
	}

	void addAfter(elemen prev, String nim, String nama, String nilai){

		if (prev != null) {
			elemen baru;
			baru = new elemen();
			baru.getKontainer().setNim(nim);
			baru.getKontainer().setNama(nama);
			baru.getKontainer().setNilai(nilai);

			if (prev.next == null) {
				baru.setNext(null);
			}else {
				baru.setNext(prev.getNext());
			}

		prev.setNext(baru);
		baru=null;

		} 
	}
	void addLast(String nim, String nama, String nilai){

		if (first == null) {
			addFirst(nim,nama,nilai);
		} else{
			elemen last = first;
			while (last.getNext() != null){
				last = last.getNext();
			}
			addAfter(last,nim,nama,nilai);
		}

	}

	void delFirst(){
		if (first != null) {
			elemen hapus = first;
			if (countElemen() == 1) {
				first = null;
			} else {
				first=first.getNext();
			}
			hapus.setNext(null);
		}else{
			System.out.println("List Kosong");
		}
	}

	void delAfter(elemen prev){
		if (prev != null) {
			elemen hapus = prev.getNext();
		}
	}

	void delLast(){
		if (first!=null) {
			if (countElemen() == 1) {
				delFirst();
			} else {
				elemen last = first;
				elemen before_last = null;
				while (last.getNext() != null){
					before_last = last;
					last = last.getNext();
				}
				delAfter(before_last);
			}
		}
	}

	void delAll(){
		if (first != null) {
			for(int i = countElemen();1 >= 1;i--){
				delLast();
			}
		}
	}

	void printElemen(){
		if (first != null) {
			elemen bantu = first;
			int i = 1;
			while (bantu != null){
				System.out.println("Elemen ke : "+i);
				System.out.println("Nim       : "+bantu.kontainer.nim);
				System.out.println("Nama      : "+bantu.kontainer.nama);
				System.out.println("Nilai     : "+bantu.kontainer.nilai);
				System.out.println("---------------------------");
				bantu = bantu.getNext();
				i = i+1;
			}
		} else {
			System.out.println("list Kosong");
		}
	}

}

