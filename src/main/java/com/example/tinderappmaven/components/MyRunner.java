package com.example.tinderappmaven.components;


import com.example.tinderappmaven.model.Profile;
import com.example.tinderappmaven.model.Role;
import com.example.tinderappmaven.respository.ProfileRepository;
import com.example.tinderappmaven.respository.RoleRepository;
import com.example.tinderappmaven.respository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRunner implements CommandLineRunner {


    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public MyRunner(RoleRepository repository, UserRepository userRepository, ProfileRepository profileRepository) {
        this.roleRepository = repository;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        profileRepository.save(new Profile(1L,"Henry Cavill",
                "https://m.media-amazon.com/images/M/MV5BODI0MTYzNTIxNl5BMl5BanBnXkFtZTcwNjg2Nzc0NA@@._V1_FMjpg_UX1000_.jpg",null));
        roleRepository.save(new Role(1L,"ROLE_ADMIN",null));
    }
}
