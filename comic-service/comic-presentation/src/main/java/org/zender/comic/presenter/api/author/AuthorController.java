package org.zender.comic.presenter.api.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.zender.comic.appication.author.IAuthorService;
import org.zender.comic.domain.author.models.Author;
import org.zender.comic.presenter.api.author.mappers.AuthorRestMapper;
import org.zender.comic.shared.http.author.AuthorOperations;
import org.zender.comic.shared.http.author.request.CreateAuthorRequest;
import org.zender.comic.shared.http.author.request.UpdateAuthorRequest;
import org.zender.comic.shared.http.author.response.AuthorResponse;
import org.zender.common.domain.valueobjects.author.AuthorId;
import org.zender.common.rest.response.BaseResponse;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController implements AuthorOperations {
    private final IAuthorService authorService;

    @Override
    public BaseResponse<AuthorResponse> findById(Long id) {
        Author author = authorService.findById(new AuthorId(id));
        return BaseResponse.success(AuthorRestMapper.INSTANCE.modelToResponse(author));
    }

    @Override
    public BaseResponse<AuthorResponse> create(CreateAuthorRequest request) {
        Author author = authorService.create(AuthorRestMapper.INSTANCE.requestToCommand(request));
        return BaseResponse.success(AuthorRestMapper.INSTANCE.modelToResponse(author));
    }

    @Override
    public BaseResponse<List<AuthorResponse>> findAll() {
        List<Author> authors = authorService.findAll();
        return BaseResponse.success(authors.stream().map(AuthorRestMapper.INSTANCE::modelToResponse).toList());
    }

    @Override
    public BaseResponse<AuthorResponse> update(Long id, UpdateAuthorRequest request) {
        Author author = authorService.update(new AuthorId(id), AuthorRestMapper.INSTANCE.requestToCommand(request));
        return BaseResponse.success(AuthorRestMapper.INSTANCE.modelToResponse(author));
    }

    @Override
    public BaseResponse<Void> delete(Long id) {
        authorService.delete(new AuthorId(id));
        return BaseResponse.success(null);
    }
}
