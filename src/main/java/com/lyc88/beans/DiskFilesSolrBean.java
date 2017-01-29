package com.lyc88.beans;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/1/27.
 */
public class DiskFilesSolrBean implements Serializable{

    @Field
    private String id;
    @Field
    private Long  fileSize;
    @Field
    private String  filePath;
    @Field
    private String  fileName;
    @Field
    private String  fileType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
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
        return "DiskFilesSolrBean{" +
                "id='" + id + '\'' +
                ", fileSize=" + fileSize +
                ", filePath='" + filePath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                '}';
    }
}
