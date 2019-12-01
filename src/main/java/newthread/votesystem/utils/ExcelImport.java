package newthread.votesystem.utils;

import newthread.votesystem.bean.Project;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 一个糟老头子
 * @createDate 2019/9/20-17:19
 */
public class ExcelImport {
    //导入Excel数据

    public static List<Project> getProjectsByFile(File file,String fileName)
            throws IOException {

        List<Project> projects = new ArrayList<>();

        // 获取文件后缀名
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        try {
            if(suffix.equals("xlsx") ){
                System.out.println("xlsx");
                XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(file));
                XSSFSheet sheet = wookbook.getSheet("Sheet1");

                //获取到Excel文件中的所有行数
                int rows = sheet.getPhysicalNumberOfRows();

                //遍历行
                for (int i = 1; i < rows; i++) {

                    // 读取左上端单元格
                    XSSFRow row = sheet.getRow(i);

                    // 行不为空
                    if (row != null) {

                        Project project = new Project();

                        //获取到Excel文件中的所有的列
                        int cells = row.getPhysicalNumberOfCells();

                        //项目编号
                        XSSFCell projectOrderCell = row.getCell(0);
                        String projectOrder = getValue1(projectOrderCell);
                        project.setProjectOrder(Integer.parseInt(projectOrder));

                        //项目名称
                        XSSFCell projectNameCell = row.getCell(1);
                        String projectName = getValue1(projectNameCell);
                        project.setProjectName(projectName);

                        //项目类别
                        XSSFCell projectTypeCell = row.getCell(2);
                        String projectType = getValue1(projectTypeCell);
                        project.setProjectType(projectType);

                        //项目负责人
                        XSSFCell projectManCell = row.getCell(3);
                        String projectMan = getValue1(projectManCell);
                        project.setProjectMan(projectMan);

                        //所在学院
                        XSSFCell collegeNameCell = row.getCell(4);
                        String collegeName = getValue1(collegeNameCell);
                        project.setCollegeName(collegeName);

                        //申请经费
                        XSSFCell moneyCell = row.getCell(5);
                        String money = getValue1(moneyCell);
                        project.setMoney(Double.parseDouble(money));


                        //备注
                        XSSFCell projectInfoCell = row.getCell(6);
                        String projectInfo = getValue1(projectInfoCell);
                        project.setProjectInfo(projectInfo);


                        projects.add(project);
                    }
                }

                System.out.println(1);
            }
        }catch (Exception e){

        }


        if(suffix.equals("xls")){
            System.out.println("xls");
            HSSFWorkbook wookbook = new HSSFWorkbook(new FileInputStream(file));

            HSSFSheet sheet = wookbook.getSheet("Sheet1");

            //获取到Excel文件中的所有行数
            int rows = sheet.getPhysicalNumberOfRows();

            //遍历行
            for (int i = 1; i < rows; i++) {

                // 读取左上端单元格
                HSSFRow row = sheet.getRow(i);

                // 行不为空
                if (row != null) {
                    Project project = new Project();

                    //获取到Excel文件中的所有的列
                    int cells = row.getPhysicalNumberOfCells();

                    //项目编号
                    HSSFCell projectOrderCell = row.getCell(0);
                    String projectOrder = getValue(projectOrderCell);
                    project.setProjectOrder(Integer.parseInt(projectOrder));

                    //项目名称
                    HSSFCell projectNameCell = row.getCell(1);
                    String projectName = getValue(projectNameCell);
                    project.setProjectName(projectName);

                    //项目类别
                    HSSFCell projectTypeCell = row.getCell(2);
                    String projectType = getValue(projectTypeCell);
                    project.setProjectType(projectType);

                    //项目负责人
                    HSSFCell projectManCell = row.getCell(3);
                    String projectMan = getValue(projectManCell);
                    project.setProjectMan(projectMan);

                    //所在学院
                    HSSFCell collegeNameCell = row.getCell(4);
                    String collegeName = getValue(collegeNameCell);
                    project.setCollegeName(collegeName);

                    //申请经费
                    HSSFCell moneyCell = row.getCell(5);
                    String money = getValue(moneyCell);
                    project.setMoney(Double.parseDouble(money));


                    //备注
                    HSSFCell projectInfoCell = row.getCell(6);
                    String projectInfo = getValue(projectInfoCell);
                    project.setProjectInfo(projectInfo);


                    projects.add(project);

                }
            }

        }

        for (Project project : projects)
            System.out.println(project);
        return projects;
    }

    private static String getValue(HSSFCell hSSFCell) {

        if (null == hSSFCell) {

            return "";

        }

        if (hSSFCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {

            // 返回布尔类型的值

            return String.valueOf(hSSFCell.getBooleanCellValue());

        } else if (hSSFCell.getCellType() == hSSFCell.CELL_TYPE_NUMERIC) {

            // 返回数值类型的值
            return String.valueOf(hSSFCell.getNumericCellValue());

        } else {

            // 返回字符串类型的值

            return String.valueOf(hSSFCell.getStringCellValue());

        }

    }
    private static String getValue1(XSSFCell xSSFCell) {

        if (null == xSSFCell) {

            return "";

        }

        if (xSSFCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {

            // 返回布尔类型的值

            return String.valueOf(xSSFCell.getBooleanCellValue());

        } else if (xSSFCell.getCellType() == xSSFCell.CELL_TYPE_NUMERIC) {

            // 返回数值类型的值
            return String.valueOf(xSSFCell.getNumericCellValue());

        } else {

            // 返回字符串类型的值

            return String.valueOf(xSSFCell.getStringCellValue());

        }

    }

}
