package pl.anetabar.restservice.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.anetabar.restservice.domain.ListItem;
import pl.anetabar.restservice.gateway.ShoppingListGateway;
import pl.anetabar.restservice.repository.ShoppingListRepository;
import pl.anetabar.restservice.service.ShoppingListService;

import java.util.List;

/**
 * Created by Aneta on 07.06.2018.
 */
@RestController
public class ShoppingListGatewayController implements ShoppingListGateway {

    @Autowired
    private ShoppingListService shoppingListService;

    @Override
    public ResponseEntity<ListItem> saveListItem(@RequestBody ListItem listItem) {
        return shoppingListService.saveListItem(listItem);
    }

    @Override
    public List<ListItem> getAllListItems() {
        return shoppingListService.getAllListItems();
    }

    @Override
    public void deleteAllItems() {
        shoppingListService.deleteAllItems();
    }

}
