package newthread.votesystem.bean;

import javax.persistence.*;

public class College {
    @Id
    @Column(name = "college_id")
    private Integer collegeId;

    @Column(name = "college_name")
    private String collegeName;

    /**
     * @return college_id
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * @param collegeId
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * @return college_name
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * @param collegeName
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}