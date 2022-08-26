package com.example.webservice.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글불러오기() {
        //given
        String title = "title ex";
        String content = "content ex";

        postsRepository.save(Posts.builder().title(title).content(content).author("ex@gmail.com").build());
        //when
        List<Posts> all = postsRepository.findAll();

        //then
        Posts posts = all.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void 시간등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("title")
                .author("author").content("content").build());

        //when
        List<Posts> all = postsRepository.findAll();
        //then
        Posts posts = all.get(0);
        System.out.println("posts.getCreatedData() = " + posts.getCreatedDate());
        Assertions.assertThat(posts.getCreatedDate()).isAfter(now);
        System.out.println("posts.getModifiedDate() = " + posts.getModifiedDate());
    }
}