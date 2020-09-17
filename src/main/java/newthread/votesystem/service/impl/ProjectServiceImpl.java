package newthread.votesystem.service.impl;

import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.ProjectFile;
import newthread.votesystem.bean.RoundProject;
import newthread.votesystem.mappers.ProjectFileMapper;
import newthread.votesystem.mappers.ProjectMapper;
import newthread.votesystem.mappers.RoundProjectMapper;
import newthread.votesystem.service.ProjectService;
import newthread.votesystem.utils.ExcelToJavaBean;
import newthread.votesystem.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目操作类
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    //轮次下项目dao
    @Autowired
    RoundProjectMapper roundProjectMapper;

    @Autowired
    ProjectFileMapper projectFileMapper;

    /**
     * 根据场次查询所有项目
     *
     * @param sessionId
     * @return
     */
    @Override
    public List<Project> queryAllProject(Integer sessionId) {
        Project project = new Project();
        project.setSessionId(sessionId);
        return projectMapper.select(project);
    }

    /**
     * 根据场次及轮次 id 查询项目
     *
     * @param sessionId
     * @param roundId
     * @return
     */
    @Override
    public List<Project> queryAllProjectsByRoundId(Integer sessionId, Integer roundId) {
        //建立查询条件类
        RoundProject roundProject = new RoundProject();
        roundProject.setSessionId(sessionId);
        roundProject.setRoundId(roundId);
        //获取轮次下项目 id
        List<RoundProject> roundProjects = roundProjectMapper.select(roundProject);
        int num = roundProjects.size();
        List<Project> projects = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            //根据项目主键查询项目信息
            Project project = projectMapper.selectByPrimaryKey(roundProjects.get(i).getProjectId());
            projects.add(project);
        }
        return projects;
    }

    /**
     * 手动添加项目
     *
     * @param project
     */
    @Override
    public boolean addProject(Project project) {
        if (projectMapper.insert(project) == 1) {
            return true;
        } else return false;
    }

    /**
     * 根据项目主键查询项目
     *
     * @param projectId
     * @return
     */
    @Override
    public Project queryProjectByProjectId(Integer projectId) {
        return projectMapper.selectByPrimaryKey(projectId);
    }

    /**
     * 删除项目根据项目主键
     *
     * @param projectId
     */
    @Override
    public boolean deleteByProjectId(Integer projectId) {
        if (projectMapper.deleteByPrimaryKey(projectId) == 1) {
            return true;
        } else return false;
    }

    /**
     * 更新项目(需要填写项目主键，场次主键信息)
     *
     * @param project
     */
    @Override
    public boolean updateProject(Project project) {
        if(projectMapper.updateByPrimaryKey(project) == 1){
            return true;
        }else return false;
    }

    /**
     * 上传项目文件
     * @param projectId
     * @return
     */
    @Override
    public boolean uploadProjectFile(File file,Integer projectId,String fileName ) {
        //将文件转换成二进制
        byte[] fileToByte = FileUtils.getFileToByte(file);
        //查询项目
        Project project = projectMapper.selectByPrimaryKey(projectId);
        //设置项目文件信息
        Integer fileId = project.getFileId();
        ProjectFile projectFile = new ProjectFile();
        projectFile.setProjectFile(fileToByte);
        projectFile.setFileName(fileName);
        projectFile.setProjectId(projectId);
        //如果项目文件为存入
        if (project.getFileId()==null||project.getFileId()==0){
            int f =projectFileMapper.insert(projectFile);
            //将fileId添加到project中
            project.setFileId(projectFile.getFileId());
            int i =projectMapper.updateByPrimaryKey(project);
            if(( f== 1) && (i ==1)){
                return true;
            }else  return false;
            //如果项目文件已插入或需要修改
        }else {
            projectFile.setFileId(fileId);
            //修改文件
            int f = projectFileMapper.updateByPrimaryKey(projectFile);
            return f==1?true:false;
        }

    }

    /**
     * 上传项目（批量添加项目）
     */
    @Override
    public List<Project> uploadProject(File file,int sessionId,String fileName) throws Exception {
        // 将文件转换成javabean
        ExcelToJavaBean excelToJavaBean = new ExcelToJavaBean();
        List<Project> projects = excelToJavaBean.importExcelAction(file,sessionId);

        //批量插入，将文件中的项目存入数据库，
        // projectMapper必须实现InsertListMapper接口
        for (Project p :
                projects) {
            System.out.println(p);
        }
        try {
            projectMapper.insertList(projects);
        }catch (Exception e){

        }

//        for(int i = 0;i < projects.size();i++){
//            Project project = projects.get(i);
//            System.out.println(project);
//            Integer j =projectMapper.insert(project);
//
//            System.out.println(j+"++++++++++++++++++++++++++++++++");
//        }
        Project project = new Project();
        project.setSessionId(sessionId);
        return (List<Project>) projectMapper.select(project);
    }

/**
 * 下载项目文件
 * @param projectId
 * @return
 */
    @Override
    public byte[] downLoadProjectFile(Integer projectId) {
        //根据projectId获取fileId
        Project project = projectMapper.selectByPrimaryKey(projectId);
        //根据文件id获取文件
        ProjectFile projectFile = projectFileMapper.selectByPrimaryKey(project.getFileId());
        return projectFile.getProjectFile();
    }

    /**
     * 获取项目名称
     * @param projectId
     * @return
     */
    @Override
    public String getProjectFileName(Integer projectId){
        Project project = projectMapper.selectByPrimaryKey(projectId);
        ProjectFile projectFile = projectFileMapper.selectByPrimaryKey(project.getFileId());
        return projectFile.getFileName();
    }

}
