package uz.pdp.apppcmarket1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.apppcmarket1.entity.Attachment;
import uz.pdp.apppcmarket1.payload.Result;
import uz.pdp.apppcmarket1.service.AttachmentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request) {
        Result result = attachmentService.uploadFile(request);
        return result;
    }

    @GetMapping
    public List<Attachment> getAttachments() {
        List<Attachment> attachmentList = attachmentService.getAttachments();
        return attachmentList;}
        @GetMapping("/{id}")
        public Attachment getAttachmentById(@PathVariable Integer id){
            Attachment attachmentById = attachmentService.getAttachmentById(id);
            return attachmentById;
        }

    @DeleteMapping
    public Result deleteAttachment(@PathVariable Integer id) {
        Result result = (Result) attachmentService.deleteAttachment(id);
        return result;
    }

    @PutMapping
    public Result editAttachment(@RequestBody Attachment attachment, @PathVariable Integer id) {
        Result result = (Result) attachmentService.editAttachment(attachment, id);
        return result;
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
