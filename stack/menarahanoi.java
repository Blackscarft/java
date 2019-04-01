package stack;
 
public class menarahanoi {
    private static menarahanoi[] tower; 
    private int stackSize;
    private int[] stackArray;
    private int top;
 
    // methode construct untuk inisialisasi size
    public menarahanoi(int size) {
        this.stackSize = size;
        this.stackArray = new int[stackSize];
        this.top = -1;
    }
 
    // methode push untuk menambah data di atas stack
    public void push(int entry) throws Exception {
    	this.stackArray[++top] = entry;
    }
 
    // methode pop untuk menghapus data dari stack
    public int pop() throws Exception {
        if(this.isStackEmpty()){
        	System.out.println("Stack kosong.");
        }
        return this.stackArray[top--];
    }

    // methode peek untuk mengetahui top dari stack
    public int peek() {
        return stackArray[top];
    }
 
    // methode IsStackEmpty untuk mengcek apakah stack kosong
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    // methode isStackFull untuk mengcek apakah stack penuh
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
 
    public void towersOfHanoi(int n) throws Exception {    	 
        //untuk membuat 3 stack sebagai tiang dari menara  hanoi
        tower = new menarahanoi[4];
        for (int i = 0; i <= 3; i++){
            tower[i] = new menarahanoi(4);
        }
        for (int d = n; d > 0; d--){
            //inisialisasi dan menambahkan ke tower 1
            tower[1].push(new Integer(d)); 
        }
        //memindahkan dari tower 1 ke 2 melaui 3
        showTowerStates(n, 1, 2, 3);
    }
    
    // methode showTowerStates untuk menampilkan tower hanoi
    public void showTowerStates(int n, int x, int y, int z) {         
        if (n > 0) {
            try{
                showTowerStates(n - 1, x, z, y);
                //memindah kan top tower satu ke yang lainya 
                Integer d = (Integer) tower[x].pop(); 
                tower[y].push(d); 
                System.out.println("Pindahkan piring " + d 
                        + " dari tower "+ x + " ke atas dari tower " + y);
                showTowerStates(n - 1, z, y, x);
            } catch(Exception e){
            	e.printStackTrace();
            }
        }
    }
    
    //  methode main untuk inisailasi tower hanoi dan size
	public static void main(String args[]){
		try {
			menarahanoi test = new menarahanoi(10);
			test.towersOfHanoi(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}