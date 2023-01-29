package com.catchmind.catchtable.service;

import com.catchmind.catchtable.domain.Ask;
import com.catchmind.catchtable.domain.network.request.AskRequest;
import com.catchmind.catchtable.domain.network.request.ImprovementRequest;
import com.catchmind.catchtable.dto.AskDto;
import com.catchmind.catchtable.dto.ImprovementDto;
import com.catchmind.catchtable.dto.NoticeDto;
import com.catchmind.catchtable.dto.ReserveDto;
import com.catchmind.catchtable.repository.AskRepository;
import com.catchmind.catchtable.repository.ImprovementRepository;
import com.catchmind.catchtable.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j  // 로그를 찍기 위해서 사용하는 어노테이션
@Transactional
@RequiredArgsConstructor
@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final AskRepository askRepository;
    private final ImprovementRepository improvementRepository;

    @Transactional
    public NoticeDto getNotice(Long noIdx) {
        return noticeRepository.findById(noIdx).map(NoticeDto::from).orElseThrow();
    }

    public String saveFile(AskRequest askRequest){
        AskDto newAsk = askRequest.of(askRequest.askTitle(), askRequest.askContent(), askRequest.prIdx(), askRequest.askAnswer()).toDto();
        askRepository.save(newAsk.toEntity());
        return null;
    }

    public String saveImprovementFile(ImprovementRequest improvementRequest){       // saveImprovementFile 이렇게 안하니까 버튼 클릭 두번해야 페이지 넘어가고 데이터 두번 저장됨
        ImprovementDto newImprovement = improvementRequest.of(improvementRequest.impTitle(),
                improvementRequest.impContent(), improvementRequest.prIdx(), improvementRequest.impAnswer()).toDto();
        improvementRepository.save(newImprovement.toImprovementEntity());
        return null;
    }

}
