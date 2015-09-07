import com.orangeside.urf.model.Function;
import com.orangeside.urf.model.Role;
import com.orangeside.urf.model.User;
import com.orangeside.urf.service.FunctionService;
import com.orangeside.urf.service.RoleService;
import com.orangeside.urf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 工程：os-app
 * 创建人 : ChenGJ
 * 创建时间： 2015/9/2
 * 说明：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"/config/spring.xml"})
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
public class UrfTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    FunctionService functionService;

    @Test
    public void insertUser() {
        User user = new User();
        user.setLoginName("admin");
        user.setPassword("admin");
        user.setDisplayName("user-admin");
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        System.out.println("插入用户：执行结果===============" + userService.insertUser(user));
        System.out.println("用户id：执行结果==============="+user.getId());
    }

    @Test
    public void getUser(){
        User user = userService.findUserById(1);
        System.out.println("获取用户：执行结果==============="+user.getDisplayName());
    }

    @Test
    @Rollback(false)
    public void deleteUser(){
        System.out.println("删除用户：执行结果==============="+userService.deleteUser(1));
    }

    @Test
    public void insertRole(){
        Role role = new Role();
        role.setRoleName("role-admin");
        role.setState(1);
        role.setDefaultAction("/test");
        System.out.println("插入角色：执行结果===============" + roleService.insertRole(role));
        System.out.println("角色id：执行结果===============" + role.getId());
    }


    @Test
    @Rollback(false)
    public void initUserRole(){
        User user = new User();
        user.setLoginName("admin");
        user.setPassword("admin");
        user.setDisplayName("user-admin");
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        System.out.println("插入用户：执行结果===============" + userService.insertUser(user));
        System.out.println("用户id：执行结果===============" + user.getId());
        Role role = new Role();
        role.setRoleName("role-admin");
        role.setState(1);
        role.setDefaultAction("/test");
        System.out.println("插入角色：执行结果===============" + roleService.insertRole(role));
        System.out.println("角色id：执行结果===============" + role.getId());

        System.out.println("插入用户和角色关系：执行结果===============" + userService.insertUserRole(user.getId(),role.getId()));

    }

    @Test
    @Rollback(false)
    public void initRoleFunction(){
        functionService.deleteFunctionById(2);
        Function function = new Function();
        function.setState(1);
        function.setAction("/index");
        function.setDisplay(1);
        function.setFunctionDesc(1);
        function.setFunctionName("主页");
        function.setParentId(0);
        System.out.println("插入功能：执行结果===============" + functionService.insertFunction(function));
        System.out.println("功能id：===============" + function.getId());

        System.out.println("插入角色和功能关系：执行结果===============" + roleService.insertRoleFuntion(4,function.getId()));

    }




}
