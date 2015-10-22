import com.orangeside.urf.model.Function;
import com.orangeside.urf.model.Role;
import com.orangeside.urf.model.User;
import com.orangeside.urf.service.FunctionService;
import com.orangeside.urf.service.RoleService;
import com.orangeside.urf.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/2
 * 说明：
 */
@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration(locations = {"/config/spring.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UrfTest extends AbstractTransactionalJUnit4SpringContextTests {
    public static Logger logger = Logger.getLogger(UrfTest.class);
    @Autowired UserService userService;
    @Autowired RoleService roleService;
    @Autowired FunctionService functionService;

    @Test public void init() {
        User user = new User();
        user.setLoginName("admin");
        user.setPassword("admin");
        user.setDisplayName("管理员");
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        logger.info("插入用户：执行结果===============" + userService.insertUser(user));
        logger.info("用户id：执行结果===============" + user.getId());

        Role adminRole = new Role();
        adminRole.setRoleName("role-admin");
        adminRole.setState(1);
        adminRole.setDefaultAction("/index");
        logger.info("插入角色：执行结果===============" + roleService.insertRole(adminRole));
        logger.info("角色id：执行结果===============" + adminRole.getId());

        logger.info("插入用户和角色关系：执行结果===============" + userService
            .insertUserRole(user.getId(), adminRole.getId()));

        Function index = new Function();
        index.setState(1);
        index.setAction("/index");
        index.setDisplay(1);
        index.setFunctionDesc(1);
        index.setFunctionName("首页");
        index.setParentId(0);
        logger.info("插入功能：执行结果===============" + functionService.insertFunction(index));
        logger.info("功能id：===============" + index.getId());

        logger.info("插入角色和功能关系：执行结果===============" + roleService
            .insertRoleFuntion(adminRole.getId(), index.getId()));

        Role role = new Role();
        role.setRoleName("role-sample");
        role.setState(2);
        role.setDefaultAction("/sample");
        logger.info("插入角色：执行结果===============" + roleService.insertRole(role));
        logger.info("角色id：执行结果===============" + role.getId());

        logger.info("插入用户和角色关系：执行结果===============" + userService
            .insertUserRole(user.getId(), role.getId()));

        Function test = new Function();
        test.setState(1);
        test.setAction("/sample*");
        test.setDisplay(1);
        test.setFunctionDesc(1);
        test.setFunctionName("测试");
        test.setParentId(0);
        logger.info("插入功能：执行结果===============" + functionService.insertFunction(test));
        logger.info("功能id：===============" + test.getId());

        logger.info("插入角色和功能关系：执行结果===============" + roleService
            .insertRoleFuntion(role.getId(), test.getId()));
    }


}
