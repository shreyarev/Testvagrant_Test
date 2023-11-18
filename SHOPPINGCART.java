import java.util.*;

class Prod {
    String name;
    double uPrice;
    double gst;
    int quantity;

    public Prod(String name, double uPrice, double gst, int quantity) {
        this.name = name;
        this.uPrice = uPrice;
        this.gst = gst;
        this.quantity = quantity;
    }

    public double calGSTAmt() {
        return (uPrice * gst / 100) * quantity;
    }



    public double calDiscPrice() {
        double discountPrice = uPrice * quantity;
        if (uPrice >= 500) {
            discountPrice *= 0.95;
        }
        return discountPrice;
    }

public class Shopkeeper {
    public static void main(String[] args) {
        List<Product> basket = new ArrayList<>();
        basket.add(new Prod("Leather Wallet", 1100, 18, 1));
        basket.add(new Prod("Umbrella", 900, 12, 4));
        basket.add(new Prod("Cigarette", 200, 28, 3));
        basket.add(new Prod("Honey", 100, 0, 2));

        Prod maxGstPro = productWithMaxGst(basket);
        System.out.println("Product with maximum GST amount: " + maxGstPro.name);

        double totalAmountToPay = calAmountToPay(basket);
        System.out.println("Total amount to be paid to the shopkeeper: Rs" + totalAmountToPay);
    }

    private static Prod productWithMaxGst(List<Prod> basket) {
        double maxGSTAmount = 0;
        Prod maxGstPro = null;

        for (Prod product : basket) {
            double gstAmt = product.calGSTAmt();
            if (gstAmt > maxGSTAmount) {
                maxGSTAmount = gstAmt;
                maxGstPro = product;
            }
        }

        return maxGstPro;
    }

    private static double calAmountToPay(List<Prod> basket) {
        double totalAmt = 0;

        for (Prod product : basket) {
            totalAmt += product.calDiscPrice() + product.calGSTAmt();
        }

        return totalAmt;
    }
}