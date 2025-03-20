package com.pos.adapter.repository;

import com.pos.adapter.entity.PosTblUserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PosTblUserRepository implements PanacheRepository<PosTblUserEntity> {
    public PosTblUserEntity findByUsername(String username) {
        return find("username",username).firstResult();
    }
}
