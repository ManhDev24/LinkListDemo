/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.StringTokenizer;

/**
 *
 * @author NC
 */
public class SLL_SoftDrink {

    SLL_Node head, tail;

    // emty sll
    public SLL_SoftDrink() {
        head = tail = null;
    }

    //checking whether the list is empty or not
    public boolean Empty() {
        return head == null;
    }

    public void addFirst(SoftDrink aSD) {
        SLL_Node newNode = new SLL_Node(aSD);
        if (this.Empty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addFirst(String pLine, String company, int volume, int price) {
        addFirst(new SoftDrink(company, company, volume, price));
    }

    public void addLast(SoftDrink aSD) {
        SLL_Node newNode = new SLL_Node(aSD);
        if (this.Empty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;

        }
    }

    public void insertAfter(SLL_Node q, SoftDrink aSD) {
        if (q == null) {
            return;
        }
        SLL_Node qNext = q.next;
        SLL_Node newNode = new SLL_Node(aSD);
        q.next = newNode;
        if (tail == q) {
            tail = q;
        }
    }

    public void addLast(String pLine, String company, int volume, int pirce) {
        addLast(new SoftDrink(pLine, company, volume, pirce));
    }

    private SoftDrink creatSD(String line) {
//        StringTokenizer stk = new StringTokenizer(line,",");
        String[] array = line.split("[,]");
        String productLine = array[0].trim();
        String company = array[1].trim();
        int volume = Integer.parseInt(array[2].trim());
        int price = Integer.parseInt(array[3].trim());
        return new SoftDrink(productLine, company, volume, price);
    }

    public void loadFromFile(String fName)
            throws Exception {
        FileReader fr = new FileReader(fName);
        BufferedReader bf = new BufferedReader(fr);
        String line;
        StringTokenizer stk;
        for (int i = 0; i < 3; i++) {
            line = bf.readLine();
            this.addFirst(creatSD(line));
        }
        while (true) {
            line = bf.readLine();
            if (line == null) {
                break;
            }
            if (!line.isEmpty()) {
                this.addLast(creatSD(line));
            }
        }

    }

    public SoftDrink search(String productLine) {
        if (this.Empty()) {
            return null;
        }
        SLL_Node p = head;
        while (p != null) {
            if (p.data != null && p.data.productLine.equals(productLine)) {
                return p.data;
            } else {
                p = p.next;
            }
        }

        return null;
    }

    public void reverse() {
        if (this.Empty()) {
            return;
        }

        SLL_Node after = null, current = head, before;

        while (current != null) {
            before = current.next;
            current.next = after;
            after = current;
            current = before;
        }

        // Swap head and tail at the end
        SLL_Node temp = head;
        head = tail;
        tail = temp;
    }

    public SoftDrink remove(String pLine) {
        if (this.Empty()) {
            return null;
        }

        SoftDrink aSoftDrink = new SoftDrink(pLine);
        SoftDrink removedEle = null;
        SLL_Node pDel = head, pAfter = null;

        while (pDel != null && !pDel.data.equals(aSoftDrink)) {
            pAfter = pDel;
            pDel = pDel.next;
        }

        if (pDel != null) {
            removedEle = pDel.data;

            if (pDel == head) {
                head = head.next;
                if (head == null) {
                    head = tail = null;
                }
            } else if (pDel == tail) {
                pAfter.next = null;
                tail = pAfter;
            } else {
                pAfter.next = pDel.next;

            }

        }

        return removedEle;
    }

    private void visit(SLL_Node node) {
        System.out.println(node.data + "\n");
    }

    // print all element
    public void printAll() {
        if (this.Empty()) {
            System.out.println("Empty list");
        } else {
            for (SLL_Node p = head; p != null; p = p.next) {
                visit(p);
            }
        }
    }

    //travelsing for printing all element of company
    public void printCompanyBased(String company) {
        if (this.Empty()) {
            System.out.println("Emty list");
        } else {
            for (SLL_Node p = head; p != null; p = p.next) {
                if (p.data.company.equals(company)) {
                    visit(p);
                }
            }
        }

    }

    public void ascSort_Price_then_pLine() {
        if (this.Empty()) {
            return;
        }
        SoftDrink t;
        SLL_Node i, j;
        for (i = head; i != tail; i = i.next) {
            for (j = i.next; j != null; j = j.next) {
                t = i.data;
                i.data = j.data;
                j.data = t;
            }
        }
    }

    public void visit_binF(RandomAccessFile f, SLL_Node node) throws Exception {
        f.writeBytes(node.data.toString() + "\r\n");
    }

    public void printAll_binF(String filename) throws Exception {
        if (this.Empty()) {
            System.out.println("EMPTY LIST");
        } else {
            File f = new File(filename);
            if (f.exists()) {
                f.delete();
            }
            RandomAccessFile rf = new RandomAccessFile(f, "rw");
            for (SLL_Node p = head; p != null; p = p.next) {
                visit_binF(rf, p);
            }
            rf.close();
        }
    }

    private void visit_txtF(PrintWriter f, SLL_Node node) throws Exception {
        f.println(node.data);
    }

    public void printaAll_txtF(String filename) throws Exception {
        if (this.Empty()) {
            System.out.println("EMPTY LIST");
        } else {
            PrintWriter pw = new PrintWriter(filename);
            for (SLL_Node p = head; p != null; p = p.next) {
                visit_txtF(pw, p);
            }
            pw.close();
        }
    }

}
