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
    
    SimpleDateFormat ftt = new SimpleDateFormat ("yyyy-MM-dd");
    String date =  ftt.format(dNow);
    %>
        <h1>
            Bảng chấm công tháng <%=month %>
           
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
                                    <th>Mã chấm công</th>
                                    <th>Giờ bắt đầu</th>
                                    <th>Giờ kết thúc</th>
                                    <th>Ngày</th>
                                    <th>Mã ca</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                HttpSession sessx = request.getSession();
            	                Account acc = (Account)sessx.getAttribute("login");
            	                
                                List<ChamCong> list = new ArrayList<ChamCong>();
                                try 
                                {
                                	list = new ChamCongDAO().getAllChamCong(acc.getMaAc(),date);
                                    for (ChamCong cc : list) 
                                    {
                                %>
                                <tr>
                                    <td><%=cc.getMaCc()%></td>
                                    <td><%=cc.getGioBatDau() %></td>
                                    <td><%=cc.getGioKetThuc()%></td>
                                    <td><%=cc.getNgay() %></td>
                                    <td><%=cc.getMaCa() %></td>
                            
                                
                              <%   
                              		}
                              %>
                            
                            </tr>
                            <%
                                }
	                            
	                            catch (Exception e)
	                            {}
                              
                            %>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Mã chấm công</th>
                                    <th>Giờ bắt đầu</th>
                                    <th>Giờ kết thúc</th>
                                    <th>Ngày</th>
                                    <th>Mã ca</th>                                
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
            </div>
            <div class="col-md-2">
                <button class="btn btn-primary" id="btnaddemployee" data-toggle="modal" data-target="#addnew">Chấm công hôm nay</button>

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
                <h4 class="modal-title">Chấm công</h4>
              </div>
              
                <form class="form-horizontal" action="addchamcong" method="post">
              <div class="modal-body">
        			<input type="hidden" value="<%=nvv.getMaNv() %>" name="ID">
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Giờ bắt đầu</label>
                  <div class="col-sm-10">
                  	<input type="hidden"  id="inputText131"  name="ID">
                    <input type="time" class="form-control" id="inputText11"  name="gbd">
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Giờ kết thúc</label>
                  <div class="col-sm-10">
                    <input type="time" class="form-control" id="inputText12"  name="gkt">
                  </div>
                </div>
                
                
                
                
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Ca làm</label>
                  <div class="col-sm-10">
                    
					<select class="form-control" id="inputText2"  name="ma_ca" >
					<%
                    List<CaLam> lst =  new  CaLamDAO().getAllCaLam();
                	if (list != null) 
                	{
                		for (CaLam cl : lst)
                		{
                    %>
						<option value="<%=cl.getMaCa() %>">Ca <%=cl.getMaCa() %></option>
					<%}} %>
					</select>
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
