package com.example.lab_backend.repo.memory;

import com.example.lab_backend.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ShopRepositoryMemory {
    private int currentId = 1;
    private final Map<Integer, Shop> repo = new HashMap<>();

    public List<Shop> viewAll()
    {
        return repo.values().stream().toList();
    }

    public Shop viewOne(int id)
    {
        return repo.get(id);
    }

    public Shop create (Shop p)
    {
        p.setId(currentId);
        currentId++;
        repo.put(currentId-1, p);
        return p;
    }

    public Shop update (Shop p)
    {
        repo.replace(p.getId(), p);
        return p;
    }

    public void delete (int id)
    {
        repo.remove(id);
    }

    public Iterable<Shop> filter (int v)
    {
       return  repo.values().stream().filter(s->s.getNrOfEmployees() > v).toList();
    }

}
