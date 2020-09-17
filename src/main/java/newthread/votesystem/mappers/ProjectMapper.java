package newthread.votesystem.mappers;

import newthread.votesystem.bean.Project;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

@Component
public interface ProjectMapper extends Mapper<Project> , InsertListMapper<Project> {
}