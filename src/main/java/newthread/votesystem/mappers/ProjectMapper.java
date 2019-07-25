package newthread.votesystem.mappers;

import newthread.votesystem.bean.Project;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface ProjectMapper extends Mapper<Project> {
}