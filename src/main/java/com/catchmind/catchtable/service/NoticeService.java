package com.catchmind.catchtable.service;

import com.catchmind.catchtable.domain.Ask;
import com.catchmind.catchtable.domain.network.request.AskRequest;
import com.catchmind.catchtable.dto.AskDto;
import com.catchmind.catchtable.repository.AskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j  // 로그를 찍기 위해서 사용하는 어노테이션
@Transactional
@RequiredArgsConstructor
@Service
public class NoticeService {

    private final AskRepository askRepository;

    public String saveFile(AskRequest askRequest){
        AskDto newAsk = askRequest.of(askRequest.askTitle(), askRequest.askContent(), askRequest.prIdx(), askRequest.askAnswer()).toDto();
        askRepository.save(newAsk.toEntity());
        return null;
    }

}
