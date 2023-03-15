import com.alibaba.excel.EasyExcel;
import com.atguigu.vod.service.excel.Stu;
import com.atguigu.vod.service.listener.ExcelListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author roo
 * @date 2023/3/15
 */
public class exceltest {
    public static void main(String[] args) {
        String fileName = "D:\\11.xlsx";
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(fileName, Stu.class).sheet("写入方法").doWrite(data());
        //读取
        EasyExcel.read(fileName, Stu.class, new ExcelListener()).sheet().doRead();

    }
    private static List<Stu> data() {
        List<Stu> list = new ArrayList<Stu>();
        for (int i = 0; i < 10; i++) {
            Stu data = new Stu();
            data.setAge(i);
            data.setName("张三"+i);
            list.add(data);
        }
        return list;
    }
}
