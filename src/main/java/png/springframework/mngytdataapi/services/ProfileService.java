package png.springframework.mngytdataapi.services;


import png.springframework.mngytdataapi.model.Profile;

public interface ProfileService extends CrudService<Profile, Long> {
    Profile findByEmailId(String emailId);
}
