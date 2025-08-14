package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.samples.petclinic.model.PetDetail;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetDetailRepository extends JpaRepository<PetDetail, Integer> {
	/**
 * Finds the PetDetail associated with the given pet identifier.
 *
 * @param petId the identifier of the Pet to look up
 * @return an Optional containing the PetDetail if found, or Optional.empty() if none exists
 */
Optional<PetDetail> findByPetId(int petId);
}

