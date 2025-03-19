package com.example.adapter.repository;

import com.example.adapter.entity.PosTblUserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PosTblUserRepository implements PanacheRepository<PosTblUserEntity> {
}
