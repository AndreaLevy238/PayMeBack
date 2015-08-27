import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main
{
    public static LinkedList<Payment> readFile(Scanner reader)
    {
        String line = reader.nextLine();
        LinkedList<Payment> book= new LinkedList<>();
        while(reader.hasNextLine()) {
            line = reader.nextLine();
            String[] data = line.split(",");
            try {
                String[] date = data[0].split("/");
                int month = Integer.parseInt(date[0]);
                int day = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[2]);
                double amount = Double.parseDouble(data[1]);
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
        if (sum < 0)
        {
            Double absSum = 0 - sum;
            System.out.println("You lent out "+ Double.toString(absSum)+ " dollars. You need to get your money back.");
        }
        else if (sum > 0)
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
            Scanner reader = new Scanner(new File("src/Expenses.csv"));
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
