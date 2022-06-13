import com.example.javaweb_assignment.service.MerchantService;
import com.example.javaweb_assignment.service.impl.MerchantServiceImpl;
import org.junit.jupiter.api.Test;

public class MerchantTest {

    MerchantService merchantService = new MerchantServiceImpl();

    @Test
    public void queryMerByIdTest() {

    }

    @Test
    public void deleteGoodsById() {
        boolean flag = merchantService.deleteGoodsById(5);
        assert flag;
    }

}
