package newthread.votesystem.utils;

import newthread.votesystem.bean.Project;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileUtils {
    /**
     * 获取 excel 文件将其转变成 project 并返回
     *
     * @param file
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    public static List<Project> getProjectsByFile(File file) throws IOException, InvalidFormatException {
        List<Project> projects = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file);
        //获取一张表
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println("sheets" + workbook.getNumberOfSheets());
        for (Row row : sheet) {
            System.out.println(1+"111");
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
            if (!ss[0].equals("项目编号") && ss[0] != null && !ss[0].equals("")) {
                Project project = new Project();
                for(int i = 0;i < ss.length;i++){
                    System.out.println(ss[i]);
                }
                project.setProjectOrder(Integer.parseInt(ss[0]));
                project.setProjectName(ss[1]);
                project.setProjectType(ss[2]);
                project.setProjectMan(ss[3]);
                project.setCollegeName(ss[4]);
                project.setMoney(Double.parseDouble(ss[5]));
                project.setProjectInfo(ss[6]);
                projects.add(project);
            }
        }
        return projects;
    }

    // 随机生成六位不重复的数字
    public static int generate6BitInt() {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        int result = 0;
        for(int i = 0; i < 6; i++)
            result = result * 10 + array[i];
        return result;
    }

    /**
     * 文件转换成二进制
     * @param file
     * @return
     */
    public static byte[] getFileToByte(File file) {
        byte[] by = new byte[(int) file.length()];
        try {
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
            byte[] bb = new byte[2048];
            int ch;
            ch = is.read(bb);
            while (ch != -1) {
                bytestream.write(bb, 0, ch);
                ch = is.read(bb);
            }
            by = bytestream.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return by;
    }
    /**
     * 根据byte数组，生成文件
     */
    public static File getFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath+"\\"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }
}
