package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.dto.PetDetailDto;
import org.springframework.samples.petclinic.model.PetDetail;
import org.springframework.stereotype.Service;

@Service
public interface PetDetailService {
	/**
 * Persists the given PetDetail and returns the saved instance.
 *
 * The returned object reflects any changes applied during persistence (for example, a generated identifier).
 *
 * @param petDetail the PetDetail to save
 * @return the persisted PetDetail
 */
PetDetail savePetDetail(PetDetail petDetail);
	/**
 * Retrieve the PetDetail associated with the given pet ID.
 *
 * @param petId the id of the pet whose details are being requested
 * @return the PetDetail for the specified pet ID, or {@code null} if no details are found
 */
PetDetail getPetDetailByPetId(Integer  petId);
	/**
 * Update the PetDetail for the pet with the given id and return the persisted result.
 *
 * @param petId the identifier of the pet whose details will be updated
 * @param petDetail the PetDetail data to apply
 * @return the updated, persisted PetDetail
 */
PetDetail updatePetDetail(Integer petId, PetDetail petDetail);
	/**
 * Delete the PetDetail associated with the given pet identifier.
 *
 * @param petId the identifier of the pet whose PetDetail should be removed
 */
void deletePetDetail(Integer petId);
}
