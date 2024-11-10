package net.ensah.demo.repository;

import net.ensah.demo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "users")
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
