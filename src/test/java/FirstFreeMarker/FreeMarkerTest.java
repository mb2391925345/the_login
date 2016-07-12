package FirstFreeMarker;
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.io.Writer;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
import freemarker.template.Configuration;  
import freemarker.template.DefaultObjectWrapper;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;  
public class FreeMarkerTest {
	
	 public static void main(String[] args) {  
	        try {  
	            //创建一个合适的Configration对象  
	            Configuration configuration = new Configuration();  
	            configuration.setDirectoryForTemplateLoading(new File("D:/workspace/new_login/src/main/resources/static"));  
	            configuration.setObjectWrapper(new DefaultObjectWrapper());  
	            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码  
	            //获取或创建一个模版。  
	            Template template = configuration.getTemplate("freemarker1.ftl");  
	            Map<String, Object> paramMap = new HashMap<String, Object>();  
	            paramMap.put("username", "我正在学习使用Freemarker生成静态文件！");  
	              
	            List<String> userlist = new ArrayList<String>();  
	            userlist.add("penghong");  
	            userlist.add("彭鸿");  
	            userlist.add("宇文拓");  
	            paramMap.put("nameList", userlist);  
	              
	           
	            Writer writer  = new OutputStreamWriter(new FileOutputStream("freemarker1.ftl"),"UTF-8");  
	            template.process(paramMap, writer);  
	              
	            System.out.println("恭喜，生成成功~~");  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (TemplateException e) {  
	            e.printStackTrace();  
	        }  
	          
	    }  

}
