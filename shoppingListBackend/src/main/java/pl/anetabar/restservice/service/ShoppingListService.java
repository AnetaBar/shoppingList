package pl.anetabar.restservice.service;

import org.springframework.http.ResponseEntity;
import pl.anetabar.restservice.domain.ListItem;

import java.util.List;

/**
 * Created by Aneta on 08.06.2018.
 */

public interface ShoppingListService {

    ResponseEntity<ListItem> saveListItem(ListItem listItem);

    List<ListItem> getAllListItems();

    void deleteAllItems();

}


