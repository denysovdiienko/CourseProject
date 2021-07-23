package edu.oda.service.item.impls;

import edu.oda.model.Item;
import edu.oda.repository.FakeItemRepository;
import edu.oda.service.item.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    FakeItemRepository repository;

    @Override
    public Item create(Item item) {

        return repository.create(item);
    }

    @Override
    public Item get(String id) {
        return repository.get(id);
    }

    @Override
    public Item update(Item item) {
        return repository.update(item);
    }

    @Override
    public Item delete(String id) {
        return repository.delete(id);
    }

    @Override
    public List<Item> getAll() {

        return repository.getAll();
    }
}