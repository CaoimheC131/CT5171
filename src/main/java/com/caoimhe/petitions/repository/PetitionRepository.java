// src/main/java/com/<your_first_name>/spetitions/repository/PetitionRepository.java
package com.caoimhe.petitions.repository;

import com.caoimhe.petitions.model.Petition;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PetitionRepository {
    private final List<Petition> petitions = new ArrayList<>();
    private Long nextId = 1L;

    public PetitionRepository() {
        petitions.add(new Petition(nextId++, "Save the Forests", "Help stop deforestation in our area."));
        petitions.add(new Petition(nextId++, "Support Renewable Energy", "Encourage renewable energy policies."));
    }

    public List<Petition> findAll() {
        return petitions;
    }

    public Optional<Petition> findById(Long id) {
        return petitions.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Petition save(Petition petition) {
        petition.setId(nextId++);
        petitions.add(petition);
        return petition;
    }
}
