package newthread.votesystem.service.impl;

import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.RoundProject;
import newthread.votesystem.mappers.ProjectMapper;
import newthread.votesystem.mappers.RoundProjectMapper;
import newthread.votesystem.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目操作类
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    // 项目 dao
    @Autowired
    ProjectMapper projectMapper;

    //轮次下项目dao
    @Autowired
    RoundProjectMapper roundProjectMapper;

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
     *
     * @param file
     */
    @Override
    public void uploadProjectFile(File file) {

    }

    /**
     * 上传项目（批量添加项目）
     *
     * @param file
     */
    @Override
    public void uploadProject(File file) {

    }
}
