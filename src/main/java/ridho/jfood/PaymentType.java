package ridho.jfood;

public enum PaymentType
{
    Cash("Cash"), Cashless("Cashless");
    
    private String payment;
    
    private PaymentType(String payment)
    {
        this.payment = payment;
    }
    
    public String toString()
    {
        return payment;
    }
}