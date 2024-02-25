/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author NC
 */
public class SLL_Node {
    
    SoftDrink data; // a data of softDrink
    SLL_Node next; //reference to next node in sll

    
    public SLL_Node(SoftDrink aSD) {
        this.data = aSD;
        this.next = null;
    }
    public SLL_Node(String prodictLine,String company, int volune, int price){
        
        SoftDrink aSD = new SoftDrink(company, company, volune, price);
        this.data = aSD;
        this.next = null;
        
    }
    
    
    
}
