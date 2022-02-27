package hu.ak_akademia.spring_boot_rest.controller.api;

import hu.ak_akademia.spring_boot_rest.domain.dto.input.AnimalInputDto;
import hu.ak_akademia.spring_boot_rest.domain.dto.output.AnimalOutputDto;
import hu.ak_akademia.spring_boot_rest.domain.dto.output.exception.ExceptionOutputDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static javax.servlet.http.HttpServletResponse.*;

@Api(tags = "Animal Controller")
@RequestMapping("/animals")
@Validated
public interface AnimalController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Returns all animals resources.")
    @ApiResponses({
            @ApiResponse(code = SC_OK, message = "Animal returned", responseContainer = "List", response = AnimalOutputDto.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error", response = ExceptionOutputDto.class)
    })
    ResponseEntity<List<AnimalOutputDto>> fetchAll();

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Saves animal.")
    @ApiResponses({
            @ApiResponse(code = SC_CREATED, message = "Animal added", response = AnimalOutputDto.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error", response = ExceptionOutputDto.class)
    })
    ResponseEntity<?> save(@Valid @RequestBody AnimalInputDto animalInputDto);


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Returns animal by id.")
    @ApiResponses({
            @ApiResponse(code = SC_OK, message = "Animal returned", response = AnimalOutputDto.class),
            @ApiResponse(code = SC_NOT_FOUND, message = "Animal not found", response = ExceptionOutputDto.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error", response = ExceptionOutputDto.class)
    })
    ResponseEntity<AnimalOutputDto> fetchById(@PathVariable("id") Integer id);

    @DeleteMapping(path = "/{id}")
    @ApiOperation("Deletes animal by id.")
    @ApiResponses({
            @ApiResponse(code = SC_OK, message = "Animal deleted", response = AnimalOutputDto.class),
            @ApiResponse(code = SC_NOT_FOUND, message = "Animal not found", response = ExceptionOutputDto.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error", response = ExceptionOutputDto.class)
    })
    ResponseEntity<?> delete(@Positive @PathVariable("id") Integer id);

    @PatchMapping(path = "/{id}")
    @ApiOperation("updates given id animal by given parameters.")
    @ApiResponses({
            @ApiResponse(code = SC_OK, message = "Animal updated", response = AnimalOutputDto.class),
            @ApiResponse(code = SC_NOT_FOUND, message = "Animal not found", response = ExceptionOutputDto.class),
            @ApiResponse(code = SC_NO_CONTENT, message = "Animal was already updated.", response = ExceptionOutputDto.class),
            @ApiResponse(code = SC_INTERNAL_SERVER_ERROR, message = "Internal Server Error", response = ExceptionOutputDto.class)
    })
    ResponseEntity<?> patch(@PathVariable("id") Integer id, @RequestBody Map<String, Object> parametersToUpdate);
}
