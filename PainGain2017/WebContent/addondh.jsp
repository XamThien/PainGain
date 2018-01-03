<%-- 
    Document   : adddondh
    Created on : Jun 21, 2017, 11:00:30 PM
    Author     : Asus
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.*" %>
<%@ page import="model.*" %>
<%@ page import="DAO.*" %>
<%
	Date dNow = new Date( );
	SimpleDateFormat ftt = new SimpleDateFormat ("yyyy-MM-dd");
	String date =  ftt.format(dNow);
	HttpSession sessionx = request.getSession();
	DonHang donhang = new DonHang( date);
	sessionx.setAttribute("donhang", donhang);
%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Quản lí hàng hóa <small>Lập đơn đặt hàng</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
            <li><a href="dsdondathang.jsp">Danh sách đơn đặt hàng</a></li>
            <li class="active">Lập đơn đặt hàng</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-md-8" style="width: 70%">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <div class="input-group input-group-sm">
                            <input type="text" name="txtsearchproc" class="form-control" placeholder="Tìm kiếm sản phẩm" id="txtsearch1" onkeyup ="dhsearchProduct(this.value);">
                            <span class="input-group-btn">
                                <button  type="button" class="btn btn-info btn-flat" id="btnaddpro" data-toggle="modal" data-target="#addnewsp">Thêm</button>
                            </span>
                        </div>
                    </div>
                    <div class="box-body suggest" id="sugges1">
                        <ul class="list-suggest" id="result1"></ul>
                    </div>
                    <div class="box-body table-responsive no-padding">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Mã hàng</th>
                                    <th>Tên hàng</th>
                                    <th width="125px">Đơn giá nhập</th>
                                    <th width="88px">Số lượng</th>
                                    <th>Thành tiền</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody id="hoadondetail" style="text-align: center;"></tbody>
                        </table>
                    </div>               
                </div>

            </div>
            <div class="col-md-4" style="width:30%; float:right">
                <div class="box" style="border-top: none;">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#activity" data-toggle="tab">Đơn hàng</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="active tab-pane" id="activity">
                                <!-- Don hang -->
                                <div class="box-body">
                                    
                                    <strong>Nhân viên lập: </strong>
                                    <p class="text-muted"><%=nvv.getTenNv() %></p>
                                    <strong>Ngày lập:</strong>
                                    <%
                                    
                                    %>
                                    <p class="text-muted"><%=date %></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div  class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">Thanh toán</h3>
                        </div>
                        <div class="box-body">
                            <strong>Tổng giá trị</strong>
                            <p class="text-muted" id="paytotal">0</p>
                            <button class="btn btn-info" type="button" onclick="saveDonDatHang();">Lưu Đơn đặt hàng</button>
                        </div>
                    </div>
                </div>
            </div>      
        </div>
        <div class="modal  fade" id="addnewsp">
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
        
    </section>
</div>
<%@include file="frame/footer.jsp"%>