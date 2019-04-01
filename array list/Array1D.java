package array1d;

// import Buffereadreader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array1D {
    static int panjang_array;
    static int[] nilai_array;

    public static void main(String[] args) {
        System.out.print("Masukan Panjang Array : ");
        panjang_array = inputdata();

        inputarray();
        tampilkan();
        average();
        urutdata();
        ganjilgenap();
    }

    private static int inputdata() {
    	BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    	String input_angka = null;

    	try {
            input_angka = read.readLine();
    	} catch(Exception e) {
            e.toString();
    	}

    	int input_nilai = Integer.valueOf(input_angka);
    	return input_nilai;
    }
    
    static void inputarray() {
        nilai_array = new int[panjang_array];
        for (int i=0; i < panjang_array ; i++) {
	        System.out.print("Masukan nilai Array  ke "+i+": ");
        	nilai_array[i] = inputdata();
        }
    }

    static void tampilkan() {
        System.out.println("Isi Array yang diinputkan : ");
        for (int i=0;i<panjang_array;i++){
            System.out.println("Array ke "+i+" : "+nilai_array[i]);
        }
    }

    static void average() {
    	double rata = 0;
    	for (int i=0;i<panjang_array;i++){
    		rata += nilai_array[i];
    	}
    	System.out.println("nilai rata - rata : "+rata/panjang_array);
    }
    
    static void urutdata() {
    	Arrays.sort(nilai_array);
    	for(int isi : nilai_array) {
    		System.out.println("diurutankan : "+isi);
    	}
    }

    static void ganjilgenap(){
    	int ganjil=0,genap=0,itemgenap=0,itemganjil=0;
    	for (int i=0;i<panjang_array;i++){
    		if (nilai_array[i] % 2 == 1) {
    			ganjil += nilai_array[i];
    			itemganjil += 1;
    		} else {
    			genap += nilai_array[i];
    			itemgenap += 1;
    		}
    	}
    	System.out.println("Jumlah ganjil : "+ganjil+" ada "+itemganjil+" item");
    	System.out.println("Jumlah genap : "+genap+" ada "+itemgenap+" item");
    }
}
