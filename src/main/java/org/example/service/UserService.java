package org.example.service;

import org.example.colors.StringColors;
import org.example.dto.ProfileDTO;
import org.example.enums.Status;
import org.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //    ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    @Autowired
    private ProfileRepository profileRepository;


    public ProfileDTO login(ProfileDTO profileDTO) {
        ProfileDTO profile = profileRepository.login(profileDTO);


        return profile;

    }

    public boolean registration(ProfileDTO profile) {
        boolean result = profileRepository.registration(profile);
        return result;
    }

    public void showProfileList() {
        List<ProfileDTO> profiles = profileRepository.getProfileList();
        if (profiles != null) {
            for (ProfileDTO profile : profiles) {
                if (profile.getStatus().equals(Status.ACTIVE)) {
                    System.out.println(StringColors.YELLOW + profile + StringColors.ANSI_RESET);
                } else if (profile.getStatus().equals(Status.NO_ACTIVE)) {
                    System.out.println(StringColors.WHITE + profile + StringColors.ANSI_RESET);
                } else if (profile.getStatus().equals(Status.BLOCKED)) {
                    System.out.println(StringColors.RED + profile + StringColors.ANSI_RESET);
                }
            }
        } else {
            System.out.println(StringColors.RED + "We have not any profiles" + StringColors.ANSI_RESET);
        }
    }

    public void setProfileRepository(ProfileRepository profileRepository) {

    }
}
