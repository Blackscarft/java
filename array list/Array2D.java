package array1d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Array2D {

    static int baris_arr1;
    static int kolom_arr1;
    static int baris_arr2;
    static int kolom_arr2;
    
    static int[][] arrayA;
    static int[][] arrayB;
    static int[][] arrayC;

    public static void main(String[] args) {
        int pilihan;
        pilihan = pilihmenu();
        
        switch(pilihan){
            case 1 :
                inputbariskolom();
                if(cek_jumlahdankurang()){
                    inputarray();
                    tampilkan();
                    jumlah();
                    minimum();
                    maximum();
                } else {
                    System.out.println("Tidak bisa di Jumlahkan ! ");
                    System.exit(0);
                }
                break;
            case 2 :
                inputbariskolom();
                if(cek_jumlahdankurang()){
                    inputarray();
                    tampilkan();
                    kurangi();
                    minimum();
                    maximum();
                } else {
                    System.out.println("Tidak bisa di Kurangi ! ");
                    System.exit(0);
                }
                break;
            case 3 :
                inputbariskolom();
                if(cek_kali()){
                    inputarray();
                    tampilkan();
                    kali();
                    minimum();
                    maximum();
                } else {
                    System.out.println("Tidak bisa di Kalikan ! ");
                    System.exit(0);
                }
                break;
        }
    }
     public static int pilihmenu() {
        System.out.println("+-----Operasi 2 Matrik-----+");
        System.out.println("+ 1. Penjumlahan           +");
        System.out.println("+ 2. Pengurangan           +");
        System.out.println("+ 3. Perkalian             +");
        System.out.println("+--------------------------+");
        int pilihan;
        do {
            System.out.print("masukan pilihan : ");
            pilihan = inputdata();
        }while(pilihan < 1 || pilihan > 3);
        return pilihan;
    }
    
    static void inputbariskolom() {
            System.out.println("Masukan Arrray 2 Dimensi");
            System.out.println("matrik ke 1 : ");
            System.out.print("Baris : ");
            baris_arr1 = inputdata();
            System.out.print("Kolom : ");
            kolom_arr1 = inputdata();
            System.out.println("matrik ke 2");
            System.out.print("Baris : ");
            baris_arr2 = inputdata();
            System.out.print("Kolom : ");
            kolom_arr2 = inputdata();
    }

    private static int inputdata() {
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      String input_angka = null;

      try {
      	input_angka = read.readLine();
      } catch(Exception e){
      	e.toString();
      }

      int input_nilai = Integer.valueOf(input_angka);
      return input_nilai;
        
    }

    static void inputarray() {
    	System.out.println("Masukan nilai matrik ke 1: ");
    	arrayA = new int[baris_arr1][kolom_arr1];
    	for (int i=0; i < baris_arr1 ; i++ ) {
    		for (int j=0; j < kolom_arr1; j++) {
            System.out.print("baris : ["+i+"], kolom ["+j+"] : ");
            arrayA[i][j] = inputdata();
    		}
    	}
    	System.out.println("Masukan nilai matrik ke 2: ");
    	arrayB = new int[baris_arr2][kolom_arr2];
    	for (int k=0; k < baris_arr2 ; k++ ) {
    		for (int l=0; l < kolom_arr2; l++) {
            System.out.print("baris : ["+k+"], kolom ["+l+"] : ");
            arrayB[k][l] = inputdata();
    		}
    	}
    }

    static void tampilkan() {
    	System.out.println("Hasil yang di inputkan  : ");
    	System.out.println("matrik 1 : ");
    	for (int i=0; i < baris_arr1 ; i++ ) {
    		for (int j=0; j < kolom_arr1; j++) {
                System.out.print(arrayA[i][j]+" ");
    		}
            System.out.println();
    	}	
    	System.out.println("matrik 2 : ");
    	for (int k=0; k < baris_arr2 ; k++ ) {
    		for (int l=0; l < kolom_arr2; l++) {
                System.out.print(arrayB[k][l]+" ");
    		}
            System.out.println();
    	}
    }
   private static boolean cek_jumlahdankurang() {
    	if((baris_arr1 == baris_arr2) && (kolom_arr1 == kolom_arr2)) {
    	    return true;
    	} else  {
    	    return false;
        }
    }

    private static boolean cek_kali()
    {
        if(kolom_arr1 == baris_arr2) {
            return true;
        } else {
            return false;
        }
    }

    static void jumlah() {
    	
        System.out.println("Hasil Penjumlahan : ");
        arrayC = new int[baris_arr1][baris_arr2];
        for (int i=0; i < baris_arr1 ;i++ ) {
            for (int j=0;j < kolom_arr1 ;j++ ) {
                arrayC[i][j] = arrayA[i][j] + arrayB[i][j];
                System.out.print(arrayC[i][j]+" ");
            }
                System.out.println();
        }
    }

    static void kurangi() {
        System.out.println("Hasil pengurangan : ");
        arrayC = new int[baris_arr1][kolom_arr1];
        for (int i=0; i < baris_arr1 ;i++ ) {
            for (int j=0;j < kolom_arr1 ;j++ ) {
                arrayC[i][j] = arrayA[i][j] - arrayB[i][j];
                System.out.print(arrayC[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void kali() {
        arrayC = new int[baris_arr1][kolom_arr2];
      
        System.out.println("Hasil Perkalian : ");
        for(int a = 0; a < baris_arr1; a++){
            for(int b = 0; b < kolom_arr2; b++){
                for(int c = 0; c < baris_arr2; c++){
                    arrayC[a][b] += arrayA[a][c] * arrayB[c][b];
                }
                System.out.print(arrayC[a][b]+" ");
            }
            System.out.println();
        }
    }

    static void minimum() {
    	System.out.print("Hasil nilai minimum : ");
    	int min = arrayC[0][0];
    	for (int i=0; i < arrayC.length ; i++ ) {
    		for (int j=0; j < arrayC[i].length; j++) {
            if (arrayC[i][j] < min){
            	min = arrayC[i][j];
            }
    		}
    	}	
    	System.out.print(min);
    	System.out.println();
    }

    static void maximum() {
        System.out.print("Hasil nilai maximum : ");
        int max = arrayC[0][0];
        for (int i=0; i < arrayC.length ; i++ ) {
            for (int j=0; j < arrayC[i].length; j++) {
                if (arrayC[i][j] > max){
                    max = arrayC[i][j];
                }
            }
        }   
        System.out.print(max);
        System.out.println();
    }

}
