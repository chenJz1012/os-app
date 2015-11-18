import java.awt.print.Printable;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class) @WebAppConfiguration
@ContextConfiguration(locations = {"/config/spring.xml"}) public class UserControllerTest {

    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection") @Autowired protected WebApplicationContext
        wac;

    @Before public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test public void users() throws Exception {
        System.out.println("result:" + mockMvc
            .perform(get("/adminUser/users").param("pageNum", "0").param("pageSize", "15"))
            .andExpect(status().isOk()).andReturn().getResponse().getContentAsString());
    }

    @Test public void selectUser() throws Exception {
        System.out.println(
            "result:" + mockMvc.perform(get("/adminUser/users/21")).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }
}
