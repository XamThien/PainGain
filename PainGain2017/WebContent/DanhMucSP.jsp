<%-- 
    Document   : danh muc san pham
    Created on : Jun 11, 2017, 2:27:50 PM
    Author     : dangt
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="DAO.*" %>
<title>Quản Lý Danh Mục Sản Phẩm</title>
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
            Danh mục sản phẩm
            <small>Quản lí</small>
        </h1>
        <span style="color:red"><i>${msg}</i></span>
        <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
            <li class="active">Danh mục sản phẩm</li>
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
                  <th>Tên danh mục</th>
                  
                  
                  <th><button class="btn btn-link" id="btnaddemployee" data-toggle="modal" data-target="#addemployee"><span class="fa fa-plus">Thêm mới</span></button></th>
                </tr>
                </thead>
                <tbody>
                <%
                List<DanhMuc> lst =  new  DanhMucDAO().getAllDanhMuc();
                	if (lst != null) 
                	{
                		for (DanhMuc nvx : lst)
                		{
                			
                %>
                <tr>
                    <td><a href="#" title="click vào để xem chi tiết"><%=nvx.getMaDm() %></a></td>
                    <td><%=nvx.getTenDm() %></td>
                   
                   
                    <td>
                      <button class="btn btn-link" data-toggle="modal" data-target="#modal-editemployee" onclick = "edit(<%=nvx.getMaDm() %>,'<%=nvx.getTenDm() %>');"><span class="fa fa-edit">Sửa</span></button>
                      <span class="fa" style="margin: 0px 5px;"></span>
                      <a onclick="return confirmAction()" href="${pageContext.request.contextPath}/actiondanhmuc?MaDM=<%=nvx.getMaDm() %>"><span class="fa fa-remove">Xóa</span></a>
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
                <h4 class="modal-title">Thêm danh mục sản phẩm</h4>
              </div>
              
                <form class="form-horizontal" action="actiondanhmuc?action=add" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên danh mục</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText1" placeholder="Tên danh mục" name="Tendm">
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
                <h4 class="modal-title">Sửa danh mục</h4>
              </div>
              
                <form class="form-horizontal" action="actiondanhmuc?action=edit" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên danh mục</label>
                  <div class="col-sm-10">
                  	<input type="hidden"  id="inputText131"  name="ID">
                    <input type="text" class="form-control" id="inputText11" placeholder="Tên danh mục" name="Tendm">
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
    function edit(ma,ten) {

        document.getElementById("inputText131").value = ma;
        document.getElementById("inputText11").value = ten;
        
    };
    
</script>

  <!-- ===============================================================================  -->
</div>
<%@include file="frame/footer.jsp" %>
