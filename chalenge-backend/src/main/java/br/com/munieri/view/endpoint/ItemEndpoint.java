package br.com.munieri.view.endpoint;

import br.com.munieri.domain.item.Item;
import br.com.munieri.domain.item.ItemNotFound;
import br.com.munieri.domain.item.service.ItemService;
import br.com.munieri.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("challenge-backend")
public class ItemEndpoint {

    @Autowired
    private ItemService service;

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public ResponseEntity<List<ItemDTO>> get(@RequestParam("begindate") String beginDate, @RequestParam("finaldate") String finalDate) throws ParseException {

        return parseToResponse(service.findByInterval(DateUtil.parse(beginDate, DateUtil.SIMPLE_PATTERN),
                DateUtil.parse(finalDate, DateUtil.SIMPLE_PATTERN)), HttpStatus.OK);

    }

    @ExceptionHandler(ItemNotFound.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO postalAddressNotFoundHandler(ItemNotFound ex, HttpServletResponse response) {
        return new ErrorDTO("item_not_found", "Item nao encontrado");
    }

    private ResponseEntity parseToResponse(List<Item> itemList, HttpStatus status) {

        List<ItemDTO> dtos = new ArrayList<>();
        for(Item item : itemList) {
            dtos.add(new ItemDTO(item));
        }

        return new ResponseEntity<List<ItemDTO>>(dtos, status);
    }
}
