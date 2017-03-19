package com.lyc88.beans;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/1/26.
 */
@Entity
@Table(name = "diskFilesCopy")
public class DiskFiles {
    @GeneratedValue
    @Id
    @Column(name="file_id")
    private Integer fileId;
    @Column(name="file_size")
    private String  fileSize;
    @Column(name="file_path")
    private String  filePath;
    @Column(name="file_name")
    private String  fileName;
    @Column(name="file_type")
    private String  fileType;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "DiskFiles{" +
                "fileId=" + fileId +
                ", fileSize='" + fileSize + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
