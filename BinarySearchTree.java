/*
 *  Java Program to Implement Binary Search Tree
 */
 
 import java.util.Scanner;
 
 /* Kelas BSTNode */
 class BSTNode
 {
     BSTNode left, right;
     int data;
 
     /* Constructor */
     public BSTNode()
     {
         left = null;
         right = null;
         data = 0;
     }
     /* Constructor */
     public BSTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     /* Fungsi untuk mengatur simpul kiri */
     public void setLeft(BSTNode n)
     {
         left = n;
     }
     /* Fungsi untuk mengatur simpul kanan */
     public void setRight(BSTNode n)
     {
         right = n;
     }
     /* Berfungsi untuk mendapatkan simpul kiri */
     public BSTNode getLeft()
     {
         return left;
     }
     /* Berfungsi untuk mendapatkan simpul yang benar */
     public BSTNode getRight()
     {
         return right;
     }
     /* Fungsi untuk mengatur data ke simpul */
     public void setData(int d)
     {
         data = d;
     }
     /* Berfungsi untuk mendapatkan data dari simpul */
     public int getData()
     {
         return data;
     }     
 }
 
 /* Kelas BST */
 class BST
 {
     private BSTNode root;
 
     /* Pembuat */
     public BST()
     {
         root = null;
     }
     /* Fungsi untuk memeriksa apakah pohon kosong */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Fungsi untuk memasukkan data */
     public void insert(int data)
     {
         root = insert(root, data);
     }
     /* Fungsi untuk memasukkan data secara rekursif */
     private BSTNode insert(BSTNode node, int data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data <= node.getData())
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
     /* Fungsi untuk menghapus data */
     public void delete(int k)
     {
         if (isEmpty())
             System.out.println("Tree Empty");
         else if (search(k) == false)
             System.out.println("Sorry "+ k +" is not present");
         else
         {
             root = delete(root, k);
             System.out.println(k+ " deleted from the tree");
         }
     }
     private BSTNode delete(BSTNode root, int k)
     {
         BSTNode p, p2, n;
         if (root.getData() == k)
         {
             BSTNode lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 p = rt;
                 return p;
             }
             else if (rt == null)
             {
                 p = lt;
                 return p;
             }
             else
             {
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         if (k < root.getData())
         {
             n = delete(root.getLeft(), k);
             root.setLeft(n);
         }
         else
         {
             n = delete(root.getRight(), k);
             root.setRight(n);             
         }
         return root;
     }
     /* Fungsi untuk menghitung jumlah node */
     public int countNodes()
     {
         return countNodes(root);
     }
     /* Berfungsi untuk menghitung jumlah node secara rekursif */
     private int countNodes(BSTNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             return l;
         }
     }
     /* Fungsi untuk mencari elemen */
     public boolean search(int val)
     {
         return search(root, val);
     }
     /* Berfungsi untuk mencari elemen secara rekursif */
     private boolean search(BSTNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getData();
             if (val < rval)
                 r = r.getLeft();
             else if (val > rval)
                 r = r.getRight();
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
         inorder(root);
     }
     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
     }
     /* Fungsi untuk melintasi preorder */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(BSTNode r)
     {
         if (r != null)
         {
             System.out.print(r.getData() +" ");
             preorder(r.getLeft());             
             preorder(r.getRight());
         }
     }
     /* Fungsi untuk traversal postorder */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(BSTNode r)
     {
         if (r != null)
         {
             postorder(r.getLeft());             
             postorder(r.getRight());
             System.out.print(r.getData() +" ");
         }
     }     
 }
 
 /* Kelas BinarySearchTree */
 public class BinarySearchTree
 {
     public static void main(String[] args)
    {                 
        Scanner scan = new Scanner(System.in);
        /* Membuat objek BST */
        BST bst = new BST(); 
        System.out.println("Binary Search Tree Test\n");          
        char ch;
        /* Lakukan operasi Tree */
        do    
        {
            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete");
            System.out.println("3. search");
            System.out.println("4. count nodes");
            System.out.println("5. check empty"); 
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                bst.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to delete");
                bst.delete( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ bst.search( scan.nextInt() ));
                break;                                          
            case 4 : 
                System.out.println("Nodes = "+ bst.countNodes());
                break;     
            case 5 :  
                System.out.println("Empty status = "+ bst.isEmpty());
                break;            
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /* Tampilan Tree */
            System.out.print("\nPost order : ");
            bst.postorder();
            System.out.print("\nPre order : ");
            bst.preorder();
            System.out.print("\nIn order : ");
            bst.inorder();
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
 }
