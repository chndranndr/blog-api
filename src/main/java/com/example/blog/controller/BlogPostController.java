package com.example.blog.controller;

import com.example.blog.entities.BlogPost;
import com.example.blog.repositories.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController {
    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost createdBlogPost = blogPostRepository.save(blogPost);
        return new ResponseEntity<>(createdBlogPost, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable Long id) {
        Optional<BlogPost> blogPost = blogPostRepository.findById(id);
        return blogPost.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<BlogPost>> getAllBlogPosts(Pageable pageable) {
        Page<BlogPost> blogPosts = blogPostRepository.findAll(pageable);
        return new ResponseEntity<>(blogPosts, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost updatedBlogPost) {
        Optional<BlogPost> existingBlogPost = blogPostRepository.findById(id);
        if (existingBlogPost.isPresent()) {
            BlogPost blogPost = existingBlogPost.get();
            blogPost.setTitle(updatedBlogPost.getTitle());
            blogPost.setBody(updatedBlogPost.getBody());
            blogPost.setAuthor(updatedBlogPost.getAuthor());
            blogPostRepository.save(blogPost);
            return new ResponseEntity<>(blogPost, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        Optional<BlogPost> blogPost = blogPostRepository.findById(id);
        if (blogPost.isPresent()) {
            blogPostRepository.delete(blogPost.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
