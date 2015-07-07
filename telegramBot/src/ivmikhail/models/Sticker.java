package ivmikhail.models;

public class Sticker {
    //    file_id	String	Unique identifier for this file
    private String fileId;
    //    width	Integer	Sticker width
    private int width;
    //    height	Integer	Sticker height
    private int height;
    //    thumb	PhotoSize	Sticker thumbnail in .webp or .jpg format
    private PhotoSize thumb;
    //    file_size	Integer	Optional. File size
    private long fileSize;

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

    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(PhotoSize thumb) {
        this.thumb = thumb;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
