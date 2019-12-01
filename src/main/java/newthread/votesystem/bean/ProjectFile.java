package newthread.votesystem.bean;

import javax.persistence.*;

@Table(name = "project_file")
public class ProjectFile {
    @Id
    @Column(name = "file_id")
    @GeneratedValue(generator = "JDBC")
    private Integer fileId;

    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "project_file")
    private byte[] projectFile;

    /**
     * @return file_id
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * @param fileId
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * @return project_id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * @return file_name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return project_file
     */
    public byte[] getProjectFile() {
        return projectFile;
    }

    /**
     * @param projectFile
     */
    public void setProjectFile(byte[] projectFile) {
        this.projectFile = projectFile;
    }
}