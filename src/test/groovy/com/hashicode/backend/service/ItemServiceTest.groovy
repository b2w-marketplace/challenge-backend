package com.hashicode.backend.service

import com.hashicode.backend.TestRoot
import com.hashicode.backend.model.Item
import com.hashicode.backend.repository.ItemRepository
import com.hashicode.backend.repository.ItemRepositoryImpl
import com.hashicode.backend.service.ItemService
import org.assertj.core.util.Lists
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDate

class ItemServiceTest extends TestRoot{

    @Autowired
    private ItemService service

    @Autowired
    private ItemRepositoryImpl itemRepositoryImpl;

    def setup(){
        ItemRepository itemRepository = Mockito.mock(ItemRepository.class);
        Mockito.when(itemRepository.getItens()).thenReturn(Lists.newArrayList(
                Lists.newArrayList(new Item(code: "1", date: "2019-03-25T00:00:00.040Z"),
                        new Item(code: "2", date: "2019-03-25T10:00:00.040Z"),
                        new Item(code: "3", date: "2019-03-26T00:00:00.040Z"),
                        new Item(code: "4", date: "2019-03-27T00:00:00.040Z"),
                        new Item(code: "5", date: "2019-03-24T00:00:00.040Z"),
                )
        ))
        service.setItemRepository(itemRepository)
    }

    def cleanup(){
        service.setItemRepository(itemRepositoryImpl)
    }

    def "testa retorna item corretamente"(){
        when: "Chama entre datas nao contidas"
        List<Item> result = service.getItensBetween(LocalDate.of(2019, 3, 22), LocalDate.of(2019, 3, 23))
        then:
        result.size()==0
        when: "Chama com dia especifico"
        result = service.getItensBetween(LocalDate.of(2019, 3, 24), LocalDate.of(2019, 3, 24))
        then:
        result.size()==1
        result.find {it.code == "5"}!=null
        when: "Chama entre dias"
        result = service.getItensBetween(LocalDate.of(2019, 3, 25), LocalDate.of(2019, 3, 26))
        then:
        result.size()==3
        result.find {it.code == "1"}!=null
        result.find {it.code == "2"}!=null
        result.find {it.code == "3"}!=null
        when: "Chama com inicio depois do fim"
        service.getItensBetween(LocalDate.of(2019, 3, 27), LocalDate.of(2019, 3, 26))
        then:
            thrown IllegalArgumentException

    }
}
