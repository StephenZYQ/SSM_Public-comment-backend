package cn.lqandzy.mapper.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import cn.lqandzy.bean.BaseBean;
import cn.lqandzy.bean.Page;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
/**
 * 
 * @author Administrator
 *
 */
public class PageInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation arg0) throws Throwable {
		StatementHandler statementHandler = (StatementHandler)arg0.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,new DefaultReflectorFactory());
		MappedStatement mappedStatement = (MappedStatement)metaObject.getValue("delegate.mappedStatement");
		String id = mappedStatement.getId();
		String ByPage="ByPage";
		if(id.endsWith(ByPage)) {
			BoundSql boundSql = statementHandler.getBoundSql();
			String sql = boundSql.getSql();
			String countSql = "select count(*) from(" + sql + ")t";
			Connection conn = (Connection)arg0.getArgs()[0];
			PreparedStatement statement = conn.prepareStatement(countSql);
			ParameterHandler parameterHandler = (ParameterHandler)metaObject.getValue("delegate.parameterHandler");
			parameterHandler.setParameters(statement);
			ResultSet rs = statement.executeQuery();
			BaseBean bean = (BaseBean)boundSql.getParameterObject();
			Page page = bean.getPage();
			if(rs.next()) {
				page.setTotalNumber(rs.getInt(1));
			}
			String pageSql = sql + " limit " + (page.getCurrentPage() - 1) * page.getPageNumber() + "," + page.getPageNumber();
			metaObject.setValue("delegate.boundSql.sql", pageSql);
		}
		return arg0.proceed();
		
	}
	@Override
	public Object plugin(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
