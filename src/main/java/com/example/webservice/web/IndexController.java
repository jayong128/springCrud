package com.example.webservice.web;

import com.example.webservice.config.auth.dto.SessionUser;
import com.example.webservice.domain.posts.Posts;
import com.example.webservice.service.PostsService;
import com.example.webservice.web.dto.PostsResponseDto;
import com.example.webservice.web.dto.PostsSaveRequestDto;
import com.example.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @PostConstruct
    public void init() {
        postsService.save(new PostsSaveRequestDto("title1", "author1", "content1"));
        postsService.save(new PostsSaveRequestDto("title2", "author2", "content2"));
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Posts> all = postsService.findAll();
        model.addAttribute("posts", all);
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("username", user.getName());
        }
        return "index2";
    }

    @PostMapping("/api/v1/posts")
    public String save(PostsSaveRequestDto requestDto) {
        postsService.save(requestDto);
        return "redirect:/";
    }

    @GetMapping("/posts/save")
    public String saveForm() {
        return "saveForm";
    }

    @GetMapping("/posts/update/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "updateForm";
    }

    @PostMapping("/api/v1/posts/{id}")
    public String update(@PathVariable Long id, PostsUpdateRequestDto requestDto) {
        postsService.update(id, requestDto);
        return "redirect:/";
    }
}
