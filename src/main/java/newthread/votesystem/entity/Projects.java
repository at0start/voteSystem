package newthread.votesystem.entity;

import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;
import org.apache.poi.hssf.util.HSSFColor;

@ExcelSheet(name = "项目列表", headColor = HSSFColor.HSSFColorPredefined.LIGHT_GREEN)
public class Projects {

        @ExcelField(name = "项目编号")
        private int projectId;

        @ExcelField(name= "项目序号")
        private int projectOrder;

        @ExcelField(name = "项目名称")
        private String projectName;

        @ExcelField(name = "项目类型")
        private String projectType;

        @ExcelField(name = "项目部门")
        private String collegeName;

        @ExcelField(name = "项目负责人")
        private String projectMan;

        @ExcelField(name = "项目简介")
        private String projectInfo;

    public Projects() {
    }

    public Projects(int projectId, int projectOrder, String projectName, String projectType, String collegeName, String projectMan, String projectInfo) {
        this.projectId = projectId;
        this.projectOrder = projectOrder;
        this.projectName = projectName;
        this.projectType = projectType;
        this.collegeName = collegeName;
        this.projectMan = projectMan;
        this.projectInfo = projectInfo;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getProjectOrder() {
        return projectOrder;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getProjectMan() {
        return projectMan;
    }

    public String getProjectInfo() {
        return projectInfo;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public void setProjectOrder(int projectOrder) {
        this.projectOrder = projectOrder;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setProjectMan(String projectMan) {
        this.projectMan = projectMan;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
    }
}

