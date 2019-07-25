package newthread.votesystem.mappers;

import newthread.votesystem.bean.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface UserMapper extends Mapper<User> {
}