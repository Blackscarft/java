public class queue{
	public static void main(String[] args) {
		int ukuran = 8;

		Queues daftar = new Queues(ukuran);

		//Masukan 9 nama

		daftar.insert("Noctic");
		daftar.insert("Promto");
		daftar.insert("Gladioulus");
		daftar.insert("Ignis");
		daftar.insert("Corleonis");
		daftar.insert("Regis");
		daftar.insert("Ledolas");
		daftar.insert("Ardyn");
		daftar.insert("Aranea");

		//Kosongkan isi queue dan tampilkan
		System.out.println("Isi Queue");
		while (! daftar.empty()){
			String nama = daftar.remove();
			System.out.println(nama);
		}

	}
}

class Queues{

	private String[] data;
	private int depan, belakang;
	private int maksElement;

	//konstruktor
	public Queues(int ukuran){
		depan = 0;
		belakang = 0;
		maksElement = ukuran;
		data = new String[ukuran];
	}


	// masukan data ke antrean
	// nilai balik tidak ada
	public void insert(String x){
		int posisiBelakang;

		// Geser belakang ke posisi berikutnya
		if (belakang == maksElement - 1)
			posisiBelakang = 0;
		else
			posisiBelakang = belakang + 1;

		//cek belakang apa sama dengan depan
		if (posisiBelakang == depan){
			System.out.println("Antrian Penuh");
			System.out.println(x + " Tidak dimasukan.");
		} else {
			belakang = posisiBelakang;
			//masukan data
			data[belakang] = x;
		}

	}

	public String remove(){
		if (empty()){
			System.out.println("Antrian kosong");
			return "";
		}

		if (depan == maksElement - 1) 
			depan = 0;
		else
			depan = depan + 1;

		return data[depan];
		
	}

	public boolean empty(){
		if (depan == belakang) 
			return true;
		else
			return false;
		
	}
}
