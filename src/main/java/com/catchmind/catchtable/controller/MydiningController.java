package com.catchmind.catchtable.controller;

import com.catchmind.catchtable.domain.Reserve;
import com.catchmind.catchtable.domain.Review;
import com.catchmind.catchtable.domain.type.ReservationType;
import com.catchmind.catchtable.dto.ReserveDto;
import com.catchmind.catchtable.repository.ReserveRepository;
import com.catchmind.catchtable.service.MydiningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("mydining")
@RequiredArgsConstructor
public class MydiningController {

    private final ReserveRepository reserveRepository;
    private final MydiningService mydiningService;


    @GetMapping("/planned")
    public String planned(Model model) {
        List<Reserve> reserves = reserveRepository.findAllByresStatus(ReservationType.PLANNED);
        System.out.println(reserves);
        model.addAttribute("list", reserves);
        return "/mydining/planned";
    }

    @GetMapping("/reserve/plannedDetail/{resIdx}")
    public String detail(Model model, @PathVariable("resIdx") Long resIdx) {
        System.out.println(resIdx);
        ReserveDto reserveDto = mydiningService.getDetail(resIdx);
        model.addAttribute("detail", reserveDto);
        System.out.println("reserveDTO->" + reserveDto);
        return "/mydining/plannedDetail";
    }

    @GetMapping("/done")
    public String done(Model model) {
        List<Reserve> reserves = reserveRepository.findAllByresStatus(ReservationType.DONE);
        System.out.println(reserves);
        model.addAttribute("list", reserves);
        return "mydining/done";
    }

//    @PostMapping("/done")
//    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("files") List<MultipartFile> files, FileEntity fileEntity) throws IOException {
//        fileService.saveFile(file, fileEntity);
//
//        for (MultipartFile multipartFile : files) {
//            fileService.saveFile(multipartFile, fileEntity);
//        }
//
//        return "redirect:/mydining/done";
//    }

    @PostMapping("/done")
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("files") List<MultipartFile> files, Review review) throws IOException {
        mydiningService.saveFile(file, review);

        for (MultipartFile multipartFile : files) {
            mydiningService.saveFile(multipartFile, review);
        }

        return "redirect:/mydining/done";
    }

    @GetMapping("/cancel")
    public String cancel(Model model) {
        List<Reserve> reserves = reserveRepository.findAllByresStatus(ReservationType.CANCEL);
        System.out.println(reserves);
        model.addAttribute("list", reserves);
        return "mydining/cancel";
    }

    @GetMapping("/emptySlot")
    public ModelAndView emptySlot() {
        return new ModelAndView("mydining/emptySlot");
    }
    @GetMapping("/reserveOpen")
    public ModelAndView reserveOpen() {
        return new ModelAndView("mydining/reserveOpen");
    }

    @GetMapping("/notifications")
    public ModelAndView notifications() {
        return new ModelAndView("mydining/notifications");
    }
}
