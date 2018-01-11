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
            Nhân viên
            <small>Quản lí</small>
        </h1>
        <span style="color:red"><i>${msg}</i></span>
        <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
            <li class="active">Nhân viên</li>
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
                  <th>Tên nhân viên</th>
                  <th>Địa chỉ</th>
                  <th>Ngày vào làm</th>
                  <th>Tên đăng nhập</th>
                  <th>Mật khẩu</th>
                  
                  <th><button class="btn btn-link" id="btnaddemployee" data-toggle="modal" data-target="#addemployee"><span class="fa fa-plus">Thêm mới</span></button></th>
                </tr>
                </thead>
                <tbody>
                <%
                List<NhanVien> list =  new  NhanVienDAO().getAllNhanVien();
                	if (list != null) 
                	{
                		for (NhanVien nvx : list)
                		{
                			Account ac = new AccountDAO().getAccountByID(nvx.getMaNv());
                			if(ac.getTrangThai()==0)
                			{
                				continue;
                			}
                %>
                <tr>
                	<td><%=nvx.getMaNv() %></td>
                    <td><a href="#" title="click vào để xem chi tiết"><%=nvx.getTenNv() %></a></td>
                    
                    <td><%=nvx.getDiaChi() %></td>
                    <td><%=nvx.getNgayVaoLam() %></td>
                    <td><%=ac.getUserName() %></td>
                    <td><%=ac.getPass() %></td>
                    
                    <td>
                      <button class="btn btn-link" data-toggle="modal" data-target="#modal-editemployee" onclick = "edit('<%=nvx.getMaNv() %>','<%=nvx.getTenNv() %>','<%=nvx.getDiaChi() %>','<%=ac.getUserName() %>','<%=ac.getPass() %>',<%=ac.getTrangThai()%>);"><span class="fa fa-edit">Sửa</span></button>
                      <span class="fa" style="margin: 0px 5px;"></span>
                      <a onclick="return confirmAction()" href="${pageContext.request.contextPath}/actionnhanvien?MaNV=<%=nvx.getMaNv() %>"><span class="fa fa-remove">Xóa</span></a>
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
                  <th>Tên nhân viên</th>
                  <th>Địa chỉ</th>
                  <th>Ngày vào làm</th>
                  <th>Tên đăng nhập</th>
                  <th>Mật khẩu</th>
                  
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
                <h4 class="modal-title">Thêm nhân viên</h4>
              </div>
              
                <form class="form-horizontal" action="actionnhanvien?action=add" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên nhân viên</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText1" placeholder="Tên nhân viên" name="Tennv">
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Username</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText2" placeholder="username" name="Username">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText4" class="col-sm-2 control-label">Password</label>
                  <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputText4" placeholder="Mật khẩu" name="Password">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText3" class="col-sm-2 control-label">Giới tính</label>
                  <div class="col-sm-10">
                  	<select class="form-control" id="inputText3"  name="Sex" >
						<option value="1">Nam</option>
						<option value="0">Nữ</option>
					</select>
                    
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Địa chỉ</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText5" placeholder="Địa chỉ" name="Diachi">
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputText6" class="col-sm-2 control-label">Ngày vào làm</label>
                  <div class="col-sm-10">
                    <input type="date" class="form-control" id="inputText6"  name="Date">
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
                <h4 class="modal-title">Sửa nhân viên</h4>
              </div>
              
                <form class="form-horizontal" action="actionnhanvien?action=edit" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên nhân viên</label>
                  <div class="col-sm-10">
                  	<input type="hidden"  id="inputText131"  name="ID">
                    <input type="text" class="form-control" id="inputText11" placeholder="Tên nhân viên" name="Tennv">
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Username</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText12" placeholder="username" name="Username">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText4" class="col-sm-2 control-label">Password</label>
                  <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputText13" placeholder="Mật khẩu" name="Password">
                  </div>
                </div>
                
                
                
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Địa chỉ</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText15" placeholder="Địa chỉ" name="Diachi">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText3" class="col-sm-2 control-label">Trạng thái hoạt động</label>
                  <div class="col-sm-10">
                  	<select class="form-control" id="inputTextxx"  name="trangthai" >
						<option value="0">Nghỉ</option>
						<option value="1">Còn làm việc</option>
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
        
        
   		
    </section>
    <!-- =============================================================================== -->
  
  <script type="text/javascript">
    function edit(ma,ten,diachi,username,pass,tt) {

    	
        
        document.getElementById("inputText131").value = ma;
        document.getElementById("inputText11").value = ten;
        document.getElementById("inputText12").value = username;
        document.getElementById("inputText13").value = pass;
        document.getElementById("inputText15").value = diachi;
        
        for(var i=0; i < document.getElementById("inputTextxx").options.length; i++)
        {
          if(document.getElementById("inputTextxx").options[i].value === tt) {
        	  document.getElementById("inputTextxx").selectedIndex = i;
            break;
          }
        }
        
        
    };
    
</script>

  <!-- ===============================================================================  -->
</div>
<%@include file="frame/footer.jsp" %>
