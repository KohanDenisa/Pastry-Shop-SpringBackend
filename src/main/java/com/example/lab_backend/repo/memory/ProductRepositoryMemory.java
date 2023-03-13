package com.example.lab_backend.repo.memory;

import com.example.lab_backend.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryMemory {
    private int currentId = 1;
    private final Map<Integer, Product> repo = new HashMap<>();

    public List<Product> viewAll()
    {
        return repo.values().stream().toList();
    }

    public Product viewOne(int id)
    {
        return repo.get(id);
    }

    public Product create (Product p)
    {
        p.setId(currentId);
        currentId++;
        repo.put(currentId-1, p);
        return p;
    }

    public Product update (Product p)
    {
        repo.replace(p.getId(), p);
        return p;
    }

    public void delete (int id)
    {
        repo.remove(id);
    }
}
