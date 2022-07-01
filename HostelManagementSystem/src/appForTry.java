import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class appForTry {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        transaction.commit();
        session.close();
    }
}
