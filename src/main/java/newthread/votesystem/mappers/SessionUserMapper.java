package newthread.votesystem.mappers;

import newthread.votesystem.bean.SessionUser;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface SessionUserMapper extends Mapper<SessionUser> {
}