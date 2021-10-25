import com.example.dao.Userdao;
import com.example.domain.user;
import org.junit.jupiter.api.Test;

/**
 * ClassName: daotest
 * Description:
 * date: 2021/10/24 12:01
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */
public class daotest {

    @Test
    public  void testlogin(){
        Userdao ud = new Userdao();
        user us = new user();
        us.setUsername("zhangsxzan");
        us.setPassword("123");
        user zhsan = ud.login(us);
        System.out.println(zhsan);
    }
}
