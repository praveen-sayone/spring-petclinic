package org.springframework.samples.petclinic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.samples.petclinic.exception.ResourceNotFoundException;
import org.springframework.samples.petclinic.model.PetDetail;
import org.springframework.samples.petclinic.repository.PetDetailRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PetDetailServiceImpl implements PetDetailService {

	private final PetDetailRepository petRepo;

	/**
	 * Create a PetDetailServiceImpl with the provided PetDetailRepository.
	 *
	 * The repository is used for persistence and retrieval of PetDetail entities by this service.
	 */
	@Autowired
	public PetDetailServiceImpl(PetDetailRepository petRepo) {
		this.petRepo = petRepo;
	}

	/**
	 * Persists the given PetDetail and returns the saved entity.
	 *
	 * This operation is performed within a transactional context.
	 *
	 * @param petDetail the PetDetail to persist
	 * @return the persisted PetDetail instance (may include generated identifiers or updated state)
	 */
	@Override
	@Transactional
	public PetDetail savePetDetail(PetDetail petDetail) {
		return petRepo.save(petDetail);
	}

	/**
	 * Retrieves the PetDetail for the given pet identifier.
	 *
	 * The result is cached in the "petDetails" cache using the provided petId as key.
	 *
	 * @param petId the unique identifier of the pet whose details are requested
	 * @return the PetDetail associated with the given petId
	 * @throws ResourceNotFoundException if no PetDetail exists for the provided petId
	 */
	@Override
	@Cacheable(value = "petDetails", key = "#petId")
	@Transactional
	public PetDetail getPetDetailByPetId(Integer petId) {
		return petRepo.findByPetId(petId)
			.orElseThrow(() -> new ResourceNotFoundException("Pet details not found for the pet id : " +petId));
	}

	/**
	 * Updates the PetDetail for the given petId using values from {@code updatedDetail}, persists the changes,
	 * and updates the cached entry for that pet.
	 *
	 * @param petId the identifier of the pet whose detail will be updated
	 * @param updatedDetail provides the new temperament, weight, and length to apply
	 * @return the persisted {@link PetDetail} after applying the updates
	 * @throws ResourceNotFoundException if no PetDetail exists for {@code petId}
	 */
	@Override
	@CachePut(value = "petDetails", key = "#petId")
	@Transactional
	public PetDetail updatePetDetail(Integer petId, PetDetail updatedDetail) {
		PetDetail existing = petRepo.findByPetId(petId)
			.orElseThrow(() -> new ResourceNotFoundException("Pet detail not found for the pet id: " + petId));

		existing.setTemperament(updatedDetail.getTemperament());
		existing.setWeight(updatedDetail.getWeight());
		existing.setLength(updatedDetail.getLength());
		return petRepo.save(existing);
	}

	/**
	 * Deletes the PetDetail associated with the given petId.
	 *
	 * Deletes the persisted PetDetail for the provided petId; if no matching PetDetail
	 * exists a ResourceNotFoundException is thrown. The corresponding cache entry in
	 * the "petDetails" cache (key = petId) is evicted.
	 *
	 * @param petId the ID of the pet whose detail should be deleted
	 * @throws ResourceNotFoundException if no PetDetail exists for the given petId
	 */
	@Override
	@CacheEvict(value = "petDetails", key = "#petId")
	@Transactional
	public void deletePetDetail(Integer petId) {
		PetDetail detail = petRepo.findByPetId(petId)
			.orElseThrow(() -> new ResourceNotFoundException("Pet details not found for the for pet id: " + petId));
		petRepo.delete(detail);
	}
}
