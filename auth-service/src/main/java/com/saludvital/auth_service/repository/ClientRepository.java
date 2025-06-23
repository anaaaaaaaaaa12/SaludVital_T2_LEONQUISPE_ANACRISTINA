package com.saludvital.auth.repository;

import com.saludvital.auth.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientIdAndClientSecretAndEnabled(String clientId, String clientSecret, boolean enabled);
}
