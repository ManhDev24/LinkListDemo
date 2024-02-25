
public class SoftDrink implements Comparable<SoftDrink> {

    String productLine;
    String company = null;
    int volune = 0;
    int price = 0;

    public SoftDrink(String productLine) {
        this.productLine = productLine;
    }

    public SoftDrink(String pLine, String company, int volune, int price) {
        this.productLine = pLine;
        this.company = company;
        this.volune = volune;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        SoftDrink aSD = (SoftDrink) obj;
        return this.productLine.equals(aSD.productLine);
    }

    @Override
    public int compareTo(SoftDrink o) {
        int pirceDif = this.price - o.price;
        if (pirceDif > 0) {
            return 1;
        }
        if (pirceDif < 0) {
            return -1;
        }
        return this.productLine.compareTo(o.productLine);

    }

    @Override
    public String toString() {
        return productLine+", "+ company+", "+ volune+", "+price;
    }
    

}
