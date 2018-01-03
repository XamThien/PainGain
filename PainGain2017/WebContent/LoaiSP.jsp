<%-- 
    Document   : loai san pham
    Created on : Jun 11, 2017, 2:27:50 PM
    Author     : dangt
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="DAO.*" %>
<title>Quản Lý loại Sản phẩm</title>
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
            Loại sản phẩm
            <small>Quản lí</small>
        </h1>
        <span style="color:red"><i>${msg}</i></span>
        <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
            <li class="active">Loại sản phẩm</li>
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
                  <th>Loại sản phẩm</th>
                  <th>Mã danh mục</th>
                  
                  
                  <th><button class="btn btn-link" id="btnaddemployee" data-toggle="modal" data-target="#addemployee"><span class="fa fa-plus">Thêm mới</span></button></th>
                </tr>
                </thead>
                <tbody>
                <%
                List<LoaiSp> lst =  new  LoaiSpDAO().getAllLoaiSp();
                	if (lst != null) 
                	{
                		for (LoaiSp nvx : lst)
                		{
                			
                %>
                <tr>
                    <td><a href="#" title="click vào để xem chi tiết"><%=nvx.getMaLoai() %></a></td>
                    <td><%=nvx.getTenLoai() %></td>
                   	<td><%=nvx.getMaDm() %></td>
                   
                    <td>
                      <button class="btn btn-link" data-toggle="modal" data-target="#modal-editemployee" onclick = "edit(<%=nvx.getMaLoai() %>,'<%=nvx.getTenLoai() %>',<%=nvx.getMaDm() %>);"><span class="fa fa-edit">Sửa</span></button>
                      <span class="fa" style="margin: 0px 5px;"></span>
                      <a onclick="return confirmAction()" href="${pageContext.request.contextPath}/actionloaisp?MaLSP=<%=nvx.getMaLoai() %>"><span class="fa fa-remove">Xóa</span></a>
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
                  <th>Loại sản phẩm</th>
                  <th>Mã danh mục</th>
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
                <h4 class="modal-title">Thêm loại sản phẩm</h4>
              </div>
              
                <form class="form-horizontal" action="actionloaisp?action=add" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên loại sản phẩm</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText1" placeholder="Tên loại sản phẩm" name="Tenlsp" required>
                  </div>
                </div>
               <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Danh mục</label>
                  <div class="col-sm-10">
                    
					<select class="form-control" id="inputText2"  name="MaDM" >
					<%
                    List<DanhMuc> lstt =  new  DanhMucDAO().getAllDanhMuc();
                	if (lstt != null) 
                	{
                		for (DanhMuc dm : lstt)
                		{
                    %>
						<option value="<%=dm.getMaDm() %>"><%=dm.getTenDm() %> </option>
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
   
    <div class="modal  fade" id="modal-editemployee">
          <div class="modal-dialog" >
            <div class="modal-content">
              <div class="modal-header with-border">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Sửa loại sản phẩm</h4>
              </div>
              
                <form class="form-horizontal" action="actionloaisp?action=edit" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Loại sản phẩm</label>
                  <div class="col-sm-10">
                  	<input type="hidden"  id="inputText131"  name="ID">
                    <input type="text" class="form-control" id="inputText11" placeholder="Tên loại sản phẩm" name="Tenlsp">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Danh mục</label>
                  <div class="col-sm-10">
                    
					<select class="form-control" id="inputText21"  name="MaDM" >
					<%
                    
                	if (lstt != null) 
                	{
                		for (DanhMuc dm : lstt)
                		{
                    %>
						<option value="<%=dm.getMaDm() %>"> <%=dm.getTenDm() %> </option>
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
        
        
   		
    </section>
    <!-- =============================================================================== -->
  
  <script type="text/javascript">
    function edit(maloai,ten,madanhmuc) {

        document.getElementById("inputText131").value = maloai;
        document.getElementById("inputText11").value = ten;
        document.getElementById("inputText21").value = madanhmuc;
    };
    
</script>

  <!-- ===============================================================================  -->
</div>
<%@include file="frame/footer.jsp" %>
