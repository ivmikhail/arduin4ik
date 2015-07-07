package ivmikhail.models;

public class PhotoSize {
    //    file_id	String	Unique identifier for this file
    private String fileId;
    //    width	Integer	Photo width
    private int width;
    //    height	Integer	Photo height
    private int height;
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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
