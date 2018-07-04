package pl.anetabar.restservice.repository;

import pl.anetabar.restservice.domain.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Aneta on 08.06.2018.
 */
@RepositoryRestResource
public interface ShoppingListRepository extends JpaRepository<ListItem, Long> {
}
