package com.italomlaino.backendchallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.italomlaino.backendchallenge.dto.ItemDto;
import com.italomlaino.backendchallenge.stub.MockyStubClient;
import com.italomlaino.backendchallenge.service.ItemService;
import com.italomlaino.backendchallenge.service.ItemServiceImpl;
import com.italomlaino.backendchallenge.service.MockyClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Spy
    private final MockyClient mockyClient = new MockyStubClient();

    @Spy
    private final ItemService itemService = new ItemServiceImpl(mockyClient);

    @InjectMocks
    @Spy
    private ItemController controller;

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        var resultActions = mockMvc
                .perform(get("/challenge-backend/item?begindate=02-10-2016&finaldate=04-10-2016"))
                .andDo(print())
                .andExpect(status().isOk());
        var result = resultActions.andReturn();
        var content = result.getResponse().getContentAsString();
        List<ItemDto> list = objectMapper.readerForListOf(ItemDto.class).readValue(content);

        assertThat(list, hasSize(3));
    }

}
