import modelo.daos.UserDaoImpl;
import modelo.beans.User;

public class TestJPA {
    public static void main(String[] args) {
        UserDaoImpl cdao = new UserDaoImpl();
        User c1 = cdao.findById(2);
        System.out.println(c1);
    }
}

