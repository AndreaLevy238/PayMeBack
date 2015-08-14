import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    public static LinkedList<Payment> readFile(Scanner reader)
    {
        LinkedList<Payment> book= new LinkedList<>();
        while(reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] data = line.split(" ");
            try {
                int month = Integer.parseInt(data[0]);
                int day = Integer.parseInt(data[1]);
                int year = Integer.parseInt(data[2]);
                double amount = Double.parseDouble(data[3]);
                Payment payment = new Payment(new Date(month, day, year), amount);
                book.add(payment);


            } catch (IndexOutOfBoundsException ob) {
                System.out.println("Incomplete Date");
            }
        }
        return book;
    }
    public static void outText(double sum)
    {
        if (sum > 0)
        {
            System.out.println("You lent out "+ Double.toString(sum)+ " dollars. You need to get your money back.");
        }
        else if (sum < 0)
        {
            System.out.println("You owe" + Double.toString(sum) + "dollars");
        }
        else
        {
            System.out.println("Free and Clear!");
        }
    }

    public static void main(String[] args)
    {

        try
        {
            Scanner reader = new Scanner(new File("src/Expenses.txt"));
            Double sum = 0.0;
            LinkedList<Payment> book = readFile(reader);

            for (Payment p : book)
            {
                    sum += p.getAmount();
            }
            outText(sum);

        }
        catch(FileNotFoundException nf)
        {
            System.out.println("File not found");
        }

    }

}
