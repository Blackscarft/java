/*
 *  Java Program to Implement Red Black Tree
 */
 
 import java.util.Scanner;
 
 /* Kelas Node */
 class RedBlackNode
 {    
     RedBlackNode left, right;
     int element;
     int color;
 
     /* Constructor */
     public RedBlackNode(int theElement)
     {
         this( theElement, null, null );
     } 
     /* Constructor */
     public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
     {
         left = lt;
         right = rt;
         element = theElement;
         color = 1;
     }    
 }
 
 /* Kelas RBTree */
 class RBTree
 {
    //  private var untuk membuat node
     private RedBlackNode current; 
     private RedBlackNode parent;
     private RedBlackNode grand;
     private RedBlackNode great;
     private RedBlackNode header;    
     private static RedBlackNode nullNode;
     /* initializer statis untuk nullNode */
     static 
     {
         nullNode = new RedBlackNode(0);
         nullNode.left = nullNode;
         nullNode.right = nullNode;
     }
     /* Hitam - 1 RED - 0 */
     static final int BLACK = 1;    
     static final int RED   = 0;
 
     /* Construct */
     public RBTree(int negInf)
     {
         header = new RedBlackNode(negInf);
         header.left = nullNode;
         header.right = nullNode;
     }
     /* Fungsi untuk memeriksa apakah Tree kosong */
     public boolean isEmpty()
     {
         return header.right == nullNode;
     }
     /* Buat Tree kosong secara logis */
     public void makeEmpty()
     {
         header.right = nullNode;
     }
     /* Fungsi untuk memasukkan item */
     public void insert(int item )
     {
         current = parent = grand = header;
         nullNode.element = item;
         while (current.element != item)
         {            
             great = grand; 
             grand = parent; 
             parent = current;
             current = item < current.element ? current.left : current.right;
             // Periksa apakah dua anak merah dan perbaiki jika demikian
             if (current.left.color == RED && current.right.color == RED)
                 handleReorient( item );
         }
         // Penyisipan gagal jika sudah ada
         if (current != nullNode)
             return;
         current = new RedBlackNode(item, nullNode, nullNode);
         // Lampirkan ke orang tua
         if (item < parent.element)
             parent.left = current;
         else
             parent.right = current;        
         handleReorient( item );
     }
     private void handleReorient(int item)
     {
         // Lakukan flip warna
         current.color = RED;
         current.left.color = BLACK;
         current.right.color = BLACK;
 
         if (parent.color == RED)   
         {
             // Harus memutar
             grand.color = RED;
             if (item < grand.element != item < parent.element)
                 // Mulai dbl rotate
                 parent = rotate( item, grand ); 
             current = rotate(item, great );
             current.color = BLACK;
         }
         // Jadikan root hitam
         header.right.color = BLACK; 
     }      
     private RedBlackNode rotate(int item, RedBlackNode parent)
     {
         if(item < parent.element)
             return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
         else
             return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
     }
     /* Putar simpul Tree biner dengan anak kiri */
     private RedBlackNode rotateWithLeftChild(RedBlackNode k2)
     {
         RedBlackNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         return k1;
     }
     /* Putar simpul Tree biner dengan anak kanan */
     private RedBlackNode rotateWithRightChild(RedBlackNode k1)
     {
         RedBlackNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         return k2;
     }
     /* Fungsi untuk menghitung jumlah node */
     public int countNodes()
     {
         return countNodes(header.right);
     }
     private int countNodes(RedBlackNode r)
     {
         if (r == nullNode)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Fungsi untuk mencari elemen */
     public boolean search(int val)
     {
         return search(header.right, val);
     }
     private boolean search(RedBlackNode r, int val)
     {
         boolean found = false;
         while ((r != nullNode) && !found)
         {
             int rval = r.element;
             if (val < rval)
                 r = r.left;
             else if (val > rval)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     /* Fungsi untuk lintasan inorder */
     public void inorder()
     {
         inorder(header.right);
     }
     private void inorder(RedBlackNode r)
     {
         if (r != nullNode)
         {
             inorder(r.left);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             inorder(r.right);
         }
     }
     /* Fungsi untuk melintasi preorder */
     public void preorder()
     {
         preorder(header.right);
     }
     private void preorder(RedBlackNode r)
     {
         if (r != nullNode)
         {
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     /* Fungsi untuk traversal postorder */
     public void postorder()
     {
         postorder(header.right);
     }
     private void postorder(RedBlackNode r)
     {
         if (r != nullNode)
         {
             postorder(r.left);             
             postorder(r.right);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
         }
     }     
 }
 
 /* Kelas RedBlackTreeTest */
 public class RedBlackTreeTest
 {
     public static void main(String[] args)
     {            
        Scanner scan = new Scanner(System.in);
        /* Membuat objek dari RedBlack Tree */
        RBTree rbt = new RBTree(Integer.MIN_VALUE); 
        System.out.println("Red Black Tree Test\n");          
        char ch;
        /* Lakukan operasi Tree */
        do    
        {
            System.out.println("\nRed Black Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. clear tree");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                rbt.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ rbt.search( scan.nextInt() ));
                break;                                          
            case 3 : 
                System.out.println("Nodes = "+ rbt.countNodes());
                break;     
            case 4 : 
                System.out.println("Empty status = "+ rbt.isEmpty());
                break;     
            case 5 : 
                System.out.println("\nTree Cleared");
                rbt.makeEmpty();
                break;         
            default : 
                System.out.println("Wrong Entry \n ");
                break;    
            }
            /* Tampilan Tree */
            System.out.print("\nPost order : ");
            rbt.postorder();
            System.out.print("\nPre order : ");
            rbt.preorder();
            System.out.print("\nIn order : ");
            rbt.inorder(); 
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
     }
 }
