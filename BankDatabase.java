import java.util.HashMap;
import java.util.Map;


public class BankDatabase {
    //made it private to help with encapsulation(hidden from other classes) reduces unlikelihood of uninteded modifications or access
    //made private to prevent reassignment to a different map object
    private final Map<Integer,String > accounts;
    private final Map<Integer, Double> balances = new HashMap<>();
    
    public BankDatabase(){
        accounts = new HashMap<>();
        accounts.put(12345,"Melissa");
        accounts.put(23456,"Canoe");
        accounts.put(34567,"Cougar");
        accounts.put(45678,"Tyler");

        balances.put(12345, 1000.0); // Account number -> Balance
        balances.put(23456, 500.0);
        balances.put(34567, 2000.0);
        balances.put(45678, 1500.0);

    }
    public double getBalance(int accountNumber) {
        return balances.getOrDefault(accountNumber, 0.0); // Return balance or 0.0 if account not found
    }
    public void addBalance(int accountNumber, double deposit){
        double result = balances.get(accountNumber) + deposit;
        balances.put(accountNumber,result);
        
        
    }
    public void wdBalance(int accountNumber, double withdraw){
        double result = balances.get(accountNumber) - withdraw;
        balances.put(accountNumber,result);
        
        
    }


    public boolean accountExists(int accountnum, String accountName){
        String storedName = accounts.get(accountnum);
        return storedName!= null && storedName.equals(accountName);
    }
}
/**
 * Things i still need to add
 * -an add account function so instead of it being an atm they can also make an account
 * add functions for the choices that they can do
 * if they recieve the message of not having an account make itso they can try again 
 * or create an account
 */