<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<title>Thêm Sản Phẩm</title>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>
<%@page import="model.*"%>
<%@page import="DAO.*"%>
<%@page import="java.util.*"%>
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>Thêm hàng hoá mới</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
			<li class="active">Thêm hàng hóa</li>
		</ol>
	</section>
	    <section class="content">
    	<!-- đây là nội dung -->
    	<span style="color:red" id="msg"></span>
    	<form class="form-horizontal" action="addnewsp" method="post">
    	<div class="col-md-6">
    		<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Điền thông tin </h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body">
                
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Tên hàng <span style="color:red"><i>*</i></span></label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText1" placeholder="Tên hàng hóa" name="tenhang" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Số lượng <span style="color:red"><i>*</i></span></label>
                  <div class="col-sm-10">
                    
                   <input type="text" class="form-control" id="inputText3" placeholder="Số lượng" name="sl" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText3" class="col-sm-2 control-label">Đơn giá mua<span style="color:red"><i>*</i></span></label>
                  <div class="col-sm-10">
                    
                    <input type="text" class="form-control" id="inputText4" placeholder="Đơn giá mua" name="dgm" required>
                  </div>
                </div>
                
              </div>
          </div>
        </div>
        <div class="col-md-6">
        	<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Điền thông tin</h3>
            </div>
              <div class="box-body">
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Đơn giá bán <span style="color:red"><i>*</i></span></label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputText5" placeholder="Đơn giá bán" name="dgb" required>
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputText6" class="col-sm-2 control-label">Mã loại <span style="color:red"><i>*</i></span></label>
                  <div class="col-sm-10">
                    
                    <select class="form-control" id="inputText6" name="maloai" required>
                    <%
                    	List<LoaiSp> lst = new LoaiSpDAO().getAllLoaiSp();
                    	for(LoaiSp lsp : lst)
                    	{

                    %>
						<option value="<%=lsp.getMaDm()%>"><%=lsp.getTenLoai() %></option>
						
					<%} %>
					</select>
                  </div>
                </div>
                <br>
                
                
                <div class="box-footer">
                <button type="reset" class="btn btn-default">Hủy</button>
                <button type="submit" class="btn btn-info pull-right" >Lưu</button>
              </div>
              </div>
          </div>
        </div>
       </form>
    </section>
</div>
<%@include file="frame/footer.jsp"%>