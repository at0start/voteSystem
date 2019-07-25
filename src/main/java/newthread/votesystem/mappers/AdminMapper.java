package newthread.votesystem.mappers;

import newthread.votesystem.bean.Admin;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface AdminMapper extends Mapper<Admin> {
}