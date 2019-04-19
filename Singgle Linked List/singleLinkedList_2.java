public class singleLinkedList_2 {
	
	public static void main(String[] args) {
		SenaraiBeraintai sb = new SenaraiBeraintai();
		sb.insert("SD","Sruktur Data");
		sb.insert("BD","Basis Data");
		sb.insert("SO","Sistem Operasi");
		sb.insert("AA","Analisa Alogaritma");
		sb.insert("RIT","Riset Teknologi Informasi");

		System.out.println("Keadaan Awal");
		sb.display();
		sb.remove("SO");
		System.out.println();
		System.out.println("Setelah SO di Hapus");
		sb.display();

		String dicari = "SO";
		System.out.println();
		System.out.println("Pencarian" + dicari);
		Node posisiData = sb.find(dicari);
		if (posisiData == null) {
			System.out.println("Tidak ditemukan");
		} else {
			System.out.println("Hasil Pencarian");
			posisiData.display();
		}
		dicari = "AA";
      System.out.println();
      System.out.println("Pencarian "+dicari);
      posisiData = sb.find(dicari);
      if (posisiData == null) {
			System.out.println(dicari +" Tidak ditemukan");
		} else {
			System.out.println("Hasil Pencarian");
			posisiData.display();
		}

	}

}

class Node {
	public String kode;
	public String nama;
	Node berikut;

	public Node(String _nama, String _kode){
		kode = _kode;
		nama = _nama;
		berikut = null;
	}

	public void display(){
		System.out.println(kode+ " : "+nama);
	}
}

class SenaraiBeraintai {
	private Node pertama;
	Node pendahulu;
	Node posisiData;

	public SenaraiBeraintai() {
		pertama = null;
	}

	public void insert(String kode, String nama) {
		Node ptrBaru;
		ptrBaru = new Node(kode, nama);
		ptrBaru.berikut = pertama;
		pertama = ptrBaru;
	}

	public boolean findX(String x){
		posisiData = pertama;
		pendahulu = null;
		boolean ditemukan = false;
		while (posisiData != null) {
			String kode = posisiData.kode;
			if (kode.compareTo(x) == 0) {
				ditemukan = true;
				break;
			}
			pendahulu = posisiData;
			posisiData = posisiData.berikut;
		}
		return ditemukan;
	}

	public Node find(String x) {
		boolean ditemukan = findX(x);
		if (! ditemukan)
			return null;
		else
			return posisiData;
	}

	public boolean remove(String x) {
		pendahulu = null;
		posisiData = null;
		boolean ditemukan = findX(x);
		if (! ditemukan){
			System.out.println("Data tidak ditemukan");
			return false;
		}
		if (pendahulu == null) {
			pertama = pertama.berikut;
		} else {
			pendahulu.berikut = posisiData.berikut;
			posisiData = null;
		}
		return true;
	}

	public void display() {
		System.out.println("Isi senarai berantai : ");
		Node penunjuk = pertama;
		while(penunjuk != null){
			penunjuk.display();
			penunjuk = penunjuk.berikut;
		}
	}

}