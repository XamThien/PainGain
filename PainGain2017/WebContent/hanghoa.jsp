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
<title>Quản Lý Hàng Hoá</title>
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
           Quản lý hàng hoá
            
        </h1>
        <span style="color:red"><i>${msg}</i></span>
        <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
            <li class="active">Hàng hoá</li>
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
                  <th>Tên hàng hoá</th>
                  <th>Số lượng</th>
                  <th>Đơn giá mua</th>
                  <th>Đơn giá bán</th>
                  <th>Loại sản phẩm</th>
                  <th><button class="btn btn-link" id="btnaddemployee" data-toggle="modal" data-target="#addemployee"><span class="fa fa-plus">Thêm mới</span></button></th>
                </tr>
                </thead>
                <tbody>
                <%
                List<SanPham> list =  new  SanPhamDAO().getAllSanPham();
                	if (list != null) 
                	{
                		for (SanPham sp : list)
                		{
                			LoaiSp lsp = new LoaiSpDAO().getLoaiSp(sp.getMaLoai());
                			
                %>
                <tr>
                    <td><%=sp.getMaSp() %></td>
                    <td><%=sp.getTenSp() %></td>
                    <td><%=sp.getSoLuong() %></td>
                    <td><%=sp.getDonGiaMua() %></td>
                    <td><%=sp.getDonGiaBan()%></td>
                    <td><%=lsp.getTenLoai() %></td>
                    <td>
                      <button class="btn btn-link" data-toggle="modal" data-target="#modal-editemployee" onclick = "edit(<%=sp.getMaSp() %>,'<%=sp.getTenSp() %>',<%=sp.getSoLuong() %>,<%=sp.getDonGiaBan() %>,<%=sp.getDonGiaMua() %>,<%=sp.getMaLoai() %>);"><span class="fa fa-edit">Sửa</span></button>
                      <span class="fa" style="margin: 0px 5px;"></span>
                      <a onclick="return confirmAction()" href="${pageContext.request.contextPath}/actionhanghoa?Ma=<%=sp.getMaSp() %>"><span class="fa fa-remove">Xóa</span></a>
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
                  <th>Tên hàng hoá</th>
                  <th>Số lượng</th>
                  <th>Đơn giá mua</th>
                  <th>Đơn giá bán</th>
                  <th>Loại sản phẩm</th>
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
                <h4 class="modal-title">Thêm sản phẩm </h4>
              </div>
              
                <form class="form-horizontal" action="actionhanghoa?action=add" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên hàng hoá</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText1" placeholder="Tên hàng hóa" name="tenhang" required>
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Số lượng</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText3" placeholder="Số lượng" name="sl" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText4" class="col-sm-2 control-label">Đơn giá mua</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText4" placeholder="Đơn giá mua" name="dgm" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText3" class="col-sm-2 control-label">Đơn giá bán</label>
                  <div class="col-sm-10">
                  	<input type="text" class="form-control" id="inputText5" placeholder="Đơn giá bán" name="dgb" required>
                    
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Loại hàng hoá</label>
                  <div class="col-sm-10">
                    <select class="form-control" id="inputText6" name="maloai" required>
                    <%
                    	List<LoaiSp> lst = new LoaiSpDAO().getAllLoaiSp();
                    	for(LoaiSp lsxp : lst)
                    	{

                    %>
						<option value="<%=lsxp.getMaDm()%>"><%=lsxp.getTenLoai() %></option>
						
					<%} %>
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
                <h4 class="modal-title">Chỉnh sửa thông tin sản phẩm</h4>
              </div>
              
                <form class="form-horizontal" action="actionhanghoa?action=edit" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên sản phẩm</label>
                  <div class="col-sm-10">
                  	<input type="hidden"  id="inputText131"  name="ID">
                    <input type="text" class="form-control" id="inputText11" placeholder="Tên sản phẩm" name="tenhang">
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Số lượng</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText12" placeholder="Số lượng" name="sl">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText4" class="col-sm-2 control-label">Đơn giá mua</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText13" placeholder="Đơn giá mua" name="dgm">
                  </div>
                </div>
                
                
                
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Đơn giá bán</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText15" placeholder="Đơn giá bán" name="dgb">
                  </div>
                </div>
                
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Loại hàng hoá</label>
                  <div class="col-sm-10">
                    <select class="form-control" id="inputText16" name="maloai" required>
                    <%
                    	
                    	for(LoaiSp lstp : lst)
                    	{

                    %>
						<option value="<%=lstp.getMaDm()%>"><%=lstp.getTenLoai() %></option>
						
					<%} %>
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
        
        
   		<% int a=1;
   		out.println(a);%>
    </section>
    <!-- =============================================================================== -->
  
  <script type="text/javascript">
    function edit(ma,ten,soluong,giaban,giamua,maloai) {

    	
        
        document.getElementById("inputText131").value = ma;
        document.getElementById("inputText11").value = ten;
        document.getElementById("inputText12").value = soluong;
        document.getElementById("inputText13").value = giamua;
        document.getElementById("inputText15").value = giaban;
        document.getElementById("inputText16").value = maloai;
        
        
    };
    
</script>

  <!-- ===============================================================================  -->
</div>
<%@include file="frame/footer.jsp" %>
