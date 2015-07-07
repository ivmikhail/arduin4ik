package ivmikhail.models;


public class Document {
    //    file_id	String	Unique file identifier
    private String fileId;
    //    thumb	PhotoSize	Document thumbnail as defined by sender
    private PhotoSize photoSize;
    //    file_name	String	Optional. Original filename as defined by sender
    private String fileName;
    //    mime_type	String	Optional. MIME type of the file as defined by sender
    private String mimeType;
    //    file_size	Integer	Optional. File size
    private long fileSize;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public PhotoSize getPhotoSize() {
        return photoSize;
    }

    public void setPhotoSize(PhotoSize photoSize) {
        this.photoSize = photoSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
