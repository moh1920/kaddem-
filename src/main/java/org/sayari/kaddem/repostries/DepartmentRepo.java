package org.sayari.kaddem.repostries;

import org.sayari.kaddem.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Departement,Integer> {
}
