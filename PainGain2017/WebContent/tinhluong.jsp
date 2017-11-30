<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="model.*" %>
<%@ page import="DAO.*" %>
<%@ page import="java.util.*" %>
<title>Quản Lý Tính Lương</title>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>
<script language="javascript">
              function confirmAction() {
      		return confirm("Xác nhận xóa:")
	}
</script>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Quản lý tính lương 
		</h1>
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
	<span style="color:red"><i id="msg"></i></span>
	
		<div class="row">
	        <div class="col-xs-12">
	          <div class="box">
	            <div class="box-header">
	              <h3 class="box-title">Danh sách</h3>
	            </div>
	            <!-- /.box-header -->
	            <marquee behavior="scroll" direction="left" style="width: 100%; overflow-y: hidden;color : pink;">TRANG NÀY ĐANG TRONG QUÁ TRÌNH HOÀN THIỆN NỘI DUNG... HÃY THÔNG CẢM CHO DỊCH VỤ CỦA CHÚNG TÔI NHÉ. THẢ TIM. </marquee>
	            <div class="box-body">
	              <table id="example1" class="table table-striped table-bordered  table-hover">
	                <thead>
	                <tr>
	                  <th>Tên nhân viên</th>
	                  <th>Số giờ làm / tháng</th>
	                  <th>Lương/giờ</th>
	                  <th>Thưởng</th>
	                  <th>Phạt</th>
	                  <th>Tổng lương</th>
	                </tr>
	                </thead>
	                <tbody>
	                
			                <tr>
			                  <td></td>
			                  <td></td>
			                  <td></td>
			                  <td></td>
			                  <td></td>
			                  <td></td>
			                  
			                </tr>
	                
	                
	                
	                
	                </tbody>
	                <tfoot>
	                 <tr>
	                  <th>Tên nhân viên</th>
	                  <th>Số giờ làm / tháng</th>
	                  <th>Lương/giờ</th>
	                  <th>Thưởng</th>
	                  <th>Phạt</th>
	                  <th>Tổng lương</th>
	                </tr>
	                </tfoot>
	              </table>
	            </div>
	            <!-- /.box-body -->
	          </div>
	         </div>
         </div>
	</section>
</div>
<%@include file="frame/footer.jsp"%>