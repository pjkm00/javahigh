package kr.or.dw.basic.upload;

//Upload된 파일 정보가 저장될 class
public class UploadDetail {
	private long filesize; 			//파일용량
	private String fileName;		//파일이름
	private String uploadStatus;	//업로드 성공 여부
	
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	
}
