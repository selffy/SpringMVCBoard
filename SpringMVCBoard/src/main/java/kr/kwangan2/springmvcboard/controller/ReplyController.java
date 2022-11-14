package kr.kwangan2.springmvcboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.kwangan2.springmvcboard.domain.Criteria;
import kr.kwangan2.springmvcboard.domain.ReplyPageDTO;
import kr.kwangan2.springmvcboard.domain.ReplyVO;
import kr.kwangan2.springmvcboard.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
@AllArgsConstructor
public class ReplyController {
   @Setter(onMethod_=@Autowired)
   private ReplyService service;
   
//   @GetMapping(value="/pages/{bno}/{page}",
//         produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//   public ResponseEntity<List<ReplyVO>> listReplyVO(
//         @PathVariable("bno") Long bno, @PathVariable("page") int page){
//      Criteria cri = new Criteria(page, 5);
//      return new ResponseEntity<List<ReplyVO>>(service.listReplyVO(cri, bno), HttpStatus.OK);
//   }
   
   @GetMapping(value="/pages/{bno}/{page}",
         produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
   public ResponseEntity<ReplyPageDTO> listReplyVO(
         @PathVariable("bno") Long bno, @PathVariable("page") int page){
      Criteria cri = new Criteria(page, 5);
      return new ResponseEntity<>(service.getListPage(cri, bno), HttpStatus.OK);
   }

   @PostMapping(value="/insert",
         consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
         produces = {MediaType.TEXT_PLAIN_VALUE})
   public ResponseEntity<String> insertReplyVO(@RequestBody ReplyVO replyVO){
      int result = service.insertReplyVO(replyVO);
      return result == 1?
            new ResponseEntity<>("success", HttpStatus.OK):
               new ResponseEntity<>("success", HttpStatus.INTERNAL_SERVER_ERROR);
   }
   
   @GetMapping(value="/{rno}",
         produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
               MediaType.APPLICATION_XML_VALUE})
   public ResponseEntity<ReplyVO> selectReplyVO(@PathVariable("rno") Long rno){
      return new ResponseEntity<>(service.selectReplyVO(rno), HttpStatus.OK);
   }
   
   @DeleteMapping(value="/{rno}",
         produces = {MediaType.TEXT_PLAIN_VALUE})
   public ResponseEntity<String> deleteReplyVO(@PathVariable("rno") Long rno){
      return service.deleteReplyVO(rno) == 1?
            new ResponseEntity<>("success", HttpStatus.OK):
               new ResponseEntity<>("success", HttpStatus.INTERNAL_SERVER_ERROR);
   }
   
   @RequestMapping(
         method = {RequestMethod.PUT, RequestMethod.PATCH},
         value="/{rno}",
         consumes = "application/json",
         produces = {MediaType.TEXT_PLAIN_VALUE})
   public ResponseEntity<String> updateReplyVO(@RequestBody ReplyVO replyVO, @PathVariable("rno") Long rno){
      replyVO.setRno(rno);
      return service.updateReplyVO(replyVO) == 1?
            new ResponseEntity<>("success", HttpStatus.OK):
               new ResponseEntity<>("success", HttpStatus.INTERNAL_SERVER_ERROR);
   }
}