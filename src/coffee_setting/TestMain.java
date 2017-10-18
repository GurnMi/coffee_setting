package coffee_setting;


import java.sql.Connection;

import coffee_setting.jdbc.DBCon;
import coffee_setting.jdbc.JdbcUtil;
import coffee_setting.service.DbService;
import coffee_setting.service.ExportService;
import coffee_setting.service.ImportService;
import coffee_setting.service.InitService;

public class TestMain {

	public static void main(String[] args) {
		
		
		DBCon dbCon =DBCon.getInstance();
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		
		//
		DbService serivce = InitService.getInstance();
		serivce.service();

		serivce = ImportService.getInstance();
		serivce.service();
		
		serivce = ExportService.getInstance();
		serivce.service();
		
		JdbcUtil.close(connection);			//종료해줘야됨
	}

}
