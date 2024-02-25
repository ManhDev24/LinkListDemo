
public class SLL_SoftDrink_Tester {

    public static void main(String[] args) throws Exception {
        String srcFname = "Source.txt";
        String binFname = "results_bin.txt";
        String txtFname = "results_text.txt";
        
        SLL_SoftDrink list = new SLL_SoftDrink();
        list.loadFromFile(srcFname);
        //traversals
        System.out.println("Soft drink in the list:");
        list.printAll();
        System.out.println();
        System.out.println("Soft drinks of Coca:");
        list.printCompanyBased("Coca");
        System.out.println();
        //reverse the list
        list.reverse();
        System.out.println("Reverse the list:");
        list.printAll();
        System.out.println();
        //sorting
        list.ascSort_Price_then_pLine();
        System.out.println("Ascending sort by price then pLine");
        list.printAll();
        System.out.println();
        //search operation
        String type = "Beer 33";
            SoftDrink result = list.search(type);
            if (result == null) {
                System.out.println("Search " + type + ": Not found!");
            } else {
                System.out.println("Search: " + result);
            }
        type = "Miranda";
        result = list.search(type);
        if (result == null) {
            System.out.println("Search" + type + ": Not found!");
        } else {
            System.out.println("Search:" + result);
        }
        System.out.println();
        //remove operation
        type = "Natural";
        result = list.remove(type);
        if (result == null) {
            System.out.println("Remove failed " + type);
        } else {
            System.out.println("Remove successfully " + result);
        }
        type = "Natural orange1";
        result = list.remove(type);
        if (result == null) {
            System.out.println("Remove failed " + type);
        } else {
            System.out.println("Remove successfully " + result);
        }
        //print all element after remove
        System.out.println("\nAfter removing");
        list.printAll();
        //write list to file
        list.printAll_binF(binFname);
        list.printaAll_txtF(txtFname);
    }
}
