import com.example.javaweb_assignment.pojo.Merchant;
import com.example.javaweb_assignment.service.AdminService;
import com.example.javaweb_assignment.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;

public class AdminServiceTest {
    AdminService adminService = new AdminServiceImpl();
    @Test
    public void loginTest() {

        boolean login = adminService.login("xty", "123");
        assert login;
    }

    @Test
    public void queryMerByIdTest() {
        Merchant merchant = adminService.queryMerById("1");
        System.out.println(merchant);
    }

    @Test
    public void insertMerTest() {
        Merchant merchant = new Merchant("999", "test~", "123", "info");
        assert adminService.insertMer(merchant);
    }

    @Test
    public void deleteMerByIdTest() {
        assert adminService.deleteMerById("test~");
    }
}
