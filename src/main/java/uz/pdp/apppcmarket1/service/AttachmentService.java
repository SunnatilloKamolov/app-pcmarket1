package uz.pdp.apppcmarket1.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pdp.apppcmarket1.entity.Attachment;
import uz.pdp.apppcmarket1.entity.AttachmentContent;
import uz.pdp.apppcmarket1.repository.AttachmentContentRepository;
import uz.pdp.apppcmarket1.repository.AttachmentRepository;

import javax.xml.transform.Result;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;
    @SneakyThrows
    public uz.pdp.apppcmarket1.payload.Result uploadFile(MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment=new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);
        AttachmentContent attachmentContent=new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepository.save(attachmentContent);
        return new uz.pdp.apppcmarket1.payload.Result("Fayl saqlandi",true,savedAttachment.getId());
    }
    public List<Attachment> getAttachments(){
        return attachmentRepository.findAll();
    }
    public Attachment getAttachmentById(Integer id){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent())
            return optionalAttachment.get();
        return null;
    }
    public Result deleteAttachment(Integer id){
        attachmentRepository.deleteById(id);
        return (Result) new uz.pdp.apppcmarket1.payload.Result("Obyekt o'chirildi",true);

    }
    public Result editAttachment(Attachment attachment,Integer id){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()){
            Attachment attachment1 = optionalAttachment.get();
            attachment1.setName(attachment1.getName());
            attachment1.setSize(attachment1.getSize());
            attachment1.setContentType(attachment1.getContentType());
            attachmentRepository.save(attachment1);
            return (Result) new uz.pdp.apppcmarket1.payload.Result("Attachment edited",true);
        }return (Result)new uz.pdp.apppcmarket1.payload.Result("attachment not found",false);
    }
}
