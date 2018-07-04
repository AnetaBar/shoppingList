package pl.anetabar.restservice.gateway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.anetabar.restservice.domain.ListItem;

import java.util.List;

/**
 * Created by Aneta on 07.06.2018.
 */
@RequestMapping("/listItems")
public interface ShoppingListGateway {

    String origin = "http://127.0.0.1:8081";

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = origin)
    ResponseEntity<ListItem> saveListItem(@RequestBody ListItem listItem);

    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin(origins = origin)
    List<ListItem> getAllListItems();

    @RequestMapping(method = RequestMethod.DELETE)
    @CrossOrigin(origins = origin)
    void deleteAllItems();

}
