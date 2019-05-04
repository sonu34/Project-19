package Upload_Data;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import common_things.Common_Things;
public class FileUploadHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Connection connection=null;
	  	PreparedStatement ps=null;
		String file_name=null;
	  	String file_name_given=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				return;
			}
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					 if(file_name==null){
			    		   if(fileItem.getFieldName().equals("file_name")){
			    			   file_name=fileItem.getString();
			    		   } 
			    	   }
					 if(file_name_given==null){
			    		   if(fileItem.getFieldName().equals("file_name_given")){
			    			   file_name_given=fileItem.getString();
			    		   } 
			    	   }
				} else {
	    	    	  if(fileItem.getSize()>0){
	    	    		  file_name=fileItem.getName();
	    	    		  fileItem.write( new File(Common_Things.upload_path + File.separator + fileItem.getName()));
	    	    	  }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try {
						connection.close();
						System.out.println("connection closed");
					}
				 catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
					}
				 catch (Exception e2) {
					 e2.printStackTrace();
				}
			}
			out.println("<script type='text/javascript'>");
			out.println("window.location.href='"+Common_Things.url+"/read.jsp?file_name="+file_name+"&file_name_given="+file_name_given+"';");
			out.println("</script>");
			out.close();
		}
	}
}