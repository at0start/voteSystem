package newthread.votesystem.mappers;

import newthread.votesystem.bean.ProjectFile;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface ProjectFileMapper extends Mapper<ProjectFile> {
}