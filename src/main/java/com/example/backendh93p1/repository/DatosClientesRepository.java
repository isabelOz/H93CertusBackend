package com.example.backendh93p1.repository;

import com.example.backendh93p1.entity.DatosClientesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosClientesRepository extends CrudRepository<DatosClientesEntity,Integer> {
}
