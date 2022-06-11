import com.example.javaweb_assignment.service.AdminService;
import com.example.javaweb_assignment.service.impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;

public class AdminServiceTest {
    @Test
    public void loginTest() {
        AdminService adminService = new AdminServiceImpl();
        boolean login = adminService.login("xty", "123");
        assert login;
    }

}
