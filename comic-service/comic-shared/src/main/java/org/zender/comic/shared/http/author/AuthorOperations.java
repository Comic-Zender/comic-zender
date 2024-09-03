package org.zender.comic.shared.http.author;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.zender.comic.shared.http.author.request.CreateAuthorRequest;
import org.zender.comic.shared.http.author.request.UpdateAuthorRequest;
import org.zender.comic.shared.http.author.response.AuthorResponse;
import org.zender.common.rest.response.BaseResponse;

import java.util.List;

public interface AuthorOperations {
    @GetMapping("/api/comic/authors")
    @ResponseStatus(HttpStatus.OK)
    BaseResponse<List<AuthorResponse>> findAll();

    @GetMapping("/api/comic/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    BaseResponse<AuthorResponse> findById(@PathVariable Long id);

    @PostMapping("/api/comic/authors")
    @ResponseStatus(HttpStatus.CREATED)
    BaseResponse<AuthorResponse> create(@RequestBody CreateAuthorRequest request);

    @PutMapping("/api/comic/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    BaseResponse<AuthorResponse> update(@PathVariable Long id, @RequestBody UpdateAuthorRequest request);

    @DeleteMapping("/api/comic/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    BaseResponse<Void> delete(@PathVariable Long id);
}
