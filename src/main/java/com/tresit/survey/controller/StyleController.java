package com.tresit.survey.controller;

import com.tresit.survey.dto.out.ResultOutDto;
import com.tresit.survey.exception.model.ErrorModel;
import com.tresit.survey.business.IStyleBusiness;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
@Slf4j
@Tag(name = "Style", description = "Style controller")
public class StyleController {

    @Autowired
    private IStyleBusiness iStyleBusiness;

    @GetMapping(path = "/style/all", produces = "application/json")
    @Operation(summary = "Get method")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Successful Operation", content = @Content(schema = @Schema(implementation = ResultOutDto.class))),
            @ApiResponse(responseCode = "201", description = "success Operation", content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "400", description  = "Bad Request/Invalid Arguments", content = @Content(schema = @Schema(implementation = ErrorModel.class))),
            @ApiResponse(responseCode = "401", description = "Unauthenticated (invalid credentials, retry login). The request does not have valid authentication credentials for the operation."),
            @ApiResponse(responseCode = "404", description  = "Not found (Resource not found, invalid url, including invalid RPCs)"),
            @ApiResponse(responseCode = "500", description  = "Internal errors. This means that some invariants expected by the underlying system have been broken. This error code is reserved for serious errors."),
    })
    public ResponseEntity<Object> getAllStyles() {
        return new ResponseEntity<>(iStyleBusiness.getAllStyles(), HttpStatus.OK);
    }

}
