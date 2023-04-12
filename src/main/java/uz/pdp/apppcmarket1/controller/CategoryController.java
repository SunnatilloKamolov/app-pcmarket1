package uz.pdp.apppcmarket1.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apppcmarket1.entity.Category;
import uz.pdp.apppcmarket1.payload.CategoryDto;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.service.CategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping
    public HttpEntity<Result> addCategory(@Valid @RequestBody CategoryDto categoryDto){
        Result result = categoryService.addCategory(categoryDto);
        return ResponseEntity.status(result.isSuccess()? 201:409).body(result);
    }@GetMapping
    public ResponseEntity<List<Category>> getCategories(){

         List<Category>categories=categoryService.getCategories();
         return ResponseEntity.ok(categories);
    }
    @GetMapping("/{id}")
    public HttpEntity<Category> getCategoryById(@PathVariable Integer id){
        Category category = categoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping
    public HttpEntity<Result> deleteCategory(@PathVariable Integer id){
        Result result = categoryService.deleteCategory(id);
        return ResponseEntity.status(result.isSuccess()? 202:409).body(result);
    }@PutMapping
    public HttpEntity<Result> editCategory(@PathVariable Integer id,@Valid @RequestBody CategoryDto categoryDto){
        Result result = categoryService.editCategory(categoryDto, id);
        return ResponseEntity.status(result.isSuccess()? 202:409).body(result);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
