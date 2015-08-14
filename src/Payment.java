public class Payment
{
    private Date date;
    private double amount;
    public Payment(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }
    public boolean didBorrow()
    {
        // an amount less than 0 is considered borrowed
        // an amount greater than 0 is considered money given
        return amount < 0;
    }
    public double getAmount()
    {
        return this.amount;
    }
}
