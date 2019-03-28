package task1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import task1.controller.ItemController;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldReturnOKStatusWithMultipleElements() throws Exception {
        mvc.perform(get("/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2017"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(9)))
                .andExpect(jsonPath("$[0].name", equalTo("Impressora")))
                .andExpect(jsonPath("$[0].code", equalTo("5")))
                .andExpect(jsonPath("$[0].dimension.weight", equalTo(10.5)))
                .andExpect(jsonPath("$[1].name", equalTo("Fifa2017")))
                .andExpect(jsonPath("$[2].name", equalTo("Notebook")))
                .andExpect(jsonPath("$[3].name", equalTo("Tablet")));
    }

}