package png.springframework.mngytdataapi.services.datajpa;

import org.springframework.stereotype.Service;
import png.springframework.mngytdataapi.model.Profile;
import png.springframework.mngytdataapi.repositories.ProfileRepository;
import png.springframework.mngytdataapi.services.ProfileService;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileSDJpaService implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileSDJpaService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> findAll() {
        List<Profile> profiles = new ArrayList<>();
        profileRepository.findAll().forEach(profiles::add);
        return profiles;
    }

    @Override
    public Profile findById(Long aLong) {
        return profileRepository.findById(aLong).orElse(null);
    }

    @Override
    public Profile save(Profile object) {
        return profileRepository.save(object);
    }

    @Override
    public void delete(Profile object) {
        profileRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        profileRepository.deleteById(aLong);
    }

    @Override
    public Profile findByEmailId(String emailId) {
        return profileRepository.findByEmailId(emailId);
    }
}
