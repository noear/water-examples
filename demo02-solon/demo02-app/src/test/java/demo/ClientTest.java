package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.noear.solon.test.HttpTestBase;
import org.noear.solon.test.SolonJUnit4ClassRunner;
import org.noear.solon.test.SolonTest;

/**
 * @author noear 2021/4/6 created
 */
@RunWith(SolonJUnit4ClassRunner.class)
@SolonTest(ClientApp.class)
public class ClientTest extends HttpTestBase {
    @Test
    public void test() throws Exception {
        String rst = path("/test").data("msg", "hello").post();

        assert rst != null && rst.startsWith("OK:");

        Thread.sleep(1000);
    }
}
