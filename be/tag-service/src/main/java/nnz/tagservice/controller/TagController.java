package nnz.tagservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import nnz.tagservice.dto.TagDTO;
import nnz.tagservice.dto.res.ResTagDTO;
import nnz.tagservice.service.TagService;
import nnz.tagservice.vo.TagVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag-service/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public ResponseEntity<List<TagDTO>> createTag(@RequestBody List<TagVO> tags) {
        try {
            List<TagDTO> createdTags = tagService.createTag(tags);
            return new ResponseEntity<>(createdTags, HttpStatus.CREATED);
        } catch (JsonProcessingException e) {
            // todo : error handling
            throw new RuntimeException();
        }
    }

    @GetMapping
    public ResponseEntity<List<ResTagDTO>> readPopularTags() {
        return new ResponseEntity<>(tagService.readPopularTags(), HttpStatus.OK);
    }

    @GetMapping(value = "/search", produces = "application/json")
    public ResponseEntity<String> readBySearchAllTag(@RequestParam(name = "search") String search) {
        return new ResponseEntity<>(tagService.readBySearchAllTag(search), HttpStatus.OK);
    }
}
