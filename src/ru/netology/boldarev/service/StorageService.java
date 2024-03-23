package ru.netology.boldarev.service;

import java.util.ArrayList;
import java.util.List;

public class StorageService<T> {
    private List<T> list = new ArrayList<>();

    public void add(T o) {
        list.add(o);
    }

    public List<T> getAll() {
        return list;
    }

    public void setList(List<T> list){
        this.list = list;
    }
}
