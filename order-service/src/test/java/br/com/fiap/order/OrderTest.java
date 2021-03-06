package br.com.fiap.order;

import br.com.fiap.order.OrderSpringBootApplication;
import br.com.fiap.order.model.OrderDTO;
import br.com.fiap.order.service.OrderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class )
@SpringBootTest(classes = OrderSpringBootApplication.class)
public class OrderTest {

	/** The web application context. */
	@Autowired
	private WebApplicationContext webApplicationContext;

	/** The mock mvc. */
	private MockMvc mockMvc;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

    @Mock
    private OrderService orderService;

    @Before
    public void setUpMock() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(orderService.save(any(OrderDTO.class))).thenReturn(new OrderDTO());
    }
    
 	@Test
 	public void naoAchouNadaTest() throws Exception {
 		mockMvc.perform(get("/order/2")).andExpect(status().isNotFound());
 	}
    
    @Test
    public void salvarOrderTest() {
        Assert.assertNotNull(orderService.save(new OrderDTO()));
    }
    


}