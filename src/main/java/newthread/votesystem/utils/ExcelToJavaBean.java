package newthread.votesystem.utils;

import com.alibaba.fastjson.JSON;
import com.xuxueli.poi.excel.ExcelImportUtil;
import newthread.votesystem.bean.Project;
import newthread.votesystem.entity.Projects;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author isalo
 * @date 2020-09-11 17:02
 */
public class ExcelToJavaBean {

    //导入Excel数据

    public List<Project> importExcelAction(File file, Integer sessionId) throws Exception {


        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //获取到Excel文件中的所有行数

        int rows = sheet.getPhysicalNumberOfRows();

        //遍历行

        List<Project> list = new ArrayList<>();

        for (int i = 1; i < rows; i++) {

            // 读取左上端单元格

            XSSFRow row = sheet.getRow(i);

            // 行不为空
            if (row != null) {


                //获取到Excel文件中的所有的列
                int cells = row.getPhysicalNumberOfCells();

                //项目编号
                XSSFCell projectOrderCell = row.getCell(0);
                Integer projectOrder = Integer.parseInt(getValue(projectOrderCell));

                //项目名称
                XSSFCell projectNameCell = row.getCell(1);
                String projectName = getValue(projectNameCell);

                //项目类别
                XSSFCell projectTypeCell = row.getCell(2);
                String projectType = getValue(projectTypeCell);

                //项目负责人
                XSSFCell projectManCell = row.getCell(3);
                String projectMan = getValue(projectManCell);

                //所在学院
                XSSFCell collegeNameCell = row.getCell(4);
                String collegeName = getValue(collegeNameCell);

                //申请经费
                XSSFCell moneyCell = row.getCell(5);
                Double money = Double.parseDouble(getValue(moneyCell));

                //备注
                XSSFCell projectInfoCell = row.getCell(6);
                String projectInfo = getValue(projectInfoCell);
                //project.setProjectInfo(projectInfo);
//                    //姓名
//
//                    XSSFCell nameCell = row.getCell(1);
//
//                    String name = getValue(nameCell);
//
//                    //性别
//
//                    XSSFCell sexCell = row.getCell(2);
//
//                    String sex = getValue(sexCell);
//
//                    //年龄
//
//                    XSSFCell ageCell = row.getCell(3);
//
//                    String age = getValue(ageCell);
//
//                    //出生年月
//
//                    XSSFCell birthCell = row.getCell(4);
//
//                    map.put("name", name);
//
//                    map.put("sex", sex);
//
//                    map.put("age", age);


                //查看是否获取到excel表格中的数据
//                System.out.println(projectOrder);
//                System.out.println(projectName);
//                System.out.println(projectType);
//                System.out.println(projectMan);
//                System.out.println(collegeName);
//                System.out.println(money);
//                System.out.println(projectInfo);
                list.add(new Project(sessionId, null, projectOrder, projectName, projectType, collegeName, projectMan, money, null, projectInfo));
            }

        }
        return list;
    }

    private String getValue(XSSFCell xSSFCell) {

        if (null == xSSFCell) {

            return "";

        }

        if (xSSFCell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {

            // 返回布尔类型的值

            return String.valueOf(xSSFCell.getBooleanCellValue());

        } else if (xSSFCell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {

            // 返回数值类型的值

            return String.valueOf(xSSFCell.getNumericCellValue());

        } else {

            // 返回字符串类型的值

            return String.valueOf(xSSFCell.getStringCellValue());

        }

    }
}
