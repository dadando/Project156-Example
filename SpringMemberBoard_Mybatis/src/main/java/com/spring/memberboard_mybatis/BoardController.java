package com.spring.memberboard_mybatis;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	@RequestMapping("/boardlist.bo")
	public String boardlist(HttpServletRequest request,Model model) throws Exception{
		boardService.getBoardList(request,model);
		
		return "board_list";
	}
	@RequestMapping("/boardwrite.bo")
	public String boardwrite() throws Exception{
				
		return "board_write";
	}
/*	
	@RequestMapping("/boardwrite.bo")
	public String boardwrite(BoardVO bvo,Model model) throws Exception{
		model.addAttribute("id",bvo.getId());
		
		return "board_write";
	}
*/
	
	@RequestMapping("/boardinsert.bo")
	public String boardinsert(BoardVO bvo,HttpServletResponse response) throws Exception{
		//------------파일 업로드 부분--------------
		MultipartFile mf = bvo.getFile();
		
		if(!(mf.getOriginalFilename().equals(""))) {
			String uploadPath = "C:\\Project156\\upload\\";
			
			String originalFileExtension = mf.getOriginalFilename().substring(mf.getOriginalFilename().indexOf("."));
			String storedFileName = UUID.randomUUID().toString().replaceAll("-", "")+originalFileExtension;
			//지정한 주소에 파일 저장
			if(mf.getSize() !=0 ) {
				//mf.transferTo(new File(uploadPath+"/"+mf.getOriginalFilename());
				mf.transferTo(new File(uploadPath + storedFileName)); //예외처리
			}
			bvo.setOrg_file(mf.getOriginalFilename());
			bvo.setUp_file(storedFileName);
			
		}
		int res = boardService.boardInsert(bvo);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		if(res!=0) {
			writer.write("<script>alert('글 작성 성공!!');"
					+"location.href='./boardlist.bo';</script>");
		}else {
			writer.write("<script>alert('글 입력 실패!!');"
					+"location.href='./boardwrite.bo';</script>");
		}
		
		return null;
	}
	
	@RequestMapping("/boarddetail.bo")
	public String boarddetail(BoardVO bvo, Model model)throws Exception {
		BoardVO vo = boardService.getDetail(bvo);
		model.addAttribute("bvo",vo);
		
		return "board_view";
	}
	
	@RequestMapping("/boraddelete.bo")
	public String boarddelete(BoardVO bvo)throws Exception{
		boardService.boardDelete(bvo);
		
		return "redirect:/boardlist.bo";
	}
	
	@RequestMapping("/boardreplyform.bo")
	public String replyform(BoardVO bvo,Model model)throws Exception{
		BoardVO vo = boardService.getDetail(bvo);
		model.addAttribute("bvo",vo);
		
		return "board_reply";
	}
	
	
	@RequestMapping("/boardreply.bo")
	public void boardreply(BoardVO bvo,HttpServletResponse response)throws Exception{
		int res = boardService.boardReply(bvo);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		if(res!=0) {
			writer.write("<script>alert('답변 성공!!');"
					+"location.href='./boardlist.bo';</script>");
		}else {
			writer.write("<script>alert('답변 실패!!');"
					+"location.href='./boardreplyform.bo';</script>");
		}
	}
	
	@RequestMapping("/boardmodifyform.bo")
	public String modifyform(BoardVO bvo,Model model) throws Exception {
		BoardVO vo = boardService.getDetail(bvo);
		model.addAttribute("vo",vo);
		
		return "board_modify";
	}
	
	@RequestMapping("/boardmodify.bo")
	public void boardmodify(BoardVO bvo,HttpServletResponse response)throws Exception{
		int res = boardService.boardModify(bvo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if(res!=0) {
			writer.write("<script>alert('수정 성공!!');"
					+"location.href='./boardlist.bo';</script>");
		}else {
			writer.write("<script>alert('수정 실패!!');"
					+"location.href='./boardmodifyform.bo';</script>");
		}
	}
	
	//파일 다운로드
	@RequestMapping("/filedownload.bo")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception{
    	response.setCharacterEncoding("utf-8");
    	
    	//String num = request.getParameter("num");
    	String of = request.getParameter("of"); // 서버에 업로드된 변경된 실제 파일명
        String of2 = request.getParameter("of2"); // 오리지날 파일명
        
        /* //웹사이트 루트디렉토리의 실제 디스크상의 경로 알아내기.
        String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
        String fullPath = uploadPath+"/"+of;
        */
        String uploadPath = "C:\\Project156\\upload\\"; // 직접 경로 지정
        String fullPath = uploadPath + of;
        File downloadFile = new File(fullPath);
        
        //파일 다운로드를 위해 컨테츠 타입을 application/download 설정
        response.setContentType("application/download; charset=UTF-8");
        //파일 사이즈 지정
        response.setContentLength((int)downloadFile.length());
        //다운로드 창을 띄우기 위한 헤더 조작
        response.setHeader("Content-Disposition", "attachment;filename="
                                        + new String(of2.getBytes(), "ISO8859_1"));
        response.setHeader("Content-Transfer-Encoding","binary");
        /*
         * Content-disposition 속성
         * 1) "Content-disposition: attachment" 브라우저 인식 파일확장자를 포함하여 모든 확장자의 
         *        파일들에 대해, 다운로드시 무조건 "파일 다운로드" 대화상자가 뜨도록 하는 헤더속성이다
         * 2) "Content-disposition: inline" 브라우저 인식 파일확장자를 가진 파일들에 대해서는 
         *        웹브라우저 상에서 바로 파일을 열고, 그외의 파일들에 대해서는 "파일 다운로드" 대화상자가
         *        뜨도록 하는 헤더속성이다.
         */
 
        FileInputStream fin = new FileInputStream(downloadFile);
        ServletOutputStream sout = response.getOutputStream();

        byte[] buf = new byte[1024];
        int size = -1;

        while ((size = fin.read(buf, 0, buf.length)) != -1) {
            sout.write(buf, 0, size);
        }
        fin.close();
        sout.close();
    }

}
