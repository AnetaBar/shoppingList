package pl.anetabar.restservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.anetabar.restservice.domain.ListItem;
import pl.anetabar.restservice.repository.ShoppingListRepository;
import pl.anetabar.restservice.service.ShoppingListService;

import java.util.List;

/**
 * Created by Aneta on 08.06.2018.
 */
@Service
public class ShoppingListServiceImpl implements ShoppingListService {

    @Autowired
    ShoppingListRepository shoppingListRepository;

    @Override
    public ResponseEntity<ListItem> saveListItem(ListItem listItem) {
        ListItem item = shoppingListRepository.save(listItem);
        return new ResponseEntity<ListItem>(item, HttpStatus.OK);
    }

    @Override
    public List<ListItem> getAllListItems() {
        return shoppingListRepository.findAll();
    }

    @Override
    public void deleteAllItems() {
        shoppingListRepository.deleteAll();
    }
}
