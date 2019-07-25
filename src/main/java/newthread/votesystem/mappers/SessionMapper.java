package newthread.votesystem.mappers;

import newthread.votesystem.bean.Session;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface SessionMapper extends Mapper<Session> {
}