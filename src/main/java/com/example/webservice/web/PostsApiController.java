package com.example.webservice.web;

import com.example.webservice.service.PostsService;
import com.example.webservice.web.dto.PostsResponseDto;
import com.example.webservice.web.dto.PostsSaveRequestDto;
import com.example.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsApiController {
    private final PostsService postsService;
//
//    @PostMapping("/api/v1/posts")
//    public Long save(PostsSaveRequestDto requestDto) {
//        return postsService.save(requestDto);
//    }

//    @PostMapping("/api/v1/posts/{id}")
//    public Long update(@PathVariable Long id,PostsUpdateRequestDto requestDto) {
//        return postsService.update(id, requestDto);
//    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long deleteApi(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
