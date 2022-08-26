package com.example.webservice.web.dto;

import com.example.webservice.domain.posts.Posts;
import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String author;
    private String content;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder().title(title)
                .content(content).author(author).build();
    }
}
