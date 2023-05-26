package png.springframework.mngytdataapi.repositories;

import org.springframework.data.repository.CrudRepository;
import png.springframework.mngytdataapi.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Profile findByEmailId(String emailId);
}
