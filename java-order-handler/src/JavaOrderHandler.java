import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class JavaOrderHandler {
    public static void main(String[] args) {
        /*
        Exercise 29 Statement:
        MyJava Coffee Outlet runs a catalog business. It sells only one type of
        coffee beans, harvested exclusively in the remote area of Irian Jaya. The
        company sells the coffee in 2-lb bags only, and the price of a single 2-lb
        bag is $5.50. When a customer places an order, the company ships the
        order in boxes. The boxes come in three sizes: the large box holds 20 bags
        of 2 lb, the medium 10 bags, and the small 5 bags. The cost of a large
        box is $1.80; a medium box, $1.00; and a small box, $0.60. The order is
        shipped in the least expensive manner. For example, the order of 52 bags
        will be shipped in four boxes: two large, one medium, and one small. The
        rule for packing is to fill the large and medium boxes completely; that is,
        the box is fully packed. Only the small boxes can have empty spaces. For
        example, to ship 52 bags, you could have used 3 large boxes, but that
        would leave the third box not fully packed. Develop a program that
        computes the total cost of an order. Display the output in the following
        format:

        Number of Bags Ordered: 52 - $ 286.00
        Boxes Used:
        2 Large - $3.60
        1 Medium - $1.00
        1 Small - $0.60
        Your total cost is: $ 291.20
        */

        /*
        Repeat Exercise 29, but this time, accept the date when the order is placed
        and display the expected date of arrival. The expected date of arrival is two
        weeks (14 days) from the date of order. The order date is entered as a
        single string in the MM/dd/yyyy format. For example, November 1, 2008
        is entered as 11/01/2008. There will be exactly two digits each for the
        month and day and four digits for the year. Display the output in the
        following format:

        Number of Bags Ordered: 52 - $ 286.00
        Boxes Used:
                    2 Large - $3.60
                    1 Medium - $1.00
                    1 Small - $0.60
        Your total cost is: $ 291.20
        Date of Order:                  November 1, 2008
        Expected Date of Arrival:       November 15, 2008
         */

        // price of coffee bag and boxes
        final double COFFEE_BAG_PRICE = 5.50;
        final double SMALL_BOX_PRICE = 0.60;
        final double MEDIUM_BOX_PRICE = 1.00;
        final double LARGE_BOX_PRICE = 1.80;

        // constants
        final String NEW_LINE = "\n";

        // number of bags the boxes can carry
        final int SMALL_BOX_SIZE = 5;
        final int MEDIUM_BOX_SIZE = 10;
        final int LARGE_BOX_SIZE = 20;

        // bags is input, and bagsAtFirst to display in output
        int bags, bagsAtFirst;

        // date values and computations
        // approach: get current date, which is dateOfOrder, get dateOfArrival, make it equal to dateOfOrder (clone)
        // then add 14 days to addOfArrival
        GregorianCalendar dateOfOrder = new GregorianCalendar();
        GregorianCalendar dateOfArrival;
        dateOfArrival = (GregorianCalendar) dateOfOrder.clone();
        dateOfArrival.add(Calendar.DATE, 14);

        // output values
        int medium, large, small; // number of bags used
        double price, total; // price of coffee, total price with boxes

        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");

        // read input
        System.out.print("How many boxes would you like to order (2 lb each): ");
        bags = scanner.nextInt();

        // assign bags to bagsAtFirst, the value of the bags get smaller with computation, to display the unchanged value
        // in output bagsAtFirst is used
        bagsAtFirst = bags;

        // compute the boxes needed
        // approach: filter from large to small, the number of bags gets divided each time, if possible
        // and the remainder is passed down to a smaller box
        large = bags / LARGE_BOX_SIZE;
        bags = bags % LARGE_BOX_SIZE;
        medium = bags / MEDIUM_BOX_SIZE;
        bags = bags % MEDIUM_BOX_SIZE;
        small = (int) Math.ceil((double) bags / SMALL_BOX_SIZE);

        // compute price and total
        price = bagsAtFirst * COFFEE_BAG_PRICE;
        total = price + (large * LARGE_BOX_PRICE) + (medium * MEDIUM_BOX_PRICE) + (small * SMALL_BOX_PRICE);

        // output
        System.out.print(
                "Number of Bags Ordered: " + bagsAtFirst + " - $ " + df.format(price) + NEW_LINE +
                        "Boxes Used:" + NEW_LINE +
                        "           " + large +  " Large - " + df.format(large * LARGE_BOX_PRICE) + NEW_LINE +
                        "           " + medium + " Medium - " + df.format(medium * MEDIUM_BOX_PRICE) + NEW_LINE +
                        "           " + small + " Small - " + df.format(small * SMALL_BOX_PRICE) + NEW_LINE +
                        "Your total cost is: $ " + df.format(total) + NEW_LINE +
                        "Date of Order:             " + sdf.format(dateOfOrder.getTime()) + NEW_LINE +
                        "Expected Date of Arrival:  " + sdf.format(dateOfArrival.getTime())
        );
    }
}