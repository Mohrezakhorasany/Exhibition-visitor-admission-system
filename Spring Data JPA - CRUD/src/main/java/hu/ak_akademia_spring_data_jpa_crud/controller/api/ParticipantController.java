package hu.ak_akademia_spring_data_jpa_crud.controller.api;

import hu.ak_akademia_spring_data_jpa_crud.domain.dto.input.ParticipantInputDto;
import hu.ak_akademia_spring_data_jpa_crud.domain.dto.output.ParticipantOutputDto;
import hu.ak_akademia_spring_data_jpa_crud.domain.dto.output.exception.ExceptionOutputDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static javax.servlet.http.HttpServletResponse.*;

@Api(tags = "Participant Controller")
@RequestMapping("/participants")
@Validated
public interface ParticipantController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = SC_OK, message = "Participant returned", responseContainer = "List", response = ParticipantOutputDto.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error", response = ExceptionOutputDto.class)
    })
    ResponseEntity<?> save(@Valid @RequestBody ParticipantInputDto ParticipantInputDto);

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Returns participant by id.")
    @ApiResponses({
            @ApiResponse(code = SC_OK, message = "Person returned", response = ParticipantOutputDto.class),
            @ApiResponse(code = SC_NOT_FOUND, message = "Person not found", response = ExceptionOutputDto.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error", response = ExceptionOutputDto.class)
    })
    ResponseEntity<ParticipantOutputDto> findById(Integer id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Returns all participants resources.")
    @ApiResponses({
            @ApiResponse(code = SC_OK, message = "People returned", responseContainer = "List", response = ParticipantOutputDto.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error", response = ExceptionOutputDto.class)
    })
    ResponseEntity<List<ParticipantOutputDto>> findAll();

    @PatchMapping(path = "/{id}")
    ResponseEntity<?> update(ParticipantInputDto ParticipantInputDto);

    @DeleteMapping(path = "/{id}")
    ResponseEntity<?> delete(Integer id);
}
