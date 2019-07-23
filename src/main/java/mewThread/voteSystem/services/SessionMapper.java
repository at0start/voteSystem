package mewThread.voteSystem.services;

import mewThread.voteSystem.model.Session;

import java.util.List;

/**
 * 操作场次
 */
public interface SessionMapper {

    //获取所有场次
    List<Session> getAllSession();

    //添加场次,；并且返回该添加场次(是否直接添加session并返回该session？？？)
    Integer addSession(Session session);

    //根据主键查询场次信息
    Session getSessionBySessionId(Integer sessionId);

    //赋予评委权限,访问 session_user 表（根据 userNumber ，添加 userNumber 个用户）
    void giveAuthority(Integer sessionId,Integer userNumber);

    //修改场次（先查（根据主键）在改）
    void updateSession(Session session);

    //根据主键删除场次
    void deleteBySessionId(Integer sessionId);

    //修改场次状态
    void updateSessionState(Integer sessionId);



    //Session session = a.getSessionBySessionId(addSession);




}
