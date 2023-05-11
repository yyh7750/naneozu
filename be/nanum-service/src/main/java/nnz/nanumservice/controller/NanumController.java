package nnz.nanumservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.eello.nnz.common.dto.PageDTO;
import lombok.RequiredArgsConstructor;
import nnz.nanumservice.dto.NanumInfoDTO;
import nnz.nanumservice.dto.res.nanum.ResNanumDetailDTO;
import nnz.nanumservice.service.CertificationService;
import nnz.nanumservice.service.NanumService;
import nnz.nanumservice.vo.NanumCertificationVO;
import nnz.nanumservice.vo.NanumVO;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/nanum-service/nanums")
@RequiredArgsConstructor
public class NanumController {

    private final NanumService nanumService;
    private final CertificationService certificationService;

    @PostMapping
    public ResponseEntity<Void> createNanum(
            @RequestPart(name = "data") NanumVO data,
            @RequestPart(name = "images") List<MultipartFile> images
    ) {
        try {
            nanumService.createNanum(data, images);
        } catch (JsonProcessingException e) {
            // todo: error handling
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageDTO> readNanumsByShowId(
            @RequestParam(name = "showId") Long showId,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "20") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return new ResponseEntity<>(nanumService.readNanumsByShowId(showId, pageRequest), HttpStatus.OK);
    }

    @GetMapping("/tag")
    public ResponseEntity<PageDTO> readNanumsByNanumTag(
            @RequestParam(name = "tag") String nanumTagName,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "20") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return new ResponseEntity<>(nanumService.readNanumsByNanumTag(nanumTagName, pageRequest), HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity<PageDTO> readNanumsByLocation(
            @RequestParam(name = "lat") Double lat,
            @RequestParam(name = "lng") Double lng,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "20") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return new ResponseEntity<>(nanumService.readNanumsByLocation(lat, lng, pageRequest), HttpStatus.OK);
    }

    @PostMapping("/{nanumId}/info")
    public ResponseEntity<Void> createNanumInfo(
            @PathVariable(name = "nanumId") Long nanumId,
            @RequestBody NanumInfoDTO nanumInfoDTO) {
        nanumService.createNanumInfo(nanumId, nanumInfoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{nanumId}/info")
    public ResponseEntity<NanumInfoDTO> createNanumInfo(@PathVariable(name = "nanumId") Long nanumId) {
        return new ResponseEntity<>(nanumService.readNanumInfo(nanumId), HttpStatus.OK);
    }

    @GetMapping("/{nanumId}")
    public ResponseEntity<ResNanumDetailDTO> readNanumDetail(
            @PathVariable(name = "nanumId") Long nanumId,
            @RequestHeader(name = "userId") Long userId) {
        return new ResponseEntity<>(nanumService.readNanumDetail(nanumId, userId), HttpStatus.OK);
    }

    @PostMapping("/{nanumId}/certification")
    public ResponseEntity<?> handleNanumCertification(@PathVariable("nanumId") Long nanumId,
                                                 @RequestBody NanumCertificationVO nanumCertificationVO){
        certificationService.handleNanumCertification(nanumId, nanumCertificationVO);
        return ResponseEntity.noContent().build();
    }


}