package newthread.votesystem.test;

import com.xuxueli.poi.excel.ExcelImportUtil;
import newthread.votesystem.entity.Projects;
import newthread.votesystem.utils.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestFile {

    public static void main(String[] args) throws IOException, InvalidFormatException {

        FileUtils fileUtils = new FileUtils();
        fileUtils.getProjectsByFile(new File("C:\\Users\\po\\Desktop\\project.xlsx"));

//        /**
//         * Mock数据，Java对象列表
//         */
////        List<Projects> projectss = new ArrayList<Projects>();
////        for (int i = 0; i < 100; i++) {
////            Projects projects = new Projects(1,1,"1","1","1","1","1");
////            projectss.add(projects);
////        }
//        String filePath = "C:\\Users\\po\\Desktop\\project.xlsx";
//
//        /**
//         * Excel导出：Object 转换为 Excel
//         */
////        ExcelExportUtil.exportToFile(projectss, filePath);
//
//        /**
//         * Excel导入：Excel 转换为 Object
//         */
//        Workbook workbook = WorkbookFactory.create(new File(filePath));
//        System.out.println("sheets" + workbook.getNumberOfSheets());
//        //获取一张表
//        Sheet sheet = workbook.getSheetAt(0);
//        for (Row row : sheet) {
//            int index = 0;
//            for (Cell cell : row) {
//                //读取数据前设置单元格类型
//                cell.setCellType(CellType.STRING);
//                String value = cell.getStringCellValue();
//                System.out.print("value:" + value + " ");
//                index++;
//            }
//            System.out.println();
//        }
////        List<Object> list = ExcelImportUtil.importExcel(Projects.class, filePath);
////
////        System.out.println(list);
    }
}
