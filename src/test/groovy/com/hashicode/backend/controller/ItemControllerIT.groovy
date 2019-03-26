package com.hashicode.backend.controller

import com.hashicode.backend.ITTestRoot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


class ItemControllerIT extends ITTestRoot{

    @Autowired
    private MockMvc mockMvc

    def "Retorna json"(){
        expect:
        mockMvc.perform(MockMvcRequestBuilders.get("/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016")).
                andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

    }


}
