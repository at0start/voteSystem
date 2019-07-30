package newthread.votesystem.utils;

import newthread.votesystem.bean.Project;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    /**
     * 获取 excel 文件将其转变成 project 并返回
     *
     * @param file
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    public List<Project> getProjectsByFile(File file) throws IOException, InvalidFormatException {
        List<Project> projects = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file);
        //获取一张表
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println("sheets" + workbook.getNumberOfSheets());
        for (Row row : sheet) {
            int index = 0;
            // 创建 String 数组存放数据
            String[] ss = new String[7];
            for (Cell cell : row) {
                //读取数据前设置单元格类型
                cell.setCellType(CellType.STRING);
                String value = cell.getStringCellValue();
                ss[index] = value;
                index++;
            }
            //值得更改
            if (!ss[0].equals("项目编号")) {
                Project project = new Project();
                project.setProjectId(Integer.parseInt(ss[0]));
                project.setProjectName(ss[1]);
                project.setProjectType(ss[2]);
                project.setCollegeName(ss[3]);
                project.setCollegeName(ss[4]);
                project.setMoney(Double.parseDouble(ss[5]));
                project.setProjectInfo(ss[6]);
                projects.add(project);
                System.out.println(project);
            }
        }
        return projects;
    }



}
