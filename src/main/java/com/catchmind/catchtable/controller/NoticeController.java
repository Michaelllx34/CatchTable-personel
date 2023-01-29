package com.catchmind.catchtable.controller;

import com.catchmind.catchtable.domain.network.request.AskRequest;
import com.catchmind.catchtable.domain.network.request.ImprovementRequest;
import com.catchmind.catchtable.dto.*;
import com.catchmind.catchtable.dto.security.CatchPrincipal;
import com.catchmind.catchtable.repository.AskRepository;
import com.catchmind.catchtable.repository.ImprovementRepository;
import com.catchmind.catchtable.repository.NoticeRepository;
import com.catchmind.catchtable.service.NoticeService;
import com.catchmind.catchtable.service.ProfileLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeRepository noticeRepository;
    private final AskRepository askRepository;
    private final ImprovementRepository improvementRepository;
    private final NoticeService noticeService;
    private final ProfileLogicService profileLogicService;

    // 공지사항 리스트 페이지
    @GetMapping("/notice")
    public String notice(Model model) {
        List<NoticeDto> noticeDtoList = noticeRepository.findAll().stream().map(NoticeDto::from).toList();
        model.addAttribute("notice", noticeDtoList);
        return "notice/notice";
    }

    //공지사항 상세
    @GetMapping("/notice/content/{noIdx}")
    public String noticeContent(Model model, @PathVariable Long noIdx) {
//        List<NoticeDto> noticeDtoList = noticeRepository.findAll().stream().map(NoticeDto::from).toList();
        NoticeDto noticeDto = noticeService.getNotice(noIdx);
        model.addAttribute("content", noticeDto);
//        model.addAttribute("content", noticeDtoList);
        return "notice/notice_review";
    }

    // 이용약관
    @GetMapping("/support/tmp1")
    public ModelAndView supportTmp1() {
        return new ModelAndView("notice/termOfService1");
    }

    //개인정보 처리방침
    @GetMapping("/support/tmp2")
    public ModelAndView supportTmp2() {
        return new ModelAndView("notice/termOfService2");
    }
    
    // 위치정보
    @GetMapping("/support/tmp3")
    public ModelAndView supportTmp3() {
        return new ModelAndView("notice/termOfService3");
    }

    // 1대1문의 리스트
    @GetMapping("/support/contact")
    public String contact(Model model, @AuthenticationPrincipal CatchPrincipal catchPrincipal) {
        Long prIdx = catchPrincipal.prIdx();
        List<AskDto> askDtoList = askRepository.findAllByProfile_PrIdx(prIdx).stream().map(AskDto::from).toList();
        model.addAttribute("notice", askDtoList);
        return "notice/contact1";
    }

    // 1대1문의 작성
    @GetMapping("/support/contact/write")
    public String contactWrite(Model model, @AuthenticationPrincipal CatchPrincipal catchPrincipal) {
        Long prIdx = catchPrincipal.prIdx();
        model.addAttribute("prIdx", prIdx);
        return "notice/contact2";
    }

    // 1대1문의 작성 내용 저장
    @PostMapping("/support/contact/write")
    public String contactWrite(AskRequest askRequest) {
        noticeService.saveFile(askRequest);
        return "redirect:/support/contact";         // support로 수정
    }
    
    // 개선제안 리스트
    @GetMapping("/support/improve")
    public String improve(Model model, @AuthenticationPrincipal CatchPrincipal catchPrincipal) {
        Long prIdx = catchPrincipal.prIdx();
        List<ImprovementDto> improvementDtoList = improvementRepository.findAllByProfile_PrIdx(prIdx).stream().map(ImprovementDto::from).toList();
        model.addAttribute("notice", improvementDtoList);
        return "notice/improve1";
    }

    //개선제안 작성
    @GetMapping("/support/improve/write")
    public String improveWrite(Model model, @AuthenticationPrincipal CatchPrincipal catchPrincipal) {
        Long prIdx = catchPrincipal.prIdx();
        model.addAttribute("prIdx", prIdx);
        return "notice/improve2";
    }

    // 개선제안 작성 내용 저장
    @PostMapping("/support/improve/write")
    public String improveWrite(ImprovementRequest improvementRequest) {
        noticeService.saveImprovementFile(improvementRequest);
        return "redirect:/support/improve";     // 돌아가자마자 status값이 null 이라서 리스트페이지에서 오류인듯   // support로 수정
    }

    // 신고내역
    @GetMapping("/report/list")
    public ModelAndView reportList() {
        return new ModelAndView("notice/report_list");
    }

    // 리뷰 신고
    @GetMapping("/report/review")
    public ModelAndView reportReview() {
        return new ModelAndView("notice/report_review");
    }    

    // 댓글 신고
    @GetMapping("/report/comment")
    public ModelAndView reportReply() {
        return new ModelAndView("notice/report_comment");
    }
}
