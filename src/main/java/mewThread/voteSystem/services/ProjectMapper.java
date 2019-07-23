package mewThread.voteSystem.services;

import mewThread.voteSystem.model.Project;

import java.io.File;
import java.util.List;

/**
 * 操作项目
 */
public interface ProjectMapper {

    //查询所有项目(根据场次)
    List<Project> queryAllProject(Integer sessionId);

    //添加项目（单个）
    void addProject(Project project);

    //根据主键查询项目(主键如何获取（自己）)
    Project queryProjectByProjectId(Integer projectId);

    //删除项目（根据主键）
    void deleteByProjectId(Integer projectId);

    //修改项目（先查再改）
    void updateProject(Project project);

    //上传项目文件
    void uploadProjectFile(File file);

    //根据文件操作批量上传项目
    void uploadProject(File file);



}
