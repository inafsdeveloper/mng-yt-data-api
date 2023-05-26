package png.springframework.mngytdataapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import png.springframework.mngytdataapi.model.Profile;
import png.springframework.mngytdataapi.services.ProfileService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("profiles")
    List<Profile> getProfiles() {
        return profileService.findAll();
    }
}
