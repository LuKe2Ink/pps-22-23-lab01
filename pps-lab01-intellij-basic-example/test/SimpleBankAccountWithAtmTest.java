import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleBankAccountWithAtmTest {

    private AccountHolder holder;
    private BankAccount bankAccountWithAtm;

    @BeforeEach
    void beforEach(){
        holder = new AccountHolder("Pippo", "Pluto", 23);
        bankAccountWithAtm = new SimpleBankAccountWithAtm(this.holder, 0);
    }

    @Test
    void testInitialAmountInBank(){assertEquals(0, this.bankAccountWithAtm.getBalance());}

    @Test
    void testAccountHolder(){
        assertEquals("Pippo", this.holder.getName());
        assertEquals("Pluto", this.holder.getSurname());
        assertEquals(23, this.holder.getId());
    }

    @Test
    void testBankAccountHolder(){
        assertEquals(this.holder, this.bankAccountWithAtm.getHolder());
    }

    @Test
    void testDepositInBankAccount(){
        this.bankAccountWithAtm.deposit(this.holder.getId(), 50);
        assertEquals(49, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawInBankAcocunt(){
        this.bankAccountWithAtm.deposit(this.holder.getId(), 50);
        this.bankAccountWithAtm.withdraw(this.holder.getId(), 20);
        assertEquals(28, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawOverCurrentBalance(){
        this.bankAccountWithAtm.deposit(this.holder.getId(), 50);
        this.bankAccountWithAtm.withdraw(this.holder.getId(), 50);
        assertEquals(49, this.bankAccountWithAtm.getBalance());
    }

    @Test
    void testMultipleTransaction(){
        this.bankAccountWithAtm.deposit(this.holder.getId(), 100);
        this.bankAccountWithAtm.withdraw(this.holder.getId(), 50);
        this.bankAccountWithAtm.withdraw(this.holder.getId(), 20);
        this.bankAccountWithAtm.deposit(this.holder.getId(), 50);
        assertEquals(76, this.bankAccountWithAtm.getBalance());
    }
}
