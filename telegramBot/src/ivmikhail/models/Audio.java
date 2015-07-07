package ivmikhail.models;


public class Audio {
    //    file_id	String	Unique identifier for this file
    private String fileId;
    //    duration	Integer	Duration of the audio in seconds as defined by sender
    private int duration;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
