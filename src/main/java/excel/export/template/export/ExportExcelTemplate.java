package excel.export.template.export;


import excel.export.template.entity.Keyword;
import excel.export.template.entity.Template;
import excel.export.template.entity.TemplateOfQuarter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 *
 */
public class ExportExcelTemplate {

    public void export(TemplateOfQuarter templateOfQuarter) throws Exception {
        OutputStream outputStream = new FileOutputStream(new File("D:\\test11.xls"));
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        List<Template> templates =  templateOfQuarter.getTemplates();
        for (Template template :templates) {
            List<Keyword> keywords = template.getKeywords();
            for (Keyword keyword :keywords) {
                Row row = sheet.getRow(keyword.getRowIndex()) == null ? sheet.createRow(keyword.getRowIndex()) : sheet.getRow(keyword.getRowIndex());
                Cell cell = row.createCell(keyword.getColIndex());
                cell.setCellValue(String.valueOf(keyword.getValue()));

            }
        }

        workbook.write(outputStream);
        outputStream.close();
    }
}
