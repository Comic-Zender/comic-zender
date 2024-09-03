package org.zender.comic.presenter.api.category;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.util.UriComponentsBuilder;
import org.zender.comic.appication.category.ICategoryService;
import org.zender.comic.appication.category.commands.CreateCategoryCommand;
import org.zender.comic.appication.category.commands.UpdateCategoryCommand;
import org.zender.comic.domain.category.models.Category;
import org.zender.comic.shared.http.category.request.CreateCategoryRequest;
import org.zender.comic.shared.http.category.request.UpdateCategoryRequest;
import org.zender.common.domain.valueobjects.category.CategoryId;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CategoryController.class)
@Import({CategoryController.class})
@ContextConfiguration(classes = WebMvcConfiguration.class)
public class CategoryControllerTest {
    private static final String URL_PATH = "/api/comic/categories";
    private static final Long ID = 1L;
    private static final String NAME = "name";
    private static final Instant CREATED_AT = Instant.now();
    private static final Instant UPDATED_AT = Instant.now();


    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ICategoryService categoryService;

    @Test
    void shouldReturnCategory_whenFindById() throws Exception {
        // Arrange
        Category categoryMock = getCategory();
        when(categoryService.findById(any())).thenReturn(categoryMock);
        String uri = UriComponentsBuilder.fromPath(URL_PATH).pathSegment("{id}").buildAndExpand(new HashMap<>() {
            {
                this.put("id", ID);
            }
        }).toUriString();
        // Act
        ResultActions resultActions = mockMvc.perform(get(uri).accept(MediaType.APPLICATION_JSON));
        // Assert
        verify(categoryService, times(1)).findById(any());
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(ID))
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andExpect(jsonPath("$.data.createdAt").value(CREATED_AT.toEpochMilli()))
                .andExpect(jsonPath("$.data.updatedAt").value(UPDATED_AT.toEpochMilli()));
    }

    @Test
    void shouldReturnCategory_findAll() throws Exception {
        // Arrange
        Category categoryMock = getCategory();
        List<Category> listCategoryMock = List.of(categoryMock);
        when(categoryService.findAll()).thenReturn(listCategoryMock);
        String uri = UriComponentsBuilder.fromPath(URL_PATH).toUriString();
        // Act
        ResultActions resultActions = mockMvc.perform(get(uri).accept(MediaType.APPLICATION_JSON));
        // Assert
        verify(categoryService, times(1)).findAll();
        resultActions.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.size()").value(listCategoryMock.size()))
                .andExpect(jsonPath("$.data[0].id").value(categoryMock.getId().getValue()))
                .andExpect(jsonPath("$.data[0].name").value(categoryMock.getName()))
                .andExpect(jsonPath("$.data[0].createdAt").value(categoryMock.getCreatedAt().toEpochMilli()))
                .andExpect(jsonPath("$.data[0].updatedAt").value(categoryMock.getUpdatedAt().toEpochMilli()));
    }

    @Test
    void shouldReturnCategory_whenCreate() throws Exception {
        // Arrange
        Category categoryMock = getCategory();
        CreateCategoryRequest requestMock = new CreateCategoryRequest(NAME);
        when(categoryService.save(any())).thenReturn(categoryMock);
        String uri = UriComponentsBuilder.fromPath(URL_PATH).toUriString();
        // Act
        ResultActions resultActions = mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(requestMock)));
        // Assert
        ArgumentCaptor<CreateCategoryCommand> commandArgumentCaptor = ArgumentCaptor.forClass(CreateCategoryCommand.class);
        verify(categoryService, times(1)).save(commandArgumentCaptor.capture());
        CreateCategoryCommand commandCapture = commandArgumentCaptor.getValue();
        assertEquals(requestMock.name(), commandCapture.getName());
        resultActions.andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").value(ID))
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andExpect(jsonPath("$.data.createdAt").value(CREATED_AT.toEpochMilli()))
                .andExpect(jsonPath("$.data.updatedAt").value(UPDATED_AT.toEpochMilli()))
        ;
    }

    @Test
    void shouldReturnCategory_whenUpdate() throws Exception {
        // Arrange
        Category categoryMock = getCategory();
        UpdateCategoryRequest requestMock = new UpdateCategoryRequest(NAME);
        when(categoryService.update(any(), any(UpdateCategoryCommand.class))).thenReturn(categoryMock);
        String uri = UriComponentsBuilder.fromPath(URL_PATH)
                .pathSegment("{id}").buildAndExpand(new HashMap<>() {{
                    this.put("id", ID);
                }}).toUriString();
        // Act
        ResultActions resultActions = mockMvc.perform(put(uri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsBytes(requestMock)));
        // Assert
        ArgumentCaptor<UpdateCategoryCommand> commandArgumentCaptor = ArgumentCaptor.forClass(UpdateCategoryCommand.class);
        verify(categoryService, times(1)).update(any(), commandArgumentCaptor.capture());
        UpdateCategoryCommand commandInput = commandArgumentCaptor.getValue();
        assertEquals(NAME, commandInput.getName());
        resultActions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").value(ID))
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andExpect(jsonPath("$.data.createdAt").value(CREATED_AT.toEpochMilli()))
                .andExpect(jsonPath("$.data.updatedAt").value(UPDATED_AT.toEpochMilli()));
    }

    private Category getCategory() {
        return Category.builder()
                .id(new CategoryId(ID))
                .name(NAME)
                .createdAt(CREATED_AT)
                .updatedAt(UPDATED_AT)
                .build();
    }
}
