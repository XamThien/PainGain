<%-- 
    Document   : dsdondathang
    Created on : Jun 21, 2017, 9:54:24 PM
    Author     : Asus
--%>
<%@page import="java.util.List"%>
<%@page import ="java.io.IOException" %>
<%@page import="DAO.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
    <%
    Date dNow = new Date( );
    SimpleDateFormat ft = new SimpleDateFormat ("MM");
    String month =  ft.format(dNow);
    
    %>
        <h1>
            Bảng thưởng phạt tháng <%=month %>
           
        </h1>
        <span style="color:red"><i>${msg}</i></span>
        <ol class="breadcrumb">
			<li><a href="home.jsp"><i class="fa fa-dashboard"></i>Tháng: </a></li>
			<li>
					
						<select  id="inputText2"  name="month" onchange="location = this.value;" >
						<%
	                    	for(int i=1; i<13;i++)
	                    	{
	                    		
	                    		
	                    %>
	                     <option value="home.jsp"> Tháng <%=i %> </option> 
	                     
							
						<%} %>
						
						</select>
					
			</li>
			
		</ol>
    </section>
    
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-md-10">
                <div class="box box-primary">

                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Nhân viên</th>
                                    <th>Giá trị</th>
                                    <th>Thưởng</th>
                                    <th>Phạt</th>
                                    <th>Nội dung</th>
                                    <th>Ngày</th>
                                </tr>
                            </thead>
                            <tbody>
                               <%
                               Date dNowx = new Date( );
                               SimpleDateFormat ftx = new SimpleDateFormat ("yyyy-MM-dd");
                               String datex =  ftx.format(dNowx);
                               
                               HttpSession sessx = request.getSession();
           	                   Account acc = (Account)sessx.getAttribute("login");
                               List<ThuongPhat> lst = new ThuongPhatDAO().getAllThuongPhat(acc.getMaAc(),datex);
                               if (lst!=null)
                               {
                            	   for (ThuongPhat tp : lst)
                                   {
                                	   
                               
                               %>
                                <tr>
                                    <td><%=acc.getUserName() %></td>
                                    <td><%=tp.getGiaTri() %></td>
                                   <%
                                   if (tp.getLaPhat()==1)
                                   {
                                	   %>
                                	    <td>0</td>
                            			<td>1</td>
                                	   <% 
                                   }
                                   else
                                   {
                                	   %>
                               	    <td>1</td>
                           			<td>0</td>
                               	   		<% 
                                   }
                                   
                                   %>
                                    <td><%=tp.getLiDo() %></td>
                            		<td><%=tp.getNgay() %></td>
                             	</tr>
	                            <%}} %>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Nhân viên</th>
                                    <th>Giá trị</th>
                                    <th>Thưởng</th>
                                    <th>Phạt</th>
                                    <th>Nội dung</th>
                                    <th>Ngày</th>                           
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
            </div>
            <div class="col-md-2">
                <button class="btn btn-primary" id="btnaddemployee" data-toggle="modal" data-target="#addnew">Thêm mới</button>

            </div>
        </div>
    </section>
    <!-- ===================================================================================== -->
   
    <div class="modal  fade" id="addnew">
          <div class="modal-dialog" >
            <div class="modal-content">
              <div class="modal-header with-border">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Thêm mới</h4>
              </div>
              
                <form class="form-horizontal" action="addthuongphat" method="post">
              <div class="modal-body">
        		<div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Nhân viên</label>
                  <div class="col-sm-10">
                    
					<select class="form-control" id="inputText2"  name="ID" >
					<%
                    List<NhanVien> lstt =  new  NhanVienDAO().getAllNhanVien();
                	if (lstt != null) 
                	{
                		for (NhanVien xxx : lstt)
                		{
                    %>
						<option value="<%=xxx.getMaNv() %>"><%=xxx.getTenNv() %></option>
					<%}} %>
					</select>
                  </div>
                  
                </div>	
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Giá trị</label>
                  <div class="col-sm-10">
                  	
                    <input type="number" class="form-control" id="inputText11"  name="giatri">
                  </div>
                </div>
                
                 
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Hình thức</label>
                  <div class="col-sm-10">
                    
					<select class="form-control" id="inputText2"  name="hinhthuc" >
					
						<option value="1">Thưởng</option>
						<option value="2">Phạt</option>
					
					</select>
                  </div>
                  
                </div>
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Lí do</label>
                  <div class="col-sm-10">
                  	
                    <textarea class="form-control" rows="3" cols="4" name="lido"></textarea>
                  </div>
                </div>
                  
                </div>
                  
             
              <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                
                <button type="submit" class="btn btn-primary" >Lưu</button>
              </div>
            </form>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
     <!-- ===================================================================================== -->
</div>
<%@include file="frame/footer.jsp"%>
