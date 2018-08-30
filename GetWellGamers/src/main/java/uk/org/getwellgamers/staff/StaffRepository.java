package uk.org.getwellgamers.staff;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StaffRepository extends CrudRepository<Staff, String>{

	@Query("SELECT s FROM Staff s WHERE LOWER(s.principalId) = LOWER(:principalId)")
	public List<Staff> findByPrincipalId(@Param("principalId") String principalId);
	
	@Query("SELECT s FROM Staff s WHERE LOWER(s.forename) = LOWER(:forename) AND LOWER(s.surname) = LOWER(:surname)")
	public List<Staff> findByName(@Param("forename") String forename, @Param("surname") String surname);

}
