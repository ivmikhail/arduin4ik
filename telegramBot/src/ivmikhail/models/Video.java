package ivmikhail.models;


public class Video {
    //    file_id	String	Unique identifier for this file
    private String fileId;
    //    width	Integer	Video width as defined by sender
    private int width;
    //    height	Integer	Video height as defined by sender
    private int height;
    //    duration	Integer	Duration of the video in seconds as defined by sender
    private int duration;
    //    thumb	PhotoSize	Video thumbnail
    private PhotoSize thumb;
    //    mime_type	String	Optional. Mime type of a file as defined by sender
    private String mimeType;
    //    file_size	Integer	Optional. File size
    private long fileSize;
    //    caption	String	Optional. Text description of the video (usually empty)
    private String caption;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(PhotoSize thumb) {
        this.thumb = thumb;
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
