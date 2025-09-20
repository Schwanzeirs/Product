package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.dataDto.DeleteResponse;
import com.product.dto.request.ProductRequest;
import com.product.dto.response.ApiResponse;
import com.product.dto.response.HeaderResponse;
import com.product.services.ProductService;
import com.product.util.ResponseBuilder;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @Autowired
    private ResponseBuilder responseBuilder;

    @PostMapping
    public ResponseEntity<HeaderResponse> insert(@RequestBody ProductRequest request) {
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                productService.insert(request)
            )
        );
    }

    @GetMapping
    public ResponseEntity<HeaderResponse> find(@RequestParam Long id) {
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                productService.find(id)
            )
        );
    }

    @GetMapping("/variant")
    public ResponseEntity<HeaderResponse> findById(@RequestParam Long id) {
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                productService.findVariant(id)
            )
        );
    }

    @DeleteMapping("/variant")
    public ResponseEntity<HeaderResponse> deleteVariant(@RequestParam Long id) {
        productService.deleteVariant(id);
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                new DeleteResponse("Successfully delete variant id : " + id)
            )
        );
    }

    @DeleteMapping
    public ResponseEntity<HeaderResponse> deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return responseBuilder.buildSuccessResponse(
            new ApiResponse(
                200, 
                "Success", 
                new DeleteResponse("Successfully delete product id : " + id)
            )
        );
    }
}
