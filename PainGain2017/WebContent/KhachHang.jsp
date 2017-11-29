<%-- 
    Document   : employee
    Created on : Jun 11, 2017, 2:27:50 PM
    Author     : dangt
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="DAO.*" %>
<title>Quản Lý Nhân Viên</title>
<%@include file="frame/header.jsp" %>
<script language="javascript">
              function confirmAction() {
      		return confirm("Xác nhận xóa:")
	}
</script>
<%@include file="frame/sidebar.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
         <h1>
            Khách hàng
            <small>Quản lí</small>
        </h1>
        <span style="color:red"><i>${msg}</i></span>
        <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
            <li class="active">Khách hàng</li>
        </ol>
    </section>
    <section class="content">
    	<span style="color:red"><i>${msg1}</i></span>
    	<span style="color:red"><i>${msg2}</i></span>
          <div class="box">
            <!-- /.box-header -->
            <div class="box-body">
              <table id="example1" class="table table-bordered table-striped table-hover">
                <thead>
                <tr>
                  <th>Mã</th>
                  <th>Tên Khách hàng</th>
                  
                  <th>Địa chỉ</th>
                  <th>Số điện thoại</th>
                  
                  <th><button class="btn btn-link" id="btnaddemployee" data-toggle="modal" data-target="#addemployee"><span class="fa fa-plus">Thêm mới</span></button></th>
                </tr>
                </thead>
                <tbody>
                <%
                List<KhachHang> list =  new  KhachHangDAO().getAllKhachHang();
                	if (list != null) 
                	{
                		for (KhachHang nvx : list)
                		{
                			
                %>
                <tr>
                    <td><a href="#" title="click vào để xem chi tiết"><%=nvx.getMaKh() %></a></td>
                    <td><%=nvx.getTenKh() %></td>
                    <td><%=nvx.getDiaChi() %></td>
                    <td><%=nvx.getSoDt() %></td>
                   
                    <td>
                      <button class="btn btn-link" data-toggle="modal" data-target="#modal-editemployee" onclick = "edit(<%=nvx.getMaKh() %>,'<%=nvx.getTenKh() %>','<%=nvx.getDiaChi() %>','<%=nvx.getSoDt() %>');"><span class="fa fa-edit">Sửa</span></button>
                      <span class="fa" style="margin: 0px 5px;"></span>
                      <a onclick="return confirmAction()" href="${pageContext.request.contextPath}/actionkhachhang?MaKH=<%=nvx.getMaKh() %>"><span class="fa fa-remove">Xóa</span></a>
                    </td>
                  </tr>
                   <%
                		}
                	}
                   %>
                   
                   
                </tbody>
                <tfoot>
                <tr>
                  <th>Mã</th>
                  <th>Tên Khách hàng</th>
                  <th>Địa chỉ</th>
                  <th>Số điện thoại</th>
                  <th>Action</th>
                </tr>
                </tfoot>
              </table>
            </div>
    
            <!-- /.box-body -->
          </div>
          <!-- ================================================================================================= -->
        <div class="modal  fade" id="addemployee">
          <div class="modal-dialog" >
            <div class="modal-content">
              <div class="modal-header with-border">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Thêm Khách Hàng</h4>
              </div>
              
                <form class="form-horizontal" action="actionkhachhang?action=add" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên khách hàng</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText1" placeholder="Tên khách hàng" name="Tennv">
                  </div>
                </div>
                  
                <div class="form-group">
                  <label for="inputText4" class="col-sm-2 control-label">Số điện thoại</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText4" placeholder="Số điện thoại" name="Password">
                  </div>
                </div>
                
                
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Địa chỉ</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText5" placeholder="Địa chỉ" name="Diachi">
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
   
    <div class="modal  fade" id="modal-editemployee">
          <div class="modal-dialog" >
            <div class="modal-content">
              <div class="modal-header with-border">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Sửa khách hàng</h4>
              </div>
              
                <form class="form-horizontal" action="actionkhachhang?action=edit" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên khách hàng</label>
                  <div class="col-sm-10">
                  	<input type="hidden"  id="inputText131"  name="ID">
                    <input type="text" class="form-control" id="inputText11" placeholder="Tên khách hàng" name="Tennv">
                  </div>
                </div>
                 
                <div class="form-group">
                  <label for="inputText4" class="col-sm-2 control-label">Số điện thoại</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText13" placeholder="Số điện thoại" name="Password">
                  </div>
                </div>
                
                
                
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Địa chỉ</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText15" placeholder="Địa chỉ" name="Diachi">
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
        
        
   		
    </section>
    <!-- =============================================================================== -->
  
  <script type="text/javascript">
    function edit(ma,ten,dc,sdt) {

    	
        
        document.getElementById("inputText131").value = ma;
        document.getElementById("inputText11").value = ten;
        
        document.getElementById("inputText13").value = sdt;
        document.getElementById("inputText15").value = dc;
       
        
       
        
    };
    
</script>

  <!-- ===============================================================================  -->
</div>
<%@include file="frame/footer.jsp" %>
