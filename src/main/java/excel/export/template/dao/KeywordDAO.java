package excel.export.template.dao;


import excel.export.template.entity.Keyword;
import excel.export.template.entity.TemplateOfQuarter;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by hhh on 2017/4/12.
 */
public interface KeywordDAO {
    boolean save(TemplateOfQuarter templateOfQuarter) throws Exception;

    TemplateOfQuarter searchTemplateOfQuarterByTime(String year, String quarter) throws SQLException;

    List<Keyword> searchAllKeyword();
}
