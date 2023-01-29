package com.catchmind.catchtable.service;

import com.catchmind.catchtable.dto.ProfileDto;
import com.catchmind.catchtable.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProfileLogicService{
    private final ProfileRepository profileRepository;

    public ProfileDto login(String prHp, String prUserpw){
        return profileRepository.findByPrHpAndPrUserpw(prHp,prUserpw).map(ProfileDto::from).orElseThrow(
                () -> new EntityNotFoundException("회원이없습니다!"));
    }

    public ProfileDto getProfileElements(Long prIdx){
        return profileRepository.findById(prIdx)
                .map(ProfileDto::from)
                .orElseThrow(() -> new EntityNotFoundException("유저가 없는데여 - prIdx :" + prIdx));
    }
}
