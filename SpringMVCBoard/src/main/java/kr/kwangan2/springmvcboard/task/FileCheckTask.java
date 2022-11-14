package kr.kwangan2.springmvcboard.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.kwangan2.springmvcboard.domain.AttachVO;
import kr.kwangan2.springmvcboard.mapper.BoardAttachMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileCheckTask {

	//매퍼 ㅅ[ㅌ;ㅇ
	@Setter(onMethod_ = {@Autowired})
	private BoardAttachMapper attachMapper;
	
	//어제 날짜의 폴더를 가지고온다
	private String getFolderYesterDay() {
		// 2022-11-09 형식 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //2022-11-09
		//날짜 연산을 위해서 Calendar 객체 생성
		Calendar cal = Calendar.getInstance();
		//하루를 뺀다
		cal.add(Calendar.DATE, -1);
		//하루를 뺀 날짜의 문자열을 구한다 => "2022-11-09"
		String str = sdf.format(cal.getTime());
		// -를 파일구분자(윈도우 \\, 유닉스 /)
 		return str.replace("-", File.separator);
	}
	
	@Scheduled(cron="0 0 2 * * *") // 초 분 시 일 월 요일 (년도) => 매분 0초마다
	public void checkFiles() throws Exception{
		log.warn("File Check Task 작동!!");
		log.warn(new Date());
		//어제 날짜의 파일명들을 db에서 셀렉트해서 리스트로 저장
		List<AttachVO> fileList = attachMapper.getOldFiles();
		
		//각각의 파일명들에 대한 경로를 리스트로 저장
		List<Path> fileListpaths
			= fileList
			//리스트 내 스트림 생성		
			.stream()
			//리스트 내의 각각의 객체에 대해서 해당 파일의 전체경로을 얻어와서
			.map(vo -> Paths.get("C:/upload", vo.getUploadPath(),
					vo.getUuid() + "_" + vo.getFileName()))
			//리스트로 생성
			.collect(Collectors.toList());
		
		fileList
			//전체 경로들을 가진 리스트의 스트림 생성
			.stream()
			//파일타입인 것들만 필터링해서
			.filter(vo -> vo.isFileType() == true)
			//파일타입인 것들의 첨부파일 경로를 매핑
			.map(vo -> Paths.get("C:/upload", vo.getUploadPath(), 
				"thumb_" + vo.getUuid() + "_" + vo.getFileName()))
			//매핑된 각각의 fileListPaths에 추가
			.forEach(p -> log.warn(p));
		
		//츨력
		fileListpaths.forEach(p -> log.warn(p));
		
		//어제 날짜의 디텍토리 구하기("C:/upload/2022/11/09") 
		File targetDir = Paths.get("C:/upload", getFolderYesterDay()).toFile();
		
		// 삭제할 파일들
		File[] removeFiles = targetDir.listFiles(file -> fileListpaths.contains(file.toPath()) == false);
		
		//삭제 처리
		for (File file : removeFiles) {
			log.warn(file.getAbsolutePath());
			file.delete();
		}
	}
}
