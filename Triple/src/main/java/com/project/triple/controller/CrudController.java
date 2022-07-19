package com.project.triple.controller;


import com.project.triple.controller.ifs.CrudInterface;
import com.project.triple.model.network.Header;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {
    @Override
    @PostMapping("")
    public Header<Res> create(@RequestBody Header<Req> request) {
        return null;
    }

    @Override
    @GetMapping("{id}")
    public Header<Res> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping
    public Header<Res> update(@RequestBody Header<Req> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header<Res> delete(@PathVariable Long id) {
        return null;
    }
}
