package newthread.votesystem.service.impl;

import newthread.votesystem.bean.Session;
import newthread.votesystem.bean.SessionUser;
import newthread.votesystem.mappers.SessionMapper;
import newthread.votesystem.mappers.SessionUserMapper;
import newthread.votesystem.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sessionService")
public class SessionServiceImpl implements SessionService{

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    SessionUserMapper sessionUserMapper;

    /**
     * 获取所有的场次
     * @return
     */
    @Override
    public List<Session> getAllSession() {
        return sessionMapper.selectAll();
    }

    /**
     * 添加场次,并返回主键
     * @param session
     * @return
     */
    @Override
    public Integer addSession(Session session) {
        sessionMapper.insert(session);
        return session.getSessionId();
    }

    /**
     * 根据场次主键查询场次
     * @param sessionId
     * @return
     */
    @Override
    public Session getSessionBySessionId(Integer sessionId) {
        return sessionMapper.selectByPrimaryKey(sessionId);
    }

    /**
     * 赋予评委场次投票权限
     * @param sessionId
     */
    @Override
    public void giveAuthority(Integer sessionId) {
        //1. 查询场次（session）表获取评委人数
        Session session = sessionMapper.selectByPrimaryKey(sessionId);
        Integer userNumber = session.getUserNumber();
        //2. 根据场次 id 删除权限信息
        SessionUser sessionUser = new SessionUser();
        sessionUser.setSessionId(sessionId);
        sessionUserMapper.delete(sessionUser);
        //3. 访问权限表,添加权限信息（session_user）
        for(int i = 0;i < userNumber;i++){
            sessionUserMapper.insert(new SessionUser(sessionId,"j" + i));
        }
    }

    /**
     * 修改场次信息
     * @param session
     */
    @Override
    public void updateSession(Session session) {
        sessionMapper.updateByPrimaryKey(session);
    }

    /**
     * 根据场次 id 删除场次
     * 1. 删除场次表（session）信息
     * 2. 删除用户权限信息（session_user）
     * @param sessionId
     */
    @Override
    public void deleteBySessionId(Integer sessionId) {
        //1. 删除该场次id场次信息
        sessionMapper.deleteByPrimaryKey(sessionId);
        //2. 删除用户权限信息（session_user）,根据 sessionId
        sessionUserMapper.delete(new SessionUser(sessionId,null));
        //3. 删除场次下的项目
        //..........

    }

    /**
     * 更新场次状态
     * @param sessionId
     */
    @Override
    public void updateSessionState(Integer sessionId) {
        //1. 获取该场次
        Session session = sessionMapper.selectByPrimaryKey(sessionId);
        //2. 修改场次状态：0 -> 1
        session.setSessionState(1);
        //3. 更新场次
        sessionMapper.updateByPrimaryKey(session);
    }
}
